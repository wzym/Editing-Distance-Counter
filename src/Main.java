import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        String[] strings = readFromFile();
        System.out.println(GetLevenshteinDistance(strings));
    }

    private int GetLevenshteinDistance(String[] strings) {
        return 0;
    }

    private String[] readFromFile() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Test.txt"));
        String[] result = new String[2];
        result[0] = bf.readLine();
        result[1] = bf.readLine();
        return result;
    }
}