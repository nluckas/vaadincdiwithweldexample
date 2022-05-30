package de.la2.vaadincdiwithweldexample;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.inject.Inject;

public class ButtonWithEvent extends Button {

    @Inject
    private Event<String> event;

    @PostConstruct
    private void init() {
        setText("Fire Event");
        addClickListener((ClickEvent<Button> t) -> {
            event.fire("Test");
        });
    }

}
