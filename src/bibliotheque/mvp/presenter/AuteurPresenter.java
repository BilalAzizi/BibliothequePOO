package bibliotheque.mvp.presenter;

import bibliotheque.metier.Auteur;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.view.ViewInterface;

public class AuteurPresenter extends Presenter<Auteur> {


    public AuteurPresenter(DAO<Auteur> model, ViewInterface<Auteur> view) {
        super(model, view);
    }
}
