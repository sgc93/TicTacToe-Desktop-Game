package controllayout;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VBoxJx extends VBox{
    public VBoxJx(){
    }
    public VBoxJx(HBoxJx name_box, HBoxJx mark_box, HBoxJx move_box, HBoxJx win_box){
        getChildren().addAll(name_box, mark_box, move_box, win_box);
        setSpacing(15);
        setAlignment(Pos.CENTER_LEFT);
    }
    public VBoxJx(TextJx topic, TextJx moto, TextJx version) {
        getChildren().addAll(topic, moto, version);
        setSpacing(15);
    }
    public VBoxJx(TextJx txt0, TextJx txt1, TextJx txt2, TextJx txt3, ButtonJx play_btn, String id) {
        getChildren().addAll(txt0, txt1, txt2, txt3, play_btn);
        setId(id);
        setSpacing(15);
        setAlignment(Pos.CENTER_LEFT);
    }
    public VBoxJx(LabelJx turn_label, HBoxJx game_area) {
        getChildren().addAll(turn_label, game_area);
        setSpacing(20);
        setAlignment(Pos.CENTER);
    }
    public VBoxJx(TextJx game_over, HBoxJx win_btn) {
        getChildren().addAll(game_over,win_btn);
        setAlignment(Pos.CENTER);
        setSpacing(20);
    }

    public VBoxJx(TextJx error_txt, ButtonJx ok_btn) {
        getChildren().addAll(error_txt,ok_btn);
        setAlignment(Pos.CENTER);
        setSpacing(20);
    }

    public VBoxJx(HBoxJx dataHbox, HBoxJx btn_hbx) {
        getChildren().addAll(dataHbox, btn_hbx);
        setAlignment(Pos.CENTER);
        setSpacing(30);
    }
    public VBoxJx(GridPaneJx grid2, HBoxJx btn_hbox) {
        getChildren().addAll(grid2, btn_hbox);
        setAlignment(Pos.CENTER);
        setSpacing(30);
    }
}
