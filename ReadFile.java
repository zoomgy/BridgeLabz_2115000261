import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
