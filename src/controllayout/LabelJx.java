package controllayout;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class LabelJx extends Label{
    public LabelJx(){
    }

    public LabelJx(String txt, String id) {
        setText(txt);
        setId(id);
        setAlignment(Pos.CENTER);
    }

    public LabelJx(String id) {
        setId(id);
    }
}
