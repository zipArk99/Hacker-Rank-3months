import java.io.*;
import java.math.*;
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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    
    int maximum=0;
    int minimum=0;
    int temp;
    List<Integer> breakRecordsCounter=new ArrayList<Integer>();
    for(int i=0; i<scores.size(); i++){
        if(i!=0){
            if(scores.get(i)>maximum){
                maximum=scores.get(i);
                temp=breakRecordsCounter.get(0);
                breakRecordsCounter.set(0,++temp);
            }else if(scores.get(i)<minimum){
                minimum=scores.get(i);
                temp=breakRecordsCounter.get(1);
                breakRecordsCounter.set(1,++temp);
            }
            
        }else{
            breakRecordsCounter.add(0);
            breakRecordsCounter.add(0);
            maximum=scores.get(i);
            minimum=scores.get(i);
        }
    }
    return breakRecordsCounter;
    

    }

}

public class BreakingTheRecord {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

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
