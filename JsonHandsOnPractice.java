import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class JsonHandsOnPractice {

    // 1. Read a JSON file and print all keys and values
    public static void readJsonFile(String filePath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        printJsonNode(rootNode, "");
    }

    private static void printJsonNode(JsonNode node, String prefix) {
        if (node.isObject()) {
            node.fieldNames().forEachRemaining(field -> printJsonNode(node.get(field), prefix + field + "."));
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJsonNode(node.get(i), prefix + i + ".");
            }
        } else {
            System.out.println(prefix + " : " + node.asText());
        }
    }

    // 2. Convert a list of Java objects into a JSON array
    public static void convertListToJsonArray() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Car> cars = Arrays.asList(new Car("Honda", "Civic", 2021), new Car("Ford", "Focus", 2019));
        String jsonArray = objectMapper.writeValueAsString(cars);
        System.out.println(jsonArray);
    }

    // 3. Filter JSON data: Print only users older than 25 years
    public static void filterJsonByAge(String filePath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        }
    }

    // 4. Validate an email field using JSON Schema
    public static boolean validateEmail(JsonNode jsonNode) {
        StringSchema emailSchema = new StringSchema();
        emailSchema.setPattern("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        JsonSchemaValidator validator = new JsonSchemaValidator();
        return validator.validate(jsonNode.get("email"), emailSchema);
    }

    // 5. Merge two JSON files into a single JSON object
    public static JsonNode mergeJsonFiles(String file1, String file2) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json1 = objectMapper.readTree(new File(file1));
        JsonNode json2 = objectMapper.readTree(new File(file2));
        ObjectNode merged = objectMapper.createObjectNode();
        merged.setAll((ObjectNode) json1);
        merged.setAll((ObjectNode) json2);
        return merged;
    }

    // 6. Convert JSON to XML format
    public static String convertJsonToXml(String jsonFilePath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File(jsonFilePath));
        return XML.toString(new org.json.JSONObject(objectMapper.writeValueAsString(jsonNode)));
    }

    // 7. Convert CSV data into JSON
    public static void convertCsvToJson(String csvFilePath, String jsonFilePath) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath));
                FileWriter writer = new FileWriter(jsonFilePath)) {
            List<String[]> allData = reader.readAll();
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = objectMapper.createArrayNode();
            String[] headers = allData.get(0);
            for (int i = 1; i < allData.size(); i++) {
                ObjectNode jsonObject = objectMapper.createObjectNode();
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], allData.get(i)[j]);
                }
                arrayNode.add(jsonObject);
            }
            objectMapper.writeValue(writer, arrayNode);
        }
    }

    // 8. Generate a JSON report from database records
    public static void generateJsonFromDb(String jsonFilePath) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "user", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode = objectMapper.createArrayNode();
        while (rs.next()) {
            ObjectNode jsonObject = objectMapper.createObjectNode();
            jsonObject.put("id", rs.getInt("id"));
            jsonObject.put("name", rs.getString("name"));
            jsonObject.put("email", rs.getString("email"));
            jsonObject.put("age", rs.getInt("age"));
            arrayNode.add(jsonObject);
        }
        objectMapper.writeValue(new File(jsonFilePath), arrayNode);
        conn.close();
    }
}