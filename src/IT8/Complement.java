package IT8;


/*²¹Î»²Ù×÷*/
public class Complement {
	public static int[] Generate(int[] P,int n) {
		int len = P.length;
		int[] PP = new int[len+n-1];
		for(int i = len;i<len+n-1;i++) {
			PP[i] = 0;
		}
		for(int i = 0;i<len;i++) {
			PP[i] = P[i];
		}
		return PP;
	}

}