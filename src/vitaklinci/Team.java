/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vitaklinci;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author uSER
 */

@Entity
public class Team {
    
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    private int points;
    
    private int igrac1, igrac2, igrac3, igrac4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getIgrac1() {
        return igrac1;
    }

    public void setIgrac1(int igrac1) {
        this.igrac1 = igrac1;
    }

    public int getIgrac2() {
        return igrac2;
    }

    public void setIgrac2(int igrac2) {
        this.igrac2 = igrac2;
    }

    public int getIgrac3() {
        return igrac3;
    }

    public void setIgrac3(int igrac3) {
        this.igrac3 = igrac3;
    }

    public int getIgrac4() {
        return igrac4;
    }

    public void setIgrac4(int igrac4) {
        this.igrac4 = igrac4;
    }
    
    
    
    
}
