package bibliotheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestion {


    private static List<Auteur> laut = new ArrayList<>();
    private static List<Lecteur> llect = new ArrayList<>();
    private static List<Ouvrage> louv= new ArrayList<>();
    private static List<Exemplaire> lex = new ArrayList<>();
    private static List<Rayon> lrayon= new ArrayList<>();
    private static List<Location> elloc = new ArrayList<>();
    private static List<Auteur> auteurs = new ArrayList<>();

    public static void populate(){
        Auteur a = new Auteur("Verne","Jules","France");
        laut.add(a);

        Livre l = new Livre("Vingt mille lieues sous les mers",10, LocalDate.of(1880,1,1),1.50,"français","aventure","a125",350,TypeLivre.ROMAN,"histoire de sous-marin");
        louv.add(l);

        //a.getLouvrage().add(l);
        //l.getLauteurs().add(a);
        a.ajoutOuvrage(l);

        a = new Auteur("Spielberg","Steven","USA");
        laut.add(a);

        DVD d = new DVD("AI",12,LocalDate.of(2000,10,1),2.50,"anglais","SF",4578l,"120 min",(byte)2);
        d.getAutresLangues().add("français");
        d.getAutresLangues().add("italien");
        d.getSousTitres().add("néerlandais");
        louv.add(d);

        //a.getLouvrage().add(d);
        //d.getLauteurs().add(a);
        a.ajoutOuvrage(d);


        a = new Auteur("Kubrick","Stanley","GB");
        laut.add(a);

        //a.getLouvrage().add(d);
        //d.getLauteurs().add(a);
        a.ajoutOuvrage(d);


        CD c = new CD("The Compil 2023",0,LocalDate.of(2023,1,1),2,"English","POP",1245,(byte)20,"100 min");
        louv.add(c);

        Rayon r = new Rayon("r12","aventure");
        lrayon.add(r);

        Exemplaire e = new Exemplaire("m12","état neuf",l);
        lex.add(e);

        //e.setRayon(r);
        //r.getLex().add(e);
        r.ajoutExemplaire(e);

        r = new Rayon("r45","science fiction");
        lrayon.add(r);

        e = new Exemplaire("d12","griffé",d);
        lex.add(e);

        //e.setRayon(r);
        //r.getLex().add(e);
        r.ajoutExemplaire(e);


        Lecteur lec = new Lecteur(1,"Dupont","Jean",LocalDate.of(2000,1,4),"Mons","jean.dupont@mail.com","0458774411");
        llect.add(lec);

        Location loc = new Location(LocalDate.of(2023,2,1),LocalDate.of(2023,3,1),lec,e);
        //lec.getLloc().add(loc);
        //e.getLloc().add(loc);
        lec.ajoutLocation(loc);
        lloc.add(loc);

        lec = new Lecteur(1,"Durant","Aline",LocalDate.of(1980,10,10),"Binche","aline.durant@mail.com","045874444");
        llect.add(lec);

        loc = new Location(LocalDate.of(2023,2,5),LocalDate.of(2023,3,5),lec,e);
        lec.getLloc().add(loc);
        e.getLloc().add(loc);
        lloc.add(loc);
    }
    public static void main(String[] args) {

        populate();
        Scanner sc = new Scanner(System.in);
        int choix;

        do{
            System.out.println("1. Auteurs\n 2. Ouvrage");
            choix=sc.nextInt();
            switch (choix){
                case 1: gestAuteurs();
                        break;
                case 2: gestOuvrage();
                        break;
            }
        }while(choix != 8);
    }

    private static void gestOuvrage(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ajout d'un nouvel ouvrage");
        System.out.println("Entrez le titre de l'ouvrage :");
        String titre = sc.nextLine();
        System.out.println("Entrez l'âge minimum requis pour ce livre :");
        int ageMin = sc.nextInt();
        sc.nextLine();
        System.out.println("Entrez la date de parution :");
        String dateParution = sc.nextLine();
        System.out.println("Entrez le prix de location :");
        double prixLocation = sc.nextDouble();
        sc.nextLine();
        System.out.println("Entrez la langue de l'ouvrage :");
        String langue = sc.nextLine();
        System.out.println("Entrez le genre de l'ouvrage :");
        String genre = sc.nextLine();

        //n'arrive pas a faire la suite
        //TODO
    }

    private static void gestAuteurs(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ajout d'un auteur");
        System.out.print("Nom : ");
        String nom = sc.nextLine();
        System.out.print("Prénom : ");
        String prenom = sc.nextLine();
        System.out.print("Nationalité : ");
        String nationalite = sc.nextLine();
        Auteur auteur = new Auteur(nom, prenom, nationalite);
        auteurs.add(auteur);
        System.out.println("Auteur ajouté");
    }
}
