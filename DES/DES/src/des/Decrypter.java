package des;

public class Decrypter {

    String app = "";
    private static final int[] E = {
        32, 1, 2, 3, 4, 5,
        4, 5, 6, 7, 8, 9,
        8, 9, 10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32, 1
    };

    //SBOX
    private int[][] s1 = {
        {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
        {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
        {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
        {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
    };
    private int[][] s2 = {
        {
            15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
        {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
        {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
        {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9
        }};
    private int[][] s3 = {
        {
            10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
        {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
        {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
        {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}

    };
    private int[][] s4 = {
        {
            7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
        {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
        {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
        {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}

    };
    private int[][] s5 = {
        {
            2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
        {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
        {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
        {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3
        }
    };
    private int[][] s6 = {
        {
            12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
        {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
        {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
        {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13
        }
    };
    private int[][] s7 = {
        {
            4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
        {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
        {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
        {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12
        }
    };
    private int[][] s8 = {
        {
            13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
        {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
        {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
        {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11
        }
    };

    private int[] P = {
        16, 7, 20, 21,
        29, 12, 28, 17,
        1, 15, 23, 26,
        5, 18, 31, 10,
        2, 8, 24, 14,
        32, 27, 3, 9,
        19, 13, 30, 6,
        22, 11, 4, 25
    };
    String[] perm_value = new String[49];
    String[] perm_value1 = new String[49];
    String[] perm_value2 = new String[49];

    public Decrypter(String text, String key) {
        String part1 = text.substring(0, 32);
        String part2 = text.substring(32);

        char[] cArray = part1.toCharArray();
        char[] cArray1 = key.toCharArray();

        for (int i = 0; i < 48; i++) {
            int asd = 0;
            asd = E[i] - 1;
            perm_value[i] = cArray[asd] + "";
        }
        String ap = "";
        for (int l = 0; l < 48; l++) {
            ap += perm_value[l];

            perm_value1[l] = cArray1[l] + "";

        }
        String ap3 = "";
        for (int n = 0; n < 48; n++) {

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

      //  System.out.println("48 bit key after expansion : \n" + ap + "\n***************Completion of encryption ***********************");
        //System.out.println("Key XOR text " + ap3);
        String test1 = ap3.substring(0, 6);
        String test2 = ap3.substring(6, 12);
        String test3 = ap3.substring(12, 18);
        String test4 = ap3.substring(18, 24);
        String test5 = ap3.substring(24, 30);
        String test6 = ap3.substring(30, 36);
        String test7 = ap3.substring(36, 42);
        String test8 = ap3.substring(42, 48);
        char[] cArr1 = test1.toCharArray();
        char[] cArr2 = test2.toCharArray();
        char[] cArr3 = test3.toCharArray();
        char[] cArr4 = test4.toCharArray();
        char[] cArr5 = test5.toCharArray();
        char[] cArr6 = test6.toCharArray();
        char[] cArr7 = test7.toCharArray();
        char[] cArr8 = test8.toCharArray();
        String[] row = new String[8];
        String[] col = new String[8];

        int[] row1 = new int[8];
        int[] col1 = new int[8];
        row[0] = cArr1[0] + "" + cArr1[5] + "";
        col[0] = cArr1[1] + "" + cArr1[2] + "" + cArr1[3] + "" + cArr1[4] + "";

        row[1] = cArr2[0] + "" + cArr2[5] + "";
        col[1] = cArr2[1] + "" + cArr2[2] + "" + cArr2[3] + "" + cArr2[4] + "";

        row[2] = cArr3[0] + "" + cArr3[5] + "";
        col[2] = cArr3[1] + "" + cArr3[2] + "" + cArr3[3] + "" + cArr3[4] + "";

        row[3] = cArr4[0] + "" + cArr4[5] + "";
        col[3] = cArr4[1] + "" + cArr4[2] + "" + cArr4[3] + "" + cArr4[4] + "";

        row[4] = cArr5[0] + "" + cArr5[5] + "";
        col[4] = cArr5[1] + "" + cArr5[2] + "" + cArr5[3] + "" + cArr5[4] + "";

        row[5] = cArr6[0] + "" + cArr6[5] + "";
        col[5] = cArr6[1] + "" + cArr6[2] + "" + cArr6[3] + "" + cArr6[4] + "";

        row[6] = cArr7[0] + "" + cArr7[5] + "";
        col[6] = cArr7[1] + "" + cArr7[2] + "" + cArr7[3] + "" + cArr7[4] + "";

        row[7] = cArr8[0] + "" + cArr8[5] + "";
        col[7] = cArr8[1] + "" + cArr8[2] + "" + cArr8[3] + "" + cArr8[4] + "";

        for (int i = 0; i < 8; i++) {
            row1[i] = Integer.parseInt(row[i], 2);
            col1[i] = Integer.parseInt(col[i], 2);
        }
        for (int i = 0; i < 8; i++) {
        }
        int s11 = s1[row1[0]][col1[0]];
        int s22 = s2[row1[1]][col1[1]];
        int s33 = s3[row1[2]][col1[2]];
        int s44 = s4[row1[3]][col1[3]];
        int s55 = s5[row1[4]][col1[4]];
        int s66 = s6[row1[5]][col1[5]];
        int s77 = s7[row1[6]][col1[6]];
        int s88 = s8[row1[7]][col1[7]];

        String b1 = new convertBcd().convertBcd1(s11);
        String b2 = new convertBcd().convertBcd1(s22);
        String b3 = new convertBcd().convertBcd1(s33);
        String b4 = new convertBcd().convertBcd1(s44);
        String b5 = new convertBcd().convertBcd1(s55);
        String b6 = new convertBcd().convertBcd1(s66);
        String b7 = new convertBcd().convertBcd1(s77);
        String b8 = new convertBcd().convertBcd1(s88);

        String bb = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8;
        char[] cArra = bb.toCharArray();

        for (int m = 0; m < 32; m++) {
            int asd = 0;
            asd = P[m] - 1;

            perm_value2[m] = cArra[asd] + "";

        }
        String apf = "";
        for (int l = 0; l < 32; l++) {
            apf += perm_value2[l];
        }
        String z = new valueXor().xore(apf, part2);

        String decrypted = z + part1;
        app = new convertHex().converts(decrypted);
        System.out.println("TEXT : " + app);
    }

    public String out() {
        return app;
    }
}
