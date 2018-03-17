package MidTest;
import java.io.*;//包含了java输入和输出流的包
import java.util.Scanner;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;



/**
 * 
 * @author 金洋
 * 
 */
public class Enc {

	public static void main(String[] args) throws Exception{
		
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String message=new String();
		String MyEncCompData=new String();
		System.out.println("请输入要加密的数据:");
		message=input.readLine();
        /*加密数据*/
        byte[] encryptResult = encrypt(message, "12345678"); //加密password,第二个参数是加密密钥
		String encryptResultStr = parseByte2HexStr(encryptResult); //将加密后的数组转化为字符串便于输出.但是不能强制转换，需要将二进制字节数组转化为十六进制字符串 
		
		MyEncCompData=encryptResultStr;
		System.out.println("加密的结果："+encryptResultStr);
		
	}
	
	
	
	/**将二进制转换成16进制 
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
	 * 加密 
	 *  
	 * @param content 需要加密的内容 
	 * @param password  加密密钥 
	 * @return 
	 */  
	public static byte[] encrypt(String content, String password) {  
	        try {             
	                KeyGenerator kgen = KeyGenerator.getInstance("AES");  
	                kgen.init(128, new SecureRandom(password.getBytes()));  
	                SecretKey secretKey = kgen.generateKey();  
	                byte[] enCodeFormat = secretKey.getEncoded();  
	                SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
	                Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
	                byte[] byteContent = content.getBytes("utf-8");  
	                cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化  
	                byte[] result = cipher.doFinal(byteContent);  
	                return result; // 加密  
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
