/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package inventory;

/**
 *
 * @author edoua
 */
public interface InventoryDAO {
    
    
    void add(Item item);
    void delete(int itemiD);
    void update(Item item);
    Item search(int itemId);
    
    
}
