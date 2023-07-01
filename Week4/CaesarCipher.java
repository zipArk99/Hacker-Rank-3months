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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        if (k >= 26) {
            k = k % 26;
        }
        String str = "";

        for (int i = 0; i < s.length(); i++) {

            int charAsciiValue = (int) s.charAt(i);
            int tempInc = charAsciiValue;
            if ((charAsciiValue >= 65 && charAsciiValue <= 90) || (charAsciiValue >= 97 && charAsciiValue <= 122)) {
                tempInc = tempInc + k;
                int extraInc = 0;
                if (tempInc > 122 && Character.isLowerCase(s.charAt(i))) {
                    extraInc = tempInc - 122;
                    tempInc = 96 + extraInc;

                } else if (tempInc > 90 && Character.isUpperCase(s.charAt(i))) {
                    extraInc = tempInc - 90;
                    tempInc = 64 + extraInc;
                }
            }
            str += (char) tempInc;

        }
        return str;

    }

}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        
        String s= Result.caesarCipher("1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M", 27);
        System.out.println(s);
    }
}
