import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {

    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;
    }
    private class SpielerZahlListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int spielerZahl;
            try {
                spielerZahl = Integer.parseInt(view.getSpielerZahl());
            } catch (NumberFormatException ex) {
                return;
            }

            if (spielerZahl < 1 || spielerZahl > 9) {
                return;
            }

            model.berechneComputerZahl();
            model.berechneRunde(spielerZahl);

            view.zeigeComputerZahl(model.getComputerZahl());
            view.zeigeRundenErgebnis(model.getRundenErgebnis());
            view.zeigeGesamtPunkte(model.getGesamtPunkte());

            if (model.hatGewonnen()) {
                view.zeigeGewonnen();
            } else if (model.hatVerloren()) {
                view.zeigeVerloren();
            }
        }
    }

    private class NochEinmalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.zurueckSetzen();
        }
    }

}