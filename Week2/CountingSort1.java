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
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
    
    
    List<Integer> countList=Arrays.asList(new Integer [arr.size()]);
    Collections.fill(countList,0);
    
    for(int i=0; i<arr.size(); i++){
        int pos=arr.get(i);
        int ele=countList.get(pos);
        countList.set(pos, ++ele);
    }
     
    for(int x : countList){
        System.out.print(" "+x);
    }
    
    return countList;
    
    

    }

}

public class CountingSort1 {
    public static void main(String[] args) throws IOException {
      Scanner input=new Scanner(System.in);
        List<Integer> arr=new ArrayList<>();
        int size=input.nextInt();

        for(int i=0; i<size; i++){
            arr.add(input.nextInt());
        }

        Result.countingSort(arr);

      
    }
}
