package bibliotheque.metier;

public class Mail {
    private String objet;
    private String message;
    private String dateEnvoi;

    private String destinataire;


    public Mail(String objet, String message, String dateEnvoi, String destiniataire) {
        this.objet = objet;
        this.message = message;
        this.dateEnvoi = dateEnvoi;
        this.destinataire = destinataire;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "objet='" + objet + '\'' +
                ", message='" + message + '\'' +
                ", dateEnvoi='" + dateEnvoi + '\'' +
                '}';
    }


}
