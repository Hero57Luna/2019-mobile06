package id.ac.polinema.idealbodyweight.util;

public class BodyMassIndex {

    private int height, mass;
    private float index;

    private float Calculate() {
        return mass / height * height;
    }

    public BodyMassIndex(int height, int mass) {
        this.height = height;
        this.mass = mass;
        this.index = Calculate();
    }

    public float getIndex() {
        return index;
    }

}
