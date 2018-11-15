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
/**
 *
 * @author User
 */
public class lastPermutation {

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
    String app;
    String c = "";

    public lastPermutation(String a) {

        String b = new convertToBinary(a).out();
        String[] ip = new String[64];
        char[] cArray1 = b.toCharArray();
        for (int i = 0; i < 64; i++) {
            int asd = 0;
            asd = IP1[i] - 1;
            ip[asd] = cArray1[i] + "";
        };
        for (int i = 0; i < 64; i++) {
            c += ip[i];
        }

        app = new convertHex().converts(c);
    }

    String out() {
        return app;
    }
}
