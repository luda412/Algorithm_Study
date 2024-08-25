package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 국영수 {
    static class Student {
        String name;
        int Kor;
        int Eng;
        int math;

        public Student(String name, int Kor, int Eng, int math) {
            this.name = name;
            this.Kor = Kor;
            this.Eng = Eng;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Student> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int Kor = Integer.parseInt(st.nextToken());
            int Eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Student(name, Kor, Eng, math));
        }

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.Kor == o2.Kor) {
                    if (o1.Eng == o2.Eng) {
                        if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.math - o1.math;
                    }
                    return o1.Eng - o2.Eng;
                }
                return o2.Kor - o1.Kor;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Student student : list){
            sb.append(student.name).append('\n');
        }
        System.out.println(sb);
    }
}
