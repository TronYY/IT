package IT6;

public class ChannelCapacity {
	protected int N,M;
	protected int time;
	protected double C;
	protected double[][] p;
	protected double[] S;
	protected double[] SS;
	
	
	public ChannelCapacity() {
		
	}
	
	
	public ChannelCapacity(int N,int M,double [][] p) {
		this.N=N;
		this.M=M;
		this.p=p;
		S=new double[N];
		SS=new double[N];
	}
	
	public void compute() {
		
		
		/** ��ʼ������ */
		for (int i = 0; i < N; i++)
			S[i] = (double) 1 / N;// ��ֵ

		/** ���� */
		boolean flag = true;
		double[][] phi = new double[M][N];

		while (flag) {
			/** ���ȼ���phi ji */
			for (int j = 0; j < M; j++) {
				double sum = 0;
				for (int i = 0; i < N; i++) {
					sum = sum + S[i] * p[i][j];
				}
				for (int i = 0; i < N; i++)
					phi[j][i] = (S[i] * p[i][j]) / sum;
			}
			/** ��������S */

			// �����ĸ
			double sum1 = 0;
			for (int i = 0; i < N; i++) {
				boolean flag3 = true;
				double sum2 = 0;
				for (int j = 0; j < M; j++) {
					if (phi[j][i] != 0)
						sum2 = sum2
								+ (p[i][j] * (Math.log(phi[j][i]) / Math
										.log(Math.E)));
					else if (phi[j][i] == 0 && p[i][j] != 0) {
						flag3 = false;
					}// exp(log0)=0,��ͬ
					else if (phi[j][i] == 0 && p[i][j] == 0)
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
					if (phi[j][i] != 0)
						sum6 = sum6 + p[i][j]
								* (Math.log(phi[j][i]) / Math.log(Math.E));
					else if (phi[j][i] == 0 && p[i][j] != 0) {
						flag1 = false;
					} else if (phi[j][i] == 0 && p[i][j] == 0)
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
			time++;
		}
		
	}
	
	public void display() {
		System.out.println("����������"+time);
		System.out.print("�����Դ�ֲ���(");
		for (int i = 0; i < N - 1; i++)	System.out.printf("%5.3f, ",S[i]);
		System.out.printf("%5.3f",S[N - 1]);
		System.out.println(")");
		System.out.printf("�ŵ�������%8.3f\n" ,C);
		
	}
	
	
	
}
