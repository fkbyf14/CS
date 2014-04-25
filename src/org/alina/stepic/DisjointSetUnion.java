package org.alina.stepic;

import java.util.Scanner;


public class DisjointSetUnion {
    int[] ss;
    int[] rank;
public DisjointSetUnion(int size) {

    ss = new int[size];
    rank = new int[size];
    for (int i = 0; i < size; i++) {
        ss[i] = i;
    }
}
    public int root(int x){
        if(ss[x]!=x){
            ss[x]= root(ss[x]);
        }
        return ss[x];
    }

    public  void union(int a,int b) {
        a = root(a);
        b = root(b);
        if (rank[a] < rank[b]){
            ss[a]=b;
        }else{
            ss[b]=a;
            if(rank[a]==rank[b]){
                rank[a]++;
            }
        }
    }
    public  String check(int a,int b){
        a = root(a);
        b = root(b);
        if (a==b){
            return "True";
        }else
            return "False";
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        DisjointSetUnion ds = new DisjointSetUnion(s.nextInt());
        while(m-- > 0) {
            String str = s.next();
            if(str.equals("Union")) {
                ds.union(s.nextInt(), s.nextInt());
            }
            if(str.equals("Check")) {
                System.out.println(ds.check(s.nextInt(), s.nextInt()));
            }
        }
    }
}