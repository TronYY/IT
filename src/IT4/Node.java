package IT4;

//�ڵ���
public class Node{
    private String key;           //���ڵ�洢�Ĺؼ��֣�����Ƿ�Ҷ�ӽڵ�Ϊ��
    private int frequency;        //�ؼ��ִ�Ƶ
    private Node left;            //���ӽڵ�
    private Node right;           //���ӽڵ�
    private Node next;            //���ȼ�������ָ����һ���ڵ������
    
    public Node(int fre,String str){  //���췽��1
           frequency = fre;
           key = str;
    }
    public Node(int fre){  //���췽��2
           frequency = fre;
    }
    
    public String getKey() {
           return key;
    }
    public void setKey(String key) {
           this.key = key;
    }
    public Node getLeft() {
           return left;
    }
    public void setLeft(Node left) {
           this.left = left;
    }
    public Node getRight() {
           return right;
    }
    public void setRight(Node right) {
           this.right = right;
    }
    public Node getNext() {
           return next;
    }
    public void setNext(Node next) {
           this.next = next;
    }
    public int getFrequency() {
           return frequency;
    }
    public void setFrequency(int frequency) {
           this.frequency = frequency;
    }
}