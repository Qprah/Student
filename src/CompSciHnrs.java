public class CompSciHnrs {
    private static CourseGraph cg = null;
    private Student stu;
    CompSciHnrs(Student stu){
        cg = new CourseGraph();
        this.stu = stu;

        populateCourses(stu);
    }

    private void populateCourses(Student stu){
        //cg.addVertex(new Course("COMP 1010", "Introductory Computer Science 1", stu, ""));
    }


}
