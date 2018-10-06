package com.company.controllers;
import com.company.models.ButtonsBuilder;
import com.company.models.Calculator;
import com.company.models.Calculus;
import com.company.models.GuiModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiController implements Calculator {

    private GuiModel guiModel;
    public static CalculusController brain = CalculusController.calculusController();
    private Boolean clear = false;

    public GuiController(GuiModel guiModel) {
        this.guiModel = guiModel;

    }

    public GuiController() {
        GuiModel guiModel = new GuiModel(new JFrame(), new JTextField(), new ArrayList<>(), new JPanel(), new JPanel());
        this.guiModel = guiModel;
    }

    @Override
    public void validate() {
        guiModel.getMainFrame().validate();
        guiModel.getMainFrame().repaint();
        guiModel.getMainFrame().setVisible(true);
        guiModel.getTxtField().setEditable(false);
    }

    @Override
    public void resize(Integer width, Integer height) {
        guiModel.getMainFrame().setSize(width, height);
    }

    @Override
    public void buttonResize(String text, Integer... dimension) {
        guiModel.getButtons().forEach(button->{

            try{
                button.setPreferredSize(new Dimension(dimension[0], dimension[1]));
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Not fed enough integers values for dimension");
                button.setPreferredSize(new Dimension(100, 100));
            }
            button.setText(text);
        });
    }

    @Override
    public void TextFieldResize(Integer... dimension) {

        try{
            guiModel.getTxtField().setPreferredSize(new Dimension(dimension[0], dimension[1]));
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Not fed enough integers values for dimension");
            guiModel.getTxtField().setPreferredSize(new Dimension(100, 100));
        }


    }

    @Override
    public void configure(String title, LayoutManager... layoutManagers) {
        System.out.println(title);
        guiModel.getMainFrame().setTitle(title);

        guiModel.getPanelButton().setLayout(layoutManagers[0]);
        if(layoutManagers.length == 2) {
            guiModel.getMainFrame().setLayout(layoutManagers[1]);
        }

    }

    @Override
    public void handleButtons() {
        ButtonsBuilder buttonsBuilder = new ButtonsBuilder().add("CE").add("C").add("<=").add("/");
        for(int i = 9 ; i > 0; i--){
            buttonsBuilder.add(String.valueOf(i));
            if(i == 7){
                buttonsBuilder.add("x");
            }else if (i == 4){
                buttonsBuilder.add("-");
            }else if (i == 1){
                buttonsBuilder.add("+");
            }
        }
        buttonsBuilder.add("+/-").add(".").add("0").add("=");



        guiModel.setButtons(buttonsBuilder.build());

        guiModel.getButtons().forEach(b->{


            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(b.getText().equals("+")){
                        clear = true;
                        brain.setCurrentOperation(Calculus.Operations.PLUS);
                        calculate();
                        updateScree(brain.getAccNumber());
                    }else if(b.getText().equals("-")){
                        clear = true;
                        calculate();
                        brain.setCurrentOperation(Calculus.Operations.MINNUS);
                        updateScree(brain.getAccNumber());
                    }else if (b.getText().equals("x")){
                        clear = true;
                        calculate();
                        brain.setCurrentOperation(Calculus.Operations.TIMES);
                        updateScree(brain.getAccNumber());
                    }else if (b.getText().equals("/")){
                        clear = true;
                        calculate();
                        brain.setCurrentOperation(Calculus.Operations.DIV);
                        updateScree(brain.getAccNumber());
                    }else if (b.getText().equals("=")){
                        clear = true;
                        calculate();
                        updateScree(brain.getAccNumber());
                        brain.setAccNumber(0.0);
                    }else if (b.getText().equals("CE")){
                        brain.setAccNumber(0.0);
                        clearScreen();
                    }else if (b.getText().equals("C")){
                        clearScreen();
                    }else if (b.getText().equals("<=")){
                        try{
                            guiModel.getTxtField()
                                    .setText(guiModel
                                            .getTxtField().getText().substring(0,guiModel.getTxtField().getText().length()-1));

                        }catch(Exception error){
                            guiModel.getTxtField().setText("");
                        }
                    }else if (b.getText().equals("+/-")){
                        guiModel.getTxtField().setText(String.valueOf(-Double.valueOf(guiModel.getTxtField().getText())));
                    }else{
                        if(clear){
                            clearScreen();
                            clear = false;
                        }

                        guiModel.getTxtField().setText(guiModel.getTxtField().getText() + b.getText());
                    }
                    /*
                    if(b.getText().equals("+")){
                        clear = true;
                        brain.setAccNumber(Double.valueOf(guiModel.getTxtField().getText()));
                        brain.setCurrentOperation(Calculus.Operations.PLUS);
                    }else if (b.getText().equals("=")){
                        System.out.println(brain.getAccNumber());
                        brain.calculate(brain.getCurrentOperation(), Double.valueOf(guiModel.getTxtField().getText()));
                        updateScree(brain.getAccNumber());
                    }else if (b.getText().equals("-")){
                        clear = true;
                        brain.setAccNumber(Double.valueOf(guiModel.getTxtField().getText()));
                        brain.setCurrentOperation(Calculus.Operations.MINNUS);
                    }else{

                    }
                    */
                }
            });

        });

    }

    public void calculate(){
        brain.calculate(brain.getCurrentOperation(), Double.valueOf(guiModel.getTxtField().getText()));
    }

    public void updateScree(Double number){
        guiModel.getTxtField().setText(String.valueOf(number));
    }
    public void clearScreen(){
        guiModel.getTxtField().setText("");
    }

    public GuiModel getGuiModel() {
        return guiModel;
    }

    public void setGuiModel(GuiModel guiModel) {
        this.guiModel = guiModel;
    }


}
