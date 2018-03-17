package IT1;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class JPanel extends JComponent {
	protected int width,height,originX,originY;
	protected static int unit=100;//��λ���Ȱ��������أ�Ҳ�ɿ��Ƿֱ�����x��y��ĵ�λ��������

	
	public void paintComponent(Graphics g) {
		width=this.getWidth();
		height=this.getHeight();
		/*������ϵԭ���λ��*/
		originX=width/2;
		originY=height/2;
		
		g.setColor(Color.BLACK);
		this.paintAxis(g);
		this.paintMethod(g);
	}

	
	/*
	 * ��������&�̶�,����ͨ��originX,originY�Ĵ������ı�ԭ��λ��;
	 */
	public void paintAxis(Graphics g){
		g.setColor(Color.BLACK);
		/*drawLine(int x1, int y1, int x2, int y2)  :x1,y1  Ϊ��������,x2,y2  Ϊ�յ������(ԭ�����е�����) */
		g.drawLine(0, originY, width, originY);//x������
		g.drawLine(originX, 0, originX, height);//y������
		g.drawString("0",originX + 2,originY +12); //��ԭ������
		
		/*
		 * ���̶�
		 * ע�⵽y�����ϣ���ͼ�ν�����Խ��������Խ�󣬵���������ϵ��Խ����y����Խ��
		 */
		
		/*��ԭ�㿪ʼ��x���ϵ�λ�̶�Ϊunit����*/
		for(int i = 1; i*unit <= width/2; i++){
			g.drawLine(originX + i*unit, originY - 10, originX + i*unit, originY);//x ����̶���
			g.drawLine(originX - i*unit, originY - 10, originX - i*unit, originY);//x ����̶���
			g.drawString(String.valueOf(i), originX + i*unit -3, originY + 12); // x��̶�����
			g.drawString(String.valueOf(i * -1), originX - i*unit -8, originY + 12); // x��̶�����
		}
		
		
		/*��ԭ�㿪ʼ��y���ϵ�λ�̶�Ϊunit����*/
		for(int i = 1; i*unit <= height/2; i++){

			g.drawLine(originX , originY + i*unit, originX + 10, originY + i*unit);//y ����̶���
			g.drawLine(originX , originY - i*unit, originX + 10, originY - i*unit);//y ����̶���
			g.drawString(String.valueOf(i), originX -12 , originY - i*unit + 5); // y��̶�����
			g.drawString(String.valueOf(i * -1), originX -12 , originY + i*unit + 5); // y��̶�����
		}
	}	
	
	
	/**
	 * 
	 * @param x ����������ϵ��x����ֵ
	 * @return ������ֵ��ԭ�����е�����
	 */
	public double alterX(double x){
		return x+originX;
	}
	
	
	/**
	 * 
	 * @param y ����������ϵ��y����ֵ
	 * @return ������ֵ��ԭ�����е�����
	 */
	public double alterY(double y) {
		return -1*(y-originY);
	}
	
	
	public double log(double value, double base) {
		return Math.log(value) / Math.log(base);
	}
	
	public void paintMethod(Graphics g1) {
		int option=0;
		double s=0,r=0;
		
		//System.out.println(width);
		//System.out.println(height);
		System.out.println("(1) y=lnx");
		System.out.println("(2) y=lnx-x+1");
		System.out.println("(3) y=xlnx");
		System.out.println("(4) y=ln(x)/x");
		System.out.println("(5) y=H(x)=-xlnx-(1-x)ln(1-x)");
		System.out.println("(6) D(p��q)(given q)");
		System.out.println("(7) D(p��q)(given p)");
		System.out.println("(8) I(X;Y)(given p(y|x))");
		System.out.println("(9) I(X;Y)(given p(x))");
		System.out.println("Please choose a funtion to draw:");
		
		Scanner input=new Scanner(System.in);
		option=input.nextInt();
		
		if (option<1 || option>9) {
			System.out.printf("Input error.\n");
			System.exit(0);
		}
		switch (option){
			case 6:
				System.out.printf("��p,q��Ϊ��ֵ�ֲ��������q�ķֲ�s (q(1)=s)\n");
				s=input.nextDouble();
				break;
			case 7:
				System.out.printf("��p,q��Ϊ��ֵ�ֲ��������p�ķֲ�r (p(1)=r)\n");
				r=input.nextDouble();
				break;
			case 8:
				System.out.printf("��ʹ�ö�Ӧ��m�ű��ļ�����MATLAB��ͼ");
				break;		
			case 9:
				System.out.printf("��ʹ�ö�Ӧ��m�ű��ļ�����MATLAB��ͼ");
				break;
		}
		
		
		
		Point2D temp1,temp2;
		double x = 0,y=0;
		Graphics2D g = (Graphics2D)g1;
		g.setColor(Color.BLUE);

		
		
		
		
		
		temp1 = new Point2D.Double(this.alterX(x * unit), this.alterY(y * unit));
		for(int i = 1 ; i <= width/2; i++){
			x += 1.0/unit;
			y = 0 ;
			switch (option) {
				case 1:y=Math.log(x);break;
				case 2:y=Math.log(x)-x+1;break;
				case 3:y=x*Math.log(x);break;
				case 4:y=Math.log(x)/x;break;
				case 5:y=-x*Math.log(x)-(1-x)*Math.log(1-x);break;
				case 6:
					if (x<0 || x>1) continue;
					else y=(1-x)*log((1-x)/(1-s),2)+x*log(x/s,2);
					break;
				case 7:
					if (x<0 || x>1) continue;
					else y=(1-r)*log((1-r)/(1-x),2)+r*log(r/x,2);
					break;
				
				
			}
			
			
			//ͼ��������ϵ��
			if ( Math.abs(y) < originY){
				temp2 = new Point2D.Double(this.alterX(x * unit), this.alterY(y * unit));	
				g.draw(new Line2D.Double(temp1, temp2));
				temp1 = temp2;
			}
		}
		
	}
	
	
	

}
