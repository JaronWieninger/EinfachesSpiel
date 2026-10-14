import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController {
    GewinnModel model;
    GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;

        view.spielerZahlField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int spielerZahl;
                try {
                    spielerZahl = Integer.parseInt(view.spielerZahlField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view.frame, "Bitte eine Zahl von 1 bis 9 eingeben.");
                    return;
                }

                if (spielerZahl < 1 || spielerZahl > 9) {
                    JOptionPane.showMessageDialog(view.frame, "Bitte eine Zahl von 1 bis 9 eingeben.");
                    return;
                }

                model.berechneComputerZahl();
                model.berechneRunde(spielerZahl);

                view.computerZahlField.setText(String.valueOf(model.getComputerZahl()));
                view.rundenErgebnisLabel.setText("Rundenergebnis: " + model.getRundenErgebnis());
                view.gesamtPunkteLabel.setText("Gesamtpunkte: " + model.getGesamtPunkte());
            }
        });
    }

    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        new GewinnController(model, view);
    }
}