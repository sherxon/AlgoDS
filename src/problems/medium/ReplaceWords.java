package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sherali Obidov.
 */
public class ReplaceWords {
    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        list.add("cat");
        list.add("rat");
        list.add("bat");
        System.out.println(new ReplaceWords().replaceWords(list, "the cattle was rattled by the battery"));
    }
        public String replaceWords(List<String> dict, String sentence) {
            if(dict==null || dict.size()==0)return sentence;
            TrieNode trie= new TrieNode(' ');
            for(int i=0; i<dict.size(); i++){
                insert(dict.get(i), 0, trie);
            }

            String[] a=sentence.trim().split(" ");

            StringBuilder sb= new StringBuilder();
            for(int i=0; i<a.length; i++){
                String s=a[i];
                String ss=startsWith(s, trie);
                if(i!=0)sb.append(" ");
                sb.append(ss);
            }
            return sb.toString();
        }

        String startsWith(String s, TrieNode node){
            StringBuilder sb=new StringBuilder();
            find(s.toCharArray(), node, sb, 0);
            return sb.length()==0 ? s : sb.toString();
        }
        void find(char[] a, TrieNode node, StringBuilder sb, int i){
            if(i>=a.length)return;
            int index=a[i]-'a';
            if(node.data[index]==null){
                sb.setLength(0);
                return;
            }
            sb.append(a[i]);
            if(node.data[index].isLeaf)return;
            find(a, node.data[index], sb, i+1);
        }

        void insert(String s, int i, TrieNode node){
            if(i>=s.length())return;
            int index=s.charAt(i)-'a';
            if(node.data[index]==null){
                node.data[index]= new TrieNode(s.charAt(i));
            }
            if(i==s.length()-1){
                node.data[index].isLeaf=true;
                return;
            }
            insert(s, i+1, node.data[index]);
        }


        private class TrieNode{
            TrieNode[] data= new TrieNode[26];
            char value;
            boolean isLeaf;
            TrieNode(char c){
                value=c;
            }
        }
}
