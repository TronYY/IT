package IT6;
import java.util.Scanner;

public class TestChannelCapacity {
	public static int N;
	public static int M;
	public static double C;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("������Դ���Ÿ���n��");
		int n= input.nextInt();
		System.out.println("�������޷��Ÿ���m��");
		int m= input.nextInt();
		
		System.out.println("�������ŵ�ת�Ƹ��ʾ���");
		double[][] p = new double[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				p[i][j] = input.nextFloat();
			}
		ChannelCapacity CC=new ChannelCapacity(n,m,p);
		CC.compute();
		CC.display();

		
		
		
	}
}
