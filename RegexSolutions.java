import java.util.regex.*;

public class RegexSolutions {

    // 1. Validate a Username
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    // 2. Validate a License Plate Number
    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\d{4}$");
    }

    // 3. Validate a Hex Color Code
    public static boolean isValidHexColor(String color) {
        return color.matches("^#[0-9A-Fa-f]{6}$");
    }

    // 4. Extract All Email Addresses
    public static void extractEmails(String text) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // 5. Extract All Capitalized Words
    public static void extractCapitalizedWords(String text) {
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // 6. Extract Dates in dd/mm/yyyy Format
    public static void extractDates(String text) {
        Pattern pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // 7. Extract Links from a Web Page
    public static void extractLinks(String text) {
        Pattern pattern = Pattern.compile("https?://\\S+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // 8. Replace Multiple Spaces with a Single Space
    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }

    // 9. Censor Bad Words
    public static String censorBadWords(String text) {
        return text.replaceAll("\\b(damn|stupid)\\b", "****");
    }

    // 10. Validate an IP Address
    public static boolean isValidIPAddress(String ip) {
        return ip.matches("^(\\d{1,3}\\.){3}\\d{1,3}$");
    }

    // 11. Validate a Credit Card Number
    public static boolean isValidCreditCard(String card) {
        return card.matches("^4\\d{15}$") || card.matches("^5\\d{15}$");
    }

    // 12. Extract Programming Languages
    public static void extractProgrammingLanguages(String text) {
        Pattern pattern = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // 13. Extract Currency Values
    public static void extractCurrencyValues(String text) {
        Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // 14. Find Repeating Words
    public static void findRepeatingWords(String text) {
        Pattern pattern = Pattern.compile("\\b(\\w+) \\\1\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    // 15. Validate a Social Security Number
    public static boolean isValidSSN(String ssn) {
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("user_123")); // true
        System.out.println(isValidLicensePlate("AB1234")); // true
        System.out.println(isValidHexColor("#FFA500")); // true
        extractEmails("Contact us at support@example.com and info@company.org");
        extractCapitalizedWords("The Eiffel Tower is in Paris and the Statue of Liberty is in New York.");
        extractDates("The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.");
        extractLinks("Visit https://www.google.com and http://example.org for more info.");
        System.out.println(replaceMultipleSpaces("This  is   an example    with multiple spaces."));
        System.out.println(censorBadWords("This is a damn bad example with some stupid words."));
        System.out.println(isValidIPAddress("192.168.1.1")); // true
        System.out.println(isValidCreditCard("4111111111111111")); // true
        extractProgrammingLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet.");
        extractCurrencyValues("The price is $45.99, and the discount is 10.50.");
        findRepeatingWords("This is is a repeated repeated word test.");
        System.out.println(isValidSSN("123-45-6789")); // true
    }
}