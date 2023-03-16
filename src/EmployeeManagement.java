public class EmployeeManagement {
    public static void main(String[] args) {

        Employee e1 = new Employee("D-F", Departments.PRODUCTION);
        Employee e2 = new Employee("G-P", Departments.PRODUCTION);
        Employee e3 = new Employee("M-N", 1115, 33.60, Levels.EMPLOYEE, Departments.ADMINISTRATION);
        Employee e4 = new Employee("F-R", 1820, 38.20, Levels.MANAGER, Departments.SALES);
        Employee[] employeeList = {e1, e2, e3, e4};
        System.out.println(); // used as spacing in console

        // promote workman e2 to employee
        e2.promoteEmployee();
        System.out.println(e2.toString());
        System.out.println(); // used as spacing in console

        // promote employee e3 to director
        e3.promoteEmployee();
        System.out.println(e3.toString());
        System.out.println(); // used as spacing in console

        // print in console all Employee
        printAllEmployee(employeeList);
        System.out.println(); // used as spacing in console

        // calculate global salary of the company
        calculateGlobalSalary(employeeList);
        System.out.println(); // used as spacing in console
    }

    public static void printAllEmployee(Employee[] list) {
        for(int i = 0; i < list.length; i++) {
            System.out.println("Employee N." + (i + 1));
            System.out.println(list[i].toString());
            System.out.println(); // used as spacing in console
        }
    }

    public static void calculateGlobalSalary(Employee[] list) {
        double total = 0;
        for(int i = 0; i < list.length; i++) {
            double overtime = list[i].getOrSetOverWage() * 5;
            double salary = list[i].getSalary();
            double monthlySalary = overtime + salary;
            total += monthlySalary;
        }
        System.out.println("Total monthly salary: " + total + "€");

    }
}