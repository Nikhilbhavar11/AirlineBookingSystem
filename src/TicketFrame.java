import java.awt.*;

public class TicketFrame extends Frame {
    public TicketFrame(String ticketNumber) {
        setLayout(new GridLayout(3, 1));
        add(new Label("Ticket Confirmed!"));
        add(new Label("Ticket Number: " + ticketNumber));
        add(new Label("Have a safe journey!"));

        setTitle("Ticket");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
            }
        });
    }
}
