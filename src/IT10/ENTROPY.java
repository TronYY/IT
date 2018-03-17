package IT10;
import java.util.ArrayList;
public class ENTROPY {
	public static double entropy(String message) {
	
		ArrayList<Node> array = new ArrayList<Node>();
		array.clear();
		double num = message.length();
		for (int i = 0; i < num; i++) {
			boolean flag_exit = true;
			for (int j = 0; j < array.size(); j++) {
				if (array.get(j).getalpha() == message.charAt(i)) {
					flag_exit = false;
					array.get(j).setp(array.get(j).getp() + 1 / num);
				}
			}
			if (flag_exit)
				array.add(new Node(1 / num, message.charAt(i)));
		}
		
		double entropy = 0;
		for (int i = 0; i < array.size(); i++) {
			double p1 = array.get(i).getp();
			entropy += (-p1 * (Math.log(p1) / Math.log(2)));
		}
		return entropy;
	}
}