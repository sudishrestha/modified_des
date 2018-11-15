package des;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class convertHex {

    public String converts(String a) {
        String[] perm_value1 = new String[33];
        String finals = "";
        for (int i = 0; i < 16; i++) {
            int r = i * 4;
            int c = (i + 1) * 4;
            String temp = a.substring(r, c);
            switch (temp) {
                case "0000":
                    perm_value1[i] = "0";
                    break;
                case "0001":
                    perm_value1[i] = "1";
                    break;
                case "0010":
                    perm_value1[i] = "2";
                    break;
                case "0011":
                    perm_value1[i] = "3";
                    break;
                case "0100":
                    perm_value1[i] = "4";
                    break;
                case "0101":
                    perm_value1[i] = "5";
                    break;
                case "0110":
                    perm_value1[i] = "6";
                    break;
                case "0111":
                    perm_value1[i] = "7";
                    break;
                case "1000":
                    perm_value1[i] = "8";
                    break;
                case "1001":
                    perm_value1[i] = "9";
                    break;
                case "1010":
                    perm_value1[i] = "A";
                    break;
                case "1011":
                    perm_value1[i] = "B";
                    break;
                case "1100":
                    perm_value1[i] = "C";
                    break;
                case "1101":
                    perm_value1[i] = "D";
                    break;
                case "1110":
                    perm_value1[i] = "E";
                    break;
                case "1111":
                    perm_value1[i] = "F";
                    break;

            }

        }

        for (int i = 0; i < 16; i++) {
            finals += perm_value1[i];
        }
        return finals;
    }

    public String convertskey(String a) {
        String[] perm_value1 = new String[49];
        String finals = "";
        for (int i = 0; i < 12; i++) {
            int r = i * 4;
            int c = (i + 1) * 4;
            String temp = a.substring(r, c);
            switch (temp) {
                case "0000":
                    perm_value1[i] = "0";
                    break;
                case "0001":
                    perm_value1[i] = "1";
                    break;
                case "0010":
                    perm_value1[i] = "2";
                    break;
                case "0011":
                    perm_value1[i] = "3";
                    break;
                case "0100":
                    perm_value1[i] = "4";
                    break;
                case "0101":
                    perm_value1[i] = "5";
                    break;
                case "0110":
                    perm_value1[i] = "6";
                    break;
                case "0111":
                    perm_value1[i] = "7";
                    break;
                case "1000":
                    perm_value1[i] = "8";
                    break;
                case "1001":
                    perm_value1[i] = "9";
                    break;
                case "1010":
                    perm_value1[i] = "A";
                    break;
                case "1011":
                    perm_value1[i] = "B";
                    break;
                case "1100":
                    perm_value1[i] = "C";
                    break;
                case "1101":
                    perm_value1[i] = "D";
                    break;
                case "1110":
                    perm_value1[i] = "E";
                    break;
                case "1111":
                    perm_value1[i] = "F";
                    break;

            }

        }

        for (int i = 0; i < 12; i++) {
            finals += perm_value1[i];
        }
        return finals;
    }
}
