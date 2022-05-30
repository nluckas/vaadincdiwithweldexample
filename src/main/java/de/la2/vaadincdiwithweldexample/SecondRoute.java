
package de.la2.vaadincdiwithweldexample;

import com.vaadin.cdi.annotation.RouteScopeOwner;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Route("second")
public class SecondRoute extends Div {

    @Inject
    @RouteScopeOwner(SecondRoute.class)
    private SecondComponent secondComponent;

    @PostConstruct
    private void init() {
        add(secondComponent);
    }

}
