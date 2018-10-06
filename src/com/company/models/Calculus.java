package com.company.models;

import java.util.Objects;

public class Calculus {

    public enum Operations{
        PLUS, MINNUS, TIMES, DIV;
    }

    private Double accNumber;
    private Operations currentOperation;

    public Calculus(Double accNumber, Operations currentOperation) {
        this.accNumber = accNumber;
        this.currentOperation = currentOperation;
    }

    public Calculus() {
        accNumber = 0.0;
        this.currentOperation = Operations.PLUS;
    }

    public Double getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(Double accNumber) {
        this.accNumber = accNumber;
    }

    public Operations getCurrentOperation() {
        return currentOperation;
    }

    public void setCurrentOperation(Operations currentOperation) {
        this.currentOperation = currentOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculus calculus = (Calculus) o;
        return Objects.equals(accNumber, calculus.accNumber) &&
                currentOperation == calculus.currentOperation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accNumber, currentOperation);
    }

    @Override
    public String toString() {
        return "Calculus{" +
                "accNumber=" + accNumber +
                ", currentOperation=" + currentOperation +
                '}';
    }
}
