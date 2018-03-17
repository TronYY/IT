package IT8;

public class Moving {
	public static int[] move(int[] a, int k) {
		int n = a.length;
		int m = Math.min(k, n - k);
		int i, j;
		if (n % m != 0) {
			int start = 0;
			// Integer now = start;
			int to = (start + k) % n;
			int getdata;
			int setdata = a[start];
			while (to != start) {
				getdata = a[to];
				a[to] = setdata;
				to = (to + k) % n;
				setdata = getdata;
			}
			a[to] = setdata;
		} else {
			int start = 0;
			int now = start;
			int to = (now + k) % n;
			int getdata;
			int setdata = a[start];
			for (i = 0; i < m; i++) {
				start = i;
				setdata = a[start];
				to = (start + k) % n;
				now = to;
				while (now != start) {
					getdata = a[to];
					a[to] = setdata;
					now = to;
					to = (to + k) % n;
					setdata = getdata;

				}
			}
		}
		return a;
	}

	
	 public static void main(String[] args) {
	 
	 int[] data = { 1,0,0,0,0,1,0,0,0}; 
	 int[] b = move(data,1);
	 for(int i = 0;i<data.length;i++) {
		 System.out.print(data[i]);
	 }
	 System.out.println();
	 for(int i = 0;i<data.length;i++) {
		 System.out.print(b[i]);
	 }
	 }	

}