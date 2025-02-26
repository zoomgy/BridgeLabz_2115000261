import java.io.*;
import java.util.*;

public class JsonPractice {

    // 1. Create a JSON object for a Student
    public static void createStudentJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode student = objectMapper.createObjectNode();
        student.put("name", "John Doe");
        student.put("age", 20);
        ArrayNode subjects = objectMapper.createArrayNode();
        subjects.add("Math").add("Science").add("History");
        student.set("subjects", subjects);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student));
    }

    // 2. Convert a Java object (Car) into JSON format
    static class Car {
        public String brand;
        public String model;
        public int year;

        public Car(String brand, String model, int year) {
            this.brand = brand;
            this.model = model;
            this.year = year;
        }
    }

    public static void convertCarToJson() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("Toyota", "Camry", 2022);
        String json = objectMapper.writeValueAsString(car);
        System.out.println(json);
    }

    // 3. Read JSON file and extract specific fields
    public static void extractFieldsFromJson(String filePath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        for (JsonNode node : rootNode) {
            System.out.println("Name: " + node.get("name").asText());
            System.out.println("Email: " + node.get("email").asText());
        }
    }

    // 4. Merge two JSON objects
    public static JsonNode mergeJsonObjects(JsonNode json1, JsonNode json2) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode merged = objectMapper.createObjectNode();
        merged.setAll((ObjectNode) json1);
        merged.setAll((ObjectNode) json2);
        return merged;
    }

    // 5. Validate JSON structure
    public static boolean validateJsonSchema(JsonNode jsonNode) {
        JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(new ObjectMapper());
        JsonSchema schema = schemaGen.generateSchema(jsonNode.getClass());
        JsonSchemaValidator validator = new JsonSchemaValidator();
        return validator.validate(jsonNode, schema);
    }

    // 6. Convert list of Java objects to JSON array
    public static void convertListToJsonArray() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Car> cars = Arrays.asList(new Car("Honda", "Civic", 2021), new Car("Ford", "Focus", 2019));
        String jsonArray = objectMapper.writeValueAsString(cars);
        System.out.println(jsonArray);
    }

    // 7. Parse JSON and filter records where age > 25
    public static void filterJsonByAge(String filePath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        }
    }

    // IPL and Censor Analyzer
    public static void censorIplData(String inputJson, String outputJson) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(inputJson));
        for (JsonNode node : rootNode) {
            ((ObjectNode) node).put("team1", node.get("team1").asText().replaceAll("(\w+) (\w+)", "$1 ***"));
            ((ObjectNode) node).put("team2", node.get("team2").asText().replaceAll("(\w+) (\w+)", "$1 ***"));
            ((ObjectNode) node).put("player_of_match", "REDACTED");
        }
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputJson), rootNode);
    }

    public static void censorIplCsv(String inputCsv, String outputCsv) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(inputCsv));
             CSVWriter writer = new CSVWriter(new FileWriter(outputCsv))) {
            List<String[]> allData = reader.readAll();
            for (int i = 1; i < allData.size(); i++) {
                allData.get(i)[1] = allData.get(i)[1].replaceAll("(\w+) (\w+)", "$1 ***");
                allData.get(i)[2] = allData.get(i)[2].replaceAll("(\w+) (\w+)", "$1 ***");
                allData.get(i)[6] = "REDACTED";
            }
            writer.writeAll(allData);
        }
    }

    public static void main(String[] args) throws Exception {
        createStudentJson();
        convertCarToJson();
        extractFieldsFromJson("users.json");
        convertListToJsonArray();
        filterJsonByAge("users.json");
        censorIplData("ipl.json", "ipl_censored.json");
        censorIplCsv("ipl.csv", "ipl_censored.csv");
    }
}
