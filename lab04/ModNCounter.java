public class ModNCounter {

    private int myCount;

    private int myMod;

    public ModNCounter(int n) {
        myCount = 0;
        myMod = n;
    }



    public void increment() {
        myCount = (myCount + 1) % myMod;
    }

    public void reset() {
        myCount = 0;
    }

    public int value() {
        return myCount;
    }

    public int getMyMod() {
        return myMod;
    }
}
