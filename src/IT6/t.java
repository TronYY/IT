package IT6;
import java.util.Scanner;

public class t {
	public static int N;
	public static int M;
	public static double C;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("����״̬ת�ƾ����������M��N��");
		int cishu = 0;// ��������
		N = input.nextInt();
		M = input.nextInt();
		double[][] p = new double[N][M];
		double[] S = new double[N];
		double[] SS = new double[N];// �������������S
		System.out.println("����״̬ת�ƾ���");
		/** ����ת�ƾ��� */
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				p[i][j] = input.nextDouble();
			}
		/** ��ʼ������ */
		for (int i = 0; i < N; i++)
			S[i] = (double) 1 / N;// ��ֵ

		/** ���� */
		boolean flag = true;
		double[][] fa = new double[M][N];

		while (flag) {
			/** ���ȼ���fa ji */
			for (int j = 0; j < M; j++) {
				double sum = 0;
				for (int i = 0; i < N; i++) {
					sum = sum + S[i] * p[i][j];
				}
				for (int i = 0; i < N; i++)
					fa[j][i] = (S[i] * p[i][j]) / sum;
			}
			/** ��������S */

			// �����ĸ
			double sum1 = 0;
			for (int i = 0; i < N; i++) {
				boolean flag3 = true;
				double sum2 = 0;
				for (int j = 0; j < M; j++) {
					if (fa[j][i] != 0)
						sum2 = sum2
								+ (p[i][j] * (Math.log(fa[j][i]) / Math
										.log(Math.E)));
					else if (fa[j][i] == 0 && p[i][j] != 0) {
						flag3 = false;
					}// exp(log0)=0,��ͬ
					else if (fa[j][i] == 0 && p[i][j] == 0)
						sum2 = sum2 + 0;// 0log0=0
				}

				if (flag3)
					sum1 = sum1 + Math.exp(sum2);
				else
					sum1 = sum1 + 0;
			}

			/** ����SS[i] */

			for (int i = 0; i < N; i++) {
				boolean flag1 = true;// �������������
				double sum6 = 0;
				for (int j = 0; j < M; j++) {
					if (fa[j][i] != 0)
						sum6 = sum6 + p[i][j]
								* (Math.log(fa[j][i]) / Math.log(Math.E));
					else if (fa[j][i] == 0 && p[i][j] != 0) {
						flag1 = false;
					} else if (fa[j][i] == 0 && p[i][j] == 0)
						sum6 = sum6 + 0;
				}
				if (flag1)
					SS[i] = Math.exp(sum6) / sum1;
				else
					SS[i] = 0;
			}
			double distance = 0;
			for (int i = 0; i < N; i++) {
				distance = distance + Math.pow(SS[i] - S[i], 2);// ���㷶��
			}
			if (distance < 0.00001)
				flag = false;
			else {
				for (int i = 0; i < N; i++)
					S[i] = SS[i];
			}
			C = Math.log(sum1) / Math.log(2);
			cishu++;
		}
		System.out.println("����" + cishu + "�ε�������õ�������£�");
		System.out.print("�������Դ�ֲ�Ϊ��(");
		for (int i = 0; i < N - 1; i++)
			System.out.print(S[i] + ",");
		System.out.print(S[N - 1]);
		System.out.println(")");
		System.out.println("���ŵ�����Ϊ��" + C);
	}
}
