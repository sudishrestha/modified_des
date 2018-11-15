/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package des;

/**
 *
 * @author User
 */
public class convertToBinary {

    String full_binary = "";

    public convertToBinary(String a) {
        char[] cArray = a.toCharArray();
        int j = a.length();
        for (int i = 0; i < j; i++) {
            switch (cArray[i]) {
                case '0':
                    full_binary += "0000";
                    break;
                case '1':
                    full_binary += "0001";
                    break;
                case '2':
                    full_binary += "0010";
                    break;
                case '3':
                    full_binary += "0011";
                    break;
                case '4':
                    full_binary += "0100";
                    break;
                case '5':
                    full_binary += "0101";
                    break;
                case '6':
                    full_binary += "0110";
                    break;
                case '7':
                    full_binary += "0111";
                    break;
                case '8':
                    full_binary += "1000";
                    break;
                case '9':
                    full_binary += "1001";
                    break;
                case 'A':
                    full_binary += "1010";
                    break;
                case 'B':
                    full_binary += "1011";
                    break;
                case 'C':
                    full_binary += "1100";
                    break;
                case 'D':
                    full_binary += "1101";
                    break;
                case 'E':
                    full_binary += "1110";
                    break;
                case 'F':
                    full_binary += "1111";
                    break;

            }

        }

    }

    String out() {
        return full_binary;
    }

}
