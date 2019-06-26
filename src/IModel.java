public interface IModel {

    /**
     * adds a Part of the given type to the system with its unique name.
     * @param name the unique identifier of this Part
     * @param type the type of part being created
     */
    void addPart(String name, String type);

    /**
     * removes a Part from the system.
     * @param name the unique identifier of any Part
     */
    void removePart(String name);

    /**
     * connects the exit of the first part to the inlet of the second part,
     * essentially sharing the state between the parts.
     * @param name1 the part with the exit state
     * @param name2 the part with the inlet state
     */
    void connectParts(String name1, String name2);
}
