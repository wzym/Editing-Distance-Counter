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
        int[] prev = new int[a.length() + 1];
        int[] cur = new int[a.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            cur[i] = i;
        }
        for (int bIndex = 1; bIndex <= b.length(); bIndex++) {
            int[] buf = cur;
            cur = prev;
            prev = buf;
            cur[0] = bIndex;
            for (int aIndex = 1; aIndex <= a.length(); aIndex++) {
                int up = prev[aIndex] + 1;
                int left = cur[aIndex - 1] + 1;
                int upLeft = prev[aIndex - 1] + getChangeCost(a.charAt(aIndex - 1), b.charAt(bIndex - 1));
                cur[aIndex] = Math.min(Math.min(up, left), upLeft);
            }
        }
        return cur[a.length()];
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