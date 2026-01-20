package com.nurdaulet.vetclinic;

public class Veterinarian extends Person {


    private int vetId;
    private String specialization;
    private int experienceYears;
    private boolean available;


    public Veterinarian(int id, String name, int age,
                        int vetId, String specialization,
                        int experienceYears, boolean available) {

        // MUST be first line (Week 4 requirement)
        super(id, name, age);

        this.vetId = vetId;
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        this.available = available;
    }


    public Veterinarian() {
        super(0, "Белгісіз", 0);
        this.vetId = 0;
        this.specialization = "Жалпы";
        this.experienceYears = 0;
        this.available = false;
    }


    public int getVetId() {
        return vetId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public boolean isAvailable() {
        return available;
    }


    public void setVetId(int vetId) {
        this.vetId = vetId;
    }

    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.trim().isEmpty()) {
            this.specialization = specialization;
        } else {
            this.specialization = "General";
            System.out.println("Specialization cannot be empty!");
        }
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        } else {
            this.experienceYears = 0;
            System.out.println("Experience years cannot be negative!");
        }
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public boolean isExperienced() {
        return experienceYears >= 5;
    }


    public boolean canTreat(String species) {
        return available && specialization.equalsIgnoreCase(species);
    }


    @Override
    public void work() {
        System.out.println("Veterinarian " + name +
                " is treating animals (" + specialization + ").");
    }

    @Override
    public String getRole() {
        return "Veterinarian";
    }

    @Override
    public String toString() {
        return "[VETERINARIAN] Name: " + name +
                ", Age: " + age +
                ", Vet ID: " + vetId +
                ", Specialization: " + specialization +
                ", Experience: " + experienceYears + " years";
    }
}
