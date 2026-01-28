package com.nurdaulet.vetclinic.menu;

import com.nurdaulet.vetclinic.*;
import com.nurdaulet.vetclinic.database.PetDAO;
import java.util.Scanner;

public class VetClinicMenu implements Menu {

    private Scanner scanner;
    private PetDAO petDAO;

    public VetClinicMenu() {
        scanner = new Scanner(System.in);
        petDAO = new PetDAO();
    }

    @Override
    public void displayMenu() {
        System.out.println("=== VET CLINIC MENU ===");
        System.out.println("1. Add Pet");
        System.out.println("2. View All Pets");
        System.out.println("5. Update Pet");
        System.out.println("6. Delete Pet");
        System.out.println("7. Search Pet by Name");
        System.out.println("8. Search Pet by Age Range");
        System.out.println("9. Search Pet by Min Age");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addPet();
                        break;
                    case 2:
                        viewAllPets();
                        break;
                    case 5:
                        updatePet();
                        break;
                    case 6:
                        deletePet();
                        break;
                    case 7:
                        searchPetByName();
                        break;
                    case 8:
                        searchPetByAgeRange();
                        break;
                    case 9:
                        searchPetByMinAge();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void addPet() {
        System.out.print("Pet ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Species: ");
        String species = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        Pet pet = new Pet(id, name, species, age, false);
        petDAO.insertPet(pet);
        System.out.println("Pet added!");
    }


    private void searchPetByName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        petDAO.searchPetsByName(name)
                .forEach(System.out::println);
    }

    private void searchPetByAgeRange() {
        System.out.print("Min age: ");
        int min = scanner.nextInt();
        System.out.print("Max age: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        petDAO.searchPetsByAgeRange(min, max)
                .forEach(System.out::println);
    }

    private void searchPetByMinAge() {
        System.out.print("Min age: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        petDAO.searchByMinAge(min)
                .forEach(System.out::println);
    }

    private void viewAllPets() {
        petDAO.getAllPets();
    }


    private boolean isAdmin = true;

    private void updatePet() {

        PetDAO dao = new PetDAO();

        System.out.print("Enter Pet ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Pet existingPet = dao.getPetById(id);

        if (existingPet == null) {
            System.out.println("No pet found with ID: " + id);
            return;
        }

        System.out.println("Current info:");
        System.out.println(existingPet);

        System.out.print("New name (" + existingPet.getName() + "): ");
        String name = scanner.nextLine();
        if (name.isBlank()) name = existingPet.getName();

        System.out.print("New species (" + existingPet.getSpecies() + "): ");
        String species = scanner.nextLine();
        if (species.isBlank()) species = existingPet.getSpecies();

        System.out.print("New age (" + existingPet.getAge() + "): ");
        String ageInput = scanner.nextLine();
        int age = ageInput.isBlank()
                ? existingPet.getAge()
                : Integer.parseInt(ageInput);

        Pet updatedPet = new Pet(
                id,
                name,
                species,
                age,
                existingPet.isVaccinated()
        );

        dao.updatePet(updatedPet);
    }

    private void deletePet() {

        PetDAO dao = new PetDAO();

        if (!isAdmin) {
            System.out.println("Permission denied.");
            return;
        }

        System.out.print("Enter Pet ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // 1. Load pet from database
        Pet pet = dao.getPetById(id);

        if (pet == null) {
            System.out.println("No pet found with ID: " + id);
            return;
        }

        // 2. Show what will be deleted
        System.out.println("Pet to be deleted:");
        System.out.println(pet);

        // 3. Ask for confirmation
        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        // 4. Delete only if confirmed
        if (confirm.equalsIgnoreCase("yes")) {
            dao.deletePet(id);
        } else {
            System.out.println("Deletion cancelled.");
        }
    }



}