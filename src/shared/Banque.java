package shared;
import java.util.Arrays;

public class Banque {
    public static final int NB_MAX_AGENCES = 50;
    private String nom;
    private double capitalGlobal;
    private String siegeSocial;
    private Agence[] agences;
    private static int nbAgences = 0;

    public Banque(String nom, double capitalGlobal, String siegeSocial) {
        this.nom = nom;
        this.capitalGlobal = capitalGlobal;
        this.siegeSocial = siegeSocial;
        this.agences = new Agence[50];
    }

    public void addAgence(Agence a) {
        if (nbAgences < 50) {
            this.agences[nbAgences++] = a;
        } else {
            System.out.println("Vous avez atteindre le nombre max du agences que vous pouvez avoir");
        }

    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getCapitalGlobal() {
        return this.capitalGlobal;
    }

    public void setCapitalGlobal(double capitalGlobal) {
        this.capitalGlobal = capitalGlobal;
    }

    public String getSiegeSocial() {
        return this.siegeSocial;
    }

    public void setSiegeSocial(String siegeSocial) {
        this.siegeSocial = siegeSocial;
    }

    public static int getNbAgences() {
        return nbAgences;
    }

    public Agence getAgence(int n) {
        return this.agences[n];
    }

    @Override
    public String toString() {
        return "Banque{" +
                "nom='" + nom + '\'' +
                ", capitalGlobal=" + capitalGlobal +
                ", siegeSocial='" + siegeSocial + '\'' +
                ", agences=" + Arrays.toString(agences) +
                '}';
    }
}
