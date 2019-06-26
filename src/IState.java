public interface IState extends IReadOnlyState {

    /**
     * sets the pressure of this state.
     * @param value the pressure value
     */
    void setPressure(double value);

    /**
     * sets the temperature of this state.
     * @param value the temperature value
     */
    void setTemperature(double value);

    /**
     * sets the enthalpy of this state.
     * @param value the enthalpy value
     */
    void setEnthalpy(double value);

    /**
     * sets the mass flow rate at this state.
     * @param value the mass flow rate value
     */
    void setMassFlow(double value);

    /**
     * sets the entropy of this state.
     * @param value the entropy value
     */
    void setEntropy(double value);

    /**
     * sets the specific volume of this state.
     * @param value the entropy value
     */
    void setSpecificVolume(double value);
}
