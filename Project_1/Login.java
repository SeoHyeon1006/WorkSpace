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
	JPanel pn= new JPanel(new BorderLayout()); //북쪽
	JPanel pTop = new MyJPanel(80, 0, 0, 0);
	JPanel pCenter = new JPanel();
	JPanel pCenterin = new MyJPanel(20, 0, 0, 0);
	JPanel pSouth = new MyJPanel(0, 60, 150, 60);
	
	JLabel home;
	JLabel log = new JLabel("로그인",JLabel.CENTER);
	JLabel logo = new JLabel("Air Dangsan",JLabel.CENTER);
	
	JTextField idt= new JTextField("아이디",23);
	//JTextField pwt= new JTextField("비밀번호",23);  //23
	JPasswordField pwt=new JPasswordField("비밀번호를 입력하세요",23);
	
	
	JButton j1 = new JButton("로그인");
	JButton j2 = new JButton("회원가입");
	
	Font f3 = new Font("돋움", Font.PLAIN, 10);
	 
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
		
		//top(라벨)
		log.setFont(log.getFont().deriveFont(30.0f));
		log.setForeground(new Color(53, 128, 83));
		logo.setFont(log.getFont().deriveFont(30.0f));
		logo.setForeground(new Color(53, 128, 83));
		pTop.add(log,"South");
		pTop.add(logo,"Center");
		
		//center(id, password)
		pCenterin.add(idt);
		pCenterin.add(pwt);
		idt.setPreferredSize(new Dimension(40,40)); //버튼 크기 설정
		pwt.setPreferredSize(new Dimension(40,40)); //버튼 크기 설정
		idt.setFont(new Font("돋움",Font.PLAIN, 15));
		pwt.setFont(new Font("돋움",Font.PLAIN, 15));
		
		//south(버튼)
		pSouth.add(j1);
		pSouth.add(j2);
		
		//버튼(j1,j2) 디자인
		j1.setBackground(new Color(53, 128, 83));
		j1.setForeground(Color.white);
		j2.setBackground(new Color(53, 128, 83));
		j2.setForeground(Color.white);
		j1.setPreferredSize(new Dimension(40,40)); //버튼 크기 설정
		j2.setPreferredSize(new Dimension(40,40)); //버튼 크기 설정
		j1.setFont(new Font("고딕",Font.BOLD, 15));
		j2.setFont(new Font("고딕",Font.BOLD, 15));
		
		//배경색 설정
		pMain.setBackground(Color.white);
		pMain.setBackground(Color.white);
		pTop.setBackground(Color.white);
		pCenter.setBackground(Color.white);
		pCenterin.setBackground(Color.white);
		pSouth.setBackground(Color.white);
		
		
		InnerMouseHandler imh= new InnerMouseHandler();
	   home.addMouseListener(imh);
	    
	
		
		//버튼 리스너(로그인, 회원가입)
	    j1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent T) {
	    		try {
	    		String uid=idt.getText();
	    		char[]ch=pwt.getPassword();
	    		String pwd=new String(ch);
	    		//유효성 체크     //trim() : 문자열 앞 뒤의 공백문자를 제거함
	    		if(uid==null||pwd==null||uid.trim().equals("")
	    				||pwd.trim().isEmpty()) {
	    			JOptionPane.showMessageDialog(pCenter,"아이디와 비밀번호를 입력하세요");
	    			idt.requestFocus();
	    			return;
	    		}else {
	            	
	            	String s;
	    			String[] array;
	    			String login_flag = "N";
	    			BufferedReader bos = new BufferedReader(new FileReader("C:\\\\\\\\회원명단\\\\\\\\회원명단.txt"));
	    			while((s=bos.readLine())!=null){
	    				array=s.split("/");
	    			if(uid.equals(array[1])&&pwd.equals(array[2]))
	    			{
	    				
	    				login_flag = "Y";
	    				
	    						
	    						
	    				//로그인이 되면 메인화면으로 이동해주기
	    			}
	    			
	    			}
	    			if(login_flag.equals("Y")) {
	    				JOptionPane.showMessageDialog(pCenter,"로그인 성공! 메인으로 이동합니다.");
	    				setVisible(false);
	    				dispose();
	    			}else {
	    				 JOptionPane.showMessageDialog(null, "아이디랑 비밀번호를 확인하세요.");
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
		//창닫기
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
}
