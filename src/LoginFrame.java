import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginBtn, signUpBtn;

    public LoginFrame() {
        setTitle("Login - Airline System");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Font font = new Font("SansSerif", Font.BOLD, 16);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(font);
        userField = new JTextField(15);
        userField.setFont(font);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(font);
        passField = new JPasswordField(15);
        passField.setFont(font);

        loginBtn = new JButton("Login");
        loginBtn.setFont(font);
        loginBtn.addActionListener(this);

        signUpBtn = new JButton("Sign Up");
        signUpBtn.setFont(font);
        signUpBtn.addActionListener(e -> {
            dispose();
            new SignUpFrame();
        });

        gbc.gridx = 0; gbc.gridy = 0; add(userLabel, gbc);
        gbc.gridx = 1; add(userField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(passLabel, gbc);
        gbc.gridx = 1; add(passField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; add(loginBtn, gbc);
        gbc.gridx = 1; add(signUpBtn, gbc);

        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = userField.getText().trim();
        String password = new String(passField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE username=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                dispose();
                new BookingFrame(username);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
