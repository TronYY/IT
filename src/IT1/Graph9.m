r=input('P(X=1)=');

IXY=[];

t=eps:0.01:1-eps;
s=t;
[T,S]=meshgrid(t,s);
HX=-(r.*log2(r)+(1-r).*log2(1-r));

HX_Y=(-T.*r.*log2(T.*r./(T.*r+S.*(1-r)   )))...
+(-(1-T).*r.*log2((1-T).*r./((1-T).*r+(1-S).*(1-r))))...
+(-S.*(1-r).*log2(S.*(1-r)./(T.*r+S.*(1-r)   )))...
+(-(1-S).*(1-r).*log2((1-S)*(1-r)./((1-T).*r+(1-S).*(1-r))));

mesh(T,S,HX-HX_Y);
xlabel('t'),ylabel('s'),zlabel('I(X;Y)')