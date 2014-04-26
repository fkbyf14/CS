package org.alina.stepic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by dmitry.maksimov on 26.04.14.
 */
public class DisjointSetUnion2 {
    static Set<Integer>[] a;

    public static  void union(int x, int y) {
        a[x].addAll(a[y]);
        a[y] = a[x];
    }

    public static String check(int x, int y) {
    if(a[x].contains(y)){
        return "True";
    }else return "False";
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        a = new Set[n];
        for (int i = 0; i < n; i++) {
            a[i] = new HashSet<Integer>();
            a[i].add(i);
        }
        while (m-- > 0) {
            String str = s.next();
            if (str.equals("Union")) {
                union(s.nextInt()-1, s.nextInt()-1);
            }
            if (str.equals("Check")) {
                System.out.println(check(s.nextInt()-1, s.nextInt()-1));
            }
        }
    }
}
