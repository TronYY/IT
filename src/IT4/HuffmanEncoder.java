package IT4;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
 
//������������
public class HuffmanEncoder {
      private PriorityQueue queue;       //���������������������ȼ�����
      private HuffmanTree tree;         //��������
      private String [] message;            //���������ʽ�洢��Ϣ�ı�
      private Map keyMap;                            //�洢�ַ��Լ���Ƶ�Ķ�Ӧ��ϵ
      private Map codeSet;                     //�洢�ַ��Լ�����Ķ�Ӧ��ϵ
     
      public HuffmanEncoder(){
             queue = new PriorityQueue();
             keyMap = new HashMap<String,Integer>();
      }
     
      //��ȡָ���ַ����Ļ���������
      public String encode(String msg){
             resolveMassage(msg);
             buildCodeSet();
             String code = "";
             for(int i=0;i<message.length;i++){//����Ϣ�ı�������ַ�����ɻ���������
                    code =code+codeSet.get(message[i]);
             }
             return code;
      }
     
      //��һ���ַ�����Ϣ�����ɵ����ַ�����ַ���Ƶ�Ķ�Ӧ��ϵ������Map
      private void resolveMassage(String msg){
            
             char [] chars =msg.toCharArray();  //����Ϣת�����ַ�����
             message = new String[chars.length];
             for(int i =0;i<chars.length;i++){
                    String key = "";
                    key =chars[i]+"";  //����ǰ�ַ�ת�����ַ���
                   
                    message [i] =  key;
                    if(keyMap.containsKey(key)){//���Map���Ѵ��ڸ��ַ������Ƶ��һ
                           keyMap.put(key,(Integer)keyMap.get(key)+1);
                    }else{//���Map��û�и��ַ�������Map
                           keyMap.put(key,1);
                    }
             }
      }
     
      //������Ӧĳ����Ϣ�Ĵ��뼯
      private void buildCodeSet(){
             Iterator it =keyMap.entrySet().iterator();
             while(it.hasNext()){
                    Entry entry =(Entry)it.next();
                    //�ø��ַ��͸��ַ��Ĵ�ƵΪ����������һ���µĽڵ㣬�������ȼ�����
                    queue.insert(new Node((Integer)entry.getValue(),(String)entry.getKey()));
             }
             queue.display();
             tree =queue.buildHuffmanTree();  //�������ȼ��������ɻ�������
             codeSet = tree.getCodeSet();   //��ȡ����������Ӧ�Ĵ��뼯
      }
     
      //��ӡ�ö���Ϣ�Ĵ��뼯
      public void printCodeSet(){
             Iterator it =codeSet.entrySet().iterator();
             System.out.println("���뼯��");
             while(it.hasNext()){
                    Entry entry =(Entry)it.next();
                    System.out.println(entry.getKey()+"����>"+entry.getValue());
             }
             System.out.println();
      }
     
      //��ȡ�ö���Ϣ�Ĵ��뼯
      public Map getCodeSet(){
             return codeSet;
      }
}