
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
    public static void separateNumbers(String s) {
        int maxLengthFirstSplit = s.length() / 2;
        if (s.charAt(0) == '0') {
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

                }
            }
            str2 += 0;
            if (!str1.isEmpty()) {
                if (Long.parseLong(str2) - Long.parseLong(str1) == 1) {
                    tempNum = str1;
                }
            }
            String nextNumber = String.valueOf(s.charAt(tempNum.length()));
            long currentSequence = Long.parseLong(tempNum);
            boolean isBeautiful = true;

            for (int i = tempNum.length() + 1; i <= s.length(); i++) {

                if ((currentSequence + 1) != Long.parseLong(nextNumber) && s.length() != i) {

                    nextNumber += s.charAt(i);
                }
                if (String.valueOf(currentSequence).length() < nextNumber.length()) {
                    if (String.valueOf(currentSequence).endsWith("9") && nextNumber.endsWith("0")) {
                        isBeautiful = true;
                        currentSequence = Long.parseLong(nextNumber);
                        if (i == s.length() - 1)
                            break;
                        i++;
                        nextNumber = String.valueOf(s.charAt(i));
                        continue;
                    } else {
                        isBeautiful = false;
                        System.out.println("NO");
                        break;
                    }
                }
                if ((currentSequence + 1) == Long.parseLong(nextNumber)) {
                    isBeautiful = true;
                    if (s.length() == i)
                        break;
                    currentSequence = Long.parseLong(nextNumber);
                    if (nextNumber.length() > 1 && i != s.length() - 1)
                        i++;

                    nextNumber = String.valueOf(s.charAt(i));

                }
                if (i >= s.length() - 1 && (currentSequence + 1) != Long.parseLong(nextNumber) && !isBeautiful) {
                    isBeautiful = false;
                }
            }

            if (isBeautiful) {
                System.out.println("YES " + tempNum);
            } else {
                System.out.println("NO");
            }
        }

    }

}

public class STN {
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
