import java.util.ArrayList;
import java.util.Random;

public class Course {
    private final String name;
    private final Student student;
    private final String letterGrade;

    private final int courseLevel;
    private ArrayList<Course> prerequisites;

    public Course(String name, Student student, ArrayList<Course> prerequisites) {
        this.name = name;
        this.student = student;
        this.letterGrade = generateRandomLetterGrade();
        this.courseLevel = Integer.parseInt(String.valueOf(name.split(" ")[1].charAt(0)));
        this.prerequisites.addAll(prerequisites);
    }

    //A, B, B+, and C+ more likely
    private String generateRandomLetterGrade() {
        Random rand = new Random();
        double gradeSelector = rand.nextDouble(); // Select a random number between 0 and 1

        if (gradeSelector < 0.1) { // 10%
            return "A+";
        } else if (gradeSelector < 0.4) { // 30%
            return rand.nextBoolean() ? "A" : "B+";
        } else if (gradeSelector < 0.8) { // 40%
            return "B";
        } else if (gradeSelector < 0.95) { // 20% chance for C+ or C
            return rand.nextBoolean() ? "C+" : "C";
        }else {
            return rand.nextBoolean() ? "D" : "F"; //5% chance
        }
    }

    public Student getStudent() {
        return student;
    }

    public int getCourseLevel() {
        return courseLevel;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public String getName() {
        return name;
    }
}
