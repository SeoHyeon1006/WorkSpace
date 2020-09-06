package Project_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class Login extends JFrame{

	JPanel pMain = new JPanel(new BorderLayout());
	JPanel pn= new JPanel(new BorderLayout()); //����
	JPanel pTop = new MyJPanel(80, 0, 0, 0);
	JPanel pCenter = new JPanel();
	JPanel pCenterin = new MyJPanel(20, 0, 0, 0);
	JPanel pSouth = new MyJPanel(0, 60, 150, 60);
	
	JLabel home;
	JLabel log = new JLabel("�α���",JLabel.CENTER);
	JLabel logo = new JLabel("Air Dangsan",JLabel.CENTER);
	
	JTextField idt= new JTextField("���̵�",23);
	//JTextField pwt= new JTextField("��й�ȣ",23);  //23
	JPasswordField pwt=new JPasswordField("��й�ȣ�� �Է��ϼ���",23);
	
	
	JButton j1 = new JButton("�α���");
	JButton j2 = new JButton("ȸ������");
	
	Font f3 = new Font("����", Font.PLAIN, 10);
	 
	public Login() {
		super("::Login2::");
		
		Container cp = getContentPane();
		cp.add(pMain, "Center");	
		cp.add(pMain, "North");

		pMain.add(pTop,"North");
		pMain.add(pCenter,"Center");
		pMain.add(pSouth,"South");
		pCenter.add(pCenterin);
		
		//layout	
		pTop.setLayout(new BorderLayout());
		pSouth.setLayout(new GridLayout(2,1, 0, 10));
		pCenterin.setLayout(new GridLayout(2,1, 0, 10));
		
		//main
		home = new JLabel(new ImageIcon("images/left.png"));
		pMain.add(home, "West");
		
		//top(��)
		log.setFont(log.getFont().deriveFont(30.0f));
		log.setForeground(new Color(53, 128, 83));
		logo.setFont(log.getFont().deriveFont(30.0f));
		logo.setForeground(new Color(53, 128, 83));
		pTop.add(log,"South");
		pTop.add(logo,"Center");
		
		//center(id, password)
		pCenterin.add(idt);
		pCenterin.add(pwt);
		idt.setPreferredSize(new Dimension(40,40)); //��ư ũ�� ����
		pwt.setPreferredSize(new Dimension(40,40)); //��ư ũ�� ����
		idt.setFont(new Font("����",Font.PLAIN, 15));
		pwt.setFont(new Font("����",Font.PLAIN, 15));
		
		//south(��ư)
		pSouth.add(j1);
		pSouth.add(j2);
		
		//��ư(j1,j2) ������
		j1.setBackground(new Color(53, 128, 83));
		j1.setForeground(Color.white);
		j2.setBackground(new Color(53, 128, 83));
		j2.setForeground(Color.white);
		j1.setPreferredSize(new Dimension(40,40)); //��ư ũ�� ����
		j2.setPreferredSize(new Dimension(40,40)); //��ư ũ�� ����
		j1.setFont(new Font("���",Font.BOLD, 15));
		j2.setFont(new Font("���",Font.BOLD, 15));
		
		//���� ����
		pMain.setBackground(Color.white);
		pMain.setBackground(Color.white);
		pTop.setBackground(Color.white);
		pCenter.setBackground(Color.white);
		pCenterin.setBackground(Color.white);
		pSouth.setBackground(Color.white);
		
		
		InnerMouseHandler imh= new InnerMouseHandler();
	   home.addMouseListener(imh);
	    
	
		
		//��ư ������(�α���, ȸ������)
	    j1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent T) {
	    		try {
	    		String uid=idt.getText();
	    		char[]ch=pwt.getPassword();
	    		String pwd=new String(ch);
	    		//��ȿ�� üũ     //trim() : ���ڿ� �� ���� ���鹮�ڸ� ������
	    		if(uid==null||pwd==null||uid.trim().equals("")
	    				||pwd.trim().isEmpty()) {
	    			JOptionPane.showMessageDialog(pCenter,"���̵�� ��й�ȣ�� �Է��ϼ���");
	    			idt.requestFocus();
	    			return;
	    		}else {
	            	
	            	String s;
	    			String[] array;
	    			String login_flag = "N";
	    			BufferedReader bos = new BufferedReader(new FileReader("C:\\\\\\\\ȸ�����\\\\\\\\ȸ�����.txt"));
	    			while((s=bos.readLine())!=null){
	    				array=s.split("/");
	    			if(uid.equals(array[1])&&pwd.equals(array[2]))
	    			{
	    				
	    				login_flag = "Y";
	    				
	    						
	    						
	    				//�α����� �Ǹ� ����ȭ������ �̵����ֱ�
	    			}
	    			
	    			}
	    			if(login_flag.equals("Y")) {
	    				JOptionPane.showMessageDialog(pCenter,"�α��� ����! �������� �̵��մϴ�.");
	    				setVisible(false);
	    				dispose();
	    			}else {
	    				 JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� Ȯ���ϼ���.");
	    			}
	    			bos.close();
	            }

	    		}catch(IOException E10){
	    			
	    		}
	    	}
	    });
		
		j2.addActionListener((e)->{
			Join c=new Join();
			c.setSize(800,800);
			c.setVisible(true);
			setVisible(false);
			dispose();
		});
		//â�ݱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPlaceholder(idt,pwt);
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
	
	class InnerMouseHandler extends MouseAdapter {

	      @Override
	      public void mouseClicked(MouseEvent e) {
	         
	         Object o = e.getSource();
	         
	         if (o == home) { 
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
}
