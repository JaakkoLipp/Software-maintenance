import java.util.Scanner;

public class DeleteProduct {
    private final InventoryManager inventoryManager;
    private Scanner scanner;
    public DeleteProduct(InventoryManager inventoryManager, Scanner scanner) {
        this.inventoryManager = inventoryManager;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Enter Product ID to Delete: ");
        int id = scanner.nextInt();
        inventoryManager.removeProduct(id);
        System.out.println("Product deleted if it existed.");
    }
}
