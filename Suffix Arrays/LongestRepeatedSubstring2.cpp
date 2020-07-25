#include <iostream>
#include <stdlib.h>
#include <string.h>
using namespace std;
class Suffix
{
    public:
    char *p;
    int index;
};
int comparator(const void *p,const void *q)
{
    return strcmp((*(Suffix *)p).p,(*(Suffix *)q).p);
}
int min(int x,int y)
{
    if(x>y)
        return y;
    return x;
}
int max(int x,int y)
{
    if(x>y)
        return x;
    return y;
}
int main() 
{
	int t;
	cin>>t;
	fflush(stdin);
	while(t--)
    {
        int n;
        cin>>n;
        fflush(stdin);
        char *str=(char *)malloc((n+1)*sizeof(char));
        cin>>str;
        fflush(stdin);
        Suffix s[n];
        for(int i=0;i<n;++i)
        {
            s[i].p=str+i;
            s[i].index=i;
        }
        qsort(s,n,sizeof(s[0]),comparator);
        int pos=-1,c1=0,c2=0;
        for(int i=1;i<n;++i)
        {
            c1=0;
            int x,y,i1,i2;
            x=min(s[i].index,s[i-1].index);
            y=max(s[i].index,s[i-1].index);
            i1=x;
            i2=y;
            for(int j=x;j<y&&str[i1]&&str[i2];++j)
            {
                if(str[i1++]==str[i2++])
                    ++c1;
                else
                    break;
            }
            if(c1>c2||(c1==c2&&x<pos))
            {
                c2=c1;
                pos=x;
            }
        }
        if(pos==-1)
            cout<<"-1\n";
        else
        {
            for(int i=1;i<=c2;++i)
                cout<<str[pos+i-1];
            cout<<"\n";
        }
    }
	return 0;
}