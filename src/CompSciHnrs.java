import java.util.List;

public class CompSciHnrs {
    private static CourseGraph cg = null;
    private Student stu;

    List<Course> cshCourses;

    CompSciHnrs(Student stu){
        cg = new CourseGraph(); //initiate the graph relation

        this.stu = stu;
        cshCourses = populateCourses(stu);

        relateCourses();


    }

    private List<Course> populateCourses(Student stu){
        CourseParser extractCourses = new CourseParser("compCrsDb", stu);
        return extractCourses.getCourses();
    }

    public List<Course> getCshCourses() {
        return cshCourses;
    }

    private void relateCourses(){

        for(Course c: cshCourses){
            cg.addVertex(c.getCode());
            System.out.println(c.toString());
        }
    }


}
