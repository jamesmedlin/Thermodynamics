# ThermodynamicsProject

# IModel
This `interface` represents a chain of parts in sequence for the purpose of being thermodynamically analyzed.
This system is comprised of parts, seperated by states, designed to be mutable to conistently have one part's exit be the next part's inlet.

Methods:
- `addPart(String name, PartType type)` which adds a `Part` of the given type to the current system with the given name.
- `removePart(String name)` which removes the `Part` with the given name.
- `connectParts(String name1, String name2)` which connects the exit of the first `Part` to the inlet of the second `Part`.

## Model
This implementation of the `IModel` interface contains the parts and their respective states.

### Fields: 
- HashMap<String, APart> `chain`
- boolean `isIdealGas` which determines the neccessary type of calculations specifically for this system.


# IPart
This `interface` represents parts in a system, consisting of inlet and exit states. Each `Part` has its respective characteristics which may involve specific calculations depending on its type.

## PartFactory 
Loosely couples the class hierarchy. 

## PartType
This `enum` class consists of parts that are supported by this program.

## APart
The `abstract` class for parts. Some calculations are standard across the board for all parts. These calculations will be based here.

### Fields
- HashMap<int, IState> `inlet`
- HashMap<int, IState> `exit`
- double `work`
- double `heatTransfer`

## Turbine
This implementation is typically used for energy generation.

## Compressor
This implementation is typically used to input energy into the system fro an external source.

## HeatExchanger 
This implementation is typically used to release heat energy from the system.


# IState/IReadOnlyState
This `interface` represents the state of an inlet or exit to or from a part. Essentially the structure that links parts.

### Methods
The `IState` interface has setter methods and extends `IReadOnlyState` to inherit getter methods.
- `setPressure(double)`
- `setTemperature(double)`
- `setEnthalpy(double)`
- `setMassFlow(double)`
- `setEntropy(double)`
- `setSpecificVolume(double)`
The `IReadOnlyState` interface only has getters that deep copy (defensive copying) anything returned, but since all are doubles, there is no need to make copies since these types are inherently immutable.
- `getPressure()`
- `getTemperature()`
- `getEnthalpy()`
- `getMassFlow()`
- `getEntropy()`
- `getSpecificVolume()`

## StateImpl
This implements `IState` and is a field in any `Part` that has these specific state values.

### Fields
- double `pressure`
- double `temperature`
- double `enthalpy`
- double `massFlow`
- double `entropy`
- double `specificVolume`

