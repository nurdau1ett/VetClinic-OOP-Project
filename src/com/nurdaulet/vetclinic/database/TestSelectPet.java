package com.nurdaulet.vetclinic.database;

public class TestSelectPet {

    public static void main(String[] args) {

        PetDAO dao = new PetDAO();
        dao.getAllPets();
    }
}
