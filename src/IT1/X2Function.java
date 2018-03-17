package IT1;

import javax.swing.*;
import java.awt.*;


public class X2Function extends JFrame
{
	public X2Function()
	{
		add(new X2FunctionPanel());
	}

	public static void main(String[] args)
	{
		X2Function frame=new X2Function();
		frame.setSize(400,250);
		frame.setTitle("»æÖÆy=x2µÄº¯Êý");
		frame.setLocationRelativeTo(null);//center
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class X2FunctionPanel extends JPanel
{
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//»­xÖá
		g.drawLine(20,150,getWidth()-20,150);
		//x¼ýÍ·
		g.drawLine(getWidth()-30,140,getWidth()-20,150);
		g.drawLine(getWidth()-30,160,getWidth()-20,150);
		//¡°x¡±
		g.drawString("X",getWidth()-10,150);


		//»­yÖá
		g.drawLine(200,getHeight()-20,200,20);
		g.drawLine(190,30,200,20);
		g.drawLine(210,30,200,20);
		g.drawString("Y",220,30);


		//»­º¯ÊýÍ¼Ïñ
		Polygon p=new Polygon();
		double scaleFactor=0.01;
		for(int x=-100;x<=100;x++)
		{
			p.addPoint(x+200,150-(int)(scaleFactor*x*x));
		}
		
		g.drawPolyline(p.xpoints,p.ypoints,p.npoints);
	}

	/*public Dimension getPreferredSize()
	{
		return new Dimension(200,200);
	}*/
}