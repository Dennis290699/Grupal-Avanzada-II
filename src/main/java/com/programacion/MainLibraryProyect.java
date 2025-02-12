package com.programacion;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class MainLibraryProyect {
    // Inicializar el contenedor CDI
    SeContainer container = SeContainerInitializer.newInstance().initialize();
}
