package IT4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
public class TestHuffmanTree {
	public static void main(String[] args) throws Exception{
        PriorityQueue queue = new PriorityQueue();
        Node n1 = new Node(1,"K");
        Node n2 = new Node(1,"U");
        Node n3 = new Node(1,"T");
        Node n4 = new Node(2,"Y");
        Node n5 = new Node(2,"E");
        Node n6 = new Node(2,"A");
        Node n7 = new Node(3,"I");
        Node n8 = new Node(4,"sp");
        Node n9 = new Node(5,"S");
        queue.insert(n1);
        queue.insert(n2);
        queue.insert(n3);
        queue.insert(n4);
        queue.insert(n5);
        queue.insert(n6);
        queue.insert(n7);
        queue.insert(n8);
        queue.insert(n9);
        queue.display();
        
        HuffmanTree tree =queue.buildHuffmanTree();
        Map map = tree.getCodeSet();
        Iterator it =map.entrySet().iterator();
        System.out.println("��������������");
        while(it.hasNext()){
               Entry<String,String>entry = (Entry)it.next();
               System.out.println(entry.getKey()+"����>"+entry.getValue());
        }
 }
}
