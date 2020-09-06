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

	// ���� Content
	JPanel pMainContent = new JPanel();
	JPanel pPlace = new JPanel();
	JPanel pDate = new JPanel();
	JPanel pSit = new JPanel();

	// ���� ��ư
	JPanel pNext = new JPanel();

	// TOP ���ư��� �λ��
	JPanel pTop = new JPanel();
	JLabel home = new JLabel(new ImageIcon("images/left.png"));// Back ����
	JLabel TopGreet = new JLabel("���� �������Դϴ�.",JLabel.CENTER);
	
	 DefaultListModel<String> model;
	 DefaultListModel<String> model2;

	// ���, ���� ��¥
	JLabel departure = new JLabel("��߳�¥");
	JLabel arrival = new JLabel("������¥");

	// �¼� ���
	JLabel SelectGrade = new JLabel("�¼� ��� ");
	JRadioButton first = new JRadioButton("�۽�Ʈ");
	JRadioButton business = new JRadioButton("����Ͻ�");
	JRadioButton economy = new JRadioButton("���ڳ��");
	ButtonGroup groupRd = new ButtonGroup();

	// ���� ��ư
	JButton next = new JButton("NEXT");
	
	//���̾ƿ�
	BorderLayout bTop = new BorderLayout();
	BorderLayout bMain = new BorderLayout();
	
	//MainFrame 
	MainFrameModify mfm ;
	ReserveTime rt;
	
	//�� ��������
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

		// Top ���� >> MainHome���� ���ư���
		pTop.setLayout(bTop);
		pTop.add(home, BorderLayout.WEST);
		
		TopGreet.setFont(mfm.f11);
		TopGreet.setForeground(new Color(53, 128, 83));
		pTop.add(TopGreet, BorderLayout.CENTER);
			
		pTop.setBorder(new EmptyBorder(30,10,30,10));

		//home addMouseListener
		InnerMouseHandler imh = new InnerMouseHandler();
		home.addMouseListener(imh);

		// Main ����
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
					 
					 departureDate+="��� ��¥:"+"\t";
					 departureDate+=model.getYear()+"-";
					 departureDate+=model.getMonth()+"-";
					 departureDate+=model.getDay();
					 
					 arrivalDate+="���� ��¥:"+"\t";
					 arrivalDate+=model2.getYear()+"-";
					 arrivalDate+=model2.getMonth()+"-";
					 arrivalDate+=model2.getDay();
					 
				parent.s1[0]=pp.combo1.getSelectedItem().toString();
				parent.s1[1]=pp.combo2.getSelectedItem().toString();
				
				
				
				
				
				//�� �ҷ�����
				System.out.println(parent.s1);
				 
				 
				 if(groupRd.getSelection()==economy.getModel()) {
					 SitGrade="���ڳ��";
				 }
				 else  if(groupRd.getSelection()==business.getModel()) {
					 SitGrade="����Ͻ�";
				 }
				 else  if(groupRd.getSelection()==first.getModel()) {
					 SitGrade="�۽�Ʈ";
				 }
				
				if(pp.combo1.getSelectedItem().toString().equals("�����") ||
					pp.combo2.getSelectedItem().toString().equals("������")) {
					JOptionPane.showMessageDialog(pPlace, "������� �������� Ȯ���ϼ���");
				}
				else if(pp.combo1.getSelectedItem().toString()
						.equals(pp.combo2.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(pPlace, "���� ������� ������ �Դϴ�.");
					
				}
				else if(pp.combo1.getSelectedItem().toString().equals("��õ") &&
						pp.combo2.getSelectedItem().toString().equals("�λ�") ||
						pp.combo2.getSelectedItem().toString().equals("����")) {
							JOptionPane.showMessageDialog(pPlace, "�ش� �������� ���� ����Ⱑ �����ϴ�.");
				}
				else if(pp.combo1.getSelectedItem().toString().equals("�λ�") &&
						pp.combo2.getSelectedItem().toString().equals("��õ") ||
						pp.combo2.getSelectedItem().toString().equals("����")) {
							JOptionPane.showMessageDialog(pPlace, "�ش� �������� ���� ����Ⱑ �����ϴ�.");
				}	
				else if(pp.combo1.getSelectedItem().toString().equals("����") &&
						pp.combo2.getSelectedItem().toString().equals("��õ") ||
						pp.combo2.getSelectedItem().toString().equals("�λ�")) {
							JOptionPane.showMessageDialog(pPlace, "�ش� �������� ���� ����Ⱑ �����ϴ�.");
				}	
				else if(model.getValue()==null || model2.getValue()==null) {
					JOptionPane.showMessageDialog(pPlace, "��¥�� Ȯ���ϼ���");
				}
				else if(!economy.isSelected() && !business.isSelected() &&
						!first.isSelected()) {
					JOptionPane.showMessageDialog(pPlace, "�¼������ �����ϼ���");
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
						(null, "������������ ���ư��ðڽ��ϱ�? ������������ ���ư��� �����ߴ� ������ ������ϴ�.",
						"�ƴϿ�",JOptionPane.YES_NO_OPTION);
				
						if(result==JOptionPane.CLOSED_OPTION) {
							
						}
						else if(result==JOptionPane.YES_OPTION) {
							setVisible(false);
							dispose();
						}
						
						
				}
		}
	}//InnerŬ���� end
		

}
