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

        // test data (Main-нан көшеді)
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
                    case 1 -> addPet();
                    case 2 -> viewAllPets();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private void addPet() { /* Main-нан көшіресің */ }
    private void viewAllPets() { /* Main-нан көшіресің */ }
}
