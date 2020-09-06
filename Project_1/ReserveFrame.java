package Project_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;


public class ReserveFrame extends JFrame {

	JPanel pNorth = new JPanel(new BorderLayout());
	JPanel pCenter = new JPanel(new BorderLayout(0, 5));
	JPanel p2Center = new JPanel();

	JLabel lbHome = new JLabel(new ImageIcon("images/left.png"));
	JLabel lbRlist = new JLabel("���� ���� ����", JLabel.CENTER);
	
	JPanel pNone = new JPanel(new BorderLayout());
	JLabel lbNone = new JLabel("��ȸ�� ���� ������ �����ϴ�.");
	
	JButton test = new JButton("���ų��� Ȯ��");
	JScrollPane sc = new JScrollPane();
	Hashtable<String, ReservePanel> ht1 = new Hashtable<>();
	static int cnt=0;
	MainFrameModify mf = new MainFrameModify();
	ReserveTime rt;
	
	
	public ReserveFrame() {
		super("::ReserveFrame::");
		
		Container cp = this.getContentPane();
		cp.add(pNorth, "North");
		cp.add(pCenter, "Center");
		
		// Ȩ ��ư, ���� ���� ���� ��
		pCenter.add(pNorth,"North");
		pNorth.add(lbHome, BorderLayout.WEST);
		pNorth.add(lbRlist,BorderLayout.CENTER);
		lbRlist.setFont(new Font("����",Font.PLAIN ,30));
		lbRlist.setForeground(new Color(53, 128, 83));
		
		pNorth.setBorder(new EmptyBorder(30,10,20,10));
		
		// Ȩ ��ư �� �̺�Ʈó��
		MyMouseHandler my2 = new MyMouseHandler();
		lbHome.addMouseListener(my2);
		
		pCenter.add(sc,"Center");
		sc.setViewportView(p2Center);
		
		
		// ��ȸ ���� ���� ��
		p2Center.setLayout(new GridLayout());
		p2Center.add(lbNone, "Center");
		lbNone.setFont(new Font("Console", Font.PLAIN, 35));
		lbNone.setHorizontalAlignment(JLabel.CENTER);
		lbNone.setForeground(Color.gray);
		
		
		pNorth.add(test,BorderLayout.EAST);
		
		MyHandler my = new MyHandler();
		test.addActionListener(my);
		
		
		
		setSize(1200, 800);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	
	MyJPanelp subp=new MyJPanelp(10, 0, 0, 0);
	
	
	
	/** ��ư �޼ҵ� */
	class MyHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			p2Center.setLayout(new FlowLayout());
			lbNone.setVisible(false);
			//lbNone.setFont(new Font("Console", Font.PLAIN, 100));
			
			for(ReserveVO vo:FlightSearchModify.v) {
			
			ReservePanel rs = new ReservePanel(ReserveFrame.this,cnt, vo);
			ht1.put("p"+cnt,rs);
			cnt++;
		
			
			subp.setLayout(new GridLayout(0, 1));
			subp.add(rs);
			p2Center.add(subp);
			p2Center.validate();
			}
		}
		
	} /////////
	
	class MyMouseHandler extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			Object obj = e.getSource();
			if (obj == lbHome) { 
	            int getHome = JOptionPane.showConfirmDialog(null,
	            "������������ ���ư��ðڽ��ϱ�?", "", JOptionPane.YES_NO_OPTION);

                if(getHome == JOptionPane.CLOSED_OPTION) {}
                else if(getHome == JOptionPane.YES_OPTION) {
                	setVisible(false);
                	dispose();
                } else {}
                
			}
		}
		
	} //////////

			
		
	

	public static void main(String[] args) {
		new ReserveFrame();

	}

}
