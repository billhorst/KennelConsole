/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Animal;
import DTO.Cat;
import DTO.Dog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Bill
 */
public interface DAOInterface {
    
    public ArrayList viewAnimals();
    public void addDog(Dog d);
    public void addCat(Cat c);
    public void loadAnimals() throws Exception;
    public void saveAnimals() throws IOException;
    public Animal getAnimal(Integer number);
    public ArrayList searchAnimals(String name);
    public void deleteAnimal(int num);
    
}
