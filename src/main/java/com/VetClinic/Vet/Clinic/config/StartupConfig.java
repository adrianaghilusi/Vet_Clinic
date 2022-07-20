package com.VetClinic.Vet.Clinic.config;

import com.VetClinic.Vet.Clinic.model.Doctor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupConfig implements ApplicationListener<ContextStartedEvent> {


    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        load();
    }
    public void load(){
    Doctor doctor = new Doctor("Jason Derp", "Miami,Florida","071367821");
    }
}
