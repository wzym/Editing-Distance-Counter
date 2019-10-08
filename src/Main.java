import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        String[] strings = readStrings();
        System.out.println(getLevenshteinDistance(strings));
    }

    private int getLevenshteinDistance(String[] strings) {
        String a = strings[0];
        String b = strings[1];
        int [][] distances = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            distances[i][0] = i;
        }
        for (int i = 0; i <= b.length(); i++) {
            distances[0][i] = i;
        }
        for (int bIndex = 1; bIndex <= b.length(); bIndex++) {
            for (int aIndex = 1; aIndex <= a.length(); aIndex++) {
                int up = distances[aIndex][bIndex - 1];
                int left = distances[aIndex - 1][bIndex];
                int upLeft = distances[aIndex - 1][bIndex - 1];
                int changeCost = getChangeCost(a.charAt(aIndex - 1), b.charAt(bIndex - 1));
                int curMin = Math.min(Math.min(up + 1, left + 1), upLeft + changeCost);
                distances[aIndex][bIndex] = curMin;
            }
        }
        return distances[a.length()][b.length()];
    }

    private int getChangeCost(char a, char b) {
        return a == b ? 0 : 1;
    }

    private String[] readStrings() throws IOException {
        //BufferedReader bf = new BufferedReader(new FileReader("Test.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] result = new String[2];
        result[0] = bf.readLine();
        result[1] = bf.readLine();
        return result;
    }
}