import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class GroceryManagementSystem {
    private List<Product> products;

    public GroceryManagementSystem() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProductQuantity(int productId, int newQuantity) {
        for (Product product : products) {
            if (product.getId() == productId) {
                product.setQuantity(newQuantity);
                break;
            }
        }
    }

    public void removeProduct(int productId) {
        Product foundProduct = null;
        for (Product product : products) {
            if (product.getId() == productId) {
                foundProduct = product;
                break;
            }
        }
        if (foundProduct != null) {
            products.remove(foundProduct);
        }
    }

    public void viewAllProducts() {
        System.out.println("----- Grocery Products -----");
        for (Product product : products) {
            System.out.println("ID: " + product.getId() +
                    ", Name: " + product.getName() +
                    ", Price: $" + product.getPrice() +
                    ", Quantity: " + product.getQuantity());
        }
    }

    public static void main(String[] args) {
        GroceryManagementSystem groceryManagementSystem = new GroceryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Grocery Management System Menu -----");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. Remove Product");
            System.out.println("4. View All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter the product ID: ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter the product quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = new Product(productId, name, price, quantity);
                    groceryManagementSystem.addProduct(product);
                    System.out.println("Product added successfully!");
                    break;
                case 2:
                    System.out.print("Enter the product ID to update quantity: ");
                    int updateProductId = scanner.nextInt();
                    System.out.print("Enter the new quantity: ");
                    int newQuantity = scanner.nextInt();
                    groceryManagementSystem.updateProductQuantity(updateProductId, newQuantity);
                    System.out.println("Product quantity updated successfully!");
                    break;
                case 3:
                    System.out.print("Enter the product ID to remove: ");
                    int removeProductId = scanner.nextInt();
                    groceryManagementSystem.removeProduct(removeProductId);
                    System.out.println("Product removed successfully!");
                    break;
                case 4:
                    groceryManagementSystem.viewAllProducts();
                    break;
                case 5:
                    System.out.println("Exiting Grocery Management System...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
