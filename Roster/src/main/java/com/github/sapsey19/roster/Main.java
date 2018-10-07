/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.roster;

import java.util.Collections;

/**
 *
 * @author sapse
 */
public class Main {
    public static void main(String [] args) {
        RosterList roster = new RosterList();
        Athlete john = new Athlete("John", "Baseball", "Sophomore");
        Athlete joe = new Athlete("Joe", "Basketball", "Freshman");
        roster.add(john);
        roster.add(joe);
        System.out.println("Is John in the roster?: " + roster.contains(john));
        System.out.println("Joe's sport: " + roster.getSport(joe));
        System.out.println("Joe's year: " + roster.getYear(joe));
        
    }
}
