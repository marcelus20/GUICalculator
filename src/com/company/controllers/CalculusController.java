package com.company.controllers;

import com.company.models.Calculus;

public class CalculusController {
    private Calculus calculus;

    public CalculusController() {
        calculus = new Calculus();
    }

    public static CalculusController calculusController(){
        return new CalculusController();
    }

    public void calculate(Calculus.Operations currentOperation, Double value){
        if(currentOperation == Calculus.Operations.PLUS){
            calculus.setAccNumber(calculus.getAccNumber()+value);
        }else if(currentOperation == Calculus.Operations.MINNUS){
            calculus.setAccNumber(calculus.getAccNumber()-value);
        }else if(currentOperation == Calculus.Operations.TIMES){
            calculus.setAccNumber(calculus.getAccNumber()*value);
        }else{
            calculus.setAccNumber(calculus.getAccNumber()/value);
        }

    }

    public Double getAccNumber(){
        return calculus.getAccNumber();
    }

    public Calculus.Operations getCurrentOperation(){
        return calculus.getCurrentOperation();
    }

    public void setCurrentOperation(Calculus.Operations operation){
        calculus.setCurrentOperation(operation);
    }
    public void setAccNumber(Double accNumber){
        calculus.setAccNumber(accNumber);
    }
}
