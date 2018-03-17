fprintf('«Î ‰»ÎP(Y|X)\n');
P(1,1)=input('P(Y=1|X=1)=');
P(1,2)=input('P(Y=0|X=1)=');
P(2,1)=input('P(Y=1|X=0)=');
P(2,2)=input('P(Y=0|X=0)=');
IXY=[];
for r=0:0.01:1
    PY=[r 1-r]*P;
    HY=-sum(PY.*log2(PY));
    
    PXY=[r r;1-r 1-r].*P;
    HY_X=-sum(sum(PXY.*log2(P)));
    IXY=[IXY,HY-HY_X];
end
r=0:0.01:1;
plot(r,IXY);
grid on;
