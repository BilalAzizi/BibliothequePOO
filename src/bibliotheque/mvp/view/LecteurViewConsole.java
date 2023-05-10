package bibliotheque.mvp.view;


import bibliotheque.metier.Lecteur;
import bibliotheque.mvp.presenter.SpecialLecteurPresenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static bibliotheque.utilitaires.Utilitaire.*;


public class LecteurViewConsole extends AbstractViewConsole<Lecteur> implements SpecialLecteurViewConsole {


  protected  void rechercher() {
      try{
        System.out.println("numLecteur : ");
        int idLecteur = lireInt();
        Lecteur rech = null;
        rech = new Lecteur(idLecteur,"N","P",null,null,null,null);
        presenter.search(rech);
      } catch (Exception e) {
          System.out.println("erreur "+e);
      }
    }

   protected  void modifier() {
        int choix = choixElt(ldatas);
        Lecteur l = ldatas.get(choix-1);
         do {
            try {
            String nom = modifyIfNotBlank("nom", l.getNom());
            String prenom = modifyIfNotBlank("prénom", l.getPrenom());
            String date = modifyIfNotBlank("date de naissance", getDateFrench(l.getDn()));
            String[] jma = date.split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int a = Integer.parseInt(jma[2]);
            LocalDate dn = LocalDate.of(a, m, j);
            String adr = modifyIfNotBlank("adresse", l.getAdresse());
            String mail = modifyIfNotBlank("mail", l.getMail());
            String tel = modifyIfNotBlank("tel", l.getTel());
            l.setNom(nom);
            l.setPrenom(prenom);
            l.setDn(dn);
            l.setAdresse(adr);
            l.setMail(mail);
            l.setTel(tel);
            break;
            } catch (Exception e) {
                System.out.println("erreur :" + e);
            }
        }while(true);
       presenter.update(l);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);
    }

    protected  void retirer() {
        int choix = choixElt(ldatas);
        Lecteur lecteur = ldatas.get(choix-1);
        presenter.remove(lecteur);
        ldatas=presenter.getAll();//rafraichissement
        affListe(ldatas);
    }


    protected  void ajouter() {
      do {
          System.out.println("nom ");
          String nom = sc.nextLine();
          System.out.println("prénom ");
          String prenom = sc.nextLine();
          System.out.println("date de naissance");
          String[] jma = sc.nextLine().split(" ");
          int j = Integer.parseInt(jma[0]);
          int m = Integer.parseInt(jma[1]);
          int a = Integer.parseInt(jma[2]);
          LocalDate dn = LocalDate.of(a, m, j);
          System.out.println("adresse");
          String adr = sc.nextLine();
          System.out.println("mail");
          String mail = sc.nextLine();
          System.out.println("tel ");
          String tel = sc.nextLine();
          Lecteur lec = null;
          try {
              lec = new Lecteur(0, nom, prenom, dn, adr, mail, tel);
              presenter.add(lec);
              break;
          } catch (Exception e) {
              System.out.println("erreur : " + e);
          }
      }
        while(true);
          ldatas=presenter.getAll();//rafraichissement
          affListe(ldatas);
    }
    protected  void special() {
        int choix =  choixElt(ldatas);
        Lecteur lec = ldatas.get(choix-1);

        List options = new ArrayList<>(Arrays.asList("Exemplaire en location","Exemplaires loués","recherche par mail","fin"));
        do {
            int ch = choixListe(options);
                 switch (ch) {
                    case 1:
                        exemplairesLocation(lec);
                        break;
                    case 2:
                        exemplairesLoues(lec);
                        break;
                     case 3:
                         lecParMail();
                         break;
                    case 4: return;
                    default:
                        System.out.println("choix invalide recommencez ");
                }
            } while (true);


        }

    @Override
    public void exemplairesLoues(Lecteur lec) {
        ((SpecialLecteurPresenter)presenter).exemplairesLoues(lec);
    }

    @Override
    public void exemplairesLocation(Lecteur lec) {
        ((SpecialLecteurPresenter)presenter).exemplairesEnLocation(lec);
    }

    @Override
    public void lecParMail() {
      //ajout pour forcer push
        System.out.print("mail recherché : ");
        String mail= sc.next();
        ((SpecialLecteurPresenter)presenter).lecParMail(mail);
    }

    protected void ajouterNouveauxLecteurs() {
        try (Scanner scanner = new Scanner(new File("nouveaux_lecteurs.txt"))) {
            while (scanner.hasNextLine()) {
                String[] ligne = scanner.nextLine().split(";");
                String nom = ligne[0];
                String prenom = ligne[1];
                LocalDate dn = LocalDate.parse(ligne[2]);
                String adresse = ligne[3];
                String mail = ligne[4];
                String tel = ligne[5];
                Lecteur lecteur = new Lecteur(0, nom, prenom, dn, adresse, mail, tel);
                presenter.add(lecteur);
            }
            ldatas = presenter.getAll();
            System.out.println("Les nouveaux lecteurs ont été ajoutés avec succès.");
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier 'nouveaux_lecteurs.txt' est introuvable.");
        } catch (Exception e) {
            System.out.println("Une erreur est survenue lors de l'ajout des nouveaux lecteurs : " + e.getMessage());
        }
    }

}


