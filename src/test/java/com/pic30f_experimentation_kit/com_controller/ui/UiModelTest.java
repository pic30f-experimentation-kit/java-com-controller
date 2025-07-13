package com.pic30f_experimentation_kit.com_controller.ui;

import com.pic30f_experimentation_kit.com_controller.services.ComService;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UiModelTest {
    private static final Number SLIDER_MIDDLE_POSITION = 50d;
    private static final Color SHADE_1 = new Color(0.5, 0.5, 0.5, 1.0);

    private ComService comService;

    private UiModel underTest;

    @BeforeEach
    public void setUp() {
        comService = Mockito.mock(ComService.class);
        underTest = new UiModel(comService);
    }

    @Test
    public void can_send_color_and_position_when_send_now() {
        underTest.sendContinuously().setValue(false);
        underTest.sliderPosition().setValue(SLIDER_MIDDLE_POSITION);
        underTest.selectedColor().setValue(SHADE_1);

        Mockito.verify(comService, Mockito.never()).sendValue(Mockito.any(Number.class), Mockito.any(Color.class));
        underTest.sendNow();
        Mockito.verify(comService).sendValue(SLIDER_MIDDLE_POSITION, SHADE_1);
    }

    @Test
    public void can_send_position_when_send_continuously() {
        underTest.sendContinuously().setValue(true);
        underTest.sliderPosition().setValue(SLIDER_MIDDLE_POSITION);

        Mockito.verify(comService).sendValue(Mockito.eq(SLIDER_MIDDLE_POSITION), Mockito.any(Color.class));
    }

    @Test
    public void can_send_color_when_send_continuously() {
        underTest.sendContinuously().setValue(true);
        underTest.selectedColor().setValue(SHADE_1);

        Mockito.verify(comService).sendValue(Mockito.any(Number.class), Mockito.eq(SHADE_1));
    }

    @Test
    public void can_disable_send_now_when_send_continuously() {
        underTest.sendContinuously().setValue(false);
        underTest.sendContinuously().setValue(true);
        Assertions.assertEquals(true,underTest.sendNowIsDisabled().getValue());
    }

    @Test
    public void can_enable_send_now_when_disabling_send_continuously() {
        underTest.sendContinuously().setValue(true);
        underTest.sendContinuously().setValue(false);
        Assertions.assertEquals(false,underTest.sendNowIsDisabled().getValue());
    }

    @Test
    public void can_ignore_changes_when_disabling_send_continuously() {
        underTest.sendContinuously().setValue(false);
        underTest.selectedColor().setValue(SHADE_1);
        underTest.sliderPosition().setValue(SLIDER_MIDDLE_POSITION);
        Mockito.verify(comService, Mockito.never()).sendValue(Mockito.any(Number.class), Mockito.any(Color.class));
    }
}