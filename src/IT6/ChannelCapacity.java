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
		
		
		/** 初始化数据 */
		for (int i = 0; i < N; i++)
			S[i] = (double) 1 / N;// 赋值

		/** 迭代 */
		boolean flag = true;
		double[][] phi = new double[M][N];

		while (flag) {
			/** 首先计算phi ji */
			for (int j = 0; j < M; j++) {
				double sum = 0;
				for (int i = 0; i < N; i++) {
					sum = sum + S[i] * p[i][j];
				}
				for (int i = 0; i < N; i++)
					phi[j][i] = (S[i] * p[i][j]) / sum;
			}
			/** 迭代计算S */

			// 计算分母
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
					}// exp(log0)=0,下同
					else if (phi[j][i] == 0 && p[i][j] == 0)
						sum2 = sum2 + 0;// 0log0=0
				}

				if (flag3)
					sum1 = sum1 + Math.exp(sum2);
				else
					sum1 = sum1 + 0;
			}

			/** 计算SS[i] */

			for (int i = 0; i < N; i++) {
				boolean flag1 = true;// 若有无穷比无穷
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
				distance = distance + Math.pow(SS[i] - S[i], 2);// 计算范数
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
		System.out.println("迭代次数："+time);
		System.out.print("最佳信源分布：(");
		for (int i = 0; i < N - 1; i++)	System.out.printf("%5.3f, ",S[i]);
		System.out.printf("%5.3f",S[N - 1]);
		System.out.println(")");
		System.out.printf("信道容量：%8.3f\n" ,C);
		
	}
	
	
	
}
