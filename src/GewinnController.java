import javax.swing.*;
import java.awt.*;
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

                // Sicherheits-Nachbesserung (Version 1.1): Eingabe sperren, Button aktivieren
                view.spielerZahlField.setEnabled(false);
                view.nochEinmalButton.setEnabled(true);

                // Bunte Oberfläche (Version 2.0): Farbliche Markierung bei Gewinn/Verlust
                if (model.hatGewonnen()) {
                    view.gesamtPunkteLabel.setBackground(Color.GREEN);
                    view.rundenErgebnisLabel.setBackground(Color.GREEN);
                } else if (model.hatVerloren()) {
                    view.gesamtPunkteLabel.setBackground(Color.RED);
                    view.rundenErgebnisLabel.setBackground(Color.RED);
                }
            }
        });
        view.nochEinmalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.spielerZahlField.setText("");
                view.computerZahlField.setText("");
                view.rundenErgebnisLabel.setText("Rundenergebnis: 0");

                // Bunte Oberfläche (Version 2.0): Farben wieder auf Weiß zurücksetzen
                view.gesamtPunkteLabel.setBackground(Color.WHITE);
                view.rundenErgebnisLabel.setBackground(Color.WHITE);
            }
        });

    }

    public static void main(String[] args) {
        GewinnModel model = new GewinnModel();
        GewinnView view = new GewinnView();
        new GewinnController(model, view);
    }
}