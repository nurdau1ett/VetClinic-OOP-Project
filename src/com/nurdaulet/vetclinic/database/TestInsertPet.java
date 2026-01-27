package com.nurdaulet.vetclinic.database;

import com.nurdaulet.vetclinic.Pet;

public class TestInsertPet {

    public static void main(String[] args) {

        Pet pet = new Pet(1001, "Buddy", "Dog", 3, true);

        PetDAO dao = new PetDAO();
        dao.insertPet(pet);
    }
}
