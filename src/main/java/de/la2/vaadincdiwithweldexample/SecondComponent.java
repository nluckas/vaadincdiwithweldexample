
package de.la2.vaadincdiwithweldexample;

import com.vaadin.cdi.annotation.RouteScopeOwner;
import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.inject.Inject;

@RouteScoped
@RouteScopeOwner(SecondRoute.class)
public class SecondComponent extends VerticalLayout {

    @Inject
    private ButtonWithEvent button;

    private Span text = new Span("Text2");
    private Button toFirst = new Button();

    @PostConstruct
    private void init() {
        add(text, button, toFirst);
        toFirst.setText("To First Route");
        toFirst.addClickListener((ClickEvent<Button> t) -> {
            UI.getCurrent().navigate(FirstRoute.class);
        });
    }

    private void onEvent(@Observes(notifyObserver = Reception.IF_EXISTS) String string) {
        text.setText("Text2 after event");
    }

}
