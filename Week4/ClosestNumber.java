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
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
    Collections. sort(arr);
    int smallestDifference=Integer.MAX_VALUE;
    for(int i=arr.size()-1; i>0; i--){
        if(arr.get(i) - arr.get(i-1)<smallestDifference){
            smallestDifference=arr.get(i) - arr.get(i-1);            
        }
    }
    List<Integer> closIntegers=new ArrayList<>();
    for(int i=0; i<arr.size()-1; i++){
        if(arr.get(i+1) - arr.get(i)==smallestDifference){
            closIntegers.add(arr.get(i));
            closIntegers.add(arr.get(i+1));
        }
    }
    System.out.println("Smallest::"+smallestDifference);
    return closIntegers;
    

    }

}

public class ClosestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
