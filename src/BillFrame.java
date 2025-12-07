import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BillFrame extends Frame implements ActionListener {
    Button nextBtn;
    String ticketNumber;

    public BillFrame(String passengerName, double total) {
        setLayout(new GridLayout(5, 1));
        Font font = new Font("Serif", Font.BOLD, 20);
        setFont(font);

        ticketNumber = "TKT" + new Random().nextInt(100000);

        add(new Label("Passenger: " + passengerName));
        add(new Label("Total Amount: ₹" + total));
        add(new Label("Ticket Number: " + ticketNumber));
        add(new Label("Thank you for booking with us!"));

        nextBtn = new Button("Get Ticket");
        nextBtn.addActionListener(this);
        add(nextBtn);

        setTitle("Booking Confirmed");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
        new TicketFrame(ticketNumber);
    }
}
