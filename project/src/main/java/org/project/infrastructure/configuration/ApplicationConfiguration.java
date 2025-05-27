package org.project.infrastructure.configuration;

import org.project.ComponentScanMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = ComponentScanMarker.class)
@Import(persistenceJPAConfiguration.class)
public class ApplicationConfiguration {




}
