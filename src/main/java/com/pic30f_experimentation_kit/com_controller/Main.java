package com.pic30f_experimentation_kit.com_controller;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring boot entry point.
 */
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		// Starts Java FX:
		Application.launch(JavaFxStarter.class, args);
	}
}
