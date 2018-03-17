package IT8;

public class CreatePol {
	
	//生成被除式
	public static int[] genDividend(int n) {
		int[] dividend = new int[n+1];
		dividend[0] = 1;
		dividend[n] = 1;
		for(int i = 1;i<n;i++) {
			dividend[i] = 0;
		}
		return dividend;	
	}
	
	//生成除式
	public static int[] genDivisor(int[] div,int n) {
		int len = div.length;
		int [] divisor = new int[len+n];
		for(int i = 0;i<len;i++) {
			divisor[i] = div[i];
		}
	    for(int i = len;i<len+n;i++) {
	    	divisor[i] = 0;
	    }
		return divisor;
		
	}

}


