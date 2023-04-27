package bibliotheque.mvp.presenter;

import bibliotheque.metier.Exemplaire;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.view.ViewInterface;

public class ExemplairePresenter extends Presenter<Exemplaire> {


    public ExemplairePresenter(DAO<Exemplaire> model, ViewInterface<Exemplaire> view) {
        super(model,view);
    }


}
