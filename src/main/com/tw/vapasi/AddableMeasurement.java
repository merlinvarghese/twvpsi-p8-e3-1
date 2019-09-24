package com.tw.vapasi;

class AddableMeasurement extends NonAddableMeasurement {

    AddableMeasurement(double value, Unit unit) {
        super(value, unit);
    }

    static AddableMeasurement cms(double quantity) {
        return new AddableMeasurement(quantity, Unit.CM);
    }

    static AddableMeasurement kms(double quantity) {
        return new AddableMeasurement(quantity, Unit.KM);
    }

    static AddableMeasurement ms(double quantity) {
        return new AddableMeasurement(quantity, Unit.M);
    }

    static AddableMeasurement gm(double quantity) {
        return new AddableMeasurement(quantity, Unit.GM);
    }

    static AddableMeasurement kg(double quantity) {
        return new AddableMeasurement(quantity, Unit.KG);
    }

    AddableMeasurement add(AddableMeasurement other) throws CannotAddException {
        double totalBase = 0.0;
        if (unit.isUnitTypeDifferent(other.unit)) {
            throw new CannotAddException();
        }
        totalBase=unit.convertToBase(this.value)+other.unit.convertToBase(other.value);
        return new AddableMeasurement(unit.convertFromBase(totalBase, this.unit), unit);
    }

    @Override
    public String toString() {
        return "AddableMeasurement{}";
    }
}
