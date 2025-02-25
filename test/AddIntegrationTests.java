import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class AddInventoryIntegrationTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream)); // Capture console output
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testAddProductThroughMainMenu() {
        // Simulated user input:
        // 1 (Add Product) -> ID: 101 -> Name: Laptop -> Quantity: 5 -> Price: 1200.0 -> Exit (12)
        String simulatedInput = """
        1
        101
        Laptop
        5
        1200
        0
        """;

        // Ensure the input buffer is filled before Main.main() starts
        ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(testInput);  // Set System.in to read from our simulated input

        // Capture System.out for verification
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main menu (this will include AddProduct execution)
        Main.main(new String[]{});

        // Check output contains success message
        String output = outputStream.toString();
        assertTrue(output.contains("Product added successfully."), "Product addition should be confirmed.");
    }
}
