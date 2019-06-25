import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TableSearcher {
    double specificVolume;
    double liquidSpecificVolume;
    double vaporSpecificVolume;
    double internalEnergy;
    double liquidInternalEnergy;
    double vaporInternalEnergy;
    double enthalpy;
    double liquidEnthalpy;
    double vaporEnthalpy;
    double entropy;
    double liquidEntropy;
    double vaporEntropy;
    Scanner scanner;

    TableSearcher() throws FileNotFoundException {
        this.liquidSpecificVolume = 0;
        this.vaporSpecificVolume = 0;
        this.liquidInternalEnergy = 0;
        this.vaporInternalEnergy = 0;
        this.liquidEnthalpy = 0;
        this.vaporEnthalpy = 0;
        this.liquidEntropy = 0;
        this.vaporEntropy = 0;
        this.scanner = new Scanner(new File("C:\\Users\\medlinj\\Desktop\\TableA-2b.CSV"));
    }

    void switchTable(String material) throws FileNotFoundException {
        if (material.equals("water")) {
            this.scanner = new Scanner(new File("C:\\Users\\medlinj\\Desktop\\TableA-2b.CSV"));
        }
    }

    public void findProperty(double temperature, double pressure) throws FileNotFoundException {
        this.scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            if (Double.parseDouble(scanner.next()) == temperature
                    && Double.parseDouble(scanner.next()) == pressure) {
                this.liquidSpecificVolume = Double.parseDouble(scanner.next()) / 1000;
                this.vaporSpecificVolume = Double.parseDouble(scanner.next());
                this.liquidInternalEnergy = Double.parseDouble(scanner.next());
                this.vaporInternalEnergy = Double.parseDouble(scanner.next());
                this.liquidEnthalpy = Double.parseDouble(scanner.next());
                scanner.next();
                this.vaporEnthalpy = Double.parseDouble(scanner.next());
                this.liquidEntropy = Double.parseDouble(scanner.next());
                this.vaporEntropy = Double.parseDouble(scanner.next());
            }
        }
        scanner.close();
    }

    public void findProperty2(double temperature, double pressure) throws FileNotFoundException {
        this.scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            if (Double.parseDouble(scanner.next()) == pressure
                    && Double.parseDouble(scanner.next()) == temperature) {
                this.specificVolume = Double.parseDouble(scanner.next());
                this.internalEnergy = Double.parseDouble(scanner.next());
                this.enthalpy = Double.parseDouble(scanner.next());
                this.entropy = Double.parseDouble(scanner.next());
            }
        }
        scanner.close();
    }
}