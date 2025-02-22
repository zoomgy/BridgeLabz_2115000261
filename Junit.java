// 1️⃣ Basic JUnit Test: Testing a Calculator Class

class Calculator {
    int add(int a, int b) { return a + b; }
    int subtract(int a, int b) { return a - b; }
    int multiply(int a, int b) { return a * b; }
    int divide(int a, int b) { 
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b; 
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void testAdd() { assertEquals(5, calc.add(2, 3)); }
    
    @Test
    void testSubtract() { assertEquals(1, calc.subtract(4, 3)); }
    
    @Test
    void testMultiply() { assertEquals(6, calc.multiply(2, 3)); }
    
    @Test
    void testDivide() { assertEquals(2, calc.divide(6, 3)); }
    
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(4, 0));
    }
}

// 2️⃣ Testing String Utility Methods

class StringUtils {
    String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    boolean isPalindrome(String str) {
        return str.equals(reverse(str));
    }

    String toUpperCase(String str) {
        return str.toUpperCase();
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    StringUtils utils = new StringUtils();

    @Test
    void testReverse() { assertEquals("dcba", utils.reverse("abcd")); }
    
    @Test
    void testIsPalindrome() { assertTrue(utils.isPalindrome("madam")); }
    
    @Test
    void testToUpperCase() { assertEquals("HELLO", utils.toUpperCase("hello")); }
}

// 3️⃣ Testing List Operations

import java.util.*;

class ListManager {
    void addElement(List<Integer> list, int element) { list.add(element); }
    void removeElement(List<Integer> list, int element) { list.remove(Integer.valueOf(element)); }
    int getSize(List<Integer> list) { return list.size(); }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {
    ListManager manager = new ListManager();
    List<Integer> list = new ArrayList<>();

    @Test
    void testAddElement() {
        manager.addElement(list, 5);
        assertTrue(list.contains(5));
    }
    
    @Test
    void testRemoveElement() {
        list.add(10);
        manager.removeElement(list, 10);
        assertFalse(list.contains(10));
    }
    
    @Test
    void testGetSize() {
        list.add(1);
        list.add(2);
        assertEquals(2, manager.getSize(list));
    }
}

// 4️⃣ Testing Exception Handling

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionTest {
    int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> divide(4, 0));
    }
}

// 5️⃣ Testing @BeforeEach and @AfterEach Annotations

import org.junit.jupiter.api.*;

class DatabaseConnection {
    void connect() { System.out.println("Connected to DB"); }
    void disconnect() { System.out.println("Disconnected from DB"); }
}

class DatabaseConnectionTest {
    DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnection() {
        assertNotNull(db);
    }
}

// 6️⃣ Testing Parameterized Tests

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtils {
    boolean isEven(int number) { return number % 2 == 0; }
}

class NumberUtilsTest {
    NumberUtils utils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6, 8 })
    void testIsEven(int num) {
        assertTrue(utils.isEven(num));
    }
}

// 7️⃣ Performance Testing Using @Timeout

import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

class PerformanceTest {
    void longRunningTask() throws InterruptedException { Thread.sleep(3000); }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask() {
        assertDoesNotThrow(() -> longRunningTask());
    }
}

// 8️⃣ Testing File Handling Methods

import java.io.*;

class FileProcessor {
    void writeToFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) { writer.write(content); }
    }
    String readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) { return reader.readLine(); }
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {
    FileProcessor processor = new FileProcessor();

    @Test
    void testFileWriteRead() throws IOException {
        String filename = "test.txt";
        processor.writeToFile(filename, "Hello");
        assertEquals("Hello", processor.readFromFile(filename));
    }
}