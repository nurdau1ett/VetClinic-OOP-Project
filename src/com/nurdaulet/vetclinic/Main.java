package com.nurdaulet.vetclinic;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Person> people = new ArrayList<>();
    private static ArrayList<Pet> pets = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        boolean running = true;
        pets.add(new Pet(1, "Buddy", "Dog", 3, false));
        pets.add(new Pet(2, "Kitty", "Cat", 1, true));
        people.add(
                new Veterinarian(1, "Dr. Aibek", 35,
                        201, "Dog", 6, true)
        );

        people.add(
                new Owner(2, "Aruzhan", 28,
                        "+77011234567", 2, false)
        );



        while (running) {
            System.out.println("=== VET CLINIC MENU ===");
            System.out.println("1. Add Pet");
            System.out.println("2. View All Pets");
            System.out.println("3. Add Owner");
            System.out.println("4. Add Veterinarian");
            System.out.println("5. Demonstrate Polymorphism");
            System.out.println("6. View Only Veterinarians");
            System.out.println("7. View All People (Polymorphic)");
            System.out.println("8. Add General Person");
            System.out.println("0. Exit");

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
                    addVeterinarian();
                    break;
                case 5:
                    demonstratePolymorphism();
                    break;
                case 6:
                    viewOnlyVeterinarians();
                    break;
                case 7:
                    viewAllPeople();
                    break;
                case 8:
                    addPerson();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
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
    private static void demonstratePolymorphism() {
        System.out.println("=== POLYMORPHISM DEMO ===");

        for (Person p : people) {
            p.work();
        }
    }
    private static void viewOnlyVeterinarians() {
        System.out.println("=== VETERINARIANS ONLY ===");

        boolean found = false;

        for (Person p : people) {
            if (p instanceof Veterinarian) {   // ← INSTANCEOF
                Veterinarian v = (Veterinarian) p; // ← DOWNCAST
                System.out.println(v);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No veterinarians found.");
        }
    }
    private static void addOwner() {
        System.out.println("--- ADD OWNER ---");

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

        Owner owner = new Owner(id, name, age, phone, petsCount, petsCount >= 3);
        people.add(owner);

        System.out.println("Owner added successfully!");
    }

    private static void addVeterinarian() {
        System.out.println("--- ADD VETERINARIAN ---");

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

        Veterinarian vet =
                new Veterinarian(id, name, age, vetId, spec, exp, true);

        people.add(vet);

        System.out.println("Veterinarian added successfully!");
    }
    private static void viewAllPeople() {
        System.out.println("=== ALL PEOPLE (POLYMORPHIC LIST) ===");

        if (people.isEmpty()) {
            System.out.println("No people found.");
            return;
        }

        for (Person p : people) {
            System.out.println(p);
        }
    }
    private static void addPerson() {
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt(); scanner.nextLine();

        people.add(new Person(id, name, age));
    }
}
