package wrap.java_concepts.comparable;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableTest {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList( new Student("abv",80),
                                                new Student("afd", 50),
                                                new Student("gfg", 70));
        //Collections.sort(students, (s1, s2) -> Integer.compare(s1.grade, s2.grade));
        Collections.sort(students, Comparator.comparingInt(s -> s.grade));
        System.out.println(students);
    }
}
