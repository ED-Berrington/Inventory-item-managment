/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

import java.io.IOException;
import java.util.List;

    public  class InventoryServices implements InventoryService{
        private InventoryDaoImpl inventoryDao;

    public InventoryServices(InventoryDaoImpl inventoryDao) {
        this.inventoryDao = inventoryDao;
    }
        
    @Override
    public void addnewItem(int itemId, String itemName, int quantity, double price) {
        inventoryDao.add(new Item(itemId,itemName,quantity,price));
    System.out.println("Product added successfully");
        
    }

    @Override
    public void deleteItem(int itemId) {
        inventoryDao.delete(itemId);
    }

    @Override
    public void updateItem(int itemId, String newName, int newQuantity, double newPrice) {
         Item ex=inventoryDao.search(itemId);
        if(ex!= null){
        ex.setName(newName);
        ex.setQuantity(newQuantity);
        ex.setPrice(newPrice);
        inventoryDao.update(ex);
        }
    }

    @Override
    public Item findItem(int itemId) {
        
        Item item=inventoryDao.search(itemId);
        if(item !=null){
            return item;
    }
            
        return null;
    }
    
       @Override
    public void showItems() {
        List<Item> items = inventoryDao.showItems();
        if (items.isEmpty()) {
            System.out.println("No items found in the inventory.");
        } else {
            System.out.println("Items in the inventory:");
            for (Item item : items) {
                System.out.println(itemDetails(item));
            }
        }
    }

    
    private String itemDetails(Item item) {
        return "ID: " + item.getId() + ", Name: " + item.getName() +
               ", Price: R" + item.getPrice()+ ", Quantity: " + item.getQuantity() ;
    }
}
