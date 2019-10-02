package id.ac.polinema.idealbodyweight.util;

public class BrocaIndex {

    public static final int Male = 0, Female = 1;
    private int gender, height;
    private float index;

    private float Calculate() {
        switch (gender) {
            case Male: return (height - 100) - ((height - 100) * 0.1f);
            case Female: return (height - 100) + ((height - 100) * 0.15f);
            default: return 0f;
        }
    }

    public BrocaIndex(int gender, int height) {
        this.height = height;
        this.gender = gender;
        this.index = Calculate();
    }

    public float getIndex() {
        return index;
    }
}
