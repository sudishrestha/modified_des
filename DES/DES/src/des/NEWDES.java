/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des;

//import dissertation.Permutation1;
import java.util.*;

class NEWDES {

    public static void main(String[] args) {
        //String input_text = new Scanner(System.in).nextLine();
        //System.out.println(input_text);
        
         System.out.println("************TAKE INPUT*********************");
         System.out.println("Enter 16 bit hexadecimal text");
        //String input_text = "012AAA789AABCDEF";
        //String input_key = "FEDCBA09876543211234567890ABCDEF";
        String input_text = new Scanner(System.in).nextLine();
        System.out.println("Enter 32 bit hexadecimal key");
        String input_key = new Scanner(System.in).nextLine();
       
        System.out.println("INPUT TEXT:(64 bit) " + input_text);
        System.out.println("INPUT KEY:(128 bit)  " + input_key);
try{
    System.out.println("*********************************************ENCRYPTION STARTS********************************************** ");

        String a = new Permutation1(input_text).tex();

        String[] b = new keyProcessor(input_key).key();

        String[] asdf = new String[16];
        asdf[0] = a;
        String l = "";
        for (int i = 0; i < 16; i++) {

            asdf[i] = new GetTextKey(a, b[i]).out();
            System.out.println("****************iteration" + (i + 1) + "**********************************");
            // System.out.println("KEY :" + b[i]);
            System.out.println("Cipher Text :" + asdf[i]);
            System.out.println("KEY =" + new convertHex().convertskey(b[i]));
            System.out.println("************************************************************");

            a = new convertToBinary(asdf[i]).out();     //new Permutation1(input_key)

        }
        String finalvalue = new inversePermuation().out(asdf[15]);
        System.out.println("Final Cipher Text after Inverse Permuation: \n" + finalvalue);
        System.out.println("************************************************************");

        System.out.println("**************************************************Decryption Starts***************************************");

        String a11 = new DEC1(finalvalue).out();
        String asd = "";

        int counter = 1;
        for (int i = 15; i >= 0; i--) {
            System.out.println("**************ITERATION " + counter + "*********************");
            asd = new Decrypter(a11, b[i]).out();
            a11 = new convertToBinary(asd).out();
            System.out.println("KEY =" + new convertHex().convertskey(b[i]));
            counter++;
        }
        String decr = new lastPermutation(asd).out();
        System.out.println("*****************************************************FINAL DECRYPTED TEXT*********************************************");
        System.out.println("DECRYPTED TEXT : " + decr);

        System.out.println("***********************************************************************************************************************");
        
        System.out.println(input_text + " <==========DES===========> " + finalvalue);
}
catch(Exception ex)
{
System.out.println("PLEASE INPUT VALID VALUE ONLY!!!");
}
}
}
