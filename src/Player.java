import controllayout.AnchorPaneJx;
import controllayout.ButtonJx;
import controllayout.GridPaneJx;
import controllayout.HBoxJx;
import controllayout.LabelJx;
import controllayout.TextFieldJx;
import controllayout.VBoxJx;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Player {
    String name;
    String game_mode;
    char mark;
    int move;
    float win_probablity;
    static Scene data_scene;
    static Stage dataStage;
    static ButtonJx submit_data = new ButtonJx("Go On", "data_btn");
    static ButtonJx sp_submit_data = new ButtonJx("Go On", "data_btn");
    static ButtonJx back_btn = new ButtonJx("Back", "data_btn");
    static TextFieldJx name_field1 = new TextFieldJx("data_field", "Player1 name");
    static TextFieldJx mark_field1 = new TextFieldJx("data_field", "Player1 mark");
    static TextFieldJx name_field2 = new TextFieldJx("data_field", "Player2 name");
    static TextFieldJx mark_field2 = new TextFieldJx("data_field", "Player2 mark");
    static TextFieldJx name_field = new TextFieldJx("data_field", "Player2 name");
    static TextFieldJx mark_field = new TextFieldJx("data_field", "Player2 mark");  

    public Player (String name, char mark){
        this.name = name;
        this.mark = mark;
    }

    public Player(String game_mode) {
        this.game_mode = game_mode;
        if (game_mode == "multi"){
            getMultiPlayerData();
        } else {
            getSinglePlayerData();
        }
        
    }

    static void getMultiPlayerData(){
        LabelJx player1 = new LabelJx("PLAYER 1", "_player");
        LabelJx name_label1 = new LabelJx("Name : ", "data_label");
        LabelJx mark_label1 = new LabelJx("Mark : ", "data_label");
               

        GridPaneJx grid1 = new GridPaneJx("_player_grid");
        grid1.addRow(0, player1);
        grid1.addRow(1, name_label1, name_field1);
        grid1.addRow(2, mark_label1, mark_field1);
        GridPaneJx.setColumnSpan(player1, 2);
        grid1.setHgap(20);
        grid1.setVgap(20);

        LabelJx player2 = new LabelJx("PLAYER 2", "_player");
        LabelJx name_label2 = new LabelJx("Name : ", "data_label");
        LabelJx mark_label2 = new LabelJx("Mark : ", "data_label");
                
        
        GridPaneJx grid2 = new GridPaneJx("_player_grid");
        grid2.addRow(0, player2);
        grid2.addRow(1, name_label2, name_field2);
        grid2.addRow(2, mark_label2, mark_field2);
        GridPaneJx.setColumnSpan(player2, 2);
        grid2.setHgap(20);
        grid2.setVgap(20);
        
        HBoxJx dataHbox = new HBoxJx(grid1, grid2);
        HBoxJx btn_hbox = new HBoxJx(submit_data, back_btn);
        VBoxJx dataVbox = new VBoxJx(dataHbox, btn_hbox);

        AnchorPaneJx data_root = new AnchorPaneJx(dataVbox);
        data_root.setId("_game_board");

        data_scene = new Scene(data_root, 1200, 600);
        dataStage = new Stage();
        dataStage.setScene(data_scene);
    }

    static void getSinglePlayerData(){

        LabelJx player2 = new LabelJx("PLAYER 2", "_player");
        LabelJx name_label = new LabelJx("Name : ", "data_label");
        LabelJx mark_label = new LabelJx("Mark : ", "data_label");
                
        GridPaneJx grid2 = new GridPaneJx("_player_grid");
        grid2.addRow(0, player2);
        grid2.addRow(1, name_label, name_field);
        grid2.addRow(2, mark_label, mark_field);
        GridPaneJx.setColumnSpan(player2, 2);
        grid2.setHgap(20);
        grid2.setVgap(20);
        
        HBoxJx btn_hbox = new HBoxJx(sp_submit_data, back_btn);
        VBoxJx dataVbox = new VBoxJx(grid2, btn_hbox);

        AnchorPaneJx data_root = new AnchorPaneJx(dataVbox);
        data_root.setId("_game_board");

        data_scene = new Scene(data_root, 1200, 600);
        dataStage = new Stage();
        dataStage.setScene(data_scene);
    }

    // handling

}