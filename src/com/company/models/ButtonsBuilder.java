package com.company.models;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonsBuilder {

    List<JButton> buttons;

    public ButtonsBuilder(List<JButton> buttons) {
        this.buttons = buttons;
    }

    public ButtonsBuilder() {
        buttons = new ArrayList<>();
    }

    public ButtonsBuilder add(JButton button){
        buttons.add(button);
        return new ButtonsBuilder(buttons);
    }

    public ButtonsBuilder add (String buttonText){
        JButton button = new JButton();
        button.setText(buttonText);
        buttons.add(button);
        return new ButtonsBuilder(buttons);
    }
    public List<JButton> build(){
        return buttons;
    }
}
