import java.util.List;

public class CompSciHnrs {
    private static CourseGraph cg = null;
    private Student stu;


    CompSciHnrs(Student stu){
        cg = new CourseGraph();
        this.stu = stu;

        populateCourses(stu);
    }

    private List<Course> populateCourses(Student stu){
        CourseParser extractCourses = new CourseParser("compCrsDb.txt", stu);
        return extractCourses.getCourses();
    }


    public static void main(String[] args) {
        CompSciHnrs hi;

        hi = new CompSciHnrs(new Student("Anmo", "asdnasd", "jiasndj"));

    }

}
