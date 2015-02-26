package magfx.ui;

import java.lang.reflect.InvocationTargetException;
import javafx.embed.swing.SwingNode;
import javax.swing.SwingUtilities;
//import magic.ui.explorer.ExplorerPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardsExplorerView extends AbstractMenuView {

    final Logger LOGGER = LoggerFactory.getLogger(CardsExplorerView.class);

    @SuppressWarnings("deprecation")
    public CardsExplorerView() {

        setScreenTitle("Cards Explorer");

        setBottom(getMenuButton("Main Menu", e -> { ScreenController.showMainMenuScreen(); }));

        final SwingNode swingNode = new SwingNode();
        setCenter(swingNode);

        try {
            SwingUtilities.invokeAndWait(() -> {
//                swingNode.setContent(new ExplorerPanel());
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            LOGGER.error("", ex);
        }

    }

}
