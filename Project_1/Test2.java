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
   JButton qbt = new JButton("1:1 �����ϱ�"); // ���� ��ư
   JTextArea ta1, ta2;
   JLabel lb;
   BorderLayout b = new BorderLayout();
   
   Font f1 = new Font("����", Font.PLAIN, 30);
   Font f2 = new Font("����", Font.PLAIN, 20);
   Font f21 = new Font("����", Font.ITALIC, 20);
   Font f3 = new Font("����", Font.PLAIN, 10);

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
      
      //��
      home=new JLabel(new ImageIcon("images/left.png"));
      lb = new JLabel("�����ϱ�", JLabel.CENTER);
      p4.add(home,BorderLayout.WEST);
      lb.setFont(new Font("����", Font.BOLD, 30));
      lb.setForeground(new Color(53, 128, 83));
      p4.add(lb);
//    lb.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
      
      
      InnerMouseHandler imh= new InnerMouseHandler();
      home.addMouseListener(imh);
      
      
      p1.setLayout(new GridLayout(6, 1));
      p2.setLayout(new BorderLayout());
      p3.setLayout(new BorderLayout());
      p2.add(p3, "Center");

      // textarea��ġ�� �� (p3n, p3c)
      p3n = new MyJPanel(50, 10, 0, 10);
      p3c = new JPanel();
      p3.add(p3n, "North");
      p3.add(p3c, "Center");

      // ��������
      p.setBackground(Color.white);
      p1.setBackground(Color.white);
      p3n.setBackground(Color.white);
      p3c.setBackground(Color.white);

      // ���ڿ� ���� ��ü ����
      QnA qa = new QnA();

      // ��ư
      for (int i = 0; i < bt.length; i++) {
         bt[i] = new JButton(qa.q[i]);
//       bt[i].setBorderPainted(false); //��ư�� �ܰ����� ������
         bt[i].setContentAreaFilled(false); // ��ư�� ���뿵�� ä���� ����
         bt[i].setFocusPainted(false);
         bt[i].setFont(new Font("����", Font.BOLD, 15));// ��Ʈ ����
         bt[i].setForeground(new Color(53, 128, 83)); //���� ����
         bt[i].setPreferredSize(new Dimension(40,40)); //��ư ũ�� ����
         p1.add(bt[i]);
      }
      
      bt[1].setBorderPainted(false);
      bt[3].setBorderPainted(false);
      
      p2.add(qbt, "South"); // �����ϱ� ��ư
      qbt.setFont(new Font("���", Font.PLAIN, 20));
      qbt.setForeground(Color.white); //���� ����
      qbt.setBackground(new Color(53, 128, 83)); //��ư ���
      
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

      textDesign(); // ���� �޼ҵ�

      // ������
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

      // 1:1 �����ϱ� ��ư ������
      qbt.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ServerFrame frame1 = new ServerFrame(); // ������
            ClientFrame frame2 = new ClientFrame(); // ������
         }
      });
      
      // â�ݱ�
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   // textarea����
   public void textDesign() {
      ta1.setFont(new Font("���ü", Font.PLAIN, 16));
      ta1.setLineWrap(true);
      ta1.setWrapStyleWord(true);
//    ta1.setOpaque(false);
      ta1.setEditable(false);

      ta2.setFont(new Font("���ü", Font.PLAIN, 16));
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
	                  (null, "������������ ���ư��ðڽ��ϱ�? ������������ ���ư��� �����ߴ� ������ ������ϴ�.",
	                  "�ƴϿ�",JOptionPane.YES_NO_OPTION);
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
	   }//InnerŬ���� end


   public static void main(String[] args) {
      Test2 t = new Test2();
      
   }
}
