package IT4;

import java.io.*;

public class Test {


	//������
	public static void main(String[] args) throws IOException{
		String message=new String();
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("������һ���ı���");
		message=input.readLine();
		
        HuffmanEncoder encoder = new HuffmanEncoder();
        String code =encoder.encode(message);
       
        encoder.printCodeSet();
        System.out.print("��������");
        System.out.println(code);
       
        HuffmanDecoder decoder = new HuffmanDecoder(encoder.getCodeSet());
        String message2 =decoder.decode(code);
        System.out.print("��������");
        System.out.println(message);
	      }

}
