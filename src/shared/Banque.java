package shared;
import java.util.ArrayList;

public class Banque {
    public static final int NB_MAX_AGENCES = 50;
    private String nom;
    private double capitalGlobal;
    private String siegeSocial;
    private ArrayList<Agence> agences;
    private static int nbAgences = 0;

    public Banque(String nom, double capitalGlobal, String siegeSocial) {
        this.nom = nom;
        this.capitalGlobal = capitalGlobal;
        this.siegeSocial = siegeSocial;
        this.agences = new ArrayList<Agence>();
    }

    public void addAgence(Agence a) {
        if (nbAgences < 50) {
            this.agences.add(a);
            nbAgences++;
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
        return this.agences.get(n);
    }

    public ArrayList<Agence> getAgences() {
        return agences;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "nom='" + nom + '\'' +
                ", capitalGlobal=" + capitalGlobal +
                ", siegeSocial='" + siegeSocial + '\'' +
                ", agences=" + agences +
                '}';
    }
}
