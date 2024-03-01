import java.util.*;

public class CourseGraph {
    private final Map<String, Set<String>> adjacencyList;
    private final Map<String, Set<String>> adjacencyListRev;

    public CourseGraph() {
        adjacencyList = new HashMap<>();
        adjacencyListRev = new HashMap<>();
    }

    public void addVertex(String course) {
        adjacencyList.putIfAbsent(course, new HashSet<>());
        adjacencyListRev.putIfAbsent(course, new HashSet<>());
    }

    public void addEdge(String course, String prerequisite) {
        adjacencyListRev.get(prerequisite).add(course);
        adjacencyList.get(course).add(prerequisite);
    }

    public Set<String> getPrerequisites(String course, Set<String> currentCourses) {
        Set<String> prerequisites = adjacencyList.getOrDefault(course, new HashSet<>());
        prerequisites.removeAll(currentCourses);
        return prerequisites;
    }

    public Set<String> getAllDoneCourses(Set<String> currentCourses) {
        Set<String> allDoneCourses = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String course : currentCourses) {
            dfs(course, visited, allDoneCourses, currentCourses);
        }
        return allDoneCourses;
    }

    private void dfs(String course, Set<String> visited, Set<String> allDoneCourses, Set<String> currentCourses) {
        if (visited.contains(course)) {
            return;
        }
        visited.add(course);
        Set<String> prerequisites = adjacencyList.get(course);
        if (prerequisites != null) {
            for (String prerequisite : prerequisites) {
                dfs(prerequisite, visited, allDoneCourses, currentCourses);
            }
        }
        if (!currentCourses.contains(course)) {
            allDoneCourses.add(course);
        }
    }

    public Set<String> getNextAvailableCourses(Set<String> currentCourses) {
        Set<String> completedOrCurrentCourses = new HashSet<>(currentCourses);
        completedOrCurrentCourses.addAll(getAllDoneCourses(currentCourses));

        Set<String> nextAvailableCourses = new HashSet<>();

        for (String course : completedOrCurrentCourses) {
            Set<String> connectedCourses = adjacencyListRev.getOrDefault(course, Collections.emptySet());
            for (String connectedCourse : connectedCourses) {
                Set<String> prerequisites = adjacencyList.get(connectedCourse);
                if (prerequisites != null && completedOrCurrentCourses.containsAll(prerequisites)) {
                    nextAvailableCourses.add(connectedCourse);
                }
            }
        }

        // Remove courses already completed or in current courses
        nextAvailableCourses.removeAll(completedOrCurrentCourses);

        return nextAvailableCourses;
    }
}
