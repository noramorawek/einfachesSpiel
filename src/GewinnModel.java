public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel(){
        this.berechneComputerZahl();
        this.rundenErgebnis = 0;
        this.gesamtPunkte = 30;
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

    public void berechneComputerZahl(){
        this.computerZahl= (int) (Math.random()*9)+1;
    }

    public void berechneRunde(int spielerZahl){
        this.spielerZahl = spielerZahl;
        if(spielerZahl == this.computerZahl){
            this.rundenErgebnis = 20;
            this.gesamtPunkte += 20;
        } else if(spielerZahl -1 == this.computerZahl || spielerZahl<this.computerZahl){
            this.rundenErgebnis = 5;
            this.gesamtPunkte += 5;
        }else {
            this.rundenErgebnis = -10;
            this.gesamtPunkte -= 20;
        }
    }

    public boolean hatGewonnen(){
        if(this.gesamtPunkte>= 100){
            return true;
        } else{
            return false;
        }
    }

    public boolean hatVerloren(){
        if(this.gesamtPunkte <= 0){
            return true;
        } else{
            return false;
        }
    }
}
