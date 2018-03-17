package IT4;

import java.io.*;

public class Test {


	//测试类
	public static void main(String[] args) throws IOException{
		String message=new String();
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("请输入一段文本：");
		message=input.readLine();
		
        HuffmanEncoder encoder = new HuffmanEncoder();
        String code =encoder.encode(message);
       
        encoder.printCodeSet();
        System.out.print("编码结果：");
        System.out.println(code);
       
        HuffmanDecoder decoder = new HuffmanDecoder(encoder.getCodeSet());
        String message2 =decoder.decode(code);
        System.out.print("解码结果：");
        System.out.println(message);
	      }

}
