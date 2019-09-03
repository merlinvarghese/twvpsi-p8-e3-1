package com.tw.vapasi;

import java.util.Objects;

class UnitMeasurement {


    private final double value;
    private final Units unit;

    private UnitMeasurement(double value, Units unit) {
        this.value = value;
        this.unit = unit;
    }

    static UnitMeasurement cms(double quantity) {
        return new UnitMeasurement(quantity, Units.CM);
    }

    static UnitMeasurement kms(double quantity) {
        return new UnitMeasurement(quantity, Units.KM);
    }

    static UnitMeasurement ms(double quantity) {
        return new UnitMeasurement(quantity, Units.M);
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
        return this.convertToBase() == ((UnitMeasurement) otherObj).convertToBase();

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }


}
