public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        if (word == null){
            return null;
        } else {
            Deque<Character> array = new ArrayDeque<>();
            for (int i = 0; i < word.length(); i++){
            char ithitem = word.charAt(i);
            array.addLast(ithitem);
            }
            return array ;
        }
    }

    public boolean isPalindrome(String word){
        if(word.length() == 0||word.length() == 1) {
            return true;
        }
        Deque<Character> palindromDeque = this.wordToDeque(word);
        return recursionhelper(palindromDeque);
    }


    private boolean recursionhelper(Deque<Character> helper){
        if (helper.size() == 1 ||helper.size() == 0){
            return true;
        }
        char A = helper.removeLast();
        char B = helper.removeFirst();
        if (A == B){
            return recursionhelper(helper);
        } else{
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length() == 0||word.length() == 1) {
            return true;
        }
        Deque<Character> palindromDeque = this.wordToDeque(word);
        return recursionhelper2(palindromDeque, cc);
    }
    private boolean recursionhelper2(Deque<Character> helper, CharacterComparator Charhelper){
        if (helper.size() == 1 ||helper.size() == 0){
            return true;
        }
        char A = helper.removeLast();
        char B = helper.removeFirst();
        if (Charhelper.equalChars(A,B)){
            return recursionhelper2(helper, Charhelper);
        } else{
            return false;
        }
    }


}
