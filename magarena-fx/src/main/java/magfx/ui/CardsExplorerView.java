package magfx.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPaneBuilder;
import javafx.scene.control.TableColumnBuilder;
import javafx.scene.control.TableView;
import javafx.scene.control.TableViewBuilder;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.Pane;
import javafx.scene.layout.PaneBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import magfx.data.CssStyles;
import magfx.utility.MagicResources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CardsExplorerView extends AbstractMenuView {

    final Logger LOGGER = LoggerFactory.getLogger(CardsExplorerView.class);

    @SuppressWarnings({"deprecation", "deprecation"})
    public CardsExplorerView() {

        setScreenTitle("Cards Explorer");

        final ImageView cardImage = ImageViewBuilder.create()
                .styleClass(CssStyles.DEBUG_BORDER, CssStyles.DEBUG_BACKGROUND)
                .image(MagicResources.getIconImage("card_back.jpg"))
                .fitWidth(300)
                .preserveRatio(true)
                .build();

        setLeft(VBoxBuilder.create()
                .styleClass(CssStyles.DEBUG_BORDER, CssStyles.DEBUG_BACKGROUND)
                .prefWidth(300)
                .children(cardImage)
                .build());

        final TableView<Object> table = TableViewBuilder.create()
                .style("-fx-font-family: 'Beleren';")
                .columns(
                        TableColumnBuilder.create()
                        .text("#")
                        .prefWidth(40)
                        .resizable(false)
                        .build(),
                        TableColumnBuilder.create()
                        .text("Name")
                        .prefWidth(180)
                        .build(),
                        TableColumnBuilder.create()
                        .text("CC")
                        .prefWidth(140)
                        .build(),
                        TableColumnBuilder.create()
                        .text("P")
                        .prefWidth(30)
                        .resizable(false)
                        .build(),
                        TableColumnBuilder.create()
                        .text("T")
                        .prefWidth(30)
                        .resizable(false)
                        .build(),
                        TableColumnBuilder.create()
                        .text("Type")
                        .prefWidth(140)
                        .build(),
                        TableColumnBuilder.create()
                        .text("Subtype")
                        .prefWidth(140)
                        .build(),
                        TableColumnBuilder.create()
                        .text("Rarity")
                        .prefWidth(90)
                        .build(),
                        TableColumnBuilder.create()
                        .text("Oracle")
                        .prefWidth(2000)
                        .build()
                )
                .build();

        final ObservableList<Object> items = FXCollections.observableArrayList("A", "B", "C");
        table.setItems(items);
        
        final ScrollPane tableScroller = ScrollPaneBuilder.create()
                .content(table)
                .build();

        final Pane filterPane = PaneBuilder.create()
                .styleClass(CssStyles.DEBUG_BORDER, CssStyles.DEBUG_BACKGROUND)
                .prefHeight(60)
                .build();

        final VBox tableLayout = VBoxBuilder.create()
                .styleClass(CssStyles.DEBUG_BORDER)
                .children(filterPane, tableScroller)
                .build();
        VBox.setVgrow(tableScroller, Priority.ALWAYS);

        setCenter(tableLayout);

        setBottom(getMenuButton("Main Menu", e -> {
            ScreenController.showMainMenuScreen();
        }));

    }

}
