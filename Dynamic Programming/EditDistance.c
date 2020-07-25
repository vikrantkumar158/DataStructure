#include <stdio.h>
#include <stdlib.h>
int min(int a,int b)
{
    if(a>b)
        return b;
    return a;
}
int editDistance(char a[],char b[],int m,int n)
{
    if(n==0)
        return m;
    if(m==0)
        return n;
    if(a[m-1]==b[n-1])
        return editDistance(a,b,m-1,n-1);
    return 1+min(min(editDistance(a,b,m-1,n),editDistance(a,b,m-1,n-1)),editDistance(a,b,m,n-1));
}
int EditDistance(char a[],char b[],int m,int n)
{
    int i,j,arr[m+1][n+1];
    for(i=0;i<=m;++i)
    {
        for(j=0;j<=n;++j)
        {
            if(i==0)
                arr[i][j]=j;
            else if(j==0)
                arr[i][j]=i;
            else if(a[i-1]==b[j-1])
                arr[i][j]=arr[i-1][j-1];
            else
                arr[i][j]=1+min(min(arr[i-1][j],arr[i][j-1]),arr[i-1][j-1]);
        }
    }
    return arr[m][n];
}
int main() 
{
	int t;
	scanf("%d",&t);
	fflush(stdin);
	while(t--)
	{
	    int m,n;
	    scanf("%d %d",&m,&n);
	    fflush(stdin);
	    char a[m+1],b[n+1];
	    scanf("%s %s",a,b);
	    printf("%d\n",EditDistance(a,b,m,n));
	}
	return 0;
}