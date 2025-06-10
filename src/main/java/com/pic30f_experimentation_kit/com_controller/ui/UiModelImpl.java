package com.pic30f_experimentation_kit.com_controller.ui;

import com.pic30f_experimentation_kit.com_controller.services.ComService;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.paint.Color;
import org.springframework.stereotype.Component;

@Component
public class UiModelImpl implements UiModel {
    private final ComService comService;

    private final Property<Boolean> sendNowIsDisabled = new SimpleBooleanProperty(false);
    private final Property<Boolean> sendContinuously = new SimpleBooleanProperty(false);
    private final Property<Number> sliderPosition = new SimpleDoubleProperty(0d);
    private final Property<Color> selectedColor = new SimpleObjectProperty<>(Color.gray(1d));

    public UiModelImpl(ComService comService) {
        this.comService = comService;
        this.sendContinuously.addListener(this::listenToSendContinuouslyChanges);
        this.sliderPosition.addListener(this::listenToSliderPositionChanges);
        this.selectedColor.addListener(this::listenToColorChanges);
    }

    private void listenToSendContinuouslyChanges(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if (newValue) {
            sendNowIsDisabled.setValue(true);
        } else {
            sendNowIsDisabled.setValue(false);
        }
    }

    private void listenToSliderPositionChanges(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        if (sendContinuously.getValue()) {
            sendNow();
        }
    }

    private void listenToColorChanges(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
        if (sendContinuously.getValue()) {
            sendNow();
        }
    }


    @Override
    public void sendNow() {
        comService.sendValue(sliderPosition.getValue(), selectedColor.getValue());
    }

    @Override
    public Property<Boolean> sendNowIsDisabled() {
        return sendNowIsDisabled;
    }

    @Override
    public Property<Boolean> sendContinuously() {
        return sendContinuously;
    }

    @Override
    public Property<Number> sliderPosition() {
        return sliderPosition;
    }

    @Override
    public Property<Color> selectedColor() {
        return selectedColor;
    }
}
