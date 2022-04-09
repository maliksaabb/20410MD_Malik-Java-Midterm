package company_app_design;

public abstract class EmployeeData {
    public abstract int employeeId();

    public abstract String employeeName();

    public abstract void assignDepartment(String department);

    public abstract int calculateSalary();

    public abstract void benefits();

    public abstract void isFullTime(boolean isFullTime);

    public void printSlogan() {
        System.out.println("Would I rather be feared or loved? Easy. Both " +
                "I want people to be afraid of how much they love me.");
    }
}
