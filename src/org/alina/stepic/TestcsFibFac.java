/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.alina.stepic;

import java.util.Scanner;

/**
 *
 * @author alina
 */
class TestcsFibFac {

    public int fib2(int n) {
        int i;
        if (n <= 1) {
            return 1;
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        int[] f1 = new int[n + 1];
        f1[0] = 0;
        f1[1] = 1;
        for (i = 2; i <= n; i++) {
            
            f[i] = (f[i - 1] + f[i - 2]);
        }
        return f[n];
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(new TestcsFibFac().fib2(s.nextInt()));
//        int a = s.nextInt();
//        int b = s.nextInt();
//        System.out.println(a+b);
    }
}
