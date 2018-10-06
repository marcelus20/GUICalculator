package com.company;

import com.company.controllers.GuiController;
import com.company.views.GuiView;

public class Main{

    public static void main(String... args){
       GuiView.buildCalculator(new GuiController());
    }
}

