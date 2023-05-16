package controllayout;

import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class HBoxJx extends HBox {
    public HBoxJx(TextJx txt, LabelJx label){
        getChildren().addAll(txt, label);
        setSpacing(15);
    }

    public HBoxJx(VBoxJx data_grid_1, GridPaneJx board_grid, VBoxJx data_grid_2) {
        getChildren().addAll(data_grid_1, board_grid, data_grid_2);
        setSpacing(70);
        setAlignment(Pos.CENTER);
    }

    public HBoxJx(ButtonJx contact_btn, ButtonJx about_btn) {
        getChildren().addAll(contact_btn, about_btn);
        setSpacing(15);
        setAlignment(Pos.CENTER);
    }

    public HBoxJx(GridPaneJx label_grid, GridPaneJx label_grid2, GridPaneJx label_grid3) {
        getChildren().addAll(label_grid, label_grid2, label_grid3);
    }

    public HBoxJx(GridPaneJx grid1, GridPaneJx grid2) {
        getChildren().addAll(grid1, grid2);
        setAlignment(Pos.CENTER);
        setSpacing(30);
    }
}
