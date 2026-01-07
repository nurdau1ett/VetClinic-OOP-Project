package com.nurdaulet.vetclinic;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pet> pets = new ArrayList<>();
    private static ArrayList<Owner> owners = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        boolean running = true;
        pets.add(new Pet(1, "Buddy", "Dog", 3, false));
        pets.add(new Pet(2, "Kitty", "Cat", 1, true));

        owners.add(new Owner(101, "Aruzhan", "+77011234567", 2, false));
        owners.add(new Owner(102, "Dias", "+77019998877", 1, false));


        while (running) {
            System.out.println("\n=== VET CLINIC MENU ===");
            System.out.println("1. Add Pet");
            System.out.println("2. View All Pets");
            System.out.println("3. Add Owner");
            System.out.println("4. View All Owners");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer clear

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
                    viewAllOwners();
                    break;
                case 0:
                    running = false;
                    scanner.close();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    private static void addPet() {
        System.out.println("--- ADD PET ---");

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
        pets.add(pet);

        System.out.println("Pet added successfully!");
    }
    private static void viewAllPets() {
        System.out.println("--- ALL PETS ---");

        if (pets.isEmpty()) {
            System.out.println("No pets found.");
            return;
        }

        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }
    private static void addOwner() {
        System.out.println("--- ADD OWNER ---");

        System.out.print("Owner ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Owner owner = new Owner(id, name, phone, 0, false);
        owners.add(owner);

        System.out.println("Owner added successfully!");
    }
    private static void viewAllOwners() {
        System.out.println("--- ALL OWNERS ---");

        if (owners.isEmpty()) {
            System.out.println("No owners found.");
            return;
        }

        for (Owner owner : owners) {
            System.out.println(owner);
        }
    }



}
