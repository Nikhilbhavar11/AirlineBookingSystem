//public class Main {
   // public static void main(String[] args) {
       // new LoginFrame();
    //}
//}
public class Main {
    public static void main(String[] args) {
        try {
            DBConnection.getConnection();
            System.out.println("✅ Connected to the database successfully!");
            new LoginFrame(); // Open login frame only after successful DB connection
        } catch (Exception e) {
            System.out.println("❌ Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}

