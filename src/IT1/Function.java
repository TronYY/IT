package IT1;

import java.awt.*;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;

public class Function extends JFrame {
	private static final double WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static final double HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private static final int INCREMENT = 20;
	
	public static void main(String[] args) {
		new Function();
	}
	
	public Function() {
		this.setTitle("��ͼ��sinx/x");
		this.setLocation(50, 50);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		Color source = g2d.getColor();
		
		g2d.setColor(Color.BLACK);
		g2d.drawString("sinx/x ��ͼ��", 50, 50);
		

		// �� X ��
		g2d.drawLine(INCREMENT, (int)HEIGHT/2, (int)WIDTH-INCREMENT, (int)HEIGHT/2);
		g2d.drawLine((int)WIDTH-INCREMENT, (int)HEIGHT/2, (int)WIDTH-10, (int)HEIGHT/2-5);
		g2d.drawLine((int)WIDTH-INCREMENT, (int)HEIGHT/2, (int)WIDTH-10, (int)HEIGHT/2+5);
		

		// �� Y ��
		g2d.drawLine((int)WIDTH/2, 40, (int)WIDTH/2, (int)HEIGHT-50);
		g2d.drawLine((int)WIDTH/2, 40, (int)WIDTH/2-10, 50);
		g2d.drawLine((int)WIDTH/2, 40, (int)WIDTH/2+10, 50);
		
		// ����ǰ�����ƶ�������
		g2d.translate((int) WIDTH / 2, (int) HEIGHT / 2);

		// ����GeneralPath����������
		GeneralPath gp = new GeneralPath();

		// ��GeneralPath��ʵ��gp�Ļ����ƶ�����ǰ��������ģ�����������������g2d���ʵ����ĵ�
		gp.moveTo(0, 0);

		// ��sin(x)/x ��ͼ��
//		drawSinxDX(gp, g2d);

		// sin(x)��ͼ��
		drawSinx(gp, g2d);

		// cos(x)��ͼ��
//		drawCosx(gp, g2d);

		// tan(x)��ͼ��
//		drawTanx(gp, g2d);
		g2d.setColor(source);
	}

	private void drawTanx(GeneralPath gp, Graphics2D g2d) {
		for (double i = 0.000001; i <= 8*Math.PI; i+=0.0001*Math.PI) {
			gp.lineTo(20*i, 100*-Math.tan(i));
		}
		g2d.draw(gp);

		// ����ǰ������ԭ��Ϊ���ģ���ת180�ȣ����溯��������ԭ��Գƣ�
		g2d.rotate(Math.PI);
		g2d.draw(gp);
	}

	private void drawCosx(GeneralPath gp, Graphics2D g2d) {
		for (double i = 0.000001; i <= 8*Math.PI; i+=0.0001*Math.PI) {
			gp.lineTo(20*i, 100*-Math.cos(i));
		}
		g2d.draw(gp);

		// ����ǰ������Y��Ϊ�Գ��ᣬ��ż����(����Y��Գ�)
		g2d.scale(-1, 1);
		g2d.draw(gp);
	}
	private void drawSinx(GeneralPath gp, Graphics2D g2d) {
		for (double i = 0.000001; i <= 8*Math.PI; i+=0.0001*Math.PI) {
        	  gp.lineTo(20*i, 100*-Math.sin(i));
        	}
		g2d.draw(gp);
		g2d.rotate(Math.PI);
		g2d.draw(gp);
	}

	private void drawSinxDX(GeneralPath gp, Graphics2D g) {
		for (double i = 0.000001; i <= 8*Math.PI; i+=0.0001*Math.PI) {
        	 gp.lineTo(20*i, 100*-Math.sin(i)/i);
         	}
		g.draw(gp);
		g.scale(-1, 1);
		g.draw(gp);
	}
}