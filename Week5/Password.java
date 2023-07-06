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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    int counter=0;
        Pattern number= Pattern.compile("[0-9]+");
        Pattern lowerLetters= Pattern.compile("[a-z]+");
        Pattern upperLetter= Pattern.compile("[A-Z]+");
        Pattern specialCharacter =  Pattern.compile("[^a-zA-Z0-9]");
        
    if(!number.matcher(password).find())
    counter++;
    
    if(!lowerLetters.matcher(password).find())
    counter++;
    
    if(!upperLetter.matcher(password).find())
    counter++;
    
    if(!specialCharacter.matcher(password).find())
    counter++;
    
    if((counter+n)<6){
        
        counter+=6-(counter+n);
    }
  
    return counter;
    }
}

public class Password {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
