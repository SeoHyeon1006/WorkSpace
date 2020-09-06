package Project_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class pPlacePart extends JPanel{

 JPanel p ,p2,p3;
 JButton b1,b2,b3;
 JLabel label1,label2;
 JList<String> list1, list2;
 Vector<String> v;
 JScrollPane sc1, sc2;
 String[] lang= {"출발지","인천","부산","김포"};
 String[] lang2= {"도착지","일본","미국","제주","중국","인천","부산","김포"};
 JComboBox<String> combo1, combo2;
 
 DefaultListModel<String> model;
 DefaultListModel<String> model2;
 int cnt = 1;
 
 

 public pPlacePart() {
 // super(":::pPlacePart:::");
  //Container cp = getContentPane();
  JPanel cp=new JPanel(new BorderLayout());
  this.add(cp);
  p=new JPanel(new FlowLayout(FlowLayout.CENTER,50,20));
  cp.add(p, BorderLayout.CENTER);
  
  p2=new JPanel();
  p3=new JPanel();
  
  p.add(p2, BorderLayout.WEST);
  p2.setBackground(new Color(53,128,83));
  p.add(p3, BorderLayout.EAST);
  p3.setBackground(new Color(53,128,83));
 
  b1=new JButton("출발지");
  b2=new JButton("도착지");
 
  b1.setBackground(Color.white);
  b1.setBorderPainted(false); //버튼 테두리 제거
  b1.setFont(new Font("돋움",Font.PLAIN,20));
  b2.setFont(new Font("돋움",Font.PLAIN,20));
  p2.add(b1);
  
 
  b2.setBackground(Color.white);
  b2.setBorderPainted(false);
 // b2.setContentAreaFilled(false); //버튼 영역 배경표시 색 제거
  p3.add(b2);
  combo1=new JComboBox(lang);
  combo1.setFont(new Font("돋움",Font.PLAIN,15));
  combo1.setForeground(new Color(53,128,83));
  combo2=new JComboBox(lang2);
  combo2.setFont(new Font("돋움",Font.PLAIN,15));
  combo2.setForeground(new Color(53,128,83));
  
  Ebent e1=new Ebent();
  
  b1.addActionListener(e1);
  b2.addActionListener(e1);
  combo1.addActionListener(e1);
  combo2.addActionListener(e1);
  
 }
 class Ebent implements ActionListener{
  @Override
  public void actionPerformed(ActionEvent e) {
   Object obj= e.getSource();
   cnt++;
   if(obj==b1) {
      if(cnt%2==0) {
         p2.add(combo1);
      }else if(cnt%2==1) {
         p2.remove(combo1);
      }
   }else if(obj==b2) {
    if(cnt%2==0) {
       p3.add(combo2);
    }else if(cnt%2==1) {
       p3.remove(combo2);
    }
   }else if(obj==combo1) {
      //콤보박스에서 선택한 값 얻어와서 버튼에 setText()하기
      String str=combo1.getSelectedItem().toString();
      b1.setText(str);
      p2.remove(combo1);
      System.out.println(combo1.getSelectedItem().toString());
      p2.updateUI();
   }else if(obj==combo2) {
      String str=combo2.getSelectedItem().toString();
      b2.setText(str);
      p3.remove(combo2);
      p3.updateUI();
   }else if(obj==b1) {
      
      if(cnt %2 ==0) {
         p2.add(combo1);
      }else if(cnt %2 ==1) {
         p2.remove(combo1);
      }
   }
   p2.validate();
   p2.updateUI();
   p3.validate();
   p3.updateUI();
  }
 }/////////////////////////////

}///////////////////////////////////////////
