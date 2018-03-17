package IT3;
import java.util.*;



public class TestUDC
{
    public static void main(String[] args){
        ArrayList<String> sourceCode=new ArrayList<String>();//存储输入的码符号

        /*输入字符*/
        if (args.length==0){
            sourceCode.clear();

            Scanner input = new Scanner(System.in);
            System.out.println("请输入信源的个数");
            int count = input.nextInt();
            System.out.println("请输入编码符号");
            for(int i = 0; i< count; i++)
            {
                sourceCode.add(input.next());
            }
            System.out.println("输入的码字是\n"+sourceCode);


        }else {
            Collections.addAll(sourceCode, args);
        }

        String result= UDC.compare(sourceCode)?"是唯一可译码":"不是唯一可译码";

        System.out.println(sourceCode+" "+result);
        System.exit(0);
    }
}
