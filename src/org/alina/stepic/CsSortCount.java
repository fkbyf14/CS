/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.alina.stepic;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author alina
 */
public class CsSortCount {

    public static int[] sort(int n) {
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 10);

        }
        Arrays.sort(a);

        return a;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (int i : sort(s.nextInt())) {
            System.out.print(i + " ");
        }
    }
}
