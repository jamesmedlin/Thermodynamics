class IdealGas extends ThermoSystem {
    State intake;
    State exit;

    IdealGas(State intake, State exit) {
        this.intake = intake;
        this.exit = exit;
    }

}