package com.nurdaulet.vetclinic;

public class Pet {

    private int petId;
    private String name;
    private String species;
    private int age;
    private boolean vaccinated;

    public Pet(int petId, String name, String species, int age, boolean vaccinated) {
        this.petId = petId;
        setName(name);
        setSpecies(species);
        setAge(age);
        this.vaccinated = vaccinated;
    }

    public Pet() {
        this.petId = 0;
        this.name = "Белгісіз";
        this.species = "Белгісіз";
        this.age = 0;
        this.vaccinated = false;
    }

    public int getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }


    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Pet name cannot be empty");
        }
        this.name = name;
    }

    public void setSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species cannot be empty");
        }
        this.species = species;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }



    public boolean isYoung() {
        return age < 2;
    }


    public void vaccinate() {
        if (!vaccinated) {
            vaccinated = true;
        }
    }


    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", age=" + age +
                ", vaccinated=" + vaccinated +
                '}';
    }
}
