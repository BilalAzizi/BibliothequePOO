package bibliotheque.mvp.presenter;

import bibliotheque.metier.Ouvrage;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.view.ViewInterface;

public class OuvragePresenter extends Presenter<Ouvrage> {


    public OuvragePresenter(DAO<Ouvrage> model, ViewInterface<Ouvrage> view) {
        super(model,view);
    }

}
