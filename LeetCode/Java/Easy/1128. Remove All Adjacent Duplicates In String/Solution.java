class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }
            else{
                if(c==stack.peek()){
                    stack.pop();
                }
                else{
                stack.push(c);
                }
                }
            }
           StringBuilder result = new StringBuilder();
              for(char c : stack){
                result.insert(0,c);
              }
              return result.toString();
        }
    }