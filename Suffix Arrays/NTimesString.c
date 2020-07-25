#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct Suffix
{
    char *p;
    int index;
}Suffix;
int comparator(const void *p,const void *q)
{
    return strcmp((*(Suffix *)p).p,(*(Suffix *)q).p);
}
int main(int argc, char const *argv[])
{
	int i,j,n,len,count,l;
	scanf("%d",&n);
	char *arr=(char*)malloc(100*sizeof(char));
	scanf("%s",&arr);
	len=strlen(arr);
	Suffix s[len];
	for(i=0;i<n;++i)
		s[i].p=arr+i;
	qsort(s,len,sizeof(s[0]),comparator);
	return 0;
}