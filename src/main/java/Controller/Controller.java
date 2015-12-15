/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.bill.consoleio.ConsoleIO;
import java.io.Console;

/**
 *
 * @author Bill
 */
public class Controller {
    
    ConsoleIO io = new ConsoleIO();
    
    public void run() {
        
        io.printOut("Kennel program start");
        io.printOut("--------------------");
        io.printOut("What do you want to do?");
        io.printOut("1 - View all animals");
        io.printOut("2 - View animals by criteria");
        io.printOut("3 - Add an animal");
        io.printOut("4 - Delete an animal");
        io.printOut("5 - Edit an animal's info");
        io.printOut("6 - Search for an animal based on criteria");
        
    }
    
}
