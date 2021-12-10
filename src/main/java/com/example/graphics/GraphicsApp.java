package com.example.graphics;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GraphicsApp extends Application {

    Rectangular rectangular = new Rectangular(0,0,1,1);

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            root.setCenter(createInputPane());
            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Graphics App");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    private Pane createInputPane() {
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(7,7,7,7));
        //gridPane.setGridLinesVisible(true);
        gridPane.setHgap(5);
        gridPane.setVgap(10);

        //Labels created
        final Label widthLabel = new Label("Width");

        final Label heightLabel = new Label("Height");

        final Label circumferenceLabel = new Label("Circumference:");

        final Label areaLabel = new Label("Area:");

        //TextFields created and configured
        final TextField widthTextField = new TextField();
        //Formatter functioniert aber nicht optimal
        //widthTextField.setTextFormatter(new DecimalTextFormatter(2, 2));

        final TextField heightTextField = new TextField();
        //Formatter functioniert aber nicht optimal
        //heightTextField.setTextFormatter(new DecimalTextFormatter(0, 2));

        final TextField circumferenceTextField = new TextField();
        circumferenceTextField.setEditable(false);
        circumferenceTextField.setMouseTransparent(true);
        circumferenceTextField.setFocusTraversable(false);
        circumferenceTextField.setBackground(Background.EMPTY);

        final TextField areaTextField = new TextField();
        areaTextField.setEditable(false);
        areaTextField.setMouseTransparent(true);
        areaTextField.setFocusTraversable(false);
        areaTextField.setBackground(Background.EMPTY);

        //button created
        final Button buttonCompute = new Button("Compute");

        //Different JavaFx objects are added to the Gridpane
        gridPane.add(widthLabel, 0, 0);
        gridPane.add(widthTextField, 1, 0);
        gridPane.add(heightLabel, 0, 1);
        gridPane.add(heightTextField, 1, 1);
        gridPane.add(buttonCompute, 1, 2);
        gridPane.add(circumferenceLabel,0,3);
        gridPane.add(circumferenceTextField,1,3);
        gridPane.add(areaLabel,0,4);
        gridPane.add(areaTextField,1,4);


        //DisableProperty makes sure that both fields are full
        buttonCompute.
                disableProperty().
                bind(
                        Bindings.or(
                                Bindings.isEmpty(
                                        widthTextField.
                                                textProperty()),
                                Bindings.isEmpty(
                                        heightTextField.
                                                textProperty())));

        //If the Compute button is pushed the imputs widthTextField and the imputs heightTextField are computed via the rectangular and written to the textfield
        buttonCompute.setOnAction(actionEvent ->{
                        rectangular.setWidth(Double.parseDouble(
                                widthTextField.getText()));
                        rectangular.setHeight(Double.parseDouble(
                                heightTextField.getText()));
                        areaTextField.
                                setText(""+
                                        rectangular.computeArea());
                        circumferenceTextField.
                                setText(""+
                                        rectangular.computeCircumference());});
        return gridPane;
    }

}

