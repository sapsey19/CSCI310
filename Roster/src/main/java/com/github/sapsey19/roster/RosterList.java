/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.roster;

import java.util.ArrayList;

/**
 *
 * @author sapse
 */
public class RosterList extends ArrayList<Athlete> {

    String getSport(Athlete athleteName) {
        for (Athlete athlete : this) {
            if (athlete == athleteName) {
                return athlete.sport;
            }
        }
        return "Athlete not found.";
    }

    boolean hasAthlete(Athlete athleteName) {
        for (Athlete athlete : this) {
            if (athlete == athleteName) {
                return true;
            }
        }
        return false;
    }

    String getYear(Athlete athleteName) {
        for (Athlete athlete : this) {
            if (athlete == athleteName) {
                return athlete.year;
            }
        }
        return "Athlete name not found.";
    }
}
