class Turbine extends APart {
    State intake;
    State exit;
    double work;

    Turbine() {
        super();
        this.work = 0;
    }

    void matchFlows() {
        if (this.intake.getMassFlow() == -1 && this.exit.getMassFlow() != -1) {
            this.intake.setMassFlow(this.exit.getMassFlow());
        }
        else if (this.exit.getMassFlow() == -1 && this.intake.getMassFlow() != -1) {
            this.exit.setMassFlow(this.intake.getMassFlow());
        }
    }

    void calculateWork() {
        if (intake.getMassFlow() != -1 && this.intake.getEnthalpy() != 0 && this.exit.getEnthalpy() != 0) {
            this.work = this.intake.getMassFlow() * (this.intake.getEnthalpy() - this.exit.getEnthalpy());
        }
        else if (this.intake.getPressure() != -1000 && this.intake.getSpecificVolume() != 0
                && this.exit.getSpecificVolume() != 0) {
            this.work = this.intake.getPressure() * (this.exit.getSpecificVolume() - this.intake.getSpecificVolume());
        }
    }


}