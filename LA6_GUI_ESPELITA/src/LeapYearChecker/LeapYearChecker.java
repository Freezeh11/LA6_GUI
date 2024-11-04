package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame {
    private JTextField yearTextField;
    private JPanel pMain;
    private JButton checkYearButton;
    LeapYearChecker() {
        checkYearButton.setName("checkYearButton");
        yearTextField.setText("");
        yearTextField.setName("yearTextField");
        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year = 0;
                try {
                    year = Integer.parseInt(yearTextField.getText());
                    boolean leap;

                    if (year % 4 == 0) {
                        if (year % 100 == 0) {
                            leap = year % 400 == 0;
                        } else {
                            leap = true;
                        }
                    } else {
                        leap = false;
                    }

                    if (leap) {
                        JOptionPane.showMessageDialog(null, "Leap year");
                    } else {
                        JOptionPane.showMessageDialog(null, "Not a leap year");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        });
    }

    public static void main(String[] args) {
        LeapYearChecker lyc = new LeapYearChecker();
        lyc.setTitle("Leap Year Checker");
        lyc.setContentPane(lyc.pMain);
        lyc.setSize(300, 150);
        lyc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lyc.setVisible(true);
    }
}
