import controllayout.AnchorPaneJx;
import controllayout.ButtonJx;
import controllayout.GridPaneJx;
import controllayout.VBoxJx;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

public class Mode {
    static AnchorPaneJx root = new AnchorPaneJx();
    // static ButtonJx[][] grid;
    static VBoxJx[][] grid;
    static Scene mode_Scene;
    static ButtonJx singlep = new ButtonJx("Single-Player Mode");
    static ButtonJx multip = new ButtonJx("Multi-Player Mode");
    static ButtonJx rule = new ButtonJx("Rule");

    static ButtonJx back = new ButtonJx("< Back", "_back_btn");
    public Mode(){
        // grid = new ButtonJx[3][3];
        grid = new VBoxJx[3][3];
        labelForming();
        createButton();
    }

    static void labelForming(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                grid[i][j] = new VBoxJx();
                grid[i][j].setAlignment(Pos.CENTER);
                grid[i][j].setPrefHeight(193);
                grid[i][j].setPrefWidth(393);
                grid[i][j].setId("_vbox");
                grid[i][j].setSpacing(10);
            }
        }  
    } 

    private static void createButton() {
        singlep.getStyleClass().add("mode_btn");
        multip.getStyleClass().add("mode_btn");
        rule.getStyleClass().add("mode_btn");
        grid[1][1].getChildren().addAll(singlep, multip, rule);
        grid[0][0].getChildren().add(back);
        grid[0][0].setAlignment(Pos.TOP_LEFT);
        grid[0][0].setPadding(new Insets(20));
    }

    static Scene displayLabel(){
        GridPaneJx label_grid = new GridPaneJx("_mode_root");
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3;j++){
                label_grid.add(grid[i][j], i, j);
            }
        }  
        mode_Scene = new Scene(label_grid, 1200, 600);
        return mode_Scene;
    }
}
