public class OffByN implements CharacterComparator{
    private int Ndiff;
    public OffByN(int c){
        Ndiff = c;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff  = x - y;
        return diff == this.Ndiff || diff == -this.Ndiff;
    }
}
