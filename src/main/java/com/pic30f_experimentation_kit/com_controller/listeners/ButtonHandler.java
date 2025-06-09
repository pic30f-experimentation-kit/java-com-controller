package com.pic30f_experimentation_kit.com_controller.listeners;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ButtonHandler implements EventHandler<ActionEvent> {
    private final Label label;
    private final HostServices hostServices;

    public ButtonHandler(Label label, HostServices hostServices) {
        this.label = label;
        this.hostServices = hostServices;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        label.setText(hostServices.getDocumentBase());
    }
}
