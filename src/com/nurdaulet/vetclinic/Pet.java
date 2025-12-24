package com.nurdaulet.vetclinic;

public class Pet {

    // 1️⃣ PRIVATE FIELDS (кемі 4)
    private int petId;
    private String name;
    private String species;
    private int age;
    private boolean vaccinated;

    // 2️⃣ PARAMETERIZED CONSTRUCTOR (барлық field)
    public Pet(int petId, String name, String species, int age, boolean vaccinated) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.age = age;
        this.vaccinated = vaccinated;
    }

    // 3️⃣ DEFAULT CONSTRUCTOR
    public Pet() {
        this.petId = 0;
        this.name = "Белгісіз";
        this.species = "Белгісіз";
        this.age = 0;
        this.vaccinated = false;
    }

    // 4️⃣ GETTERS
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

    // 5️⃣ SETTERS
    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    // 6️⃣ LOGIC METHODS (кемі 2)

    // Жануар жас па?
    public boolean isYoung() {
        return age < 2;
    }

    // Вакцина салу
    public void vaccinate() {
        if (!vaccinated) {
            vaccinated = true;
        }
    }

    // 7️⃣ toString()
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
