package IT3;

import java.util.ArrayList;


public class UDC {

    private static boolean result=true;//Ĭ���ǿ�Ψһ����

    /**
     * �Ƚ������ַ���������ȣ�����������Ψһ�����룬ʹresultΪ�١�
     * ������ǰ׺��ϵ���򷵻غ�׺��
     * �������Ϲ�ϵ,������
     * @param str1
     * @param str2
     * @return
     */
    private static String compareString(String str1,String str2)
    {
        String theResult=null;
        if(str1.equals(str2)){
            result=false;
        }
        if(result)
        {
            if(str1.startsWith(str2))
            {
                theResult=str1.substring(str2.length(),str1.length());

            }
            if(str2.startsWith(str1))
            {
                theResult=str2.substring(str1.length(),str2.length());
            }
        }
        return theResult;
    }

    /**
     * �Ƚ��������ϡ�������ͬ��Ԫ�أ�����Ψһ�����롣ʹresultΪ�١�
     * ��������Ԫ������ǰ׺��ϵ������ȡ��׺��ӵ�mylist�С�
     * @param a
     * @param b
     * @param endString
     */
    private static void compareList(ArrayList<String> a,ArrayList<String> b,String endString)
    {
        boolean flag=false;
        String aa;
        String bb;
        cp: for(int i=0;i<a.size();i++)
        {
            for(int j=0;j<b.size();j++)
            {
                aa=a.get(i);
                bb=b.get(j);
                endString=compareString(aa,bb);
                if(!result)
                {
                    break cp;
                }
                if(endString!=null&&!b.contains(endString))
                {
                    b.add(endString);
                    flag=true;
                    break cp;
                }
            }
        }
        if(flag)
        {
            compareList(a,b,endString);
        }
    }

    /**
     * ��һ��String���Ƿ�ΪΨһ����������о�
     * @param ccString
     * @return
     */
    public static boolean compare(ArrayList<String> ccString){
        String endString=null;//��������Ҫ����mylist�еĺ�׺��
        ArrayList<String> myList=new ArrayList<>();

        //�Ƚ������ַ������κ������ַ�,������ǰ��׺���ַ���ӵ�myList��
        cp: for(int m = 0; m< ccString.size(); m++)
        {
            for(int j = m+1; j< ccString.size(); j++)
            {
                String st1=ccString.get(m);
                String st2=ccString.get(j);
                endString= compareString(st1,st2);
                if(!result)
                {
                    break cp;
                }
                if(endString!=null&&!myList.contains(endString))
                {
                    myList.add(endString);
                }
            }
        }
        compareList(ccString,myList,endString);
        return result;
    }
}