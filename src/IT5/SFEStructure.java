package IT5;

public class SFEStructure {
	protected int x;//ԭֵ
	protected float p;//����
	protected float F;//�ۻ��ֲ�����
	protected float F_;//�������ۻ��ֲ�����
	protected int l;//ʹ��l��������ʾx
	public String s;//����
	 
	public SFEStructure() {
		this.x=0;
		this.p=0;
		this.F=0;
		this.F_=0;
		this.l=0;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public SFEStructure(int x,float p) {
		this.x=x;
		this.p=p;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getP() {
		return p;
	}

	public void setP(float p) {
		this.p = p;
	}

	public float getF() {
		return F;
	}

	public void setF(float f) {
		F = f;
	}

	public float getF_() {
		return F_;
	}

	public void setF_(float f_) {
		F_ = f_;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	
	
	
	
}
