package IT2;
import java.io.*;
public class CalcEntropyofData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i;
		float[] p=new float[26]; 
		String text=new String();
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������һ����Ӣ��Сд��ĸ��ɵ��ı���");
		
		
		text=input.readLine();

		for (i=0;i<text.length();i++)
			p[text.charAt(i)-97]++;
		System.out.println("�ı��еķ���Ƶ�ʷֲ�Ϊ��");
		for (i=0;i<26;i++)
			if (p[i]>1e-7) {
				p[i]=p[i]/text.length();
				System.out.printf("%c��%f\n",i+97,p[i]);
			}

		
		
		Entropy En=new Entropy();
		System.out.println("�ı��еķ���Ƶ�ʷֲ��������������H="+En.H(p));
		
	}

}
