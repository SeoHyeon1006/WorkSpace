package Project_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ReservePanel extends JPanel {

	String s1 = "                              ���";
	String s2 = "          ����";
	String line = "      ---------------";

	JPanel mainP = new MyJPanel(5, 5, 5, 5);
	JPanel p2 = new JPanel(new BorderLayout());

	JLabel ReserveNum;

	JLabel lbNum = new JLabel("     MPKVCE / 8527-3656");
	JLabel lbMon;

	JLabel l1, l2, l3, l4, l5, l6, l7;
	JButton btCancel = new JButton("�������");

	Font menuFont = new Font("Console", Font.PLAIN, 20);

	// ���� ��� ����
	Hashtable<String, ReservePanel> ht;
	ReserveFrame parent;
	int cnt;

	// ������ �޴� ����
	String sLocation;
	String aLocation;
	String date;
	String sTime;
	String aTime;
	JLabel lbNone;

	// ���� ������ ����

	int cnt2;

	// ������ ��������

	public ReservePanel(ReserveFrame parent, int cnt, ReserveVO vo) {

		this.parent = parent;
		this.cnt = cnt;
		this.sLocation = "                   "+vo.getDeparturePlace();// parent.sLocation;
		this.aLocation = vo.getArrivalPlace();// parent.aLocation;
		this.date = "2020/05/22 (��)";
		this.sTime = vo.getDepartureTime(); // parent.sTime;
		this.aTime = vo.getArrivalTime();// parent.aTime;
		this.cnt2 = vo.getNum();

		// ReservePanelSet
		this.add(mainP);
		mainP.setLayout(new BorderLayout());
		mainP.setBorder(new TitledBorder(""));

		// North
		mainP.add(p2, "North");
		p2.add(lbNum, "Center");
		p2.setBackground(new Color(223, 228, 234));
		lbNum.setFont(new Font("Console", Font.PLAIN, 20));

		// �����ȣ ��
		ReserveNum = new JLabel("   �����ȣ: " + cnt2);
		p2.add(ReserveNum, "West");
		ReserveNum.setFont(new Font("Console", Font.PLAIN, 15));

		// ���೯¥ ��
		lbMon = new JLabel(date + "    ");
		p2.add(lbMon, "East");
		lbMon.setFont(new Font("Console", Font.PLAIN, 15));

		// Center
		JPanel p3sub = new MyJPanel(20, 30, 20, 20);
		mainP.add(p3sub, "Center");
		p3sub.setLayout(new GridLayout(3, 0, 5, 0));

		// �����, ������ ��
		l1 = new JLabel(sLocation);
		l2 = new JLabel("      " + aLocation);

		p3sub.add(l1);
		l1.setFont(menuFont);
		p3sub.add(l2);
		l2.setFont(menuFont);

		l3 = new JLabel("");
		p3sub.add(l3);

		// ��߽ð�, �����ð� ��
		l4 = new JLabel(sTime + line);
		l5 = new JLabel("     " + aTime);

		p3sub.add(l4);
		l4.setFont(menuFont);
		p3sub.add(l5);
		l5.setFont(menuFont);

		// ������� ��ư
		p3sub.add(btCancel);
		btCancel.setBackground(new Color(53, 128, 83));
		btCancel.setForeground(Color.white);
		btCancel.setFont(new Font("Console", Font.BOLD, 15));

		// ---
		l6 = new JLabel(s1);
		l7 = new JLabel(s2);
		p3sub.add(l6);
		l6.setForeground(new Color(127, 140, 141));
		l6.setFont(new Font("Console", Font.BOLD, 15));
		p3sub.add(l7);
		l7.setForeground(new Color(127, 140, 141));
		l7.setFont(new Font("Console", Font.BOLD, 15));

		this.ht = parent.ht1;

		btCancel.setActionCommand("p" + cnt+"/"+cnt2);

		// btCancel.setText(btCancel.getText()+"p"+cnt);

		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				System.out.println(cmd+">>>>>");
				int cancel = JOptionPane.showConfirmDialog(null, "������ ������ ����Ͻðڽ��ϱ�?", "�������",
						JOptionPane.YES_NO_OPTION);
				if(cancel==JOptionPane.NO_OPTION) return;
				String now = "";
				String[] tk=cmd.split("\\/");// split: ���ڿ� ������ /���������� ����.
																	// ��ȯ���� �迭
				System.out.println(tk[0]);
				System.out.println(tk[1]);
				now = tk[1]; //cmd.charAt(1);
				int chk = Integer.parseInt(now);
				System.out.println(chk);
				if (cancel == JOptionPane.CLOSED_OPTION) {
				} else if (cancel == JOptionPane.YES_OPTION) {

					// for(ReserveVO vo:FlightSearchModify.v) {
					for (int i = FlightSearchModify.v.size() - 1; i >= 0; i--) {
						if (chk == vo.getNum()) {
							FlightSearchModify.v.remove(vo);

							ReservePanel rp = ht.get(tk[0]);
							if(rp!=null) {
								parent.subp.remove(rp);
								parent.subp.updateUI();
							}
							break;
						}

					}


				}

			}
		});

	} // Constructor

	@Override
	public Insets getInsets() {
		return new Insets(10, 10, 1, 10);
	}

}
