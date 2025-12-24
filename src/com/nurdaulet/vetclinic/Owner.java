package com.nurdaulet.vetclinic;

public class Owner {

    // 1️⃣ PRIVATE FIELDS (кемі 4)
    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;
    private boolean frequentClient;

    // 2️⃣ PARAMETERIZED CONSTRUCTOR
    public Owner(int ownerId, String name, String phone, int numberOfPets, boolean frequentClient) {
        this.ownerId = ownerId;
        this.name = name;
        this.phone = phone;
        this.numberOfPets = numberOfPets;
        this.frequentClient = frequentClient;
    }

    // 3️⃣ DEFAULT CONSTRUCTOR
    public Owner() {
        this.ownerId = 0;
        this.name = "Белгісіз";
        this.phone = "Жоқ";
        this.numberOfPets = 0;
        this.frequentClient = false;
    }

    // 4️⃣ GETTERS
    public int getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getNumberOfPets() {
        return numberOfPets;
    }

    public boolean isFrequentClient() {
        return frequentClient;
    }

    // 5️⃣ SETTERS
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }

    public void setFrequentClient(boolean frequentClient) {
        this.frequentClient = frequentClient;
    }

    // 6️⃣ LOGIC METHODS (кемі 2)

    // Жаңа жануар қосу
    public void addPet() {
        this.numberOfPets++;
        if (this.numberOfPets >= 3) {
            this.frequentClient = true;
        }
    }

    // Тұрақты клиент пе?
    public boolean checkFrequentClient() {
        return numberOfPets >= 3;
    }

    // 7️⃣ toString()
    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", numberOfPets=" + numberOfPets +
                ", frequentClient=" + frequentClient +
                '}';
    }
}
