package MidTest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
public class TestHuffmanTree {
	public static void main(String[] args) throws Exception{
        PriorityQueue queue = new PriorityQueue();
        Node n1 = new Node(1,"j");
        Node n2 = new Node(1,"i");
        Node n3 = new Node(2,"n");
        Node n4 = new Node(1,"y");
        Node n5 = new Node(1,"a");
        Node n6 = new Node(1,"g");
        Node n7 = new Node(1,"sp");
        queue.insert(n1);
        queue.insert(n2);
        queue.insert(n3);
        queue.insert(n4);
        queue.insert(n5);
        queue.insert(n6);
        queue.insert(n7);
       
        queue.display();
        
        HuffmanTree tree =queue.buildHuffmanTree();
        Map map = tree.getCodeSet();
        Iterator it =map.entrySet().iterator();
        System.out.println("»ô·òÂü±àÂë½á¹û£º");
        while(it.hasNext()){
               Entry<String,String>entry = (Entry)it.next();
               System.out.println(entry.getKey()+"¡ª¡ª>"+entry.getValue());
        }
 }
}
