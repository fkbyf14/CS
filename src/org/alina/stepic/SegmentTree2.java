package org.alina.stepic;

import java.util.*;

/**
 * Created by dmitry.maksimov on 26.04.14.
 */
public class SegmentTree2 {
    static int[][] tree;
    static int k;
    static int l;

    public static void fill(){
        int z=0;
        for(int j=1; j < k ;j++){
            tree[j] = new int[(tree[j-1].length)/2];
            for(int i = 0; i < (tree[j-1].length)/2; i++){
                tree[j][i] = Math.min(tree[j - 1][z], tree[j - 1][z + 1]);
                z+=2;
            }
           /* System.out.println("j=" + j + " tree = ");
            for (int ints : tree[j]) {
                System.out.print(" " + ints);

            }*/
            z=0;
        }
    }
    public static void set(int i,int x){

        int tempI=i;
        tree[0][tempI]=x;
        for(int j=1; j < k; j++){
           int y = tempI/2;
            int ost = tempI%2;
            System.out.println("y=" + y + ", j=" + j + ", tempI=" + tempI);
            if(ost!=0){
                tree[j][y] = Math.min(tree[j-1][tempI],tree[j-1][tempI-1]);
            }else{
                tree[j][y] = Math.min(tree[j-1][tempI],tree[j-1][tempI+1]);
            }
        tempI = y;

        }
    }
    private static int getK(int l) {
        switch (l){
            case 1:
                return 1;
            case 2:
                return 2;
            case 4:
                return 3;
            case 8:
                return 4;
            case 16:
                return 5;
            case 32:
                return 6;
            case 64:
                return 7;
            case 128:
                return 8;
            case 256:
                return 9;
            case 512:
                return 10;
            case 1024:
                return 11;
            case 2048:
                return 12;
            case 4096:
                return 13;
            case 8192:
                return 14;
            case 16384:
                return 15;
            case 32768:
                return 16;
            case 65536:
                return 17;
            case 131072:
                return 18;
            default:
                return -1;
        }
    }

    private static int min(int i, int j) {
        int temp = j - i +1;
        System.out.println("i=" + i + ", j=" + j + ", temp=" + temp );
        if(i == j)
            return tree[0][i];
        if(getK( temp ) != -1 && (j + 1) % temp == 0)
            return tree[getK(temp)][(j + 1) / temp - 1];
        int powTwo = Integer.highestOneBit(temp);
        System.out.println("powTwo=" + powTwo + " ");

        temp = ( (j + 1) / powTwo) * powTwo;
        //System.out.println("temp" + temp);
        if(temp != j + 1)
            return Math.min(min(i, temp - 1), min(temp, j));
        else
            return Math.min(min(i, temp - powTwo), min(temp - powTwo + 1, j));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        l = Integer.highestOneBit(n) * 2;
        if(l == n * 2)
            l /= 2;
        k = getK(l);
        tree = new int[k][];
        tree[0] = new int[l];
        for (int i = 0; i < l; i++) {
            tree[0][i] = i < n ? s.nextInt() : 1000000004;
        }
        fill();
        while (m-- > 0) {
            String str = s.next();
            if (str.equals("Set")) {
                set(s.nextInt() - 1, s.nextInt());
            }
            if (str.equals("Min")) {
                System.out.println(min(s.nextInt() - 1, s.nextInt() - 1));
            }
        }
    }


}