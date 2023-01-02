package shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable {

    // Attributs
    public final int NB_MAX_COMPTE = 4;

    private final int code;
    private final String nom;
    private final String prenom;
    private String adresse;
    private Agence monAgence;
    private ArrayList<Compte> mesComptes;
    private Employe conseiller;
    private int nbCompte = 0;

    private static int nbClient = 0;

    // Constructor
    public Client(String nom, String prenom, String adresse, Agence agence) {
        this.code = ++nbClient;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.monAgence = agence;
        this.mesComptes = new ArrayList<Compte>();
    }

    // Methods
    public void addCompte(Compte c) {

        if (this.nbCompte < NB_MAX_COMPTE) {
            this.mesComptes.add(c);
            this.nbCompte++;
        } else {
            System.out.println("Vous avez atteindre le nombre max du comptes que vous pouvez avoir");
        }

    }

    public void deposer(int nCompte, double montant) {
        this.mesComptes.get(nCompte).deposer(montant);
    }

    public void retirer(int nCompte, double montant) {
        this.mesComptes.get(nCompte).retirer(montant);
    }


    // Getters and Setters
    public Compte getCompte(int n) {
        return this.mesComptes.get(n);
    }

    public int getCode() {
        return this.code;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Agence getMonAgence() {
        return this.monAgence;
    }

    public void setMonAgence(Agence monAgence) {
        this.monAgence = monAgence;
    }

    public int getNbCompte() {
        return this.nbCompte;
    }

    public static int getNbClient() {
        return nbClient;
    }

    public Employe getConseiller() {
        return this.conseiller;
    }

    public void setConseiller(Employe conseiller) {
        this.conseiller = conseiller;
    }

    @Override
    public String toString() {
        return "Client{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", mesComptes=" + mesComptes +
                ", conseiller=" + conseiller +
                ", nbCompte=" + nbCompte +
                '}';
    }
}
