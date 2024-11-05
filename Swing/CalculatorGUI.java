package LAB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField input1;
    private JTextField input2;
    private JLabel resultLabel;

    public CalculatorGUI() {
        setTitle("Basic Calculator");
        setSize(400, 600);
//        setLayout(new FlowLayout());
        setLayout(new GridLayout(6, 2, 10, 10));
        input1 = new JTextField(10);
        input2 = new JTextField(10);
        resultLabel = new JLabel("Result: ");

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        add(new JLabel("First Number:"));
        add(input1);
        add(new JLabel("Second Number:"));
        add(input2);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(resultLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(input1.getText());
            int num2 = Integer.parseInt(input2.getText());
            String command = e.getActionCommand();
            int result;

            switch (command) {
                case "Add":
                    result = num1 + num2;
                    resultLabel.setText("Result: " + result);
                    break;
                case "Subtract":
                    result = num1 - num2;
                    resultLabel.setText("Result: " + result);
                    break;
                case "Multiply":
                    result = num1 * num2;
                    resultLabel.setText("Result: " + result);
                    break;
                case "Divide":
                    if (num2 == 0) {
                        resultLabel.setText("Error: Division by zero");
                    } else {
                        result = num1 / num2;
                        resultLabel.setText("Result: " + result);
                    }
                    break;
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Error: Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculator = new CalculatorGUI();
            calculator.setVisible(true);
        });
    }
}

