package MidTest;

import java.util.HashMap;
import java.util.Map;
//����������
public class HuffmanTree {
      private Node root;
      private Map codeSet = new HashMap();  //�û���������Ӧ���ַ����뼯
      
      public HuffmanTree(Node root){
             this.root = root;
             buildCodeSet(root,"");  //��ʼ�����뼯
      }
      
      //���ɱ��뼯��˽�з����������˵�����˼��
      //����currentNode��ʾ��ǰ�ڵ㣬����currentCode����ǰ�ڵ��Ӧ�Ĵ���
      private void buildCodeSet(Node currentNode,String currentCode){
             if(currentNode.getKey() != null){
                    //���������У������ǰ�ڵ�����ؼ��֣���ýڵ�϶���Ҷ�ӽڵ㣬���ùؼ��ֺʹ��������뼯
                    codeSet.put(currentNode.getKey(),currentCode);
             }else{//�������Ҷ�ӽڵ㣬�ض�ͬʱ���������ӽڵ㣬���ֽڵ�û�ж�Ӧ�ؼ���
                    //ת�����ӽڵ���Ҫ����ǰ����׷��0
                    buildCodeSet(currentNode.getLeft(),currentCode+"0");
                    //ת�����ӽڵ���Ҫ����ǰ����׷��1
                    buildCodeSet(currentNode.getRight(),currentCode+"1");
             }
      }
      
      //��ȡ���뼯
      public Map getCodeSet(){
             return codeSet;
      }
      
}