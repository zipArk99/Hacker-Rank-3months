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
import java.time.*;

class Result {

    /*
    * Complete the 'timeConversion' function below.
    *
    * The function is expected to return a STRING.
    * The function accepts STRING s as parameter.
    */

    public static String timeConversion(String s) throws Exception{
        Date d=null;
        try{
            DateFormat dateFormat=new SimpleDateFormat("hh:mm:ss");
            d= dateFormat.parse(s);
            }catch(Exception exc){
                System.out.print(exc.toString());
            }
            d.
            return String.valueOf(d.);
           

        
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
