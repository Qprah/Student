import java.util.*;

public class Student {
    private final String name;
    private final String email;
    private String password;
    private final int stuNum;
    private final int year;
    private final int maxYear = 4;
    private static CourseGraph cg = null;

    //sets for course information
    private final Set<String> completedCourses;
    private final Set<String> currentCourses;
    private final Set<String> nextAvailableCourses;

    public Student(String fullName, String email, String password) {
        this.name = fullName;
        this.email = email;
        this.password = password;
        this.stuNum = assignStuNum();
        this.year = getRandomNumber(maxYear);


        cg = new CourseGraph();
        populateCourses();

        currentCourses = new HashSet<>(getCurrentCourses());
        completedCourses = new HashSet<>(getCompletedCourses(currentCourses));
        nextAvailableCourses = new HashSet<>(getNextAvailableCourses(currentCourses));
    }

    private int assignStuNum() {
        Random rand = new Random();
        return rand.nextInt(2000001) + 7000000;
    }

    private int getRandomNumber(int bound) {
        Random rand = new Random();
        //now we need to populate the courses only so that year one courses are complete and some of year 2 are done or maybe not
        return rand.nextInt(bound) + 1;
    }

    private void populateCourses() {
        // Adding courses and their prerequisites
        cg.addVertex("MATH 1240");

        cg.addVertex("COMP 1010");
        cg.addVertex("COMP 1020");

        cg.addVertex("COMP 2140");
        cg.addVertex("COMP 2160");
        cg.addVertex("COMP 2150");
        cg.addVertex("COMP 2280");
        cg.addVertex("COMP 2080");

        cg.addVertex("COMP 3010");
        cg.addVertex("COMP 3430");
        cg.addVertex("COMP 3020");
        cg.addVertex("COMP 3030");
        cg.addVertex("COMP 3380");
        cg.addVertex("COMP 3170");
        cg.addVertex("COMP 3370");
        cg.addVertex("COMP 3350");

        cg.addVertex("COMP 4020");
        cg.addVertex("COMP 4300");
        cg.addVertex("COMP 4380");
        cg.addVertex("COMP 4350");

        //added later
        cg.addVertex("COMP 3190");
        cg.addVertex("COMP 3290");
        cg.addVertex("COMP 3490");

        cg.addVertex("COMP 4050");
        cg.addVertex("COMP 4550");
        cg.addVertex("COMP 4580");



        //////////////////////////Prerequisite Relations//////////////////////////////////////


        cg.addEdge("COMP 1020", "COMP 1010");

        cg.addEdge("COMP 2140", "COMP 1020");

        cg.addEdge("COMP 2160", "COMP 1020");

        cg.addEdge("COMP 2150", "COMP 2140");
        cg.addEdge("COMP 2150", "COMP 2160");

        cg.addEdge("COMP 2280", "COMP 2140");
        cg.addEdge("COMP 2280", "COMP 2160");

        cg.addEdge("COMP 2080", "COMP 2140");
        cg.addEdge("COMP 2080", "MATH 1240");

        cg.addEdge("COMP 3010", "COMP 2150");
        cg.addEdge("COMP 3010", "COMP 2080");

        cg.addEdge("COMP 3430", "COMP 2280");
        cg.addEdge("COMP 3430", "COMP 2080");

        cg.addEdge("COMP 3170", "COMP 2080");

        cg.addEdge("COMP 3030", "COMP 2080");

        cg.addEdge("COMP 3380", "COMP 2150");

        cg.addEdge("COMP 3020", "COMP 2150");

        cg.addEdge("COMP 3370", "COMP 2280");

        cg.addEdge("COMP 4300", "COMP 3010");
        cg.addEdge("COMP 4300", "COMP 3430");

        cg.addEdge("COMP 4380", "COMP 3010");
        cg.addEdge("COMP 4380", "COMP 3430");
        cg.addEdge("COMP 4380", "COMP 3380");

        cg.addEdge("COMP 4020", "COMP 3020");

        cg.addEdge("COMP 4350", "COMP 3010");
        cg.addEdge("COMP 4350", "COMP 3380");
        cg.addEdge("COMP 4350", "COMP 3350");

        //added later
        cg.addEdge("COMP 3190", "COMP 2150");

        cg.addEdge("COMP 3290", "COMP 2140");
        cg.addEdge("COMP 3290", "COMP 2280");

        cg.addEdge("COMP 3490", "COMP 2150");

        cg.addEdge("COMP 4050", "COMP 3350");

        cg.addEdge("COMP 4550", "COMP 3430");
        cg.addEdge("COMP 4550", "COMP 3370");

        cg.addEdge("COMP 4580", "COMP 3430");
        cg.addEdge("COMP 4580", "COMP 3010");

    }


   //to be defined
   public Set<String> getCurrentCourses() {

       String[][] tuples = yearCourseSelector();

       // Get a random index to select a tuple
       int randomIndex = getRandomNumber(tuples.length) - 1;

       // Return the Set of courses
       return new HashSet<>(Arrays.asList(tuples[randomIndex]));
    }


    public Set<String> getCompletedCourses(Set<String> currentCourses) {
        return cg.getAllDoneCourses(currentCourses);
    }

    public Set<String> getNextAvailableCourses(Set<String> currentCourses) {
        return cg.getNextAvailableCourses(currentCourses);
    }

    public String[][] yearCourseSelector() {
        String[][][] yearTuples = {
                {   //year 1
                        {"COMP 1010"},{"COMP 1020"}
                },
                {   // Year 2
                        {"COMP 2150", "COMP 2080", "COMP 2280"},
                        {"COMP 2140", "MATH 1240", "COMP 2160"}
                },
                {   // Year 3
                        {"COMP 3020", "COMP 3380", "COMP 3040"},
                        {"COMP 3020", "COMP 3170", "COMP 3430"}
                },
                {   // Year 4
                        {"COMP 4350", "COMP 3170", "COMP 3430"},
                        {"COMP 4350", "COMP 3170", "COMP 3430", "COMP 3040"}
                }
        };

        // Adjusting year to array index
        int yearIndex = year - 1;

        // Returning the tuple for the specified year
        return yearTuples[yearIndex];
    }

    public String getName() {
        return name;
    }

    public int getStuNum() {
        return stuNum;
    }

    public int getYear() {
        return year;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student Full Name: ").append(name).append("\n");
        sb.append("Student Email: ").append(email).append("\n");
        sb.append("Student Number: ").append(stuNum).append("\n");
        sb.append("Year: ").append(year).append("\n");

        // Get completed courses
        sb.append("Completed Courses: ").append(completedCourses).append("\n");

        // Get current courses
        sb.append("Current Courses: ").append(currentCourses).append("\n");

        // Get next available courses
        sb.append("Next Available Courses: ").append(nextAvailableCourses).append("\n");

        return sb.toString();
    }

}
