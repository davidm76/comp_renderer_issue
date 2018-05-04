package com.example.comprenderissue;

import java.util.Arrays;
import java.util.Comparator;

import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;

import static com.example.comprenderissue.UsersView.USERS;

@Route(value = USERS, layout = MainView.class)
public class UsersView extends Grid<User> {

    public static final String USERS = "users";

    public UsersView() {

        setItems(Arrays.asList(new User ("User 1", true),
                new User("User 2", true), new User("User 3", false)));


        addColumn(User::getUsername).setHeader("Username");
        addColumn(new ComponentRenderer<>(f -> new Checkbox(f.getEnabled())))
                .setHeader("Enabled");


    }
}
