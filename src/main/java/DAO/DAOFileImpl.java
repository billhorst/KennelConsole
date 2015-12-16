/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Animal;
import DTO.Cat;
import DTO.Dog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Bill
 */
public class DAOFileImpl implements DAOInterface {

    HashMap kennel = new HashMap<>();
    static int number;

    @Override
    public ArrayList viewAnimals() {
        Collection<Animal> animals = kennel.values();
        ArrayList<Animal> list = new ArrayList<>();
        list.addAll(animals);
        return list;
    }

    @Override
    public void addDog(Dog d) {
        kennel.put(number, d);
        number++;
    }

    @Override
    public void addCat(Cat c) {
        kennel.put(number, c);
        number++;
    }

}
