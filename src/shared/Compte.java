package shared;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.security.SecureRandom;

public class Compte implements Serializable {

    // Attributs
    private static int nbCompte = 0;

    protected String pin;
    protected int code;
    protected double solde;
    protected Agence lAgence;
    protected Client proprietaire;
    protected ArrayList<Operation> operations;
    protected int nbOperations = 0;

    // Constructors
    public Compte() {
    }

    public Compte(double solde) {
        this.solde = solde;
        this.code = ++nbCompte;
        this.pin = generatePIN();
        this.operations = new ArrayList<Operation>();
    }

    public Compte(Client client, Agence agence) {
        this(50.0, client, agence);
    }

    public Compte(double solde, Client client, Agence agence) {
        this.code = ++nbCompte;
        this.solde = solde;
        this.proprietaire = client;
        this.lAgence = agence;
        this.pin = generatePIN();
        operations = new ArrayList<Operation>();
    }

    // Methods
    public void retirer(double montant) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String time = currentDateTime.format(formattedTime);

        if (montant < this.solde) {
            this.solde -= montant;
            addOperation(montant, "retrait", time);

        }
    }

    public void deposer(double montant) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String time = currentDateTime.format(formattedTime);

        this.solde += montant;
        addOperation(montant, "depot", time);
    }

    public void addOperation(double montant, String type, String time) {
        operations.add(new Operation(montant, type, time));
        nbOperations++;
    }

    private String generatePIN() {
        SecureRandom random = new SecureRandom();
        random.setSeed(12345);

        int code = random.nextInt(10000);

        String formattedCode = String.format("%04d", code);

        return formattedCode;
    }


    // Getters and Setters
    public static int getNbCompte() {
        return nbCompte;
    }

    public int getCode() {
        return this.code;
    }

    public String getPin() {
        return pin;
    }

    public double getSolde() {
        return this.solde;
    }

    public Agence getlAgence() {
        return this.lAgence;
    }

    public Client getProprietaire() {
        return this.proprietaire;
    }

    public Operation getOperation(int i) {
        return operations.get(i);
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public int getNbOperations() {
        return nbOperations;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "pin='" + pin + '\'' +
                ", code=" + code +
                ", solde=" + solde +
                ", operations=" + operations +
                ", nbOperations=" + nbOperations +
                '}';
    }
}
