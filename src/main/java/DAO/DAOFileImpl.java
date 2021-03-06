/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Animal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Bill
 */
public class DAOFileImpl implements DAOInterface {

    HashMap<Integer, Animal> kennel = new HashMap<>();
    public static Integer number;
    public static final String ANIMALLIST = "animals.txt";
    public static final String DELIMETER = "::";

    @Override
    public ArrayList viewAnimals() {
        Collection<Animal> animals = kennel.values();
        ArrayList<Animal> list = new ArrayList<>();
        list.addAll(animals);
        return list;
    }

    @Override
    public void addAnimal(Animal a) {
        a.setNum(number);
        kennel.put(number, a);
        number++;
    }

    @Override
    public void loadAnimals() throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ANIMALLIST)));
        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMETER);

            Animal currentAnimal = new Animal() {
            };
            currentAnimal.setNum(Integer.parseInt(currentTokens[0]));
            currentAnimal.setBreed(currentTokens[1]);
            currentAnimal.setName(currentTokens[2]);
            currentAnimal.setGender(currentTokens[3]);
            currentAnimal.setAge(Integer.parseInt(currentTokens[4]));
            currentAnimal.setDisposition(currentTokens[5]);
            currentAnimal.setWeight(Double.parseDouble(currentTokens[6]));
            kennel.put(Integer.parseInt(currentTokens[0]), currentAnimal);
            number = Integer.parseInt(currentTokens[0])+1;
        }
    }

    @Override
    public void saveAnimals() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ANIMALLIST));
        for (Animal thisAnimal : kennel.values()) {
            out.println(thisAnimal.getNum() + DELIMETER
                    + thisAnimal.getBreed() + DELIMETER
                    + thisAnimal.getName() + DELIMETER
                    + thisAnimal.getGender() + DELIMETER
                    + thisAnimal.getAge() + DELIMETER
                    + thisAnimal.getDisposition() + DELIMETER
                    + thisAnimal.getWeight());
            out.flush();
        }
        out.close();

    }

    @Override
    public Animal getAnimal(Integer number) {
        return (Animal) kennel.get(number);
    }

    @Override
    public ArrayList searchAnimals(String name) {
        
        Collection<Animal> animals = kennel.values();
        ArrayList<Animal> searchList = new ArrayList<>();
        for (Animal currentAnimal : animals) {
            if(currentAnimal.getName().equals(name)) {
                searchList.add(currentAnimal);
            }
        }        
        return searchList;
    }

    @Override
    public void deleteAnimal(Integer num) {
        kennel.remove(num);
    }

    @Override
    public void editAnimal(Animal animal) {
        kennel.put(animal.getNum(), animal);
    }

    @Override
    public int getMaxAnimalNum() {
        return number;
    }
    
    

}
