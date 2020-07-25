#include <iostream>
#include <string>
using namespace std;

string common(string s1,string s2)
{
	string result="";
	int i,j;
	for(i=0,j=0;i<s1.length()&&j<s2.length();++i,++j)
	{
		if(s1[i]!=s2[j])
			break;
		result=result+s1[i];
	}
	return result;
}

string findPrefix(string arr[],int low,int high)
{
	if(low==high)
		return arr[low];
	else if(high>low)
	{
		int mid=low+(high-low)/2;
		string str1=findPrefix(arr,low,mid);
		string str2=findPrefix(arr,mid+1,high);
		return common(str1,str2);
	}
	else
	{
		return "";
	}
}

int main(int argc, char const *argv[])
{
	int i,n;
	cin>>n;
	fflush(stdin);
	string arr[n];
	for(i=0;i<n;++i)
		cin>>arr[i];
	cout<<findPrefix(arr,0,n-1)<<endl;
	return 0;
}