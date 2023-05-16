package controllayout;

import javafx.scene.control.TextField;

public class TextFieldJx extends TextField{
    public TextFieldJx(String class_name, String placeholder){
        getStyleClass().add(class_name);
        setPromptText(placeholder);
    }
}
