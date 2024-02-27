import java.util.*;

public class CourseGraph {
    private Map<String, List<String>> adjacencyList;
    private Map<String, List<String>> adjacencyListRev;

    public CourseGraph() {
        adjacencyList = new HashMap<>();
        adjacencyListRev = new HashMap<>();
    }

    public void addVertex(String course) {
        adjacencyList.putIfAbsent(course, new ArrayList<>());
        adjacencyListRev.putIfAbsent(course, new ArrayList<>());
    }

    public void addEdge(String course, String prerequisite) {
        adjacencyListRev.get(prerequisite).add(course);
        adjacencyList.get(course).add(prerequisite);
    }

    public List<String> getPrerequisites(String course, Set<String> currentCourses) {
        List<String> prerequisites = adjacencyList.getOrDefault(course, new ArrayList<>());
        prerequisites.removeAll(currentCourses);
        return prerequisites;
    }

    public List<String> getAllDoneCourses(Set<String> currentCourses) {
        List<String> allDoneCourses = new ArrayList<>(); // Change to List
        Set<String> visited = new HashSet<>();
        for (String course : currentCourses) {
            dfs(course, visited, allDoneCourses, currentCourses);
        }
        return allDoneCourses;
    }

    private void dfs(String course, Set<String> visited, List<String> allDoneCourses, Set<String> currentCourses) {
        if (visited.contains(course)) {
            return;
        }
        visited.add(course);
        List<String> prerequisites = getPrerequisites(course, currentCourses);
        for (String prerequisite : prerequisites) {
            dfs(prerequisite, visited, allDoneCourses, currentCourses);
        }
        if (!currentCourses.contains(course)) {
            allDoneCourses.add(course);
        }
    }

    public Set<String> getNextAvailableCourses(Set<String> currentCourses) {
        Set<String> nextAvailableCourses = new HashSet<>();
        List<String> completedCourses = getAllDoneCourses(currentCourses); // Change to List

        for (String course : currentCourses) {
            List<String> coursesConnectedToCurrent = adjacencyListRev.get(course);
            if (coursesConnectedToCurrent != null) {
                nextAvailableCourses.addAll(coursesConnectedToCurrent); // Add courses connected to current course
            }
        }

        // Add prerequisites of prerequisites
        Set<String> prereqsOfPrereqs = new HashSet<>();
        for (String course : nextAvailableCourses) {
            List<String> prereqs = adjacencyListRev.get(course);
            if (prereqs != null) {
                prereqsOfPrereqs.addAll(prereqs);
            }
        }

        // Remove completed courses and courses with unsatisfied prerequisites
        nextAvailableCourses.addAll(prereqsOfPrereqs);
        nextAvailableCourses.removeAll(completedCourses);
        nextAvailableCourses.removeAll(currentCourses);

        return nextAvailableCourses;
    }

}
