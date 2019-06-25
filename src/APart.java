abstract class APart implements IPart {
    State intake;
    State exit;

    APart() {
        this.intake = null;
        this.exit = null;
    }


    void findMissingPressOrTemp() {
        double basecase = -1000;
        if (intake.pressure == basecase) {
            intake.pressure = exit.pressure * intake.temperature / exit.temperature;
        }
        if (intake.temperature == basecase) {
            intake.temperature = intake.pressure * exit.temperature / exit.pressure;
        }
        if (exit.pressure == basecase) {
            exit.pressure = intake.pressure * exit.temperature / intake.temperature;
        }
        if (exit.temperature == basecase) {
            exit.temperature = exit.pressure * intake.temperature / intake.pressure;
        }
    }
}