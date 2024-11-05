package LAB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegistrationForm extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public RegistrationForm() {
        setTitle("User Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));

        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        passwordField = new JPasswordField();
        messageLabel = new JLabel();

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Phone Number:"));
        add(phoneField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(submitButton);
        add(messageLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String password = new String(passwordField.getPassword());

        if (isValidName(name) && isValidEmail(email) && isValidPhone(phone) && isValidPassword(password)) {
            messageLabel.setText("Success: Registration completed.");
        } else {
            messageLabel.setText("Error: Invalid input.");
        }
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationForm form = new RegistrationForm();
            form.setVisible(true);
            form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
