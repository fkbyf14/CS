package org.alina.stepic;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dmitry.maksimov on 10.10.14.
 */
public class MergeSort {
	static long inverse = 0;
	public static long[] merge(long[] z1, long[] z2){
		int s1 = z1.length - 1;
		int s2 = z2.length - 1;
		long[] res = new long[z1.length + z2.length];
		int pos = s1 + s2 + 1;
		long t = 0;
		for (; pos >= 0; ) {
			if (s1 >= 0 )
				t = z1[s1];
			if ((s2 < 0 || t > z2[s2]) && s1 >= 0) {
				res[pos] = t;
				pos--;
				inverse += s2 + 1;
				s1--;
			} else {
				res[pos] = z2[s2];
				pos--;
				s2--;
			}

		}
		return res;
	}
	public static long[] sort(long[] z){
		if(z.length ==2){
			if(z[0]>z[1]){
				long temp = z[0];
				z[0] = z[1];
				z[1] = temp;
				inverse++;
			}
			return z;
		}
		if(z.length ==1){
			return z;
		}

		long[] z1 = sort(Arrays.copyOf(z, z.length / 2));
		long[] z2 = sort(Arrays.copyOfRange(z, z.length / 2, z.length));
		return merge(z1, z2);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		long[] a = new long[n];
		for(int i = 0;i < n;i++){
			a[i] = s.nextLong();
		}

		sort(a);
		System.out.println(inverse);
	}
}
