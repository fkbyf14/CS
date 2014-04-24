package org.alina.stepic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SameNumber {

    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while(s.hasNextInt()) {
            list.add(s.nextInt());
        }
        System.out.println(isHalfSame(n / 2, list));

    }

    enum Answer {
        T("True"),
        F("False");

        private String answer;
        Answer(String string) {
            this.answer = string;
        }
    }

    static String isHalfSame(int n, List<Integer> list) {
        if(list.isEmpty())
            return Answer.F.answer;
        if(n < 1)
            return Answer.T.answer;
        Collections.sort(list);
        int count = 0;
        int temp = list.get(0);
        for(int i : list) {
            if(temp == i) {
                count++;
                if(count > n)
                    return Answer.T.answer;
            } else {
                temp = i;
                count = 1;
            }
        }
        return Answer.F.answer;
    }
}