class HeatExchanger extends APart {
    State intake;
    State exit;
    State coolantIntake;
    State coolantExit;
    double heatTransfer;
    double entropyProduction;
    double surfaceTemperature;

    HeatExchanger() {
        this.intake = null;
        this.exit = null;
        this.coolantIntake = null;
        this.coolantExit = null;
        this.heatTransfer = 0;
        this.entropyProduction = -1;
        this.surfaceTemperature = 0;
    }

    // calculates enthalpy
    void findMissingEnthalpy() {
        if (this.coolantIntake.enthalpy == 0) {
            this.coolantIntake.enthalpy = ((-this.heatTransfer
                    - this.intake.massFlow * (this.intake.enthalpy - this.exit.enthalpy))
                    / this.coolantExit.massFlow) + this.coolantExit.enthalpy;
        }
        if (this.coolantExit.enthalpy == 0) {
            this.coolantExit.enthalpy = -(((-this.heatTransfer
                    - this.intake.massFlow * (this.intake.enthalpy - this.exit.enthalpy))
                    / this.coolantExit.massFlow) - this.coolantIntake.enthalpy);
        }
        if (this.exit.enthalpy == 0) {
            this.exit.enthalpy = -(((-this.heatTransfer
                    - this.coolantIntake.massFlow * (this.coolantIntake.enthalpy
                    - this.coolantExit.enthalpy))
                    / this.exit.massFlow) - this.intake.enthalpy);
        }
        if (this.intake.enthalpy == 0) {
            this.intake.enthalpy = ((-this.heatTransfer
                    - this.coolantIntake.massFlow * (this.coolantIntake.enthalpy
                    - this.coolantExit.enthalpy))
                    / this.exit.massFlow) + this.exit.enthalpy;
        }
    }

    // calculates energy transfer via heat
    void calculateHeatTransfer() {
        if (this.coolantIntake.enthalpy != 0 && this.coolantExit.enthalpy != 0
                && this.intake.enthalpy != 0 && this.exit.enthalpy != 0 && this.intake.massFlow != -1
                && this.coolantIntake.massFlow != -1) {
            this.heatTransfer = -(this.coolantExit.massFlow
                    * (this.coolantIntake.enthalpy - this.coolantExit.enthalpy)
                    + this.intake.massFlow * (this.intake.enthalpy - this.exit.enthalpy));
        }
        else if (this.entropyProduction != -1 && this.surfaceTemperature != 0
                && this.intake.entropy != 0 && this.exit.entropy != 0 && this.coolantExit.entropy != 0
                && this.coolantIntake.entropy != 0) {
            this.heatTransfer = this.surfaceTemperature
                    * -(this.intake.massFlow * (this.intake.entropy - this.exit.entropy)
                    + this.coolantExit.massFlow * (this.coolantIntake.entropy - this.coolantExit.entropy)
                    + this.entropyProduction);
        }
    }

    // calculates mass flow
    void calculateMassFlow() {
        if (this.heatTransfer != 0 && this.surfaceTemperature != 0 && this.intake.massFlow != -1
                && this.coolantExit.entropy != 0 && this.coolantIntake.entropy != 0
                && this.intake.entropy != 0 && this.exit.entropy != 0 && this.entropyProduction != -1) {
            this.coolantIntake.massFlow = (-(this.heatTransfer / this.surfaceTemperature)
                    - this.intake.massFlow * (this.intake.entropy - this.exit.entropy)
                    - this.entropyProduction) / (this.coolantIntake.entropy - this.coolantExit.entropy);
        }
        else if (this.heatTransfer != 0 && this.surfaceTemperature != 0
                && this.coolantIntake.massFlow != -1 && this.coolantExit.entropy != 0
                && this.coolantIntake.entropy != 0 && this.intake.entropy != 0 && this.exit.entropy != 0
                && this.entropyProduction != -1) {
            this.intake.massFlow = (-(this.heatTransfer / this.surfaceTemperature)
                    - this.coolantIntake.massFlow * (this.coolantIntake.entropy
                    - this.coolantExit.entropy) - this.entropyProduction)
                    / (this.intake.entropy - this.exit.entropy);
        }
    }
}