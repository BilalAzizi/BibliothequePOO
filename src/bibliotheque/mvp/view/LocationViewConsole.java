package bibliotheque.mvp.view;

import bibliotheque.metier.Exemplaire;
import bibliotheque.metier.Lecteur;
import bibliotheque.metier.Location;
import bibliotheque.mvp.presenter.LocationPresenter;
import bibliotheque.mvp.presenter.SpecialLocationPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bibliotheque.utilitaires.Utilitaire.*;

public class LocationViewConsole extends AbstractViewConsole<Location> implements SpecialLocationViewConsole {
    @Override
    protected void rechercher() {
        String recherche = saisie("Recherche : ");
        try {
            List<Location> resultatRecherche = presenter.rechercher(recherche);
            if (resultatRecherche.isEmpty()) {
                affMsg("Aucun résultat trouvé.");
            } else {
                affListe(resultatRecherche);
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la recherche : " + e.getMessage());
        }
    }

    @Override
    protected void modifier() {
        int choix = choixElt(ldatas);
        Location l = ldatas.get(choix-1);
        do {
            try {
                l.enregistrerRetour();
                break;
            } catch (Exception e) {
                System.out.println("Erreur lors de l'enregistrement du retour : " + e.getMessage());
            }
        } while (true);
        presenter.update(l);
        ldatas = presenter.getAll(); // Rafraîchissement
        affListe(ldatas);
    }

    @Override
    protected void ajouter() {
        try {
            Lecteur l = ((LocationPresenter) presenter).choixLecteur();
            Exemplaire ex = ((LocationPresenter) presenter).choixExemplaire();
            if (ex.enLocation()) {
                affMsg("Exemplaire en location");
                return;
            }
            Location loc = new Location(l, ex);
            presenter.add(loc);
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de la location : " + e.getMessage());
        }
    }

    @Override
    protected void special() {
        int choix = choixElt(ldatas);
        Location l = ldatas.get(choix - 1);

        List<String> options = new ArrayList<>(Arrays.asList("calculer amende", "enregistrer retour", "fin"));
        do {
            int ch = choixListe(options);

            switch (ch) {

                case 1:
                    try {
                        amende(l);
                    } catch (Exception e) {
                        System.out.println("Erreur lors du calcul de l'amende : " + e.getMessage());
                    }
                    break;
                case 2:
                    retour(l);
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    @Override
    public void retour(Location l) {
        try {
            if (l.getExemplaire().enLocation()) {
                ((SpecialLocationPresenter) presenter).enregistrerRetour(l);
            } else {
                affMsg("Exemplaire pas en location");
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de l'enregistrement du retour : " + e.getMessage());
        }
    }

    @Override
    public void amende(Location l) {
        ((SpecialLocationPresenter) presenter).calculerAmende(l);
    }
}
