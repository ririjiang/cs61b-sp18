public class Palindrome {
    public Deque<String> wordToDeque(String word){
        if (word == null){
            return null;
        } else {
            Deque<String> array = new ArrayDeque<>();
            for (int i = 0; i < word.length(); i++){
            char ithitem = word.charAt(i);
            array.addLast(String.valueOf(ithitem));
            }
            return array;
        }
    }

    public boolean isPalindrome(String word){
        if(word.length() == 0||word.length() == 1) {
            return true;
        }
        Deque<String> palindromDeque = this.wordToDeque(word);
        return recursionhelper(palindromDeque);
    }


    private boolean recursionhelper(Deque<String> helper){
        if (helper.size() == 1 ||helper.size() == 0){
            return true;
        }
        String A = helper.removeLast();
        String B = helper.removeFirst();
        if (A.equals(B)){
            return recursionhelper(helper);
        } else{
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length() == 0||word.length() == 1) {
            return true;
        }
        Deque<String> palindromDeque = this.wordToDeque(word);
        return recursionhelper2(palindromDeque, cc);
    }
    private boolean recursionhelper2(Deque<String> helper, CharacterComparator Charhelper){
        if (helper.size() == 1 ||helper.size() == 0){
            return true;
        }
        String A = helper.removeLast();
        String B = helper.removeFirst();
        char AC = A.charAt(0);
        char BC = B.charAt(0);
        if (Charhelper.equalChars(AC,BC)){
            return recursionhelper2(helper, Charhelper);
        } else{
            return false;
        }
    }


}
