package IT9;
import java.io.*;
public class CalcEntropyofData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i;
		float[] p=new float[26]; 
		String text=new String();
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入一段由英文小写字母组成的文本：");
		
		
		text=input.readLine();

		for (i=0;i<text.length();i++)
			p[text.charAt(i)-97]++;
		System.out.println("文本中的符号频率分布为：");
		for (i=0;i<26;i++)
			if (p[i]>1e-7) {
				p[i]=p[i]/text.length();
				System.out.printf("%c：%f\n",i+97,p[i]);
			}

		
		
		Entropy En=new Entropy();
		System.out.println("文本中的符号频率分布的随机变量的熵H="+En.H(p));
		
	}

}
