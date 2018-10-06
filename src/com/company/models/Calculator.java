package com.company.models;

import java.awt.*;

public interface Calculator {

    void validate();
    void resize(Integer width, Integer height);
    void buttonResize(String text, Integer... dimension);
    void TextFieldResize(Integer... dimensions);
    void configure(String title, LayoutManager... layoutManagers);
    void handleButtons();

}
