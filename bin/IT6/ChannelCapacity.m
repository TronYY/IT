function [s,Capacity]=ChannelCapacity(n,m,py_x)
%Input  -n 信源符号个数
%       -m 信宿符号个数
%       -py_x n*m矩阵，信道转移概率矩阵
%Output -s 1*n矩阵 最佳信源分布
s=ones(1,n)/n;
C0=0;
C1=0;

while (1)
    for j=1:m
       for i=1:n
          a(j,i)=s(i)*py_x(i,j);
       end
    end
    
    temp=sum(a,2);
    
    for j=1:m
       for i=1:n
          phi(j,i)=a(j,i)/temp(i);
       end
    end
    
    
    
    for i=1:n
       s(i) =exp(py_x(i,:)*log2(phi(:,i)));
    end
    temp=sum(s);
    s=s./temp;
    
    temp1=0;
    for i=1:n
        temp2=0;
        for j=1:m
            temp2=temp2+py_x(i,j)*log2(phi(j,i));
        end
        temp1=temp1+exp(temp2);
    end
    C0=C1;C1=log2(temp1);
    
    if (C1-C0<1e-6)
        break;
    end   
    
end
Capacity=C1;



