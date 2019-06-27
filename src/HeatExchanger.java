
/**
 * this represents a heat exchanger in the
 */
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
        if (this.coolantIntake.getEnthalpy() == 0) {
            this.coolantIntake.setEnthalpy(((-this.heatTransfer
                    - this.intake.getMassFlow() * (this.intake.getEnthalpy()
                    - this.exit.getEnthalpy())) / this.coolantExit.getMassFlow())
                    + this.coolantExit.getEnthalpy());
        }
        if (this.coolantExit.getEnthalpy() == 0) {
            this.coolantExit.setEnthalpy( -(((-this.heatTransfer
                    - this.intake.getMassFlow() * (this.intake.getEnthalpy()
                    - this.exit.getEnthalpy())) / this.coolantExit.getMassFlow())
                    - this.coolantIntake.getEnthalpy()));
        }
        if (this.exit.getEnthalpy() == 0) {
            this.exit.setEnthalpy( -(((-this.heatTransfer
                    - this.coolantIntake.getMassFlow() * (this.coolantIntake.getEnthalpy()
                    - this.coolantExit.getEnthalpy()))
                    / this.exit.getMassFlow()) - this.intake.getEnthalpy()));
        }
        if (this.intake.getEnthalpy() == 0) {
            this.intake.setEnthalpy(((-this.heatTransfer
                    - this.coolantIntake.getMassFlow() * (this.coolantIntake.getEnthalpy()
                    - this.coolantExit.getEnthalpy()))
                    / this.exit.getMassFlow()) + this.exit.getEnthalpy());
        }
    }

    // calculates energy transfer via heat
    void calculateHeatTransfer() {
        if (this.coolantIntake.getEnthalpy() != 0 && this.coolantExit.getEnthalpy() != 0
                && this.intake.getEnthalpy() != 0 && this.exit.getEnthalpy() != 0
                && this.intake.getMassFlow() != -1 && this.coolantIntake.getMassFlow() != -1) {
            this.heatTransfer = -(this.coolantExit.getMassFlow()
                    * (this.coolantIntake.getEnthalpy() - this.coolantExit.getEnthalpy())
                    + this.intake.getMassFlow() * (this.intake.getEnthalpy()
                    - this.exit.getEnthalpy()));
        }
        else if (this.entropyProduction != -1 && this.surfaceTemperature != 0
                && this.intake.getEntropy() != 0 && this.exit.getEntropy() != 0
                && this.coolantExit.getEntropy() != 0 && this.coolantIntake.getEntropy() != 0) {
            this.heatTransfer = this.surfaceTemperature
                    * -(this.intake.getMassFlow() * (this.intake.getEntropy()
                    - this.exit.getEntropy()) + this.coolantExit.getMassFlow()
                    * (this.coolantIntake.getEntropy() - this.coolantExit.getEntropy())
                    + this.entropyProduction);
        }
    }

    // calculates mass flow
    void calculateMassFlow() {
        if (this.heatTransfer != 0 && this.surfaceTemperature != 0
                && this.intake.getMassFlow() != -1 && this.coolantExit.getEntropy() != 0
                && this.coolantIntake.getEntropy() != 0 && this.intake.getEntropy() != 0
                && this.exit.getEntropy() != 0 && this.entropyProduction != -1) {
            this.coolantIntake.setMassFlow((-(this.heatTransfer / this.surfaceTemperature)
                    - this.intake.getMassFlow() * (this.intake.getEntropy()
                    - this.exit.getEntropy()) - this.entropyProduction)
                    / (this.coolantIntake.getEntropy() - this.coolantExit.getEntropy()));
        }
        else if (this.heatTransfer != 0 && this.surfaceTemperature != 0
                && this.coolantIntake.getMassFlow() != -1 && this.coolantExit.getEntropy() != 0
                && this.coolantIntake.getEntropy() != 0 && this.intake.getEntropy() != 0
                && this.exit.getEntropy() != 0 && this.entropyProduction != -1) {
            this.intake.setMassFlow((-(this.heatTransfer / this.surfaceTemperature)
                    - this.coolantIntake.getMassFlow() * (this.coolantIntake.getEntropy()
                    - this.coolantExit.getEntropy()) - this.entropyProduction)
                    / (this.intake.getEntropy() - this.exit.getEntropy()));
        }
    }
}