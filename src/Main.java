import java.io.*;

public class Main {

    public final static int NB_CLIENTS = 4;

    public static void main(String[] args) throws IOException {

        // Création de l'agence
        Agence lAgence = new Agence("N 20? Rue Nassim, Hay Dakhla, Agadir");

        // Création des Clients et leurs comptes
        Client LesClient[] = new Client[NB_CLIENTS];

        LesClient[0] = new Client("BERRISS", "Ismail", "Inezgane", lAgence);
        LesClient[1] = new Client("CHHOU", "Anass", "Inezgane", lAgence);
        LesClient[2] = new Client("BOUHEDDA", "Hind", "Agadir", lAgence);
        LesClient[3] = new Client("LACHHAB", "Hamza", "Agadir", lAgence);

       // Client 1
        LesClient[0].addCompte(new CompteEpargne(5000));
        // Client 2
        LesClient[1].addCompte(new ComptePayant(500));
        // Client 3
        LesClient[2].addCompte(new ComptePayant(3500));
        LesClient[2].addCompte(new ComptePayant(9800));
        // Client 4
        LesClient[3].addCompte(new CompteEpargne(2300));
        LesClient[3].addCompte(new ComptePayant(4300));

        // Sérialisation

        FileOutputStream f1 = new FileOutputStream("comptes");
        ObjectOutputStream o = new ObjectOutputStream(f1);

        o.writeObject(LesClient);

        f1.close(); o.close();

        // Deposer de l'argent
        if(LesClient[0].getCompte(0) != null) {
            LesClient[0].getCompte(0).deposer(500);
        } else {
            System.out.println("Ce compte n'existe pas");
        }

        // Retirer de l'argent
        if(LesClient[2].getCompte(1) != null) {
            LesClient[2].getCompte(1).retirer(100);
        } else {
            System.out.println("Ce compte n'existe pas");
        }

        // Ajout des clients et de leurs comptes à l'agence
        for(int i = 0; i < LesClient.length; i++) {
            lAgence.addClient(LesClient[i]);
        }

        // Application de la méthode calculInteret() sur tous les comptes d'épargne
        for(int i = 0; i < Agence.getNbClients(); i++) {
            for(int j = 0; j < lAgence.getClient(i).getNbCompte(); j++) {
                if (lAgence.getClient(i).getCompte(j) instanceof CompteEpargne) {
                    ((CompteEpargne)lAgence.getClient(i).getCompte(j)).calculInteret();
                }
            }
        }

        /*** Affichage ***/

        // Liste des différents clients avec leurs différents comptes

        System.out.println("--- Liste des differents clients avec leurs differents comptes ---");

        for(int i = 0; i < Agence.getNbClients(); i++) {
            System.out.println(lAgence.getClient(i).toString());
        }

        // Liste des comptes d'épargne de l'agence

        System.out.println("\n--- Liste des comptes d'epargne de l'agence ---");

        for(int i = 0; i < Agence.getNbClients(); i++) {
            for(int j = 0; j < lAgence.getClient(i).getNbCompte(); j++) {
                if (lAgence.getClient(i).getCompte(j) instanceof CompteEpargne) {
                    System.out.println(lAgence.getClient(i).getCompte(j).toString());
                }
            }
        }

        // Liste des comptes payants de l'agence

        System.out.println("\n--- Liste des comptes payants de l'agence ---");

        for(int i = 0; i < Agence.getNbClients(); i++) {
            for(int j = 0; j < lAgence.getClient(i).getNbCompte(); j++) {
                if (lAgence.getClient(i).getCompte(j) instanceof ComptePayant) {
                    System.out.println(lAgence.getClient(i).getCompte(j).toString());
                }
            }
        }

    }
}