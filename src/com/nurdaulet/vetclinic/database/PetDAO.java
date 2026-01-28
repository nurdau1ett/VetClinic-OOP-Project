package com.nurdaulet.vetclinic.database;

import com.nurdaulet.vetclinic.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        String sql = "SELECT * FROM pet WHERE deleted = FALSE";
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

    public Pet getPetById(int petId) {

        String sql = "SELECT * FROM pet WHERE pet_id = ? AND deleted = FALSE\n";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, petId);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Pet(
                        rs.getInt("pet_id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getInt("age"),
                        rs.getBoolean("vaccinated")
                );
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }

    public boolean updatePet(Pet pet) {

        String sql = "UPDATE pet SET name = ?, species = ?, age = ?, vaccinated = ? " +
                "WHERE pet_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pet.getName());
            statement.setString(2, pet.getSpecies());
            statement.setInt(3, pet.getAge());
            statement.setBoolean(4, pet.isVaccinated());
            statement.setInt(5, pet.getPetId()); // WHERE

            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("Pet updated successfully!");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public boolean deletePet(int petId) {

        String sql = "UPDATE pet SET deleted = TRUE WHERE pet_id = ?\n";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, petId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println("Pet deleted (ID: " + petId + ")");
                return true;
            } else {
                System.out.println("No pet found with ID: " + petId);
            }

        } catch (SQLException e) {
            System.out.println("Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }



    public List<Pet> searchPetsByName(String name) {

        List<Pet> pets = new ArrayList<>();

        String sql = "SELECT * FROM pet WHERE name ILIKE ? AND deleted = FALSE";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return pets;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Pet pet = new Pet(
                        rs.getInt("pet_id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getInt("age"),
                        rs.getBoolean("vaccinated")
                );
                pets.add(pet);
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Search by name failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return pets;
    }




    public List<Pet> searchPetsByAgeRange(int minAge, int maxAge) {

        List<Pet> pets = new ArrayList<>();

        String sql = "SELECT * FROM pet WHERE age BETWEEN ? AND ? AND deleted = FALSE";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return pets;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);
            statement.setInt(2, maxAge);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Pet pet = new Pet(
                        rs.getInt("pet_id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getInt("age"),
                        rs.getBoolean("vaccinated")
                );
                pets.add(pet);
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Search by age range failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return pets;
    }




    public List<Pet> searchByMinAge(int minAge) {

        List<Pet> pets = new ArrayList<>();

        String sql =
                "SELECT * FROM pet " +
                        "WHERE age >= ? AND deleted = FALSE " +
                        "ORDER BY age DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return pets;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                pets.add(new Pet(
                        rs.getInt("pet_id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getInt("age"),
                        rs.getBoolean("vaccinated")
                ));
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return pets;
    }






}
