package id.ac.polinema.idealbodyweight.util;

public class BodyMassIndex {

    private float height, mass, value;

    public float Calculate() {
        return this.value = this.mass / (this.height * this.height);
    }

    public BodyMassIndex(float height, float mass) {
        this.height = height;
        this.mass = mass;
        this.Calculate();
    }


}
