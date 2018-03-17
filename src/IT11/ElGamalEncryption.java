package IT11;

import java.math.BigInteger;   
import java.security.*;   
   
public class ElGamalEncryption{   
       
    protected ElGamalKey mKey;   
       
    protected static BigInteger kOne = BigInteger.valueOf(1);   
       
    protected void engineInitEncrypt(PublicKey key) throws InvalidKeyException {   
    if (!(key instanceof ElGamalPublicKey)) throw new InvalidKeyException("Invalid ElGamalPublicKey.");   
    mKey = (ElGamalKey)key;   
    }   
       
    protected void engineInitDecrypt(PrivateKey key) throws InvalidKeyException {   
    if (!(key instanceof ElGamalPrivateKey)) throw new InvalidKeyException("Invalid ElGamalPrivateKey.");   
    mKey = (ElGamalKey)key;   
    }   
       
    protected BigInteger[] engineEncrypt(BigInteger M){   
    BigInteger y = ((ElGamalPublicKey)mKey).getY();   
    BigInteger g = mKey.getG();   
    BigInteger p = mKey.getP();   
   
    BigInteger k;   
    do {   
      k = new BigInteger(p.bitLength() - 1, new SecureRandom());   
    } while (k.gcd(p).equals(kOne) == false);   
       
    BigInteger a = g.modPow(k, p);   
       
    BigInteger temp = y.modPow(k, p);   
    BigInteger C = (M.multiply(temp)).mod(p);   
    BigInteger[] result = new BigInteger[2];   
    result[0] = a;   
    result[1] = C;   
       
    return result;   
  }   
     
protected BigInteger engineDecrypt(BigInteger[] result){   
    BigInteger k = ((ElGamalPrivateKey)mKey).getK();   
    BigInteger p = mKey.getP();   
       
    BigInteger a = result[0];   
    BigInteger C = result[1];   
    BigInteger temp = a.modPow(k, p).modInverse(p);   
       
       
    return C.multiply(temp).mod(p);   
  }


}

