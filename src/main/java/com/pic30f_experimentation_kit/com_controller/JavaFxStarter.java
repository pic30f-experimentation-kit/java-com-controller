package com.pic30f_experimentation_kit.com_controller;

import com.pic30f_experimentation_kit.com_controller.events.StageReadyEvent;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Starter class for Java FX.
 */
public class JavaFxStarter extends Application {
    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        ApplicationContextInitializer<GenericApplicationContext> initializer = ac -> {
            ac.registerBean(Application.class, () -> JavaFxStarter.this);
            ac.registerBean(Parameters.class, this::getParameters);
            ac.registerBean(HostServices.class, this::getHostServices);
        };

        this.springContext = new SpringApplicationBuilder()
                .sources(ComControllerApplication.class)
                .initializers(initializer)
                .run(getParameters().getRaw().toArray(new String[0]));
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.springContext.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() {
        this.springContext.close();
        Platform.exit();
    }
}
