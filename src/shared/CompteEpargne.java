package shared;

import java.io.Serializable;

public class CompteEpargne extends Compte implements Serializable {
    public final String typeCompteP = "CompteEpargne";
    private double tauxInteret = 6.0;

    public CompteEpargne(double solde) {
        super(solde);
    }

    public CompteEpargne(Client client, Agence agence) {
        super(client, agence);
    }

    public CompteEpargne(double solde, Client client, Agence agence) {
        super(solde, client, agence);
    }

    public void calculInteret() {
        super.deposer(this.getSolde() * this.tauxInteret / 100.0);
    }

    public String getTypeCompteP() {
        return "CompteEpargne";
    }

    public double getTauxInteret() {
        return this.tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "tauxInteret=" + tauxInteret +
                ", pin='" + pin + '\'' +
                ", code=" + code +
                ", solde=" + solde +
                ", operations=" + operations +
                ", nbOperations=" + nbOperations +
                '}';
    }
}

