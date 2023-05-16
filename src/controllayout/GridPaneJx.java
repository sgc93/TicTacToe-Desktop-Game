package controllayout;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class GridPaneJx extends GridPane {
    public GridPaneJx(){
        
        setVgap(5);
        setHgap(5);
    }

    public GridPaneJx(String string) {
        setId(string);
        setAlignment(Pos.CENTER);
    }
}
