package com.github.vitaliuss.plane;

import com.github.vitaliuss.model.TypeOfMilitaryPlane;
import java.util.Objects;

public class MilitaryPlane extends Plane{

    private TypeOfMilitaryPlane typeOfMilitaryPlane;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, TypeOfMilitaryPlane typeOfPlane) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.typeOfMilitaryPlane = typeOfPlane;
    }

    public TypeOfMilitaryPlane getType() {
        return typeOfMilitaryPlane;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + typeOfMilitaryPlane +
                '}');
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MilitaryPlane) || !super.equals(object)) return false;
        return typeOfMilitaryPlane == ((MilitaryPlane) object).typeOfMilitaryPlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeOfMilitaryPlane);
    }
}
