package Project_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;
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

public class NextFrame extends JFrame {
	
	// TOP ���ư��� �λ��
		JPanel pTop = new JPanel();
		JLabel home = new JLabel(new ImageIcon("images/left.png"));// Back ����
		JLabel TopGreet = new JLabel("���� �������Դϴ�.",JLabel.CENTER);
		
		//Main
		JPanel pMain = new JPanel();
		JPanel pMainTop = new JPanel();
		JPanel pMainCenter = new JPanel();
		
		
		//�Ϸ� ��ư
		JButton Complete = new JButton("COMPLETE");
		
		//�Ϸ� ��ư �г�
		JPanel pComplete = new JPanel();
		
		BorderLayout bTop = new BorderLayout();
		BorderLayout bMain = new BorderLayout();
		
		
		//Check
		MyJPanelp subp=new MyJPanelp(10, 0, 0, 0);
		Hashtable<String, ReservePanel> ht1 = new Hashtable<>();
		static int cnt=0;
		JPanel p2Center = new JPanel();
		
		//mainFrame
		MainFrameModify mfm =new MainFrameModify();
		
		
		ReserveVO re;
		
		public NextFrame(FlightSearchModify parent, ReserveVO re) {
			super("FlightSearch");
			this.re=re;
			
			Container cp = getContentPane();
			cp.add(pTop, BorderLayout.NORTH);
			cp.add(pMain, BorderLayout.CENTER);
			cp.add(Complete, BorderLayout.SOUTH);
			
			//Top���� ���ư���
			pTop.setLayout(bTop);
			pTop.add(home, BorderLayout.WEST);
			pTop.setBorder(new EmptyBorder(20,10,30,10));
			
			TopGreet.setFont(mfm.f11);
			TopGreet.setForeground(new Color(53, 128, 83));
			pTop.add(TopGreet, BorderLayout.CENTER);
			
			//MainContent
			pMain.setLayout(bMain);
			
			ReserveTime rt= new ReserveTime(parent);
			pMainTop.add(rt);
			pMainTop.setBorder(new EmptyBorder(20,10,10,10));
			
			ReserveTime2 rt2 = new ReserveTime2(parent);
			pMainCenter.add(rt2);
			
			
			pMain.add(pMainTop, BorderLayout.NORTH);
			pMain.add(pMainCenter, BorderLayout.CENTER);
			
			//Complete �г� 
			Complete.setPreferredSize(new Dimension(300, 50));
			Complete.setBackground(new Color(53,128,83));
			Complete.setForeground(Color.WHITE);
			Complete.setFont(mfm.f2);
			
			Complete.addActionListener((e)->{
				FlightSearchModify.s2[0] = rt.l4.getText();
				FlightSearchModify.s2[1] = rt.l6.getText();
				System.out.println(rt.cb.isSelected());
				if(rt.cb.isSelected()==false) {
					JOptionPane.showMessageDialog(pMain, "����ð��� �����ϼ���.");
					return;
				}
				if(rt2.cb.isSelected()==false) {
					JOptionPane.showMessageDialog(pMain, "����ð��� �����ϼ���.");
					return;
				}
				else {
					re.setDepartureTime(rt.l4.getText());
					re.setArrivalTime(rt.l6.getText());
					parent.v.add(re);
					System.out.println(parent.v.size());
					JOptionPane.showMessageDialog(pMain, "���Ű� �Ϸ�Ǿ����ϴ�. �������� �̵��մϴ�.");
					
				}
				setVisible(false);
				dispose();
				
				mfm.setSize(1200, 800);
				mfm.setVisible(true);
				
			});
			
			
			//HOME���� ���ư��� addMouseListener
			InnerMouseHandler imh=new InnerMouseHandler();
			home.addMouseListener(imh);
		}
		class InnerMouseHandler extends MouseAdapter {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				Object o = e.getSource();
				
				if (o ==home) {
					int result= JOptionPane.showConfirmDialog
							(null, "������������ ���ư��ðڽ��ϱ�? ������������ ���ư��� �����ߴ� ������ ������ϴ�.",
							"�ƴϿ�",JOptionPane.YES_NO_OPTION);
							UIManager.put("OptionPane.messageFont", mfm.f2);
							UIManager.put("OptionPane.buttonFont", mfm.f2);

					
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
