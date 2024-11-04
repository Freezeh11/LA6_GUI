package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {
    private JPanel pMain;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;

    public FoodOrderingSystem() {
        setTitle("Food Ordering System");
        cPizza.setName("cPizza");
        cBurger.setName("cBurger");
        cFries.setName("cFries");
        cSoftDrinks.setName("cSoftDrinks");
        cTea.setName("cTea");
        cSundae.setName("cSundae");
        rb5.setName("rb5");
        rb10.setName("rb10");
        rb15.setName("rb15");
        btnOrder.setName("btnOrder");
        rbNone.setName("rbNone");

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        double total = 0.0;

        if (cPizza.isSelected()){
            total += 100.0;
        }
        if (cBurger.isSelected()){
            total += 80.0;
        }
        if (cFries.isSelected()){
            total += 55.0;
        }
        if (cSoftDrinks.isSelected()){
            total += 50.0;
        }
        if (cTea.isSelected()){
            total += 50.0;
        }
        if (cSundae.isSelected()){
            total += 40.0;
        }

        double discount = 0.0;
        if (rb5.isSelected()){
            discount = 0.05;
        }
        else if (rb10.isSelected()){
            discount = 0.10;
        }
        else if (rb15.isSelected()){
            discount = 0.15;
        }

        double discountAmount = total * discount;
        total -= discountAmount;

        String message = String.format("The total price is Php %.2f", total);
        JOptionPane.showMessageDialog(null, message);
    }

    public static void main(String[] args) {
        FoodOrderingSystem fos = new FoodOrderingSystem();
        fos.setContentPane(fos.pMain);
        fos.setSize(300, 425);
        fos.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fos.setVisible(true);
    }
}
