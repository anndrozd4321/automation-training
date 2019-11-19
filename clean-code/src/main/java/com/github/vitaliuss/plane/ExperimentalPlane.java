package com.github.vitaliuss.plane;

import com.github.vitaliuss.model.ClassificationLevelType;
import com.github.vitaliuss.model.ExperimentalTypes;

public class ExperimentalPlane extends Plane {

    private ExperimentalTypes experimentalType;
    private ClassificationLevelType classificationLevelType;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationLevelType classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevelType = classificationLevelType;
    }

    public ClassificationLevelType getClassificationLevelType(){
        return classificationLevelType;
    }

    public void setClassificationLevel(ClassificationLevelType classificationLevelType){
        this.classificationLevelType = classificationLevelType;
    }

    public void setExperimentalType(ExperimentalTypes experimentalType) {
        this.experimentalType = experimentalType;
    }

    public ExperimentalTypes getExperimentalType() {
        return experimentalType;
    }
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
