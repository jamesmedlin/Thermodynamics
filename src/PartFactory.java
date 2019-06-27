public class PartFactory {

    /**
     * creates an instance of the requested part based on the given type.
     * @param type the type of part to be created
     * @return an instance of the requested part
     * @throws IllegalArgumentException when given an unsupported part type
     */
    public static IPart makePart(String type) throws IllegalArgumentException {
        switch (type) {
            case "Turbine":
                return new Turbine();
            case "Compressor":
                return new Compressor();
            case "Heat Exchanger":
                return new HeatExchanger();
            default:
                throw new IllegalArgumentException("This part type is unsupported.");
        }
    }
}C
