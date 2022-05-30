
package de.la2.vaadincdiwithweldexample;

import com.vaadin.cdi.annotation.RouteScopeOwner;
import com.vaadin.cdi.annotation.RouteScoped;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Route("first")
@RouteScoped
@RouteScopeOwner(FirstRoute.class)
public class FirstRoute extends Div {

    @Inject
    @RouteScopeOwner(FirstRoute.class)
    private FirstComponent firstComponent;

    @PostConstruct
    private void init() {
        add(firstComponent);
    }


}
