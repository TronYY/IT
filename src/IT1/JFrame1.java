package IT1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class JFrame1 extends JFrame {
	private JPanel1 jp;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame1 frame = new JFrame1();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame1() {
		jp = new JPanel1();
		jp.setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.setBackground(Color.BLACK);
		this.setContentPane(jp);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}


class JPanel1 extends JComponent{
	int width,height;
	int zx,zy;
	int unit = 100; //��λ���Ȱ��������أ�Ҳ�ɿ��Ƿֱ�����x��y��ĵ�λ��������

	public void paintComponent(Graphics g){
		g.setColor(Color.BLACK);
		width = this.getWidth();
		height = this.getHeight();
		//	zx = 100;
		//	zy = 200;
		zx = width/2; //������ϵԭ������λ�ã����Ըı�
		zy = height/2;

		g.setColor(Color.BLACK);
		this.paintAxis(g);
		this.paintMethod(g);
		this.paintMethod1(g);
		this.paintMethod2(g);
	}

	private void paintMethod(Graphics g1){
		Point2D temp1,temp2;
		double x,y;
		Graphics2D g = (Graphics2D)g1;
		g.setColor(Color.GREEN);
		x = -1.0*zx/unit;
		y = Math.pow(x, 3) ;
		temp1 = new Point2D.Double(this.alterX(x * unit), this.alterY(y * unit));
		for(int i = 0 ; i < width; i++){
			x += 1.0/unit;
			y = Math.pow(x, 3) ;
			if ( Math.abs(y) < zy){
				temp2 = new Point2D.Double(this.alterX(x * unit), this.alterY(y * unit));	
				g.draw(new Line2D.Double(temp1, temp2));
				temp1 = temp2;
			}
		}
	}
	
	private void paintMethod1(Graphics g1){
		Point2D temp1,temp2;
		double x,y;
		Graphics2D g = (Graphics2D)g1;
		g.setColor(Color.BLUE);

		x = -1.0*zx/unit;
		y = Math.pow(Math.E, x) ;
		temp1 = new Point2D.Double(this.alterX(x * unit), this.alterY(y * unit));
		for(int i = 0 ; i < width; i++){
			x += 1.0/unit;
			y = Math.pow(Math.E, x) ;
			if ( Math.abs(y) < zy){
				temp2 = new Point2D.Double(this.alterX(x * unit), this.alterY(y * unit));	
				g.draw(new Line2D.Double(temp1, temp2));
				temp1 = temp2;
			}
		}
	}
	
	
	private void paintMethod2(Graphics g1){
		Point2D temp1,temp2;
		double x,y;
		Graphics2D g = (Graphics2D)g1;
		g.setColor(Color.PINK);

		x = -1.0*zx/unit;
		y = Math.sin(Math.PI * x);
		temp1 = new Point2D.Double(this.alterX(x * unit), this.alterY(y * unit));
		for(int i = 0 ; i < width; i++){
			x += 1.0/unit;
			y = Math.sin(Math.PI * x);
			if ( Math.abs(y) < zy){
				temp2 = new Point2D.Double(this.alterX(x * unit), this.alterY(y * unit));	
				g.draw(new Line2D.Double(temp1, temp2));
				temp1 = temp2;
			}
		}
	}

	//��������,����ͨ��zx,zy�Ĵ������ı�ԭ��λ��;
	private void paintAxis(Graphics g){
		g.setColor(Color.CYAN);
		g.drawLine(0, zy, width, zy);
		g.drawLine(zx, 0, zx, height);
		g.drawString("0",zx + 2,zy +12); //��ԭ������
		for(int i = 1; i*unit < width; i++){
			g.drawLine(zx + i*unit, zy - 10, zx + i*unit, zy);//x ����
			g.drawLine(zx - i*unit, zy - 10, zx - i*unit, zy);//x ����
			g.drawString(String.valueOf(i), zx + i*unit -3, zy + 12); // x������
			g.drawString(String.valueOf(i * -1), zx - i*unit -8, zy + 12); // x������

			g.drawLine(zx , zy + i*unit, zx + 10, zy + i*unit);//y ����
			g.drawLine(zx , zy - i*unit, zx + 10, zy - i*unit);//y ����
			g.drawString(String.valueOf(i), zx -12 , zy - i*unit + 5); // y������
			g.drawString(String.valueOf(i * -1), zx -12 , zy + i*unit + 5); // y������
		}
	}

	private double alterX(double x){ //�������Ӧ��ԭ����
		return x + zx;
	}

	private double alterY(double y){ //�������Ӧ��ԭ����
		return -1 *( y - zy);
	}
}