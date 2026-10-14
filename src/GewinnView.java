import javax.swing.*;
import java.awt.*;

public class GewinnView {

    JFrame frame;
    JLabel gesamtPunkteLabel;
    JLabel rundenErgebnisLabel;
    JTextField spielerZahlField;
    JTextField computerZahlField;
    JButton nochEinmalButton;

    public GewinnView() {
        frame = new JFrame("Gewinn");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.setBackground(Color.WHITE);

        gesamtPunkteLabel = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);
        gesamtPunkteLabel.setOpaque(true);
        gesamtPunkteLabel.setBackground(Color.WHITE);

        rundenErgebnisLabel = new JLabel("Rundenergebnis: 0", SwingConstants.CENTER);
        rundenErgebnisLabel.setOpaque(true);
        rundenErgebnisLabel.setBackground(Color.WHITE);

        topPanel.add(gesamtPunkteLabel);
        topPanel.add(rundenErgebnisLabel);
        frame.add(topPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(1, 2));
        JPanel spielerPanel = new JPanel(new GridLayout(2, 1));
        JLabel spielerLabel = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        spielerZahlField = new JTextField();
        spielerPanel.add(spielerLabel);
        spielerPanel.add(spielerZahlField);

        JPanel computerPanel = new JPanel(new GridLayout(2, 1));
        JLabel computerLabel = new JLabel("Computerzahl:", SwingConstants.CENTER);
        computerZahlField = new JTextField();
        computerZahlField.setEditable(false);

        computerPanel.add(computerLabel);
        computerPanel.add(computerZahlField);

        inputPanel.add(spielerPanel);
        inputPanel.add(computerPanel);
        frame.add(inputPanel, BorderLayout.CENTER);

        nochEinmalButton = new JButton("Noch einmal");
        frame.add(nochEinmalButton, BorderLayout.SOUTH);

        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}