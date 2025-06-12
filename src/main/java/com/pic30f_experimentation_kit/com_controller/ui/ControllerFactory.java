package com.pic30f_experimentation_kit.com_controller.ui;

import javafx.util.Callback;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Controller factory based on available spring beans.
 */
@Component
public class ControllerFactory implements Callback<Class<?>, Object> {
    private final ApplicationContext applicationContext;

    public ControllerFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object call(Class<?> aClass) {
        return applicationContext.getBean(aClass);
    }

}
