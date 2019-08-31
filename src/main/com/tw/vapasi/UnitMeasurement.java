package com.tw.vapasi;

import java.util.Objects;

class UnitMeasurement {


    private static final int M_To_CM = 100;
    private static final int KM_TO_CM = 100000;


    private final double value;
    private final Units unit;

    public enum Units {
        KM,
        CM,
        M
    }

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

    private double convertToCM() {
        switch (this.unit) {
            case M:
                return this.value * M_To_CM;
            case KM:
                return this.value * KM_TO_CM;
            default:
                return this.value;
        }

    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj)
            return true;
        if (otherObj == null || this.getClass() != otherObj.getClass())
            return false;
        return this.convertToCM() == ((UnitMeasurement) otherObj).convertToCM();

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

}
