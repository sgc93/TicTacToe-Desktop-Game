import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import controllayout.AnchorPaneJx;
import controllayout.ButtonJx;
import controllayout.TextJx;
import controllayout.VBoxJx;

public class App extends Application {
    Scene board_scene;
    static Stage winStage = new Stage();
    String p1_name, p2_name;
    char p1_mark, p2_mark;
    Image icon = new Image("css\\Exclude.png");
    public static void main(String[] args) throws Exception {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Wellcome.wellC_Scene.getStylesheets().add(getClass().getResource("css\\wellcome.css").toExternalForm());
        primaryStage.setScene(Wellcome.wellC_Scene);
        primaryStage.setTitle("Well Come to play, have a geat fun!");
        primaryStage.getIcons().add(icon);
        primaryStage.show();
        

        // event handling

        Wellcome.play_btn.setOnAction(event -> {
            Mode m = new Mode();
            Scene mode_Scene;
            mode_Scene = Mode.displayLabel();
            mode_Scene.getStylesheets().add(getClass().getResource("css\\mode_page.css").toExternalForm());
            primaryStage.setScene(mode_Scene);
        });

        Player.back_btn.setOnAction(event -> {
            Mode m = new Mode();
            Scene mode_Scene;
            mode_Scene = Mode.displayLabel();
            mode_Scene.getStylesheets().add(getClass().getResource("css\\mode_page.css").toExternalForm());
            primaryStage.setScene(mode_Scene);
        });


        Mode.multip.setOnAction(event -> {
            Player p = new Player("multi");
            Player.data_scene.getStylesheets().add(getClass().getResource("css\\data_scene.css").toExternalForm());    
            primaryStage.setScene(Player.data_scene);
            // Player.dataStage.show();
        });

        
        Player.submit_data.setOnAction(event -> {
            if(Player.name_field1.getText() == "" || Player.mark_field1.getText() == "" || Player.name_field2.getText() == "" || Player.mark_field2.getText() == ""){
                TextJx error_txt = new TextJx("All inputs are Required, fill them first, Please!", "_game_over");
                ButtonJx ok = new ButtonJx("OK", "_ok_btn");
                ok.setOnAction(e -> {
                App.winStage.close();
                });
                VBoxJx win_root = new VBoxJx(error_txt, ok);
                win_root.setId("error_root");
                Scene error_scene = new Scene(win_root, 500, 150);
            error_scene.getStylesheets().add(getClass().getResource("css\\win_draw.css").toExternalForm());
            App.winStage.setScene(error_scene);
            App.winStage.setTitle("Input Error");
            App.winStage.getIcons().add(icon);
            App.winStage.show();
        }
        else {
            
            p1_name = Player.name_field1.getText();
            p1_mark = (Player.mark_field1.getText()).charAt(0);
            p2_name = Player.name_field2.getText();
            p2_mark = (Player.mark_field2.getText()).charAt(0);

            // creating 2 players with their data
            Player p1 = new Player(p1_name, p1_mark);
            Player p2 = new Player(p2_name, p2_mark);

            TicTacToe.updatePlayerData(p1.name, p1.mark, p2.name, p2.mark);
            TicTacToe t =new TicTacToe("multi");
            Mode MultiPlayer = new Mode();
            AnchorPaneJx root = new AnchorPaneJx(TicTacToe.displayBoard());
            root.setId("_game_board");
            Scene singleP_Scene; 
            singleP_Scene = new Scene(root, 1200, 600);
            singleP_Scene.getStylesheets().add(getClass().getResource("css\\play_board.css").toExternalForm());
            primaryStage.setScene(singleP_Scene);
        }

        });

        Mode.singlep.setOnAction(event -> {
            Player p = new Player("single");
            Player.data_scene.getStylesheets().add(getClass().getResource("css\\data_scene.css").toExternalForm());    
            primaryStage.setScene(Player.data_scene);
            // Player.dataStage.show();
        });

        Mode.back.setOnAction(event -> {
            primaryStage.setScene(Wellcome.wellC_Scene);
        });

        Player.sp_submit_data.setOnAction(event -> {
            if(Player.name_field.getText() == "" || Player.mark_field.getText() == "" ){
                TextJx error_txt = new TextJx("All inputs are Required, fill them first, Please!", "_game_over");
                ButtonJx ok = new ButtonJx("Ok", "_ok_btn");
                ok.setOnAction(e -> {
                App.winStage.close();
                });
                VBoxJx win_root = new VBoxJx(error_txt, ok);
                win_root.setId("error_root");
                Scene error_scene = new Scene(win_root, 500, 150);
            error_scene.getStylesheets().add(getClass().getResource("css\\win_draw.css").toExternalForm());
            App.winStage.setScene(error_scene);
            App.winStage.setTitle("Input Error");
            App.winStage.getIcons().add(icon);
            App.winStage.show();
        }
        else {
            
            p1_name = "AI";
            p1_mark = 'X';
            p2_name = Player.name_field.getText();
            p2_mark = (Player.mark_field.getText()).charAt(0);

            // creating 2 players with their data
            Player p_AI = new Player(p1_name, p1_mark);
            Player p_human = new Player(p2_name, p2_mark);
            System.out.println("Data of the first person :  Name- " + p_AI.name + ", Mark-  " + p_AI.mark + "\n Data of the second person : Name- " + p_human.name + ", Mark- " + p_human.mark );

            TicTacToe.updatePlayerData(p_AI.name, p_AI.mark, p_human.name, p_human.mark);
            TicTacToe ttt =new TicTacToe("single");
            Mode SinglePlayer = new Mode();
            AnchorPaneJx root = new AnchorPaneJx(TicTacToe.displayBoard());
            root.setId("_game_board");
            Scene singleP_Scene; 
            singleP_Scene = new Scene(root, 1200, 600);
            singleP_Scene.getStylesheets().add(getClass().getResource("css\\play_board.css").toExternalForm());
            primaryStage.setScene(singleP_Scene);
        }

        });

        TicTacToe.quit.setOnAction(event ->{
            TicTacToe.restartFunc();
            primaryStage.setScene(Wellcome.wellC_Scene);
            winStage.close();
        });
    }
}