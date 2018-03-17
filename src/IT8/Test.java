package IT8;

import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入“1”进行编码,输入“0”进行解码");
		int temp = sc.nextInt();
		sc.reset();
		System.out.println("请输入生成多项式的阶数：");
		int k = sc.nextInt();
		sc.reset();
		System.out.println("请输入生成多项式");
		int[] gener = new int[k+1];
		for(int i = 0;i<k+1;i++) {
			gener[i] = sc.nextInt();
		}
		if(temp == 1) {
			//信息多项式info
			sc.reset();
			System.out.println("请输入信息多项式的阶数：");
			int d = sc.nextInt();
			sc.reset();
			System.out.println("请输入生成多项式");
			int[] info = new int[d+1];
			for(int i = 0;i<d+1;i++) {
				info[i] = sc.nextInt();
			}
			
			int len = gener.length;
			int len1 = info.length;
			//计算x^r*m(x),m(x)为信息多项式
			int[] t = Complement.Generate(info, len);
			for(int i = 0;i<t.length;i++) {
				System.out.print( t[i]+ " ");
			}
			Moving.move(t, len-1);
			//处理生成多项式
			int [] divisor = CreatePol.genDivisor(gener, len1-1);
			System.out.println("*********");
			for(int i = 0;i<divisor.length;i++) {
				System.out.print(divisor[i]);
			}
			
			System.out.println("+++++++++++++");
			for(int i = 0;i<divisor.length;i++) {
				System.out.print(t[i]);
			}
			//生成循环码
			int[] code  = GetCode.genCode(t, divisor, len);
			for(int i = 0;i<t.length;i++) {
				System.out.print( code[i]+ " ");
			}
			
		}
		if(temp == 0) {
			sc.reset();
			System.out.println("请输入码字长度：");
			int L = sc.nextInt();
			sc.reset();
			System.out.println("请输入码字：");
			int[] codeword = new int[L];
			for(int i = 0;i<L;i++) {
				codeword[i] = sc.nextInt();
			}
			//处理生成多项式使得与码字有相同长度
			int codeLen = codeword.length;
			int[] gener2 = Complement.Generate(gener, codeLen-k);
			System.out.println("======");
			for(int i = 0;i<gener2.length;i++) {
				System.out.print(gener2[i]);
			}
			
			
			GetCode CRCdecode=new GetCode();
			int[] word = CRCdecode.genCode(codeword, gener2, k);
			System.out.println("输出解码结果");
			for(int i = 0;i<word.length;i++) {
				System.out.print(word[i]);
			}
		}
	}
}