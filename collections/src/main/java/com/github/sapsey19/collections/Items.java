/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.collections;

import java.util.ArrayList;

/**
 *
 * @author sapse
 */
class Items extends ArrayList<Item>{

    boolean hasItemByName(String name) {
        boolean hasItem = false;
        for(Item item: this)
        {
            if(item.name.equals(name))
                hasItem = true;
        }
        return hasItem;
    }
    
    int totalInCents()
    {
        int sum = 0;
        for(Item item: this)
        {
            sum+= item.priceInCents;
        }
        return sum;
    }
    
}
