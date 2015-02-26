package magfx.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;

public abstract class AbstractMenuView extends AbstractScreenView {

    protected Button getMenuButton(final String text, final EventHandler<ActionEvent> action) {
        return ButtonBuilder.create()
                .text(text)
                .onAction(action)
                .styleClass("menuButton")
                .minWidth(240)
                .minHeight(30)
                .focusTraversable(false)
                .build();
    }

}
