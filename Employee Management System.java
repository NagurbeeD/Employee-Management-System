import java.util.*;


public class EmployeeManagementSystem {


    private static Map<Integer, Employee> employeeMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int choice;


        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();


            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewAllEmployees(); break;
                case 3: searchEmployee(); break;
                case 4: updateEmployee(); break;
                case 5: deleteEmployee(); break;
                case 6: System.out.println("Exiting... Thank you!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }


    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();


        Employee emp = new Employee(id, name, dept, salary);
        employeeMap.put(id, emp);
        System.out.println("Employee added successfully.");
    }


    private static void viewAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\nEmployee List:");
            for (Employee emp : employeeMap.values()) {
                System.out.println(emp);
            }
        }
    }


    private static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        Employee emp = employeeMap.get(id);
        if (emp != null) {
            System.out.println(emp);
        } else {
            System.out.println("Employee not found.");
        }
    }


    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        Employee emp = employeeMap.get(id);
        if (emp != null) {
            scanner.nextLine(); // consume newline
            System.out.print("Enter new name: ");
            emp.setName(scanner.nextLine());
            System.out.print("Enter new department: ");
            emp.setDepartment(scanner.nextLine());
            System.out.print("Enter new salary: ");
            emp.setSalary(scanner.nextDouble());
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }


    private static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = scanner.nextInt();
        if (employeeMap.remove(id) != null) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}