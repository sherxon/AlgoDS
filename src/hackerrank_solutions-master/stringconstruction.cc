#include <bits/stdc++.h>

using namespace std;

int stringConstruction(string s){
    set <char> myset;
    int len=s.size();
    for(int i=0;i<len;i++)
    myset.insert(s[i]);
    len=myset.size();
    return len;
}

int main() {
    int q;
    cin >> q;
    for(int a0 = 0; a0 < q; a0++){
        string s;
        cin >> s;
        int result = stringConstruction(s);
        cout << result << endl;
    }
    return 0;
}
