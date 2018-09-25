package com.github.sapsey19.collections;


/*
 * @author sapse
 */
public class Market {

    Items items = new Items();                    //Items is an ArrayList of item, a Market has Items
    // Registers registers;
    // Customers customers;

    void addItem(String name, int priceInCents) {
        items.add(new Item(name, priceInCents));
    }

    void printSales(int discountInPercent) {
        for (Item item : items) {
            int discountPrice = item.priceInCents * (100 - discountInPercent) / 100;
            System.out.println("buy " + item.name + " for only " + discountPrice + " cents");
        }
    }
    
    boolean hasItemByName(String name) {
        return items.hasItemByName(name);
    }

    Cart getCartFor(Customer alice) {
        return new Cart(this, alice);
        
    }

  

}
