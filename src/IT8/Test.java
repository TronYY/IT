package IT8;

import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���롰1�����б���,���롰0�����н���");
		int temp = sc.nextInt();
		sc.reset();
		System.out.println("���������ɶ���ʽ�Ľ�����");
		int k = sc.nextInt();
		sc.reset();
		System.out.println("���������ɶ���ʽ");
		int[] gener = new int[k+1];
		for(int i = 0;i<k+1;i++) {
			gener[i] = sc.nextInt();
		}
		if(temp == 1) {
			//��Ϣ����ʽinfo
			sc.reset();
			System.out.println("��������Ϣ����ʽ�Ľ�����");
			int d = sc.nextInt();
			sc.reset();
			System.out.println("���������ɶ���ʽ");
			int[] info = new int[d+1];
			for(int i = 0;i<d+1;i++) {
				info[i] = sc.nextInt();
			}
			
			int len = gener.length;
			int len1 = info.length;
			//����x^r*m(x),m(x)Ϊ��Ϣ����ʽ
			int[] t = Complement.Generate(info, len);
			for(int i = 0;i<t.length;i++) {
				System.out.print( t[i]+ " ");
			}
			Moving.move(t, len-1);
			//�������ɶ���ʽ
			int [] divisor = CreatePol.genDivisor(gener, len1-1);
			System.out.println("*********");
			for(int i = 0;i<divisor.length;i++) {
				System.out.print(divisor[i]);
			}
			
			System.out.println("+++++++++++++");
			for(int i = 0;i<divisor.length;i++) {
				System.out.print(t[i]);
			}
			//����ѭ����
			int[] code  = GetCode.genCode(t, divisor, len);
			for(int i = 0;i<t.length;i++) {
				System.out.print( code[i]+ " ");
			}
			
		}
		if(temp == 0) {
			sc.reset();
			System.out.println("���������ֳ��ȣ�");
			int L = sc.nextInt();
			sc.reset();
			System.out.println("���������֣�");
			int[] codeword = new int[L];
			for(int i = 0;i<L;i++) {
				codeword[i] = sc.nextInt();
			}
			//�������ɶ���ʽʹ������������ͬ����
			int codeLen = codeword.length;
			int[] gener2 = Complement.Generate(gener, codeLen-k);
			System.out.println("======");
			for(int i = 0;i<gener2.length;i++) {
				System.out.print(gener2[i]);
			}
			
			
			GetCode CRCdecode=new GetCode();
			int[] word = CRCdecode.genCode(codeword, gener2, k);
			System.out.println("���������");
			for(int i = 0;i<word.length;i++) {
				System.out.print(word[i]);
			}
		}
	}
}