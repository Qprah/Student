import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseParser {
    private final List<Course> courses;
    public CourseParser(String fileName, Student stu){
        courses = new ArrayList<>(parseCoursesFromFile(fileName, stu));
        System.out.println(courses.size());
    }

    public static List<Course> parseCoursesFromFile(String filename, Student stu) {
        List<Course> courses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    String code = parts[0].trim();
                    String name = parts[1].trim();
                    String description = parts[2].trim();
                    courses.add(new Course(code, name, stu ,description));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public List<Course> getCourses() {
        return courses;
    }
}