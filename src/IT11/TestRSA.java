package IT11;

import java.security.interfaces.RSAPrivateKey;  
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Scanner;  

public class TestRSA  {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String, Object> map = RSA.getKeys();
		//���ɹ�Կ��˽Կ
		RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
		RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
		
		//ģ
		String modulus = publicKey.getModulus().toString();
		//��Կָ��
		String public_exponent = publicKey.getPublicExponent().toString();
		//˽Կָ��
		String private_exponent = privateKey.getPrivateExponent().toString();
		
		//ʹ��ģ��ָ�����ɹ�Կ��˽Կ
		RSAPublicKey pubKey = RSA.getPublicKey(modulus, public_exponent);
		RSAPrivateKey priKey = RSA.getPrivateKey(modulus, private_exponent);
		
		
		
		System.out.println("����������:");
    	Scanner input=new Scanner(System.in);
    	String message=input.next();
    	
        System.out.println("ԭ��: " + message);
        System.out.println("������Ϣ��Ϊ��  "+ ENTROPY.entropy(message));
        
       
      
        
        //���ܺ������
      	String encryptData = RSA.encryptByPublicKey(message, pubKey);
        System.out.println("���ܺ�: " + encryptData);
        System.out.println("������Ϣ��Ϊ��  "+ ENTROPY.entropy(encryptData));
        
        System.out.println("���������ģ�");
        
        String newEncryptData=input.next();

        String decryptData = RSA.decryptByPrivateKey(newEncryptData, priKey);
        System.out.println("���ܺ�: " + decryptData);
		
		
	}
}