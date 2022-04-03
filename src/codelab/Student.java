package codelab;

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private int numberOfExercisesSolved;

    public Student() {
    }

    public Student(String firstName, String lastName, int numberOfExercisesSolved) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfExercisesSolved = numberOfExercisesSolved;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNumberOfExercisesSolved() {
        return numberOfExercisesSolved;
    }

    public void setNumberOfExercisesSolved(int numberOfExercisesSolved) {
        this.numberOfExercisesSolved = numberOfExercisesSolved;
    }

    public int compareTo(Student student) {
        return student.getNumberOfExercisesSolved() - this.getNumberOfExercisesSolved();
    }

}
