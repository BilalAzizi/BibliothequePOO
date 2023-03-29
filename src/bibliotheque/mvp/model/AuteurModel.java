package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;

import java.util.ArrayList;
import java.util.List;

public class AuteurModel implements DAOAuteur {
    private List<Auteur> auteurs = new ArrayList<>();

    @Override
    public Auteur addAuteur(Auteur aut) {
        if (!auteurs.contains(aut)){
            auteurs.add(aut);
            return aut;
        }
        return null;
    }

    @Override
    public boolean removeAuteur(Auteur aut) {
        return auteurs.remove(aut);
        //return false;
    }

    @Override
    public List<Auteur> getAuteurs() {
        return new ArrayList<>(auteurs);
        //return null;
    }

    @Override
    public Auteur updateAuteur(Auteur aut) {
        for (int i = 0; i < auteurs.size(); i++){
            Auteur a = auteurs.get(i);
            if(a.equals(aut)){
                auteurs.set(i, aut);
                return aut;
            }
        }
        return null;
    }
}
