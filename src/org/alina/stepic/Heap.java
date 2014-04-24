package org.alina.stepic;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Heap {

    public static PriorityQueue<Integer> heap = new PriorityQueue<Integer>(1000, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1.equals(o2))
                return 0;
            if(o1 < o2)
                return 1;
            else
                return -1;
        }
    });

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while(n-- > 0) {
            String str = s.next();
            if(str.equals("Insert")) {
                insertToHeap(s.nextInt());
            }
            if(str.equals("Extract")) {
                System.out.println(getMax());
            }
        }
    }

    public static void insertToHeap(int number) {
        heap.add(number);
    }

    public static int getMax() {
        return heap.poll();

    }
}
