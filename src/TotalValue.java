public class TotalValue {

    private final InventoryManager inventoryManager;

    public TotalValue(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public void execute() {
        if (inventoryManager.getInventory().isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        double sum = 0.0;
        for (Product product : inventoryManager.getInventory()) {
            sum += product.getPrice();
        }
        System.out.println("Total value:"+sum);

    }
}
