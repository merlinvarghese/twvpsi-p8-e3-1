package com.tw.vapasi;

public enum Unit {
    CM(1, UnitType.LENGTH,0),
    M(100, UnitType.LENGTH,0),
    KM(100000, UnitType.LENGTH,0),
    GM(1, UnitType.WEIGHT,0),
    KG(1000, UnitType.WEIGHT,0),
    C(1,UnitType.TEMPERATURE,0),
    F(1,UnitType.TEMPERATURE,-32),
    K(1,UnitType.TEMPERATURE,-273.0);

    enum UnitType {
        LENGTH,
        WEIGHT,
        TEMPERATURE;
    }

    private double conversionFactor;
    private UnitType type;
    private double offset;

    Unit(double conversionFactor, UnitType type,double offset) {
        this.conversionFactor = conversionFactor;
        this.type = type;
        this.offset=offset;
    }

    double convertToBase(double value) {
        return (value * this.conversionFactor)+offset;
    }

    double convertFromBase(double value, Unit unit) {
        return (value/unit.conversionFactor)- offset;
    }

    boolean isUnitTypeDifferent(Unit unit) {
          return this.type != unit.type;
    }
}

