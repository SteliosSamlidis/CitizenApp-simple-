package org.citizen;

import org.citizen.actions.AddAction;
import org.citizen.actions.DeleteAction;
import org.citizen.actions.ReadAction;
import org.citizen.actions.UpdateAction;

import javax.persistence.*;
import java.util.Scanner;

public class Main {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("CitizenPU");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> ReadAction.execute(entityManager);
                case 2 -> AddAction.execute(entityManager, scanner);
                case 3 -> UpdateAction.execute(entityManager, scanner);
                case 4 -> DeleteAction.execute(entityManager, scanner);
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

        entityManager.close();
        entityManagerFactory.close();
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n1. Read entries");
        System.out.println("2. Add entry");
        System.out.println("3. Update entry");
        System.out.println("4. Delete entry");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
}
