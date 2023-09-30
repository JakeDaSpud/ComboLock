public class ComboLock {

    //Fields
    private int indexPos = 0;
    private int code1 = 1;
    private int code2 = 0;
    private int code3 = 1;
    private ComboLockState currentState = ComboLockState.NONE_CORRECT;

    //Constructor
    public ComboLock() {
    }

    public ComboLock(int code1, int code2, int code3) {
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
    }

    public ComboLock(int indexPos, int code1, int code2, int code3, ComboLockState currentState) {
        this.indexPos = indexPos;
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        this.currentState = currentState.NONE_CORRECT;
    }

    public void reset() {
        this.indexPos = 0;
        this.currentState = currentState.NONE_CORRECT;
    }

    public void turnRight(int ticks) {
        this.indexPos = ((this.indexPos + ticks) % 40);

        if (this.currentState == currentState.NONE_CORRECT && this.indexPos == this.code1) {
            this.currentState = currentState.FIRST_CORRECT;
        }

        else if (this.currentState == currentState.SECOND_CORRECT && this.indexPos == this.code3)
        {
            this.currentState = currentState.ALL_CORRECT;
        }

        else {
            reset();
        }
    }

    public void turnLeft(int ticks) {
        this.indexPos = (this.indexPos - ticks + 40) % 40;

        if (this.indexPos < 0) {this.indexPos += 40;}

        if (this.currentState == currentState.FIRST_CORRECT && this.indexPos == this.code2) {
            this.currentState = currentState.SECOND_CORRECT;
        }

        else {
            reset();
        }
    }

    //open()
    public boolean open() {
        if (this.currentState == currentState.ALL_CORRECT)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ComboLock{" +
                "indexPos=" + indexPos +
                ", code1=" + code1 +
                ", code2=" + code2 +
                ", code3=" + code3 +
                ", currentState=" + currentState +
                '}';
    }
}