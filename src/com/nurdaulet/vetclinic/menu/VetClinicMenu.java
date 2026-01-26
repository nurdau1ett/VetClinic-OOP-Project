package com.nurdaulet.vetclinic.menu;

import com.nurdaulet.vetclinic.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VetClinicMenu implements Menu {

    private ArrayList<Person> people;
    private ArrayList<Pet> pets;
    private Scanner scanner;

    public VetClinicMenu() {
        people = new ArrayList<>();
        pets = new ArrayList<>();
        scanner = new Scanner(System.in);

        // test data
        pets.add(new Pet(1, "Buddy", "Dog", 3, false));
        people.add(new Veterinarian(1, "Dr. Aibek", 35, 201, "Dog", 6, true));
    }

    @Override
    public void displayMenu() {
        System.out.println("=== VET CLINIC MENU ===");
        System.out.println("1. Add Pet");
        System.out.println("2. View All Pets");
        System.out.println("3. Add Owner");
        System.out.println("4. Add Veterinarian");
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
                    case 3:
                        addOwner();
                        break;
                    case 4:
                        addVeterinarian();
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

        pets.add(new Pet(id, name, species, age, false));
        System.out.println("Pet added!");
    }

    private void addOwner() {
        System.out.print("Person ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Number of pets: ");
        int petsCount = scanner.nextInt();
        scanner.nextLine();

        people.add(new Owner(id, name, age, phone, petsCount, petsCount >= 3));
        System.out.println("Owner added!");
    }

    private void addVeterinarian() {
        System.out.print("Person ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Vet ID: ");
        int vetId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();

        people.add(new Veterinarian(id, name, age, vetId, spec, exp, true));
        System.out.println("Veterinarian added!");
    }

    private void viewAllPets() {
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
            return;
        }

        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
}
