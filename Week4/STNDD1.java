import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        int maxLengthFirstSplit = s.length() / 2;
        if (s.charAt(0) == '0' || s.length() == 1) {
            System.out.println("NO");
        } else {
            String str1 = "";
            String str2 = "";
            String tempNum = String.valueOf(s.charAt(0));

            for (int i = 1; i <= maxLengthFirstSplit; i++) {
                str1 = s.substring(0, i);
                str2 = s.substring(i, i + i);

                if (Long.parseLong(str2) - Long.parseLong(str1) == 1) {
                    tempNum = str1;

                } else {
                    if ((Long.parseLong(str1) + 1) == Long.parseLong(str2) * 10) {
                        tempNum = str1;
                    }
                }
            }

            String currentSequence = tempNum;
            Long nextNum = Long.parseLong(tempNum);
            String sSubString = "";
            while (currentSequence.length() <= s.length()) {
                nextNum++;
                currentSequence += String.valueOf(nextNum);
                if (currentSequence.length() <= s.length()) {
                    sSubString = s.substring(0, currentSequence.length());
                }
                if (sSubString.equals(currentSequence)) {
                    if (currentSequence.length() == s.length())
                        break;
                } else {
                    System.out.println("NO");
                    break;
                }
            }

            if (currentSequence.equals(s)) {
                System.out.println("YES " + tempNum);
            }

        }

    }

}

public class STNDD1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
