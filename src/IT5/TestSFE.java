package IT5;

import java.io.*;
import java.util.Scanner;



public class TestSFE {


	//测试类
	public static void main(String[] args) throws IOException{
		int i;
		float[] p; 
		Scanner input=new Scanner(System.in);
		System.out.print("请输入x的取值个数m：");
		int m=input.nextInt();
		
		p=new float[m+1];
		System.out.println("请输入对应概率分布P(X)");
		for (i=1;i<=m;i++)
				p[i]=input.nextFloat();
		
		SFE S=new SFE(m);
		S.setSfe(p);
		S.display();
	}

}
