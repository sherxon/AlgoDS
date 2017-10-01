#include <bits/stdc++.h>

using namespace std;

string twoStrings(string s1, string s2){
   
   set <char> se1;
   set <char> se2;
   for(int i=0;i<s1.size();i++)
   se1.insert(s1[i]);
   for(int i=0;i<s2.size();i++)
   se2.insert(s2[i]);
   set<int> intersect;
set_intersection(se1.begin(),se1.end(),se2.begin(),se2.end(),
                  std::inserter(intersect,intersect.begin()));
                  if(intersect.empty())
                  return "NO";
                  else
                  return "YES";
                  
    
}

int main() {
    int q;
    cin >> q;
    for(int a0 = 0; a0 < q; a0++){
        string s1;
        cin >> s1;
        string s2;
        cin >> s2;
        string result = twoStrings(s1, s2);
        cout << result << endl;
    }
    return 0;
}
