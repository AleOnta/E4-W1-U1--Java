import java.util.Random;

public class Employee {
    // static attribute
    public static double standardSalary = 1000;
    // private attribute
    private String employeeID;
    private double salary;
    private double overtimeHourWage;
    private Levels level;
    private Departments department;
    // to create ID
    private final Random rand = new Random();

    // Constructors
    private Employee() {
        System.out.println("new employee created");
    }
    public Employee(String id, Departments depart) {
        this();
        employeeID = generateID(id);
        salary = standardSalary;
        overtimeHourWage = 30;
        level = Levels.WORKMAN;
        department = depart;
    }

    public Employee(String id, double sal, double over, Levels lev, Departments depart) {
        this();
        employeeID = generateID(id);
        salary = sal;
        overtimeHourWage = over;
        level = lev;
        department = depart;
    }

    // defining methods

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", salary=" + salary +
                ", overtimeHourWage=" + overtimeHourWage +
                ", level=" + level +
                ", department=" + department +
                '}';
    }
    private String generateID(String id) {
        int upperBound = 1234;
        int dynamicID = rand.nextInt(upperBound);
        return id + dynamicID;
    }

    // methods get to read properties

    public String getID() {
        return employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public double getOrSetOverWage() {
        return overtimeHourWage;
    }

    public void getOrSetOverWage(double perHour) {
        overtimeHourWage = perHour;
    }

    public Levels getLevel() {
        return level;
    }

    public Departments getOrSetDepartment() {
        return department;
    }

    public void getOrSetDepartment(Departments depart) {
        department = depart;
    }

    public Levels promoteEmployee() {
        switch (level) {
            case WORKMAN:
                level = Levels.EMPLOYEE;
                salary = standardSalary * 1.2;
                break;
            case EMPLOYEE:
                level = Levels.DIRECTOR;
                salary = standardSalary * 1.5;
                break;
            case DIRECTOR:
                level = Levels.MANAGER;
                salary = standardSalary * 2;
                break;
            case MANAGER:
                System.out.println("ERROR OCCURRED: Employee selected is already a Manager");
                break;
        }
        return level;
    }

    // static methods for Employee

    public static double calculateSalary(Employee e) {
        return e.salary;
    }
    public static double calculateSalary(Employee e, int hours) {
        double overtime = e.overtimeHourWage * hours;
        return overtime + e.salary;
    }
}
