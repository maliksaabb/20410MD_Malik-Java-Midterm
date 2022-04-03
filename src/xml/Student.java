package xml;

import java.io.Serializable;

public class Student implements Serializable {

    // Student class has 4 instance variables, which will be constructed as Student Object into List<Student>
    public String firstName;
    public String lastName;
    public char score;
    public String id;

    public Student() {
    }

    public Student(String firstName, String lastName, char score, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
        this.id = id;
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

    public char getScore() {
        return score;
    }

    public void setScore(char score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student" + "(" + "id= " + id + ")" + firstName + " " + lastName + " " + " Grade = " + score;
    }

}
