package IT1;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class JPanel extends JComponent {
	protected int width,height,originX,originY;
	protected static int unit=100;//单位长度包含的像素，也可考虑分别设置x，y轴的单位长度像素

	
	public void paintComponent(Graphics g) {
		width=this.getWidth();
		height=this.getHeight();
		/*新坐标系原点的位置*/
		originX=width/2;
		originY=height/2;
		
		g.setColor(Color.BLACK);
		this.paintAxis(g);
		this.paintMethod(g);
	}

	
	/*
	 * 画坐标轴&刻度,可以通过originX,originY的处置来改变原点位置;
	 */
	public void paintAxis(Graphics g){
		g.setColor(Color.BLACK);
		/*drawLine(int x1, int y1, int x2, int y2)  :x1,y1  为起点的坐标,x2,y2  为终点的坐标(原画板中的坐标) */
		g.drawLine(0, originY, width, originY);//x坐标轴
		g.drawLine(originX, 0, originX, height);//y坐标轴
		g.drawString("0",originX + 2,originY +12); //画原点数字
		
		/*
		 * 画刻度
		 * 注意到y方向上，在图形界面上越往下像素越大，但是在坐标系中越往上y坐标越大
		 */
		
		/*从原点开始，x轴上单位刻度为unit像素*/
		for(int i = 1; i*unit <= width/2; i++){
			g.drawLine(originX + i*unit, originY - 10, originX + i*unit, originY);//x 正向刻度线
			g.drawLine(originX - i*unit, originY - 10, originX - i*unit, originY);//x 负向刻度线
			g.drawString(String.valueOf(i), originX + i*unit -3, originY + 12); // x轴刻度数字
			g.drawString(String.valueOf(i * -1), originX - i*unit -8, originY + 12); // x轴刻度数字
		}
		
		
		/*从原点开始，y轴上单位刻度为unit像素*/
		for(int i = 1; i*unit <= height/2; i++){

			g.drawLine(originX , originY + i*unit, originX + 10, originY + i*unit);//y 负向刻度线
			g.drawLine(originX , originY - i*unit, originX + 10, originY - i*unit);//y 正向刻度线
			g.drawString(String.valueOf(i), originX -12 , originY - i*unit + 5); // y轴刻度数字
			g.drawString(String.valueOf(i * -1), originX -12 , originY + i*unit + 5); // y轴刻度数字
		}
	}	
	
	
	/**
	 * 
	 * @param x 建立的坐标系中x坐标值
	 * @return 该坐标值在原画板中的坐标
	 */
	public double alterX(double x){
		return x+originX;
	}
	
	
	/**
	 * 
	 * @param y 建立的坐标系中y坐标值
	 * @return 该坐标值在原画板中的坐标
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
		System.out.println("(6) D(p‖q)(given q)");
		System.out.println("(7) D(p‖q)(given p)");
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
				System.out.printf("设p,q都为二值分布，请给出q的分布s (q(1)=s)\n");
				s=input.nextDouble();
				break;
			case 7:
				System.out.printf("设p,q都为二值分布，请给出p的分布r (p(1)=r)\n");
				r=input.nextDouble();
				break;
			case 8:
				System.out.printf("请使用对应的m脚本文件进行MATLAB绘图");
				break;		
			case 9:
				System.out.printf("请使用对应的m脚本文件进行MATLAB绘图");
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
			
			
			//图像还在坐标系内
			if ( Math.abs(y) < originY){
				temp2 = new Point2D.Double(this.alterX(x * unit), this.alterY(y * unit));	
				g.draw(new Line2D.Double(temp1, temp2));
				temp1 = temp2;
			}
		}
		
	}
	
	
	

}
