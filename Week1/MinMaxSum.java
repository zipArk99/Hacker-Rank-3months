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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        long min=0;
        long max=0;
        
        
        //System.out.println(arr.subList(0,3));
        //System.out.println(arr.subList(arr.size()-1,arr.size()-4));
        for(int i=0; i<4; i++){
            min+=arr.get(i);
        }
        for(int i=arr.size()-1; i>=arr.size()-4; i--){
            max+=arr.get(i);
        }
        System.out.print(min+" ");
        System.out.print(max);
       
    }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
