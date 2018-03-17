package IT2;

public class Entropy {
	protected int m,n;//m*n�ֲ�
	protected float[][] p;
	protected float[] px;
	protected float[] py;
	
	public Entropy() {
		
	}
	
	public Entropy(int m,int n, float[][] p) {
		this.p=new float[m][n];
		this.py=new float[m];
		this.px=new float[n];
		System.arraycopy(p, 0, this.p, 0, p.length);
		this.m=m;
		this.n=n;
	}
	
	
	/**
	 * 
	 * @param value����������
	 * @param base�����ĵ���
	 * @return ������ֵ
	 */
	public double log(double value, double base) {
		return Math.log(value) / Math.log(base);
	}
	
	
	
	/**
	 * 
	 * @param q:һά�ֲ�q
	 * @return����
	 */
	public float H(float[] q) {
		float h=0;
		int i;
		for (i=0;i<q.length;i++)
			if (q[i]>1e-7)//q[i]=0ʱ������ӣ�Լ��0log0=0
				h+=-q[i]*log(q[i],2);
		return h;
	}
	
	/**
	 * 
	 * @return H(X)
	 */
	public float HX() {
		this.px=new float[n];
		int i,j;
		for (i=0;i<n;i++) 
			for (j=0;j<m;j++)
				px[i]+=p[j][i];
		return H(px);
	}
	
	/**
	 * 
	 * @return H(Y)
	 */
	public float HY() {
		this.py=new float[m];
		int i,j;
		for (i=0;i<m;i++) 
			for (j=0;j<n;j++)
				py[i]+=p[i][j];
		return H(py);
	}
	
	/**
	 * 
	 * @return H(X|Y)
	 */
	public float HX_Y() {
		float[] px_y=new float[n];
		float hx_y=0;
		int i,j;
		for (i=0;i<m;i++) {
			for (j=0;j<n;j++) px_y[j]=p[i][j]/py[i];
			hx_y+=py[i]*H(px_y);
		}
		
		return hx_y;
	}
	
	/**
	 * 
	 * @return H(Y|X)
	 */
	public float HY_X() {
		float[] py_x=new float[m];
		float hy_x=0;
		int i,j;
		for (i=0;i<n;i++) {
			for (j=0;j<m;j++) py_x[j]=p[j][i]/px[i];
			hy_x+=px[i]*H(py_x);
		}
		return hy_x;
	}
	
	
	/**
	 * 
	 * @return������H(X,Y)
	 */
	public float HXY() {
		return HX()+HY_X();
		
	}
	
	/**
	 * 
	 * @return����ϢI(X,Y)
	 */
	public float IXY() {
		return HX()-HX_Y();
	}
}
