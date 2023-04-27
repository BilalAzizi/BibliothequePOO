package bibliotheque.mvp.presenter;

import bibliotheque.metier.Location;
import bibliotheque.mvp.model.DAO;
import bibliotheque.mvp.view.ViewInterface;

public class LocationPresenter extends Presenter<Location> {


    public LocationPresenter(DAO<Location> model, ViewInterface<Location> view) {
        super(model,view);
    }


}
