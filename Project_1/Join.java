package Project_1;

import javax.swing.*;

import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Join extends JFrame {

	JPanel p = new JPanel(new BorderLayout());
	JPanel pTop = new JPanel(new BorderLayout());
	JPanel pCenter = new JPanel(new FlowLayout());
	JPanel pSouth = new JPanel();

	JLabel lm = new JLabel(new ImageIcon("images/mark.png"));
	JLabel ls = new JLabel("ȸ������", JLabel.CENTER);

	JLabel l1 = new JLabel("*���̵�");
	JLabel l2 = new JLabel("*��й�ȣ");
	JLabel l3 = new JLabel("*��й�ȣ Ȯ��");
	JLabel l4 = new JLabel("*�̸�");
	JLabel l5 = new JLabel("*����");
	JLabel l6 = new JLabel("*��ȭ��ȣ");
	JLabel l7 = new JLabel("*�̸���");
	JLabel l8 = new JLabel("*�ּ�");
	JTextField t1 = new JTextField("���̵�");
	JTextField t2 = new JTextField("��й�ȣ");
	JTextField t3 = new JTextField("��й�ȣ Ȯ��");
	JTextField t4 = new JTextField("�̸��� �Է����ּ���");
	JTextField t5 = new JTextField("������ �Է��ϼ���");
	JTextField t6 = new JTextField("��ȭ ��ȣ�� �Է��ϼ���");
	JTextField t7 = new JTextField("�̸����� �Է��ϼ���");
	JTextField t8 = new JTextField("�ּҸ� �Է��ϼ���");
	JButton j1 = new JButton(new ImageIcon("images/sign.png"));
	JButton j2 = new JButton(new ImageIcon("images/cancle.png"));

	Container c = getContentPane();

	GridPane grid = new GridPane();

	public Join() {
		super("::Join::");
		Container cp = getContentPane();
		this.setResizable(false);
		cp.add(p);
		p.add(pTop, "North");
		p.add(pCenter, "Center");
		p.add(pSouth, "South");
		p.setBackground(Color.white);

		pTop.setBackground(Color.white);
		pTop.add(lm, "West");
		pTop.add(ls, "Center");
		ls.setFont(ls.getFont().deriveFont(30.0f));
		ls.setForeground(new Color(53, 128, 83));

		pCenter.setBackground(Color.white);
		pCenter.setLayout(null);
		pCenter.add(l1);
		pCenter.add(t1);
		pCenter.add(l2);
		pCenter.add(t2);
		pCenter.add(l3);
		pCenter.add(t3);
		pCenter.add(l4);
		pCenter.add(t4);
		pCenter.add(l5);
		pCenter.add(t5);
		pCenter.add(l6);
		pCenter.add(t6);
		pCenter.add(l7);
		pCenter.add(t7);
		pCenter.add(l8);
		pCenter.add(t8);

		//t1.setEnabled(true);
		//l1.setOpaque(true);// ���� �����ϰ�

		/*
		 * Font l1 = new Font("����", Font.PLAIN, 30); Font l2 = new Font("����",
		 * Font.PLAIN, 20); Font l3 = new Font("����", Font.ITALIC, 20); Font l4 = new
		 * Font("����", Font.PLAIN, 10);
		 */
		l1.setBounds(175, 50, 100, 40);
		l2.setBounds(175, 120, 100, 40);
		l3.setBounds(175, 190, 150, 40);
		l4.setBounds(175, 260, 100, 40);
		l5.setBounds(175, 330, 100, 40);
		l6.setBounds(175, 400, 100, 40);
		l7.setBounds(175, 470, 100, 40);
		l8.setBounds(175, 540, 100, 40);
		
		l1.setFont(new Font("����",Font.BOLD,15));
		l2.setFont(new Font("����",Font.BOLD,15));
		l3.setFont(new Font("����",Font.BOLD,15));
		l4.setFont(new Font("����",Font.BOLD,15));
		l5.setFont(new Font("����",Font.BOLD,15));
		l6.setFont(new Font("����",Font.BOLD,15));
		l7.setFont(new Font("����",Font.BOLD,15));
		l8.setFont(new Font("����",Font.BOLD,15));
		t1.setFont(new Font("����",Font.BOLD,15));
		
		l1.setForeground(new Color(53, 128, 83));
		l2.setForeground(new Color(53, 128, 83));
		l3.setForeground(new Color(53, 128, 83));
		l4.setForeground(new Color(53, 128, 83));
		l5.setForeground(new Color(53, 128, 83));
		l6.setForeground(new Color(53, 128, 83));
		l7.setForeground(new Color(53, 128, 83));
		l8.setForeground(new Color(53, 128, 83));

		t1.setBounds(175, 80, 450, 30);
		t2.setBounds(175, 150, 450, 30);
		t3.setBounds(175, 220, 450, 30);
		t4.setBounds(175, 290, 450, 30);
		t5.setBounds(175, 360, 450, 30);
		t6.setBounds(175, 430, 450, 30);
		t7.setBounds(175, 500, 450, 30);
		t8.setBounds(175, 570, 450, 30);

		pSouth.setBackground(Color.white);
		pSouth.add(j1);
		pSouth.add(j2);
		
		j1.setBackground(Color.white);
		j1.setBorderPainted(false);
		
		j2.setBackground(Color.white);
		j2.setBorderPainted(false);
		
		
		pSouth.setPreferredSize(new Dimension(100, 100));

		j2.addMouseListener(new MouseAdapter() {
			 @Override
		      public void mouseClicked(MouseEvent e) {
		         
		         Object o = e.getSource();
		         
		         if (o ==j2) { 
		            System.out.println("click");
		            int result= JOptionPane.showConfirmDialog
		                  (null, "������������ ���ư��ðڽ��ϱ�? ������������ ���ư��� �����ߴ� ������ ������ϴ�.",
		                  "�ƴϿ�",JOptionPane.YES_NO_OPTION);
		                  
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

		});
		
		j1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent T) {//ȸ������ ������ ����
				try{
                    if(t1.getText().equals("")) {
                    	JOptionPane.showMessageDialog(null, "���̵� �Է��ϼ���.");
                    	
                    	
                    }
                    else if(t2.getText().equals("")) {
                    	JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼ���.");
                    }
                    else if(t3.getText().equals("")) {
                    	JOptionPane.showMessageDialog(null, "��й�ȣ Ȯ��ĭ�� ��й�ȣ�� �Է��ϼ���.");
                    }
                    else if(t4.getText().equals("")) {
                    	JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���.");
                    }
				 
	                else if(t5.getText().equals("")) {
	                	JOptionPane.showMessageDialog(null, "������  �Է��ϼ���.");
                     }
                    else if(t6.getText().equals("")) {
                    	JOptionPane.showMessageDialog(null, "��ȭ��ȣ�� �Է��ϼ���.");
                    }
                    else if(t7.getText().equals("")) {
                    	JOptionPane.showMessageDialog(null, "�̸����� �Է��ϼ���.");
                    }
                    else  if(t8.getText().equals("")) {
                    	JOptionPane.showMessageDialog(null, "�ּҸ� �Է��ϼ���.");
                    }else {
                    	
                    	 if( !(t2.getText().equals(t3.getText())) ) {
                         	JOptionPane.showMessageDialog(null, "������ ��� �Է��Ͽ����� Ȯ���ϼ���.");
                         }else {
                        	 
                        	 BufferedWriter bos = new BufferedWriter(new FileWriter("C:\\\\ȸ�����\\\\ȸ�����.txt",true));
         					bos.write(t1.getText()+"/");
         					bos.write(t2.getText()+"/");
         					bos.write(t3.getText()+"/");
         					bos.write(t4.getText()+"/");
         					bos.write(t5.getText()+"/");
         					bos.write(t6.getText()+"/");
         					bos.write(t7.getText()+"/");
         					bos.write(t8.getText()+"\r\n");
         					bos.close();
         					JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�!!");
                         	setVisible(false);
                         	dispose();
                         }
                    	 
                    	
                    }
                    
                   
                    
					
					
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
				}
			}
		});
		

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPlaceholder(t1,t2,t3,t4,t5,t6,t7,t8);
	}
	int i=0;
	public void setPlaceholder(JTextField... tf) {
		System.out.println(tf.length);
		for (i = 0; i < tf.length; i++) {
			tf[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					((JTextField)e.getSource()).setText("");
				}
			});
		}

	}
	
}
