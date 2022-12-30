import java.io.Serializable;
import java.util.Arrays;

public class Agence implements Serializable {

    // Attributs
    public final static int NB_MAX_COMPTES = 50;
    public final static int NB_MAX_CLIENTS = 20;


    private int numAgence;
    private String adresse;
    private Client[] lesClients;
    private Compte[] lesComptes;

    private static int nbAgences = 0;
    private static int nbComptes = 0;
    private static int nbClients = 0;

    // Constructors
    public Agence (String adresse) {
        numAgence = ++nbAgences;
        this.adresse = adresse;
        lesClients = new Client[NB_MAX_CLIENTS];
        lesComptes = new Compte[NB_MAX_COMPTES];
    }

    // Methods
    public void addCompte(Compte c) {
        if(nbComptes < NB_MAX_COMPTES)
            lesComptes[nbComptes++] = c;
        else System.out.println("Vous avez atteindre le nombre max du comptes que vous pouvez avoir");
    }

    public void addClient(Client c) {
        if(nbClients < NB_MAX_CLIENTS)
            lesClients[nbClients++] = c;
        else System.out.println("Vous avez atteindre le nombre max du clients que vous pouvez avoir");
    }

    // Getters and Setters
    public int getNumAgence() {
        return numAgence;
    }

    public void setNumAgence(int numAgence) {
        this.numAgence = numAgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Compte getCompte(int n) {
        return lesComptes[n];
    }

    public Client getClient(int n) {
        return lesClients[n];
    }

    public static int getNbAgences() {
        return nbAgences;
    }

    public static int getNbComptes() {
        return nbComptes;
    }

    public static int getNbClients() {
        return nbClients;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "numAgence=" + numAgence +
                ", adresse='" + adresse + '\'' +
                ", lesClients=" + Arrays.toString(lesClients) +
                ", lesComptes=" + Arrays.toString(lesComptes) +
                '}';
    }

}
