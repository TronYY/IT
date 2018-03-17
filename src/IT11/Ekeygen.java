package IT11;

   
    
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;   
import java.security.*;   

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
   
public class Ekeygen {   
  
    static ElGamalEncryption encrypt;   
    static ElGamalKeyPairGenerator ekpg;   
    static KeyPair epair;   
       
    public static void main(String[] args){
    	JFrame jiami=new JFrame();
    	final ElGamalPrivateKey eprik;   
        final ElGamalPublicKey epubk;   
        ekpg = new ElGamalKeyPairGenerator();   
        ekpg.initialize(16, new SecureRandom());   
        epair = ekpg.generateKeyPair();   
           
        eprik = (ElGamalPrivateKey) epair.getPrivate();   
        epubk = (ElGamalPublicKey) epair.getPublic();   
           
           
        System.out.println("Private Key: k = " + eprik.getK() );   
        System.out.println("Public Key: y = " + epubk.getY() + ", g = " + epubk.getG() + ", p = " + epubk.getP());   
           
       /* try   
        {   
               
           
            String str = "45678";   
               
            
            System.out.println("Message : " + str);   
             
           
               
            
               
            System.out.println();   
               
                       
            BigInteger C;   
            //encrypt.engineInitDecrypt(eprik);   
             
             
               
            
           
           
           
        }   */
        //catch(InvalidKeyException ike)   
        //{   
           // System.out.println("Invalid Key!");   
        //}   
       
  
    	jiami.setSize(500, 500);
    	final JTextField xianshi=new JTextField();
    	xianshi.setBounds(20, 222, 333, 25);
    	jiami.setLayout(null);
    	jiami.add(xianshi);
    	final JTextField elgam=new JTextField();
    	elgam.setBounds(20, 18, 333, 25);
    	jiami.setLayout(null);
    	jiami.add(elgam);
    	final JTextField elga1=new JTextField();
    	elga1.setBounds(20, 155, 100, 25);
    	jiami.setLayout(null);
    	jiami.add(elga1);
    	final JTextField elga2=new JTextField();
    	elga2.setBounds(180, 155, 100, 25);
    	jiami.setLayout(null);
    	jiami.add(elga2);
    	JButton an=new JButton();
    	an.setBounds(22, 52, 88, 33);
    	an.setText("º”√‹");
    	an.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    		String ssa=elgam.getText();
    		encrypt = new ElGamalEncryption();   
            try {
				encrypt.engineInitEncrypt(epubk);
			} catch (InvalidKeyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
    		System.out.println(ssa);
            BigInteger msg_num = new BigInteger(ssa);   
               
            BigInteger[] encryptedmsg = encrypt.engineEncrypt(msg_num);   
            xianshi.setText("Encrpyted Message: " + encryptedmsg[0] + "," + encryptedmsg[1]);
    		}
    	});
    	jiami.add(an);
    	JButton an2=new JButton();
    	an2.setBounds(111, 52, 88, 33);
    	an2.setText("Ω‚√‹");
    	jiami.add(an2);
    	an2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
           
            String ss1=elga1.getText();
            String ss2=elga2.getText();
    		
    		encrypt = new ElGamalEncryption();   
            try {
				encrypt.engineInitDecrypt(eprik);
			} catch (InvalidKeyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
    	    
			
			BigInteger encryptedmsg = new BigInteger(ss1);	
			BigInteger encryptedmsg1 = new BigInteger(ss2);
			BigInteger[] enmsg = new BigInteger[2];
		    enmsg[0]=encryptedmsg;
		    enmsg[1]=encryptedmsg1;
    			      
            BigInteger decryptedmsg = encrypt.engineDecrypt(enmsg);   
            xianshi.setText("Decrypted Message: " +decryptedmsg);
    		}
    	});
    	
    	
    	
    	
    	jiami.setVisible(true);
        
} 
}