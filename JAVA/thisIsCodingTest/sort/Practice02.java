package aloneBook.sort;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//p.180 성적이 낮은 순서로 학생 출력하기
public class Practice02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Student> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(new Student(sc.next(), sc.nextInt()));
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(Student s: list){
            sb.append(s.name).append(" ");
        }
        System.out.println(sb.toString());
    }
}

class Student implements Comparable<Student> {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.score);
    }
}