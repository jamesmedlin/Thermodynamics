

/**
 * represents a part in the system.
 */
abstract class APart implements IPart {
    State intake;
    State exit;
    double work;
    double heatTranfer;

    APart() {
        this.intake = null;
        this.exit = null;
    }

    void findMissingPressOrTemp() {
        double basecase = -1000;
        if (intake.getPressure() == basecase) {
            intake.setPressure(exit.getPressure() * intake.getTemperature() / exit.getTemperature());
        }
        if (intake.getTemperature() == basecase) {
            intake.setTemperature(intake.getPressure() * exit.getTemperature() / exit.getPressure());
        }
        if (exit.getPressure() == basecase) {
            exit.setPressure( intake.getPressure() * exit.getTemperature() / intake.getTemperature());
        }
        if (exit.getTemperature() == basecase) {
            exit.setTemperature(exit.getPressure() * intake.getTemperature() / intake.getPressure());
        }
    }
}