import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class DeleteInventoryIntegrationTest {
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
void testDeleteProductThroughMainMenu () {
    // 4 (Delete Product) -> ID: 101 -> 2 (View Products) -> Exit (12)
    String simulatedInput = """
        4
        101
        2
        12
        """;
    ByteArrayInputStream testInput = new ByteArrayInputStream(simulatedInput.getBytes());
    System.setIn(testInput);

    // Capture System.out for verification
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    // Run the main menu (this will include AddProduct execution)
    Main.main(new String[]{});

    // Check output contains success message
    String output = outputStream.toString();
    assertTrue(output.contains("Product deleted if it existed"), "Product delete confirmed.");
    assertFalse(output.contains("ID: 101, Name: Laptop"), "Product should not be listed in view products.");
}
}