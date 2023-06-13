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
public class Contestent {
    
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int energy, health, preparation;
    
    private int points, matchPlayed;
    
    
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void addPoints(int point){
        points+=point;
    }
    public void subPoints(int point){
        points-=point;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPreparation() {
        return preparation;
    }

    public void setPreparation(int preparation) {
        this.preparation = preparation;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public void setAll(int e, int h, int p){
        energy = e;
        health = h;
        preparation = p;
    }
    
    public int getMatchPlayed(){
        return matchPlayed;
    }
    
    public void setMatchPlayed(int matchPlayed){
        this.matchPlayed = matchPlayed;
    }
}
