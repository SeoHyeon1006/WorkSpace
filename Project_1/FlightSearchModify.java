package Project_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


public class FlightSearchModify extends JFrame {

	// 메인 Content
	JPanel pMainContent = new JPanel();
	JPanel pPlace = new JPanel();
	JPanel pDate = new JPanel();
	JPanel pSit = new JPanel();

	// 다음 버튼
	JPanel pNext = new JPanel();

	// TOP 돌아가기 인사라벨
	JPanel pTop = new JPanel();
	JLabel home = new JLabel(new ImageIcon("images/left.png"));// Back 사진
	JLabel TopGreet = new JLabel("예매 진행중입니다.",JLabel.CENTER);
	
	 DefaultListModel<String> model;
	 DefaultListModel<String> model2;

	// 출발, 도착 날짜
	JLabel departure = new JLabel("출발날짜");
	JLabel arrival = new JLabel("도착날짜");

	// 좌석 등급
	JLabel SelectGrade = new JLabel("좌석 등급 ");
	JRadioButton first = new JRadioButton("퍼스트");
	JRadioButton business = new JRadioButton("비즈니스");
	JRadioButton economy = new JRadioButton("이코노미");
	ButtonGroup groupRd = new ButtonGroup();

	// 다음 버튼
	JButton next = new JButton("NEXT");
	
	//레이아웃
	BorderLayout bTop = new BorderLayout();
	BorderLayout bMain = new BorderLayout();
	
	//MainFrame 
	MainFrameModify mfm ;
	ReserveTime rt;
	
	//값 가져오기
	String departurePlace;
	String arrivalPlace;
	
	String departureDate="";
	String arrivalDate="";
	String SitGrade;
	static String s2[] = new String[2];
	
	static Vector<ReserveVO> v=new Vector<>();
	static int cnt;

	public FlightSearchModify(MainFrameModify parent) {
		
		super("FlightSearch");
		mfm=parent;
		MainFrameModify.s1[2] =FlightSearchModify.s2[0];
		MainFrameModify.s1[3] = FlightSearchModify.s2[1];

		Container cp = getContentPane();
		cp.add(pTop, BorderLayout.NORTH);
		cp.add(pMainContent, BorderLayout.CENTER);
		cp.add(next, BorderLayout.SOUTH);

		// Top 내용 >> MainHome으로 돌아가기
		pTop.setLayout(bTop);
		pTop.add(home, BorderLayout.WEST);
		
		TopGreet.setFont(mfm.f11);
		TopGreet.setForeground(new Color(53, 128, 83));
		pTop.add(TopGreet, BorderLayout.CENTER);
			
		pTop.setBorder(new EmptyBorder(30,10,30,10));

		//home addMouseListener
		InnerMouseHandler imh = new InnerMouseHandler();
		home.addMouseListener(imh);

		// Main 내용
		pMainContent.setLayout(new BorderLayout());

		// pPlace
		pPlacePart pp=new pPlacePart();
		pp.setBorder(new EmptyBorder(30,10,10,10));
		pPlace.add(pp);
		pMainContent.add(pPlace,"North");
			
		
		
		// pDate
			// departure
				departure.setFont(mfm.f2);
				pDate.add(departure);
				UtilDateModel model = new UtilDateModel();
				JDatePanelImpl datePanel = new JDatePanelImpl(model);
				JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
				pDate.add(datePicker);
			
			// arrival
				arrival.setFont(mfm.f2);
				pDate.add(arrival);
				UtilDateModel model2 = new UtilDateModel();
				JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
				JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2);
				pDate.add(datePicker2);
				
				pDate.setBorder(new EmptyBorder(100,10,30,10));
		
		pMainContent.add(pDate, BorderLayout.CENTER);
		
		//pSit
		
		SelectGrade.setFont(mfm.f21);
		economy.setFont(mfm.f21);
		business.setFont(mfm.f21);
		first.setFont(mfm.f21);
		
		groupRd.add(economy);
		groupRd.add(business);
		groupRd.add(first);
		
		pSit.add(SelectGrade);
		pSit.add(economy);
		pSit.add(business);
		pSit.add(first);
		pSit.setBorder(new EmptyBorder(10,10,40,10));
		
		
		pMainContent.add(pSit, BorderLayout.SOUTH);
		
		if(groupRd.getSelection()==economy.getModel()) {
	    	  System.out.println(economy.getText());
	      }
		else if(groupRd.getSelection()==business.getModel()) {
			System.out.println(business.getText());
		}
		

		//Next 
		next.setPreferredSize(new Dimension(300, 50));
		next.setBackground(new Color(53,128,83));
		next.setForeground(Color.WHITE);
		next.setFont(mfm.f2);
		
		
		
		//NextAddListener
				next.addActionListener(e->{
					departurePlace=pp.combo1.getSelectedItem().toString();
					 arrivalPlace=pp.combo2.getSelectedItem().toString();
					 
					 departureDate+="출발 날짜:"+"\t";
					 departureDate+=model.getYear()+"-";
					 departureDate+=model.getMonth()+"-";
					 departureDate+=model.getDay();
					 
					 arrivalDate+="도착 날짜:"+"\t";
					 arrivalDate+=model2.getYear()+"-";
					 arrivalDate+=model2.getMonth()+"-";
					 arrivalDate+=model2.getDay();
					 
				parent.s1[0]=pp.combo1.getSelectedItem().toString();
				parent.s1[1]=pp.combo2.getSelectedItem().toString();
				
				
				
				
				
				//값 불러오기
				System.out.println(parent.s1);
				 
				 
				 if(groupRd.getSelection()==economy.getModel()) {
					 SitGrade="이코노미";
				 }
				 else  if(groupRd.getSelection()==business.getModel()) {
					 SitGrade="비즈니스";
				 }
				 else  if(groupRd.getSelection()==first.getModel()) {
					 SitGrade="퍼스트";
				 }
				
				if(pp.combo1.getSelectedItem().toString().equals("출발지") ||
					pp.combo2.getSelectedItem().toString().equals("도착지")) {
					JOptionPane.showMessageDialog(pPlace, "출발지와 도착지를 확인하세요");
				}
				else if(pp.combo1.getSelectedItem().toString()
						.equals(pp.combo2.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(pPlace, "같은 출발지와 도착지 입니다.");
					
				}
				else if(pp.combo1.getSelectedItem().toString().equals("인천") &&
						pp.combo2.getSelectedItem().toString().equals("부산") ||
						pp.combo2.getSelectedItem().toString().equals("김포")) {
							JOptionPane.showMessageDialog(pPlace, "해당 목적지를 향한 비행기가 없습니다.");
				}
				else if(pp.combo1.getSelectedItem().toString().equals("부산") &&
						pp.combo2.getSelectedItem().toString().equals("인천") ||
						pp.combo2.getSelectedItem().toString().equals("김포")) {
							JOptionPane.showMessageDialog(pPlace, "해당 목적지를 향한 비행기가 없습니다.");
				}	
				else if(pp.combo1.getSelectedItem().toString().equals("김포") &&
						pp.combo2.getSelectedItem().toString().equals("인천") ||
						pp.combo2.getSelectedItem().toString().equals("부산")) {
							JOptionPane.showMessageDialog(pPlace, "해당 목적지를 향한 비행기가 없습니다.");
				}	
				else if(model.getValue()==null || model2.getValue()==null) {
					JOptionPane.showMessageDialog(pPlace, "날짜를 확인하세요");
				}
				else if(!economy.isSelected() && !business.isSelected() &&
						!first.isSelected()) {
					JOptionPane.showMessageDialog(pPlace, "좌석등급을 선택하세요");
				}
				
				
				 
				else {
					ReserveVO re=new ReserveVO(++cnt,departureDate,arrivalDate,departurePlace,
							arrivalPlace,SitGrade,null,null);
				NextFrame nf=new NextFrame(FlightSearchModify.this, re);
				
				nf.setSize(1200,800);
				nf.setVisible(true);
				
				setVisible(false);
				dispose();
				}
				
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class InnerMouseHandler extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			Object o = e.getSource();
			
			if (o ==home) {
				int result= JOptionPane.showConfirmDialog
						(null, "이전페이지로 돌아가시겠습니까? 이전페이지로 돌아가면 진행했던 내용은 사라집니다.",
						"아니요",JOptionPane.YES_NO_OPTION);
				
						if(result==JOptionPane.CLOSED_OPTION) {
							
						}
						else if(result==JOptionPane.YES_OPTION) {
							setVisible(false);
							dispose();
						}
						
						
				}
		}
	}//Inner클래스 end
		

}
