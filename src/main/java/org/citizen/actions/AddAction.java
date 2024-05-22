package org.citizen.actions;

import org.citizen.domain.Citizen;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AddAction {
    public static void execute(EntityManager entityManager, Scanner scanner) {
        System.out.print("\nEnter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter tax ID: ");
        String taxId = scanner.nextLine();
        System.out.print("Enter identification ID (8 characters): ");
        String identificationId = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter date of birth (dd/MM/yyyy): ");
        String dateOfBirthStr = scanner.nextLine();

        if (identificationId != null && identificationId.length() != 8) {
            System.out.println("Invalid identification ID! Please enter 8 characters.");
        }

        // Validate date format
        LocalDateTime dateOfBirth;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate parsedDate = LocalDate.parse(dateOfBirthStr, formatter);
            dateOfBirth = parsedDate.atStartOfDay();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please enter the date in the format dd/MM/yyyy.");
            return;
        }

        entityManager.getTransaction().begin();

        Citizen citizen = new Citizen();
        citizen.setFirstName(firstName);
        citizen.setLastName(lastName);
        citizen.setTaxId(taxId);
        citizen.setIdentificationId(identificationId);
        citizen.setAddress(address);
        citizen.setGender(gender);
        citizen.setDateOfBirth(dateOfBirth);

        entityManager.persist(citizen);

        entityManager.getTransaction().commit();

        System.out.println("Entry added successfully.");
    }
}