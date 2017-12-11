#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>

using namespace std;


int main() {
    string s;
    cin>>s;
    //build the set
    set<int> st;
    int last = -1;
    int num = 0;
    for(int i = 0; i<s.length(); ++i){
        if(s[i] == last){
            num +=tolower(s[i])-'a'+1;
        }else{
            num = tolower(s[i])-'a'+1;
            last = s[i];
        }
        st.insert(num);
    }
    //retrieve from the set
    int n,x;
    cin>>n;
    while(n--){
        cin>>x;
        if(st.count(x)) cout<<"Yes"<<endl;
        else cout<<"No"<<endl;
    }
        
    return 0;
}
