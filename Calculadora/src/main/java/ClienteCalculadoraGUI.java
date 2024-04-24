import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteCalculadoraGUI extends JFrame {
    private JTextField num1Field, num2Field, resultField;
    private JComboBox<String> operacionBox;

    public ClienteCalculadoraGUI() {
        super("Calculadora RMI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(6, 2));

        operacionBox = new JComboBox<>(new String[]{"Suma", "Resta", "Multiplicación", "División"});
        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Registry registry = LocateRegistry.getRegistry("localhost");
                    Calculadora calculadora = (Calculadora) registry.lookup("Calculadora");
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    String operacion = (String) operacionBox.getSelectedItem();
                    double resultado = 0;

                    switch (operacion) {
                        case "Suma":
                            resultado = calculadora.sumar(num1, num2);
                            break;
                        case "Resta":
                            resultado = calculadora.restar(num1, num2);
                            break;
                        case "Multiplicación":
                            resultado = calculadora.multiplicar(num1, num2);
                            break;
                        case "División":
                            resultado = calculadora.dividir(num1, num2);
                            break;
                    }

                    resultField.setText(Double.toString(resultado));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        add(new JLabel("Número 1:"));
        add(num1Field);
        add(new JLabel("Número 2:"));
        add(num2Field);
        add(new JLabel("Operación:"));
        add(operacionBox);
        add(new JLabel("Resultado:"));
        add(resultField);
        add(calcularButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ClienteCalculadoraGUI();
    }
}
