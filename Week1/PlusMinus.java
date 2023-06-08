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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    static double minusCounter=0;
    static double plusCounter=0;
    static double zeroCounter=0;
    public static void plusMinus(List<Integer> arr) {
    for(int x : arr){
        if(x>0){
            plusCounter+=1;
        }else if(x<0){
            minusCounter+=1;
        }else{
            zeroCounter+=1;         
        }
    }
    
    System.out.println(String.format("%.6f",+plusCounter/arr.size()));
     System.out.println(String.format("%.6f",+minusCounter/arr.size()));
      System.out.println(String.format("%.6f",+zeroCounter/arr.size()));

    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
