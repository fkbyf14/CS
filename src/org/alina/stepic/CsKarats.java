/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alina.stepic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alina
 */
public class CsKarats {

    public static String[] karatsuba(Integer[] x, Integer[] y) {
//
//        ArrayList z1 = new ArrayList();
//        ArrayList z2 = new ArrayList();
//        ArrayList z3 = new ArrayList();
//        ArrayList z = new ArrayList();
        
        String str1 = "";
        String str2 = "";
        
        if (x.length <= 9 && y.length <= 9) {
            for (int i = 0; i <= (x.length); i++) {
                str1 += x[i];
            }
            Long x1 = new Long(str1);

            for (int j = 0; j <= (y.length); j++) {
                str2 += y[j];
            }
            Long y1 = new Long(str2);
            Long t1 = x1 * y1;
            String str = Long.toString(t1);
            String[] strs = str.split("");
            for (String string : strs) {

                System.out.print(string);
                
            }
            //return;
        }
            

           /* for (int i = 0; i <= (x.length) / 2; i++) {
                str1 += x[i];
            }
            Long xl = new Long(str1);

            for (int j = 0; j <= (y.length) / 2; j++) {
                str2 += y[j];
            }
            Long yl = new Long(str2);
            Long t1 = xl * yl;
            String str = Long.toString(t1);
            String[] strs = str.split("");
            for (String string : strs) {

                System.out.print(string);
            }
*/
//        String str3 = "";
//        String str4 = "";
//        for (int i = 0; i > (x.length) / 2; i++) {
//            str1 += x[i];
//        }
//        Long xr = new Long(str1);
//
//        for (int j = 0; j > (y.length) / 2; j++) {
//            str2 += y[j];
//        }
//        Long yr = new Long(str2);
//        Long t2 = xr * yr;
//
//        Long t3=(xl+xr)*(yl+yr);
//       Long t=t1*(Long)(Math.pow(10, (x.length+y.length)/2))+xl*yr*(Long)(Math.pow(10, (x.length)/2))+xr*yl*(Long)(Math.pow(10, (y.length)/2))+t2;
            return null;

        }



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        s.nextLine();
        while (s.hasNextInt()) {
            list.add(s.nextInt());
        }

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        s.nextLine();
        while (s.hasNextInt()) {
            list1.add(s.nextInt());
        }
        // karatsuba(s.nextInt(), s.nextInt());
        System.out.print(karatsuba(list.toArray(new Integer[list.size()]), list.toArray(new Integer[list.size()])));
//        for (int i : karatsuba(s.nextInt(),s.nextInt())) {
//            System.out.print(i + " ");
//        }
    }
}
