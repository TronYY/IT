package IT2;
import java.util.Scanner;
public class TestEntropy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j;
		float[][] p; 
		Scanner input=new Scanner(System.in);
		System.out.print("请输入Y的取值个数m：");
		int m=input.nextInt();
		System.out.print("请输入X的取值个数n：");
		int n=input.nextInt();
		
		p=new float[m][n];
		System.out.println("请输入二维分布p(y,x)");
		for (i=0;i<m;i++)
			for (j=0;j<m;j++)
				p[i][j]=input.nextFloat();
		
		Entropy En=new Entropy(m,n,p);
		System.out.println("X的熵H(X)="+En.HX());
		System.out.println("Y的熵H(Y)="+En.HY());
		System.out.println("条件熵H(X|Y)="+En.HX_Y());
		System.out.println("条件熵H(Y|X)="+En.HY_X());
		System.out.println("联合熵H(X,Y)="+En.HXY());
		System.out.println("互信息I(X,Y)="+En.IXY());
		
	}

}
