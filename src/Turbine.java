class Turbine extends APart {
    State intake;
    State exit;
    double work;
    double entropyProduction;

    Turbine() {
        super();
        this.work = 0;
        this.entropyProduction = -1;
    }

    void matchFlows() {
        if (this.intake.massFlow == -1 && this.exit.massFlow != -1) {
            this.intake.massFlow = this.exit.massFlow;
        }
        else if (this.exit.massFlow == -1 && this.intake.massFlow != -1) {
            this.exit.massFlow = this.intake.massFlow;
        }
    }

    void calculateWork() {
        if (intake.massFlow != -1 && this.intake.enthalpy != 0 && this.exit.enthalpy != 0) {
            this.work = this.intake.massFlow * (this.intake.enthalpy - this.exit.enthalpy);
        }
        else if (this.intake.pressure != -1000 && this.intake.specificVolume != 0
                && this.exit.specificVolume != 0) {
            this.work = this.intake.pressure * (this.exit.specificVolume - this.intake.specificVolume);
        }
    }


}