function [P_X,C,N]=channel(n,m,P_YX)
%Input  -n ��Դ���Ÿ���
%       -m ���޷��Ÿ���
%       -p n*m�����ŵ�ת�Ƹ��ʾ���
%Output -S 1*n���� �����Դ�ֲ�
%       -Ck �ŵ�����
%       -N ��������


e=1e-7;%ֹͣ�������ݲ���
C1=1;
C=0;
N=0;

P_X=ones(1,n)/n;

%�������
while (abs(C1-C))>e
    P_Y=P_X*P_YX;
    
    I1=sum((P_YX.*log2(P_YX))');
    I2=log2(P_Y)*(P_YX');
    BETA=exp(I1-I2);
    B=P_X*(BETA');
    C1=log(B);C=log(max(BETA));
    P_X=P_X.*BETA/B;
    N=N+1;
end




