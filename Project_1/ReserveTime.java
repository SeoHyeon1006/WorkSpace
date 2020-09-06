package Project_1;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Project_1.FlightSearchModify;
import Project_1.MyJPanel;

public class ReserveTime extends JPanel {
   
   JPanel p = new JPanel(new BorderLayout());
   JPanel pNorth = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 10));
   JPanel pCenter = new JPanel(new BorderLayout());
   JPanel p2North = new JPanel(new BorderLayout());
   JPanel p2Center = new JPanel(new BorderLayout());
   
   JPanel p2c = new MyJPanel(15, 10, 15, 10);
   JPanel p2e = new MyJPanel(15, 10, 15, 10);
   
   JPanel p3c = new MyJPanel(20, 30, 40, 20);
   JPanel p3e = new MyJPanel(30, 50, 10, 40);
   
   JRadioButton cb;
   
   Font menuFont = new Font("����", Font.BOLD, 20);
   Font menuFont2 = new Font("����", Font.BOLD, 15);
   TitledBorder titleBorder = new TitledBorder(new LineBorder(Color.GRAY),"");
   
   JLabel date, start, none, arrive;
   
   JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
   
   
   public ReserveTime(FlightSearchModify gparent) {
      this.add(p);
      p.add(pNorth, "North");
      
      date = new JLabel(gparent.departureDate+"     ");
      date.setFont(menuFont);
      start = new JLabel(gparent.departurePlace);
      start.setFont(menuFont);
      none = new JLabel("--------------  ");
      arrive = new JLabel(gparent.arrivalPlace);
      arrive.setFont(menuFont);
      pNorth.add(date);
      pNorth.add(start);
      pNorth.add(none);
      pNorth.add(arrive);
      
      p.add(pCenter, "Center");
      
      
      pCenter.add(p2North, "North");
      p2North.add(p2c, "Center");
      p2c.setBackground(new Color(53,128,83));
      JLabel time = new JLabel("�⵵���ð� (����ð�)");
      JLabel grade = new JLabel("         "+gparent.SitGrade+"              ");
      p2c.add(time);
      time.setFont(new Font("����", Font.PLAIN, 15));
      time.setForeground(Color.white);
      
      p2North.add(p2e, "East");
      p2e.add(grade);
      grade.setFont(new Font("����", Font.PLAIN, 15));
      p2c.setBorder(titleBorder);
      p2e.setBorder(titleBorder);
      
      
      pCenter.add(p2Center, "Center");
      p2Center.add(p3c, "Center");
      p2Center.add(p3e, "East");
      p3c.setBorder(titleBorder);
      p3e.setBorder(titleBorder);
      
      p3c.setLayout(new GridLayout(2,0));
 
      //�ð�ǥ
      if(gparent.departurePlace.equals("��õ")&& gparent.arrivalPlace.equals("�Ϻ�")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          l2 = new JLabel("                   "+"1�ð� 55��");
          p3c.add(l2);
          l3 = new JLabel("");
          p3c.add(l3);
          l4 = new JLabel("                   "+"21:20");
          p3c.add(l4);
          l4.setFont(menuFont);
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          l6 = new JLabel("23:15");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      else if(gparent.departurePlace.equals("��õ")&& gparent.arrivalPlace.equals("�̱�")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          
          l2 = new JLabel("                   "+"11�ð� ��");
          p3c.add(l2);
          
          l3 = new JLabel("");
          p3c.add(l3);
          
          l4 = new JLabel("                   "+"2:40");
          p3c.add(l4);
          l4.setFont(menuFont);
          
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          
          l6 = new JLabel("13:40");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      else if(gparent.departurePlace.equals("��õ")&& gparent.arrivalPlace.equals("�߱�")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          
          l2 = new JLabel("                   "+"1�ð� 55��");
          p3c.add(l2);
          
          l3 = new JLabel("");
          p3c.add(l3);
          
          l4 = new JLabel("                   "+"21:20");
          p3c.add(l4);
          l4.setFont(menuFont);
          
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          
          l6 = new JLabel("23:15");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      else if(gparent.departurePlace.equals("��õ") && gparent.arrivalPlace.equals("����")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          l2 = new JLabel("                   "+"1�ð� 30��");
          p3c.add(l2);
          l3 = new JLabel("");
          p3c.add(l3);
          l4 = new JLabel("                   "+"7:20");
          p3c.add(l4);
          l4.setFont(menuFont);
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          l6 = new JLabel("8:50");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      ///////////////////////////////////
      
      else if((gparent.departurePlace.equals("�λ�") || 
    		  gparent.departurePlace.equals("����")) && gparent.arrivalPlace.equals("�Ϻ�")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          l2 = new JLabel("                   "+"2�ð� 00��");
          p3c.add(l2);
          l3 = new JLabel("");
          p3c.add(l3);
          l4 = new JLabel("                   "+"13:20");
          p3c.add(l4);
          l4.setFont(menuFont);
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          l6 = new JLabel("15:20");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      else if(gparent.departurePlace.equals("�λ�") && gparent.arrivalPlace.equals("����")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          l2 = new JLabel("                   "+"1�ð� 00��");
          p3c.add(l2);
          l3 = new JLabel("");
          p3c.add(l3);
          l4 = new JLabel("                   "+"10:20");
          p3c.add(l4);
          l4.setFont(menuFont);
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          l6 = new JLabel("11:20");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      else if(gparent.departurePlace.equals("����") && gparent.arrivalPlace.equals("����")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          l2 = new JLabel("                   "+"1�ð� 20��");
          p3c.add(l2);
          l3 = new JLabel("");
          p3c.add(l3);
          l4 = new JLabel("                   "+"5:20");
          p3c.add(l4);
          l4.setFont(menuFont);
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          l6 = new JLabel("6:40");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      else if(gparent.departurePlace.equals("����") && gparent.arrivalPlace.equals("�̱�")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          l2 = new JLabel("                   "+"15�ð� 20��");
          p3c.add(l2);
          l3 = new JLabel("");
          p3c.add(l3);
          l4 = new JLabel("                   "+"19:20");
          p3c.add(l4);
          l4.setFont(menuFont);
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          l6 = new JLabel("10:40");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      else if(gparent.departurePlace.equals("�λ�") && gparent.arrivalPlace.equals("�̱�")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          l2 = new JLabel("                   "+"16�ð� 20��");
          p3c.add(l2);
          l3 = new JLabel("");
          p3c.add(l3);
          l4 = new JLabel("                   "+"15:10");
          p3c.add(l4);
          l4.setFont(menuFont);
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          l6 = new JLabel("4:30");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      else if(gparent.departurePlace.equals("����") && gparent.arrivalPlace.equals("�߱�")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          l2 = new JLabel("                   "+"1�ð� 50��");
          p3c.add(l2);
          l3 = new JLabel("");
          p3c.add(l3);
          l4 = new JLabel("                   "+"11:00");
          p3c.add(l4);
          l4.setFont(menuFont);
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          l6 = new JLabel("12:50");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      else if(gparent.departurePlace.equals("�λ�") && gparent.arrivalPlace.equals("�߱�")) {
    	  l1 = new JLabel("");
          p3c.add(l1);
          l2 = new JLabel("                   "+"2�ð� 25��");
          p3c.add(l2);
          l3 = new JLabel("");
          p3c.add(l3);
          l4 = new JLabel("                   "+"19:10");
          p3c.add(l4);
          l4.setFont(menuFont);
          l5 = new JLabel("                    "+"--------------");
          p3c.add(l5);
          l6 = new JLabel("21:35");
          p3c.add(l6);
          l6.setFont(menuFont);
      }
      
      // p3e
      if(gparent.SitGrade.equals("���ڳ��")) {
    	  JLabel price = new JLabel("KRW 228,000");
    	  p3e.add(price);
    	  cb = new JRadioButton();
    	  p3e.add(cb);
    	  return;
      }
      else if(gparent.SitGrade.equals("����Ͻ�")) {
    	  JLabel price = new JLabel("KRW 378,000");
    	  p3e.add(price);
    	  cb = new JRadioButton();
          p3e.add(cb);
          return;
      }
      else if(gparent.SitGrade.equals("�۽�Ʈ")) {
    	  JLabel price = new JLabel("KRW 578,000");
    	  p3e.add(price);
    	  cb = new JRadioButton();
    	  p3e.add(cb);
    	  return;
      }    	  
      setSize(800, 250);
   }
   
}