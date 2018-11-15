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
public class convertBcd {

    public String convertBcd1(int a) {
        String as = "";
        switch (a) {
            case 0:
                as = "0000";
                break;
            case 1:
                as = "0001";
                break;
            case 2:
                as = "0010";
                break;
            case 3:
                as = "0011";
                break;
            case 4:
                as = "0100";
                break;
            case 5:
                as = "0101";
                break;
            case 6:
                as = "0110";
                break;
            case 7:
                as = "0111";
                break;
            case 8:
                as = "1000";
                break;
            case 9:
                as = "1001";
                break;
            case 10:
                as = "1010";
                break;
            case 11:
                as = "1011";
                break;
            case 12:
                as = "1100";
                break;
            case 13:
                as = "1101";
                break;
            case 14:
                as = "1110";
                break;
            case 15:
                as = "1111";
                break;

        }

        return as;
    }

}
