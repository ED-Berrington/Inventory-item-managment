/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package inventory;

/**
 *
 * @author edoua
 */
public interface InventoryService {
    void addnewItem(int itemId,String itemName, int quantity, double price);
    void deleteItem(int itemId);
    void updateItem(int itemId, String newName,int newQuantity,double newPrice);
    Item findItem(int itemId);
    void showItems();
}
