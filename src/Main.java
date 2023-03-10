import shared.*;
import util.EndOfFile;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        // Création de la banque
        Banque banque = new Banque("CIH", 2.0E8, "Agadir");

        // Création des agences
        Agence agence1 = new Agence("N 20 Rue Nassim, Hay Dakhla, Agadir");
        Agence agence2 = new Agence("N 2 Rue Nahda, Dcheira Jihadia, Inezgane");

        // Ajout des agences
        banque.addAgence(agence1);
        banque.addAgence(agence2);

        // Création des directeur
        Employe directeur1 = new Employe("Abid", "Ayoub");
        Employe directeur2 = new Employe("Tioussi", "Karam");

        // Ajout des directeurs
        agence1.addDirecteur(directeur1);
        agence2.addDirecteur(directeur2);

        // Création des Employés
        Employe e1 = new Employe("e1", "e1");
        Employe e2 = new Employe("e2", "e2");
        Employe e3 = new Employe("e3", "e3");
        Employe e4 = new Employe("e4", "e4");
        Employe e5 = new Employe("e5", "e5");

        // Ajout des employés
        agence1.addEmploye(e1);
        agence1.addEmploye(e2);
        agence1.addEmploye(e3);

        agence2.addEmploye(e4);
        agence2.addEmploye(e5);

        // Création des clients et leurs comptes
        ArrayList<Client> LesClient = new ArrayList<Client>();

        LesClient.add(new Client("BERRISS", "Ismail", "Inezgane", agence2));
        LesClient.add(new Client("CHHOU", "Anass", "Inezgane", agence2));
        LesClient.add(new Client("BOUHEDDA", "Hind", "Agadir", agence1));
        LesClient.add(new Client("LACHHAB", "Hamza", "Agadir", agence1));

        // Client 1
        LesClient.get(0).addCompte(new CompteEpargne(5000));
        // Client 2
        LesClient.get(1).addCompte(new ComptePayant(500));
        // Client 3
        LesClient.get(2).addCompte(new ComptePayant(3500));
        LesClient.get(2).addCompte(new ComptePayant(9800));
        // Client 4
        LesClient.get(3).addCompte(new CompteEpargne(2300));
        LesClient.get(3).addCompte(new ComptePayant(4300));

        // Sérialisation
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("comptes.txt"))){
            for(Client client : LesClient) {
                oos.writeObject(client);
            }
            oos.writeObject(new EndOfFile());
        }catch (Exception e){
            e.printStackTrace();
        }

        // Deposer de l'argent
        if (LesClient.get(0).getCompte(0) != null) {
            LesClient.get(0).getCompte(0).deposer(500.0);
        } else {
            System.out.println("Ce compte n'existe pas");
        }

        // Retirer de l'argent
        if (LesClient.get(2).getCompte(1) != null) {
            LesClient.get(2).getCompte(1).retirer(100.0);
        } else {
            System.out.println("Ce compte n'existe pas");
        }

        // Ajout des clients à leurs agences

        for(Client client : LesClient) {

            if (client.getAdresse().equals("Agadir")) {
                agence1.addClient(client);
            } else if (client.getAdresse().equals("Inezgane")) {
                agence2.addClient(client);
            }

        }

        // Application de la méthode calculInteret() sur tous les comptes d'épargne

        for(Agence agence : banque.getAgences()) {
            for(Client client : agence.getLesClients()) {
                for(Compte compte : client.getMesComptes()) {
                    if (compte instanceof CompteEpargne) {
                        ((CompteEpargne)compte).calculInteret();
                    }
                }
            }
        }

        /*** Affichage ***/

        // Affichage des agences

        System.out.println("--- Affichages des agences ---");

        for(Agence agence : banque.getAgences()) {
            System.out.println(agence.toString());
        }

        // Liste des différents clients avec leurs différents comptes

        System.out.println("\n--- Liste des differents clients avec leurs differents comptes ---");

        for(Agence agence : banque.getAgences()) {
            for(Client client : agence.getLesClients()) {
                System.out.println(client.toString());
            }
        }

        // Liste des comptes d'épargne de l'agence

        System.out.println("\n--- Liste des comptes d'epargne de l'agence ---");

        for(Agence agence : banque.getAgences()) {
            for(Client client : agence.getLesClients()) {
                for(Compte compte : client.getMesComptes()) {
                    if (compte instanceof CompteEpargne) {
                        System.out.println(compte.toString());
                    }
                }
            }
        }

        // Liste des comptes payants de l'agence

        System.out.println("\n--- Liste des comptes payants de l'agence ---");

        for(Agence agence : banque.getAgences()) {
            for(Client client : agence.getLesClients()) {
                for(Compte compte : client.getMesComptes()) {
                    if (compte instanceof ComptePayant) {
                        System.out.println(compte.toString());
                    }
                }
            }
        }

    }

}