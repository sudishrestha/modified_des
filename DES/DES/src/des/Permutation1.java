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

class Permutation1 {

    String[] perm_value = new String[65];
    String ap = "";
    String full_binary = "";

    public Permutation1(String input_value) {
        int IP1[] = {
            58, 50, 42, 34, 26, 18, 10, 2,
            60, 52, 44, 36, 28, 20, 12, 4,
            62, 54, 46, 38, 30, 22, 14, 6,
            64, 56, 48, 40, 32, 24, 16, 8,
            57, 49, 41, 33, 25, 17, 9, 1,
            59, 51, 43, 35, 27, 19, 11, 3,
            61, 53, 45, 37, 29, 21, 13, 5,
            63, 55, 47, 39, 31, 23, 15, 7
        };

        full_binary = new convertToBinary(input_value).out();

        char[] cArray1 = full_binary.toCharArray();

        for (int m = 0; m < 64; m++) {
            int asd = 0;
            asd = IP1[m] - 1;

            perm_value[m] = cArray1[asd] + "";

        }
        for (int l = 0; l < 64; l++) {
            ap += perm_value[l];
        }
    }

    public String tex() {
        return ap;
    }

}
