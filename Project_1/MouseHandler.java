package Project_1;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MouseHandler extends JPanel {

	JPanel north = new JPanel(new BorderLayout());
	JLabel home = new JLabel(new ImageIcon("images/left.png"));
	JLabel homeGreet = new JLabel("�׻� �ּ��� ���ϰڽ��ϴ�.");
	
	FlightSearchModify fs;
	MainFrameModify mf;
	
	public MouseHandler(MainFrameModify mf){
		
		this.mf=mf;

		// MouseHandler ���̱�.
		InnerMouseHandler imh = new InnerMouseHandler();
		fs.home.addMouseListener(imh);
	 

	}

	class InnerMouseHandler extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			
			Object o = e.getSource();
			
			if (o == fs.home) { 
				System.out.println("click");
				int result= JOptionPane.showConfirmDialog
						(null, "������������ ���ư��ðڽ��ϱ�? ������������ ���ư��� �����ߴ� ������ ������ϴ�.",
						"�ƴϿ�",JOptionPane.YES_NO_CANCEL_OPTION);
				
						if(result==JOptionPane.CLOSED_OPTION) {
							
						}
						else if(result==JOptionPane.YES_OPTION) {
							mf.card.show(mf.pCard, "HOME");
						}
						else {
							
						}
				}
		}
	}//InnerŬ���� end

}
	
