package Project_1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test2 extends JFrame {
   JPanel p = new MyJPanel(10, 10, 10, 10);
   JPanel p1 = new JPanel();
   JPanel p2 = new JPanel();
   JPanel p3 = new JPanel();
   JPanel p3n, p3c;
   JPanel p4;
   JButton[] bt = new JButton[5];
   JLabel home;
   JButton qbt = new JButton("1:1 문의하기"); // 문의 버튼
   JTextArea ta1, ta2;
   JLabel lb;
   BorderLayout b = new BorderLayout();
   
   Font f1 = new Font("돋움", Font.PLAIN, 30);
   Font f2 = new Font("돋움", Font.PLAIN, 20);
   Font f21 = new Font("돋움", Font.ITALIC, 20);
   Font f3 = new Font("돋움", Font.PLAIN, 10);

   public Test2() {
      super("::Test::");
      Container cp = getContentPane();
      cp.add(p, "Center");
      p.setLayout(new BorderLayout());
      p.add(p1, "North");
      p.add(p2, "Center");
      
      p4=new JPanel();
      p4.setLayout(b);
      p1.add(p4, BorderLayout.NORTH);
      p4.setBackground(Color.white);
      
      //라벨
      home=new JLabel(new ImageIcon("images/left.png"));
      lb = new JLabel("문의하기", JLabel.CENTER);
      p4.add(home,BorderLayout.WEST);
      lb.setFont(new Font("돋움", Font.BOLD, 30));
      lb.setForeground(new Color(53, 128, 83));
      p4.add(lb);
//    lb.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
      
      
      InnerMouseHandler imh= new InnerMouseHandler();
      home.addMouseListener(imh);
      
      
      p1.setLayout(new GridLayout(6, 1));
      p2.setLayout(new BorderLayout());
      p3.setLayout(new BorderLayout());
      p2.add(p3, "Center");

      // textarea위치할 곳 (p3n, p3c)
      p3n = new MyJPanel(50, 10, 0, 10);
      p3c = new JPanel();
      p3.add(p3n, "North");
      p3.add(p3c, "Center");

      // 배경색지정
      p.setBackground(Color.white);
      p1.setBackground(Color.white);
      p3n.setBackground(Color.white);
      p3c.setBackground(Color.white);

      // 문자열 가진 객체 생성
      QnA qa = new QnA();

      // 버튼
      for (int i = 0; i < bt.length; i++) {
         bt[i] = new JButton(qa.q[i]);
//       bt[i].setBorderPainted(false); //버튼의 외곽선을 없애줌
         bt[i].setContentAreaFilled(false); // 버튼의 내용영역 채우지 않음
         bt[i].setFocusPainted(false);
         bt[i].setFont(new Font("돋움", Font.BOLD, 15));// 폰트 설정
         bt[i].setForeground(new Color(53, 128, 83)); //글자 색깔
         bt[i].setPreferredSize(new Dimension(40,40)); //버튼 크기 설정
         p1.add(bt[i]);
      }
      
      bt[1].setBorderPainted(false);
      bt[3].setBorderPainted(false);
      
      p2.add(qbt, "South"); // 문의하기 버튼
      qbt.setFont(new Font("고딕", Font.PLAIN, 20));
      qbt.setForeground(Color.white); //글자 색깔
      qbt.setBackground(new Color(53, 128, 83)); //버튼 배경
      
      // textarea
      ta1 = new JTextArea();
      ta2 = new JTextArea();
      ta1 = new JTextArea(3, 50);
      ta2 = new JTextArea(10, 50);
      JScrollPane sp1 = new JScrollPane(ta1);
      sp1.setBorder(BorderFactory.createEmptyBorder());
      p3n.add(sp1);

      JScrollPane sp2 = new JScrollPane(ta2);
      sp2.setBorder(BorderFactory.createEmptyBorder());
      p3c.add(sp2);

      textDesign(); // 만든 메소드

      // 리스너
      bt[0].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ta1.setText(qa.q[0]);
            ta2.setText(qa.a[0]);
         }
      });
      bt[1].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ta1.setText(qa.q[1]);
            ta2.setText(qa.a[1]);
         }
      });
      bt[2].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ta1.setText(qa.q[2]);
            ta2.setText(qa.a[2]);
         }
      });
      bt[3].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ta1.setText(qa.q[3]);
            ta2.setText(qa.a[3]);
         }
      });
      bt[4].addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ta1.setText(qa.q[4]);
            ta2.setText(qa.a[4]);
         }
      });

      // 1:1 문의하기 버튼 리스너
      qbt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ServerFrame frame1 = new ServerFrame(); // 관리자
            ClientFrame frame2 = new ClientFrame(); // 문의자
         }
      });
      
      // 창닫기
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   // textarea설정
   public void textDesign() {
      ta1.setFont(new Font("고딕체", Font.PLAIN, 16));
      ta1.setLineWrap(true);
      ta1.setWrapStyleWord(true);
//    ta1.setOpaque(false);
      ta1.setEditable(false);

      ta2.setFont(new Font("고딕체", Font.PLAIN, 16));
      ta2.setLineWrap(true);
      ta2.setWrapStyleWord(true);
//    ta2.setOpaque(false);
      ta2.setEditable(false);
   }
   
   class InnerMouseHandler extends MouseAdapter {

	      @Override
	      public void mouseClicked(MouseEvent e) {
	         
	         Object o = e.getSource();
	         
	         if (o ==home) { 
	            System.out.println("click");
	            int result= JOptionPane.showConfirmDialog
	                  (null, "이전페이지로 돌아가시겠습니까? 이전페이지로 돌아가면 진행했던 내용은 사라집니다.",
	                  "아니요",JOptionPane.YES_NO_OPTION);
	                  UIManager.put("OptionPane.messageFont",f3);

	                  UIManager.put("OptionPane.buttonFont",f3);

	            
	                  if(result==JOptionPane.CLOSED_OPTION) {
	                     
	                  }
	                  else if(result==JOptionPane.YES_OPTION) {
	                     setVisible(false);
	                     dispose();
	                     
	                  }
	                  else {
	                     
	                  }
	            }
	      }
	   }//Inner클래스 end


   public static void main(String[] args) {
      Test2 t = new Test2();
      
   }
}
