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
public class Points {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int tim1, tim2;
    private int poeni1, poeni2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTim1() {
        return tim1;
    }

    public void setTim1(int tim1) {
        this.tim1 = tim1;
    }

    public int getTim2() {
        return tim2;
    }

    public void setTim2(int tim2) {
        this.tim2 = tim2;
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
    
    
}
