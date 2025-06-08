package com.pic30f_experimentation_kit.com_controller.listeners;

import com.pic30f_experimentation_kit.com_controller.configuration.UiConfiguration;
import com.pic30f_experimentation_kit.com_controller.events.StageReadyEvent;
import jakarta.annotation.PostConstruct;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class StageListener implements ApplicationListener<StageReadyEvent> {
    private static final String FXML_RESOURCE = "/ui.fxml";

    private final String title;
    private final ControllerFactory controllerFactory;

    private FXMLLoader loader;

    public StageListener(UiConfiguration configuration, ControllerFactory controllerFactory) {
        this.title = configuration.getTitle();
        this.controllerFactory = controllerFactory;
    }

    @PostConstruct
    public void initialization() {
        URL url = this.getClass().getResource(FXML_RESOURCE);
        loader = new FXMLLoader(url);
        loader.setControllerFactory(controllerFactory);
    }


    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
