/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edoua
 */
public class InventoryDaoImpl implements InventoryDAO{
    private List<Item> items;
    private File file;

    public InventoryDaoImpl() {
        this.items = new ArrayList<>() ;
        this.file=new File("inventory.txt");
        createFile(file);
    }
    

    public boolean createFile(String path) {
        return createFile(new File(path));
    }

    public boolean createFile(File file) {
       if(!file.exists()){
       try{
       return file.createNewFile();}
       catch(IOException e){
       return false;
       }
       }
       else return file.exists();
        
    }

    @Override
    public void add(Item item) {
        items.add(item);
        
        try {
            writeToFile(file,items);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void delete(int itemId) {
     
    loadItemsFromFile();

    Item itemToRemove = null;
    for (Item item : items) {
        if (item.getId() == itemId) {
            itemToRemove = item;
            break;
        }
    }
    
    if (itemToRemove != null) {
        items.remove(itemToRemove);

        
        try {
            writeToFile(file, items);
            System.out.println("Item removed successfully.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } else {
        System.out.println("Item with ID " + itemId + " not found.");
    }
        }
        
    

    @Override
   public void update(Item updatedItem) {
    // Load items from the file
    loadItemsFromFile();

    // Find the item to update
    for (Item item : items) {
        if (item.getId() == updatedItem.getId()) {
            // Update the item's properties with new values
            item.setName(updatedItem.getName());
            item.setQuantity(updatedItem.getQuantity());
            item.setPrice(updatedItem.getPrice());
            break;
        }
    }
    try {
        writeToFile(file, items);
        System.out.println("Item updated successfully.");
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

    public void writeToFile(File file,List <Item> items) throws IOException{
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(file))){
    for(Item item: items){
        bw.write(item.getId()+","+item.getName()+","+item.getPrice()+","+item.getQuantity()+"\n");
    }
    }
    }
    

    @Override
public Item search(int itemId) {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            if (id == itemId) {
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);
                
                Item item = new Item(id, name, quantity, price);
                System.out.println("Item found:");
                System.out.println("ID: " + item.getId());
                System.out.println("Name: " + item.getName());
                System.out.println("Price: " + item.getPrice());
                System.out.println("Quantity: " + item.getQuantity());
                return item;
            }
        }
        System.out.println("Item with ID " + itemId + " not found.");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}
    
    public List<Item> showItems(){
        List<Item> items=new ArrayList<>();
    try(BufferedReader br=new BufferedReader(new FileReader(file))){
    String line;
    while((line=br.readLine()) !=null){
    String[] parts=line.split(",");
        int id=Integer.parseInt(parts[0]);
        String name=parts[1];
        int quantity=Integer.parseInt(parts[3]);
       double price=Double.parseDouble(parts[2]);
        Item item=new Item(id,name,quantity,(int)price);
        items.add(item);
    }
    }catch(IOException e){
        e.printStackTrace();
    }
    return items;
    }
    
    private void loadItemsFromFile() {
    items.clear(); 

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            double price = Double.parseDouble(parts[2]);
            int quantity = Integer.parseInt(parts[3]);
            Item item = new Item(id, name, quantity, price);
            items.add(item);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
