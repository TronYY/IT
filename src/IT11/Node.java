package IT11;
public class Node {
	private double pr;
	private char al;
	
	public void setp(double p) {
		this.pr = p;
	}

	public void setalpha(char a) {
		this.al = a;
	}

	public double getp() {
		return pr;
	}

	public char getalpha() {
		return al;
	}

	public Node(double p, char alpha) {
		this.pr = p;
		this.al = alpha;
	}

	
}