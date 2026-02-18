import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> grades = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("\n===== Student Grades Manager =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All");
            System.out.println("3. Update Grade");
            System.out.println("4. Calculate Average");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter grade (0-100): ");
                int grade = sc.nextInt();
                sc.nextLine();

                if (grade < 0 || grade > 100) {
                    System.out.println("Invalid grade!");
                } else {
                    names.add(name);
                    grades.add(grade);
                    System.out.println("Student added!");
                }

            } else if (choice == 2) {
                if (names.size() == 0) {
                    System.out.println("No students yet.");
                } else {
                    System.out.println("\n--- Students List ---");
                    for (int i = 0; i < names.size(); i++) {
                        System.out.println((i + 1) + ") " + names.get(i) + " - " + grades.get(i));
                    }
                }

            } else if (choice == 3) {
                if (names.size() == 0) {
                    System.out.println("No students to update.");
                } else {
                    System.out.print("Enter student name to update: ");
                    String searchName = sc.nextLine();

                    boolean found = false;
                    for (int i = 0; i < names.size(); i++) {
                        if (names.get(i).equalsIgnoreCase(searchName)) {
                            System.out.print("Enter new grade (0-100): ");
                            int newGrade = sc.nextInt();
                            sc.nextLine();

                            if (newGrade < 0 || newGrade > 100) {
                                System.out.println("Invalid grade!");
                            } else {
                                grades.set(i, newGrade);
                                System.out.println("Grade updated!");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student not found.");
                }

            } else if (choice == 4) {
                if (grades.size() == 0) {
                    System.out.println("No grades to average.");
                } else {
                    int sum = 0;
                    for (int g : grades) sum += g;
                    double avg = (double) sum / grades.size();
                    System.out.println("Average = " + avg);
                }

            } else if (choice == 5) {
                running = false;
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
