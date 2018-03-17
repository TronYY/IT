package IT4;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
 
//������������
public class HuffmanDecoder {
      private Map codeSet;  //����ζ�Ӧ�Ĵ��뼯
     
      public HuffmanDecoder(Map map){
             codeSet = map;
      }
     
      //������ν�������Ϣ�ı�
      public String decode(String code){
             String message = "";
             String key = "";
             char [] chars = code.toCharArray();
             for(int i=0;i<chars.length;i++){
                    key += chars[i];
                    if(codeSet.containsValue(key)){  //���뼯�д��ڸöδ���
                           Iterator it =codeSet.entrySet().iterator();
                           while(it.hasNext()){
                                  Entry entry = (Entry)it.next();
                                  if(entry.getValue().equals(key)){
                                         message+= entry.getKey();  //��ȡ�öδ����Ӧ�ļ�ֵ������Ϣ�ַ�
                                  }
                           }
                           key ="";  //����α�����Ϊ0
                    }else{
                           continue;  //�öδ��벻�ܽ���Ϊ�ı���Ϣ������ѭ��
                    }
             }
             return message;
      }
}