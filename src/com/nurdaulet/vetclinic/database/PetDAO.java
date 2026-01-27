package com.nurdaulet.vetclinic.database;

import com.nurdaulet.vetclinic.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetDAO {

    public void insertPet(Pet pet) {

        String sql = "INSERT INTO pet (pet_id, name, species, age, vaccinated) " +
                "VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, pet.getPetId());
            statement.setString(2, pet.getName());
            statement.setString(3, pet.getSpecies());
            statement.setInt(4, pet.getAge());
            statement.setBoolean(5, pet.isVaccinated());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Pet inserted successfully!");
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void getAllPets() {

        String sql = "SELECT * FROM pet";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n--- ALL PETS FROM DATABASE ---");

            while (resultSet.next()) {
                int id = resultSet.getInt("pet_id");
                String name = resultSet.getString("name");
                String species = resultSet.getString("species");
                int age = resultSet.getInt("age");
                boolean vaccinated = resultSet.getBoolean("vaccinated");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Species: " + species);
                System.out.println("Age: " + age);
                System.out.println("Vaccinated: " + vaccinated);
                System.out.println("----");
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

}
