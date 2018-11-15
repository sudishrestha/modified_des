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
public class inversePermuation {

    String[] perm_value = new String[65];
    String ap = "";
    String full_binary = "";
    int IP1[] = {
        40, 8, 48, 16, 56, 24, 64, 32,
        39, 7, 47, 15, 55, 23, 63, 31,
        38, 6, 46, 14, 54, 22, 62, 30,
        37, 5, 45, 13, 53, 21, 61, 29,
        36, 4, 44, 12, 52, 20, 60, 28,
        35, 3, 43, 11, 51, 19, 59, 27,
        34, 2, 42, 10, 50, 18, 58, 26,
        33, 1, 41, 9, 49, 17, 57, 25
    };

    String out(String a) {
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
        char[] cArray1 = full_binary.toCharArray();
        for (int m = 0; m < 64; m++) {
            int asd = 0;
            asd = IP1[m] - 1;

            perm_value[m] = cArray1[asd] + "";

        }
        for (int l = 0; l < 64; l++) {
            ap += perm_value[l];
        }
        String re = new convertHex().converts(ap);
        return re;
    }

}
