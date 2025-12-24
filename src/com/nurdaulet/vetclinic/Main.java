package com.nurdaulet.vetclinic;

public class Main {


    public static void main(String[] args) {


        System.out.println("=== VetClinic Management System ===\n");


        Pet pet1 = new Pet(1, "Buddy", "Dog", 3, false);
        Pet pet2 = new Pet();
        Owner owner1 = new Owner(101, "Aruzhan", "+77011234567", 2, false);
        Owner owner2 = new Owner();
        Veterinarian vet1 = new Veterinarian(201, "Dr. Aibek", "Dog", 6, true);


        System.out.println("--- INITIAL STATE ---");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(owner1);
        System.out.println(owner2);
        System.out.println(vet1);
        System.out.println();


        System.out.println("--- TESTING GETTERS ---");
        System.out.println("Pet1 name: " + pet1.getName());
        System.out.println("Pet1 age: " + pet1.getAge());
        System.out.println("Owner1 phone: " + owner1.getPhone());
        System.out.println("Vet1 experience: " + vet1.getExperienceYears());
        System.out.println();


        System.out.println("--- TESTING SETTERS ---");
        pet2.setName("Kitty");
        pet2.setSpecies("Cat");
        pet2.setAge(1);
        owner2.setName("Dias");
        owner2.setPhone("+77019876543");
        vet1.setAvailable(false);

        System.out.println("Updated pet2: " + pet2);
        System.out.println("Updated owner2: " + owner2);
        System.out.println("Updated vet1 availability: " + vet1.isAvailable());
        System.out.println();


        System.out.println("--- TESTING LOGIC METHODS ---");

        System.out.println("Is pet1 young? " + pet1.isYoung());
        System.out.println("Vaccinating pet1...");
        pet1.vaccinate();
        System.out.println("Pet1 vaccinated: " + pet1.isVaccinated());

        System.out.println("\nAdding pet to owner1...");
        owner1.addPet();
        System.out.println("Owner1 number of pets: " + owner1.getNumberOfPets());
        System.out.println("Owner1 frequent client? " + owner1.checkFrequentClient());

        System.out.println("\nIs vet1 experienced? " + vet1.isExperienced());
        System.out.println("Can vet1 treat Dogs? " + vet1.canTreat("Dog"));
        System.out.println();


        System.out.println("--- FINAL STATE ---");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(owner1);
        System.out.println(owner2);
        System.out.println(vet1);


        System.out.println("\n=== Program Complete ===");
    }
}
