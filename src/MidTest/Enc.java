package MidTest;
import java.io.*;//������java�����������İ�
import java.util.Scanner;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;



/**
 * 
 * @author ����
 * 
 */
public class Enc {

	public static void main(String[] args) throws Exception{
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String message=new String();
		String MyEncCompData=new String();
		System.out.println("������Ҫ���ܵ�����:");
		message=input.readLine();
        /*��������*/
        byte[] encryptResult = encrypt(message, "12345678"); //����password,�ڶ��������Ǽ�����Կ
		String encryptResultStr = parseByte2HexStr(encryptResult); //�����ܺ������ת��Ϊ�ַ����������.���ǲ���ǿ��ת������Ҫ���������ֽ�����ת��Ϊʮ�������ַ��� 
		
		MyEncCompData=encryptResultStr;
		System.out.println("���ܵĽ����"+encryptResultStr);
		
	}
	
	
	
	/**��������ת����16���� 
	 * @param buf 
	 * @return 
	 */  
	public static String parseByte2HexStr(byte buf[]) {  
	        StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < buf.length; i++) {  
	                String hex = Integer.toHexString(buf[i] & 0xFF);  
	                if (hex.length() == 1) {  
	                        hex = '0' + hex;  
	                }  
	                sb.append(hex.toUpperCase());  
	        }  
	        return sb.toString();  
	}  
	
	
	
	
	
	/** 
	 * ���� 
	 *  
	 * @param content ��Ҫ���ܵ����� 
	 * @param password  ������Կ 
	 * @return 
	 */  
	public static byte[] encrypt(String content, String password) {  
	        try {             
	                KeyGenerator kgen = KeyGenerator.getInstance("AES");  
	                kgen.init(128, new SecureRandom(password.getBytes()));  
	                SecretKey secretKey = kgen.generateKey();  
	                byte[] enCodeFormat = secretKey.getEncoded();  
	                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
	                Cipher cipher = Cipher.getInstance("AES");// ����������  
	                byte[] byteContent = content.getBytes("utf-8");  
	                cipher.init(Cipher.ENCRYPT_MODE, key);// ��ʼ��  
	                byte[] result = cipher.doFinal(byteContent);  
	                return result; // ����  
	        } catch (NoSuchAlgorithmException e) {  
	                e.printStackTrace();  
	        } catch (NoSuchPaddingException e) {  
	                e.printStackTrace();  
	        } catch (InvalidKeyException e) {  
	                e.printStackTrace();  
	        } catch (UnsupportedEncodingException e) {  
	                e.printStackTrace();  
	        } catch (IllegalBlockSizeException e) {  
	                e.printStackTrace();  
	        } catch (BadPaddingException e) {  
	                e.printStackTrace();  
	        }  
	        return null;  
	}  
}
