#include <bits/stdc++.h>

using namespace std;

void solve(int year){
	int arr[12];
	arr[0]=31;
	arr[1]=28;
	arr[2]=31;
	arr[3]=30;
	arr[4]=31;
	arr[5]=30;
	arr[6]=31;
	arr[7]=31;
	arr[8]=31;
	arr[9]=31;
	arr[10]=30;
	arr[11]=31;
    int sum=0,i=0;
    if(year<1918)
    {
    if(year%4==0)
    arr[1]=29;
    }
    else if(year==1918)
    arr[1]=15;
    else
    {
    if((year%4==0)&&(year%100!=0))
    arr[1]=29;
    }
    while(sum<=256)
    {
    sum+=arr[i];
    i++;
    }
    sum=sum-arr[i-1];
    sum=256-sum;
    //cout<<sum<<endl;
    if(i<10 && sum>9)
    cout<<sum<<"."<<"0"<<i<<"."<<year<<endl;
    else if(sum<10 && i>9)
        cout<<"0"<<sum<<"."<<i<<"."<<year<<endl;
    else if(i<10 && sum<10)
         cout<<"0"<<sum<<"."<<"0"<<i<<"."<<year<<endl;
        else
          cout<<sum<<"."<<i<<"."<<year<<endl;
}
    

int main() {
    int year;
    cin >> year;
    solve(year);
    //cout << result << endl;
    return 0;
}
