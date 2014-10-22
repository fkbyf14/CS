package org.alina.stepic;

import java.util.*;

/**
 * Created by dmitry.maksimov on 22.04.14.
 */
public class QuickSort {
	static class Section {
		int x;
		int y;
		int length;

		Section(int x, int y) {
			this.x = x;
			this.y = y;
			this.length = y - x;
		}

		boolean consist(Section s) {
			return (x <= s.x && y >= s.y);
		}

		public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}

	static class CompareLeft implements Comparator<Section> {

		@Override
		public int compare(Section o1, Section o2) {
			if (o1.x == o2.x && o1.y == o2.y) {
				return 0;
			} else if (o1.x < o2.x || (o1.x == o2.x && o1.length > o2.length)) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	/*static class CompareRight implements Comparator<Section> {

		@Override
		public int compare(Section o1, Section o2) {
			if (o1.x == o2.x && o1.y == o2.y) {
				return 0;
			} else if (o1.y > o2.y || (o1.y == o2.y && o1.length > o2.length)) {
				return 1;
			} else {
				return -1;
			}
		}
	}
*/
	public static void main(String[] args) {
		final CompareLeft compLeft = new CompareLeft();
		//final CompareRight compRight = new CompareRight();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		ArrayList<Section> left = new ArrayList<Section>();
		//ArrayList<Section> right = new ArrayList<Section>();
		while (n-- > 0) {
			Section sec = new Section(s.nextInt(), s.nextInt());
			left.add(sec);
			//right.add(sec);
		}

		Collections.sort(left, compLeft);
		//Collections.sort(right, compRight);

		//System.out.println(left);
		for (int j = 0; j < m; j++) {
			int t = s.nextInt();
			final Section se = new Section(t, t);
			int count = 0;
			int i = 0;
			while (i < left.size() && left.get(i).x <= se.x) {
				if (left.get(i).consist(se))
					count++;
				i++;
			}
			System.out.print(count + " ");
		}
	   /*     int t = s.nextInt();

            final Section se = new Section(t, t);

            Comparator<Section> temp = new Comparator<Section>() {

                @Override
                public int compare(Section o1, Section o2) {
                    if((o1.consist(se) && o2.consist(se)) ||
                            (!o1.consist(se) && !o2.consist(se)))
                    {
                        return compRight.compare(o1, o2);
                    } else if(o1.consist(se) && !o2.consist(se)) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            };
            Collections.sort(left, temp);
           // System.out.println(left);
            int index1 = -(Collections.binarySearch(left, se, temp)) - 1;

            System.out.print(left.size() - index1 + " ");

        }
*/
	}
}