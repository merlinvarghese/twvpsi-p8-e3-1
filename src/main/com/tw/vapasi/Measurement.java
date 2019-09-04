package com.tw.vapasi;

import java.util.Objects;

class Measurement {
    private final double value;
    private final Unit unit;
    //private final UnitType type;
    //private final Units.UnitType type;

    private Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
        //this.type = type;
    }

    static Measurement cms(double quantity) {
        return new Measurement(quantity, Unit.CM);
    }

    static Measurement kms(double quantity) {
        return new Measurement(quantity, Unit.KM);
    }

    static Measurement ms(double quantity) {
        return new Measurement(quantity, Unit.M);
    }

    static Measurement gm(double quantity) {
        return new Measurement(quantity, Unit.GM);
    }

    static Measurement kg(double quantity) {
        return new Measurement(quantity, Unit.KG);
    }

    static Measurement c(double quantity) {
        return new Measurement(quantity, Unit.C);
    }

    static Measurement f(double quantity) {
        return new Measurement(quantity, Unit.F);
    }

    static Measurement k(double quantity) {
        return new Measurement(quantity, Unit.K);
    }

    Measurement add(Measurement other) throws CannotAddException {
        double totalBase = 0.0;
        if (unit.isUnitTypeDifferent(other.unit)) {
            throw new CannotAddException();
        }
        totalBase=unit.convertToBase(this.value)+other.unit.convertToBase(other.value);
        return new Measurement(unit.convertFromBase(totalBase, this.unit), unit);

    }

    @Override
    public boolean equals(Object otherObj) {
        if (this == otherObj) {
            return true;
        }

        if (otherObj == null || this.getClass() != otherObj.getClass()) {
            return false;
        }
        Measurement other = (Measurement) otherObj;
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
        return "Measurement{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }
}
