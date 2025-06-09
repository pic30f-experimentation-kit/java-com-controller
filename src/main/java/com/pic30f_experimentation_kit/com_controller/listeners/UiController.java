package com.pic30f_experimentation_kit.com_controller.listeners;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

@Component
public class UiController {
    private final HostServices hostServices;
    @FXML
    public VBox vBox;

    @FXML
    public Label label;

    @FXML
    public Button button;

    public UiController(HostServices hostServices) {
        this.hostServices = hostServices;
    }

    @FXML
    public void initialize() {
        this.label.setText("Don't you dare to click");
        ButtonHandler buttonHandler = new ButtonHandler(label, hostServices);
        this.button.setOnAction(buttonHandler);
    }
}
