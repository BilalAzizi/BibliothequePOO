package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.mvp.presenter.AuteurPresenter;
import bibliotheque.utilitaires.Utilitaire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AuteurViewConsole implements AuteurViewInterface{
    private AuteurPresenter presenter;
    private List<Auteur> lauteur;
    private Scanner sc = new Scanner(System.in);

    public AuteurViewConsole() {
    }

    @Override
    public void setPresenter(AuteurPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setListDatas(List<Auteur> auteurs) {
        this.lauteur = auteurs;
        Utilitaire.affListe((lauteur));
        menu();
    }

    @Override
    public void affMsg(String msg) {
        System.out.println("information: "+msg);
    }

    public void menu() {
        List options = new ArrayList<>(Arrays.asList("ajouter", "retirer", "modifier", "fin"));
        do {
            int ch = Utilitaire.choixListe(options);

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    modifier();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }

    private void modifier() {
        //TODO choisir elt et demander les nouvelles valeurs puis appeler méthode maj(lecteur) (à développer) du presenter
        int choix = Utilitaire.choixElt(lauteur);
        Auteur auteur = lauteur.get(choix-1);
        presenter.maj(auteur);
    }

    private void retirer() {
        int choix = Utilitaire.choixElt(lauteur);
        Auteur auteur = lauteur.get(choix-1);
        presenter.removeAuteur(auteur);
    }


    private void ajouter() {
        System.out.println("nom ");
        String nom = sc.nextLine();
        System.out.println("prénom ");
        String prenom = sc.nextLine();
        System.out.println("nationalité ");
        String nationalite = sc.nextLine();
        Auteur aut = new Auteur (nom, prenom, nationalite);
        presenter.addAuteur(aut);
    }
}
