package IT3;
import java.util.*;



public class TestUDC
{
    public static void main(String[] args){
        ArrayList<String> sourceCode=new ArrayList<String>();//�洢����������

        /*�����ַ�*/
        if (args.length==0){
            sourceCode.clear();

            Scanner input = new Scanner(System.in);
            System.out.println("��������Դ�ĸ���");
            int count = input.nextInt();
            System.out.println("������������");
            for(int i = 0; i< count; i++)
            {
                sourceCode.add(input.next());
            }
            System.out.println("�����������\n"+sourceCode);


        }else {
            Collections.addAll(sourceCode, args);
        }

        String result= UDC.compare(sourceCode)?"��Ψһ������":"����Ψһ������";

        System.out.println(sourceCode+" "+result);
        System.exit(0);
    }
}
