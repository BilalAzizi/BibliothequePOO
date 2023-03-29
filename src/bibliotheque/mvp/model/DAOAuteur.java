package bibliotheque.mvp.model;

import bibliotheque.metier.Auteur;

import java.util.List;

public interface DAOAuteur {
    Auteur addAuteur(Auteur aut);

    boolean removeAuteur(Auteur aut);

    List<Auteur> getAuteurs();

    Auteur updateAuteur(Auteur aut);
}
