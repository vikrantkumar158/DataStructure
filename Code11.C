#include<stdio.h>
int main() 
{
	int t;
	scanf("%d",&t);
	while(t--) 
	{
		int n,arr[10],ind=0;
		scanf("%d",&n);
		while(n!=0) 
		{
			arr[ind++]=n%10;
			n=n/10;
		}
		int flag=0,x=arr[0];
		for(int i=1;i<ind;++i)
			if(x<arr[i])
				x=arr[i];
		for(int i=ind-2;i>=0;--i) 
		{
			if(arr[i]==0) 
			{
				flag=1;
				if(i==0)
					printf("0");
			}
			else if(flag==1) 
			{
				for(int j=i;j>=0;--j)
					printf("%d",arr[j]);
				break;
			}
			else
				break;
		}	
		for(int i=ind-1;i>=0&&flag==0;--i) 
		{
			if(arr[i]==x) 
			{
				x=-1;
				continue;
			}
			else
				printf("%d",arr[i]);
		}
		printf("\n");
	}
	return 0;
}