package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class InventoryManagerTest {
    private InventoryManager inventory;

    @BeforeEach
    void setUp() {
        inventory = new InventoryManager();
    }

    @Test
    void testAddProduct() {
        Product product = new Product(1, "Laptop", 10, 1500.0);
        inventory.addProduct(product);
        List<Product> products = inventory.getAllProducts();
        assertTrue(products.contains(product), "Product should be in inventory.");
    }

    @Test
    void testRemoveProduct() {
        Product product = new Product(2, "Mouse", 5, 25.0);
        inventory.addProduct(product);
        boolean removed = inventory.removeProduct(2);
        assertTrue(removed, "Product should be removed successfully.");
        assertFalse(inventory.getAllProducts().contains(product), "Product should no longer be in inventory.");
    }

    @Test
    void testGetProductById() {
        Product product = new Product(3, "Keyboard", 3, 45.0);
        inventory.addProduct(product);
        Product retrieved = inventory.getProductById(3);
        assertNotNull(retrieved, "Product should be found.");
        assertEquals("Keyboard", retrieved.getName(), "Product name should match.");
    }
}
