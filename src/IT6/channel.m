function [P_X,C,N]=channel(n,m,P_YX)
%Input  -n 信源符号个数
%       -m 信宿符号个数
%       -p n*m矩阵，信道转移概率矩阵
%Output -S 1*n矩阵 最佳信源分布
%       -Ck 信道容量
%       -N 迭代次数


e=1e-7;%停止迭代的容差限
C1=1;
C=0;
N=0;

P_X=ones(1,n)/n;

%迭代求解
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




