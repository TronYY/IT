package IT11;

   
import java.math.BigInteger;   
import java.security.*;   
   
public class ElGamalPrivateKey extends ElGamalKey implements PrivateKey {   
       
     private BigInteger mK;   
     
     protected ElGamalPrivateKey(BigInteger k, BigInteger g, BigInteger p) {   
     super(g, p);   
      mK = k;   
     }   
     protected BigInteger getK() { return mK; }   
        
     public String toString()   
     {   
        return  mK + ":" + getG() + ":" + getP();   
     }   
} 