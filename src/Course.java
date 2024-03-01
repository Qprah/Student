import java.util.Random;

public class Course {
    private final String name;
    private final Student student;
    private final String letterGrade;
    private final int courseLevel;
    private final String code;
    private String description;

    public Course(String code, String name, Student student, String description) {
        this.code = code;
        this.name = name;
        this.student = student;
        this.letterGrade = generateRandomLetterGrade();
        this.courseLevel = Integer.parseInt(String.valueOf(code.split(" ")[1].charAt(0)));
        this.description = description;
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
        } else { // 20% chance for C+ or C
            return rand.nextBoolean() ? "C+" : "C";
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

    public String getCode(){
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", student=" + student +
                ", letterGrade='" + letterGrade + '\'' +
                ", courseLevel=" + courseLevel +
                ", description='" + description + '\'' +
                '}';
    }
}
