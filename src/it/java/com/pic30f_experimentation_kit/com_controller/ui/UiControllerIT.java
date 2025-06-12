package com.pic30f_experimentation_kit.com_controller.ui;

import com.pic30f_experimentation_kit.com_controller.services.ComService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.testfx.framework.junit5.ApplicationTest;

import java.net.URL;

class UiControllerIT extends ApplicationTest {
    private ComService comService;

    @Override
    public void start(Stage stage) throws Exception {
        comService = Mockito.mock(ComService.class);
        UiModel uiModel = new UiModel(comService);
        final UiController uiController = new UiController(uiModel);

        URL url = this.getClass().getResource("/ui.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setControllerFactory((a) -> uiController);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void can_do_something_nice() {
        clickOn("#slider");
        Mockito.verify(comService, Mockito.never()).sendValue(Mockito.any(Number.class), Mockito.any(Color.class));
        clickOn("#sendNow");
        Mockito.verify(comService).sendValue(50.22583559168925d, Color.gray(1));
    }
}