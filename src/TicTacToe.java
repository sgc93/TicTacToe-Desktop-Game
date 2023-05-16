import java.util.Random;
import controllayout.ButtonJx;
import controllayout.GridPaneJx;
import controllayout.HBoxJx;
import controllayout.LabelJx;
import controllayout.TextJx;
import controllayout.VBoxJx;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class TicTacToe {
    static ButtonJx[][] board;
    int i, j;
    static String p1name, p2name;
    static Random r = new Random();
    static Boolean player1_turn;
    Boolean player2_turn;
    static LabelJx name_label1 = new LabelJx("data_label");
    static LabelJx mark_label1 = new LabelJx("data_label");
    static LabelJx move_label1 = new LabelJx("0","data_label");
    static LabelJx win_label1 = new LabelJx("0", "data_label");
    static LabelJx name_label2 = new LabelJx("data_label");
    static LabelJx mark_label2 = new LabelJx("data_label");
    static LabelJx move_label2 = new LabelJx("0", "data_label");
    static LabelJx win_label2 = new LabelJx("0", "data_label");
    static LabelJx turn_label = new LabelJx("_turn_label");
    static ButtonJx quit = new ButtonJx("Quit", "_ok_btn");
    static BackgroundFill bg_fill1 = new BackgroundFill(Color.rgb(0, 224, 255), new CornerRadii(0), new Insets(0,0,0,0));
    BackgroundFill bg_fill2 = new BackgroundFill(Color.rgb(242, 0, 255), new CornerRadii(0), new Insets(0,0,0,0));
    BackgroundFill bg_fill3 = new BackgroundFill(Color.rgb(17, 255, 0), new CornerRadii(0), new Insets(0,0,0,0));
    static BackgroundFill bg_fill4 = new BackgroundFill(Color.RED, new CornerRadii(0), new Insets(0,0,0,0));
    static String game_mode;

    public TicTacToe(String mode){
        TicTacToe.game_mode = mode;
        board = new ButtonJx[3][3];
        initBoard();
        firstTurn();
    }

    void initBoard(){
        for(i = 0; i<board.length; i++){
            for(j = 0; j<board[i].length;j++){
                board[i][j] = new ButtonJx();
                board[i][j].setPrefHeight(150);
                board[i][j].setPrefWidth(150);
                board[i][j].getStyleClass().add("board_btn");
                board[i][j].setAlignment(Pos.CENTER);
                board[i][j].setOnAction(event -> {
                    if(TicTacToe.game_mode.equals("multi") ){
                        mp_gameHandler(event);
                    } else {
                        sp_gameHandler(event);
                    }
                    
                });
            }
        }
    }


    private void mp_gameHandler(ActionEvent event) {
        Background bg1 = new Background(bg_fill1);
        Background bg2 = new Background(bg_fill2);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(event.getSource() == board[i][j]){
                    if(player1_turn){
                        if(board[i][j].getText().equals("")){
                            turn_label.setText(p2name + "'s turn");
                            board[i][j].setBackground(bg1);
                            board[i][j].setText(mark_label1.getText());
                            move_label1.setText(getPlayer1Move());
                            win_label1.setText(getPlayer1Prob() + "%");
                            winChecker();
                            player1_turn = false;
                        }
                    }
                    else{
                        if(board[i][j].getText().equals("")){
                            turn_label.setText(p1name + "'s turn");
                            board[i][j].setBackground(bg2);
                            board[i][j].setText(mark_label2.getText());
                            move_label2.setText(getPlayer2Move());
                            win_label2.setText(getPlayer2Prob() + "%");
                            winChecker();
                            player1_turn = true;
                        }
                    }
                }
            } 
        }
    }

    private void sp_gameHandler(ActionEvent event) {
        Background bg1 = new Background(bg_fill1);
        Background bg2 = new Background(bg_fill2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!player1_turn) {
                    if (event.getSource() == board[i][j]) {
                        if (board[i][j].getText().equals("")) {
                            // Player's move
                            turn_label.setText(p1name + "'s turn");
                            board[i][j].setBackground(bg2);
                            board[i][j].setText(mark_label2.getText());
                            move_label2.setText(getPlayer2Move());
                            win_label2.setText(getPlayer2Prob() + "%");
                            String win = winChecker();
                            if(!(win.equals("win"))){
                                player1_turn = true;
                                // AI player's move
                                if(player1_turn){
                                    int row, col;
                                    do {
                                        row = r.nextInt(3);
                                        col = r.nextInt(3);
                                    } while (!isValid(row, col));
            
                                    System.out.println(row + " " + col);
                                    turn_label.setText(p2name + "'s turn");
                                    board[row][col].setBackground(bg1);
                                    board[row][col].setText(mark_label1.getText());
                                    move_label1.setText(getPlayer1Move());
                                    win_label1.setText(getPlayer1Prob() + "%");
                                    if(!(winChecker().equals("win"))){
                                        player1_turn = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    
    boolean isValid(int row, int col){
        if(row >= 0 && row <= 2 && col >= 0 && col <= 2){
            if(TicTacToe.board[row][col].getText().equals("")){
                return true;
            }
        }
        return false;
    }

    private String winChecker() {
        Background bg3 = new Background(bg_fill3);
        Background bg4 = new Background(bg_fill4);
        Scene win_scene;
        String win = " ";
        if(checkColWin(bg3)){
            win = "win";
            System.out.println("Player 1 won!, column winning");
        } 
        else if(checkRowWin(bg3)){
            win = "win";
            System.out.println("Player 1 won!, row winning");
        } 
        else if(checkCrossWin(bg3)){
            win = "win";
            System.out.println("Player 1 won!, cross winning");
        }
        else if(checkDraw()){
            win = "draw";
            System.out.println("Game Over!, No one have won.");
        }
        
        if(win.equals("win")){
            TextJx game_over = new TextJx("Congrats!, Game finished!", "_game_over");
            ButtonJx restart = new ButtonJx("Restart", "_ok_btn");
            restart.setOnAction(event -> {
                TicTacToe.restartFunc();
            });
            
            HBoxJx win_btn = new HBoxJx(restart, quit);
            VBoxJx win_root = new VBoxJx(game_over, win_btn);
            win_root.setBackground(bg3);
            win_scene = new Scene(win_root, 500, 150);
            win_scene.getStylesheets().add(getClass().getResource("css\\win_draw.css").toExternalForm());
            App.winStage.setScene(win_scene);
            App.winStage.show();
        }
        else if(win.equals("draw")){
            TextJx game_over = new TextJx("DRAW!, GAME OVER!", "_game_over");
            ButtonJx restart = new ButtonJx("Restart", "_ok_btn");
            restart.setOnAction(event -> {
                TicTacToe.restartFunc();
            });
            
            HBoxJx win_btn = new HBoxJx(restart, quit);
            VBoxJx win_root = new VBoxJx(game_over, win_btn);

            win_root.setBackground(bg4);
            win_scene = new Scene(win_root, 500, 150);
            win_scene.getStylesheets().add(getClass().getResource("css\\win_draw.css").toExternalForm());
            App.winStage.setScene(win_scene);
            App.winStage.show();
        }
        return win;
    }

    static void firstTurn(){
        Background bg1 = new Background(bg_fill1);
        if ( r.nextInt(2) == 0){
            player1_turn = true;
            turn_label.setText(p1name + "'s turn");
            int row = r.nextInt(3);
            int col = r.nextInt(3);
            if(game_mode.equals("single") && board[row][col].getText().equals("")){
                turn_label.setText(p2name + "'s turn");
                board[row][col].setBackground(bg1);
                board[row][col].setText(mark_label1.getText());
                move_label1.setText(getPlayer1Move());
                win_label1.setText(getPlayer1Prob() + "%");
                player1_turn = false;
            }
        } else {
            player1_turn = false;
            turn_label.setText(p2name + "'s turn");
        } 
    }

    static VBoxJx displayBoard(){
        
        // player 1
        TextJx name_txt1 = new TextJx("Name : ", "_name");
        HBoxJx name_box1 = new HBoxJx(name_txt1, name_label1);

        TextJx mark_txt1 = new TextJx("Mark : ", "_mark");
        HBoxJx mark_box1 = new HBoxJx(mark_txt1, mark_label1);

        TextJx move_txt1 = new TextJx("Move : ", "_move");
        HBoxJx move_box1 = new HBoxJx(move_txt1, move_label1);

        TextJx win_txt1 = new TextJx("Win Probablity : ", "_pro");
        HBoxJx win_box1 = new HBoxJx(win_txt1, win_label1);

        VBoxJx data_grid_X1 = new VBoxJx(name_box1,mark_box1, move_box1, win_box1);

        // Player 2
        TextJx name_txt2 = new TextJx("Name : ", "_name");
        HBoxJx name_box2 = new HBoxJx(name_txt2, name_label2);

        TextJx mark_txt2 = new TextJx("Mark : ", "_mark");
        HBoxJx mark_box2 = new HBoxJx(mark_txt2, mark_label2);

        TextJx move_txt2 = new TextJx("Move : ", "_move");
        HBoxJx move_box2 = new HBoxJx(move_txt2, move_label2);

        TextJx win_txt2 = new TextJx("Win Probablity : ", "_pro");
        HBoxJx win_box2 = new HBoxJx(win_txt2, win_label2);
        
        VBoxJx data_grid_X2 = new VBoxJx(name_box2, mark_box2, move_box2, win_box2);

        GridPaneJx board_grid = new GridPaneJx();
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3;j++){
                board_grid.addRow(i, board[i][j]);
            }
        }
        board_grid.setId("_baord_grid");

        HBoxJx game_area = new HBoxJx(data_grid_X1, board_grid, data_grid_X2);
        VBoxJx gameBox = new VBoxJx(turn_label, game_area);
        return gameBox;
    }


    static boolean checkColWin(Background bg){
        for(int j = 0; j <= 2; j++){
            if (j == 0 && board[0][j].getText() != "" && board[0][j].getText() == board[1][j].getText() && board[1][j].getText() == board[2][j].getText()){
                board[0][0].setBackground(bg);
                board[1][0].setBackground(bg);
                board[2][0].setBackground(bg);
                return true;
            } 
            else if (j == 1 && board[0][j].getText() != "" && board[0][j].getText() == board[1][j].getText() && board[1][j].getText() == board[2][j].getText()){
                board[0][1].setBackground(bg);
                board[1][1].setBackground(bg);
                board[2][1].setBackground(bg);
                return true;
            }
            else if (j == 2 && board[0][j].getText() != "" && board[0][j].getText() == board[1][j].getText() && board[1][j].getText() == board[2][j].getText()){
                board[0][2].setBackground(bg);
                board[1][2].setBackground(bg);
                board[2][2].setBackground(bg);
                return true;
            }
        }
        return false;
    }

    static boolean checkRowWin(Background bg){
        for(int i = 0; i <= 2; i++){
            if (i == 0 && board[i][0].getText() != "" && board[i][0].getText() == board[i][1].getText() && board[i][1].getText() == board[i][2].getText()){
                board[0][0].setBackground(bg);
                board[0][1].setBackground(bg);
                board[0][2].setBackground(bg);
                return true;
            }
            else if (i == 1 && board[i][0].getText() != "" && board[i][0].getText() == board[i][1].getText() && board[i][1].getText() == board[i][2].getText()){
                board[1][0].setBackground(bg);
                board[1][1].setBackground(bg);
                board[1][2].setBackground(bg);
                return true;
            }
            else if (i == 2 && board[i][0].getText() != "" && board[i][0].getText() == board[i][1].getText() && board[i][1].getText() == board[i][2].getText()){
                board[2][0].setBackground(bg);
                board[2][1].setBackground(bg);
                board[2][2].setBackground(bg);
                return true;
            }
        }
        return false;
    }

    static boolean checkCrossWin(Background bg){
        if (board[0][0].getText() != "" && board[0][0].getText() == board[1][1].getText() && board[1][1].getText() == board[2][2].getText()){
            board[0][0].setBackground(bg);
            board[1][1].setBackground(bg);
            board[2][2].setBackground(bg);
            return true;
        }
        if( board[0][2].getText() != "" && board[0][2].getText() == board[1][1].getText() && board[1][1].getText() == board[2][0].getText()){
            board[0][2].setBackground(bg);
            board[1][1].setBackground(bg);
            board[2][0].setBackground(bg);
            return true;
        }
        return false;
    }

    static boolean checkDraw(){
        Background bg4 = new Background(bg_fill4);
        for(int i = 0; i <= 2; i++){
            for (int j = 0; j <= 2; j++){
                if(board[i][j].getText() == ""){ 
                    return false;
                }
            }
        }
        for(int i = 0; i <= 2; i++){
            for (int j = 0; j <= 2; j++){
                board[i][j].setBackground(bg4);
            }
        }
        return true;
    }

    static void updatePlayerData(String p1_name, char p1_mark,String p2_name ,char p2_mark ){
        p1name = p1_name;
        p2name = p2_name;
        name_label1.setText(p1_name);
        mark_label1.setText(Character.toString(p1_mark));
        name_label2.setText(p2_name);
        mark_label2.setText(Character.toString(p2_mark));
    }

    static String getPlayer1Move(){
        String move_str = move_label1.getText();
        int move_int = Integer.parseInt(move_str);
        move_int += 1;
        move_str = Integer.toString(move_int);
        return move_str;
    }
    static String getPlayer2Move(){
        String move_str = move_label2.getText();
        int move_int = Integer.parseInt(move_str);
        move_int += 1;
        move_str = Integer.toString(move_int);
        return move_str;
    }

    static String getPlayer1Prob(){
        String prob_str = win_label1.getText();
        // get number current number of move
        float move_int = Float.parseFloat(move_label1.getText());
        float prob_int = (move_int / 5) * 100;
        prob_str = Float.toString(prob_int);
        return prob_str;
    }
    static String getPlayer2Prob(){
        String prob_str = win_label2.getText();
        // get number current number of move
        float move_int = Float.parseFloat(move_label2.getText());
        float prob_int = (move_int / 4) * 100;
        prob_str = Float.toString(prob_int);
        return prob_str;
    }

    static void restartFunc() {
        BackgroundFill bg_fill = new BackgroundFill(Color.WHITE, new CornerRadii(0), null);
        Background bg = new Background(bg_fill);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j].setText("");
                board[i][j].setBackground(bg);
            }
        }
        move_label1.setText("0");
        move_label2.setText("0");
        win_label1.setText("0");
        win_label2.setText("0");

        App.winStage.close();
    }
}
