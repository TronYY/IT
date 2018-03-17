package IT3;

import java.util.ArrayList;


public class UDC {

    private static boolean result=true;//默认是可唯一译码

    /**
     * 比较两个字符串，若相等，即不可能是唯一可译码，使result为假。
     * 若满足前缀关系，则返回后缀。
     * 若无以上关系,返回真
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
     * 比较两个集合。若有相同的元素，则不是唯一可译码。使result为假。
     * 若其中有元素满足前缀关系。则提取后缀添加到mylist中。
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
     * 对一个String集是否为唯一可译码给出判决
     * @param ccString
     * @return
     */
    public static boolean compare(ArrayList<String> ccString){
        String endString=null;//用来引用要加入mylist中的后缀。
        ArrayList<String> myList=new ArrayList<>();

        //比较所给字符集中任何两个字符,将满足前后缀的字符添加到myList中
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