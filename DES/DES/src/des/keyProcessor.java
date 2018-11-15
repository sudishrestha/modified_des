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
import java.util.*;

class keyProcessor {

    String[] perm_value = new String[65];
    String[] perm_value22 = new String[49];
    String[] perm_value1 = new String[65];
    String[] key = new String[16];
    String[] xorKey = new String[57];
    String[] l1 = new String[57];
    String ap22 = "";
    String[] l2 = new String[57];
    String full_binary = "";
    int counter = 0;

    public keyProcessor(String input_value) {
        //initial permutation
        int PC1[] = {
            57, 49, 41, 33, 25, 17, 9,
            1, 58, 50, 42, 34, 26, 18,
            10, 2, 59, 51, 43, 35, 27,
            19, 11, 3, 60, 52, 44, 36,
            63, 55, 47, 39, 31, 23, 15,
            7, 62, 54, 46, 38, 30, 22,
            14, 6, 61, 53, 45, 37, 29,
            21, 13, 5, 28, 20, 12, 4
        };
        int PC2[] = {
            121, 113, 105, 97, 89, 81, 73,
            65, 122, 114, 106, 98, 90, 82,
            74, 66, 123, 115, 107, 99, 91,
            83, 75, 67, 124, 116, 108, 100,
            127, 119, 111, 103, 95, 87, 79,
            71, 126, 118, 110, 102, 94, 86,
            78, 70, 125, 117, 109, 101, 93,
            85, 77, 69, 92, 84, 76, 68,};
        int PC3[] = {
            14, 17, 11, 24, 1, 5, 3, 28,
            15, 6, 21, 10, 23, 19, 12, 4,
            26, 8, 16, 7, 27, 20, 13, 2,
            41, 52, 31, 37, 47, 55, 30, 40,
            51, 45, 33, 48, 44, 49, 39, 56,
            33, 53, 46, 42, 50, 36, 29, 32,};
        int shifter[] = {
            1, 1, 2, 2, 2, 2, 2, 2,
            1, 2, 2, 2, 2, 2, 2, 1,};
//change position as initial permutation
        char[] cArray = input_value.toCharArray();
        int j = input_value.length();
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
        String part1 = full_binary.substring(0, 64);
        String part2 = full_binary.substring(64);
        char[] cArray1 = part1.toCharArray();
        String ap = "";
        int sum = 0;
        for (int m = 0; m < 56; m++) {
            int asd = 0;

            asd = PC1[m];

            perm_value[m] = cArray1[asd] + "";

        }

        char[] cArray2 = part2.toCharArray();
        String ap2 = "";
        String ap3 = "";
        int sum2 = 0;
        for (int m = 0; m < 56; m++) {
            int asd = 0;
            asd = PC2[m] - 64;

            perm_value1[m] = cArray2[asd] + "";

        }
        for (int l = 0; l < 56; l++) {
            ap += perm_value[l];
            ap2 += perm_value1[l];
        }

        for (int n = 0; n < 56; n++) {

            if (perm_value[n].equals("0") && perm_value1[n].equals("0")) {
                ap3 = ap3 + "0";
            } else if (perm_value[n].equals("0") && perm_value1[n].equals("1")) {
                ap3 += "1";
            } else if (perm_value[n].equals("1") && perm_value1[n].equals("0")) {
                ap3 += "1";
            } else if (perm_value[n].equals("1") && perm_value1[n].equals("1")) {
                ap3 += "0";
            }

        }
        //Divide 58 bits into 28 bits each
        char[] cArray3 = ap3.toCharArray();
        String l3 = "";
        String l4 = "";
        for (int s = 0; s < 57; s++) {
            if (s < 28) {
                l3 += cArray3[s] + "";
            } else if (s < 56) {
                l4 += cArray3[s] + "";
            }

        }
        for (int i = 0; i < 16; i++) {
            int s = shifter[counter];

            String shifted1 = l3.substring(s) + l3.substring(0, s);
            String shifted2 = l4.substring(s) + l4.substring(0, s);
            String total_shift = shifted1 + shifted2;
            l3 = shifted1;
            l4 = shifted2;
            char[] cArray22 = total_shift.toCharArray();

            for (int m = 0; m < 48; m++) {
                int asd = 0;
                asd = PC3[m] - 1;

                perm_value22[m] = cArray22[asd] + "";

            }
            for (int l = 0; l < 48; l++) {
                ap22 += perm_value22[l];
            }
            key[i] = ap22;
            ap22 = "";
            counter++;
        }
        counter = 0;
    }

    public String[] key() {
        return key;
    }
}
