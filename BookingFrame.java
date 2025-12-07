/*import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookingFrame extends JFrame implements ActionListener {

    JTextField tfName, tfPhone, tfSeats;
    JComboBox<String> cbGender, cbSource, cbDestination;
    JButton btnBook;

    String username;

    public BookingFrame(String username) {
        this.username = username;

        setTitle("Flight Booking");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 255));

        JLabel heading = new JLabel("Book Your Flight");
        heading.setFont(new Font("Georgia", Font.BOLD, 28));
        heading.setBounds(250, 20, 300, 40);
        heading.setForeground(new Color(30, 30, 80));
        add(heading);

        JLabel nameLabel = new JLabel("Passenger Name:");
        nameLabel.setBounds(100, 80, 150, 30);
        add(nameLabel);
        tfName = new JTextField();
        tfName.setBounds(270, 80, 350, 30);
        add(tfName);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(100, 130, 150, 30);
        add(phoneLabel);
        tfPhone = new JTextField();
        tfPhone.setBounds(270, 130, 350, 30);
        add(tfPhone);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(100, 180, 150, 30);
        add(genderLabel);
        String[] genders = {"Male", "Female", "Other"};
        cbGender = new JComboBox<>(genders);
        cbGender.setBounds(270, 180, 350, 30);
        add(cbGender);

        JLabel sourceLabel = new JLabel("Source:");
        sourceLabel.setBounds(100, 230, 150, 30);
        add(sourceLabel);
        String[] cities = {
                "Mumbai", "Delhi", "Bangalore", "Hyderabad", "Chennai",
                "Kolkata", "Pune", "Ahmedabad", "Jaipur", "Goa",
                "Lucknow", "Nagpur", "Indore", "Chandigarh", "Bhopal",
                "Coimbatore", "Patna", "Surat", "Kochi", "Guwahati"
        };
        cbSource = new JComboBox<>(cities);
        cbSource.setBounds(270, 230, 350, 30);
        add(cbSource);

        JLabel destLabel = new JLabel("Destination:");
        destLabel.setBounds(100, 280, 150, 30);
        add(destLabel);
        cbDestination = new JComboBox<>(cities);
        cbDestination.setBounds(270, 280, 350, 30);
        add(cbDestination);

        JLabel seatsLabel = new JLabel("Seats:");
        seatsLabel.setBounds(100, 330, 150, 30);
        add(seatsLabel);
        tfSeats = new JTextField();
        tfSeats.setBounds(270, 330, 350, 30);
        add(tfSeats);

        btnBook = new JButton("Book Ticket");
        btnBook.setBounds(270, 390, 200, 40);
        btnBook.setBackground(new Color(0, 0, 200));
        btnBook.setForeground(Color.WHITE);
        btnBook.addActionListener(this);
        add(btnBook);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = tfName.getText().trim();
        String phone = tfPhone.getText().trim();
        String gender = (String) cbGender.getSelectedItem();
        String source = (String) cbSource.getSelectedItem();
        String destination = (String) cbDestination.getSelectedItem();
        String seatsStr = tfSeats.getText().trim();

        if (name.isEmpty() || phone.isEmpty() || seatsStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int seats = Integer.parseInt(seatsStr);
            int pricePerSeat = 2500;
            int totalPrice = pricePerSeat * seats;

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "your_password_here");
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO bookings (username, passenger_name, seats, total_price, phone, gender, source, destination) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, username);
            ps.setString(2, name);
            ps.setInt(3, seats);
            ps.setInt(4, totalPrice);
            ps.setString(5, phone);
            ps.setString(6, gender);
            ps.setString(7, source);
            ps.setString(8, destination);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Ticket Booked Successfully!");
                new BillFrame(name, totalPrice);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to book ticket.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Seats must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookingFrame extends JFrame implements ActionListener {

    JTextField tfName, tfPhone, tfSeats;
    JComboBox<String> cbGender, cbSource, cbDestination;
    JButton btnBook;

    String username;

    public BookingFrame(String username) {
        this.username = username;

        setTitle("Flight Booking");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 255));

        JLabel heading = new JLabel("Book Your Flight");
        heading.setFont(new Font("Georgia", Font.BOLD, 28));
        heading.setBounds(250, 20, 300, 40);
        heading.setForeground(new Color(30, 30, 80));
        add(heading);

        JLabel nameLabel = new JLabel("Passenger Name:");
        nameLabel.setBounds(100, 80, 150, 30);
        add(nameLabel);
        tfName = new JTextField();
        tfName.setBounds(270, 80, 350, 30);
        add(tfName);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(100, 130, 150, 30);
        add(phoneLabel);
        tfPhone = new JTextField();
        tfPhone.setBounds(270, 130, 350, 30);
        add(tfPhone);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(100, 180, 150, 30);
        add(genderLabel);
        String[] genders = {"Male", "Female", "Other"};
        cbGender = new JComboBox<>(genders);
        cbGender.setBounds(270, 180, 350, 30);
        add(cbGender);

        JLabel sourceLabel = new JLabel("Source:");
        sourceLabel.setBounds(100, 230, 150, 30);
        add(sourceLabel);
        String[] cities = {
                "Mumbai", "Delhi", "Bangalore", "Hyderabad", "Chennai",
                "Kolkata", "Pune", "Ahmedabad", "Jaipur", "Goa",
                "Lucknow", "Nagpur", "Indore", "Chandigarh", "Bhopal",
                "Coimbatore", "Patna", "Surat", "Kochi", "Guwahati"
        };
        cbSource = new JComboBox<>(cities);
        cbSource.setBounds(270, 230, 350, 30);
        add(cbSource);

        JLabel destLabel = new JLabel("Destination:");
        destLabel.setBounds(100, 280, 150, 30);
        add(destLabel);
        cbDestination = new JComboBox<>(cities);
        cbDestination.setBounds(270, 280, 350, 30);
        add(cbDestination);

        JLabel seatsLabel = new JLabel("Seats:");
        seatsLabel.setBounds(100, 330, 150, 30);
        add(seatsLabel);
        tfSeats = new JTextField();
        tfSeats.setBounds(270, 330, 350, 30);
        add(tfSeats);

        btnBook = new JButton("Book Ticket");
        btnBook.setBounds(270, 390, 200, 40);
        btnBook.setBackground(new Color(0, 0, 200));
        btnBook.setForeground(Color.WHITE);
        btnBook.addActionListener(this);
        add(btnBook);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String name = tfName.getText().trim();
        String phone = tfPhone.getText().trim();
        String gender = (String) cbGender.getSelectedItem();
        String source = (String) cbSource.getSelectedItem();
        String destination = (String) cbDestination.getSelectedItem();
        String seatsStr = tfSeats.getText().trim();

        if (name.isEmpty() || phone.isEmpty() || seatsStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int seats = Integer.parseInt(seatsStr);
            int pricePerSeat = 2500;
            int totalPrice = pricePerSeat * seats;

            // ✅ Use your shared DBConnection class here
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO bookings (username, passenger_name, seats, total_price, phone, gender, source, destination) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setString(1, username);
            ps.setString(2, name);
            ps.setInt(3, seats);
            ps.setInt(4, totalPrice);
            ps.setString(5, phone);
            ps.setString(6, gender);
            ps.setString(7, source);
            ps.setString(8, destination);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Ticket Booked Successfully!");
                new BillFrame(name, totalPrice);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to book ticket.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Seats must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

