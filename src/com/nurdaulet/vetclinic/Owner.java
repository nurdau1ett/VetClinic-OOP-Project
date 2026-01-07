package com.nurdaulet.vetclinic;

public class Owner {


    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;
    private boolean frequentClient;


    public Owner(int ownerId, String name, String phone, int numberOfPets, boolean frequentClient) {
        this.ownerId = ownerId;
        setName(name);
        setPhone(phone);
        setNumberOfPets(numberOfPets);
        this.frequentClient = frequentClient;
    }


    public Owner() {
        this.ownerId = 0;
        this.name = "Белгісіз";
        this.phone = "Жоқ";
        this.numberOfPets = 0;
        this.frequentClient = false;
    }


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


    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
            System.out.println("Owner name cannot be empty!");
        }
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
