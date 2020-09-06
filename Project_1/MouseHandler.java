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
	JLabel homeGreet = new JLabel("항상 최선을 다하겠습니다.");
	
	FlightSearchModify fs;
	MainFrameModify mf;
	
	public MouseHandler(MainFrameModify mf){
		
		this.mf=mf;

		// MouseHandler 붙이기.
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
						(null, "이전페이지로 돌아가시겠습니까? 이전페이지로 돌아가면 진행했던 내용은 사라집니다.",
						"아니요",JOptionPane.YES_NO_CANCEL_OPTION);
				
						if(result==JOptionPane.CLOSED_OPTION) {
							
						}
						else if(result==JOptionPane.YES_OPTION) {
							mf.card.show(mf.pCard, "HOME");
						}
						else {
							
						}
				}
		}
	}//Inner클래스 end

}
	
