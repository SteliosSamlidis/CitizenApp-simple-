package org.citizen.actions;

import org.citizen.domain.Citizen;

import javax.persistence.*;
import java.util.Scanner;

public class DeleteAction {
    public static void execute(EntityManager entityManager, Scanner scanner) {
        System.out.print("\nEnter ID of entry to delete: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Citizen citizen = entityManager.find(Citizen.class, id);
        if (citizen == null) {
            System.out.println("No citizen found with the specified ID.");
            return;
        }

        entityManager.getTransaction().begin();
        entityManager.remove(citizen);
        entityManager.getTransaction().commit();

        System.out.println("Entry deleted successfully.");
    }
}
