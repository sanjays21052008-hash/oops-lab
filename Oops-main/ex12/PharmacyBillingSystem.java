import java.util.*;

class Medicine {
    private String name;
    private double price;
    private int quantity;

    Medicine(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class PharmacyBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Medicine> medicines = new ArrayList<>();

        medicines.add(new Medicine("Paracetamol", 20.0, 0));
        medicines.add(new Medicine("Vitamin C", 50.0, 0));
        medicines.add(new Medicine("Cough Syrup", 80.0, 0));

        try {
            System.out.println("PHARMACY BILLING SYSTEM");
            System.out.println("-----------------------");
            System.out.println("1. Paracetamol - Rs.20");
            System.out.println("2. Vitamin C - Rs.50");
            System.out.println("3. Cough Syrup - Rs.80");

            System.out.print("Enter medicine number: ");
            int choice = sc.nextInt();

            if (choice < 1 || choice > medicines.size()) {
                throw new IllegalArgumentException(
                    "Invalid medicine selection!");
            }

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            if (qty <= 0) {
                throw new IllegalArgumentException(
                    "Quantity must be greater than zero!");
            }

            Medicine m = medicines.get(choice - 1);

            double total = m.getPrice() * qty;
            double discount = 0;

            if (total >= 100) {
                discount = total * 0.10;
            }

            double finalBill = total - discount;

            System.out.println("\n----- FINAL BILL -----");
            System.out.println("Medicine: " + m.getName());
            System.out.println("Price: Rs." + m.getPrice());
            System.out.println("Quantity: " + qty);
            System.out.println("Total Amount: Rs." + total);
            System.out.println("Discount: Rs." + discount);
            System.out.println("Final Bill: Rs." + finalBill);
            System.out.println("----------------------");

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter numbers only.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
