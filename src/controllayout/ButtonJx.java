package controllayout;

import javafx.scene.control.Button;

public class ButtonJx extends Button{
    public ButtonJx(){

    }

    public ButtonJx(String txt) {
        setText(txt);
    }

    public ButtonJx(String txt, String id) {
        setText(txt);
        setId(id);
    }
}
