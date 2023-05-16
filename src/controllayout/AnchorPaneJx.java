package controllayout;

import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class AnchorPaneJx extends AnchorPane{
    public AnchorPaneJx(VBoxJx vBoxJx){
        getChildren().addAll(vBoxJx);

        // positioning
        AnchorPane.setBottomAnchor(vBoxJx, 0.0);
        AnchorPane.setTopAnchor(vBoxJx, 0.0);
        AnchorPane.setRightAnchor(vBoxJx, 0.0);
        AnchorPane.setLeftAnchor(vBoxJx, 0.0);
    
    }

    public AnchorPaneJx(VBoxJx intro_box, VBoxJx info_box, HBoxJx footer_box, String id) {
        getChildren().addAll(intro_box, info_box, footer_box);
        setId(id);
        // positioning
        AnchorPane.setBottomAnchor(intro_box, 390.0);
        AnchorPane.setTopAnchor(intro_box, 10.0);
        AnchorPane.setRightAnchor(intro_box, 200.0);
        AnchorPane.setLeftAnchor(intro_box, 200.0);
        intro_box.setAlignment(Pos.CENTER);

        AnchorPane.setBottomAnchor(info_box, 120.0);
        AnchorPane.setTopAnchor(info_box, 220.0);
        AnchorPane.setRightAnchor(info_box, 200.0);
        AnchorPane.setLeftAnchor(info_box, 200.0);
        info_box.setAlignment(Pos.CENTER);

        AnchorPane.setBottomAnchor(footer_box, 10.0);
        AnchorPane.setTopAnchor(footer_box, 480.0);
        AnchorPane.setRightAnchor(footer_box, 200.0);
        AnchorPane.setLeftAnchor(footer_box, 200.0);
        footer_box.setAlignment(Pos.CENTER_RIGHT);
    }

    public AnchorPaneJx(GridPaneJx grid) {
        getChildren().add(grid);
    }

    public AnchorPaneJx() {
    }
}