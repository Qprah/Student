import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Main{
    public static void main(String[] args) {
        CourseGraph courseGraph = new CourseGraph();

        // Adding courses and their prerequisites
        courseGraph.addVertex("MATH 1240");

        courseGraph.addVertex("COMP 1010");
        courseGraph.addVertex("COMP 1020");

        courseGraph.addVertex("COMP 2140");
        courseGraph.addVertex("COMP 2160");
        courseGraph.addVertex("COMP 2150");
        courseGraph.addVertex("COMP 2280");
        courseGraph.addVertex("COMP 2080");

        courseGraph.addVertex("COMP 3010");
        courseGraph.addVertex("COMP 3430");
        courseGraph.addVertex("COMP 3020");
        courseGraph.addVertex("COMP 3030");
        courseGraph.addVertex("COMP 3380");
        courseGraph.addVertex("COMP 3170");
        courseGraph.addVertex("COMP 3370");
        courseGraph.addVertex("COMP 3350");

        courseGraph.addVertex("COMP 4020");
        courseGraph.addVertex("COMP 4300");
        courseGraph.addVertex("COMP 4380");
        courseGraph.addVertex("COMP 4350");

        //added later
        courseGraph.addVertex("COMP 3190");
        courseGraph.addVertex("COMP 3290");
        courseGraph.addVertex("COMP 3490");

        courseGraph.addVertex("COMP 4050");
        courseGraph.addVertex("COMP 4550");
        courseGraph.addVertex("COMP 4580");



        ////////////////////////////////////////////////////////////////


        courseGraph.addEdge("COMP 1020", "COMP 1010");

        courseGraph.addEdge("COMP 2140", "COMP 1020");

        courseGraph.addEdge("COMP 2160", "COMP 1020");

        courseGraph.addEdge("COMP 2150", "COMP 2140");
        courseGraph.addEdge("COMP 2150", "COMP 2160");

        courseGraph.addEdge("COMP 2280", "COMP 2140");
        courseGraph.addEdge("COMP 2280", "COMP 2160");

        courseGraph.addEdge("COMP 2080", "COMP 2140");
        courseGraph.addEdge("COMP 2080", "MATH 1240");

        courseGraph.addEdge("COMP 3010", "COMP 2150");
        courseGraph.addEdge("COMP 3010", "COMP 2080");

        courseGraph.addEdge("COMP 3430", "COMP 2280");
        courseGraph.addEdge("COMP 3430", "COMP 2080");

        courseGraph.addEdge("COMP 3170", "COMP 2080");

        courseGraph.addEdge("COMP 3030", "COMP 2080");

        courseGraph.addEdge("COMP 3380", "COMP 2150");

        courseGraph.addEdge("COMP 3020", "COMP 2150");

        courseGraph.addEdge("COMP 3370", "COMP 2280");

        courseGraph.addEdge("COMP 4300", "COMP 3010");
        courseGraph.addEdge("COMP 4300", "COMP 3430");

        courseGraph.addEdge("COMP 4380", "COMP 3010");
        courseGraph.addEdge("COMP 4380", "COMP 3430");
        courseGraph.addEdge("COMP 4380", "COMP 3380");

        courseGraph.addEdge("COMP 4020", "COMP 3020");

        courseGraph.addEdge("COMP 4350", "COMP 3010");
        courseGraph.addEdge("COMP 4350", "COMP 3380");
        courseGraph.addEdge("COMP 4350", "COMP 3350");

        //added later
        courseGraph.addEdge("COMP 3190", "COMP 2150");

        courseGraph.addEdge("COMP 3290", "COMP 2140");
        courseGraph.addEdge("COMP 3290", "COMP 2280");

        courseGraph.addEdge("COMP 3490", "COMP 2150");

        courseGraph.addEdge("COMP 4050", "COMP 3350");

        courseGraph.addEdge("COMP 4550", "COMP 3430");
        courseGraph.addEdge("COMP 4550", "COMP 3370");

        courseGraph.addEdge("COMP 4580", "COMP 3430");
        courseGraph.addEdge("COMP 4580", "COMP 3010");






        // Student completes courses for COMP 2080, 2150, and 2280
        Set<String> currentCourses = new HashSet<>();
        currentCourses.add("COMP 3370");
        currentCourses.add("COMP 3020");
        currentCourses.add("COMP 3380");

        // Get all completed courses
        List<String> allCompletedCourses = courseGraph.getAllDoneCourses(currentCourses);
        System.out.println("All completed courses: " + allCompletedCourses);

        //all current courses
        System.out.println("Current Courses: " + currentCourses);

        // Get available courses for the student
        Set<String> availableCourses = courseGraph.getNextAvailableCourses(currentCourses);
        System.out.println("Available courses for the student: " + availableCourses);

        //System.out.println(courseGraph.toString());
    }
}