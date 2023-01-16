import java.util.*;
import java.io.*;

class Solution {
    
    static class Node {
        int cnt;
        String word;
        
        Node(int cnt, String word){
            this.cnt = cnt;
            this.word = word;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
       
        
        Queue<Node> queue =  new ArrayDeque<>();
        queue.offer(new Node(0, begin));
        boolean[] isVisited = new boolean[words.length];
        int answer = 0;
        
        while(!queue.isEmpty()){
            Node top = queue.poll();
            if(top.word.equals(target)){
                answer = top.cnt;
                break;
            }
            for(int i=0;i<words.length;i++){
                int cnt=0;
                char[] c = top.word.toCharArray();
                char[] compare = words[i].toCharArray();
                for(int j=0;j<compare.length;j++){
                    if(c[j] !=compare[j]){
                        cnt++;
                    }
                }
                
                if(cnt==1 && !isVisited[i]){
                    isVisited[i] = true;
                    queue.offer(new Node(top.cnt+1, words[i]));
                }
            }
        }
        
        return answer;
    }
}