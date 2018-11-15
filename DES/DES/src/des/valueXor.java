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
public class valueXor {

    public String xore(String a, String b) {
        char[] cArray1 = a.toCharArray();
        char[] cArray2 = b.toCharArray();
        String[] perm_value = new String[33];
        String[] perm_value1 = new String[33];
        for (int i = 0; i < 32; i++) {
            perm_value[i] = cArray1[i] + "";
            perm_value1[i] = cArray2[i] + "";
        }
        String ap3 = "";
        for (int n = 0; n < 32; n++) {

            if (perm_value[n].equals("0") && perm_value1[n].equals("0")) {
                ap3 += "0";
            } else if (perm_value[n].equals("0") && perm_value1[n].equals("1")) {
                ap3 += "1";
            } else if (perm_value[n].equals("1") && perm_value1[n].equals("0")) {
                ap3 += "1";
            } else if (perm_value[n].equals("1") && perm_value1[n].equals("1")) {
                ap3 += "0";
            }

        }

        return ap3;
    }

}
