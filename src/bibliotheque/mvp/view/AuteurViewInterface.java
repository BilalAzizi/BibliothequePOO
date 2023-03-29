package bibliotheque.mvp.view;

import bibliotheque.metier.Auteur;
import bibliotheque.mvp.presenter.AuteurPresenter;

import java.util.List;

public interface AuteurViewInterface {
    public void setPresenter(AuteurPresenter presenter);

    public void setListDatas(List<Auteur> auteurs);

    public void affMsg(String msg);
}
