/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Animal;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Bill
 */
public interface DAOInterface {
    
    public ArrayList viewAnimals();
    public void addAnimal(Animal a);
    public void loadAnimals() throws Exception;
    public void saveAnimals() throws IOException;
    public Animal getAnimal(Integer number);
    public ArrayList searchAnimals(String name);
    public void deleteAnimal(Integer num);
    public void editAnimal(Animal animal);
    public int getMaxAnimalNum();
    
}
