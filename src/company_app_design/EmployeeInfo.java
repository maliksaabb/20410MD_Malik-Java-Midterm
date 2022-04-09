package company_app_design;

import java.util.Scanner;

public class EmployeeInfo extends EmployeeData{

    /** INSTRUCTIONS
     * This class should implement the Employee interface, but you must do that without using the keyword `implement`
     * anywhere in this class. DONE
     *
     * HINT: Take a look at the collections framework diagram. Do you see how a class may impleme
nt an interface without
     *       directly implementing it? DONE
     *
     * YOU MUST USE/DO:
     *         OOP (Abstraction, Encapsulation, Inheritance and Polymorphism) concepts in every way possible
     *         Use all kind of keywords (super, this, static, final, etc)
     *         Implement nested class below (DateConversion)
     *         Use Exception Handling
     *
     * Once you're done with designing this EmployeeInfo class, go to the Company Employee class to test
     */

    private String name;
    private int employeeId;
    private String employeePosition;
    private String email;
    private String department;
    private boolean isFullTime;
    private int salary;
    private static int numOfEmployees;

    private String vacationTime;



    // Make sure to declare and use static, non-static & final fields
    static final String companyName = "TheCompany";
    static final String employmentEndDate = "N/A :)";

    // You must have/use multiple constructors to initialize instance variables that you will create above


    public EmployeeInfo(String name, int employeeId, String employeePosition) {
        this.employeeId = employeeId;
        this.name = name;
        this.employeePosition = employeePosition;
        numOfEmployees++;
    }

    public EmployeeInfo(String name, int employeeId, String employeePosition, String email,
                        String department, int salary){

        this(name, employeeId, employeePosition);
        this.email = email;
        this.department = department;
        this.salary = salary;
        numOfEmployees++;

    }

    /*
    You need to implement the logic of this method as such:
        It should calculate employee bonus based on salary and performance.
        It should return the total yearly bonus
        e.g. - Bonus = 10% of yearly salary for best performance
               Bonus = 6% of yearly salary for average performance, etc.
     */
    public static int calculateAnnualBonus(int salary, int performanceGrade) {

        int total = 0;
        if(performanceGrade < 1 || performanceGrade > 5){
            return -1;
        }

        if(performanceGrade == 5){

            total = (int) (salary * .1);

        } else if(performanceGrade == 4){

            total = (int) (salary * .08);

        } else if(performanceGrade == 3){

            total = (int) (salary * .06);

        } else if(performanceGrade == 2){

            total = (int) (salary * .04);

        }

        return total;
    }

    /*
    You need to implement the logic of this method as such:
        It should calculate employee pension based on salary and numbers of years spent with the company.
        It should return the total pension amount.
        e.g. - Employee will receive 5% of salary as pension for every year they are with the company
     *
     */
    public static int calculateEmployeePension(int salary) {
        int total = 0;
        int yearsWithCompany = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter start date in format (example: May,2015): ");
        String joiningDate = sc.nextLine();
        System.out.println("Please enter today's date in format (example: August,2017): ");
        String todaysDate = sc.nextLine();
        String convertedJoiningDate = DateConversion.convertDate(joiningDate);
        String convertedTodaysDate = DateConversion.convertDate(todaysDate);

        String[] joiningDateArray = convertedJoiningDate.split("/");
        String[] todaysDateArray = convertedTodaysDate.split("/");

        if(Integer.parseInt(todaysDateArray[0]) >= Integer.parseInt(joiningDateArray[0])){

            yearsWithCompany = Integer.parseInt(todaysDateArray[1]) - Integer.parseInt(joiningDateArray[1]);
            System.out.println(yearsWithCompany);

        } else {

            yearsWithCompany = Integer.parseInt(todaysDateArray[1]) - Integer.parseInt(joiningDateArray[1]) - 1;
            System.out.println(yearsWithCompany);

        }

        // Figure out how to extract the number of years the employee has been with the company, using the above 2 dates
        // Calculate pension
        total = (int) (.05 * salary) * yearsWithCompany;
        return total;
    }

    public void chooseVacationTime(){ //I know this method doesn't make much sense but I couldn't think of anything else

        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("What are the dates that you need for your vacation request?");
            String monthAndYear = scan.next();
            vacationTime = DateConversion.convertDate(monthAndYear);


        } catch(IllegalArgumentException iae){

            System.out.println("Sorry, no integers allowed! Must be a String value.");

        }

    }

    @Override
    public int employeeId() {
        return employeeId;
    }

    @Override
    public String employeeName() {
        return name;
    }

    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }

    @Override
    public int calculateSalary() {
        return salary;
    }

    @Override
    public void benefits() {

        if(isFullTime){
            System.out.println("Benefits include Dental, Health, Vision, PTO");
        } else {
            System.out.println("Benefits include Health and Dental");
        }

    }

    public int getNumOfEmployees(){
        return numOfEmployees;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void isFullTime(boolean isFullTime) {
        if(isFullTime){
            this.isFullTime = true;
        } else {
            this.isFullTime = false;
        }
    }

    public void printReminder(){
        System.out.println(employmentEndDate);
    }

    @Override
    public void printSlogan(){
        super.printSlogan();
    }


    private static class DateConversion {

        public static String convertDate(String date) {
            String[] extractMonth = date.split(",");
            String givenMonth = extractMonth[0];
            int monthDate = whichMonth(givenMonth);

            String actualDate = monthDate + "/" + extractMonth[1];
            return actualDate;
        }

        public static int whichMonth(String givenMonth) {
            Months month = Months.valueOf(givenMonth);
            int monthNumber;

            switch (month) {
                case January:
                    monthNumber = 1;
                    break;
                case February:
                    monthNumber = 2;
                    break;
                case March:
                    monthNumber = 3;
                    break;
                case April:
                    monthNumber = 4;
                    break;
                case May:
                    monthNumber = 5;
                    break;
                case June:
                    monthNumber = 6;
                    break;
                case July:
                    monthNumber = 7;
                    break;
                case August:
                    monthNumber = 8;
                    break;
                case September:
                    monthNumber = 9;
                    break;
                case October:
                    monthNumber = 10;
                    break;
                case November:
                    monthNumber = 11;
                    break;
                case December:
                    monthNumber = 12;
                    break;
                default:
                    monthNumber = -1;
                    break;
            }
            return monthNumber;
        }
    }
}