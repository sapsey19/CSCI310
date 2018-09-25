/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.collections;

/**
 *
 * @author sapse
 */
class Cart {
    Customer customer;
    Market market;
    Items items = new Items();

    Cart(Market aThis, Customer alice) {
        market = aThis;
        customer = alice;
    }
    
    void addItem(String name) {
        for(Item marketItem: market.items) 
        {
            if(marketItem.name.equals(name))
            {
                items.add(marketItem);
                market.items.remove(marketItem);
                return;
            }
        }
        throw new IllegalStateException("Item " + name + " does not exist.");
    }

    boolean hasItemByName(String name) {
        return items.hasItemByName(name);
    }

    void checkout() {
        if(customer.moneyInCents >= items.totalInCents())
        {
            customer.moneyInCents -= items.totalInCents();
            customer.items.addAll(items);            
            items.clear();            
        }
        else
            throw new IllegalStateException("Not enough money.");
    }
    
}
