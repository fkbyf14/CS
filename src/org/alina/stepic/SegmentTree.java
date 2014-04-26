package org.alina.stepic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by dmitry.maksimov on 25.04.14.
 */
public class SegmentTree {
    public static void set(int i, int x, ArrayList list) {
        list.set(i, x);
    }

    public static int min(int l, int r, ArrayList list) {
        List list1 = list.subList(l, r + 1);
        int mn = (Integer) Collections.min(list1);

        /*for(int i=0; i<list1.size();i++){

        }
        */
        return mn;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (n-- > 0) {
            list.add(s.nextInt());
        }
        while (m-- > 0) {
            String str = s.next();
            if (str.equals("Set")) {
                set(s.nextInt() - 1, s.nextInt(), list);
            }
            if (str.equals("Min")) {
                System.out.println(min(s.nextInt() - 1, s.nextInt() - 1, list));
            }
        }
    }
}