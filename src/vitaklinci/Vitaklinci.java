/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vitaklinci;

/**
 *
 * @author uSER
 */
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
public class Vitaklinci extends JFrame {

    /**
     * @param args the command line arguments
     */
    private enum Tim {PECURKOVICI, IMUNOVICI, TROPICI, GROZDICI, OKRUGLICI, SALATICI, ZDRAVKOVICI, LETNJIKOVICI
    , ZACINKOVICI, KRUNICI, TVRDICI, DJUSICI, RUMENICI, KORENICI, SECERKOVICI, VESELJAKOVICI, DOBRICI, ZELENOVICI};
    private enum Mec {OSMINE_FINALA, CETVRTINA_FINALA, POLUFINALE, FINALE}
    private JButton newMatch = new JButton("Novi mec");
    JButton elimination = new JButton("Eliminacija");
        
    
    JButton next = new JButton("Sledeci mec");
    JButton startTour = new JButton("Pokreni mec");
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VitaklinciPU");
    static EntityManager em = emf.createEntityManager();
    private Team[] teams = new Team[18];
    {
        
    }
    private ImageIcon[] images = new ImageIcon[72];
    private JLabel[] labels = new JLabel[72];
    private int[][] tabela = new int[8][2];
    JList list = new JList();
    private int[] raspored = new int[18];
   Table table = new Table();
   int counter = 0;
    int cnt = 0;
    private int[][] cetvrtfinale = new int[4][2];
    private int[][] polufinale = new int[2][2];
    private int[][] finale = new int[1][1];
    private int brMeca = 0, brTima = 0;
    JTextArea team1T = new JTextArea();
        JTextField team2T = new JTextField();
        GridLayout gl1 = new GridLayout(1, 4);
        GridLayout gl2 = new GridLayout(1, 4);
        JPanel panelTeam1 = new JPanel(gl1);
        JPanel panelTeam2 = new JPanel(gl2);
        JPanel points1 = new JPanel(new GridLayout(1, 5));
        JPanel points2 = new JPanel(new GridLayout(1, 5));
        JLabel[] labelsTeam1 = new JLabel[4];
        JLabel[] labelsTeam2 = new JLabel[4];
        JLabel[] pointsL1 = new JLabel[5];
        JLabel[] pointsL2 = new JLabel[5];
        int[] players1 = new int[4];
        int[] players2 = new int[4];
        {
            for(int i=0;i<labelsTeam1.length;i++){
                labelsTeam1[i] = new JLabel();
                labelsTeam2[i] = new JLabel();
            }
        }
        JButton nextTeam = new JButton("Sledeci tim");
        JButton start = new JButton("Kreni");
    
        int m=0;
    public Vitaklinci(){
        super("Vitaklinci");
        setSize(1000, 1000);
        init();
     
        setVisible(true);
                   
    }
    private void rasporedi(){
        raspored = shuffle(18);
    }
    private void init(){
        
        em.getTransaction().begin();
        for(int i=0;i<teams.length;i++){
            teams[i] = new Team();
            teams[i].setName((String)(Tim.values()[i].name()));
            teams[i].setIgrac1(i*4 + 0);
            teams[i].setIgrac2(i*4 + 1);
            teams[i].setIgrac3(i*4 + 2);
            teams[i].setIgrac4(i*4 + 3); 
            teams[i].setId(i);
            em.persist(teams[i]);
        }
        em.getTransaction().commit();
        
        for(int i=0;i<images.length;i++){
            String pic_name = new String(Integer.toString(i+1) + ".jpg");
            images[i] = new ImageIcon(getClass().getResource(pic_name));
            labels[i] = new JLabel(images[i]);
           // add(labels[i]);
        }
        
        for(int i=0;i<4;i++){
            panelTeam1.add(labelsTeam1[i]);
           
            panelTeam2.add(labelsTeam2[i]);
           /* if(i>=4)
                labelsTeam1[i].setText("0");
            else 
                labelsTeam2[i].setText("0");*/
         
        }
        
        for(int i=0;i<5;i++){
            
            pointsL1[i] = new JLabel("0");
            pointsL1[i].setFont(new Font(null, Font.BOLD, 30));
            pointsL2[i] = new JLabel("0");
            pointsL2[i].setFont(new Font(null, Font.BOLD, 30));
            
            points1.add(pointsL1[i]);
            points2.add(pointsL2[i]);
        }
        JPanel s1 = new JPanel(new GridLayout(1, 1));
        JPanel s2 = new JPanel(new GridLayout(1, 1));
        s1.add(panelTeam1);
        s1.add(points1);
        s2.add(panelTeam2);
        s2.add(points2);
        
        JPanel s = new JPanel(new GridLayout(2, 1));
       // add(s1, "North");
       // add(s2, "South");
        add(s1, "North");
        add(s2, "South");
      
        nextTeam.addActionListener((ae) -> {
            nextTeam();
            for(int i=0;i<pointsL1.length;i++){
                pointsL1[i].setText("0");
                pointsL2[i].setText("0");
            }
            m=0;
        });
        
        start.addActionListener((ae) -> {
            next.setEnabled(false);
            System.out.println("USAO");
            if(m >= 4){
                
                m = 0;
                for(int i=0;i<pointsL1.length;i++){
                pointsL1[i].setText("0");
                pointsL2[i].setText("0");
            }
            }
            Random rand = new Random();
            
            int skill = rand.nextInt(3);
            int strenth1 = 0;
            int strenth2 = 0;
            
            switch(skill){
                case 0: strenth1 = table.getContestent(players1[m]).getEnergy(); strenth2 = table.getContestent(players2[m]).getEnergy(); break;
                case 1: strenth1 = table.getContestent(players1[m]).getHealth(); strenth2 = table.getContestent(players2[m]).getHealth(); break;
                case 2: strenth1 = table.getContestent(players1[m]).getPreparation(); strenth2 = table.getContestent(players2[m]).getPreparation(); break;
            }
            System.out.println("");
            System.out.println(strenth1 + " " + strenth2 + " " + m);
            int rndPoints1 = rand.nextInt(6);
            int rndPoints2 = rand.nextInt(6);
            rndPoints1*=strenth1;
            rndPoints2*=strenth2;
            System.out.println("DOSAO OVDE");
            int pts1  = Integer.parseInt(pointsL1[m].getText());
            pts1+=rndPoints1;
            pointsL1[m].setText(Integer.toString(pts1));
            pts1  = Integer.parseInt(pointsL1[4].getText());
            pts1+=rndPoints1;
            pointsL1[4].setText(Integer.toString(pts1));
            
            int pts2  = Integer.parseInt(pointsL2[m].getText());
            pts2+=rndPoints2;
            pointsL2[m].setText(Integer.toString(pts2));
            pts2  = Integer.parseInt(pointsL2[4].getText());
            pts2+=rndPoints2;
            pointsL2[4].setText(Integer.toString(pts2));
           
            Matches mec = new Matches();
            mec.setId(400);
            mec.setIgrac1(players1[m]);
            mec.setIgrac2(players2[m]);
            mec.setPoeni1(rndPoints1);
            mec.setPoeni2(rndPoints2);
            mec.setTip(Mec.values()[0].name());
            em.getTransaction().begin();
            em.persist(mec);
           System.out.println("DOSAO OVDE2");
           em.getTransaction().commit();
            m++;
           System.out.println("DOSAO OVDE3");
            
            if(m == 4){
                int mod1 = players1[3]%4;
                int mod2 = players2[3]%4;
                int prvi = (players1[3] - mod1)/4;
                int drugi = (players2[3] - mod2)/4;
               
                em.getTransaction().begin();
                Points p = new Points();
                p.setId(400);
                p.setPoeni1(pts1);
                p.setPoeni2(pts2);
                p.setTim1(prvi);
                p.setTim2(drugi);
                em.persist(p);
                int br;
                if(pts1 >= pts2){
                    br = drugi;
                    cetvrtfinale[brMeca++][brTima++] = prvi;
                }
                else{
                    br = prvi;
                    cetvrtfinale[brMeca++][brTima++] = drugi;
                }
                Team t = em.find(Team.class, br);
                t.setPoints(t.getPoints() + 1);
                em.getTransaction().commit();
                start.setEnabled(false);
                next.setEnabled(true);
            }
            
            
        });
        
        
        
        newMatch.addActionListener((ae) -> {
            int cnt1 = counter++;
            int cnt2 = counter++;
            Random rand = new Random();
           
            int[] schedule1 = shuffle(4);
            int[] schedule2 = shuffle(4);
            for(int i=0;i<4;i++){
                labelsTeam1[i].setIcon(images[raspored[cnt1]*4 + schedule1[i]]);
                players1[i] = raspored[cnt1]*4 + schedule1[i];
                labelsTeam2[i].setIcon(images[raspored[cnt2]*4 + schedule2[i]]);
                players2[i] = raspored[cnt2]*4 + schedule2[i];
            }
            
            doAll();
            
            if(counter==18){
                newMatch.setEnabled(false);
                counter = 0;
            }
        });
        
        
        
        startTour.addActionListener((ae) -> {
            rasporedi();
            newMatch.setEnabled(true);
        });
        
        
        next.addActionListener((ae) -> {
            int first = tabela[cnt][0];
            int second = tabela[cnt++][1];
            if (cnt == 8){
                next.setEnabled(false);
                cnt = 0;
            }
            
            teamPlay(first, second);
            start.setEnabled(true);
            next.setEnabled(false);
        });
        elimination.addActionListener((ae) -> {
            elimination();
            next.setEnabled(true);
        });
        JPanel buttons = new JPanel();
        buttons.add(nextTeam);
        //buttons.add(start);
        buttons.add(elimination);
       // buttons.add(startTour);
        buttons.add(next);
        buttons.add(newMatch);
        add(team1T, "Center");
        //add(list, "Center");
        add(buttons, "East");
    }
    private void elimination(){
        raspored = shuffle(18);
        Random rand = new Random();
        int[][] eliminationPoints = new int[raspored.length][2];
        int[] skill = new int[4];
        for(int i=0;i<skill.length;i++)
            skill[i] = rand.nextInt(3);
        System.out.println("");
        System.out.println("************");
        System.out.println(skill[0] + " " + skill[1] + " " + skill[2] + " " + skill[3]);
        int strenth = 0;
        int pts = 0;
        for(int cnt=0;cnt<raspored.length;cnt++){
            int[] pom = shuffle(4);
            for(int i=0;i<skill.length;i++){
            players1[i] = raspored[cnt]*4 + pom[i];
            switch(skill[i]){
                case 0: strenth = table.getContestent(players1[i]).getEnergy(); break;
                case 1: strenth = table.getContestent(players1[i]).getHealth(); break;
                case 2: strenth = table.getContestent(players1[i]).getPreparation(); break;
            }
            int rnd = rand.nextInt(6);
            
            pts+=(rnd * strenth);
            System.out.print("Igrac: " + players1[i] + "(rnd = " + rnd + ", strenth = "  + strenth + ")");
            }
            
            eliminationPoints[cnt][0] = raspored[cnt];
            eliminationPoints[cnt][1] = pts;
            
            System.out.println("    " + "TIM: " + eliminationPoints[cnt][0] + ", BROJ POENA:" + eliminationPoints[cnt][1]);
            pts = 0;
        }
        
        eliminationPoints = order(eliminationPoints);
        
       /* em.getTransaction().begin();
        Team t = em.find(Team.class, eliminationPoints[16][0]);
        t.setPoints(t.getPoints() + 1);
        em.getTransaction().commit();*/
        
       
        team1T.setText("");
        list.removeAll();
        String[] arr = new String[18];
        for(int i=0;i<eliminationPoints.length;i++){
            String s = Tim.values()[eliminationPoints[i][0]].name() + " " + eliminationPoints[i][1];
            
            arr[i] = s;
           
           team1T.setText(team1T.getText() + Tim.values()[eliminationPoints[i][0]].name() + " " + eliminationPoints[i][1]  + "\n");
        }
        list = new JList(arr);
        
        tabela[0][0] = eliminationPoints[0][0];
        tabela[0][1] = eliminationPoints[15][0];
        tabela[1][0] = eliminationPoints[7][0];
        tabela[1][1] = eliminationPoints[8][0];
        tabela[2][0] = eliminationPoints[3][0];
        tabela[2][1] = eliminationPoints[12][0];
        tabela[3][0] = eliminationPoints[4][0];
        tabela[3][1] = eliminationPoints[11][0];
        
        tabela[4][0] = eliminationPoints[1][0];
        tabela[4][1] = eliminationPoints[14][0];
        tabela[5][0] = eliminationPoints[6][0];
        tabela[5][1] = eliminationPoints[9][0];
        tabela[6][0] = eliminationPoints[2][0];
        tabela[6][1] = eliminationPoints[13][0];
        tabela[7][0] = eliminationPoints[5][0];
        tabela[7][1] = eliminationPoints[10][0];
        
        
    }
    
    private int[][] order(int p[][]){
        
        for(int i=0;i<p.length-1;i++)
            for(int j=i+1;j<p.length;j++)
                if(p[i][1]<p[j][1]){
                    int temp1 = p[i][1];
                    int temp2 = p[i][0];
                    p[i][0] = p[j][0];
                    p[i][1] = p[j][1];
                    p[j][0] = temp2;
                    p[j][1] = temp1;
                }
        System.out.println("");
        for(int i=0;i<p.length;i++)
            System.out.println(p[i][0] + " " + p[i][1]);
        return p;
    }
    
    private void doAll(){
        for(int i=0;i<pointsL1.length;i++){
                pointsL1[i].setText("0");
                pointsL2[i].setText("0");
        }
        int k=0;
        while(k<4){
        Random rand = new Random();
            int skill = rand.nextInt(3);
            int strenth1 = 0;
            int strenth2 = 0;
            
            switch(skill){
                case 0: strenth1 = table.getContestent(players1[k]).getEnergy(); strenth2 = table.getContestent(players2[k]).getEnergy(); break;
                case 1: strenth1 = table.getContestent(players1[k]).getHealth(); strenth2 = table.getContestent(players2[k]).getHealth(); break;
                case 2: strenth1 = table.getContestent(players1[k]).getPreparation(); strenth2 = table.getContestent(players2[k]).getPreparation(); break;
            }
            System.out.println("");
            System.out.println(strenth1 + " " + strenth2 + " " + k);
            int rndPoints1 = rand.nextInt(6);
            int rndPoints2 = rand.nextInt(6);
            rndPoints1*=strenth1;
            rndPoints2*=strenth2;
            
            int pts1  = Integer.parseInt(pointsL1[k].getText());
            pts1+=rndPoints1;
            pointsL1[k].setText(Integer.toString(pts1));
            pts1  = Integer.parseInt(pointsL1[4].getText());
            pts1+=rndPoints1;
            pointsL1[4].setText(Integer.toString(pts1));
            
            int pts2  = Integer.parseInt(pointsL2[k].getText());
            pts2+=rndPoints2;
            pointsL2[k].setText(Integer.toString(pts2));
            pts2  = Integer.parseInt(pointsL2[4].getText());
            pts2+=rndPoints2;
            pointsL2[4].setText(Integer.toString(pts2));
            
            k++;
        }
    }
    public void nextTeam(){
        Random rand = new Random();
        int num1 = rand.nextInt(16);
        int num2 = rand.nextInt(16);
        int[] schedule1 = shuffle(4);
        int[] schedule2 = shuffle(4);
        
        for(int i=0, j=0;i<4; i++, j++){
           
           
            labelsTeam1[i].setIcon(images[num1*4 + schedule1[j]]);
            players1[j] = num1*4 + schedule1[j];
            labelsTeam2[i].setIcon(images[num2*4 + schedule2[j]]);
            players2[j] = num2*4 + schedule2[j];
            
            
            
        }
        
    }
    private void teamPlay(int first, int second){
        Random rand = new Random();
      
        int[] schedule1 = shuffle(4);
        int[] schedule2 = shuffle(4);
        
        for(int i=0, j=0;i<4; i++, j++){
           
           
            labelsTeam1[i].setIcon(images[first*4 + schedule1[j]]);
            players1[j] = first*4 + schedule1[j];
            labelsTeam2[i].setIcon(images[second*4 + schedule2[j]]);
            players2[j] = second*4 + schedule2[j];
            
            
            
        }
    }
    public static int[] shuffle(int n){
        int pom[] = new int[n];
        Random rand = new Random();
        int numbers = 0;
        for(int i=0;i<n;i++){
            int num = rand.nextInt(n);
            pom[i] = num;
            numbers++;
            for(int j=0;j<numbers-1;j++)
                if(pom[j] == pom[numbers-1]){
                    numbers--;
                    i--;
                    break;
                }
        }
        for(int i=0;i<n;i++)
            System.out.print(pom[i]);
        return pom;
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Vitaklinci gui  = new Vitaklinci();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        
        for(int i=0;i<20;i++){
            shuffle(16);
            
            System.out.println();
        }
    }
    
    
}
