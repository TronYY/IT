package IT2;
import java.util.Scanner;
public class TestEntropy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j;
		float[][] p; 
		Scanner input=new Scanner(System.in);
		System.out.print("������Y��ȡֵ����m��");
		int m=input.nextInt();
		System.out.print("������X��ȡֵ����n��");
		int n=input.nextInt();
		
		p=new float[m][n];
		System.out.println("�������ά�ֲ�p(y,x)");
		for (i=0;i<m;i++)
			for (j=0;j<m;j++)
				p[i][j]=input.nextFloat();
		
		Entropy En=new Entropy(m,n,p);
		System.out.println("X����H(X)="+En.HX());
		System.out.println("Y����H(Y)="+En.HY());
		System.out.println("������H(X|Y)="+En.HX_Y());
		System.out.println("������H(Y|X)="+En.HY_X());
		System.out.println("������H(X,Y)="+En.HXY());
		System.out.println("����ϢI(X,Y)="+En.IXY());
		
	}

}
