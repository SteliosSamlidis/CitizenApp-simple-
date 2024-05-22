package org.citizen.actions;

import org.citizen.domain.Citizen;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UpdateAction {
    public static void execute(EntityManager entityManager, Scanner scanner) {
        System.out.print("\nEnter ID of entry to update: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume newline

        Citizen citizen = entityManager.find(Citizen.class, id);
        if (citizen == null) {
            System.out.println("No citizen found with the specified ID.");
            return;
        }

        System.out.print("Enter new first name: ");
        String newFirstName = scanner.nextLine();
        System.out.print("Enter new last name: ");
        String newLastName = scanner.nextLine();
        System.out.print("Enter new tax ID: ");
        String newTaxId = scanner.nextLine();
        System.out.print("Enter new identification ID (8 characters): ");
        String newIdentificationId = scanner.nextLine();
        System.out.print("Enter new address: ");
        String newAddress = scanner.nextLine();
        System.out.print("Enter new gender: ");
        String newGender = scanner.nextLine();
        System.out.print("Enter new date of birth (dd/MM/yyyy): ");
        String newDateOfBirthStr = scanner.nextLine();

        // Validate date format
        LocalDateTime newDateOfBirth;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate parsedDate = LocalDate.parse(newDateOfBirthStr, formatter);
            newDateOfBirth = parsedDate.atStartOfDay();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
            return;
        }

        // Validate identification ID length
        if (newIdentificationId.length() != 8) {
            System.out.println("Identification ID must be 8 characters long.");
            return;
        }

        entityManager.getTransaction().begin();

        citizen.setFirstName(newFirstName);
        citizen.setLastName(newLastName);
        citizen.setTaxId(newTaxId);
        citizen.setIdentificationId(newIdentificationId);
        citizen.setAddress(newAddress);
        citizen.setGender(newGender);
        citizen.setDateOfBirth(newDateOfBirth);

        entityManager.getTransaction().commit();

        System.out.println("Entry updated successfully.");
    }
}