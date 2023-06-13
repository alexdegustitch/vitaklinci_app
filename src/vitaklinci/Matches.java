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
public class Matches {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int igrac1, igrac2;
    
    private int poeni1, poeni2;
    
    private String tip;
    
    private int turnir;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPoeni1() {
        return poeni1;
    }

    public void setPoeni1(int poeni1) {
        this.poeni1 = poeni1;
    }

    public int getPoeni2() {
        return poeni2;
    }

    public void setPoeni2(int poeni2) {
        this.poeni2 = poeni2;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getTurnir() {
        return turnir;
    }

    public void setTurnir(int turnir) {
        this.turnir = turnir;
    }
    
    
}
