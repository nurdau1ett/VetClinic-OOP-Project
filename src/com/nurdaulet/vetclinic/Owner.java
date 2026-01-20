package com.nurdaulet.vetclinic;

public class Owner extends Person {


    private int ownerId;
    private String phone;
    private int numberOfPets;
    private boolean frequentClient;


    public Owner(int id, String name, int age,
                 String phone, int numberOfPets, boolean frequentClient) {

        super(id, name, age);
        this.phone = phone;
        this.numberOfPets = numberOfPets;
        this.frequentClient = frequentClient;
    }


    public Owner() {
        super(0, "Белгісіз", 0);
        this.ownerId = 0;
        this.phone = "Жоқ";
        this.numberOfPets = 0;
        this.frequentClient = false;
    }


    public int getOwnerId() {
        return ownerId;
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


    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }


    public void setPhone(String phone) {
        if (phone != null && phone.startsWith("+7")) {
            this.phone = phone;
        } else {
            this.phone = "Invalid";
            System.out.println("Phone number is invalid!");
        }
    }

    public void setNumberOfPets(int numberOfPets) {
        if (numberOfPets >= 0) {
            this.numberOfPets = numberOfPets;
            this.frequentClient = numberOfPets >= 3;
        } else {
            this.numberOfPets = 0;
        }
    }


    public void setFrequentClient(boolean frequentClient) {
        this.frequentClient = frequentClient;
    }


    public void addPet() {
        this.numberOfPets++;
        if (this.numberOfPets >= 3) {
            this.frequentClient = true;
        }
    }


    public boolean checkFrequentClient() {
        return numberOfPets >= 3;
    }

    @Override
    public void work() {
        System.out.println("Owner " + name + " is taking care of pets.");
    }

    @Override
    public String getRole() {
        return "Owner";
    }

    @Override
    public String toString() {
        return "[OWNER] Name: " + name +
                ", Age: " + age +
                ", Phone: " + phone +
                ", Pets: " + numberOfPets +
                ", Frequent client: " + frequentClient;
    }
}
