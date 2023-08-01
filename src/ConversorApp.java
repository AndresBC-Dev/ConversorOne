import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * 
 * 
 * @author Andres Buitrago
 * @version 1.0
 * 
 * 
 * 
 */

public class ConversorApp extends JFrame {
    private JComboBox<String> currentMoneda;
    private JComboBox<String> monedaDestino;
    private JTextField cantidadAConvertir;
    private JLabel resultadoLabel;

    private Conversor conversor;

    public ConversorApp() {
        conversor = new Conversor();

        setTitle("Conversor de Moneda");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        String[] monedas = {"USD", "COP", "EUR"};
        currentMoneda = new JComboBox<>(monedas);
        monedaDestino = new JComboBox<>(monedas);
        cantidadAConvertir = new JTextField(10);
        JButton convertirButton = new JButton("Convertir");
        JButton borrarButton = new JButton("Borrar");
        resultadoLabel = new JLabel("Resultado:");


        add(currentMoneda);
        add(new JLabel("a"));
        add(monedaDestino);
        add(new JLabel("Cantidad:"));
        add(cantidadAConvertir);
        add(convertirButton);
        add(borrarButton);
        add(resultadoLabel);


        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String monedaActual = (String) currentMoneda.getSelectedItem();
                String monedaDest = (String) monedaDestino.getSelectedItem();
                double cantidad = Double.parseDouble(cantidadAConvertir.getText());

                double resultado = conversor.convertir(monedaActual, monedaDest, cantidad);
                resultadoLabel.setText("Resultado: " + formatCurrency(resultado) + " " + monedaDest);
            }
        });


        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cantidadAConvertir.setText("");
                resultadoLabel.setText("Resultado:");
            }
        });
    }

    private String formatCurrency(double amount) {
        return String.format("%.2f", amount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConversorApp app = new ConversorApp();
                app.setVisible(true);
            }
        });
    }
}
