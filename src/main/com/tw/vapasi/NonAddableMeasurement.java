package com.tw.vapasi;

import java.util.Objects;

class NonAddableMeasurement {
    protected final double value;
    protected final Unit unit;

    NonAddableMeasurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }



    static NonAddableMeasurement c(double quantity) {
        return new NonAddableMeasurement(quantity, Unit.C);
    }

    static NonAddableMeasurement f(double quantity) {
        return new NonAddableMeasurement(quantity, Unit.F);
    }

    static NonAddableMeasurement k(double quantity) {
        return new NonAddableMeasurement(quantity, Unit.K);
    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) {
            return true;
        }
        if (otherObj == null || this.getClass() != otherObj.getClass()) {
            return false;
        }
        NonAddableMeasurement other = (NonAddableMeasurement) otherObj;
        if (this.unit.isUnitTypeDifferent(other.unit)) {
            return false;
        }
        return this.unit.convertToBase(this.value) == other.unit.convertToBase(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public String toString() {
        return "NonAddableMeasurement{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
