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
	
	JButton login = new JButton("로그인");
	JButton book = new JButton("예매");
	JButton bookCheck = new JButton("예매확인");
	JButton question = new JButton("문의");

	JLabel joinMessage = new JLabel("앗! 아직 회원가입 전이신가요?");
	JLabel join = new JLabel("회원가입");
		
	JLabel greet = new JLabel("즐거움에 안전함을 더하다");
	
	JLabel info = new JLabel("대표전화 02-231-4444"
			+ "     FAX: 02-343-2145     주소: 서울특별시 영등포구 당산동");

	
	//추천
	JLabel recommendTitle = new JLabel("아직 마음에 드는 호텔을 찾지 못하셨나요?");
	JLabel recommendSite = new JLabel("바로가기 참조:");
	JLabel recommendSite2 = new JLabel("https://www.hotelscombined.co.kr/");
	
	JLabel hotel1= new JLabel(new ImageIcon("images/hotel1.PNG"));
	JLabel hotel2= new JLabel(new ImageIcon("images/hotel2.PNG"));
	JLabel hotel3= new JLabel(new ImageIcon("images/hotel3.PNG"));
	
	Font f1 = new Font("돋움", Font.PLAIN, 30);
	Font f11 = new Font("돋움", Font.PLAIN, 35);
	Font title = new Font("돋움", Font.BOLD, 35);
	Font f2 = new Font("돋움", Font.PLAIN, 20);
	Font f21 = new Font("돋움", Font.ITALIC, 20);
	Font f3 = new Font("돋움", Font.PLAIN, 10);
	
	static String[] s1=  new String[4];
	
	FlightSearchModify fs = new FlightSearchModify(MainFrameModify.this);
	CardLayout card = new CardLayout();
	BorderLayout Homeb = new BorderLayout();
	BorderLayout Mainb = new BorderLayout();
	BorderLayout recommendb = new BorderLayout();

	
	static int cnt=0;
	Hashtable<String, ReservePanel> ht1 = new Hashtable<>();
	
	
	public MainFrameModify() {

		super("에어 당산에 오신 여러분! 환영합니다!");

		Container cp = getContentPane();
		cp.add(pCard, "Center");
		pCard.setBackground(Color.white);
		pCard.setLayout(card);

		// pHome
		pHome.setLayout(Homeb);

		// 상단 인사말 패널
		pHi.setBorder(new EmptyBorder(50, 30, 30, 30));
		greet.setForeground(new Color(53, 128,83));
		greet.setFont(title);
		pHi.add(greet);
		
		//상단 이미지
		JLabel logo = new JLabel(new ImageIcon("images/LOGO.jpg"));
		pHi.add(logo,BorderLayout.WEST);
		pHi.setBackground(Color.white);

		pHome.add(pHi, BorderLayout.NORTH);

		// 메인 패널
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

		// 회원가입 메세지
		
		joinMessage.setFont(f2);
		join.setFont(f21);
		
		pMainMesaage.add(joinMessage);
		pMainMesaage.add(join);
		
		JoinHandler jh=new JoinHandler();
		join.addMouseListener(jh);

		pMain.add(pMainMesaage, BorderLayout.SOUTH);
		
		//추천 목록
		recommend.setLayout(recommendb);
		recommendTitle.setFont(f2);                                                                      
		recommend.add(recommendTitle, BorderLayout.NORTH);
		
		//추천이미지
		recommendImage.add(hotel1);
		hotel1.setToolTipText("오라카이 대학로 , 서울");
		recommendImage.add(hotel2);
		hotel2.setToolTipText("크라운 하버 호텔, 부산 ");
		recommendImage.add(hotel3);
		hotel3.setToolTipText("롯데 호텔, 제주");
		recommend.add(recommendImage,BorderLayout.CENTER);
		//바로가기 참조:
		recommendSite.setFont(f2);
		recommendSite2.setFont(f2);
		
		recommendSite.setForeground(new Color(198,198,198));
		recommendSite2.setForeground(new Color(198,198,198));
		
		pRecommendSite.add(recommendSite,BorderLayout.WEST);
		pRecommendSite.add(recommendSite2,BorderLayout.CENTER);
		
		recommend.add(pRecommendSite, BorderLayout.SOUTH);
		
           
		//PpMainCenter에 부착
		pMainCenter.add(pMain, BorderLayout.CENTER);
		pMainCenter.add(recommend, BorderLayout.SOUTH);
		
		//pHome에 부착
		pHome.add(pMainCenter);
		
		//pRecommendSite addMouseListener
		MyHandler2 mh= new MyHandler2();
		recommendSite2.addMouseListener(mh);
		
		// 하단 정보 패널
		pBottom.setBackground(Color.gray);
		info.setFont(f2);
		pBottom.add(info);

		pHome.add(pBottom, BorderLayout.SOUTH);

		// pHome을 pCard로 붙이기
		pCard.add(pHome, "HOME");
		
		//ActionListener
		
		//로그인 버튼
				login.addActionListener((e)->{
					Login login=new Login();
					login.setSize(400,600);
					login.setVisible(true);
				});
				// 예약 버튼 ActionListener
				book.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						fs.setSize(1200, 800);
						fs.setVisible(true);
					}

				});
		//문의 버튼 ActionListener
				question.addActionListener((e)->{

					Test2 questionFrame= new Test2();
					questionFrame.setSize(1200, 800);
				    questionFrame.setVisible(true);
				});
				
		// 예약 확인 버튼 
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
