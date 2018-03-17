package IT4;

//���ڸ��������������������ȼ�����
public class PriorityQueue{
    private Node first;
    private int length;
    
    public PriorityQueue(){
           length = 0;
           first = null;
    }
    
    //����ڵ�
    public void insert(Node node){
           if(first == null){  //����Ϊ��
                  first = node;
           }else{
                  Node cur = first;
                  Node previous = null;
                  while(cur.getFrequency()< node.getFrequency()){  //��λҪ����λ�õ�ǰһ���ڵ�ͺ�һ���ڵ�
                         previous = cur;
                         if(cur.getNext() ==null){  //�ѵ����β
                                cur = null;
                                break;
                         }else{
                                cur =cur.getNext();
                         }
                         
                  }
                  if(previous == null){  //Ҫ�����һ���ڵ�֮ǰ
                         node.setNext(first);
                         first = node;
                  }else if(cur == null){  //Ҫ�������һ���ڵ�֮��
                         previous.setNext(node);
                  }else{  //���뵽�����ڵ�֮��
                         previous.setNext(node);
                         node.setNext(cur);
                  }
           }
           length++;
    }
    
    //ɾ����ͷԪ��
    public Node delete(){
           Node temp = first;
           first = first.getNext();
           length--;
           return temp;
    }
    
    //��ȡ���г���
    public int getLength(){
           return length;
    }
    
    //��˳���ӡ����
    public void display(){
           Node cur = first;
           System.out.print("���ȼ����У�\t");
           while(cur != null){
                  System.out.print(cur.getKey()+":"+cur.getFrequency()+"\t");
                  cur = cur.getNext();
           }
           System.out.println();
    }
    
    //�����������
    public HuffmanTree buildHuffmanTree(){
           while(length > 1){
                  Node hLeft = delete();  //ȡ�����еĵ�һ���ڵ���Ϊ�½ڵ�����ӽڵ�
                  Node hRight = delete(); //ȡ�����еĵڶ����ڵ���Ϊ�½ڵ�����ӽڵ�
                  //�½ڵ��Ȩֵ���������ӽڵ��Ȩֵ֮��
                  Node hRoot = new Node(hLeft.getFrequency()+hRight.getFrequency());
                  hRoot.setLeft(hLeft);
                  hRoot.setRight(hRight);
                  insert(hRoot);
           }
           //��������ֻʣһ���ڵ㣬��Ϊ���������ĸ��ڵ�
           return new HuffmanTree(first);
    }
    
}
