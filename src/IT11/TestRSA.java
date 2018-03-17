package IT11;

import java.security.interfaces.RSAPrivateKey;  
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Scanner;  

public class TestRSA  {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = RSA.getKeys();
		//生成公钥和私钥
		RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
		RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
		
		//模
		String modulus = publicKey.getModulus().toString();
		//公钥指数
		String public_exponent = publicKey.getPublicExponent().toString();
		//私钥指数
		String private_exponent = privateKey.getPrivateExponent().toString();
		
		//使用模和指数生成公钥和私钥
		RSAPublicKey pubKey = RSA.getPublicKey(modulus, public_exponent);
		RSAPrivateKey priKey = RSA.getPrivateKey(modulus, private_exponent);
		
		
		
		System.out.println("请输入明文:");
    	Scanner input=new Scanner(System.in);
    	String message=input.next();
    	
        System.out.println("原文: " + message);
        System.out.println("明文信息熵为：  "+ ENTROPY.entropy(message));
        
       
      
        
        //加密后的密文
      	String encryptData = RSA.encryptByPublicKey(message, pubKey);
        System.out.println("加密后: " + encryptData);
        System.out.println("密文信息熵为：  "+ ENTROPY.entropy(encryptData));
        
        System.out.println("请输入密文：");
        
        String newEncryptData=input.next();

        String decryptData = RSA.decryptByPrivateKey(newEncryptData, priKey);
        System.out.println("解密后: " + decryptData);
		
		
	}
}