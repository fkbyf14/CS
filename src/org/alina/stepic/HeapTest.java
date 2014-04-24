package org.alina.stepic;

import junit.framework.TestCase;

import java.util.Random;

/**
 * Created by dmitry.maksimov on 14.04.14.
 */
public class HeapTest extends TestCase {

    public void testSimpleSet() {
        Heap.insertToHeap(100);
        Heap.insertToHeap(10);
        assertEquals(100, Heap.getMax());
        Heap.insertToHeap(5);
        Heap.insertToHeap(50);
        assertEquals(50, Heap.getMax());
        Heap.insertToHeap(34534);
        Heap.insertToHeap(34634);
        Heap.insertToHeap(34544);
        Heap.insertToHeap(34534);
        Heap.insertToHeap(34534);
        Heap.insertToHeap(23453);

        assertEquals(34634, Heap.getMax());
        System.out.println(Heap.heap);
        Heap.heap.clear();
    }

    public void testRandom() {
        Random ran = new Random();
        int k = 0;
        int max1=0, max2=0;
        int n;
        while(k++ < 100000) {
            n = ran.nextInt(1000000000);
            if(max2 < n) {
                max1 = max2;
                max2 = n;
            } else if(max1 < n) {
                max1 = n;
            }
            Heap.insertToHeap(n);
        }
        assertEquals(max2, Heap.getMax());
        assertEquals(max1, Heap.getMax());
        Heap.heap.clear();
    }

    public void testSameMax() {
        Random ran = new Random();
        int k = 0;
        int max = 0;
        int n;
        while(k++ < 31) {
            n = (k % 10 == 0) ? 100 : ran.nextInt(99);
            Heap.insertToHeap(n);
            if(n<100 && max < n)
                max = n;
        }
        System.out.println(Heap.heap);

        assertEquals(100, Heap.getMax());
        assertEquals(100, Heap.getMax());
        assertEquals(100, Heap.getMax());
        assertEquals(max, Heap.getMax());
        System.out.println(Heap.heap);
        Heap.heap.clear();
    }
}
