package com.nurdaulet.vetclinic;

public class Veterinarian {


    private int vetId;
    private String name;
    private String specialization;
    private int experienceYears;
    private boolean available;


    public Veterinarian(int vetId, String name, String specialization, int experienceYears, boolean available) {
        this.vetId = vetId;
        setName(name);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        this.available = available;
    }


    public Veterinarian() {
        this.vetId = 0;
        this.name = "Белгісіз";
        this.specialization = "Жалпы";
        this.experienceYears = 0;
        this.available = false;
    }


    public int getVetId() {
        return vetId;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
            System.out.println("Veterinarian name cannot be empty!");
        }
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
    public String toString() {
        return "Veterinarian{" +
                "vetId=" + vetId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                ", available=" + available +
                '}';
    }
}
