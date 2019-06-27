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

### Methods
- `setInlet(IState)` sets the inlet of this part to the given state
- `setExit(IState)` sets the exit of this part to the given state
- `getInlet()` retrieves the inlet of this part
- `getExit()` retrieves the exit of this part
- `setWork(double)` sets the work in or out of a part to the given value
- `setHeatTransfer(double)` sets the heat energy transferred to or from this part to the given value
- `getWork()` retrieves the work value of this part
- `getHeatTransfer()` retrieves the value of heat energy of this part

## PartFactory 
Loosely couples the class hierarchy. 
Supported `Parts` include:
- `Turbine`
- `Compressor`
- `Heat Exchanger`

## PartType
This `enum` class consists of parts that are supported by this program. Currently supports `Turbine`, `Compressor`, and `Heat Exchanger`.

## APart
The `abstract` class for parts. Some calculations are standard across the board for all parts. These calculations will be based here.

### Fields
- IState `inlet`
- IState `exit`
- double `work`
- double `heatTransfer`

## Turbine
This implementation that `extends APart` is typically used for energy generation.

## Compressor
This implementation that `extends APart` is typically used to input energy into the system fro an external source.

## HeatExchanger 
This implementation that `extends APart` is typically used to release heat energy from the system.


# IState/IReadOnlyState
This `interface` represents the state of an inlet or exit to or from a part. Essentially the structure that links parts.

### Methods
The `IState` interface has setter methods and extends `IReadOnlyState` to inherit getter methods.
- `setPressure(double)` sets the pressure to the given value
- `setTemperature(double)` sets the temperature to the given value
- `setEnthalpy(double)` sets the enthalpy to the given value
- `setMassFlow(double)` sets the mass flow rate to the given value
- `setEntropy(double)` sets the entropy to the given value
- `setSpecificVolume(double)` sets the specific volume to the given value
The `IReadOnlyState` interface only has getters that deep copy (defensive copying) anything returned, but since all are doubles, there is no need to make copies since these types are inherently immutable.
- `getPressure()` retrieves the temperature value
- `getTemperature()` retrieves the temperature value
- `getEnthalpy()` retrieves the enthalpy value
- `getMassFlow()` retrieves the mass flow rate value
- `getEntropy()` retrieves the entropy value
- `getSpecificVolume()` retrieves the specific volume value

## State
This implements `IState` and is a field in any `Part` that has these specific state values. A `builder pattern` is used in this class.

### Fields
- double `pressure`
- double `temperature`
- double `enthalpy`
- double `massFlow`
- double `entropy`
- double `specificVolume`

### Builder
This `static` class is intended to allow for any given number of values to be specified and the rest defaulted to predetermined values.
#### Methods
- `pressure(double)` sets the pressure value
- `temperature(double)` sets the temperature value
- `enthalpy(double)` sets the enthalpy value
- `massFlow(double)` sets the mass flow rate value
- `entropy(double)` sets the entropy value
- `specificVolume(double)` sets the specific volume value
- `build()` constructs an instance of `IState`


