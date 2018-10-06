package com.company.models;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class GuiModel {

    private JFrame mainFrame;
    private JTextField txtField;
    private List<JButton> buttons;
    private JPanel panelButton;
    private JPanel txtFieldPanel;

    public GuiModel(JFrame mainFrame, JTextField txtField, List<JButton> buttons, JPanel panelButton, JPanel txtFieldPanel) {
        this.mainFrame = mainFrame;
        this.txtField = txtField;
        this.buttons = buttons;
        this.panelButton = panelButton;
        this.txtFieldPanel = txtFieldPanel;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public JTextField getTxtField() {
        return txtField;
    }

    public List<JButton> getButtons() {
        return buttons;
    }

    public JPanel getPanelButton() {
        return panelButton;
    }

    public JPanel getTxtFieldPanel() {
        return txtFieldPanel;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void setTxtField(JTextField txtField) {
        this.txtField = txtField;
    }

    public void setButtons(List<JButton> buttons) {
        this.buttons = buttons;
    }

    public void setPanelButton(JPanel panelButton) {
        this.panelButton = panelButton;
    }

    public void setTxtFieldPanel(JPanel txtFieldPanel) {
        this.txtFieldPanel = txtFieldPanel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuiModel guiModel = (GuiModel) o;
        return Objects.equals(mainFrame, guiModel.mainFrame) &&
                Objects.equals(txtField, guiModel.txtField) &&
                Objects.equals(buttons, guiModel.buttons) &&
                Objects.equals(panelButton, guiModel.panelButton) &&
                Objects.equals(txtFieldPanel, guiModel.txtFieldPanel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainFrame, txtField, buttons, panelButton, txtFieldPanel);
    }


}
