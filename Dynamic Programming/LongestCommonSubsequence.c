#include <stdio.h>
int max(int a,int b)
{
    if(a>b)
        return a;
    return b;
}
int LCS(char a[],char b[],int m,int n)
{
    if(m<0||n<0)
        return 0;
    if(a[m]==b[n])
        return 1+LCS(a,b,m-1,n-1);
    else
        return max(LCS(a,b,m-1,n),LCS(a,b,m,n-1));
}
int lcs(char a[],char b[],int m,int n)
{
    int i,j,arr[m+1][n+1];
    for(i=0;i<=m;++i)
    {
        for(j=0;j<=n;++j)
        {
            if(i==0||j==0)
                arr[i][j]=0;
            else if(a[i-1]==b[j-1])
                arr[i][j]=1+arr[i-1][j-1];   
            else
                arr[i][j]=max(arr[i-1][j],arr[i][j-1]);
        }
    }
    return arr[m][n];
}
int main() 
{
    int t;
    scanf("%d",&t);
    while(t--)
    {
        int m,n;
        scanf("%d %d",&m,&n);
        fflush(stdin);
        char a[m+1],b[n+1];
        scanf("%s",a);
        scanf("%s",b);
        printf("%d\n",lcs(a,b,m,n));
    }
	return 0;
}