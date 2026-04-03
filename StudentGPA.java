import java.util.*;

public class StudentGPA {
    public static void main(String[] args) {
        // a. Create a map: student name -> GPA
        Map<String, Double> studentMap = new HashMap<>();

        // b. Add students to the map
        studentMap.put("Alice",   3.9);
        studentMap.put("Bob",     3.4);
        studentMap.put("Charlie", 3.9);
        studentMap.put("Diana",   2.8);
        studentMap.put("Eve",     3.6);
        studentMap.put("Frank",   2.5);
        studentMap.put("Grace",   3.1);

        System.out.println("---Students' GPA");
        studentMap.forEach((name, gpa) ->
        System.out.printf("  %-10s -> %.1f%n", name, gpa));

        // c. Find the student(s) with the highest GPA
        double maxGPA = Collections.max(studentMap.values());
        System.out.println("\n---Highest GPA");
        for (Map.Entry<String, Double> entry : studentMap.entrySet()) {
            if (entry.getValue() == maxGPA) {
                System.out.printf("  %-10s -> %.1f%n", entry.getKey(), entry.getValue());
            }
        }

        // d. Find the average GPA
        double averageGPA = studentMap.values().stream()
        .mapToDouble(Double::doubleValue)
        .average()
        .orElse(0.0);
        System.out.printf("\n---Average GPA: %.2f", averageGPA);

        // e. Find the number of students with GPA below average
        long belowAverage = studentMap.values().stream()
        .filter(gpa -> gpa < averageGPA)
        .count();

        System.out.println("\n\n---Students Below Average GPA");
        System.out.println("  Count: " + belowAverage);
        studentMap.entrySet().stream()

        .filter(e -> e.getValue() < averageGPA)
        .forEach(e -> System.out.printf("  %-10s -> %.1f%n",
        e.getKey(), e.getValue()));
    }
}
