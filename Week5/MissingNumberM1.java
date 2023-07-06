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
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
    TreeMap<Integer,Integer> arrMap=new TreeMap<>();
    TreeMap<Integer,Integer> brrMap=new TreeMap<>();
    List<Integer> array=new ArrayList<>();
    for(int i=0; i<brr.size(); i++){
        int temp=0;
        int brrKey=brr.get(i);
        if(brrMap.containsKey(brrKey)){
            temp =brrMap.get(brrKey);
            brrMap.replace(brrKey,++temp);
        }else{
            brrMap.put(brrKey, 1);
        }
        
        if(i<arr.size()){
            int arrKey=arr.get(i);
              if(arrMap.containsKey(arrKey)){
            temp =arrMap.get(arrKey);
            arrMap.replace(arrKey,++temp);
        }else{
            arrMap.put(arrKey, 1);
        }
        }
    }
    
    for(Map.Entry<Integer,Integer> map: brrMap.entrySet()){
        int key=map.getKey();
        if(arrMap.containsKey(key) && map.getValue() <= arrMap.get(key)){
            continue;
        }
     array.add(key);   
    }
return array;
    }

}

public class MissingNumberM1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

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
