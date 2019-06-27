

/**
 * represents a state either entering or exiting a part.
 */
class State implements IState  {
    private double pressure;
    private double temperature;
    private double enthalpy;
    private double massFlow;
    private double entropy;
    private double specificVolume;

    /**
     * constructs an instance of a state with the given values,
     * whether default or specified from the builder.
     *
     * @param press pressure value
     * @param temp temperature value
     * @param massFlow mass flow value
     * @param enthalpy enthalpy value
     * @param entropy entropy value
     * @param specificVolume specific volume value
     */
    private State(double press, double temp, double massFlow, double enthalpy,
                  double entropy, double specificVolume) {
        this.pressure = press;
        this.temperature = temp;
        this.massFlow = massFlow;
        this.enthalpy = enthalpy;
        this.entropy = entropy;
        this.specificVolume = specificVolume;
    }

    @Override
    public void setPressure(double value) {
        this.pressure = value;
    }

    @Override
    public void setTemperature(double value) {
        this.temperature = value;
    }

    @Override
    public void setEnthalpy(double value) {
        this.enthalpy = value;
    }

    @Override
    public void setMassFlow(double value) {
        this.massFlow = value;
    }

    @Override
    public void setEntropy(double value) {
        this.entropy = value;
    }

    @Override
    public void setSpecificVolume(double value) {tm
        this.specificVolume = value;
    }

    @Override
    public double getPressure() {
        return this.pressure;
    }

    @Override
    public double getTemperature() {
        return this.temperature;
    }

    @Override
    public double getEnthalpy() {
        return this.enthalpy;
    }

    @Override
    public double getMassFlow() {
        return this.massFlow;
    }

    @Override
    public double getEntropy() {
        return this.entropy;
    }

    @Override
    public double getSpecificVolume() {
        return this.specificVolume;
    }


    /**
     * instantiates a builder.
     * @return an instance of a builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * implemented the builder pattern for practice. Also happens to work...
     */
    public static final class Builder {
        private double pressure;
        private double temperature;
        private double enthalpy;
        private double massFlow;
        private double entropy;
        private double specificVolume;

        private Builder() {
            this.pressure = -1000;
            this.temperature = -1000;
            this.massFlow = -1;
            this.enthalpy = 0;
            this.entropy = 0;
            this.specificVolume = 0;
        }

        /**
         * sets a pressure value if specified.
         * @param pressure the pressure value
         * @return this instance in order to stack this class's methods
         */
        public Builder pressure(double pressure) {
            this.pressure = pressure;
            return this;
        }

        /**
         * sets a temperature value if specified.
         * @param temp the temperature value
         * @return this instance in order to stack this class's methods
         */
        public Builder temperature(double temp) {
            this.temperature = temp;
            return this;
        }

        /**
         * sets an enthalpy value if specified.
         * @param value the enthalpy value
         * @return this instance in order to stack this class's methods
         */
        public Builder enthalpy(double value) {
            this.enthalpy = value;
            return this;
        }

        /**
         * sets a mass flow value if specified.
         * @param value the mass flow value
         * @return this instance in order to stack this class's methods
         */
        public Builder massFlow(double value) {
            this.massFlow = value;
            return this;
        }

        /**
         * sets an entropy value if specified.
         * @param value the entropy value
         * @return this instance in order to stack this class's methods
         */
        public Builder entropy(double value) {
            this.entropy = value;
            return this;
        }

        /**
         * sets a specific volume value if specified.
         * @param value the specific volume value
         * @return this instance in order to stack this class's methods
         */
        public Builder specificVolume(double value) {
            this.specificVolume = value;
            return this;
        }

        /**
         * constructs a state.
         * @return an instance of a state
         */
        public IState build() {
            return new State(this.pressure, this.temperature, this.enthalpy,
                    this.massFlow, this.entropy, this.specificVolume);
        }
    }
}