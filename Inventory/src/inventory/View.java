/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

import java.util.Scanner;

/**
 *
 * @author edoua
 */
public class View {
    static void menu(){
    System.out.println("Enter the number of what you want to do");
    System.out.println("1. Create a new item");
    System.out.println("2. Delete an item");
    System.out.println("3. Update an item");
    System.out.println("4. Search for an item");
    System.out.println("5. show all the items");
    System.out.println("6. exit");
    
    }
    
    static void run(){
        int id;
        int quantity;
        String name;
        String description;
        double price;
        boolean exit=false;
    Scanner scan=new Scanner(System.in);
    InventoryDaoImpl inventoryDao = new InventoryDaoImpl(); 
    InventoryServices inventS=new InventoryServices(inventoryDao);
    
    while(!exit){
    menu();
    String choice=scan.nextLine();
    try{
    switch(choice){
        
            case("1"):
              //make a new item
            System.out.println("Enter the Id of the item");
            
            id=Integer.parseInt(scan.nextLine());
            System.out.println("Enter the name of the item");
            name=scan.nextLine();
            
            
            System.out.println("Enter the price. should be 0.00 format");
            price=Double.parseDouble(scan.nextLine());
            System.out.println("Enter the quantity of the item");
            quantity=Integer.parseInt(scan.nextLine());
            
            inventS.addnewItem(id, name, quantity, price);
            break;
            case("2"):
               //delete an item 
                System.out.println("Enter the Id of the item you wish to delete");
                id=Integer.parseInt(scan.nextLine());
                
                inventS.deleteItem(id);
                break;
             case("3"):
                 //update an item
                 System.out.println("Enter the Id of the item you wish to update");
                 id=Integer.parseInt(scan.nextLine());
                 System.out.println("Enter the new name of the item");
                 name=scan.nextLine();
                 System.out.println("Enter the new price of the item");
                 price=Double.parseDouble(scan.nextLine());
                 System.out.println("Enter the new quantity of the item");
                 quantity=Integer.parseInt(scan.nextLine());
                 
                 inventS.updateItem(id, name, quantity, price);
                 break;
             case("4"):
                 //search for an item
                 System.out.println("Enter the Id of the item you are searching for");
                 id=Integer.parseInt(scan.nextLine());
                 inventS.findItem(id);
                 break;
             case("5"):
             //print all the availible items
                inventS.showItems();
                break;
             case("6"):
                 //exit the program
                 System.out.println("Exiting the program hope you have a good day");
                 exit=true;
                 break;
             default:System.out.println("That is not a valid choice. Please try again");
             break;
    }
    }catch(NumberFormatException e){
        e.printStackTrace();
    }
        catch(Exception e){
        e.printStackTrace();
        }
    
    }
    
    }
public static void main(String[] args){
run();
}

}
