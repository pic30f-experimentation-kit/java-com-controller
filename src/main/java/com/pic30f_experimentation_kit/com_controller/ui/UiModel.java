package com.pic30f_experimentation_kit.com_controller.ui;

import javafx.beans.property.Property;
import javafx.scene.paint.Color;

/**
 * The model receives events from the view, and sends events to the controller for it to update the view.
 * @see UiController
 */
public interface UiModel {
    /**
     * Immediately sends the currently selected color and position to the COM port.
     */
    void sendNow();

    /**
     * Specifies if the <em>Send Now</em> button should be disabled.
     * @return Bindable access to the property.
     */
    Property<Boolean> sendNowIsDisabled();

    /**
     * Specifies if the changes in selected color and slider positions are to be sent immediately.
     * @return Bindable access to the property.
     */
    Property<Boolean> sendContinuously();

    /**
     * Specifies the slider position.
     * @return Bindable access to the property.
     */
    Property<Number> sliderPosition();

    /**
     * Specifies the selected color.
     * @return Bindable access to the property.
     */
    Property<Color> selectedColor();
}
