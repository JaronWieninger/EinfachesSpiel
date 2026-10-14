public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 30;
        this.spielerZahl = 0;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }
    public void berechneComputerZahl() {
        int min = 1;
        int max = 9;
        int range = max - min + 1;

        this.computerZahl = (int)(Math.random() * range) + min;
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        if(spielerZahl == this.computerZahl) {
            this.rundenErgebnis = 20;
            this.gesamtPunkte += 20;
        } else if(Math.abs(spielerZahl - this.computerZahl) == 1) {
            this.rundenErgebnis = 5;
            this.gesamtPunkte += 5;
        } else {
            this.rundenErgebnis = -10;
            this.gesamtPunkte -= 10;
        }
    }
    public boolean hatGewonnen() {
        if(this.gesamtPunkte >= 100) {
            return true;
        }
        return false;
    }

    public boolean hatVerloren() {
        if(this.gesamtPunkte <= 0) {
            return true;
        }
        return false;
    }
}