package shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.security.SecureRandom;

public class Agence implements Serializable {

    public static final int NB_MAX_CLIENTS = 30;
    public static final int NB_MAX_EMPLOYES = 6;

    private int numAgence;
    private String adresse;
    private Employe directeur;
    private ArrayList<Employe> employes;
    private ArrayList<Client> lesClients;

    private int nbComptes = 0;
    private int nbClients = 0;
    private int nbEmployes = 0;

    private static int nbAgences = 0;

    public Agence(String adresse) {
        this.numAgence = ++nbAgences;
        this.adresse = adresse;
        this.lesClients = new ArrayList<Client>();
        this.employes = new ArrayList<Employe>();
    }

    public void addClient(Client c) {
        if (this.nbClients < NB_MAX_CLIENTS) {
            this.lesClients.add(c);

            SecureRandom random = new SecureRandom();
            random.setSeed(12345);

            int i = random.nextInt(this.employes.size());
            this.lesClients.get(nbClients).setConseiller(this.employes.get(i));
            this.nbClients++;
        } else {
            System.out.println("Vous avez atteindre le nombre max du clients que vous pouvez avoir");
        }

    }

    public void addDirecteur(Employe d) {
        this.directeur = d;
    }

    public void addEmploye(Employe e) {
        if (this.nbEmployes < NB_MAX_EMPLOYES) {
            this.employes.add(e);
            this.nbEmployes++;
        } else {
            System.out.println("Vous avez atteindre le nombre max des employes que vous pouvez avoir");
        }

    }

    public int getNumAgence() {
        return this.numAgence;
    }

    public void setNumAgence(int numAgence) {
        this.numAgence = numAgence;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Client getClient(int n) {
        return this.lesClients.get(n);
    }

    public static int getNbAgences() {
        return nbAgences;
    }

    public int getNbClients() {
        return this.nbClients;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "numAgence=" + numAgence +
                ", adresse='" + adresse + '\'' +
                ", directeur=" + directeur +
                ", employes=" + employes +
                ", lesClients=" + lesClients +
                ", nbComptes=" + nbComptes +
                ", nbClients=" + nbClients +
                ", nbEmployes=" + nbEmployes +
                '}';
    }
}

