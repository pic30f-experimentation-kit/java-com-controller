package com.pic30f_experimentation_kit.com_controller.services;

import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ComServiceImpl implements ComService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComServiceImpl.class);

    @Override
    public void sendValue(Number position, Color color) {
        LOGGER.info("Position {} - Color {}", position, color);
    }
}
