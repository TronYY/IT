package IT8;


import java.lang.reflect.Field;
import java.util.Arrays;

public class Divide {

	public static int[][] divide(int[] divisor, int[] dividend) {
		int len = dividend.length;
		int[] divisor2 = new int[len];
		int[][] result = new int[2][len];
		
		for(int i = 0;i<len;i++) {
			divisor2[i] = divisor[i];
		}
		
		int[] factor= new int[len];
		int[] remainder = new int[len];
		
		// 初始商为0
		for (int i = 0; i < len; i++) {
			factor[i] = 0;
		}
		
		for(;;){
			int flag1 = 0, flag2 = 0;
			if (Arrays.equals(dividend, divisor2)) {
				factor[0] = 1;
				for(int i = 0;i<len;i++) {
					remainder[i] = 0;
				}
				break;
			}
			else {
				System.out.println();
				System.out.println("除法开始");
				
				// 找出右边第一个不为1的下标
				for(int i = 0;i<len;i++) {
					divisor[i] = divisor2[i];
				}
				for (int j = len - 1; j >= 0; j--) {
					if (dividend[j] == 1) {
						flag1 = j;
						break;
					}
				}
				for (int j = len - 1; j >= 0; j--) {
					if (divisor[j] == 1) {
						flag2 = j;
						break;
					}
				}

				if (flag1 > flag2) {
					int re = flag1 - flag2;
					factor[re] = 1;
					divisor = Moving.move(divisor, re);
					
					for (int k = 0; k < len; k++) {
						dividend[k] = dividend[k] ^ divisor[k];
					}
				}
				for(int i = 0;i<len;i++) {
					remainder[i] = dividend[i];
				}

				if(flag1 == flag2) {
					factor[0] = 1;
					if(flag1 == flag2 &&  Arrays.equals(dividend, divisor2)) {
						factor[0] = 1;
						for(int i = 0;i<len;i++) {
							remainder[i] = 0;
						}
						break;
					}
					break;
				}
				
				if(flag1<flag2) {
					break;
				}
			}
		}
		for(int i = 0;i<len;i++) {
			result[0][i] = factor[i];
		}
		for(int i = 0;i<len;i++) {
			result[1][i] = remainder[i];
		}
		System.out.println("商和余数为：");
		for(int i = 0;i<len;i++) {
			System.out.print(result[0][i]+" ");
		}
		System.out.print("\n");
		
		for(int i = 0;i<len;i++) {
			System.out.print(result[1][i]+" ");
		}
		System.out.print("\n");
		
		
	
		return result;
	}

}