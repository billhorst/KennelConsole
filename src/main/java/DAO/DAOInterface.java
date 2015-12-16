/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Cat;
import DTO.Dog;
import java.util.ArrayList;

/**
 *
 * @author Bill
 */
public interface DAOInterface {
    
    public ArrayList viewAnimals();
    public void addDog(Dog d);
    public void addCat(Cat c);
    
}
