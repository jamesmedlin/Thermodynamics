class State {
    double pressure;
    double temperature;
    double enthalpy;
    double massFlow;
    double entropy;
    double specificVolume;

    State() {
        this.pressure = -1000;
        this.temperature = -1000;
        this.massFlow = -1;
        this.enthalpy = 0;
        this.entropy = 0;
        this.specificVolume = 0;
    }
}