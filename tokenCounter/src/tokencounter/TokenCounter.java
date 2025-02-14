/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tokencounter;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author edoua
 */
public class TokenCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String sentence=scan.nextLine();
        String search=scan.nextLine();
        StringTokenizer token=new StringTokenizer(sentence/**search**/);
        int count = token.countTokens();
        System.out.println("amount of tokens: "+count);
        for(int i=0;i<count;i++){System.out.println("Token at: "+i+" : "+token.nextToken());}
        
    }
    
}
