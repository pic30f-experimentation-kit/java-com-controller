package com.pic30f_experimentation_kit.com_controller.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UiController {
    private final UiModel uiModel;

    @FXML
    public VBox vBox;

    @FXML
    public Label sliderLabel;

    @FXML
    public Slider slider;

    @FXML
    public Label colorPickerLabel;

    @FXML
    public ColorPicker colorPicker;

    @FXML
    public CheckBox sendContinuously;

    @FXML
    public Button sendNow;

    public UiController(UiModel uiModel) {
        this.uiModel = uiModel;
    }

    @FXML
    public void initialize() {
        this.slider.valueProperty().bindBidirectional(uiModel.sliderPosition());
        this.sendContinuously.selectedProperty().bindBidirectional(uiModel.sendContinuously());
        this.colorPicker.valueProperty().bindBidirectional(uiModel.selectedColor());
        this.sendNow.disableProperty().bindBidirectional(uiModel.sendNowIsDisabled());
        this.sendNow.setOnAction((e) -> uiModel.sendNow());
    }
}
