package shared;

import java.io.Serializable;

public class Operation implements Serializable {

    // Attributs
    private double montant;
    private String type;
    private final String date;

    // Constructors
    public Operation(double montant, String type, String date) {
        this.montant = montant;
        this.type = type;
        this.date = date;
    }

    // Getters and Setters
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "montant=" + montant +
                ", type='" + type + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
