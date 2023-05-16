import controllayout.AnchorPaneJx;
import controllayout.ButtonJx;
import controllayout.HBoxJx;
import controllayout.LabelJx;
import controllayout.TextJx;
import controllayout.VBoxJx;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Wellcome {
    // title
    static TextJx topic = new TextJx("TIC TAC TOE", "_topic");
    static TextJx moto = new TextJx("Simple, But Tricky and Fun.", "_moto");
    static TextJx version = new TextJx("V 1.0.0  |  April 2023", "_version");
    static VBoxJx intro_box = new VBoxJx(topic, moto, version);
    
    // middle box
    static TextJx txt0 = new TextJx("Have a Nice Time 👍 ", "_text0");
    static TextJx txt1 = new TextJx("Play with built in AI | Singleplayer mode ", "_text1");
    static TextJx txt2 = new TextJx("Play with your freind | Multiplayer mode ", "_text2");
    static TextJx txt3 = new TextJx("Guide yourself with the given Rules of the game", "_text3");
    static ButtonJx play_btn = new ButtonJx("PLAY", "_play_btn");
    static VBoxJx info_box = new VBoxJx(txt0, txt1, txt2, txt3, play_btn, "_info_box");
    
    // footer
    static ButtonJx contact_btn = new ButtonJx("CONTACT", "_cont_btn");
    static ButtonJx about_btn = new ButtonJx("ABOUT", "_about_btn");
    static HBoxJx footer_box = new HBoxJx(contact_btn, about_btn);

    // add the above contents to the root node and scene
    static AnchorPaneJx wellC_root = new AnchorPaneJx(intro_box, info_box, footer_box, "_wellc_root");

    static Scene wellC_Scene = new Scene(wellC_root, 1200, 600);
}