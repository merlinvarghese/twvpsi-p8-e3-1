package com.tw.vapasi;
class UnitMeasurement {


    private static final int HUNDRED = 100;
    private static final int THOUSAND = 1000;
    private static final int TENTHOUSAND = 10000;
    private static final int ONE = 1;

    int value;
    String unit;

    UnitMeasurement(int value, String unit) {
        this.value = value;
        this.unit = unit;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    Boolean convertFromMeter(UnitMeasurement obj) {
        if (this.unit.equals("cm") && this.value == HUNDRED && obj.value == ONE)
            return true;

        if (this.unit.equals("km") && this.value == THOUSAND && obj.value == ONE)
            return true;

        return false;
    }

    Boolean convertFromKilometer(UnitMeasurement obj) {
        if (this.unit.equals("m")  && this.value == THOUSAND && obj.value == ONE)
            return true;
        if (this.unit.equals("cm")  && this.value == TENTHOUSAND && obj.value == ONE)
            return true;
        return false;
    }

    Boolean convertFromCm(UnitMeasurement obj) {
        if (this.unit.equals("m") && this.value == ONE && obj.value == ONE)
            return true;

        if (this.unit.equals("km") && this.value == ONE && obj.value == ONE)
            return true;
        return false;
    }


    boolean compare(UnitMeasurement obj) {
        switch (obj.unit) {
            case "m":
                return convertFromMeter(obj);
            case "km":
                return convertFromKilometer(obj);
            case "cm":
                return convertFromCm(obj);
            default:
                return true;
        }
    }

    private boolean FromMeter(String cm, int i) {
        if (this.unit == cm)
            if (i == 1)
                return true;
        return false;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        return compare((UnitMeasurement) obj);


    }
}
