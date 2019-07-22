package com.packagename.myapp.spring;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("other-view")
@JsModule("./src/other-view.js")
@Route("other")
public class OtherView extends PolymerTemplate<OtherView.OtherModel> {
    @Id("setNameBtn")
    private Button setNameBtn;

    @Id("goodBtn")
    private Button goodBtn;

    public OtherView() {
        setNameBtn.addClickListener(e -> {
           getModel().setName("Bobby");
        });

        goodBtn.addClickListener(e -> {
            getElement().executeJs("return this.getText()").then(String.class, value -> {
                System.out.println("value from js: " + value);
            });
        });
    }

    public interface OtherModel extends TemplateModel {
        void setName(String name);
    }
}
