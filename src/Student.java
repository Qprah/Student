import java.util.ArrayList;
import java.util.Random;

public class Student {
    private String name;
    private String email;
    private String password;
    private int stuNum;
    private int year;
    private ArrayList<Course> courses;

    public Student(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.stuNum = assignStuNum();
        this.year = getRandomYear();
        this.courses = new ArrayList<>();
        populateCourses(); // Populate courses for each student
    }

    private int assignStuNum() {
        Random rand = new Random();
        return rand.nextInt(2000001) + 7000000;
    }

    private int getRandomYear() {
        Random rand = new Random();
        //now we need to populate the courses only so that year one courses are complete and some of year 2 are done or maybe not
        return rand.nextInt(4) + 1;
    }

    private void populateCourses() {

        //year 1 pool
        //courses.add(new Course("COMP 1010", this, null));
        //courses.add(new Course("COMP 1020", this, new ArrayList<Course>()));
//        courses.add(new Course("COMP 1012", this));
//
//        //year 2 pool
//        courses.add(new Course("COMP 2080", this));
//        courses.add(new Course("COMP 2140", this));
//        courses.add(new Course("COMP 2150", this));
//        courses.add(new Course("COMP 2160", this));
//        courses.add(new Course("COMP 2280", this));
//
//        //year 3 pool
//        courses.add(new Course("COMP 3010", this));
//        courses.add(new Course("COMP 3020", this));
//        courses.add(new Course("COMP 3030", this));
//        courses.add(new Course("COMP 3040", this));
//        courses.add(new Course("COMP 3170", this));
//        courses.add(new Course("COMP 3190", this));
//        courses.add(new Course("COMP 3350", this));
//        courses.add(new Course("COMP 3370", this));
//        courses.add(new Course("COMP 3380", this));
//        courses.add(new Course("COMP 3430", this));
//        courses.add(new Course("COMP 3490", this));
//
//        //year 4 pool
//        courses.add(new Course("COMP 4020", this));
//        courses.add(new Course("COMP 4050", this));
//        courses.add(new Course("COMP 4060", this));
//        courses.add(new Course("COMP 4140", this));
//        courses.add(new Course("COMP 4180", this));
//        courses.add(new Course("COMP 4190", this));
//        courses.add(new Course("COMP 4300", this));
//        courses.add(new Course("COMP 4350", this));
//        courses.add(new Course("COMP 4360", this));
//        courses.add(new Course("COMP 4380", this));
//        courses.add(new Course("COMP 4420", this));
//        courses.add(new Course("COMP 4430", this));
//        courses.add(new Course("COMP 4490", this));
//        courses.add(new Course("COMP 4510", this));
//        courses.add(new Course("COMP 4522", this));
//        courses.add(new Course("COMP 4550", this));
//        courses.add(new Course("COMP 4560", this));
//        courses.add(new Course("COMP 4580", this));
//        courses.add(new Course("COMP 4620", this));
//        courses.add(new Course("COMP 4710", this));
//        courses.add(new Course("COMP 4820", this));
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Name: ").append(name).append("\n");
        sb.append("Student Email: ").append(email).append("\n");
        sb.append("Student Number: ").append(stuNum).append("\n");
        sb.append("Year: ").append(year).append("\n");
        sb.append("Courses:\n");
        for (Course course : courses) {
            sb.append("\tCourse Name: ").append(course.getName()).append("\n");
            sb.append("\t\tLetter Grade: ").append(course.getLetterGrade()).append("\n");
            sb.append("\t\tCourse Level: ").append(course.getCourseLevel()).append("\n");
        }
        return sb.toString();
    }
}
