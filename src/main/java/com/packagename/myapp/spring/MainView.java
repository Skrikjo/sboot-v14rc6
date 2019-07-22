package com.packagename.myapp.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView(@Autowired MessageBean bean) {
        MenuBar bar = new MenuBar();
        MenuItem item = bar.addItem(new RouterLink("Other View", OtherView.class));
        item.addClickListener(e -> {
            System.out.println("first item clicked");
        });

        SubMenu item1 = bar.addItem("second item").getSubMenu();
        item1.addItem(new H3("first"));
        item1.addItem(new H3("second"), e -> {

            System.out.println("sub second item clicked");
        });
        item1.addItem(new H3("third"));

        bar.addItem("third item", e -> {
            System.out.println("third item clicked");
        });
        add(bar);



        Button button = new Button("Click me",
                e -> Notification.show(bean.getMessage()));

//        DatePicker picker = new DatePicker();

        add(button);
    }

}
