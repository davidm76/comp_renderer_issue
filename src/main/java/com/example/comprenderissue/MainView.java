package com.example.comprenderissue;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import static com.example.comprenderissue.DeviceView.DEVICES;
import static com.example.comprenderissue.UsersView.USERS;

@Route("")
@Push
@Theme(Lumo.class)
@BodySize(height = "96vh", width = "98vw")
public class MainView extends VerticalLayout implements RouterLayout, AfterNavigationObserver {

    private Tabs tabs = new Tabs();

    private List<String> hrefs = new ArrayList<>();

    public MainView() {

        setSizeFull();

        tabs.setWidth("100%");
        tabs.add(new Tab("Users"));
        hrefs.add(USERS);
        tabs.add(new Tab("Devices"));
        hrefs.add(DEVICES);

        add(tabs);
        tabs.addSelectedChangeListener(e -> navigate());
    }

    private void navigate() {
        int idx = tabs.getSelectedIndex();
        if (idx >= 0 && idx < hrefs.size()) {
            UI.getCurrent().navigate(hrefs.get(idx));
        }
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        String href = event.getLocation().getFirstSegment().isEmpty() ? USERS
                : event.getLocation().getPath();
        tabs.setSelectedIndex(hrefs.indexOf(href));
    }
}
