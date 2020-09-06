package Project_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class MainFrameModify extends JFrame {

	JPanel pCard = new JPanel();
	JPanel pHome = new JPanel();
	
	JPanel pHi = new JPanel();
	
	JPanel pMainCenter = new JPanel();
	
	
	JPanel pMain = new JPanel();
	JPanel pMainBut = new JPanel();
	JPanel pMainMesaage = new JPanel();
	JPanel pBottom = new JPanel();
	
	JPanel recommend = new JPanel();
	JPanel recommendImage = new JPanel();
	JPanel pRecommendSite = new JPanel();
	
	JButton login = new JButton("�α���");
	JButton book = new JButton("����");
	JButton bookCheck = new JButton("����Ȯ��");
	JButton question = new JButton("����");

	JLabel joinMessage = new JLabel("��! ���� ȸ������ ���̽Ű���?");
	JLabel join = new JLabel("ȸ������");
		
	JLabel greet = new JLabel("��ſ� �������� ���ϴ�");
	
	JLabel info = new JLabel("��ǥ��ȭ 02-231-4444"
			+ "     FAX: 02-343-2145     �ּ�: ����Ư���� �������� ��굿");

	
	//��õ
	JLabel recommendTitle = new JLabel("���� ������ ��� ȣ���� ã�� ���ϼ̳���?");
	JLabel recommendSite = new JLabel("�ٷΰ��� ����:");
	JLabel recommendSite2 = new JLabel("https://www.hotelscombined.co.kr/");
	
	JLabel hotel1= new JLabel(new ImageIcon("images/hotel1.PNG"));
	JLabel hotel2= new JLabel(new ImageIcon("images/hotel2.PNG"));
	JLabel hotel3= new JLabel(new ImageIcon("images/hotel3.PNG"));
	
	Font f1 = new Font("����", Font.PLAIN, 30);
	Font f11 = new Font("����", Font.PLAIN, 35);
	Font title = new Font("����", Font.BOLD, 35);
	Font f2 = new Font("����", Font.PLAIN, 20);
	Font f21 = new Font("����", Font.ITALIC, 20);
	Font f3 = new Font("����", Font.PLAIN, 10);
	
	static String[] s1=  new String[4];
	
	FlightSearchModify fs = new FlightSearchModify(MainFrameModify.this);
	CardLayout card = new CardLayout();
	BorderLayout Homeb = new BorderLayout();
	BorderLayout Mainb = new BorderLayout();
	BorderLayout recommendb = new BorderLayout();

	
	static int cnt=0;
	Hashtable<String, ReservePanel> ht1 = new Hashtable<>();
	
	
	public MainFrameModify() {

		super("���� ��꿡 ���� ������! ȯ���մϴ�!");

		Container cp = getContentPane();
		cp.add(pCard, "Center");
		pCard.setBackground(Color.white);
		pCard.setLayout(card);

		// pHome
		pHome.setLayout(Homeb);

		// ��� �λ縻 �г�
		pHi.setBorder(new EmptyBorder(50, 30, 30, 30));
		greet.setForeground(new Color(53, 128,83));
		greet.setFont(title);
		pHi.add(greet);
		
		//��� �̹���
		JLabel logo = new JLabel(new ImageIcon("images/LOGO.jpg"));
		pHi.add(logo,BorderLayout.WEST);
		pHi.setBackground(Color.white);

		pHome.add(pHi, BorderLayout.NORTH);

		// ���� �г�
		pMain.setLayout(Mainb);
		pMainBut.setBorder(new EmptyBorder(0, 10, 10, 10));

		
		login.setPreferredSize(new Dimension(160, 70));
		book.setPreferredSize(new Dimension(160, 70));
		bookCheck.setPreferredSize(new Dimension(160, 70));
		question.setPreferredSize(new Dimension(160, 70));
		
		login.setBackground(new Color(53,128,83));
		book.setBackground(new Color(53,128,83));
		bookCheck.setBackground(new Color(53,128,83));
		question.setBackground(new Color(53,128,83));
		
		login.setForeground(Color.white);
		book.setForeground(Color.white);
		bookCheck.setForeground(Color.white);
		question.setForeground(Color.white);

		login.setFont(f2);
		book.setFont(f2);
		bookCheck.setFont(f2);
		question.setFont(f2);

		pMainBut.add(login);
		pMainBut.add(book);
		pMainBut.add(bookCheck);
		pMainBut.add(question);
		
		pMain.setBorder(new EmptyBorder(20,20,80,20));
		

		pMain.add(pMainBut, BorderLayout.CENTER);

		// ȸ������ �޼���
		
		joinMessage.setFont(f2);
		join.setFont(f21);
		
		pMainMesaage.add(joinMessage);
		pMainMesaage.add(join);
		
		JoinHandler jh=new JoinHandler();
		join.addMouseListener(jh);

		pMain.add(pMainMesaage, BorderLayout.SOUTH);
		
		//��õ ���
		recommend.setLayout(recommendb);
		recommendTitle.setFont(f2);                                                                      
		recommend.add(recommendTitle, BorderLayout.NORTH);
		
		//��õ�̹���
		recommendImage.add(hotel1);
		hotel1.setToolTipText("����ī�� ���з� , ����");
		recommendImage.add(hotel2);
		hotel2.setToolTipText("ũ��� �Ϲ� ȣ��, �λ� ");
		recommendImage.add(hotel3);
		hotel3.setToolTipText("�Ե� ȣ��, ����");
		recommend.add(recommendImage,BorderLayout.CENTER);
		//�ٷΰ��� ����:
		recommendSite.setFont(f2);
		recommendSite2.setFont(f2);
		
		recommendSite.setForeground(new Color(198,198,198));
		recommendSite2.setForeground(new Color(198,198,198));
		
		pRecommendSite.add(recommendSite,BorderLayout.WEST);
		pRecommendSite.add(recommendSite2,BorderLayout.CENTER);
		
		recommend.add(pRecommendSite, BorderLayout.SOUTH);
		
           
		//PpMainCenter�� ����
		pMainCenter.add(pMain, BorderLayout.CENTER);
		pMainCenter.add(recommend, BorderLayout.SOUTH);
		
		//pHome�� ����
		pHome.add(pMainCenter);
		
		//pRecommendSite addMouseListener
		MyHandler2 mh= new MyHandler2();
		recommendSite2.addMouseListener(mh);
		
		// �ϴ� ���� �г�
		pBottom.setBackground(Color.gray);
		info.setFont(f2);
		pBottom.add(info);

		pHome.add(pBottom, BorderLayout.SOUTH);

		// pHome�� pCard�� ���̱�
		pCard.add(pHome, "HOME");
		
		//ActionListener
		
		//�α��� ��ư
				login.addActionListener((e)->{
					Login login=new Login();
					login.setSize(400,600);
					login.setVisible(true);
				});
				// ���� ��ư ActionListener
				book.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						fs.setSize(1200, 800);
						fs.setVisible(true);
					}

				});
		//���� ��ư ActionListener
				question.addActionListener((e)->{

					Test2 questionFrame= new Test2();
					questionFrame.setSize(1200, 800);
				    questionFrame.setVisible(true);
				});
				
		// ���� Ȯ�� ��ư 
				bookCheck.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						System.out.println(s1[0]);
						System.out.println(s1[1]);
						System.out.println(s1[2]);
						System.out.println(s1[3]);
						
						ReserveFrame rf = new ReserveFrame();
						
					}
				});
				
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class MyHandler2 extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			try {
                Desktop.getDesktop().browse(new URI("https://www.hotelscombined.co.kr/"));
            } catch (URISyntaxException | IOException ex) {
            	
            }
			
		}
		
	}
	class JoinHandler extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			Join join= new Join();
			join.setSize(800, 800);
			join.setVisible(true);
			
		}
	}
        

	public static void main(String[] args) {
		MainFrameModify mf = new MainFrameModify();
		mf.setSize(1200, 800);
		mf.setVisible(true);
	}
}
