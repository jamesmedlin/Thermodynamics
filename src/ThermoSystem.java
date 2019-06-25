import java.util.ArrayList;

// represents an entire system being analyzed
class ThermoSystem {
    ArrayList<APart> parts;
    String material;
    boolean isIdealGas;

    ThermoSystem() {
        this.parts = new ArrayList<APart>();
        this.isIdealGas = true;
    }

    void findMissingPressOrTemp() {
        if (this.isIdealGas) {
            for (int i = 0; i < this.parts.size(); i++) {
                APart part = this.parts.get(i);
                part.findMissingPressOrTemp();
            }
        }
    }

}