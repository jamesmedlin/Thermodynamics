import java.util.HashMap;

public class Model implements IModel {
    HashMap<String, IPart> parts;
    boolean isIdealGas;

    Model() {
        this.parts = new HashMap<>();
        this.isIdealGas = true;
    }

    @Override
    public void addPart(String name, String type) {
        if (!parts.containsKey(name)) {
            parts.put(name, PartFactory.makePart(type));
        } else {
            throw new IllegalArgumentException("Part name already exists in this system.");
        }
    }

    @Override
    public void removePart(String name) {
        if (parts.containsKey(name)) {
            parts.remove(name);
        } else {
            throw new IllegalArgumentException("Part name does not exist in this system.");
        }
    }

    @Override
    public void connectParts(String name1, String name2) {
        if (parts.containsKey(name1) && parts.containsKey(name2)) {
            if (parts.get(name1).getExit() != null &&
            parts.get(name2).getInlet() != null) {
                parts.get(name2).setInlet(parts.get(name1).getExit());
            } else if (parts.get(name2).getInlet() != null) {
                parts.get(name1).setExit(parts.get(name2).getInlet());
            } else if (parts.get(name1).getExit() != null) {
                parts.get(name2).setInlet(parts.get(name1).getExit());
            } else {
                throw new IllegalArgumentException("Both the inlet and outlet are null.");
            }
        }
        else {
            throw new IllegalArgumentException("Both shape names must be valid.");
        }
    }
}
