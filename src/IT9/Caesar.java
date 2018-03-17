package IT9;

import java.io.*;
public class Caesar {
	public static final int ALPHASIZE=26;
	public static final char[] alpha={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	protected char[] encrypt=new char[ALPHASIZE];//加密数组；
	protected char[] decrypt=new char[ALPHASIZE];//解密数组
	
	public Caesar(){
		for (int i=0;i<ALPHASIZE;i++) encrypt[i]=alpha[(i+3)%ALPHASIZE];
		for (int i=0;i<ALPHASIZE;i++) decrypt[encrypt[i]-'a']=alpha[i];
	}
	
	public String encrypt(String secret){
		char[] mess=secret.toCharArray();
		for (int i=0;i<mess.length;i++)
			if ((mess[i]>='a')&&(mess[i]<='z'))
				mess[i]=encrypt[mess[i]-'a'];
		return new String(mess);
	}
	
	public String decrypt(String secret){
		char[] mess=secret.toCharArray();
		for (int i=0;i<mess.length;i++)
			if ((mess[i]>='a')&&(mess[i]<='z'))
				mess[i]=decrypt[mess[i]-'a'];
		return new String(mess);	
	}
	public static void main(String[] args) throws IOException{
		Caesar cipher=new Caesar();
		System.out.println("Encryption order="+new String(cipher.encrypt));
		System.out.println("Decryption order="+new String(cipher.decrypt));
		
		String secret=new String();
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("请输入一段小写英文文本：");
		secret=input.readLine();
		
		secret=cipher.encrypt(secret);
		System.out.println("加密后："+secret);
		secret=cipher.decrypt(secret);
		System.out.println("解密后："+secret);
	}
}
										