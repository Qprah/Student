import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Create an ArrayList to store the students
        ArrayList<Student> studentsList = new ArrayList<>();

        // Add students to the list
        studentsList.add(new Student("Anmol", "sin121@myumanitoba.ca", "pass1"));
        studentsList.add(new Student("John", "john@example.com", "pass2"));
        studentsList.add(new Student("Alice", "alice@example.com", "pass3"));
        studentsList.add(new Student("Bob", "bob@example.com", "pass4"));
        studentsList.add(new Student("Emma", "emma@example.com", "pass5"));
        studentsList.add(new Student("Ethan", "ethan@example.com", "pass6"));
        studentsList.add(new Student("Sophia", "sophia@example.com", "pass7"));
        studentsList.add(new Student("Liam", "liam@example.com", "pass8"));

        //enroll first student in Comp sci honors for now
        CompSciHnrs csh = new CompSciHnrs(studentsList.get(0));






        // Print the details of each student using a loop
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println(studentsList.get(i));
        }
    }


}
