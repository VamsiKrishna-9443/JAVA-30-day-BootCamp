import java.util.ArrayList;
import java.util.Iterator;

public class InventoryManager {

    ArrayList<Product> products = new ArrayList<>();

    // CREATE
    public void addProduct(Product product) {

        products.add(product);

        System.out.println("Product added successfully.");
    }

    // READ
    public void displayProducts() {

        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Product product : products) {
            product.displayProduct();
        }
    }

    // UPDATE
    public void updateProduct(
            int id,
            double newPrice,
            int newQuantity) {

        for (Product product : products) {

            if (product.id == id) {

                product.price = newPrice;
                product.quantity = newQuantity;

                System.out.println("Product updated.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    // DELETE
    public void deleteProduct(int id) {

        Iterator<Product> iterator =
                products.iterator();

        while (iterator.hasNext()) {

            Product product = iterator.next();

            if (product.id == id) {

                iterator.remove();

                System.out.println("Product deleted.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    // SEARCH
    public void searchProduct(int id) {
        for (Product product : products) {

            if (product.id == id) {
                product.displayProduct();
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public static void main(String[] args) {

        InventoryManager manager =
                new InventoryManager();

        // CREATE
        manager.addProduct(new Product(101, "Laptop", 60000, 5));

        manager.addProduct(new Product(102, "Mouse", 1000, 20));

        manager.addProduct(new Product(103, "Keyboard", 2000, 10));

        // READ
        System.out.println("\n--- ALL PRODUCTS ---");

        manager.displayProducts();

        // SEARCH
        System.out.println("\n--- SEARCH ---");

        manager.searchProduct(102);

        // UPDATE
        System.out.println("\n--- UPDATE ---");

        manager.updateProduct(102, 1200, 25);

        manager.searchProduct(102);

        // DELETE
        System.out.println("\n--- DELETE ---");

        manager.deleteProduct(103);

        // READ AGAIN
        System.out.println("\n--- FINAL INVENTORY ---");

        manager.displayProducts();
    }
}