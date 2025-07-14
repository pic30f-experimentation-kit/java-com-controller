package com.pic30f_experimentation_kit.com_controller.listeners;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

public class StageReadyEvent extends ApplicationEvent {
    public Stage getStage() {
        return (Stage) getSource();
    }

    public StageReadyEvent(Object source) {
        super(source);
    }
}
