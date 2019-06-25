//import java.io.FileNotFoundException;
//
//class ThermoExamples {
//    ThermoSystem system1;
//    State s1;
//    State s2;
//    Turbine turbine;
//
//    void initSystem() {
//        system1 = new ThermoSystem();
//        s1 = new State();
//        s2 = new State();
//        turbine = new Turbine();
//        turbine.intake = s1;
//        turbine.exit = s2;
//        system1.parts.add(turbine);
//    }
//
////  boolean testFindMissingPressOrTemp(Tester t) {
//////    this.initSystem();
//////    s1.pressure = 1;
//////    s1.temperature = 273.15;
//////    s2.pressure= 2.5;
//////    system1.findMissingPressOrTemp();
//////    return t.checkExpect(s2.temperature, 682.875);
//////  }
//
//    boolean testCalculateWork(Tester t) {
//        this.initSystem();
//        this.s1.enthalpy = 250.0;
//        this.s2.enthalpy = 64;
//        this.s1.massFlow = 10;
//        this.turbine.matchFlows();
//        this.turbine.calculateWork();
//        return t.checkExpect(this.turbine.work, 0);
//    }
//
//    boolean testFindEnthalpy(Tester t) throws FileNotFoundException {
//        TableSearcher ts1 = new TableSearcher();
//        TableSearcher ts2 = new TableSearcher();
//        ts1.findProperty(290, 74.36);
//        ts2.findProperty(0.01, 0.00611);
//        return t.checkExpect(ts1.liquidSpecificVolume, 0.0013656)
//                && t.checkExpect(ts1.vaporSpecificVolume, 0.02557)
//                && t.checkExpect(ts1.liquidInternalEnergy, 1278.9)
//                && t.checkExpect(ts1.vaporInternalEnergy, 2576.0)
//                && t.checkExpect(ts1.liquidEnthalpy, 1289.1)
//                && t.checkExpect(ts1.vaporEnthalpy, 2766.2)
//                && t.checkExpect(ts1.liquidEntropy, 3.1594)
//                && t.checkExpect(ts1.vaporEntropy, 5.7821)
//                && t.checkExpect(ts2.liquidSpecificVolume, 0.0010002)
//                && t.checkExpect(ts2.vaporSpecificVolume, 206.136)
//                && t.checkExpect(ts2.liquidInternalEnergy, 0.0)
//                && t.checkExpect(ts2.vaporInternalEnergy, 2375.3)
//                && t.checkExpect(ts2.liquidEnthalpy, 0.01)
//                && t.checkExpect(ts2.vaporEnthalpy, 2501.4)
//                && t.checkExpect(ts2.liquidEntropy, 0.0)
//                && t.checkExpect(ts2.vaporEntropy, 9.1562);
//    }
//}