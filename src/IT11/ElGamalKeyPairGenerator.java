package IT11;

   
import java.math.BigInteger;   
import java.security.*;   
   
public class ElGamalKeyPairGenerator extends KeyPairGeneratorSpi {   
  private int mStrength = 0;   
  private SecureRandom mSecureRandom = null;   
     
  public void initialize(int strength, SecureRandom random) {   
    mStrength = strength;   
    mSecureRandom = random;   
  }   
     
  public KeyPair generateKeyPair() {   
    if (mSecureRandom == null) {   
      mStrength = 1024;   
      mSecureRandom = new SecureRandom();   
    }   
    BigInteger p = new BigInteger(mStrength, 16, mSecureRandom);   
    BigInteger g = new BigInteger(mStrength - 1, mSecureRandom);   
    BigInteger k = new BigInteger(mStrength - 1, mSecureRandom);   
    BigInteger y = g.modPow(k, p);   
       
    ElGamalPublicKey publicKey = new ElGamalPublicKey(y, g, p);   
    ElGamalPrivateKey privateKey = new ElGamalPrivateKey(k, g, p);   
    return new KeyPair(publicKey, privateKey);   
  }   
}