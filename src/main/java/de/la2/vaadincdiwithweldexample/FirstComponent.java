
package de.la2.vaadincdiwithweldexample;

import com.vaadin.cdi.annotation.RouteScopeOwner;
import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Inject;

@RouteScoped
@RouteScopeOwner(FirstRoute.class)
public class FirstComponent extends VerticalLayout {

    @Inject
    private ButtonWithEvent button;

    private Span text = new Span("Text");
    private Button toSecond = new Button();

    @PostConstruct
    private void init() {
        add(text, button, toSecond);
        toSecond.setText("To Second Route");
        toSecond.addClickListener((ClickEvent<Button> t) -> {
            UI.getCurrent().navigate(SecondRoute.class);
        });
    }

    private void onEvent(@Observes(notifyObserver = Reception.IF_EXISTS) String string) {
        text.setText("Text after event");
    }

}
