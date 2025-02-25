
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class InventoryManagerTest {

    //unit tests
    private InventoryManager inventory;

    @BeforeEach
    void setUp() {
        inventory = new InventoryManager();
    }

    @Test
    void testAddProduct() {
        Product product = new Product(1, "Laptop", 10, 1500.0);
        inventory.addProduct(product);
        List<Product> products = inventory.getInventory();
        assertTrue(products.contains(product), "Product should be in inventory.");
    }

    @Test
    void testRemoveProduct() {
        Product product = new Product(2, "Mouse", 5, 25.0);
        inventory.addProduct(product);
        int size1 = inventory.getInventory().size();
        inventory.removeProduct(2);
        int size2 = inventory.getInventory().size();
        boolean removed = false;
        if (size1 > size2){
            removed = true;
        }
        assertTrue(removed, "Product should be removed successfully.");
        assertFalse(inventory.getInventory().contains(product), "Product should no longer be in inventory.");
    }

    @Test
    void testFindProductById() {
        Product product = new Product(3, "Keyboard", 3, 45.0);
        inventory.addProduct(product);
        Product retrieved = inventory.findProductById(3);
        assertNotNull(retrieved, "Product should be found.");
        assertEquals("Keyboard", retrieved.getName(), "Product name should match.");
    }
}
