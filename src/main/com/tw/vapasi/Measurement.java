package com.tw.vapasi;

import java.util.Objects;

class Measurement {
    private final double value;
    private final Units unit;

    private Measurement(double value, Units unit) {
        this.value = value;
        this.unit = unit;
    }

    static Measurement cms(double quantity) {
        return new Measurement(quantity, Units.CM);
    }

    static Measurement kms(double quantity) {
        return new Measurement(quantity, Units.KM);
    }

    static Measurement ms(double quantity) {
        return new Measurement(quantity, Units.M);
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
        return this.convertToBase() == ((Measurement) otherObj).convertToBase();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }
}
