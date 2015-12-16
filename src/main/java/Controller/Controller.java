/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOFileImpl;
import DAO.DAOInterface;
import DTO.Animal;
import DTO.Cat;
import DTO.Dog;
import com.bill.consoleio.ConsoleIO;
import java.util.ArrayList;

/**
 *
 * @author Bill
 */
public class Controller {

    ConsoleIO io = new ConsoleIO();
    DAOInterface dao = new DAOFileImpl();

    public void run() {

        int choice;

        io.printOut("Kennel program start");
        do {

            io.printOut("--------------------");
            io.printOut("What do you want to do?");
            io.printOut("1 - View all animals");
            io.printOut("2 - View animals by criteria");
            io.printOut("3 - Add an animal");
            io.printOut("4 - Delete an animal");
            io.printOut("5 - Edit an animal's info");
            io.printOut("6 - Search for an animal based on criteria");
            io.printOut("7 - Exit program");

            io.printOut("---------------------");
            choice = io.promptForInt("Press number and then the enter button");

            switch (choice) {
                case 1:
                    viewAllAnimals();
                    break;
                case 2:
                    viewAnimalsByCriteria();
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
                    searchForAnimal();
                    break;
                default:
                    io.printOut("Unrecognized command");

                    break;
            }
        } while (choice != 7);

    }

    public void viewAllAnimals() {

        ArrayList<Animal> kennel = dao.viewAnimals();
        io.printOut("List of animals: (total number: "+kennel.size()+")");
        io.printOut("----------------");
        for (Animal currentAnimal : kennel) {

            io.printOut("Animal name: " + currentAnimal.getName());
        }
        io.printOut("----------------");
        io.printOut("Animal list end.");
    }

    public void viewAnimalsByCriteria() {

    }

    public void addAnimal() {
        Dog d = new Dog();
        Cat c = new Cat();
        io.printOut("Answer the following:");
        String type = io.promptForString("Is new animal a dog (d) or cat (c)?");
        String breed = io.promptForString("Animal's breed?");
        String name = io.promptForString("Animal's name?");
        String gender = io.promptForString("Animal's gender?");
        int age = io.promptForInt("Animal's age?");
        String disposition = io.promptForString("Animal's disposition?");
        int weight = io.promptForInt("Animal's weight?");

        if (type.equals("d")) {
            d.setBreed(breed);
            d.setName(name);
            d.setGender(gender);
            d.setAge(age);
            d.setDisposition(disposition);
            d.setWeight(weight);
            dao.addDog(d);
        } else if (type.equals("c")) {
            c.setBreed(breed);
            c.setName(name);
            c.setGender(gender);
            c.setAge(age);
            c.setDisposition(disposition);
            c.setWeight(weight);
            dao.addCat(c);
        } else {
            io.printOut("Unrecognized command... Going back");
        }
    }

    public void deleteAnimal() {

    }

    public void editAnimalInfo() {

    }

    public void searchForAnimal() {

    }

}
