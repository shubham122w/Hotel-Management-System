package HM;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();
        manager.loadFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Save to File");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Department: ");
                    String dept = scanner.nextLine();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    manager.addEmployee(new Employee(id, name, dept, salary));
                    break;
                case 2:
                    manager.viewEmployees();
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = scanner.nextInt();
                    manager.searchById(searchId);
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = scanner.nextInt();
                    manager.deleteById(delId);
                    break;
                case 5:
                    manager.saveToFile();
                    break;
                case 0:
                    manager.saveToFile();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}