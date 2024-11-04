package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField tfNumber1;
    private JComboBox<String> cbOperations;
    private JTextField tfNumber2;
    private JButton btnCompute;
    private JPanel pMain;
    private JLabel lblResult;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        tfNumber1.setName("tfNumber1");
        cbOperations.setName("cbOperations");
        tfNumber2.setName("tfNumber2");
        btnCompute.setName("btnCompute");
        lblResult.setName("lblResult");

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeResult();
            }
        });
    }

    private void computeResult() {
        try {
            int num1 = Integer.parseInt(tfNumber1.getText());
            int num2 = Integer.parseInt(tfNumber2.getText());
            String op = (String) cbOperations.getSelectedItem();
            int result;
            double divisionResult;

            switch (op) {
                case "+":
                    result = num1 + num2;
                    lblResult.setText(Integer.toString(result));
                    break;
                case "-":
                    result = num1 - num2;
                    lblResult.setText(Integer.toString(result));
                    break;
                case "*":
                    result = num1 * num2;
                    lblResult.setText(Integer.toString(result));
                    break;
                case "/":
                    if (num2 == 0) {
                        lblResult.setText("Cannot divide by zero");
                    } else {
                        divisionResult = (double) num1 / num2;
                        lblResult.setText(Double.toString(divisionResult));
                    }
                    break;
                default:
                    lblResult.setText("Unknown operation");
                    break;
            }
        } catch (NumberFormatException ex) {
            lblResult.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SimpleCalculator sc = new SimpleCalculator();
        sc.setContentPane(sc.pMain);
        sc.setSize(500, 160);
        sc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        sc.setVisible(true);
    }
}
