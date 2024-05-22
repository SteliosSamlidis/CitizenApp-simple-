package org.citizen.actions;

import org.citizen.domain.Citizen;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReadAction {
    public static void execute(EntityManager entityManager) {
        TypedQuery<Citizen> query = entityManager.createQuery("SELECT c FROM Citizen c", Citizen.class);
        List<Citizen> citizens = query.getResultList();

        System.out.println("\nCitizens List:");
        for (Citizen citizen : citizens) {
            System.out.println("ID: " + citizen.getId() +
                    ", Name: " + citizen.getFirstName() + " " + citizen.getLastName() +
                    ", Tax ID: " + citizen.getTaxId() +
                    ", Identification ID: " + citizen.getIdentificationId() +
                    ", Address: " + citizen.getAddress() +
                    ", Gender: " + citizen.getGender() +
                    ", Date of Birth: " + formatDate(citizen.getDateOfBirth()));
        }
    }

    private static String formatDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTime.format(formatter);
    }
}