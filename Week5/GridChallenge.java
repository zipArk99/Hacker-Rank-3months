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

class Result1 {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        char[] characters = new char[grid.size()];
        List<String> strGrid = new ArrayList<>();
        int size = grid.size();
        characters = grid.get(0).toCharArray();
        Arrays.sort(characters);
        strGrid.add(String.valueOf(characters));
        for (int i = 1; i < size; i++) {
            characters = grid.get(i).toCharArray();
            Arrays.sort(characters);
            int val = strGrid.get(i - 1).compareTo(String.valueOf(characters));
            if (val <= 0)
                strGrid.add(String.valueOf(characters));
            else
                return "NO";
        }
        return "YES";

    }

}

public class GridChallenge {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
    
        for (int i = 0; i < testCase; i++) {
            List<String> strList=new ArrayList<>();
            int size=s.nextInt();

            for(int j=0; j<size; j++){
                strList.add(s.nextLine());
            }
            
            System.out.println(Result1.gridChallenge(strList));
            strList.clear();
        }

    }
}
