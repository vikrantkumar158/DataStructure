#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[])
{
	int i,n;
	cin>>n;
	fflush(stdin);
	string arr[n];
	for(i=0;i<n;++i)
		cin>>arr[i];
	for(i=0;i<n;++i)
		sort(arr[i].begin(),arr[i].end());
	sort(arr,arr+n);
	string ana=arr[0];
	int count=0;
	for(i=1;i<n;++i)
	{
		if(ana==arr[i])
			++count;
		else
		{
			cout<<"Anagram: "<<ana<<" Count: "<<count<<endl;
			ana=arr[i];
			count=0;
		}
	}	
	if(count!=0)
	{
		cout<<"Anagram: "<<ana<<" Count: "<<count<<endl;
	}
	return 0;
}