/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFileImpl;
import DAO.DAOInterface;
import DTO.Animal;
import com.bill.consoleio.ConsoleIO;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Bill
 */
public class Controller {

    ConsoleIO io = new ConsoleIO();
    DAOInterface dao = new DAOFileImpl();

    public void run() {

        //upon running the program, loads animals from animals.txt
        loadAnimals();

        int choice;

        io.printOut("Kennel program start");
        do {

            io.printOut("--------------------");
            io.printOut("What do you want to do?");
            io.printOut("1 - View all animals");
            io.printOut("2 - Search for an animal by name");
            io.printOut("3 - Add an animal");
            io.printOut("4 - Delete an animal");
            io.printOut("5 - Edit an animal's info");
            io.printOut("6 - Save animal list");
            io.printOut("7 - Exit");

            io.printOut("---------------------");

            choice = io.promptForInt("Press number and then the enter button", 1, 7);

            switch (choice) {
                case 1:
                    viewAllAnimals();
                    break;
                case 2:
                    searchForAnimal();
                    break;
                case 3:
                    addAnimal();
                    break;
                case 4:
                    deleteAnimal();
                    break;
                case 5:
                    editAnimalInfo();
                    break;
                case 6:
                    saveAnimals();
                    break;
                case 7:
                    io.printOut("Bye");
                    break;
                default:
                    io.printOut("Unrecognized command");
            }
        } while (choice != 7);

    }

    public void viewAllAnimals() {

        ArrayList<Animal> kennel = dao.viewAnimals();
        io.printOut("List of animals: (total number: " + kennel.size() + ")");
        io.printOut("----------------");
        for (Animal currentAnimal : kennel) {

            io.printOut("Name: " + currentAnimal.getName()
                    + "(Serial # " + currentAnimal.getNum() + ")");
        }
        io.printOut("----------------");
        io.printOut("Animal list end.");
    }

    public void addAnimal() {
        Animal a = new Animal() {
        };
        io.printOut("Answer the following:");
        String breed = io.promptForString("Animal's breed?");
        String name = io.promptForString("Animal's name?");
        String gender = io.promptForString("Animal's gender?");
        int age = io.promptForInt("Animal's age?");
        String disposition = io.promptForString("Animal's disposition?");
        double weight = io.promptForDouble("Animal's weight?");

        a.setBreed(breed);
        a.setName(name);
        a.setGender(gender);
        a.setAge(age);
        a.setDisposition(disposition);
        a.setWeight(weight);
        dao.addAnimal(a);
        
        io.printOut(name+" added.");

    }

    public void deleteAnimal() {
        String delete = "";
        String name = io.promptForString("What's the name of the animal to delete?");
        ArrayList<Animal> results = dao.searchAnimals(name);
        for (Animal currentAnimal : results) {
            io.printOut(currentAnimal.getNum() + currentAnimal.getName());
        }
        if (results.size() == 0) {
            io.printOut("No results...");
        } else if (results.size() == 1) {
            delete = io.promptForString("Delete " + results.get(0).getName() + "? (y) / (n)");
            if (delete.equals("y")) {
                dao.deleteAnimal(results.get(0).getNum());
                io.printOut("--------");
                io.printOut("Deleted");
                io.printOut("--------");
            }
        } else {
            io.printOut("There are two or more animals with that name.");
            int animalDeleteNum = io.promptForInt("Enter number of animal to delete.");
            delete = io.promptForString("Delete " + dao.getAnimal(animalDeleteNum).getName() + "?");
            if (delete.equals("y")) {
                dao.deleteAnimal(animalDeleteNum);
                io.printOut("--------");
                io.printOut("Deleted");
                io.printOut("--------");
            }
        }
    }

    public void editAnimalInfo() {

        String name = io.promptForString("Name of animal to edit?");

        ArrayList<Animal> results = dao.searchAnimals(name);

        if (results.size() > 0) {

            io.printOut("The following animals match the name of animal to edit:");
            io.printOut("-------------------------------------------------------");

            for (Animal currentAnimal : results) {
                io.printOut("Serial Number: " + currentAnimal.getNum()
                        + "\nName: " + currentAnimal.getName() + " (" + currentAnimal.getGender() + ")"
                        + "\nBreed: " + currentAnimal.getBreed()
                        + "\nAge: " + currentAnimal.getAge()
                        + "\nDisposition: " + currentAnimal.getDisposition()
                        + "\nWeight: " + currentAnimal.getWeight());
            }
            int animalNumber;
            try {
                io.printOut("---------------------------------------------");
                animalNumber = io.promptForInt("Enter serial number of animal to edit.");

                Animal oldAnimal = dao.getAnimal(animalNumber);

                Animal newAnimal = new Animal() {
                };

                newAnimal.setNum(animalNumber);
                io.printOut("Old name: " + oldAnimal.getName());
                newAnimal.setName(io.promptForString("New name: "));
                io.printOut("Old gender: " + oldAnimal.getGender());
                newAnimal.setGender(io.promptForString("New gender: "));
                io.printOut("Old breed: " + oldAnimal.getBreed());
                newAnimal.setBreed(io.promptForString("New breed: "));
                io.printOut("Old age: " + oldAnimal.getAge());
                newAnimal.setAge(io.promptForInt("New age: "));
                io.printOut("Old disposition: " + oldAnimal.getDisposition());
                newAnimal.setDisposition(io.promptForString("New disposition: "));
                io.printOut("Old weight: " + oldAnimal.getWeight());
                newAnimal.setWeight(io.promptForDouble("New weight: "));

                dao.editAnimal(newAnimal);

            } catch (Exception e) {
                System.out.println("Animal not found.");
            }
        } else {
            io.printOut("Animal not found.");
        }

    }

    public void searchForAnimal() {
        String name = io.promptForString("Enter the name of the animal to search for.");
        ArrayList<Animal> results = dao.searchAnimals(name);
        for (Animal currentAnimal : results) {
            io.printOut("---------------------------");
            io.printOut("Serial Number: " + currentAnimal.getNum()
                    + "\nName: " + currentAnimal.getName() + " (" + currentAnimal.getGender() + ")"
                    + "\nBreed: " + currentAnimal.getBreed()
                    + "\nAge: " + currentAnimal.getAge()
                    + "\nDisposition: " + currentAnimal.getDisposition()
                    + "\nWeight: " + currentAnimal.getWeight());

            io.printOut("---------------------------");
        };
        if (results.size() == 0) {
            io.printOut("No animals found with that name.");
        }
    }

    public void saveAnimals() {
        try {
            dao.saveAnimals();
            io.printOut("------------------");
            io.printOut("Animal list saved.");
            io.printOut("------------------");
        } catch (Exception e) {
            io.printOut("There was a problem saving.");
        }
    }

    public void loadAnimals() {
        try {
            dao.loadAnimals();
        } catch (Exception e) {
            io.printOut("There was a problem loading.");
        }
    }

}
