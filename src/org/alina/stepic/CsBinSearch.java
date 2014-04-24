/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.alina.stepic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alina
 */
public class CsBinSearch {


    public static int search(List<Long> a, List<Long> b) {


        boolean t = false;
        System.out.println();
        for (int i = 0; i < b.size(); i++) {
            int j = Collections.binarySearch(a, b.get(i));
            if (j < 0) {
                System.out.print(-1 + " ");
            } else {
                System.out.print((j + 1) + " ");
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        ArrayList<Long> list1 = new ArrayList<Long>();

        for (int i = 0; i < n; i++) {
            list1.add(s.nextLong());

        }
         long k = s.nextLong();
        ArrayList<Long> list2 = new ArrayList<Long>();

        for (int i = 0; i < n; i++) {
            list2.add(s.nextLong());

        }
        search(list1, list2);

    }
}
