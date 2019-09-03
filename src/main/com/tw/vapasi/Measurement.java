package com.tw.vapasi;

import java.util.Objects;

class Measurement {
    private final double value;
    private final Units unit;
    private final UnitType type;

    enum UnitType {
        LENGTH,
        WEIGHT;
    }

    private Measurement(double value, Units unit, UnitType type) {
        this.value = value;
        this.unit = unit;
        this.type = type;
    }

    static Measurement cms(double quantity) {
        return new Measurement(quantity, Units.CM, UnitType.LENGTH);
    }

    static Measurement kms(double quantity) {
        return new Measurement(quantity, Units.KM, UnitType.LENGTH);
    }

    static Measurement ms(double quantity) {
        return new Measurement(quantity, Units.M, UnitType.LENGTH);
    }

    static Measurement gm(double quantity) {
        return new Measurement(quantity, Units.GM, UnitType.WEIGHT);
    }

    static Measurement kg(double quantity) {
        return new Measurement(quantity, Units.KG, UnitType.WEIGHT);
    }

    private double convertToBase() {
        return this.unit.convertToBase(this.value);
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj)
            return true;
        if (otherObj == null || this.getClass() != otherObj.getClass())
            return false;
        if(!(this.type == ((Measurement)otherObj).type))
            return false;

        return this.convertToBase() == ((Measurement) otherObj).convertToBase();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }
}
