package IT1;

import java.awt.*;//抽象窗口工具包，该包提供了一套与本地图形界面进行交互的接口
import javax.swing.*;


public class Jframe extends JFrame {
	private JPanel jp;
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe frame=new Jframe();
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}

			
		});
	}
	
	public Jframe() {
		jp=new JPanel();
		jp.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		this.setBackground(Color.WHITE);
		this.setContentPane(jp);
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

}
