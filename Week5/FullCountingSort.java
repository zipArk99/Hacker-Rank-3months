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
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        
       
        TreeMap<Integer,StringBuilder> arrStr2=new TreeMap<>();
      
            int index=0;
            StringBuilder str=new StringBuilder();
            int size=arr.size();
        for (int i = 0; i < size; i++) {

            index = Integer.parseInt(arr.get(i).get(0));
             str.append(arr.get(i).get(1)).append(" ");
              if(arrStr2.containsKey(index)){
                arrStr2.get(index).append((i > (size / 2)-1)?str:"- " );
            }else{
                arrStr2.put(index,new StringBuilder((i > (size / 2)-1)?str:"- "));
               // arrStr2.get(index).append(((i > (size / 2)-1)?str:"-"));
            }
            str.setLength(0);          

        }

      for(Map.Entry<Integer,StringBuilder> map : arrStr2.entrySet()){
          System.out.print(map.getValue());
          
      }

    }

}

public class FullCountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}
