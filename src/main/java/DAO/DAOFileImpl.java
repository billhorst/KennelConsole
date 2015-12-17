/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Animal;
import DTO.Cat;
import DTO.Dog;
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
    public static int number;
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
    public void addDog(Dog d) {
        d.setNum(number);
        kennel.put(number, d);
        number++;
    }

    @Override
    public void addCat(Cat c) {
        c.setNum(number);
        kennel.put(number, c);
        number++;
    }

    @Override
    public void loadAnimals() throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(ANIMALLIST)));
        String currentLine;
        String[] currentTokens;
        
        while(sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMETER);
            
            Animal currentAnimal = new Animal() {};
            currentAnimal.setNum(Integer.parseInt(currentTokens[0]));
            currentAnimal.setBreed(currentTokens[1]);
            currentAnimal.setName(currentTokens[2]);
            currentAnimal.setGender(currentTokens[3]);
            currentAnimal.setAge(Integer.parseInt(currentTokens[4]));
            currentAnimal.setDisposition(currentTokens[5]);
            currentAnimal.setWeight(Integer.parseInt(currentTokens[6]));
            kennel.put(Integer.parseInt(currentTokens[0]), currentAnimal);
            number = Integer.parseInt(currentTokens[0]+1);
        }
    }

    @Override
    public void saveAnimals() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(ANIMALLIST));
        for (int i = 0; i < kennel.size(); i++) {
            out.println(this.getAnimal(i).getNum() + DELIMETER +
                    this.getAnimal(i).getBreed() + DELIMETER + 
                    this.getAnimal(i).getName() + DELIMETER + 
                    this.getAnimal(i).getGender() + DELIMETER + 
                    this.getAnimal(i).getAge() + DELIMETER +
                    this.getAnimal(i).getDisposition() + DELIMETER +
                    this.getAnimal(i).getWeight());
            out.flush();
        }
        out.close();

    }
    
    @Override
    public Animal getAnimal(Integer number) {
        return (Animal) kennel.get(number);
    }


}
