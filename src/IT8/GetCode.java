package IT8;

/*生成编码*/
public class GetCode {
	public static int[] genCode(int[] dividend,int[] divisor,int n) {
		//计算X^r*P(X)
		int len = dividend.length;
		int[] dividend2 = new int[len];
		for(int i = 0;i<len;i++) {
			dividend2[i] = dividend[i];
		}
		int[] R = new int[len];
		int[] code = new int[len];
		//计算R(x)
		int[][] R1 = Divide.divide(divisor, dividend);
		for(int i = 0;i<len;i++) {
			R[i] = R1[1][i];
		}
		for(int i = 0;i<len;i++) {
			code[i] = R[i] | dividend2[i];
		}
		return code;
		
		
		
	}

}