public interface IReadOnlyState {
    /**
     * retrieves the pressure of this state.
     * @return pressure value
     */
    double getPressure();

    /**
     * retrieves the temperature of this state.
     * @return temperature value
     */
    double getTemperature();

    /**
     * retrieves the enthalpy of this state.
     * @return the enthalpy value
     */
    double getEnthalpy();

    /**
     * retrieves the mass flow rate at this state.
     * @return the mass flow rate value
     */
    double getMassFlow();

    /**
     * retrieves the entropy of this state.
     * @return the entropy value
     */
    double getEntropy();

    /**
     * retrieves the specific volume of this state.
     * @return the entropy value
     */
    double getSpecificVolume();
}
