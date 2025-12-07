import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SignUpFrame extends JFrame implements ActionListener {
    JTextField userField;
    JPasswordField passField;
    JButton signUpBtn;

    public SignUpFrame() {
        setTitle("Sign Up");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Font font = new Font("Serif", Font.BOLD, 16);

        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        userField = new JTextField(15);
        userField.setFont(font);

        passField = new JPasswordField(15);
        passField.setFont(font);

        signUpBtn = new JButton("Register");
        signUpBtn.setFont(font);
        signUpBtn.addActionListener(this);

        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("Username:"), gbc);
        gbc.gridx = 1; add(userField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Password:"), gbc);
        gbc.gridx = 1; add(passField, gbc);
        gbc.gridx = 1; gbc.gridy = 2; add(signUpBtn, gbc);

        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = userField.getText().trim();
        String pass = new String(passField.getPassword()).trim();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are mandatory.");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            dispose();
            new LoginFrame();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
