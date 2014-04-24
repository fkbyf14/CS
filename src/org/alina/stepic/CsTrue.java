/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.alina.stepic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author alina
 */
public class CsTrue {

    public static String cs(int n, Integer[] x) {

//        if (x.length == 0) {
//            return "False";
//        }
//
//        if (n > 2 && x.length == 1) {
//            return "False";
//        }
        if (n < 2 && x.length == 1) {
            return "True";
        }

        if (n == 0 && x.length != 0) {
            return "True";
        }
        Arrays.sort(x);
        int count = 1;

        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] == x[i + 1]) {
                count++;

                if (count > n / 2) {
                    return "True";
                }
            } else {
                count = 1;
            }
            if (i > (x.length - (n / 2) + 1) && count == 1) {
                return "False";
            }

        }
        return "False";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(s.hasNextInt()) {
            list.add(s.nextInt());
        } else {
            System.out.println("False");
            return;
        }
        
        String ss = s.nextLine();

        String[] strings = ss.split(" ");


        for (String string : strings) {

            if (!string.equals("")) {
                list.add(Integer.valueOf(string));
            }
        }
        System.out.print(cs(n,list.toArray(new Integer[0])));
    }
}
