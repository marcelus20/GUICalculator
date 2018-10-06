package com.company.views;

import com.company.controllers.GuiController;

import java.awt.*;

public class GuiView {



    public static void buildCalculator(GuiController guiController){
        guiController.handleButtons();
        guiController.configure("My Calculator", new GridLayout(5,4), new BorderLayout());
        guiController.validate(); guiController.resize(300,400); guiController.TextFieldResize(250, 70);
        guiController.getGuiModel().getTxtFieldPanel().add(guiController.getGuiModel().getTxtField());
        guiController.getGuiModel().getButtons().forEach(button->guiController.getGuiModel().getPanelButton().add(button));
        guiController.getGuiModel().getMainFrame().add(guiController.getGuiModel().getTxtField(), BorderLayout.NORTH);
        guiController.getGuiModel().getMainFrame().add(guiController.getGuiModel().getPanelButton(), BorderLayout.CENTER);

    }

}
