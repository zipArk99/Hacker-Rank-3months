import java.io.*;
import java.util.*;

public class CamelCase4 {

    public static void main(String[] args) {
     Scanner scanner=new Scanner(System.in);
    
     while(scanner.hasNextLine()){
         
         char [] ch=scanner.nextLine().toCharArray();
         char operation=ch[0];
         char type=ch[2];
         
         for(int i=4; i<ch.length-1; i++){
             if(operation=='S'){  
                System.out.print(Character.toLowerCase (ch[i]));
                if(Character.isUpperCase(ch[i+1]) && ch[i+1]!='(' ){
                    System.out.print(" ");
                    System.out.print(Character.toLowerCase(ch[i+1]));
                    i++;
                   // char low=Character.toLowerCase(ch[i+1]);
                   // ch[i+1]=low;
                }
                else if(ch[i+1]=='('){
                    break;
                }
             }
             else{
                 if(i==4 && type=='C'){
                     System.out.print(Character.toUpperCase(ch[i]));
                 }
                 else if(Character.isWhitespace(ch[i])){
                     i++;
                     System.out.print(Character.toUpperCase(ch[i]));
                 }else{
                System.out.print(ch[i]);                 
                 }
             }
             
         } 
         if((operation=='S' && ch[ch.length-2]!='(') || (operation=='C'))
         System.out.print(ch[ch.length-1]);
         if(type=='M' && operation=='C')
         System.out.print("()");
         System.out.println();
     }
     
}
}
