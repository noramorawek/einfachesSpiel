import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GewinnView extends JFrame {

    private JLabel lblRundenergebnis;
    private JLabel lblGesamtpunkte;
    private JTextField txtSpielerZahl;
    private JTextField txtComputerZahl;
    private JButton btnNochEinmal;

    public GewinnView() {
        super("Zahlen-Gewinnspiel (v1.0)");
        start();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void start() {
        setLayout(new BorderLayout(10, 10));
        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel infoPanel = new JPanel(new GridLayout(2, 2, 10, 5));

        JLabel headerRunde = new JLabel("Rundenergebnis:");
        JLabel headerPunkte = new JLabel("Gesamtpunkte:");
        infoPanel.add(headerRunde);
        infoPanel.add(headerPunkte);

        lblRundenergebnis = new JLabel("Tippe eine Zahl von 1 bis 9");
        lblRundenergebnis.setFont(lblRundenergebnis.getFont().deriveFont(Font.BOLD));
        lblRundenergebnis.setOpaque(true);
        lblRundenergebnis.setBackground(Color.WHITE);

        lblGesamtpunkte = new JLabel("Gesamtpunkte: 30");
        lblGesamtpunkte.setFont(lblGesamtpunkte.getFont().deriveFont(Font.BOLD));
        lblGesamtpunkte.setOpaque(true);
        lblGesamtpunkte.setBackground(Color.WHITE);

        infoPanel.add(lblRundenergebnis);
        infoPanel.add(lblGesamtpunkte);

        JPanel eingabePanel = new JPanel(new GridLayout(2, 2, 10, 5));

        JLabel headerSpieler = new JLabel("Deine Zahl:");
        JLabel headerComputer = new JLabel("Computer:");
        eingabePanel.add(headerSpieler);
        eingabePanel.add(headerComputer);

        txtSpielerZahl = new JTextField();
        txtSpielerZahl.setHorizontalAlignment(JTextField.CENTER);
        txtSpielerZahl.setFont(txtSpielerZahl.getFont().deriveFont(20f));

        txtComputerZahl = new JTextField();
        txtComputerZahl.setHorizontalAlignment(JTextField.CENTER);
        txtComputerZahl.setFont(txtComputerZahl.getFont().deriveFont(20f));
        txtComputerZahl.setEditable(false);

        eingabePanel.add(txtSpielerZahl);
        eingabePanel.add(txtComputerZahl);

        txtSpielerZahl.setPreferredSize(new Dimension(150, 80));
        txtComputerZahl.setPreferredSize(new Dimension(150, 80));

        JPanel zentrum = new JPanel(new BorderLayout(10, 10));
        zentrum.add(infoPanel, BorderLayout.NORTH);
        zentrum.add(eingabePanel, BorderLayout.CENTER);
        add(zentrum, BorderLayout.CENTER);

        btnNochEinmal = new JButton("Noch einmal!");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnNochEinmal);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    public String getSpielerZahl() {
        return txtSpielerZahl.getText();
    }

    public void zeigeComputerZahl(int zahl) {
        txtComputerZahl.setText(String.valueOf(zahl));
    }

    public void zeigeRundenErgebnis(int ergebnis) {
        String text = ergebnis > 0 ? "+" + ergebnis : String.valueOf(ergebnis);
        lblRundenergebnis.setText(text);
    }

    public void zeigeGesamtPunkte(int punkte) {
        lblGesamtpunkte.setText(String.valueOf(punkte));
    }

    public void zeigeGewonnen() {
        lblRundenergebnis.setText("Gewonnen!");
    }

    public void zeigeVerloren() {
        lblRundenergebnis.setText("Verloren");
    }

    public void zurueckSetzen() {
        txtSpielerZahl.setText("");
        txtComputerZahl.setText("");
        lblRundenergebnis.setText("Tippe eine Zahl von 1 bis 9");
        txtSpielerZahl.setEditable(true);
        txtSpielerZahl.requestFocus();
        btnNochEinmal.setEnabled(false);
    }


    public void setErgebnisFarbe(Color farbe) {
        lblRundenergebnis.setBackground(farbe);
    }

    public void setPunkteFarbe(Color farbe) {
        lblGesamtpunkte.setBackground(farbe);
    }


    public void addSpielerZahlListener(ActionListener l) {
        txtSpielerZahl.addActionListener(l);
    }

    public void addNochEinmalListener(ActionListener l) {
        btnNochEinmal.addActionListener(l);
    }
}