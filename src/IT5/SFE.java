package IT5;

public class SFE {
	protected int m;
	protected SFEStructure[] Sfe;
	
	public SFE(int m) {
		this.m=m;
		Sfe=new SFEStructure[m+1];
	}
	
	/**
	 * 
	 * @param value对数的真数
	 * @param base对数的底数
	 * @return 对数的值
	 */
	public double log(double value, double base) {
		return Math.log(value) / Math.log(base);
	}
	
	public void setSfe(float[] p) {
		int i,length;
		Sfe[0]=new SFEStructure();
		for (i=1;i<=m;i++) {
			Sfe[i]=new SFEStructure();
			Sfe[i].setX(i);
			Sfe[i].setP(p[i]);
			Sfe[i].setF(Sfe[i-1].getF()+p[i]);
			Sfe[i].setF_(Sfe[i-1].getF()+p[i]/2);
			length=(int)(Math.ceil(log(1/p[i],2))+1);
			Sfe[i].setL(length);
			Sfe[i].setS(trans(p[i],length));
		}
	}
	
	public String trans(float num,int length){
        String temp = "";
        
        for(int i=0;i<length;i++){
            num*=2;
            if(num>=1){
                temp+="1";
                num = num-1;
            }else{
                temp+="0";
            }
        }
        return temp;
    }
	
	public void display() {
		System.out.println("编码结果如下：");
		System.out.println("x\tp(x)\tF(x)\tF_(x)\tl(x)\tCode Word");
		for (int i = 1; i <=m; i++)  
			System.out.println(Sfe[i].getX() + "\t" + Sfe[i].getP() + "\t" + Sfe[i].getF() + "\t" +Sfe[i].getF_()+ "\t" +Sfe[i].getL()  + "\t" +Sfe[i].getS()); 
				 
	}
	
	

		

}
