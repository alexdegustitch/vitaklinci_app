/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vitaklinci;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author uSER
 */
public class Table {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VitaklinciPU");
    static EntityManager em = emf.createEntityManager();
    private Contestent[] contestents = new Contestent[72];
    {
        for(int i=0;i<contestents.length;i++)
            contestents[i] = new Contestent();
        
        contestents[0].setAll(1, 4, 1);
        contestents[1].setAll(1, 4, 1);
        contestents[2].setAll(1, 5, 1);
        contestents[3].setAll(1, 4, 1);
        contestents[4].setAll(1, 3, 3);
        contestents[5].setAll(1, 3, 3);
        contestents[6].setAll(1, 3, 3);
        contestents[7].setAll(1, 2, 3);
        contestents[8].setAll(2, 3, 2);
        contestents[9].setAll(2, 4, 4);
        contestents[10].setAll(2, 3, 4);
        contestents[11].setAll(1, 3, 1);
        contestents[12].setAll(2, 3, 5);
        contestents[13].setAll(1, 2, 4);
        contestents[14].setAll(1, 3, 5);
        contestents[15].setAll(1, 3, 5);
        contestents[16].setAll(1, 2, 4);
        contestents[17].setAll(5, 4, 1);
        contestents[18].setAll(1, 2, 4);
        contestents[19].setAll(1, 3, 1);
        contestents[20].setAll(1, 4, 2);
        contestents[21].setAll(1, 4, 4);
        contestents[22].setAll(4, 5, 2);
        contestents[23].setAll(1, 3, 5);
        contestents[24].setAll(1, 4, 1);
        contestents[25].setAll(1, 3, 4);
        contestents[26].setAll(1, 3, 1);
        contestents[27].setAll(1, 3, 1);
        contestents[28].setAll(2, 2, 4);
        contestents[29].setAll(2, 2, 5);
        contestents[30].setAll(1, 3, 5);
        contestents[31].setAll(1, 4, 2);
        contestents[32].setAll(1, 5, 4);
        contestents[33].setAll(1, 5, 4);
        contestents[34].setAll(1, 5, 4);
        contestents[35].setAll(4, 5, 4);
        contestents[36].setAll(1, 5, 5);
        contestents[37].setAll(1, 3, 5);
        contestents[38].setAll(2, 4, 1);
        contestents[38].setAll(2, 3, 1);
        contestents[40].setAll(5, 5, 5);
        contestents[41].setAll(5, 5, 4);
        contestents[42].setAll(5, 5, 5);
        contestents[43].setAll(5, 5, 5);
        contestents[44].setAll(1, 3, 4);
        contestents[45].setAll(1, 3, 3);
        contestents[46].setAll(2, 2, 5);
        contestents[47].setAll(2, 2, 5);
        contestents[48].setAll(2, 2, 5);
        contestents[49].setAll(2, 2, 5);
        
        contestents[50].setAll(1, 4, 5);
        contestents[51].setAll(1, 2, 5);
        contestents[52].setAll(2, 5, 1);
        contestents[53].setAll(2, 3, 1);
        contestents[54].setAll(2, 3, 1);
        contestents[55].setAll(1, 3, 1);
        contestents[56].setAll(1, 1, 5);
        contestents[57].setAll(5, 1, 5);
        contestents[58].setAll(5, 1, 5);
        contestents[59].setAll(5, 1, 5);
        contestents[60].setAll(2, 3, 3);
        contestents[61].setAll(2, 3, 3);
        contestents[62].setAll(1, 3, 3);
        contestents[63].setAll(2, 4, 1);
        contestents[64].setAll(1, 2, 1);
        contestents[65].setAll(2, 3, 3);
        contestents[66].setAll(1, 4, 1);
        contestents[67].setAll(3, 2, 5);
        contestents[68].setAll(1, 4, 3);
        contestents[69].setAll(1, 5, 4);
        contestents[70].setAll(1, 5, 4);
        contestents[71].setAll(1, 3, 3);
        em.getTransaction().begin();
        for(int i=0;i<contestents.length;i++){
            contestents[i].setId(i);
            em.persist(contestents[i]);
        }
        
        em.getTransaction().commit();
    }
    
    public Contestent getContestent(int num){
        return contestents[num];
    }
}
