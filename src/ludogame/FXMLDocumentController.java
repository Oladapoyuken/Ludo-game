/*
 * This is a code for a ludo game
 * Capable of handling 2, 3 and 4 users
 * Enjoy...
 */
package ludogame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Yuken4real
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private Button homeBT1, homeBT3, homeBT4, homeBT2;
    @FXML
    private Button homeRT1, homeRT3, homeRT4, homeRT2;
    @FXML
    private Button homeGT1, homeGT3, homeGT4, homeGT2;
    @FXML
    private Button homeYT1, homeYT3, homeYT4, homeYT2;
    @FXML
    private Button rollBut;
    @FXML
    private TextField rollSpace1, rollSpace2;
    
    @FXML
    public Button box00,
        box01, box02, box03, box04, box05, box06, box07, box08, box09, 
        box10, box11, box12, box13, box14, box15, box16, box17, box18, 
        box19, box20, box21, box22, box23, box24, box25, box26, box27, 
        box28, box29, box30, box31, box32, box33, box34, box35, box36, 
        box37, box38, box39, box40, box41, box42, box43, box44, box45, 
        box46, box47, box48, box49, box50, box51, box52, enB52, enB53, 
        enB54, enB55, enB56, enR13, enR14, enR15, enR16, enR17, enG26,
        enG27, enG28, enG29, enG30, enY39, enY40, enY41, enY42, enY43;
    
    
    public int[] boxValue = {
        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
        0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    };
     
    public int rolledNum1 = 0, rolledNum2 = 0, playerNumber = 0, winner = 0;
    
    public boolean toggle = true,first = true, second = false, third = false, fourth = false,
                    bn = false, rn = false, gn = false, yn = false, blueCont = true, redCont = true,
                    greenCont = true, yellowCont = true, comB = false, comR = false, comG = false,
                    comY = false,rcheck = true, gcheck = true, ycheck = true, bcheck = true,
                    bEnd = true, rEnd = true, yEnd = true, gEnd = true;
    
    
    
    public int[] selectBlueTile = {0,0,0,0};
    public int[] selectRedTile = {0,0,0,0};
    public int[] selectYellowTile = {0,0,0,0};
    public int[] selectGreenTile = {0,0,0,0};
    
    
    public Button[] road = new Button[73];
     
    public Button[] BlueRoad;
    public Button[] RedRoad;
    public Button[] GreenRoad;
    public Button[] YellowRoad;
    
    public Button[] allButtons;
    
    public Button[] BlueRoadEnd;
    public Button[] RedRoadEnd;
    public Button[] GreenRoadEnd;
    public Button[] YellowRoadEnd;
    
    
    public Button[] allBlueBut = new Button[4];
    public Button[] allRedBut = new Button[4];
    public Button[] allYellowBut = new Button[4];
    public Button[] allGreenBut = new Button[4];
    @FXML
    private RadioButton twoPlayers;
    @FXML
    private RadioButton threePlayers;
    @FXML
    private RadioButton fourPlayers;
    @FXML
    private Button playerOne;
    @FXML
    private Button playerTwo;
    @FXML
    private Button playerThree;
    @FXML
    private Button playerFour;
    @FXML
    private Label note, p1Lab, p2Lab, p3Lab, p4Lab, winOne, winTwo, winThree, winFour;
    @FXML
    private Button resetBut;
    @FXML
    private AnchorPane ludoFrame;
    @FXML
    private Button escapeBut;
    @FXML
    private SplitPane splitPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeTiles();
        
    } 
    
    //Start blue tile at home
    @FXML
    private void moveBT(ActionEvent event) throws FileNotFoundException {
        Button bt = (Button)event.getSource();
        String s = bt.getText().substring(6);
        int homeNo = Integer.parseInt(s);
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a; int holdB = b;
        int counter = 0;
        if(playerNumber == 4){
            if (homeNo == 1) {
                allBlueBut[0].setGraphic(null);
                allBlueBut[0].setDisable(true);
                allBlueBut[0].setId("0");

            } else if (homeNo == 2) {
                allBlueBut[1].setGraphic(null);
                allBlueBut[1].setDisable(true);
                allBlueBut[1].setId("0");
            } else if (homeNo == 3) {
                allBlueBut[2].setGraphic(null);
                allBlueBut[2].setDisable(true);
                allBlueBut[2].setId("0");
            } else if (homeNo == 4) {
                allBlueBut[3].setGraphic(null);
                allBlueBut[3].setDisable(true);
                allBlueBut[3].setId("0");
            }
            for(Button bx : road){
                if(bx.getId().equals("bt1")){
                    counter++;   
                }
                else if(bx.getId().equals("bt2") || bx.getId().equals("bt3") || bx.getId().equals("bt4")){
                    counter = 2;
                }
            }
            
            if(counter == 0 && (holdA != 6 || holdB != 6)){
                autoBlue();
                disableHBlue();
                if(redCont == true){
                    first = false;
                    second = true;
                    third = false;
                    fourth = false;
                }
                else if(yellowCont == true){
                    first = false;
                    second = false;
                    third = true;
                    fourth = false;
                }
                else if(greenCont == true){
                    second = false;
                    first = false;
                    third = false;
                    fourth = true;
                }
                else{
                    note.setText("Game Over");
                    gameOver();
                    
                }
            }
            else{
                if(box01.getId().equals("bt1")){
                    box01.setGraphic(showBlue(2));
                    box01.setId("bt2");
                    
                }
                else if(box01.getId().equals("bt2")){
                    box01.setGraphic(showBlue(3));
                    box01.setId("bt3");
                    
                }
                else if(box01.getId().equals("bt3")){
                    box01.setGraphic(showBlue(4));
                    box01.setId("bt4");
                    
                }
                else if(box01.getId().equals("0")){
                    box01.setGraphic(showBlue(1));
                    box01.setId("bt1");
                    
                }
                
                else{
                    bluePower(box01);
                    showBprogress();
                }
                if (toggle == true) {
                    toggle = false;
                    disableGreen();
                    disableRed();
                    disableYellow();
                    bcheck = true ; bEnd = true;
                    rollBut.setDisable(true);
                    bn = true;
                    if(holdA != 6){
                        disableHBlue();
                    }
                    else if(holdB != 6){
                        disableHBlue();
                    }
                    else{
                        enableHBlue();
                    }
                    enableBlue();
                }
                else if(toggle == false) {
                    toggle = true;
                    rollBut.setDisable(false);
                    blueDouble(holdA, holdB);

                    disableHBlue();
                    disableBlue();
                }
                for(Button chk : allBlueBut){
                    if(chk.getId() != "bt1"){
                        chk.setDisable(true);
                    }
                }
            }
        }
        
        //when playerNumbers are equal to 2
        else if(playerNumber == 2){
            if (homeNo == 1) {
                allBlueBut[0].setGraphic(null);
                allBlueBut[0].setDisable(true);
                allBlueBut[0].setId("0");

            } else if (homeNo == 2) {
                allBlueBut[1].setGraphic(null);
                allBlueBut[1].setDisable(true);
                allBlueBut[1].setId("0");
            } else if (homeNo == 3) {
                allBlueBut[2].setGraphic(null);
                allBlueBut[2].setDisable(true);
                allBlueBut[2].setId("0");
            } else if (homeNo == 4) {
                allBlueBut[3].setGraphic(null);
                allBlueBut[3].setDisable(true);
                allBlueBut[3].setId("0");
            }
            for(Button bx : road){
                if( bx.getId().equals("bt1") || bx.getId().equals("rt1")){
                    counter++;   
                }
                else if(bx.getId().equals("bt2") || bx.getId().equals("rt2") || 
                    bx.getId().equals("bt3") || bx.getId().equals("rt3") || 
                    bx.getId().equals("bt4") || bx.getId().equals("rt4") ||
                    bx.getId().equals("b1r1") || bx.getId().equals("b2r1") ||
                    bx.getId().equals("b1r2") || bx.getId().equals("b2r2") ||
                    bx.getId().equals("b1r3") || bx.getId().equals("b2r3") ||
                    bx.getId().equals("b1r4") || bx.getId().equals("b2r4") ||
                    bx.getId().equals("b3r1") || bx.getId().equals("b4r1") ||
                    bx.getId().equals("b3r2") || bx.getId().equals("b4r2") ||
                    bx.getId().equals("b3r3") || bx.getId().equals("b4r3") ||
                    bx.getId().equals("b3r4") || bx.getId().equals("b4r4")){

                    counter = 2;
                }
            }
            if(counter == 0 && (holdA != 6 || holdB != 6)){
                autoBlue2();
                disableHBlue();
                disableHRed();
                disableBlue();
                disableRed();
                if(holdA == 6 && holdB == 6){
                    if(redCont == true || blueCont == true){
                        first = true;
                        second = true;
                        third = false;
                        fourth = false;
                    }
                    else{
                        note.setText("GAME OVER");
                        gameOver();
                    }
                }
                else{
                   if(yellowCont == true || greenCont == true){
                        first = false;
                        second = false;
                        third = true;
                        fourth = true;
                    }
                    else{
                       note.setText("GAME OVER");
                        gameOver();
                    }

                }
            }
            else{
                if (toggle == true) {
                    toggle = false;
                    bcheck = false ; bEnd = true;
                    if(holdA == 6 && holdB == 6){
                        enableHBlue();
                        enableHRed();
                        enableBlue();
                        enableRed();
                    }
                    else{
                        disableHRed();
                        disableHBlue();
                        enableBlue();
                        enableRed();
                    }
                    rollBut.setDisable(true);
                    bn = true;
                    enableBlue();
                    enableRed();
                }
                else if(toggle == false) {
                    toggle = true;
                    bcheck = true ; bEnd = false;
                    rollBut.setDisable(false);
                    if(holdA == 6 && holdB == 6){
                        if(blueCont == true || redCont == true){
                            first = true;
                            second = true;
                            third = false;
                            fourth = false;
                        }
                        else if(yellowCont == true || greenCont == true){
                            first = false;
                            second = false;
                            third = true;
                            fourth = true;
                        }
                        
                        else{
                            note.setText("GAME OVER");
                            gameOver();
                        }
                    }
                    else{
                        if(yellowCont == true || greenCont == true){
                            first = false;
                            second = false;
                            third = true;
                            fourth = true;
                        }
                        else{
                            note.setText("PLAYER TWO WIN");
                            gameOver();
                        }

                    }

                    disableHBlue();
                    disableHRed();
                    enableBlue();
                    enableRed();
                }
                if(box01.getId().equals("bt1")){
                    box01.setGraphic(showBlue(2));
                    box01.setId("bt2");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box01.getId().equals("bt2")){
                    box01.setGraphic(showBlue(3));
                    box01.setId("bt3");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box01.getId().equals("bt3")){
                    box01.setGraphic(showBlue(4));
                    box01.setId("bt4");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box01.getId().equals("0")){
                    box01.setGraphic(showBlue(1));
                    box01.setId("bt1");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box01.getId().equals("rt1")){
                    box01.setGraphic(showBlueRed(1,1));
                    box01.setId("b1r1");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box01.getId().equals("rt2")){
                    box01.setGraphic(showBlueRed(1,2));
                    box01.setId("b1r2");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box01.getId().equals("rt3")){
                    box01.setGraphic(showBlueRed(1,3));
                    box01.setId("b1r3");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box01.getId().equals("rt4")){
                    box01.setGraphic(showBlueRed(1,4));
                    box01.setId("b1r4");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box01.getId().equals("b1r1")){
                    box01.setGraphic(showBlueRed(2,1));
                    box01.setId("b2r1");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }   
                }
                else if(box01.getId().equals("b2r1")){
                    box01.setGraphic(showBlueRed(3,1));
                    box01.setId("b3r1");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box01.getId().equals("b3r1")){
                    box01.setGraphic(showBlueRed(4,1));
                    box01.setId("b4r1");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }    
                }

                else if(box01.getId().equals("b1r2")){
                    box01.setGraphic(showBlueRed(2,2));
                    box01.setId("b2r2");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                    
                }
                else if(box01.getId().equals("b2r2")){
                    box01.setGraphic(showBlueRed(3,2));
                    box01.setId("b3r2");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                    
                }
                else if(box01.getId().equals("b3r2")){
                    box01.setGraphic(showBlueRed(4,2));
                    box01.setId("b4r2");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }

                else if(box01.getId().equals("b1r3")){
                    box01.setGraphic(showBlueRed(2,3));
                    box01.setId("b2r3");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box01.getId().equals("b2r3")){
                    box01.setGraphic(showBlueRed(3,3));
                    box01.setId("b3r3");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box01.getId().equals("b3r3")){
                    box01.setGraphic(showBlueRed(4,3));
                    box01.setId("b4r3");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }

                else if(box01.getId().equals("b1r4")){
                    box01.setGraphic(showBlueRed(2,4));
                    box01.setId("b2r4");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box01.getId().equals("b2r4")){
                    box01.setGraphic(showBlueRed(3,4));
                    box01.setId("b3r4");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box01.getId().equals("b3r4")){
                    box01.setGraphic(showBlueRed(4,4));
                    box01.setId("b4r4");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                
                else{
                    bluePower2(box01);
                    showBprogress();
                }

                
                
                
                for(Button chk : allBlueBut){
                    if(chk.getId() != "bt1"){
                        chk.setDisable(true);
                    }
                }
                for(Button chk : allRedBut){
                    if(chk.getId() != "rt1"){
                        chk.setDisable(true);
                    }
                }
            }
        }
    }
    
    
    
    @FXML
    private void moveRT(ActionEvent event) throws FileNotFoundException {
        Button bt = (Button)event.getSource();
        String s = bt.getText().substring(6);
        int homeNo = Integer.parseInt(s);
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a;
        int holdB = b;
        int counter = 0;
        if(playerNumber == 4){
            for(Button bx : road){
                if(bx.getId().equals("rt1")){
                    counter++;   
                }
                else if(bx.getId().equals("rt2") || bx.getId().equals("rt3") || bx.getId().equals("rt4")){
                    counter = 2;
                }
            }
            if(homeNo == 1){
                allRedBut[0].setDisable(true);
                allRedBut[0].setGraphic(null);
                allRedBut[0].setId("0");
            }
            else if(homeNo == 2){
                allRedBut[1].setDisable(true);
                allRedBut[1].setGraphic(null);
                allRedBut[1].setId("0");
            }
            else if(homeNo == 3){
                allRedBut[2].setDisable(true);
                allRedBut[2].setGraphic(null);
                allRedBut[2].setId("0");
            }
            else if(homeNo == 4){
                allRedBut[3].setDisable(true);
                allRedBut[3].setGraphic(null);
                allRedBut[3].setId("0");
            }
            if(counter == 0 && (holdA != 6 || holdB != 6)){
                autoRed();
                disableHRed();
                if(yellowCont == true){
                    first = false;
                    second = false;
                    third = true;
                    fourth = false;
                }
                else if(greenCont == true){
                    first = false;
                    second = false;
                    third = false;
                    fourth = true;
                }
                else if(blueCont == true){
                    first = true;
                    second = false;
                    third = false;
                    fourth = false;
                }
                else{
                    note.setText("GAME OVER");
                    gameOver();
                }
                
            }
            else{
                if(box14.getId().equals("rt1")){
                    box14.setGraphic(showRed(2));
                    box14.setId("rt2");
                    boxValue[14] = 2;
                }
                else if(box14.getId().equals("rt2")){
                    box14.setGraphic(showRed(3));
                    box14.setId("rt3");
                    boxValue[14] = 2;
                }
                else if(box14.getId().equals("rt3")){
                    box14.setGraphic(showRed(4));
                    box14.setId("rt4");
                    boxValue[14] = 2;
                }
                else if(box14.getId().equals("0")){
                    box14.setGraphic(showRed(1));
                    box14.setId("rt1");
                    boxValue[14] = 2;
                }
                else{
                    redPower(box14);
                    showRprogress();
                }
                if (toggle == true) {
                    toggle = false;
                    disableGreen();
                    disableBlue();
                    disableYellow();
                    rcheck = true ; rEnd = true;
                    rollBut.setDisable(true);
                    bn = true;
                    if(holdA != 6){
                        disableHRed();
                    }
                    else if(holdB != 6){
                        disableHRed();
                    }
                    else{
                        enableHRed();
                    }
                    enableRed();
                }
                else if(toggle == false) {
                    toggle = true;
                    rollBut.setDisable(false);
                    redDouble(holdA, holdB);
                    disableRed();
                    disableHRed();       
                }
                
                for(Button chk : allRedBut){
                    if(chk.getId() != "rt1"){
                        chk.setDisable(true);
                    }
                }
            }
        }
        else if(playerNumber == 2){
            
            for(Button bx : road){
                if( bx.getId().equals("bt1") || bx.getId().equals("rt1")){
                    counter++;   
                }
                else if(bx.getId().equals("bt2") || bx.getId().equals("rt2") || 
                    bx.getId().equals("bt3") || bx.getId().equals("rt3") || 
                    bx.getId().equals("bt4") || bx.getId().equals("rt4") ||
                    bx.getId().equals("b1r1") || bx.getId().equals("b2r1") ||
                    bx.getId().equals("b1r2") || bx.getId().equals("b2r2") ||
                    bx.getId().equals("b1r3") || bx.getId().equals("b2r3") ||
                    bx.getId().equals("b1r4") || bx.getId().equals("b2r4") ||
                    bx.getId().equals("b3r1") || bx.getId().equals("b4r1") ||
                    bx.getId().equals("b3r2") || bx.getId().equals("b4r2") ||
                    bx.getId().equals("b3r3") || bx.getId().equals("b4r3") ||
                    bx.getId().equals("b3r4") || bx.getId().equals("b4r4")){

                    counter = 2;
                }
            }
            if(homeNo == 1){
                allRedBut[0].setDisable(true);
                allRedBut[0].setGraphic(null);
                allRedBut[0].setId("0");
            }
            else if(homeNo == 2){
                allRedBut[1].setDisable(true);
                allRedBut[1].setGraphic(null);
                allRedBut[1].setId("0");
            }
            else if(homeNo == 3){
                allRedBut[2].setDisable(true);
                allRedBut[2].setGraphic(null);
                allRedBut[2].setId("0");
            }
            else if(homeNo == 4){
                allRedBut[3].setDisable(true);
                allRedBut[3].setGraphic(null);
                allRedBut[3].setId("0");
            }
            if(counter == 0 && (holdA != 6 || holdB != 6)){
                autoRed2();
                disableHRed();
                disableHBlue();
                disableRed();
                disableBlue();
                if(yellowCont == true || greenCont == true){
                    first = false;
                    second = false;
                    third = true;
                    fourth = true;
                }
                else{
                   note.setText("GAME OVER");
                    gameOver();
                }
                
            }
            else{
                if (toggle == true) {
                    toggle = false;
                    bcheck = false ; bEnd = true;
                    if(holdA == 6 && holdB == 6){
                        enableHRed();
                        enableHBlue();
                    }
                    else{
                        disableHBlue();
                        disableHRed();
                    }
                    rollBut.setDisable(true);
                    bn = true;
                    enableRed();
                    enableBlue();
                }
                else if(toggle == false) {
                    toggle = true;
                    bcheck = true ; bEnd = false;
                    rollBut.setDisable(false);
                    if(holdA == 6 && holdB == 6){
                        if(redCont == true || blueCont == true){
                            first = true;
                            second = true;
                            third = false;
                            fourth = false;
                        }
                        
                        else{
                            note.setText("GAME OVER");
                            gameOver();
                        }
                    }
                    else{
                       if(yellowCont == true || greenCont == true){
                            first = false;
                            second = false;
                            third = true;
                            fourth = true;
                        }
                        else{
                           note.setText("GAME OVER");
                            gameOver();
                        }

                    }
                    disableHBlue();
                    disableHRed();
                    enableBlue();
                    enableRed();
                }
                
                if(box14.getId().equals("rt1")){
                    box14.setGraphic(showRed(2));
                    box14.setId("rt2");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box14.getId().equals("rt2")){
                    box14.setGraphic(showRed(3));
                    box14.setId("rt3");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box14.getId().equals("rt3")){
                    box14.setGraphic(showRed(4));
                    box14.setId("rt4");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box14.getId().equals("0")){
                    box14.setGraphic(showRed(1));
                    box14.setId("rt1");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box14.getId().equals("bt1")){
                    box14.setGraphic(showBlueRed(1,1));
                    box14.setId("b1r1");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else if(box14.getId().equals("bt2")){
                    box14.setGraphic(showBlueRed(1,2));
                    box14.setId("b2r1");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box14.getId().equals("bt3")){
                    box14.setGraphic(showBlueRed(1,3));
                    box14.setId("b3r1");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box14.getId().equals("bt4")){
                    box14.setGraphic(showBlueRed(1,4));
                    box14.setId("b4r1");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }

                else if(box14.getId().equals("b1r1")){
                    box14.setGraphic(showBlueRed(1,2));
                    box14.setId("b1r2");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box14.getId().equals("b1r2")){
                    box14.setGraphic(showBlueRed(1,3));
                    box14.setId("b1r3");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box14.getId().equals("b1r3")){
                    box14.setGraphic(showBlueRed(1,4));
                    box14.setId("b1r4");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }

                else if(box14.getId().equals("b2r1")){
                    box14.setGraphic(showBlueRed(2,2));
                    box14.setId("b2r2");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box14.getId().equals("b2r2")){
                    box14.setGraphic(showBlueRed(2,3));
                    box14.setId("b2r3");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box14.getId().equals("b2r3")){
                    box14.setGraphic(showBlueRed(2,4));
                    box14.setId("b2r4");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }

                else if(box14.getId().equals("b3r1")){
                    box14.setGraphic(showBlueRed(3,2));
                    box14.setId("b3r2");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box14.getId().equals("b3r2")){
                    box14.setGraphic(showBlueRed(3,3));
                    box14.setId("b3r3");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box14.getId().equals("b3r3")){
                    box14.setGraphic(showBlueRed(3,4));
                    box14.setId("b3r4");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }

                else if(box14.getId().equals("b4r1")){
                    box14.setGraphic(showBlueRed(4,2));
                    box14.setId("b4r2");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box14.getId().equals("b4r2")){
                    box14.setGraphic(showBlueRed(4,3));
                    box14.setId("b4r3");
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                    
                }
                else if(box14.getId().equals("b4r3")){
                    box14.setGraphic(showBlueRed(4,4));
                    box14.setId("b4r4");   
                    if(bcheck == true){
                        disableBlue(); disableRed();
                    }
                }
                else{
                    redPower2(box14);
                    showRprogress();
                }
                
                
                for(Button chk : allRedBut){
                    if(chk.getId() != "rt1"){
                        chk.setDisable(true);
                    }
                }
                for(Button chk : allBlueBut){
                    if(chk.getId() != "bt1"){
                        chk.setDisable(true);
                    }
                }
            }
            
        }
    }
    
    @FXML
    private void moveGT(ActionEvent event) throws FileNotFoundException {
        Button bt = (Button)event.getSource();
        String s = bt.getText().substring(6);
        int homeNo = Integer.parseInt(s);
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a;
        int holdB = b;
        int counter = 0;
        if(playerNumber == 4){
            for(Button bx : road){
                if(bx.getId().equals("gt1")){
                    counter++;   
                }
                else if(bx.getId().equals("gt2") || bx.getId().equals("gt3") || bx.getId().equals("gt4")){
                    counter = 2;
                }
            }
            if(homeNo == 1){
            allGreenBut[0].setDisable(true);
            allGreenBut[0].setGraphic(null);
            allGreenBut[0].setId("0");
            }
            else if(homeNo == 2){
                allGreenBut[1].setDisable(true);
                allGreenBut[1].setGraphic(null);
                allGreenBut[1].setId("0");
            }
            else if(homeNo == 3){
                allGreenBut[2].setDisable(true);
                allGreenBut[2].setGraphic(null);
                allGreenBut[2].setId("0");
            }
            else if(homeNo == 4){
                allGreenBut[3].setDisable(true);
                allGreenBut[3].setGraphic(null);
                allGreenBut[3].setId("0");
            }
            if(counter == 0 && (holdA != 6 || holdB != 6)){
                autoGreen();
                disableHGreen();
//                fourth = false;
                if(blueCont == true){
                    first = true;
                    second = false;
                    third = false;
                    fourth = false;
                }
                else if(redCont == true){
                    first = false;
                    second = true;
                    third = false;
                    fourth = false;
                }
                else if(yellowCont == true){
                    first = false;
                    second = false;
                    third = true;
                    fourth = false;
                }
                else{
                    note.setText("GAME OVER");
                    gameOver();
                }
            }
            else{
                if(box27.getId().equals("gt1")){
                    box27.setGraphic(showGreen(2));
                    box27.setId("gt2");
                    boxValue[27] = 4;
                }
                else if(box27.getId().equals("gt2")){
                    box27.setGraphic(showGreen(3));
                    box27.setId("gt3");
                    boxValue[27] = 4;
                }
                else if(box27.getId().equals("gt3")){
                    box27.setGraphic(showGreen(4));
                    box27.setId("gt4");
                    boxValue[27] = 4;
                }
                else if(box27.getId().equals("0")){
                    box27.setGraphic(showGreen(1));
                    box27.setId("gt1");
                    boxValue[27] = 4;
                }
                else{
                    greenPower(box27);
                    showGprogress();
                }
                
                if (toggle == true) {
                    toggle = false;
                    gcheck = true; gEnd = true;
                    disableRed();
                    disableBlue();
                    disableYellow();
                    enableGreen();
                    rollBut.setDisable(true);
                    bn = true;
                    if(holdA != 6){
                        disableHGreen();
                    }
                    else if(holdB != 6){
                        disableHGreen();
                    }
                    else{
                        enableHGreen();
                    }
                }
                else if(toggle == false) {
                    toggle = true;
                    rollBut.setDisable(false);
                    greenDouble(holdA, holdB);
                    disableGreen();
                    disableHGreen();
                    
                }
                
                for(Button chk : allGreenBut){
                    if(chk.getId() != "gt1"){
                        chk.setDisable(true);
                    }
                }
            }
        } 
        else if(playerNumber == 2){
            if(homeNo == 1){
                allGreenBut[0].setDisable(true);
                allGreenBut[0].setGraphic(null);
                allGreenBut[0].setId("0");
            }
            else if(homeNo == 2){
                allGreenBut[1].setDisable(true);
                allGreenBut[1].setGraphic(null);
                allGreenBut[1].setId("0");
            }
            else if(homeNo == 3){
                allGreenBut[2].setDisable(true);
                allGreenBut[2].setGraphic(null);
                allGreenBut[2].setId("0");
            }
            else if(homeNo == 4){
                allGreenBut[3].setDisable(true);
                allGreenBut[3].setGraphic(null);
                allGreenBut[3].setId("0");
            }
            
            for(Button bx : road){
                if( bx.getId().equals("yt1") || bx.getId().equals("gt1")){
                    counter++;   
                }
                else if(bx.getId().equals("yt2") || bx.getId().equals("gt2") || 
                    bx.getId().equals("yt3") || bx.getId().equals("gt3") || 
                    bx.getId().equals("yt4") || bx.getId().equals("gt4") ||
                    bx.getId().equals("y1g1") || bx.getId().equals("y2g1") ||
                    bx.getId().equals("y1g2") || bx.getId().equals("y2g2") ||
                    bx.getId().equals("y1g3") || bx.getId().equals("y2g3") ||
                    bx.getId().equals("y1g4") || bx.getId().equals("y2g4") ||
                    bx.getId().equals("y3g1") || bx.getId().equals("y4g1") ||
                    bx.getId().equals("y3g2") || bx.getId().equals("y4g2") ||
                    bx.getId().equals("y3g3") || bx.getId().equals("y4g3") ||
                    bx.getId().equals("y3g4") || bx.getId().equals("y4g4")){

                    counter = 2;
                }
            }
            if(counter == 0 && (holdA != 6 || holdB != 6)){
                autoGreen2();
                disableHYellow();
                disableHGreen();
                disableYellow();
                disableGreen();
                if(blueCont == true || redCont == true){
                    first = true;
                    second = true;
                    third = false;
                    fourth = false;
                }
                else{
                   note.setText("GAME OVER");
                    gameOver();
                }
            }
            else{
                if (toggle == true) {
                    toggle = false;
                    ycheck = false;yEnd = true;
                    if(holdA == 6 && holdB == 6){
                        enableHYellow();
                        enableHGreen();
                        enableYellow();
                        enableGreen();
                    }
                    else{
                        disableHYellow();
                        disableHGreen();
                        enableYellow();
                        enableGreen();
                    }
                    rollBut.setDisable(true);
                    bn = true;
                }
                else if(toggle == false) {
                    toggle = true;
                    ycheck = true; yEnd = false;
                    rollBut.setDisable(false);
                    if(holdA == 6 && holdB == 6){
                        if(greenCont == true || yellowCont == true){
                            first = false;
                            second = false;
                            third = true;
                            fourth = true;
                        }
                        else{
                            note.setText("GAME OVER");
                            gameOver();
                        }
                    }
                    else{
                       if(blueCont == true || redCont == true){
                            first = true;
                            second = true;
                            third = false;
                            fourth = false;
                        }
                        else{
                            note.setText("PLAYER ONE WIN");
                            gameOver();
                        }

                    }
                    disableHYellow();
                    disableHGreen();
                    
                }
                enableYellow();
                enableGreen();
                
                if(box27.getId().equals("gt1")){
                    box27.setGraphic(showGreen(2));
                    box27.setId("gt2");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("gt2")){
                    box27.setGraphic(showGreen(3));
                    box27.setId("gt3");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("gt3")){
                    box27.setGraphic(showGreen(4));
                    box27.setId("gt4");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("0")){
                    box27.setGraphic(showGreen(1));
                    box27.setId("gt1");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("yt1")){
                    box27.setGraphic(showYellowGreen(1,1));
                    box27.setId("y1g1"); 
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("yt2")){
                    box27.setGraphic(showYellowGreen(2,1));
                    box27.setId("y2g1");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("yt3")){
                    box27.setGraphic(showYellowGreen(3,1));
                    box27.setId("y3g1");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("yt4")){
                    box27.setGraphic(showYellowGreen(4,1));
                    box27.setId("y4g1");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y1g1")){
                    box27.setGraphic(showYellowGreen(1,2));
                    box27.setId("y1g2");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y2g1")){
                    box27.setGraphic(showYellowGreen(2,2));
                    box27.setId("y2g2");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y3g1")){
                    box27.setGraphic(showYellowGreen(3,2));
                    box27.setId("y3g2");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y4g1")){
                    box27.setGraphic(showYellowGreen(4,2));
                    box27.setId("y4g2");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y1g2")){
                    box27.setGraphic(showYellowGreen(1,3));
                    box27.setId("y1g3");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y2g2")){
                    box27.setGraphic(showYellowGreen(2,3));
                    box27.setId("y2g3");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y3g2")){
                    box27.setGraphic(showYellowGreen(3,3));
                    box27.setId("y3g3");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y4g2")){
                    box27.setGraphic(showYellowGreen(4,3));
                    box27.setId("y4g3");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y1g3")){
                    box27.setGraphic(showYellowGreen(1,4));
                    box27.setId("y1g4");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y2g3")){
                    box27.setGraphic(showYellowGreen(2,4));
                    box27.setId("y2g4");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box27.getId().equals("y3g3")){
                    box27.setGraphic(showYellowGreen(3,4));
                    box27.setId("y3g4");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }

                else if(box27.getId().equals("y4g3")){
                    box27.setGraphic(showYellowGreen(4,4));
                    box27.setId("y4g4");
                    if( ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else{
                    greenPower2(box27);
                    showGprogress();
                }
                
                
                for(Button chk : allGreenBut){
                    if(chk.getId() != "gt1"){
                        chk.setDisable(true);
                    }
                }
                for(Button chk : allYellowBut){
                    if(chk.getId() != "yt1"){
                        chk.setDisable(true);
                    }
                }
            }
        }
    }
    
    
    @FXML
    private void moveYT(ActionEvent event) throws FileNotFoundException {
        Button bt = (Button)event.getSource();
        String s = bt.getText().substring(6);
        int homeNo = Integer.parseInt(s);
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a;
        int holdB = b;
        int counter = 0;
        if(playerNumber == 4){
            for(Button bx : road){
                if(bx.getId().equals("yt1")){
                    counter++;   
                }
                else if(bx.getId().equals("yt2") || bx.getId().equals("yt3") || bx.getId().equals("yt4")){
                    counter = 2;
                }
            }
            if(homeNo == 1){
                allYellowBut[0].setDisable(true);
                allYellowBut[0].setGraphic(null);
                allYellowBut[0].setId("0");
            }
            else if(homeNo == 2){
                allYellowBut[1].setDisable(true);
                allYellowBut[1].setGraphic(null);
                allYellowBut[1].setId("0");
            }
            else if(homeNo == 3){
                allYellowBut[2].setDisable(true);
                allYellowBut[2].setGraphic(null);
                allYellowBut[2].setId("0");
            }
            else if(homeNo == 4){
                allYellowBut[3].setDisable(true);
                allYellowBut[3].setGraphic(null);
                allYellowBut[3].setId("0");
            }
            if(counter == 0 && (holdA != 6 || holdB != 6)){
                autoYellow();
                disableHYellow();
//                third = false;
                if(greenCont == true){
                    first = false;
                    second = false;
                    third = false;
                    fourth = true;
                }
                else if(blueCont == true){
                    first = true;
                    second = false;
                    third = false;
                    fourth = false;
                }
                else if(redCont == true){
                    first = false;
                    second = true;
                    third = false;
                    fourth = false;
                }
                else{
                    note.setText("GAME OVER");
                    gameOver();
                }
            }
            else{
                if(box40.getId().equals("yt1")){
                    box40.setGraphic(showYellow(2));
                    box40.setId("yt2");
                    boxValue[40] = 3;
                }
                else if(box40.getId().equals("yt2")){
                    box40.setGraphic(showYellow(3));
                    box40.setId("yt3");
                    boxValue[40] = 3;
                }
                else if(box40.getId().equals("yt3")){
                    box40.setGraphic(showYellow(4));
                    box40.setId("yt4");
                    boxValue[40] = 3;
                }
                else if(box40.getId().equals("0")){
                    box40.setGraphic(showYellow(1));
                    box40.setId("yt1");
                    boxValue[40] = 3;
                }
                else{
                    yellowPower(box40);
                    showYprogress();
                }
                if (toggle == true) {
                    toggle = false;
                    ycheck = true; yEnd = true;
                    disableGreen();
                    disableBlue();
                    disableRed();
                    enableYellow();
                    rollBut.setDisable(true);
                    bn = true;
                    if(holdA != 6){
                        disableHYellow();
                    }
                    else if(holdB != 6){
                        disableHYellow();
                    }
                    else{
                        enableHYellow();
                    }
                }
                else if(toggle == false) {
                    toggle = true;
                    rollBut.setDisable(false);
                    yellowDouble(holdA, holdB);
                    disableHYellow();
                    disableYellow();
                }
                for(Button chk : allYellowBut){
                    if(chk.getId() != "yt1"){
                        chk.setDisable(true);
                    }
                }
            }            
        }
        else if(playerNumber == 2){
            
            if(homeNo == 1){
                allYellowBut[0].setDisable(true);
                allYellowBut[0].setGraphic(null);
                allYellowBut[0].setId("0");
            }
            else if(homeNo == 2){
                allYellowBut[1].setDisable(true);
                allYellowBut[1].setGraphic(null);
                allYellowBut[1].setId("0");
            }
            else if(homeNo == 3){
                allYellowBut[2].setDisable(true);
                allYellowBut[2].setGraphic(null);
                allYellowBut[2].setId("0");
            }
            else if(homeNo == 4){
                allYellowBut[3].setDisable(true);
                allYellowBut[3].setGraphic(null);
                allYellowBut[3].setId("0");
            }
            for(Button bx : road){
                if( bx.getId().equals("yt1") || bx.getId().equals("gt1")){
                    counter++;   
                }
                else if(bx.getId().equals("yt2") || bx.getId().equals("gt2") || 
                    bx.getId().equals("yt3") || bx.getId().equals("gt3") || 
                    bx.getId().equals("yt4") || bx.getId().equals("gt4") ||
                    bx.getId().equals("y1g1") || bx.getId().equals("y2g1") ||
                    bx.getId().equals("y1g2") || bx.getId().equals("y2g2") ||
                    bx.getId().equals("y1g3") || bx.getId().equals("y2g3") ||
                    bx.getId().equals("y1g4") || bx.getId().equals("y2g4") ||
                    bx.getId().equals("y3g1") || bx.getId().equals("y4g1") ||
                    bx.getId().equals("y3g2") || bx.getId().equals("y4g2") ||
                    bx.getId().equals("y3g3") || bx.getId().equals("y4g3") ||
                    bx.getId().equals("y3g4") || bx.getId().equals("y4g4")){

                    counter = 2;
                }
            }
            if(counter == 0 && (holdA != 6 || holdB != 6)){
                autoYellow();
                disableHYellow();
                disableHGreen();
                disableYellow();
                disableGreen();
                if(blueCont == true || redCont == true){
                    first = true;
                    second = true;
                    third = false;
                    fourth = false;
                }
                else{
                   note.setText("GAME OVER");
                    gameOver();
                }
            }
            else{
                
                if (toggle == true) {
                    toggle = false;
                    ycheck = false; yEnd = true;
                    rollBut.setDisable(true);
                    bn = true;
                    if(holdA == 6 && holdB == 6){
                        enableHGreen();
                        enableHYellow();
                        enableGreen();
                        enableYellow();
                    }
                    else{
                        disableHGreen();
                        disableHYellow();
                        enableGreen();
                        enableYellow();
                    }
                }
                else if(toggle == false) {
                    toggle = true;
                    ycheck = true; yEnd = false;
                    rollBut.setDisable(false);
                    if(holdA == 6 && holdB == 6){
                        if(greenCont == true || yellowCont == true){
                            first = false;
                            second = false;
                            third = true;
                            fourth = true;
                        }
                        else{
                            note.setText("GAME OVER");
                            gameOver();
                        }
                    }
                    else{
                       if(blueCont == true || redCont == true){
                            first = true;
                            second = true;
                            third = false;
                            fourth = false;
                        }
                        else{
                            note.setText("PLAYER ONE WIN");
                            gameOver();
                        }

                    }
                    disableHYellow();
                    disableHGreen(); 
                    enableYellow();
                    enableGreen();
                }
                
                
                
                if(box40.getId().equals("yt1")){
                    box40.setGraphic(showYellow(2));
                    box40.setId("yt2");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("yt2")){
                    box40.setGraphic(showYellow(3));
                    box40.setId("yt3");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("yt3")){
                    box40.setGraphic(showYellow(4));
                    box40.setId("yt4");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("0")){
                    box40.setGraphic(showYellow(1));
                    box40.setId("yt1");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("gt1")){
                    box40.setGraphic(showYellowGreen(1,1));
                    box40.setId("y1g1");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("gt2")){
                    box40.setGraphic(showYellowGreen(1,2));
                    box40.setId("y1g2");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("gt3")){
                    box40.setGraphic(showYellowGreen(1,3));
                    box40.setId("y1g3");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("gt4")){
                    box40.setGraphic(showYellowGreen(1,4));
                    box40.setId("y1g4");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y1g1")){
                    box40.setGraphic(showYellowGreen(2,1));
                    box40.setId("y2g1");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y1g2")){
                    box40.setGraphic(showYellowGreen(2,2));
                    box40.setId("y2g2");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y1g3")){
                    box40.setGraphic(showYellowGreen(2,3));
                    box40.setId("y2g3");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y1g4")){
                    box40.setGraphic(showYellowGreen(2,4));
                    box40.setId("y2g4");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y2g1")){
                    box40.setGraphic(showYellowGreen(3,1));
                    box40.setId("y3g1");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y2g2")){
                    box40.setGraphic(showYellowGreen(3,2));
                    box40.setId("y3g2");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y2g3")){
                    box40.setGraphic(showYellowGreen(3,3));
                    box40.setId("y3g3");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y2g4")){
                    box40.setGraphic(showYellowGreen(3,4));
                    box40.setId("y3g4");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y3g1")){
                    box40.setGraphic(showYellowGreen(4,1));
                    box40.setId("y4g1");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y3g2")){
                    box40.setGraphic(showYellowGreen(4,2));
                    box40.setId("y4g2");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y3g3")){
                    box40.setGraphic(showYellowGreen(4,3));
                    box40.setId("y4g3");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else if(box40.getId().equals("y3g4")){
                    box40.setGraphic(showYellowGreen(4,4));
                    box40.setId("y4g4");
                    if(ycheck == true){
                        disableYellow(); disableGreen();
                    }
                }
                else{
                    yellowPower2(box40);
                    showYprogress();
                }
                
                for(Button chk : allGreenBut){
                    if(chk.getId() != "gt1"){
                        chk.setDisable(true);
                    }
                }
                for(Button chk : allYellowBut){
                    if(chk.getId() != "yt1"){
                        chk.setDisable(true);
                    }
                }
            }
        }
        
    }
    
    
    
    
    
    
    @FXML
    private void moveTile(ActionEvent event) throws FileNotFoundException {
        
        Button bt = (Button)event.getSource();
        
        int number = 0;
        if(bt.getText().length() == 5 || bt.getText().length() == 4){
            number = Integer.parseInt(bt.getText().substring(3));
        }
        else{
            number = Integer.parseInt(bt.getText());
        }
        
        //playerNumber = 4 //boxValue[number] == 1
        
        if(playerNumber == 4){
        
        if(bt.getId().substring(0, 1).equals("b")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("bt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("bt2") || x.getId().equals("bt3") || x.getId().equals("bt4")){
                        counter = 2;
                    }
                }
                if(counter == 1 && bn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    blueDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHBlue();
                    enableBlue();
                    
                }
                else{
                    a = startBlue(number);
                }
                
                if(a > 57){
                    
                    if(holdA + number == 57){
                        a = holdA + number;
                        rollSpace1.setText("0");
                    }
                    else if(b + number == 57){
                        a = b + number;
                        rollSpace2.setText("0");
                    }
                    else if(holdA > b){
                        a = b + number;
                    }
                    else if(holdA < b){
                        a = holdA + number;
                    }
                    else{
                        a = holdA + number;
                    }
                    
                }
                if(a == 57){
                    if(bt.getId().equals("bt4")){
                        bt.setId("bt3");
                        boxValue[number] = 1;
                        bt.setGraphic(showBlue(3));
                    }
                    else if(bt.getId().equals("bt3")){
                        bt.setId("bt2");
                        boxValue[number] = 1;
                        bt.setGraphic(showBlue(2));
                    }
                    else if(bt.getId().equals("bt2")){
                        bt.setId("bt1");
                        boxValue[number] = 1;
                        bt.setGraphic(showBlue(1));
                    }
                    else {
                        bt.setId("0");
                        boxValue[number] = 0;
                        bt.setGraphic(null);
                    }
                    showBprogress();
                    
                }
                else if(a <= 56) {
                    
                    if(bt.getId().equals("bt4")){
                        bt.setId("bt3");
                        boxValue[number] = 1;
                        bt.setGraphic(showBlue(3));
                    }
                    else if(bt.getId().equals("bt3")){
                        bt.setId("bt2");
                        boxValue[number] = 1;
                        bt.setGraphic(showBlue(2));
                    }
                    else if(bt.getId().equals("bt2")){
                        bt.setId("bt1");
                        boxValue[number] = 1;
                        bt.setGraphic(showBlue(1));
                    }
                    else {
                        bt.setId("0");
                        boxValue[number] = 0;
                        bt.setGraphic(null);
                    }

                    try {
                        for (Button bts : BlueRoad) {
                            int face = 0;
                            if(bts.getText().length() == 5 || bts.getText().length() == 4){
                                face = Integer.parseInt(bts.getText().substring(3));
                            }
                            else{
                                face = Integer.parseInt(bts.getText());
                            }

                            if (face == a) {

                                if(bts.getId().equals("bt1")){
                                    bts.setGraphic(showBlue(2));
                                    bts.setId("bt2");
                                    if(counter == 1 || bcheck == true){
                                        disableBlue();
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt2")){
                                    bts.setGraphic(showBlue(3));
                                    bts.setId("bt3");
                                    if(counter == 1 || bcheck == true){
                                        disableBlue();
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt3")){
                                    bts.setGraphic(showBlue(4));
                                    bts.setId("bt4");
                                    if(counter == 1 || bcheck == true){
                                        disableBlue();
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("0")){
                                    bts.setGraphic(showBlue(1));
                                    bts.setId("bt1");
                                    if(counter == 1 || bcheck == true){
                                        disableBlue();
                                    }
                                    break;
                                }
                                else{
                                    showBprogress();
                                    //Eliminating red with blue
                                    if(bts.getId().equals("rt1")){
                                        bts.setGraphic(null);
                                        bts.setId("0");
                                        bts.setDisable(false);
                                        boxValue[face] = 0;
                                        for(Button bte : allRedBut){
                                            if(bte.getGraphic()== null){
                                                bte.setDisable(true);
                                                bte.setGraphic(showRed(1));
                                                bte.setId("rt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("rt2")){
                                        bts.setGraphic(showRed(1));
                                        bts.setId("rt1");
                                        for(Button bte : allRedBut){
                                            if(bte.getGraphic()== null){
                                                bte.setDisable(true);
                                                bte.setGraphic(showRed(1));
                                                bte.setId("rt1");
                                                break;
                                            }
                                        }

                                        break;
                                    }
                                    else if(bts.getId().equals("rt3")){
                                        bts.setGraphic(showRed(2));
                                        bts.setId("rt2");
                                        for(Button bte : allRedBut){
                                            if(bte.getGraphic()== null){
                                                bte.setDisable(true);
                                                bte.setGraphic(showRed(1));
                                                bte.setId("rt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("rt4")){
                                        bts.setGraphic(showRed(3));
                                        bts.setId("rt3");
                                        for(Button bte : allRedBut){
                                            if(bte.getGraphic()== null){
                                                bte.setDisable(true);
                                                bte.setGraphic(showRed(1));
                                                bte.setId("rt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    //Eliminating green with blue
                                    if(bts.getId().equals("gt1")){
                                        bts.setGraphic(null);
                                        bts.setId("0");
                                        bts.setDisable(false);
                                        boxValue[face] = 0;
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("gt2")){
                                        bts.setGraphic(showGreen(1));
                                        bts.setId("gt1");
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("gt3")){
                                        bts.setGraphic(showGreen(2));
                                        bts.setId("gt2");
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("gt4")){
                                        bts.setGraphic(showGreen(3));
                                        bts.setId("gt3");
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    //Eliminating yellow with blue
                                    if(bts.getId().equals("yt1")){
                                        bts.setGraphic(null);
                                        bts.setId("0");
                                        bts.setDisable(false);
                                        boxValue[face] = 0;
                                        for(Button bte : allYellowBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showYellow(1));
                                                bte.setId("yt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("yt2")){
                                        bts.setGraphic(showYellow(1));
                                        bts.setId("yt1");
                                        for(Button bte : allYellowBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showYellow(1));
                                                bte.setId("yt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("yt3")){
                                        bts.setGraphic(showYellow(2));
                                        bts.setId("yt2");
                                        for(Button bte : allYellowBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showYellow(1));
                                                bte.setId("yt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("yt4")){
                                        bts.setGraphic(showYellow(3));
                                        bts.setId("yt3");
                                        for(Button bte : allYellowBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showYellow(1));
                                                bte.setId("yt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    bts.setDisable(false);

                                }

                            }
                        }

                    } catch (NumberFormatException nfe) {
                    }
                }
                else{
                    if (number > 51) {
                        if (bEnd == true) {
                            bt.setDisable(true);
                            if(counter == 1){
                                rollBut.setDisable(false);
                            }
                        } else {
                            bt.setDisable(false);
                            rollBut.setDisable(false);
                            disableBlue();
                            disableHBlue();
                        }
                    }
                }
            }
        }
        
        //Moving RED tile
        else if(bt.getId().substring(0, 1).equals("r")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("rt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("rt2") || x.getId().equals("rt3") || x.getId().equals("rt4")){
                        counter = 2;
                    }                
                }
                if(counter == 1 && rn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    redDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHRed();
                    enableRed();
                }
                else{
                    a = startRed(number);
                }
                if(a > 52){
                    a = a - 52;
                }
                
                if(bt.getId().equals("rt4")){
                    bt.setId("rt3");
                    boxValue[number] = 2;
                    bt.setGraphic(showRed(3));
                }
                else if(bt.getId().equals("rt3")){
                    bt.setId("rt2");
                    boxValue[number] = 2;
                    bt.setGraphic(showRed(2));
                }
                else if(bt.getId().equals("rt2")){
                    bt.setId("rt1");
                    boxValue[number] = 2;
                    bt.setGraphic(showRed(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                
                try {
                    for (Button bts : RedRoad) {
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) {
                            
                            if(bts.getId().equals("rt1")){
                                bts.setGraphic(showRed(2));
                                bts.setId("rt2");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            }
                            else if(bts.getId().equals("rt2")){
                                bts.setGraphic(showRed(3));
                                bts.setId("rt3");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            }
                            else if(bts.getId().equals("rt3")){
                                bts.setGraphic(showRed(4));
                                bts.setId("rt4");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            }
                            else if(bts.getId().equals("0")){
                                bts.setGraphic(showRed(1));
                                bts.setId("rt1");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            }
                            else{
                                showRprogress();
                                //Eliminating blue with red
                                if(bts.getId().equals("bt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt2")){
                                    bts.setGraphic(showBlue(1));
                                    bts.setId("bt1");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("bt3")){
                                    bts.setGraphic(showBlue(2));
                                    bts.setId("bt2");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;   
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt4")){
                                    bts.setGraphic(showBlue(3));
                                    bts.setId("bt3");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating green with red
                                if(bts.getId().equals("gt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt2")){
                                    bts.setGraphic(showGreen(1));
                                    bts.setId("gt1");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt3")){
                                    bts.setGraphic(showGreen(2));
                                    bts.setId("gt2");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt4")){
                                    bts.setGraphic(showGreen(3));
                                    bts.setId("gt3");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating yellow with red
                                if(bts.getId().equals("yt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt2")){
                                    bts.setGraphic(showYellow(1));
                                    bts.setId("yt1");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt3")){
                                    bts.setGraphic(showYellow(2));
                                    bts.setId("yt2");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt4")){
                                    bts.setGraphic(showYellow(3));
                                    bts.setId("yt3");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                bts.setDisable(false);
                            }
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
                
            }
        }
        
        //Moving Yellow tile
        else if(bt.getId().substring(0, 1).equals("y")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("yt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("yt2") || x.getId().equals("yt3") || x.getId().equals("yt4")){
                        counter = 2;
                    }              
                }
                if(counter == 1 && yn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    yellowDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHYellow();                       //Might wanna remove the holdA and b condition to make it move all rolled number automatically
                    enableYellow();
                }
                else{
                    a = startYellow(number);
                }
              
                
                if(a > 52){
                    a = a - 52;
                }
                
                if(bt.getId().equals("yt4")){
                    bt.setId("yt3");
                    boxValue[number] = 3;
                    bt.setGraphic(showYellow(3));
                }
                else if(bt.getId().equals("yt3")){
                    bt.setId("yt2");
                    boxValue[number] = 3;
                    bt.setGraphic(showYellow(2));
                }
                else if(bt.getId().equals("yt2")){
                    bt.setId("yt1");
                    boxValue[number] = 3;
                    bt.setGraphic(showYellow(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                try {
                    for (Button bts : YellowRoad) {
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) {
                            
                            if(bts.getId().equals("yt1")){
                                bts.setGraphic(showYellow(2));
                                bts.setId("yt2");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else if(bts.getId().equals("yt2")){
                                bts.setGraphic(showYellow(3));
                                bts.setId("yt3");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else if(bts.getId().equals("yt3")){
                                bts.setGraphic(showYellow(4));
                                bts.setId("yt4");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else if(bts.getId().equals("0")){
                                bts.setGraphic(showYellow(1));
                                bts.setId("yt1");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else{
                                showYprogress();
                                //Eliminating blue with yellow
                                if(bts.getId().equals("bt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt2")){
                                    bts.setGraphic(showBlue(1));
                                    bts.setId("bt1");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("bt3")){
                                    bts.setGraphic(showBlue(2));
                                    bts.setId("bt2");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;   
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt4")){
                                    bts.setGraphic(showBlue(3));
                                    bts.setId("bt3");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                        //Eliminating green with yellow
                                if(bts.getId().equals("gt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt2")){
                                    bts.setGraphic(showGreen(1));
                                    bts.setId("gt1");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt3")){
                                    bts.setGraphic(showGreen(2));
                                    bts.setId("gt2");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt4")){
                                    bts.setGraphic(showGreen(3));
                                    bts.setId("gt3");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Elimanating red with yellow
                                if(bts.getId().equals("rt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt2")){
                                    bts.setGraphic(showRed(1));
                                    bts.setId("rt1");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("rt3")){
                                    bts.setGraphic(showRed(2));
                                    bts.setId("rt2");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt4")){
                                    bts.setGraphic(showRed(3));
                                    bts.setId("rt3");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                bts.setDisable(false);
                            }
                        }
                        
                    }
                } catch (NumberFormatException nfe) {
                }
                
            }
        }
        
        
        else if(bt.getId().substring(0, 1).equals("g")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("gt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("gt2") || x.getId().equals("gt3") || x.getId().equals("gt4")){
                        counter = 2;
                    }              
                }
                if(counter == 1 && gn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    greenDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHGreen();
                    enableGreen();
                }
                else{
                    a = startGreen(number);
                }
                
                if(a > 52){
                    a = a - 52;
                }
                
                if(bt.getId().equals("gt4")){
                    bt.setId("gt3");
                    boxValue[number] = 4;
                    bt.setGraphic(showGreen(3));
                }
                else if(bt.getId().equals("gt3")){
                    bt.setId("gt2");
                    boxValue[number] = 4;
                    bt.setGraphic(showGreen(2));
                }
                else if(bt.getId().equals("gt2")){
                    bt.setId("gt1");
                    boxValue[number] = 4;
                    bt.setGraphic(showGreen(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                try {
                    for (Button bts : GreenRoad) {
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) {
                            
                            if(bts.getId().equals("gt1")){
                                bts.setGraphic(showGreen(2));
                                bts.setId("gt2");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else if(bts.getId().equals("gt2")){
                                bts.setGraphic(showGreen(3));
                                bts.setId("gt3");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else if(bts.getId().equals("gt3")){
                                bts.setGraphic(showGreen(4));
                                bts.setId("gt4");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else if(bts.getId().equals("0")){
                                bts.setGraphic(showGreen(1));
                                bts.setId("gt1");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else{
                                showGprogress();
                                if(bts.getId().equals("bt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt2")){
                                    bts.setGraphic(showBlue(1));
                                    bts.setId("bt1");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("bt3")){
                                    bts.setGraphic(showBlue(2));
                                    bts.setId("bt2");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;   
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt4")){
                                    bts.setGraphic(showBlue(3));
                                    bts.setId("bt3");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }


                                //Elimanating red with green
                                if(bts.getId().equals("rt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt2")){
                                    bts.setGraphic(showRed(1));
                                    bts.setId("rt1");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("rt3")){
                                    bts.setGraphic(showRed(2));
                                    bts.setId("rt2");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt4")){
                                    bts.setGraphic(showRed(3));
                                    bts.setId("rt3");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating yellow with green
                                if(bts.getId().equals("yt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt2")){
                                    bts.setGraphic(showYellow(1));
                                    bts.setId("yt1");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt3")){
                                    bts.setGraphic(showYellow(2));
                                    bts.setId("yt2");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt4")){
                                    bts.setGraphic(showYellow(3));
                                    bts.setId("yt3");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                bts.setDisable(false); //enabling tiles after removal
                            }
                            
                        }
                    }
                } catch (NumberFormatException nfe) {
                }   
            }
           
        }
        }//playnumber = 3
        
        
        if(playerNumber == 2){
        
            if(bt.getId().substring(0, 1).equals("b") || bt.getId().substring(0, 1).equals("r")){

                if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                    int a = Integer.valueOf(rollSpace1.getText());
                    int b = Integer.valueOf(rollSpace2.getText());
                    int holdA = a;
                    int counter = 0;
                    for(Button bx : road){
                        if( bx.getId().equals("bt1") || bx.getId().equals("rt1")){
                            counter++;   
                        }
                        else if(bx.getId().equals("bt2") || bx.getId().equals("rt2") || 
                            bx.getId().equals("bt3") || bx.getId().equals("rt3") || 
                            bx.getId().equals("bt4") || bx.getId().equals("rt4") ||
                            bx.getId().equals("b1r1") || bx.getId().equals("b2r1") ||
                            bx.getId().equals("b1r2") || bx.getId().equals("b2r2") ||
                            bx.getId().equals("b1r3") || bx.getId().equals("b2r3") ||
                            bx.getId().equals("b1r4") || bx.getId().equals("b2r4") ||
                            bx.getId().equals("b3r1") || bx.getId().equals("b4r1") ||
                            bx.getId().equals("b3r2") || bx.getId().equals("b4r2") ||
                            bx.getId().equals("b3r3") || bx.getId().equals("b4r3") ||
                            bx.getId().equals("b3r4") || bx.getId().equals("b4r4")){
                            
                            counter = 2;
                        }
                    }
                    if(counter == 1 && bn == false && toggle == true){
                        a = a + b;
                        a = a + number;
                        
                        if(holdA == 6 && b == 6){
                            first = true;
                            second = true;
                        }
                        else{
                            first = false;
                            second = false;
                        }
                        rollBut.setDisable(false);
                        disableHBlue();
                        disableHRed();
                        enableBlue();
                        enableRed();

                    }
                    else{
                        a = startBlue2(number);
                    }

                    //Move blue tile is selected
                    if(bt.getId().substring(0, 1).equals("b")){
                        if(a > 57){
                            
                            if(holdA + number == 57){
                                a = holdA + number;
                                rollSpace1.setText("0");
                            }
                            else if(b + number == 57){
                                a = b + number;
                                rollSpace2.setText("0");
                            }
                            else if(holdA > b){
                                a = b + number;
                            }
                            else if(holdA < b){
                                a = holdA + number;
                            }
                            else{
                                a = holdA + number;
                            }
                        }
                        
                        if(a == 57){
                            blueInit(bt, number);
                            showBprogress();
                        }
                        else if(a <= 56) {

                            blueInit(bt, number);

                            try {

                                finalBlue(a, counter);

                            } catch (NumberFormatException nfe) {
                            }
                        }
                        else{
                            if (number > 51) {
                                if (bEnd == true) {
                                    bt.setDisable(true);
                                    if(counter == 1){
                                        rollBut.setDisable(false);
                                    }
                                } else {
                                    bt.setDisable(false);
                                    rollBut.setDisable(false);
                                    disableBlue();
                                    disableHBlue();
                                    disableRed();
                                    disableHRed();
                                }
                            }
                        }
                    }
                    //if red tile was selected
                    else if(bt.getId().substring(0, 2).equals("rt")){
                        if(a > 52){
                            a = a - 52;
                        }

                        redInit(bt, number);    

                        try {
                            finalRed(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                }
            }
            else if(bt.getId().substring(0, 1).equals("y") || bt.getId().substring(0, 1).equals("g")){
                if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                    int a = Integer.valueOf(rollSpace1.getText());
                    int b = Integer.valueOf(rollSpace2.getText());
                    int holdA = a;
                    int counter = 0;
                    for(Button bx : road){
                        if( bx.getId().equals("yt1") || bx.getId().equals("gt1")){
                            counter++;   
                        }
                        else if(bx.getId().equals("yt2") || bx.getId().equals("gt2") || 
                            bx.getId().equals("yt3") || bx.getId().equals("gt3") || 
                            bx.getId().equals("yt4") || bx.getId().equals("gt4") ||
                            bx.getId().equals("y1g1") || bx.getId().equals("y2g1") ||
                            bx.getId().equals("y1g2") || bx.getId().equals("y2g2") ||
                            bx.getId().equals("y1g3") || bx.getId().equals("y2g3") ||
                            bx.getId().equals("y1g4") || bx.getId().equals("y2g4") ||
                            bx.getId().equals("y3g1") || bx.getId().equals("y4g1") ||
                            bx.getId().equals("y3g2") || bx.getId().equals("y4g2") ||
                            bx.getId().equals("y3g3") || bx.getId().equals("y4g3") ||
                            bx.getId().equals("y3g4") || bx.getId().equals("y4g4")){

                            counter = 2;
                        }
                    }
                    if(counter == 1 && bn == false && toggle == true){
                        a = a + b;
                        a = a + number;
                        if(holdA == 6 && b == 6){
                            third = true;
                            fourth = true;
                        }
                        else{
                            third = false;
                            fourth = false;
                        }
                        rollBut.setDisable(false);
                        disableHYellow();
                        disableHGreen();
                        enableYellow();
                        enableGreen();
                    }
                    else{
                        a = startYellow2(number);
                    }
                    if(a > 52){
                        a = a - 52;
                    }
                    
                    
                    if(bt.getId().substring(0, 1).equals("y")){
                        yellowInit(bt);
                        try {
                            finalYellow(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                    else if(bt.getId().substring(0, 1).equals("g")){
                        greenInit(bt);
                        try {
                            finalGreen(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                    
                }     //move to other motion methods           
            }
        }
    }
        
        
        
        
        
        
        
        
        
    
    
    public void initializeTiles(){
        allBlueBut = new Button[] {homeBT1, homeBT2, homeBT3, homeBT4};
        allRedBut = new Button[] {homeRT1, homeRT2, homeRT3, homeRT4};
        allYellowBut = new Button[] {homeYT1, homeYT2, homeYT3, homeYT4};
        allGreenBut = new Button[] {homeGT1, homeGT2, homeGT3, homeGT4};
        rollBut.setDisable(true);
        
//        winner = 1;
//        showWinner(1);
        
        for(int i = 0; i < 4; i++){
            try {
                setRedTiles(allRedBut[i]);
                
                setYellowTiles(allYellowBut[i]);
                setGreenTiles(allGreenBut[i]);
                setBlueTiles(allBlueBut[i]);
            } catch (FileNotFoundException ex) {
                
            }
        }
        
        allButtons = new Button[] {
            box00, box01, box02, box03, box04, box05, box06, box07, box08, box09,
            box10, box11, box12, box13, box14, box15, box16, box17, box18, box19,
            box20, box21, box22, box23, box24, box25, box26, box27, box28, box29,
            box30, box31, box32, box33, box34, box35, box36, box37, box38, box39,
            box40, box41, box42, box43, box44, box45, box46, box47, box48, box49,
            box50, box51, box52, enB52, enB53, enB54, enB55, enB56, enR13, enR14,
            enR15, enR16, enR17, enY39, enY40, enY41, enY42, enY43, enG26, enG27,
            enG28, enG29, enG30, homeBT1, homeBT2, homeBT3, homeBT4, homeRT1,
            homeRT2, homeRT3, homeRT4, homeYT1, homeYT2, homeYT3, homeYT4, homeGT1,
            homeGT2, homeGT3, homeGT4, rollBut, playerOne, playerTwo, playerThree,
            playerFour
        };
        
        
        road = new Button[] {
            box00, box01, box02, box03, box04, box05, box06, box07, box08, box09,
            box10, box11, box12, box13, box14, box15, box16, box17, box18, box19,
            box20, box21, box22, box23, box24, box25, box26, box27, box28, box29,
            box30, box31, box32, box33, box34, box35, box36, box37, box38, box39,
            box40, box41, box42, box43, box44, box45, box46, box47, box48, box49,
            box50, box51, box52, enB52, enB53, enB54, enB55, enB56, enR13, enR14,
            enR15, enR16, enR17, enY39, enY40, enY41, enY42, enY43, enG26, enG27,
            enG28, enG29, enG30
        };
        
        for(Button allx : road){
            allx.setId("0");
        }
        playerOne.setId("0");
        playerTwo.setId("0");
        playerThree.setId("0");
        playerFour.setId("0");
        
        
        //new way
        BlueRoad = new Button[] {
            box01, box02, box03, box04, box05, box06, box07, box08, box09,
            box10, box11, box12, box13, box14, box15, box16, box17, box18, box19,
            box20, box21, box22, box23, box24, box25, box26, box27, box28, box29,
            box30, box31, box32, box33, box34, box35, box36, box37, box38, box39,
            box40, box41, box42, box43, box44, box45, box46, box47, box48, box49,
            box50, box51, enB52, enB53, enB54, enB55, enB56
        };
        //new way
         RedRoad = new Button[] {
            box14, box15, box16, box17, box18, box19, 
            box20, box21, box22, box23, box24, box25, box26, box27, box28, box29,
            box30, box31, box32, box33, box34, box35, box36, box37, box38, box39, 
            box40, box41, box42, box43, box44, box45, box46, box47, box48, box49, 
            box50, box51, box52, box01, box02, box03, box04, box05, box06, box07, 
            box08, box09, box10, box11, box12     
        };
         RedRoadEnd = new Button[]{
            box52, box01, box02, box03, box04, box05, box06, box07, box08, 
            box09,box10, box11, box12, enR13, enR14, enR15, enR16, enR17
         };
         //new way
         YellowRoad = new Button[] {
            box40, box41, box42, box43, box44, box45, box46, box47, box48, box49,
            box50, box51, box52, box01, box02, box03, box04, box05, box06, box07,
            box08, box09, box10, box11, box12, box13, box14, box15, box16, box17, 
            box18, box19, box20, box21, box22, box23, box24, box25, box26, box27,
            box28, box29, box30, box31, box32, box33, box34, box35, box36, box37,
            box38
        };
         YellowRoadEnd = new Button[]{
           box26, box27, box28, box29, box30, box31,box32, box33, box34, box35,
            box36, box37, box38, enY39, enY40, enY41, enY42, enY43  
         };
         //new way
         GreenRoad = new Button[] {
            box27, box28, box29,
            box30, box31, box32, box33, box34, box35, box36, box37, box38, box39,
            box40, box41, box42, box43, box44, box45, box46, box47, box48, box49,
            box50, box51, box52, box01, box02, box03, box04, box05, box06, box07,
            box08, box09, box10, box11, box12, box13, box14, box15, box16, box17, 
            box18, box19, box20, box21, box22, box23, box24, box25
        };
         GreenRoadEnd = new Button[]{
            box13, box14, box15, box16, box17, box18,box19, box20, box21, box22,
            box23, box24, box25, enG26, enG27, enG28, enG29, enG30 
         };
         
         enableALL();
         
    }
    
    public void setRedTiles(Button but) throws FileNotFoundException{
        but.setGraphic(showRed(1));
        but.setDisable(true);
        but.setId("rt1");
        
    }

    public void setBlueTiles(Button but) throws FileNotFoundException{
        but.setGraphic(showBlue(1));
        but.setDisable(true);
        but.setId("bt1");
    }
    
    public void setGreenTiles(Button but) throws FileNotFoundException{
        but.setGraphic(showGreen(1));
        but.setDisable(true);
        but.setId("gt1");
    }
    
    public void setYellowTiles(Button but) throws FileNotFoundException{
        but.setGraphic(showYellow(1));
        but.setDisable(true);
        but.setId("yt1");
    }

    @FXML
    private void genRandNo(ActionEvent event) throws FileNotFoundException {
        Random random = new Random();
        rolledNum1 = 1 + random.nextInt(6);
        rolledNum2 = 1 + random.nextInt(6);
        rollSpace1.setText(String.valueOf(rolledNum1));
        rollSpace2.setText(String.valueOf(rolledNum2));
        int holdA = rolledNum1; int holdB = rolledNum2;
        bcheck = false;rcheck = false;ycheck = false;gcheck = false;
        if(playerNumber == 4){
            
            if(playerOne.getId().equals("bt4") && playerTwo.getId().equals("rt4") && playerThree.getId().equals("yt4")){
                note.setText("GAME OVER");
                gameOver();
            }
            else if(playerOne.getId().equals("bt4") && playerTwo.getId().equals("rt4") && playerFour.getId().equals("gt4")){
                note.setText("GAME OVER");
                gameOver();
            }
            else if(playerOne.getId().equals("bt4") && playerThree.getId().equals("yt4") && playerFour.getId().equals("gt4")){
                note.setText("GAME OVER");
                gameOver();
            }
            else if(playerThree.getId().equals("yt4") && playerTwo.getId().equals("rt4") && playerFour.getId().equals("gt4")){
                note.setText("GAME OVER");
                gameOver();
            }
            
            
            if(first == true && blueCont == true){
                note.setText("Player BLUE turn");
                
                for(Button chk : allBlueBut){
                    if(chk.getId().equals("bt1")){
                        comB = true;
                        break;
                    }
                    else{
                        comB = false;
                    }
                }
                if((rolledNum1 == 6 || rolledNum2 == 6) && comB == true){
                    for(Button btn : allBlueBut){
                        if(btn.getId().equals("bt1")){
                            btn.setDisable(false);
                        }
                    }
                }
                else{
                    disableHBlue();
                }
                enableBlue();
                disableGreen();
                disableYellow();
                disableRed();
                disableHRed();
                disableHGreen();
                disableHYellow();
                
                blueDouble(holdA, holdB);
                
            }
            
            else if(second == true && redCont == true){
                note.setText("Player RED turn");
                for(Button chk : allRedBut){
                    if(chk.getId().equals("rt1")){
                        comR = true;
                        break;
                    }
                    else{
                        comR = false;
                    }
                }
                if((rolledNum1 == 6 || rolledNum2 == 6) && comR == true){
                    for(Button btn : allRedBut){
                        if(btn.getId().equals("rt1")){
                            btn.setDisable(false);
                        }
                    }
                }
                else{
                    disableHRed();
                }
                enableRed();
                disableBlue();
                disableGreen();
                disableYellow();
                disableHGreen();
                disableHYellow();
                disableHBlue();
                
                redDouble(holdA, holdB);
            }
            else if(third == true && yellowCont == true){
                note.setText("Player YELLOW turn");
                for(Button chk : allYellowBut){
                    if(chk.getId().equals("yt1")){
                        comY = true;
                        break;
                    }
                    else{
                        comY = false;
                    }
                }
                if((rolledNum1 == 6 || rolledNum2 == 6) && comY == true){
                    for(Button btn : allYellowBut){
                        if(btn.getId().equals("yt1")){
                            btn.setDisable(false);
                        }
                    }
                }
                else{
                    disableHYellow();
                }
                enableYellow();
                disableGreen();
                disableBlue();
                disableRed();
                disableHRed();
                disableHGreen();
                disableHBlue();
                
                yellowDouble(holdA, holdB);
                
                
            }
            
            else if(fourth == true && greenCont == true){
                note.setText("Player GREEN turn");
                for(Button chk : allGreenBut){
                    if(chk.getId().equals("gt1")){
                        comG = true;
                        break;
                    }
                    else{
                        comG = false;
                    }
                }
                if((rolledNum1 == 6 || rolledNum2 == 6) && comG == true){
                    for(Button btn : allGreenBut){
                        if(btn.getId().equals("gt1")){
                            btn.setDisable(false);
                        }
                    }
                }
                else{
                    disableHGreen();
                }
                enableGreen();
                disableYellow();
                disableBlue();
                disableRed();
                disableHRed();
                disableHYellow();
                disableHBlue();
                
                greenDouble(holdA, holdB);
            }
        }
        
        else if(playerNumber == 2){
            
            if(playerOne.getId().equals("bt4") && playerTwo.getId().equals("rt4")){
                note.setText("PLAYER ONE WIN");
                gameOver();
            }
            else if(playerThree.getId().equals("yt4") && playerFour.getId().equals("gt4")){
                note.setText("PLAYER TWO WIN");
                gameOver();
            }
            
            if(first == true && blueCont == true || second == true && redCont == true){
                note.setText("Player ONE turn");
                for(Button chk : allBlueBut){
                    if(chk.getId().equals("bt1")){
                        comB = true;
                        break;
                    }
                    else{
                        comB = false;
                    }
                }
                for(Button chk : allRedBut){
                    if(chk.getId().equals("rt1")){
                        comR = true;
                        break;
                    }
                    else{
                        comR = false;
                    }
                }
                
                
                if((rolledNum1 == 6 || rolledNum2 == 6) && comB == true){
                    for(Button btn : allBlueBut){
                        if(btn.getId().equals("bt1")){
                            btn.setDisable(false);
                        }
                    }
                }
                else{
                    disableHBlue();
                }
                if((rolledNum1 == 6 || rolledNum2 == 6) && comR == true){
                    for(Button btn : allRedBut){
                        if(btn.getId().equals("rt1")){
                            btn.setDisable(false);
                        }
                    }
                }
                else{
                    disableHRed();
                }
                enableBlue();
                enableRed();
                
                disableGreen();
                disableYellow();
                disableHGreen();
                disableHYellow();
                
                if(holdA == 6 && holdB == 6){
                    if(blueCont == true || redCont == true){
                        first = true;
                        second = true;
                        third = false;
                        fourth = false;
                    }
                }
                else{
                    if(yellowCont == true || greenCont == true){
                        first = false;
                        second = false;
                        third = true;
                        fourth = true;
                    }
                    else{
                        note.setText("PLAYER TWO WIN");
                        gameOver();
                    }
                }
                
            }
            
            else if(third == true && yellowCont == true || fourth == true && greenCont == true){
                note.setText("Player TWO turn");
                for(Button chk : allYellowBut){
                    if(chk.getId().equals("yt1")){
                        comY = true;
                        break;
                    }
                    else{
                        comY = false;
                    }
                }
                for(Button chk : allGreenBut){
                    if(chk.getId().equals("gt1")){
                        comG = true;
                        break;
                    }
                    else{
                        comG = false;
                    }
                }
                if((rolledNum1 == 6 || rolledNum2 == 6) && comG == true){
                    for(Button btn : allGreenBut){
                        if(btn.getId().equals("gt1")){
                            btn.setDisable(false);
                        }
                    }
                }
                else{
                    disableHGreen();
                }
                if((rolledNum1 == 6 || rolledNum2 == 6) && comY == true){
                    for(Button btn : allYellowBut){
                        if(btn.getId().equals("yt1")){
                            btn.setDisable(false);
                        }
                    }
                }
                else{
                    disableHYellow();
                }
                
                enableYellow();
                enableGreen();
                
                disableRed();
                disableBlue();
                disableHRed();
                disableHBlue();
                
                if(holdA == 6 && holdB == 6){
                    if(blueCont == true || redCont == true){
                        first = false;
                        second = false;
                        third = true;
                        fourth = true;
                    }
                }
                else{
                    if(blueCont == true || redCont == true){
                        first = true;
                        second = true;
                        third = false;
                        fourth = false;
                    }
                    else{
                        note.setText("PLAYER ONE WIN");
                        gameOver();
                    }
                }
                
            }
        }
    }

    
    
    @FXML
    private void moveTileR(ActionEvent event) throws FileNotFoundException {
        Button bt = (Button)event.getSource();
        int number;
        if(bt.getText().length() == 5 || bt.getText().length() == 4){
            number = Integer.parseInt(bt.getText().substring(3));
        }
        else{
            number = Integer.parseInt(bt.getText());
        }
        
        if(playerNumber == 4){
            
        if(bt.getId().substring(0, 1).equals("b")){
            
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("bt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("bt2") || x.getId().equals("bt3") || x.getId().equals("bt4")){
                        counter = 2;
                    }                
                }
                if(counter == 1 && bn == false && toggle == true){          //holdA != 6 && b != 6 && 
                    a = a + b;
                    a = a + number;
                    blueDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHBlue();
                    enableBlue();
                }
                else{
                    a = startBlue(number);
                }
                
                
                if(bt.getId().equals("bt4")){
                    bt.setId("bt3");
                    boxValue[number] = 1;
                    bt.setGraphic(showBlue(3));
                }
                else if(bt.getId().equals("bt3")){
                    bt.setId("bt2");
                    boxValue[number] = 1;
                    bt.setGraphic(showBlue(2));
                }
                else if(bt.getId().equals("bt2")){
                    bt.setId("bt1");
                    boxValue[number] = 1;
                    bt.setGraphic(showBlue(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                
                try {
                    for (Button bts : BlueRoad) {
                        
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) { //A problem is here, I think when it get to 6 it threw an exception
                            
                            if(bts.getId().equals("bt1")){
                                bts.setGraphic(showBlue(2));
                                bts.setId("bt2");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else if(bts.getId().equals("bt2")){
                                bts.setGraphic(showBlue(3));
                                bts.setId("bt3");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else if(bts.getId().equals("bt3")){
                                bts.setGraphic(showBlue(4));
                                bts.setId("bt4");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else if(bts.getId().equals("0")){
                                bts.setGraphic(showBlue(1));
                                bts.setId("bt1");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else{
                                showBprogress();
                                //Eliminating red with blue
                                if(bts.getId().equals("rt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt2")){
                                    bts.setGraphic(showRed(1));
                                    bts.setId("rt1");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("rt3")){
                                    bts.setGraphic(showRed(2));
                                    bts.setId("rt2");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt4")){
                                    bts.setGraphic(showRed(3));
                                    bts.setId("rt3");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating green with blue
                                if(bts.getId().equals("gt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt2")){
                                    bts.setGraphic(showGreen(1));
                                    bts.setId("gt1");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt3")){
                                    bts.setGraphic(showGreen(2));
                                    bts.setId("gt2");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt4")){
                                    bts.setGraphic(showGreen(3));
                                    bts.setId("gt3");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating yellow with blue
                                if(bts.getId().equals("yt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt2")){
                                    bts.setGraphic(showYellow(1));
                                    bts.setId("yt1");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt3")){
                                    bts.setGraphic(showYellow(2));
                                    bts.setId("yt2");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt4")){
                                    bts.setGraphic(showYellow(3));
                                    bts.setId("yt3");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }    
                            }
                        }
                    }
                    
                } catch (NumberFormatException nfe) {
                }
                
            }
        }
        else if(bt.getId().substring(0, 1).equals("r")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("rt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("rt2") || x.getId().equals("rt3") || x.getId().equals("rt4")){
                        counter = 2;
                    }               
                }
                if(counter == 1 && rn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    redDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHRed();
                    enableRed();
                }
                else{
                    a = startRed(number);
                }
                
                if(a > 52){
                    a = a - 52;
                }
                
                try{
                    
                    if(a > 18 && bt.getText().substring(0, 3).equals("red")){
                        a = number;
                        if(holdA + number == 18){
                            a = holdA + number;
                            rollSpace1.setText("0");
                        }
                        else if(b + number == 18){
                            a = b + number;
                            rollSpace2.setText("0");
                        }
                        else if(holdA > b){
                            a = b + number;
                        }
                        else if(holdA < b){
                            a = holdA + number;
                        }
                        else{
                            a = holdA + number;
                        }
                    }
                    if(a == 18 && bt.getText().substring(0, 3).equals("red")){

                        if(bt.getId().equals("rt4")){
                            bt.setId("rt3");
                            boxValue[number] = 2;
                            bt.setGraphic(showRed(3));
                        }
                        else if(bt.getId().equals("rt3")){
                            bt.setId("rt2");
                            boxValue[number] = 2;
                            bt.setGraphic(showRed(2));
                        }
                        else if(bt.getId().equals("rt2")){
                            bt.setId("rt1");
                            boxValue[number] = 2;
                            bt.setGraphic(showRed(1));
                        }
                        else {
                            bt.setId("0");
                            boxValue[number] = 0;
                            bt.setGraphic(null);
                        }
                        showRprogress();
                    }
                    else if(a > 18 && bt.getText().substring(0, 3).equals("red")){
                        
                        if (number > 12) {
                            if (rEnd == true) {
                                bt.setDisable(true);
                                if(counter == 1){
                                    rollBut.setDisable(false);
                                }
                            } else {
                                bt.setDisable(false);
                                rollBut.setDisable(false);
                                disableRed();
                                disableHRed();
                            }
                        }
                
                    }
                    else{
                        if(bt.getId().equals("rt4")){
                            bt.setId("rt3");
                            boxValue[number] = 2;
                            bt.setGraphic(showRed(3));
                        }
                        else if(bt.getId().equals("rt3")){
                            bt.setId("rt2");
                            boxValue[number] = 2;
                            bt.setGraphic(showRed(2));
                        }
                        else if(bt.getId().equals("rt2")){
                            bt.setId("rt1");
                            boxValue[number] = 2;
                            bt.setGraphic(showRed(1));
                        }
                        else {
                            bt.setId("0");
                            boxValue[number] = 0;
                            bt.setGraphic(null);
                        }

                        try {
                            for (Button bts : RedRoadEnd) {
                                int face = 0;
                                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                                    face = Integer.parseInt(bts.getText().substring(3));
                                }
                                else{
                                    face = Integer.parseInt(bts.getText());
                                }
                                if (face == a) {

                                    if(bts.getId().equals("rt1")){
                                        bts.setGraphic(showRed(2));
                                        bts.setId("rt2");
                                        if(counter == 1 || rcheck == true){
                                            disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("rt2")){
                                        bts.setGraphic(showRed(3));
                                        bts.setId("rt3");
                                        if(counter == 1 || rcheck == true){
                                            disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("rt3")){
                                        bts.setGraphic(showRed(4));
                                        bts.setId("rt4");
                                        if(counter == 1 || rcheck == true){
                                            disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("0")){
                                        bts.setGraphic(showRed(1));
                                        bts.setId("rt1");
                                        if(counter == 1 || rcheck == true){
                                            disableRed();
                                        }
                                        break;
                                    }
                                    else{  
                                        showRprogress();
                                        //Eliminating blue with red
                                        if(bts.getId().equals("bt1")){
                                        bts.setGraphic(null);
                                        bts.setId("0");
                                        bts.setDisable(false);
                                        boxValue[face] = 0;
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("bt2")){
                                        bts.setGraphic(showBlue(1));
                                        bts.setId("bt1");
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;
                                            }
                                        }

                                        break;
                                    }
                                    else if(bts.getId().equals("bt3")){
                                        bts.setGraphic(showBlue(2));
                                        bts.setId("bt2");
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;   
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("bt4")){
                                        bts.setGraphic(showBlue(3));
                                        bts.setId("bt3");
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    //Eliminating green with red
                                    if(bts.getId().equals("gt1")){
                                        bts.setGraphic(null);
                                        bts.setId("0");
                                        bts.setDisable(false);
                                        boxValue[face] = 0;
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("gt2")){
                                        bts.setGraphic(showGreen(1));
                                        bts.setId("gt1");
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("gt3")){
                                        bts.setGraphic(showGreen(2));
                                        bts.setId("gt2");
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("gt4")){
                                        bts.setGraphic(showGreen(3));
                                        bts.setId("gt3");
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                        //Eliminating yellow with red
                                        if(bts.getId().equals("yt1")){
                                            bts.setGraphic(null);
                                            bts.setId("0");
                                            bts.setDisable(false);
                                            boxValue[face] = 0;
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("yt2")){
                                            bts.setGraphic(showYellow(1));
                                            bts.setId("yt1");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("yt3")){
                                            bts.setGraphic(showYellow(2));
                                            bts.setId("yt2");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("yt4")){
                                            bts.setGraphic(showYellow(3));
                                            bts.setId("yt3");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        } catch (NumberFormatException nfe) {
                        }
                    }
                }catch(Exception e){
                }                
            }
        }
        else if(bt.getId().substring(0, 1).equals("y")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("yt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("yt2") || x.getId().equals("yt3") || x.getId().equals("yt4")){
                        counter = 2;
                    }               
                }
                if(counter == 1 && yn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    yellowDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHYellow();
                    enableYellow();
                }
                else{
                    a = startYellow(number);
                }
                
                
                
                if(a > 52){
                    a = a - 52;
                }
                
                if(bt.getId().equals("yt4")){
                    bt.setId("yt3");
                    boxValue[number] = 3;
                    bt.setGraphic(showYellow(3));
                }
                else if(bt.getId().equals("yt3")){
                    bt.setId("yt2");
                    boxValue[number] = 3;
                    bt.setGraphic(showYellow(2));
                }
                else if(bt.getId().equals("yt2")){
                    bt.setId("yt1");
                    boxValue[number] = 3;
                    bt.setGraphic(showYellow(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                
                try {
                    for (Button bts : YellowRoad) {
                        
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) {
                            
                            if(bts.getId().equals("yt1")){
                                bts.setGraphic(showYellow(2));
                                bts.setId("yt2");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else if(bts.getId().equals("yt2")){
                                bts.setGraphic(showYellow(3));
                                bts.setId("yt3");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else if(bts.getId().equals("yt3")){
                                bts.setGraphic(showYellow(4));
                                bts.setId("yt4");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else if(bts.getId().equals("0")){
                                bts.setGraphic(showYellow(1));
                                bts.setId("yt1");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else{
                                showYprogress();
                                //Eliminating blue with yellow
                                if(bts.getId().equals("bt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt2")){
                                    bts.setGraphic(showBlue(1));
                                    bts.setId("bt1");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("bt3")){
                                    bts.setGraphic(showBlue(2));
                                    bts.setId("bt2");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;   
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt4")){
                                    bts.setGraphic(showBlue(3));
                                    bts.setId("bt3");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating green with yellow
                                if(bts.getId().equals("gt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt2")){
                                    bts.setGraphic(showGreen(1));
                                    bts.setId("gt1");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt3")){
                                    bts.setGraphic(showGreen(2));
                                    bts.setId("gt2");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt4")){
                                    bts.setGraphic(showGreen(3));
                                    bts.setId("gt3");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Elimanating red with yellow
                                if(bts.getId().equals("rt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt2")){
                                    bts.setGraphic(showRed(1));
                                    bts.setId("rt1");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("rt3")){
                                    bts.setGraphic(showRed(2));
                                    bts.setId("rt2");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt4")){
                                    bts.setGraphic(showRed(3));
                                    bts.setId("rt3");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
                
            }
        }
        else if(bt.getId().substring(0, 1).equals("g")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("gt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("gt2") || x.getId().equals("gt3") || x.getId().equals("gt4")){
                        counter = 2;
                    }               
                }
                if(counter == 1 && gn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    greenDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHGreen();
                    enableGreen();
                }
                else{
                    a = startGreen(number);
                }
               
                
                if(a > 52){
                    a = a - 52;
                }
                
                if(bt.getId().equals("gt4")){
                    bt.setId("gt3");
                    boxValue[number] = 4;
                    bt.setGraphic(showGreen(3));
                }
                else if(bt.getId().equals("gt3")){
                    bt.setId("gt2");
                    boxValue[number] = 4;
                    bt.setGraphic(showGreen(2));
                }
                else if(bt.getId().equals("gt2")){
                    bt.setId("gt1");
                    boxValue[number] = 4;
                    bt.setGraphic(showGreen(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                
                try {
                    for (Button bts : GreenRoad) {
                        
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) {
                            
                            if(bts.getId().equals("gt1")){
                                bts.setGraphic(showGreen(2));
                                bts.setId("gt2");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else if(bts.getId().equals("gt2")){
                                bts.setGraphic(showGreen(3));
                                bts.setId("gt3");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else if(bts.getId().equals("gt3")){
                                bts.setGraphic(showGreen(4));
                                bts.setId("gt4");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else if(bts.getId().equals("0")){
                                bts.setGraphic(showGreen(1));
                                bts.setId("gt1");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else{
                                showGprogress();
                                if(bts.getId().equals("bt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt2")){
                                    bts.setGraphic(showBlue(1));
                                    bts.setId("bt1");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("bt3")){
                                    bts.setGraphic(showBlue(2));
                                    bts.setId("bt2");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;   
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt4")){
                                    bts.setGraphic(showBlue(3));
                                    bts.setId("bt3");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }


                                //Elimanating red with green
                                if(bts.getId().equals("rt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt2")){
                                    bts.setGraphic(showRed(1));
                                    bts.setId("rt1");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("rt3")){
                                    bts.setGraphic(showRed(2));
                                    bts.setId("rt2");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt4")){
                                    bts.setGraphic(showRed(3));
                                    bts.setId("rt3");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating yellow with green
                                if(bts.getId().equals("yt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt2")){
                                    bts.setGraphic(showYellow(1));
                                    bts.setId("yt1");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt3")){
                                    bts.setGraphic(showYellow(2));
                                    bts.setId("yt2");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt4")){
                                    bts.setGraphic(showYellow(3));
                                    bts.setId("yt3");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
                
            }
        }
    }
    else if(playerNumber == 2){
        if(bt.getId().substring(0, 1).equals("b") || bt.getId().substring(0, 1).equals("r")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a;
                int counter = 0;
                for(Button bx : road){
                    if( bx.getId().equals("bt1") || bx.getId().equals("rt1")){
                        counter++;   
                    }
                    else if(bx.getId().equals("bt2") || bx.getId().equals("rt2") || 
                        bx.getId().equals("bt3") || bx.getId().equals("rt3") || 
                        bx.getId().equals("bt4") || bx.getId().equals("rt4") ||
                        bx.getId().equals("b1r1") || bx.getId().equals("b2r1") ||
                        bx.getId().equals("b1r2") || bx.getId().equals("b2r2") ||
                        bx.getId().equals("b1r3") || bx.getId().equals("b2r3") ||
                        bx.getId().equals("b1r4") || bx.getId().equals("b2r4") ||
                        bx.getId().equals("b3r1") || bx.getId().equals("b4r1") ||
                        bx.getId().equals("b3r2") || bx.getId().equals("b4r2") ||
                        bx.getId().equals("b3r3") || bx.getId().equals("b4r3") ||
                        bx.getId().equals("b3r4") || bx.getId().equals("b4r4")){

                        counter = 2;
                    }
                }
                if(counter == 1 && bn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    if(holdA == 6 && b == 6){
                        first = true;
                        second = true;
                    }
                    else{
                        first = false;
                        second = false;
                    }
                    rollBut.setDisable(false);
                    disableHBlue();
                    disableHRed();
                    enableBlue();
                    enableRed();

                }
                else{
                    a = startBlue2(number);
                }
                if(bt.getId().substring(0, 1).equals("b")){
                    blueInit(bt, number);
                    try {
                        finalBlue(a, counter);
                    } catch (NumberFormatException nfe) {
                    }
                }
                //if red tile was selected
                else if(bt.getId().substring(0, 2).equals("rt")){
                    if(a > 52){
                        a = a - 52;
                    }
                    if(a > 18 && bt.getText().substring(0, 3).equals("red")){
                        a = number;
                        if(holdA + number == 18){
                            a = holdA + number;
                            rollSpace1.setText("0");
                        }
                        else if(b + number == 18){
                            a = b + number;
                            rollSpace2.setText("0");
                        }
                        else if(holdA > b){
                            a = b + number;
                        }
                        else if(holdA < b){
                            a = holdA + number;
                        }
                        else{
                            a = holdA + number;
                        }
                    }
                    if(a == 18 && bt.getText().substring(0, 3).equals("red")){

                        redInit(bt, number);
                        showRprogress();
                    }
                    else if(a > 18 && bt.getText().substring(0, 3).equals("red")){
                       
                        if (number > 12) {
                            if (bEnd == true) {
                                bt.setDisable(true);
                                if(counter == 1){
                                    rollBut.setDisable(false);
                                }
                            } else {
                                bt.setDisable(false);
                                rollBut.setDisable(false);
                                disableRed();
                                disableHRed();
                                disableHBlue();
                                disableBlue();
                            }
                        }
                
                    }
                    else{
                        try {
                            redInit(bt, number);
                            
                            for (Button bts : RedRoadEnd) {
                                int face = 0;
                                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                                    face = Integer.parseInt(bts.getText().substring(3));
                                }
                                else{
                                    face = Integer.parseInt(bts.getText());
                                }
                                if (face == a) {
                                    if(bts.getId().equals("rt1")){
                                        bts.setGraphic(showRed(2));
                                        bts.setId("rt2");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("rt2")){
                                        bts.setGraphic(showRed(3));
                                        bts.setId("rt3");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("rt3")){
                                        bts.setGraphic(showRed(4));
                                        bts.setId("rt4");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("0")){
                                        bts.setGraphic(showRed(1));
                                        bts.setId("rt1");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("bt1")){
                                        bts.setGraphic(showBlueRed(1,1));
                                        bts.setId("b1r1");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("bt2")){
                                        bts.setGraphic(showBlueRed(1,2));
                                        bts.setId("b2r1");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("bt3")){
                                        bts.setGraphic(showBlueRed(1,3));
                                        bts.setId("b3r1");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("bt4")){
                                        bts.setGraphic(showBlueRed(1,4));
                                        bts.setId("b4r1");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }

                                    else if(bts.getId().equals("b1r1")){
                                        bts.setGraphic(showBlueRed(1,2));
                                        bts.setId("b1r2");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("b1r2")){
                                        bts.setGraphic(showBlueRed(1,3));
                                        bts.setId("b1r3");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("b1r3")){
                                        bts.setGraphic(showBlueRed(1,4));
                                        bts.setId("b1r4");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }

                                    else if(bts.getId().equals("b2r1")){
                                        bts.setGraphic(showBlueRed(2,2));
                                        bts.setId("b2r2");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("b2r2")){
                                        bts.setGraphic(showBlueRed(2,3));
                                        bts.setId("b2r3");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("b2r3")){
                                        bts.setGraphic(showBlueRed(2,4));
                                        bts.setId("b2r4");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }

                                    else if(bts.getId().equals("b3r1")){
                                        bts.setGraphic(showBlueRed(3,2));
                                        bts.setId("b3r2");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("b3r2")){
                                        bts.setGraphic(showBlueRed(3,3));
                                        bts.setId("b3r3");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("b3r3")){
                                        bts.setGraphic(showBlueRed(3,4));
                                        bts.setId("b3r4");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }

                                    else if(bts.getId().equals("b4r1")){
                                        bts.setGraphic(showBlueRed(4,2));
                                        bts.setId("b4r2");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("b4r2")){
                                        bts.setGraphic(showBlueRed(4,3));
                                        bts.setId("b4r3");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("b4r3")){
                                        bts.setGraphic(showBlueRed(4,4));
                                        bts.setId("b4r4");
                                        if(counter == 1 || bcheck == true){
                                            disableBlue();disableRed();
                                        }
                                        break;
                                    }        
                                    else{
                                        showRprogress();

                                        //Eliminating green with red
                                        if(bts.getId().equals("gt1")){
                                            bts.setGraphic(null);
                                            bts.setId("0");
                                            bts.setDisable(false);
                                            boxValue[face] = 0;
                                            for(Button bte : allGreenBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showGreen(1));
                                                    bte.setId("gt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("gt2")){
                                            bts.setGraphic(showGreen(1));
                                            bts.setId("gt1");
                                            for(Button bte : allGreenBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showGreen(1));
                                                    bte.setId("gt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("gt3")){
                                            bts.setGraphic(showGreen(2));
                                            bts.setId("gt2");
                                            for(Button bte : allGreenBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showGreen(1));
                                                    bte.setId("gt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("gt4")){
                                            bts.setGraphic(showGreen(3));
                                            bts.setId("gt3");
                                            for(Button bte : allGreenBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showGreen(1));
                                                    bte.setId("gt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        //Eliminating yellow with red
                                        if(bts.getId().equals("yt1")){
                                            bts.setGraphic(null);
                                            bts.setId("0");
                                            bts.setDisable(false);
                                            boxValue[face] = 0;
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("yt2")){
                                            bts.setGraphic(showYellow(1));
                                            bts.setId("yt1");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("yt3")){
                                            bts.setGraphic(showYellow(2));
                                            bts.setId("yt2");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("yt4")){
                                            bts.setGraphic(showYellow(3));
                                            bts.setId("yt3");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        //blue or red eliminating opponent doubles
                                        else if(bts.getId().equals("y1g1")){
                                            bts.setGraphic(showGreen(1));
                                            bts.setId("gt1");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showGreen(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y1g2")){
                                            bts.setGraphic(showGreen(2));
                                            bts.setId("gt2");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showGreen(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y1g3")){
                                            bts.setGraphic(showGreen(3));
                                            bts.setId("gt3");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showGreen(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y1g4")){
                                            bts.setGraphic(showGreen(4));
                                            bts.setId("gt4");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showGreen(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y2g1")){
                                            bts.setGraphic(showYellowGreen(1,1));
                                            bts.setId("y1g1");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y2g2")){
                                            bts.setGraphic(showYellowGreen(1,2));
                                            bts.setId("y1g2");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y2g3")){
                                            bts.setGraphic(showYellowGreen(1,3));
                                            bts.setId("y1g3");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y2g4")){
                                            bts.setGraphic(showYellowGreen(1,4));
                                            bts.setId("y1g4");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y3g1")){
                                            bts.setGraphic(showYellowGreen(2,1));
                                            bts.setId("y2g1");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y3g2")){
                                            bts.setGraphic(showYellowGreen(2,2));
                                            bts.setId("y2g2");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y3g3")){
                                            bts.setGraphic(showYellowGreen(2,3));
                                            bts.setId("y2g3");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y3g4")){
                                            bts.setGraphic(showYellowGreen(2,4));
                                            bts.setId("y2g4");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y4g1")){
                                            bts.setGraphic(showYellowGreen(3,1));
                                            bts.setId("y3g1");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y4g2")){
                                            bts.setGraphic(showYellowGreen(3,2));
                                            bts.setId("y3g2");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y4g3")){
                                            bts.setGraphic(showYellowGreen(3,3));
                                            bts.setId("y3g3");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y4g4")){
                                            bts.setGraphic(showYellowGreen(3,4));
                                            bts.setId("y3g4");
                                            for(Button bte : allYellowBut){
                                                if(bte.getId().equals("0")){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showYellow(1));
                                                    bte.setId("yt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        bts.setDisable(false);
                                    }
                                }
                            }
                            
                            
                            
                            
                        } catch (NumberFormatException nfe) {
                        }
                    }
                }
            }
        } 
        else if(bt.getId().substring(0, 1).equals("y") || bt.getId().substring(0, 1).equals("g")){
                if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                    int a = Integer.valueOf(rollSpace1.getText());
                    int b = Integer.valueOf(rollSpace2.getText());
                    int holdA = a;
                    int counter = 0;
                    for(Button bx : road){
                        if( bx.getId().equals("yt1") || bx.getId().equals("gt1")){
                            counter++;   
                        }
                        else if(bx.getId().equals("yt2") || bx.getId().equals("gt2") || 
                            bx.getId().equals("yt3") || bx.getId().equals("gt3") || 
                            bx.getId().equals("yt4") || bx.getId().equals("gt4") ||
                            bx.getId().equals("y1g1") || bx.getId().equals("y2g1") ||
                            bx.getId().equals("y1g2") || bx.getId().equals("y2g2") ||
                            bx.getId().equals("y1g3") || bx.getId().equals("y2g3") ||
                            bx.getId().equals("y1g4") || bx.getId().equals("y2g4") ||
                            bx.getId().equals("y3g1") || bx.getId().equals("y4g1") ||
                            bx.getId().equals("y3g2") || bx.getId().equals("y4g2") ||
                            bx.getId().equals("y3g3") || bx.getId().equals("y4g3") ||
                            bx.getId().equals("y3g4") || bx.getId().equals("y4g4")){

                            counter = 2;
                        }
                    }
                    if(counter == 1 && bn == false && toggle == true){
                        a = a + b;
                        a = a + number;
                        if(holdA == 6 && b == 6){
                            third = true;
                            fourth = true;
                        }
                        else{
                            third = false;
                            fourth = false;
                        }
                        rollBut.setDisable(false);
                        disableHYellow();
                        disableHGreen();
                        enableYellow();
                        enableGreen();
                    }
                    else{
                        a = startYellow2(number);
                    }
                    if(a > 52){
                        a = a - 52;
                    }
                    
                    if(bt.getId().substring(0, 1).equals("y")){
                        yellowInit(bt);
                        try {
                            finalYellow(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                    else if(bt.getId().substring(0, 1).equals("g")){
                        greenInit(bt);
                        try {
                            finalGreen(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                    
                }     //move to other motion methods           
            }
        }
    }
        
    @FXML
    private void moveTileY(ActionEvent event) throws FileNotFoundException {
        Button bt = (Button)event.getSource();
        int number;
        if(bt.getText().length() == 5 || bt.getText().length() == 4){
            number = Integer.parseInt(bt.getText().substring(3));
        }
        else{
            number = Integer.parseInt(bt.getText());
        }
        
        if(playerNumber == 4){
            
        if(bt.getId().substring(0, 1).equals("b")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("bt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("bt2") || x.getId().equals("bt3") || x.getId().equals("bt4")){
                        counter = 2;
                    }                
                }
                if(counter == 1 && bn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    blueDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHBlue();
                    enableBlue();
                }
                else{
                    a = startBlue(number);
                }
                
                if(bt.getId().equals("bt4")){
                    bt.setId("bt3");
                    boxValue[number] = 1;
                    bt.setGraphic(showBlue(3));
                }
                else if(bt.getId().equals("bt3")){
                    bt.setId("bt2");
                    boxValue[number] = 1;
                    bt.setGraphic(showBlue(2));
                }
                else if(bt.getId().equals("bt2")){
                    bt.setId("bt1");
                    boxValue[number] = 1;
                    bt.setGraphic(showBlue(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                
                try {
                    for (Button bts : BlueRoad) {
                        
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) {
                            
                            if(bts.getId().equals("bt1")){
                                bts.setGraphic(showBlue(2));
                                bts.setId("bt2");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else if(bts.getId().equals("bt2")){
                                bts.setGraphic(showBlue(3));
                                bts.setId("bt3");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else if(bts.getId().equals("bt3")){
                                bts.setGraphic(showBlue(4));
                                bts.setId("bt4");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else if(bts.getId().equals("0")){
                                bts.setGraphic(showBlue(1));
                                bts.setId("bt1");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else{
                                showBprogress();
                                //Eliminating red with blue
                                if(bts.getId().equals("rt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt2")){
                                    bts.setGraphic(showRed(1));
                                    bts.setId("rt1");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("rt3")){
                                    bts.setGraphic(showRed(2));
                                    bts.setId("rt2");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt4")){
                                    bts.setGraphic(showRed(3));
                                    bts.setId("rt3");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating green with blue
                                if(bts.getId().equals("gt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt2")){
                                    bts.setGraphic(showGreen(1));
                                    bts.setId("gt1");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt3")){
                                    bts.setGraphic(showGreen(2));
                                    bts.setId("gt2");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt4")){
                                    bts.setGraphic(showGreen(3));
                                    bts.setId("gt3");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating yellow with blue
                                if(bts.getId().equals("yt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt2")){
                                    bts.setGraphic(showYellow(1));
                                    bts.setId("yt1");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt3")){
                                    bts.setGraphic(showYellow(2));
                                    bts.setId("yt2");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt4")){
                                    bts.setGraphic(showYellow(3));
                                    bts.setId("yt3");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            
                            
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
            }
        }
        else if(bt.getId().substring(0, 1).equals("r")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("rt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("rt2") || x.getId().equals("rt3") || x.getId().equals("rt4")){
                        counter = 2;
                    }                
                }
                if(counter == 1 && rn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    redDouble(holdA, holdA);
                    rollBut.setDisable(false);
                    disableHRed();
                    enableRed();
                }
                else{
                    a = startRed(number);
                }
                if(a > 52){
                    a = a - 52;
                }
                
                if(bt.getId().equals("rt4")){
                    bt.setId("rt3");
                    boxValue[number] = 2;
                    bt.setGraphic(showRed(3));
                }
                else if(bt.getId().equals("rt3")){
                    bt.setId("rt2");
                    boxValue[number] = 2;
                    bt.setGraphic(showRed(2));
                }
                else if(bt.getId().equals("rt2")){
                    bt.setId("rt1");
                    boxValue[number] = 2;
                    bt.setGraphic(showRed(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                try {
                    for (Button bts : RedRoad) {
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) {
                            if (bts.getId().equals("rt1")) {
                                bts.setGraphic(showRed(2));
                                bts.setId("rt2");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            } else if (bts.getId().equals("rt2")) {
                                bts.setGraphic(showRed(3));
                                bts.setId("rt3");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            } else if (bts.getId().equals("rt3")) {
                                bts.setGraphic(showRed(4));
                                bts.setId("rt4");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            } else if(bts.getId().equals("0")) {
                                bts.setGraphic(showRed(1));
                                bts.setId("rt1");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            }
                            else{
                                showRprogress();
                                //Eliminating blue with red
                            if(bts.getId().equals("bt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt2")){
                                    bts.setGraphic(showBlue(1));
                                    bts.setId("bt1");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("bt3")){
                                    bts.setGraphic(showBlue(2));
                                    bts.setId("bt2");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;   
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt4")){
                                    bts.setGraphic(showBlue(3));
                                    bts.setId("bt3");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            //Eliminating green with red
                            if(bts.getId().equals("gt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt2")){
                                    bts.setGraphic(showGreen(1));
                                    bts.setId("gt1");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt3")){
                                    bts.setGraphic(showGreen(2));
                                    bts.setId("gt2");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt4")){
                                    bts.setGraphic(showGreen(3));
                                    bts.setId("gt3");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            //Eliminating yellow with red
                            if(bts.getId().equals("yt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt2")){
                                    bts.setGraphic(showYellow(1));
                                    bts.setId("yt1");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt3")){
                                    bts.setGraphic(showYellow(2));
                                    bts.setId("yt2");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt4")){
                                    bts.setGraphic(showYellow(3));
                                    bts.setId("yt3");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
                
            }
        }
        else if(bt.getId().substring(0, 1).equals("y")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("yt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("yt2") || x.getId().equals("yt3") || x.getId().equals("yt4")){
                        counter = 2;
                    }              
                }
                if(counter == 1 && yn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    yellowDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHYellow();
                    enableYellow();
                }
                else{
                    a = startYellow(number);
                }
                
                if(a > 52){
                    a = a - 52;
                }
                try{
                    if(a > 44 && bt.getText().substring(0, 3).equals("yel")){
                        a = number;
                        if(holdA + number == 44){
                            a = holdA + number;
                            rollSpace1.setText("0");
                        }
                        else if(b + number == 44){
                            a = b + number;
                            rollSpace2.setText("0");
                        }
                        else if(holdA > b){
                            a = b + number;
                        }
                        else if(holdA < b){
                            a = holdA + number;
                        }
                        else{
                            a = holdA + number;
                        }
                    }
                    
                    if(a == 44 && bt.getText().substring(0, 3).equals("yel")){
                        if(bt.getId().equals("yt4")){
                            bt.setId("yt3");
                            boxValue[number] = 3;
                            bt.setGraphic(showYellow(3));
                        }
                        else if(bt.getId().equals("yt3")){
                            bt.setId("yt2");
                            boxValue[number] = 3;
                            bt.setGraphic(showYellow(2));
                        }
                        else if(bt.getId().equals("yt2")){
                            bt.setId("yt1");
                            boxValue[number] = 3;
                            bt.setGraphic(showYellow(1));
                        }
                        else {
                            bt.setId("0");
                            boxValue[number] = 0;
                            bt.setGraphic(null);
                        }
                        showYprogress();
                    }
                    else if( a > 44 && bt.getText().substring(0, 3).equals("yel") ){
                        if (number > 38) {
                            if (yEnd == true) {
                                bt.setDisable(true);
                                if(counter == 1){
                                    rollBut.setDisable(false);
                                }
                            } else {
                                bt.setDisable(false);
                                rollBut.setDisable(false);
                                disableYellow();
                                disableHYellow();
                            }
                        }
                    }

                    else{
                        if(bt.getId().equals("yt4")){
                            bt.setId("yt3");
                            boxValue[number] = 3;
                            bt.setGraphic(showYellow(3));
                        }
                        else if(bt.getId().equals("yt3")){
                            bt.setId("yt2");
                            boxValue[number] = 3;
                            bt.setGraphic(showYellow(2));
                        }
                        else if(bt.getId().equals("yt2")){
                            bt.setId("yt1");
                            boxValue[number] = 3;
                            bt.setGraphic(showYellow(1));
                        }
                        else {
                            bt.setId("0");
                            boxValue[number] = 0;
                            bt.setGraphic(null);
                        }
                        try {
                            for (Button bts : YellowRoadEnd) {

                                int face = 0;
                                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                                    face = Integer.parseInt(bts.getText().substring(3));
                                }
                                else{
                                    face = Integer.parseInt(bts.getText());
                                }

                                if (face == a) {

                                    if(bts.getId().equals("yt1")){
                                        bts.setGraphic(showYellow(2));
                                        bts.setId("yt2");
                                        if(counter == 1 || ycheck == true){
                                            disableYellow();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("yt2")){
                                        bts.setGraphic(showYellow(3));
                                        bts.setId("yt3");
                                        if(counter == 1 || ycheck == true){
                                            disableYellow();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("yt3")){
                                        bts.setGraphic(showYellow(4));
                                        bts.setId("yt4");
                                        if(counter == 1 || ycheck == true){
                                            disableYellow();
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("0")){
                                        bts.setGraphic(showYellow(1));
                                        bts.setId("yt1");
                                        if(counter == 1 || ycheck == true){
                                            disableYellow();
                                        }
                                        break;
                                    }
                                    else{
                                        showYprogress();
                                        //Eliminating blue with yellow
                                        if(bts.getId().equals("bt1")){
                                        bts.setGraphic(null);
                                        bts.setId("0");
                                        bts.setDisable(false);
                                        boxValue[face] = 0;
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("bt2")){
                                        bts.setGraphic(showBlue(1));
                                        bts.setId("bt1");
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;
                                            }
                                        }

                                        break;
                                    }
                                    else if(bts.getId().equals("bt3")){
                                        bts.setGraphic(showBlue(2));
                                        bts.setId("bt2");
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;   
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("bt4")){
                                        bts.setGraphic(showBlue(3));
                                        bts.setId("bt3");
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    //Eliminating green with yellow
                                    if(bts.getId().equals("gt1")){
                                        bts.setGraphic(null);
                                        bts.setId("0");
                                        bts.setDisable(false);
                                        boxValue[face] = 0;
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("gt2")){
                                        bts.setGraphic(showGreen(1));
                                        bts.setId("gt1");
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("gt3")){
                                        bts.setGraphic(showGreen(2));
                                        bts.setId("gt2");
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("gt4")){
                                        bts.setGraphic(showGreen(3));
                                        bts.setId("gt3");
                                        for(Button bte : allGreenBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showGreen(1));
                                                bte.setId("gt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                            //Elimanating red with yellow
                                        if(bts.getId().equals("rt1")){
                                            bts.setGraphic(null);
                                            bts.setId("0");
                                            bts.setDisable(false);
                                            boxValue[face] = 0;
                                            for(Button bte : allRedBut){
                                                if(bte.getGraphic()== null){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showRed(1));
                                                    bte.setId("rt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("rt2")){
                                            bts.setGraphic(showRed(1));
                                            bts.setId("rt1");
                                            for(Button bte : allRedBut){
                                                if(bte.getGraphic()== null){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showRed(1));
                                                    bte.setId("rt1");
                                                    break;
                                                }
                                            }

                                            break;
                                        }
                                        else if(bts.getId().equals("rt3")){
                                            bts.setGraphic(showRed(2));
                                            bts.setId("rt2");
                                            for(Button bte : allRedBut){
                                                if(bte.getGraphic()== null){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showRed(1));
                                                    bte.setId("rt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("rt4")){
                                            bts.setGraphic(showRed(3));
                                            bts.setId("rt3");
                                            for(Button bte : allRedBut){
                                                if(bte.getGraphic()== null){
                                                    bte.setDisable(true);
                                                    bte.setGraphic(showRed(1));
                                                    bte.setId("rt1");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        } catch (NumberFormatException nfe) {
                        }
                    }
                }catch(Exception e){}
            }
        }
        else if(bt.getId().substring(0, 1).equals("g")){
            if (!rollSpace1.getText().trim().isEmpty()&& !rollSpace2.getText().trim().isEmpty() ) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("gt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("gt2") || x.getId().equals("gt3") || x.getId().equals("gt4")){
                        counter = 2;
                    }             
                }
                if(counter == 1 && gn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    greenDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHGreen();
                    enableGreen();
                    
                }
                else{
                    a = startGreen(number);
                }
                
                if(a > 52){
                    a = a - 52;
                }
                
                if(bt.getId().equals("gt4")){
                    bt.setId("gt3");
                    boxValue[number] = 4;
                    bt.setGraphic(showGreen(3));
                }
                else if(bt.getId().equals("gt3")){
                    bt.setId("gt2");
                    boxValue[number] = 4;
                    bt.setGraphic(showGreen(2));
                }
                else if(bt.getId().equals("gt2")){
                    bt.setId("gt1");
                    boxValue[number] = 4;
                    bt.setGraphic(showGreen(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                try {
                    for (Button bts : GreenRoad) {
                        
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) {
                            
                            if(bts.getId().equals("gt1")){
                                bts.setGraphic(showGreen(2));
                                bts.setId("gt2");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else if(bts.getId().equals("gt2")){
                                bts.setGraphic(showGreen(3));
                                bts.setId("gt3");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else if(bts.getId().equals("gt3")){
                                bts.setGraphic(showGreen(4));
                                bts.setId("gt4");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else if(bts.getId().equals("0")){
                                bts.setGraphic(showGreen(1));
                                bts.setId("gt1");
                                if(counter == 1 || gcheck == true){
                                    disableGreen();
                                }
                                break;
                            }
                            else{
                                showGprogress();
                                if(bts.getId().equals("bt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt2")){
                                    bts.setGraphic(showBlue(1));
                                    bts.setId("bt1");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("bt3")){
                                    bts.setGraphic(showBlue(2));
                                    bts.setId("bt2");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;   
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt4")){
                                    bts.setGraphic(showBlue(3));
                                    bts.setId("bt3");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }                            
                            //Elimanating red with green
                            if(bts.getId().equals("rt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt2")){
                                    bts.setGraphic(showRed(1));
                                    bts.setId("rt1");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("rt3")){
                                    bts.setGraphic(showRed(2));
                                    bts.setId("rt2");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt4")){
                                    bts.setGraphic(showRed(3));
                                    bts.setId("rt3");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            //Eliminating yellow with green
                            if(bts.getId().equals("yt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt2")){
                                    bts.setGraphic(showYellow(1));
                                    bts.setId("yt1");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt3")){
                                    bts.setGraphic(showYellow(2));
                                    bts.setId("yt2");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt4")){
                                    bts.setGraphic(showYellow(3));
                                    bts.setId("yt3");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                            
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
                
                catch (Exception e) {
                }
                
            }
        }
        }
        else if(playerNumber == 2){
            if(bt.getId().substring(0, 1).equals("b") || bt.getId().substring(0, 1).equals("r")){

                if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                    int a = Integer.valueOf(rollSpace1.getText());
                    int b = Integer.valueOf(rollSpace2.getText());
                    int holdA = a;
                    int counter = 0;
                    for(Button bx : road){
                        if( bx.getId().equals("bt1") || bx.getId().equals("rt1")){
                            counter++;   
                        }
                        else if(bx.getId().equals("bt2") || bx.getId().equals("rt2") || 
                            bx.getId().equals("bt3") || bx.getId().equals("rt3") || 
                            bx.getId().equals("bt4") || bx.getId().equals("rt4") ||
                            bx.getId().equals("b1r1") || bx.getId().equals("b2r1") ||
                            bx.getId().equals("b1r2") || bx.getId().equals("b2r2") ||
                            bx.getId().equals("b1r3") || bx.getId().equals("b2r3") ||
                            bx.getId().equals("b1r4") || bx.getId().equals("b2r4") ||
                            bx.getId().equals("b3r1") || bx.getId().equals("b4r1") ||
                            bx.getId().equals("b3r2") || bx.getId().equals("b4r2") ||
                            bx.getId().equals("b3r3") || bx.getId().equals("b4r3") ||
                            bx.getId().equals("b3r4") || bx.getId().equals("b4r4")){
                            
                            counter = 2;
                        }
                    }
                    if(counter == 1 && bn == false && toggle == true){
                        a = a + b;
                        a = a + number;
                        if(holdA == 6 && b == 6){
                            first = true;
                            second = true;
                        }
                        else{
                            first = false;
                            second = false;
                        }
                        rollBut.setDisable(false);
                        disableHBlue();
                        disableHRed();
                        enableBlue();
                        enableRed();

                    }
                    else{
                        a = startBlue2(number);
                    }

                    //Move blue tile is selected
                    if(bt.getId().substring(0, 1).equals("b")){
                        blueInit(bt, number);
                        try {
                            finalBlue(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                    //if red tile was selected
                    else if(bt.getId().substring(0, 2).equals("rt")){
                        if(a > 52){
                            a = a - 52;
                        }

                        redInit(bt, number);    

                        try {
                            finalRed(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                }
            }
            else if(bt.getId().substring(0, 1).equals("y") || bt.getId().substring(0, 1).equals("g")){
                if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                    int a = Integer.valueOf(rollSpace1.getText());
                    int b = Integer.valueOf(rollSpace2.getText());
                    int holdA = a;
                    int counter = 0;
                    for(Button bx : road){
                        if( bx.getId().equals("yt1") || bx.getId().equals("gt1")){
                            counter++;   
                        }
                        else if(bx.getId().equals("yt2") || bx.getId().equals("gt2") || 
                            bx.getId().equals("yt3") || bx.getId().equals("gt3") || 
                            bx.getId().equals("yt4") || bx.getId().equals("gt4") ||
                            bx.getId().equals("y1g1") || bx.getId().equals("y2g1") ||
                            bx.getId().equals("y1g2") || bx.getId().equals("y2g2") ||
                            bx.getId().equals("y1g3") || bx.getId().equals("y2g3") ||
                            bx.getId().equals("y1g4") || bx.getId().equals("y2g4") ||
                            bx.getId().equals("y3g1") || bx.getId().equals("y4g1") ||
                            bx.getId().equals("y3g2") || bx.getId().equals("y4g2") ||
                            bx.getId().equals("y3g3") || bx.getId().equals("y4g3") ||
                            bx.getId().equals("y3g4") || bx.getId().equals("y4g4")){

                            counter = 2;
                        }
                    }
                    if(counter == 1 && bn == false && toggle == true){
                        a = a + b;
                        a = a + number;
                        if(holdA == 6 && b == 6){
                            third = true;
                            fourth = true;
                        }
                        else{
                            third = false;
                            fourth = false;
                        }
                        rollBut.setDisable(false);
                        disableHYellow();
                        disableHGreen();
                        enableYellow();
                        enableGreen();
                    }
                    else{
                        a = startYellow2(number);
                    }
                    if(a > 52){
                        a = a - 52;
                    }
                    
                    if(bt.getId().substring(0, 1).equals("y")){
                        
                        try{
                            if(a > 44 && bt.getText().substring(0, 3).equals("yel")){
                                a = number;
                                if(holdA + number == 44){
                                    a = holdA + number;
                                    rollSpace1.setText("0");
                                }
                                else if(b + number == 44){
                                    a = b + number;
                                    rollSpace2.setText("0");
                                }
                                else if(holdA > b){
                                    a = b + number;
                                }
                                else if(holdA < b){
                                    a = holdA + number;
                                }
                                else{
                                    a = holdA + number;
                                }
                            }

                            if(a == 44 && bt.getText().substring(0, 3).equals("yel")){
                                yellowInit(bt);
                                showYprogress();
                            }
                            else if( a > 44 && bt.getText().substring(0, 3).equals("yel") ){
                                if (number > 38) {
                                    if (yEnd == true) {
                                        bt.setDisable(true);
                                        if(counter == 1){
                                            rollBut.setDisable(false);
                                        }
                                    } else {
                                        bt.setDisable(false);
                                        rollBut.setDisable(false);
                                        disableYellow();
                                        disableHYellow();
                                        disableGreen();
                                        disableHGreen();
                                    }
                                }
                            }
                            else{
                                yellowInit(bt);
                                try {
                                    for (Button bts : YellowRoadEnd) {
                                        int face = 0;
                                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                                            face = Integer.parseInt(bts.getText().substring(3));
                                        }
                                        else{
                                            face = Integer.parseInt(bts.getText());
                                        }
                                        if (face == a) {

                                            if(bts.getId().equals("yt1")){
                                                bts.setGraphic(showYellow(2));
                                                bts.setId("yt2");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("yt2")){
                                                bts.setGraphic(showYellow(3));
                                                bts.setId("yt3");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("yt3")){
                                                bts.setGraphic(showYellow(4));
                                                bts.setId("yt4");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("0")){
                                                bts.setGraphic(showYellow(1));
                                                bts.setId("yt1");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }

                                            else if(bts.getId().equals("gt1")){
                                                bts.setGraphic(showYellowGreen(1,1));
                                                bts.setId("y1g1");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("gt2")){
                                                bts.setGraphic(showYellowGreen(1,2));
                                                bts.setId("y1g2");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("gt3")){
                                                bts.setGraphic(showYellowGreen(1,3));
                                                bts.setId("y1g3");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("gt4")){
                                                bts.setGraphic(showYellowGreen(1,4));
                                                bts.setId("y1g4");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y1g1")){
                                                bts.setGraphic(showYellowGreen(2,1));
                                                bts.setId("y2g1");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y2g1")){
                                                bts.setGraphic(showYellowGreen(3,1));
                                                bts.setId("y3g1");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y3g1")){
                                                bts.setGraphic(showYellowGreen(4,1));
                                                bts.setId("y4g1");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y1g2")){
                                                bts.setGraphic(showYellowGreen(2,2));
                                                bts.setId("y2g2");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y2g2")){
                                                bts.setGraphic(showYellowGreen(3,2));
                                                bts.setId("y3g2");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y3g2")){
                                                bts.setGraphic(showYellowGreen(4,2));
                                                bts.setId("y4g2");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }

                                            else if(bts.getId().equals("y1g3")){
                                                bts.setGraphic(showYellowGreen(2,3));
                                                bts.setId("y2g3");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y2g3")){
                                                bts.setGraphic(showYellowGreen(3,3));
                                                bts.setId("y3g3");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y3g3")){
                                                bts.setGraphic(showYellowGreen(4,3));
                                                bts.setId("y4g3");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y1g4")){
                                                bts.setGraphic(showYellowGreen(2,4));
                                                bts.setId("y2g4");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y2g4")){
                                                bts.setGraphic(showYellowGreen(3,4));
                                                bts.setId("y3g4");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("y3g4")){
                                                bts.setGraphic(showYellowGreen(4,4));
                                                bts.setId("y4g4");
                                                if(counter == 1 || ycheck == true){
                                                    disableGreen();disableYellow();
                                                }
                                                break;
                                            }
                                            else{
                                                showYprogress();
                                                //Eliminating blue with yellow
                                                if(bts.getId().equals("bt1")){
                                                    bts.setGraphic(null);
                                                    bts.setId("0");
                                                    bts.setDisable(false);
                                                    boxValue[face] = 0;
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("bt2")){
                                                    bts.setGraphic(showBlue(1));
                                                    bts.setId("bt1");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }

                                                    break;
                                                }
                                                else if(bts.getId().equals("bt3")){
                                                    bts.setGraphic(showBlue(2));
                                                    bts.setId("bt2");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("bt4")){
                                                    bts.setGraphic(showBlue(3));
                                                    bts.setId("bt3");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }

                                                //Elimanating red with yellow
                                                if(bts.getId().equals("rt1")){
                                                    bts.setGraphic(null);
                                                    bts.setId("0");
                                                    bts.setDisable(false);
                                                    boxValue[face] = 0;
                                                    for(Button bte : allRedBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showRed(1));
                                                            bte.setId("rt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("rt2")){
                                                    bts.setGraphic(showRed(1));
                                                    bts.setId("rt1");
                                                    for(Button bte : allRedBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showRed(1));
                                                            bte.setId("rt1");
                                                            break;
                                                        }
                                                    }

                                                    break;
                                                }
                                                else if(bts.getId().equals("rt3")){
                                                    bts.setGraphic(showRed(2));
                                                    bts.setId("rt2");
                                                    for(Button bte : allRedBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showRed(1));
                                                            bte.setId("rt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("rt4")){
                                                    bts.setGraphic(showRed(3));
                                                    bts.setId("rt3");
                                                    for(Button bte : allRedBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showRed(1));
                                                            bte.setId("rt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b1r1")){
                                                    bts.setGraphic(showRed(1));
                                                    bts.setId("rt1");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b1r2")){
                                                    bts.setGraphic(showRed(2));
                                                    bts.setId("rt2");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b1r3")){
                                                    bts.setGraphic(showRed(3));
                                                    bts.setId("rt3");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b1r4")){
                                                    bts.setGraphic(showRed(4));
                                                    bts.setId("rt4");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b2r1")){
                                                    bts.setGraphic(showBlueRed(1,1));
                                                    bts.setId("b1r1");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b2r2")){
                                                    bts.setGraphic(showBlueRed(1,2));
                                                    bts.setId("b1r2");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b2r3")){
                                                    bts.setGraphic(showBlueRed(1,3));
                                                    bts.setId("b1r3");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b2r4")){
                                                    bts.setGraphic(showBlueRed(1,4));
                                                    bts.setId("b1r4");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b3r1")){
                                                    bts.setGraphic(showBlueRed(2,1));
                                                    bts.setId("b2r1");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b3r2")){
                                                    bts.setGraphic(showBlueRed(2,2));
                                                    bts.setId("b2r2");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b3r3")){
                                                    bts.setGraphic(showBlueRed(2,3));
                                                    bts.setId("b2r3");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b3r4")){
                                                    bts.setGraphic(showBlueRed(2,4));
                                                    bts.setId("b2r4");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b4r1")){
                                                    bts.setGraphic(showBlueRed(3,1));
                                                    bts.setId("b3r1");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b4r2")){
                                                    bts.setGraphic(showBlueRed(3,2));
                                                    bts.setId("b3r2");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b4r3")){
                                                    bts.setGraphic(showBlueRed(3,3));
                                                    bts.setId("b3r3");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                                else if(bts.getId().equals("b4r4")){
                                                    bts.setGraphic(showBlueRed(3,4));
                                                    bts.setId("b3r4");
                                                    for(Button bte : allBlueBut){
                                                        if(bte.getId().equals("0")){
                                                            bte.setDisable(true);
                                                            bte.setGraphic(showBlue(1));
                                                            bte.setId("bt1");
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } catch (NumberFormatException nfe) {
                                }
                            }
                        } catch (Exception e) {
                        }
                    }
                    else if(bt.getId().substring(0, 1).equals("g")){
                        greenInit(bt);
                        try {
                            finalGreen(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                    
                }     //move to other motion methods           
            }
        }
    }
    
    @FXML
    private void moveTileG(ActionEvent event) throws FileNotFoundException {
        Button bt = (Button)event.getSource();
        int number = 0;
        if(bt.getText().length() == 5 || bt.getText().length() == 4){
            number = Integer.parseInt(bt.getText().substring(3));
        }
        else{
            number = Integer.parseInt(bt.getText());
        }
        if(playerNumber == 4){
        if(bt.getId().substring(0, 1).equals("b")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("bt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("bt2") || x.getId().equals("bt3") || x.getId().equals("bt4")){
                        counter = 2;
                    }              
                }
                if(counter == 1 && bn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    blueDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHBlue();
                    enableBlue();
                }
                else{
                    a = startBlue(number);
                }
                
                if(bt.getId().equals("bt4")){
                    bt.setId("bt3");
                    boxValue[number] = 1;
                    bt.setGraphic(showBlue(3));
                }
                else if(bt.getId().equals("bt3")){
                    bt.setId("bt2");
                    boxValue[number] = 1;
                    bt.setGraphic(showBlue(2));
                }
                else if(bt.getId().equals("bt2")){
                    bt.setId("bt1");
                    boxValue[number] = 1;
                    bt.setGraphic(showBlue(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                
                try {
                    for (Button bts : BlueRoad) {
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }
                        if (face == a) {
                            
                            if(bts.getId().equals("bt1")){
                                bts.setGraphic(showBlue(2));
                                bts.setId("bt2");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else if(bts.getId().equals("bt2")){
                                bts.setGraphic(showBlue(3));
                                bts.setId("bt3");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else if(bts.getId().equals("bt3")){
                                bts.setGraphic(showBlue(4));
                                bts.setId("bt4");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else if(bts.getId().equals("0")){
                                bts.setGraphic(showBlue(1));
                                bts.setId("bt1");
                                if(counter == 1 || bcheck == true){
                                    disableBlue();
                                }
                                break;
                            }
                            else{
                                showBprogress();
                                //Eliminating red with blue
                                if(bts.getId().equals("rt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt2")){
                                    bts.setGraphic(showRed(1));
                                    bts.setId("rt1");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("rt3")){
                                    bts.setGraphic(showRed(2));
                                    bts.setId("rt2");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt4")){
                                    bts.setGraphic(showRed(3));
                                    bts.setId("rt3");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating green with blue
                                if(bts.getId().equals("gt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt2")){
                                    bts.setGraphic(showGreen(1));
                                    bts.setId("gt1");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt3")){
                                    bts.setGraphic(showGreen(2));
                                    bts.setId("gt2");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt4")){
                                    bts.setGraphic(showGreen(3));
                                    bts.setId("gt3");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating yellow with blue
                                if(bts.getId().equals("yt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt2")){
                                    bts.setGraphic(showYellow(1));
                                    bts.setId("yt1");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt3")){
                                    bts.setGraphic(showYellow(2));
                                    bts.setId("yt2");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt4")){
                                    bts.setGraphic(showYellow(3));
                                    bts.setId("yt3");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                bts.setDisable(false);
                            }
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
            }
        }
        else if(bt.getId().substring(0, 1).equals("r")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("rt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("rt2") || x.getId().equals("rt3") || x.getId().equals("rt4")){
                        counter = 2;
                    }               
                }
                if(counter == 1 && rn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    redDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHRed();
                    enableRed();
                }
                else{
                    a = startRed(number);
                }
               
                if(a > 52){
                    a = a - 52;
                }
                
                if(bt.getId().equals("rt4")){
                    bt.setId("rt3");
                    boxValue[number] = 2;
                    bt.setGraphic(showRed(3));
                }
                else if(bt.getId().equals("rt3")){
                    bt.setId("rt2");
                    boxValue[number] = 2;
                    bt.setGraphic(showRed(2));
                }
                else if(bt.getId().equals("rt2")){
                    bt.setId("rt1");
                    boxValue[number] = 2;
                    bt.setGraphic(showRed(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                
                try {
                    for (Button bts : RedRoad) {
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) {
                            if (bts.getId().equals("rt1")) {
                                bts.setGraphic(showRed(2));
                                bts.setId("rt2");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            } else if (bts.getId().equals("rt2")) {
                                bts.setGraphic(showRed(3));
                                bts.setId("rt3");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            } else if (bts.getId().equals("rt3")) {
                                bts.setGraphic(showRed(4));
                                bts.setId("rt4");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            } else if(bts.getId().equals("0")) {
                                bts.setGraphic(showRed(1));
                                bts.setId("rt1");
                                if(counter == 1 || rcheck == true){
                                    disableRed();
                                }
                                break;
                            }
                            else{
                                showRprogress();
                                
                            //Eliminating blue with red
                            if(bts.getId().equals("bt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt2")){
                                    bts.setGraphic(showBlue(1));
                                    bts.setId("bt1");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("bt3")){
                                    bts.setGraphic(showBlue(2));
                                    bts.setId("bt2");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;   
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt4")){
                                    bts.setGraphic(showBlue(3));
                                    bts.setId("bt3");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating green with red
                                if(bts.getId().equals("gt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt2")){
                                    bts.setGraphic(showGreen(1));
                                    bts.setId("gt1");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt3")){
                                    bts.setGraphic(showGreen(2));
                                    bts.setId("gt2");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt4")){
                                    bts.setGraphic(showGreen(3));
                                    bts.setId("gt3");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                //Eliminating yellow with red
                                if(bts.getId().equals("yt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt2")){
                                    bts.setGraphic(showYellow(1));
                                    bts.setId("yt1");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt3")){
                                    bts.setGraphic(showYellow(2));
                                    bts.setId("yt2");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("yt4")){
                                    bts.setGraphic(showYellow(3));
                                    bts.setId("yt3");
                                    for(Button bte : allYellowBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showYellow(1));
                                            bte.setId("yt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        
                    }
                } catch (NumberFormatException nfe) {
                }
                
            }
        }
        else if(bt.getId().substring(0, 1).equals("y")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("yt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("yt2") || x.getId().equals("yt3") || x.getId().equals("yt4")){
                        counter = 2;
                    }              
                }
                if(counter == 1 && yn == false && toggle == true){
                    a = a + b;
                    a = a + number;;
                    yellowDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHYellow();
                    enableYellow();
                }
                else{
                    a = startYellow(number);
                }
                
                
                if(a > 52){
                    a = a - 52;
                }
                
                if(bt.getId().equals("yt4")){
                    bt.setId("yt3");
                    boxValue[number] = 3;
                    bt.setGraphic(showYellow(3));
                }
                else if(bt.getId().equals("yt3")){
                    bt.setId("yt2");
                    boxValue[number] = 3;
                    bt.setGraphic(showYellow(2));
                }
                else if(bt.getId().equals("yt2")){
                    bt.setId("yt1");
                    boxValue[number] = 3;
                    bt.setGraphic(showYellow(1));
                }
                else {
                    bt.setId("0");
                    boxValue[number] = 0;
                    bt.setGraphic(null);
                }
                try {
                    for (Button bts : YellowRoad) {
                        
                        int face = 0;
                        if(bts.getText().length() == 5 || bts.getText().length() == 4){
                            face = Integer.parseInt(bts.getText().substring(3));
                        }
                        else{
                            face = Integer.parseInt(bts.getText());
                        }

                        if (face == a) {
                            
                            if(bts.getId().equals("yt1")){
                                bts.setGraphic(showYellow(2));
                                bts.setId("yt2");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else if(bts.getId().equals("yt2")){
                                bts.setGraphic(showYellow(3));
                                bts.setId("yt3");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else if(bts.getId().equals("yt3")){
                                bts.setGraphic(showYellow(4));
                                bts.setId("yt4");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else if(bts.getId().equals("0")){
                                bts.setGraphic(showYellow(1));
                                bts.setId("yt1");
                                if(counter == 1 || ycheck == true){
                                    disableYellow();
                                }
                                break;
                            }
                            else{
                                showYprogress();
                                //Eliminating blue with yellow
                            if(bts.getId().equals("bt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt2")){
                                    bts.setGraphic(showBlue(1));
                                    bts.setId("bt1");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("bt3")){
                                    bts.setGraphic(showBlue(2));
                                    bts.setId("bt2");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;   
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("bt4")){
                                    bts.setGraphic(showBlue(3));
                                    bts.setId("bt3");
                                    for(Button bte : allBlueBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showBlue(1));
                                            bte.setId("bt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            else if(bts.getId().equals("bt4")){
                                bts.setGraphic(showBlue(3));
                                for(Button bte : allBlueBut){
                                    if(bte.getId().equals("0")){
                                        bte.setDisable(true);
                                        bte.setGraphic(showBlue(1));
                                        bte.setId("bt1");
                                        break;
                                    }
                                }
                                break;
                            }
                                    //Eliminating green with yellow
                            if(bts.getId().equals("gt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt2")){
                                    bts.setGraphic(showGreen(1));
                                    bts.setId("gt1");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt3")){
                                    bts.setGraphic(showGreen(2));
                                    bts.setId("gt2");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt4")){
                                    bts.setGraphic(showGreen(3));
                                    bts.setId("gt3");
                                    for(Button bte : allGreenBut){
                                        if(bte.getId().equals("0")){
                                            bte.setDisable(true);
                                            bte.setGraphic(showGreen(1));
                                            bte.setId("gt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            //Elimanating red with yellow
                            if(bts.getId().equals("rt1")){
                                    bts.setGraphic(null);
                                    bts.setId("0");
                                    bts.setDisable(false);
                                    boxValue[face] = 0;
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt2")){
                                    bts.setGraphic(showRed(1));
                                    bts.setId("rt1");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }

                                    break;
                                }
                                else if(bts.getId().equals("rt3")){
                                    bts.setGraphic(showRed(2));
                                    bts.setId("rt2");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("rt4")){
                                    bts.setGraphic(showRed(3));
                                    bts.setId("rt3");
                                    for(Button bte : allRedBut){
                                        if(bte.getGraphic()== null){
                                            bte.setDisable(true);
                                            bte.setGraphic(showRed(1));
                                            bte.setId("rt1");
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                } catch (NumberFormatException nfe) {
                }
                
            }
        }
        else if(bt.getId().substring(0, 1).equals("g")){
            if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                int a = Integer.valueOf(rollSpace1.getText());
                int b = Integer.valueOf(rollSpace2.getText());
                int holdA = a; int holdB = b;
                int counter = 0;
                for(Button x : road){
                    if(x.getId().equals("gt1")){
                        counter++;   
                    }
                    else if(x.getId().equals("gt2") || x.getId().equals("gt3") || x.getId().equals("gt4")){
                        counter = 2;
                    }               
                }
                if(counter == 1 && gn == false && toggle == true){
                    a = a + b;
                    a = a + number;
                    greenDouble(holdA, holdB);
                    rollBut.setDisable(false);
                    disableHGreen();
                    enableGreen();
                }
                else{
                    a = startGreen(number);
                }
                
                
                if(a > 52){
                    a = a - 52;
                }
                
                try{
                    
                if(a > 31 && bt.getText().substring(0, 3).equals("gre")){
                    a = number;
                    if((holdA + number) == 31){
                        a = holdA + number;
                        rollSpace1.setText("0");
                    }
                    else if((b + number) == 31){
                        a = b + number;
                        rollSpace2.setText("0");
                    }
                    else if(holdA > b){
                        a = b + number;
                    }
                    else if(holdA < b){
                        a = holdA + number;
                    }
                    else{
                        a = holdA + number;
                    }
                }
                
                if(a == 31 && bt.getText().substring(0, 3).equals("gre")){
                    if(bt.getId().equals("gt4")){
                        bt.setId("gt3");
                        boxValue[number] = 4;
                        bt.setGraphic(showGreen(3));
                    }
                    else if(bt.getId().equals("gt3")){
                        bt.setId("gt2");
                        boxValue[number] = 4;
                        bt.setGraphic(showGreen(2));
                    }
                    else if(bt.getId().equals("gt2")){
                        bt.setId("gt1");
                        boxValue[number] = 4;
                        bt.setGraphic(showGreen(1));
                    }
                    else {
                        bt.setId("0");
                        boxValue[number] = 0;
                        bt.setGraphic(null);
                    }
                    showGprogress();
                    
                }
                else if(a > 31 && bt.getText().substring(0, 3).equals("gre")){
                    if (number > 25) {
                        if (gEnd == true) {
                            bt.setDisable(true);
                            if(counter == 1){
                                rollBut.setDisable(false);
                            }
                        } else {
                            bt.setDisable(false);
                            rollBut.setDisable(false);
                            disableGreen();
                            disableHGreen();
                        }
                    }
                }
                
                else{
                    
                    if(bt.getId().equals("gt4")){
                        bt.setId("gt3");
                        boxValue[number] = 4;
                        bt.setGraphic(showGreen(3));
                    }
                    else if(bt.getId().equals("gt3")){
                        bt.setId("gt2");
                        boxValue[number] = 4;
                        bt.setGraphic(showGreen(2));
                    }
                    else if(bt.getId().equals("gt2")){
                        bt.setId("gt1");
                        boxValue[number] = 4;
                        bt.setGraphic(showGreen(1));
                    }
                    else {
                        bt.setId("0");
                        boxValue[number] = 0;
                        bt.setGraphic(null);
                    }
                    try {
                        for (Button bts : GreenRoadEnd) {

                            int face = 0;
                            if(bts.getText().length() == 5 || bts.getText().length() == 4){
                                face = Integer.parseInt(bts.getText().substring(3));
                            }
                            else{
                                face = Integer.parseInt(bts.getText());
                            }

                            if (face == a) {
                                
                                if(bts.getId().equals("gt1")){
                                    bts.setGraphic(showGreen(2));
                                    bts.setId("gt2");
                                    if(counter == 1 || gcheck == true){
                                        disableGreen();
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt2")){
                                    bts.setGraphic(showGreen(3));
                                    bts.setId("gt3");
                                    if(counter == 1 || gcheck == true){
                                        disableGreen();
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("gt3")){
                                    bts.setGraphic(showGreen(4));
                                    bts.setId("gt4");
                                    if(counter == 1 || gcheck == true){
                                        disableGreen();
                                    }
                                    break;
                                }
                                else if(bts.getId().equals("0")){
                                    bts.setGraphic(showGreen(1));
                                    bts.setId("gt1");
                                    if(counter == 1 || gcheck == true){
                                        disableGreen();
                                    }
                                    break;
                                }
                                else{
                                    showGprogress();
                                    if(bts.getId().equals("bt1")){
                                        bts.setGraphic(null);
                                        bts.setId("0");
                                        bts.setDisable(false);
                                        boxValue[face] = 0;
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("bt2")){
                                        bts.setGraphic(showBlue(1));
                                        bts.setId("bt1");
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;
                                            }
                                        }

                                        break;
                                    }
                                    else if(bts.getId().equals("bt3")){
                                        bts.setGraphic(showBlue(2));
                                        bts.setId("bt2");
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;   
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("bt4")){
                                        bts.setGraphic(showBlue(3));
                                        bts.setId("bt3");
                                        for(Button bte : allBlueBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showBlue(1));
                                                bte.setId("bt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    //Elimanating red with green
                                    if(bts.getId().equals("rt1")){
                                        bts.setGraphic(null);
                                        bts.setId("0");
                                        bts.setDisable(false);
                                        boxValue[face] = 0;
                                        for(Button bte : allRedBut){
                                            if(bte.getGraphic()== null){
                                                bte.setDisable(true);
                                                bte.setGraphic(showRed(1));
                                                bte.setId("rt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("rt2")){
                                        bts.setGraphic(showRed(1));
                                        bts.setId("rt1");
                                        for(Button bte : allRedBut){
                                            if(bte.getGraphic()== null){
                                                bte.setDisable(true);
                                                bte.setGraphic(showRed(1));
                                                bte.setId("rt1");
                                                break;
                                            }
                                        }

                                        break;
                                    }
                                    else if(bts.getId().equals("rt3")){
                                        bts.setGraphic(showRed(2));
                                        bts.setId("rt2");
                                        for(Button bte : allRedBut){
                                            if(bte.getGraphic()== null){
                                                bte.setDisable(true);
                                                bte.setGraphic(showRed(1));
                                                bte.setId("rt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("rt4")){
                                        bts.setGraphic(showRed(3));
                                        bts.setId("rt3");
                                        for(Button bte : allRedBut){
                                            if(bte.getGraphic()== null){
                                                bte.setDisable(true);
                                                bte.setGraphic(showRed(1));
                                                bte.setId("rt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    //Eliminating yellow with green
                                    if(bts.getId().equals("yt1")){
                                        bts.setGraphic(null);
                                        bts.setId("0");
                                        bts.setDisable(false);
                                        boxValue[face] = 0;
                                        for(Button bte : allYellowBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showYellow(1));
                                                bte.setId("yt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("yt2")){
                                        bts.setGraphic(showYellow(1));
                                        bts.setId("yt1");
                                        for(Button bte : allYellowBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showYellow(1));
                                                bte.setId("yt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("yt3")){
                                        bts.setGraphic(showYellow(2));
                                        bts.setId("yt2");
                                        for(Button bte : allYellowBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showYellow(1));
                                                bte.setId("yt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                    else if(bts.getId().equals("yt4")){
                                        bts.setGraphic(showYellow(3));
                                        bts.setId("yt3");
                                        for(Button bte : allYellowBut){
                                            if(bte.getId().equals("0")){
                                                bte.setDisable(true);
                                                bte.setGraphic(showYellow(1));
                                                bte.setId("yt1");
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }   
                            }
                        }
                    } catch (NumberFormatException nfe) {
                    }
                }
                }catch(Exception e){}
                
            }
            
        }
        }
        else if(playerNumber == 2){
            if(bt.getId().substring(0, 1).equals("b") || bt.getId().substring(0, 1).equals("r")){

                if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                    int a = Integer.valueOf(rollSpace1.getText());
                    int b = Integer.valueOf(rollSpace2.getText());
                    int holdA = a;
                    int counter = 0;
                    for(Button bx : road){
                        if( bx.getId().equals("bt1") || bx.getId().equals("rt1")){
                            counter++;   
                        }
                        else if(bx.getId().equals("bt2") || bx.getId().equals("rt2") || 
                            bx.getId().equals("bt3") || bx.getId().equals("rt3") || 
                            bx.getId().equals("bt4") || bx.getId().equals("rt4") ||
                            bx.getId().equals("b1r1") || bx.getId().equals("b2r1") ||
                            bx.getId().equals("b1r2") || bx.getId().equals("b2r2") ||
                            bx.getId().equals("b1r3") || bx.getId().equals("b2r3") ||
                            bx.getId().equals("b1r4") || bx.getId().equals("b2r4") ||
                            bx.getId().equals("b3r1") || bx.getId().equals("b4r1") ||
                            bx.getId().equals("b3r2") || bx.getId().equals("b4r2") ||
                            bx.getId().equals("b3r3") || bx.getId().equals("b4r3") ||
                            bx.getId().equals("b3r4") || bx.getId().equals("b4r4")){
                            
                            counter = 2;
                        }
                    }
                    if(counter == 1 && bn == false && toggle == true){
                        a = a + b;
                        a = a + number;
                        if(holdA == 6 && b == 6){
                            first = true;
                            second = true;
                        }
                        else{
                            first = false;
                            second = false;
                        }
                        rollBut.setDisable(false);
                        disableHBlue();
                        disableHRed();
                        enableBlue();
                        enableRed();

                    }
                    else{
                        a = startBlue2(number);
                    }

                    //Move blue tile is selected
                    if(bt.getId().substring(0, 1).equals("b")){
                        blueInit(bt, number);
                        try {
                            finalBlue(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                    //if red tile was selected
                    else if(bt.getId().substring(0, 2).equals("rt")){
                        if(a > 52){
                            a = a - 52;
                        }

                        redInit(bt, number);    

                        try {
                            finalRed(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                }
            }
            else if(bt.getId().substring(0, 1).equals("y") || bt.getId().substring(0, 1).equals("g")){
                if (!rollSpace1.getText().trim().isEmpty() && !rollSpace2.getText().trim().isEmpty()) {
                    int a = Integer.valueOf(rollSpace1.getText());
                    int b = Integer.valueOf(rollSpace2.getText());
                    int holdA = a;
                    int counter = 0;
                    for(Button bx : road){
                        if( bx.getId().equals("yt1") || bx.getId().equals("gt1")){
                            counter++;   
                        }
                        else if(bx.getId().equals("yt2") || bx.getId().equals("gt2") || 
                            bx.getId().equals("yt3") || bx.getId().equals("gt3") || 
                            bx.getId().equals("yt4") || bx.getId().equals("gt4") ||
                            bx.getId().equals("y1g1") || bx.getId().equals("y2g1") ||
                            bx.getId().equals("y1g2") || bx.getId().equals("y2g2") ||
                            bx.getId().equals("y1g3") || bx.getId().equals("y2g3") ||
                            bx.getId().equals("y1g4") || bx.getId().equals("y2g4") ||
                            bx.getId().equals("y3g1") || bx.getId().equals("y4g1") ||
                            bx.getId().equals("y3g2") || bx.getId().equals("y4g2") ||
                            bx.getId().equals("y3g3") || bx.getId().equals("y4g3") ||
                            bx.getId().equals("y3g4") || bx.getId().equals("y4g4")){

                            counter = 2;
                        }
                    }
                    if(counter == 1 && bn == false && toggle == true){
                        a = a + b;
                        a = a + number;
                        if(holdA == 6 && b == 6){
                            third = true;
                            fourth = true;
                        }
                        else{
                            third = false;
                            fourth = false;
                        }
                        rollBut.setDisable(false);
                        disableHYellow();
                        disableHGreen();
                        enableYellow();
                        enableGreen();
                    }
                    else{
                        a = startYellow2(number);
                    }
                    
                    if(a > 52){
                        a = a - 52;
                    }
                    
                    if(bt.getId().substring(0, 1).equals("y")){
                        yellowInit(bt);
                        try {
                            finalYellow(a, counter);
                        } catch (NumberFormatException nfe) {
                        }
                    }
                    else if(bt.getId().substring(0, 1).equals("g")){
                        
                        try {
                            if(a > 31 && bt.getText().substring(0, 3).equals("gre")){
                                a = number;
                                if((holdA + number) == 31){
                                    a = holdA + number;
                                    rollSpace1.setText("0");
                                }
                                else if((b + number) == 31){
                                    a = b + number;
                                    rollSpace2.setText("0");
                                }
                                else if(holdA > b){
                                    a = b + number;
                                }
                                else if(holdA < b){
                                    a = holdA + number;
                                }
                                else{
                                    a = holdA + number;
                                }
                            }

                            if(a == 31 && bt.getText().substring(0, 3).equals("gre")){
                                greenInit(bt);
                                showGprogress();

                            }
                            else if(a > 31 && bt.getText().substring(0, 3).equals("gre")){
                                
                                if (number > 25) {
                                    if (yEnd == true) {
                                        bt.setDisable(true);
                                        if(counter == 1){
                                            rollBut.setDisable(false);
                                        }
                                    } else {
                                        bt.setDisable(false);
                                        rollBut.setDisable(false);
                                        disableGreen();
                                        disableHGreen();
                                        disableYellow();
                                        disableHYellow();
                                    }
                                }
                
                            }
                            else{
                                greenInit(bt);
                                for (Button bts : GreenRoadEnd) {

                                    int face = 0;
                                    if(bts.getText().length() == 5 || bts.getText().length() == 4){
                                        face = Integer.parseInt(bts.getText().substring(3));
                                    }
                                    else{
                                        face = Integer.parseInt(bts.getText());
                                    }

                                    if (face == a) {

                                        if(bts.getId().equals("gt1")){
                                            bts.setGraphic(showGreen(2));
                                            bts.setId("gt2");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("gt2")){
                                            bts.setGraphic(showGreen(3));
                                            bts.setId("gt3");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("gt3")){
                                            bts.setGraphic(showGreen(4));
                                            bts.setId("gt4");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("0")){
                                            bts.setGraphic(showGreen(1));
                                            bts.setId("gt1");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("yt1")){
                                            bts.setGraphic(showYellowGreen(1,1));
                                            bts.setId("y1g1");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("yt2")){
                                            bts.setGraphic(showYellowGreen(2,1));
                                            bts.setId("y2g1");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("yt3")){
                                            bts.setGraphic(showYellowGreen(3,1));
                                            bts.setId("y3g1");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("yt4")){
                                            bts.setGraphic(showYellowGreen(4,1));
                                            bts.setId("y4g1");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y1g1")){
                                            bts.setGraphic(showYellowGreen(1,2));
                                            bts.setId("y1g2");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y2g1")){
                                            bts.setGraphic(showYellowGreen(2,2));
                                            bts.setId("y2g2");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y3g1")){
                                            bts.setGraphic(showYellowGreen(3,2));
                                            bts.setId("y3g2");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y4g1")){
                                            bts.setGraphic(showYellowGreen(4,2));
                                            bts.setId("y4g2");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y1g2")){
                                            bts.setGraphic(showYellowGreen(1,3));
                                            bts.setId("y1g3");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y2g2")){
                                            bts.setGraphic(showYellowGreen(2,3));
                                            bts.setId("y2g3");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y3g2")){
                                            bts.setGraphic(showYellowGreen(3,3));
                                            bts.setId("y3g3");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y4g2")){
                                            bts.setGraphic(showYellowGreen(4,3));
                                            bts.setId("y4g3");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y1g3")){
                                            bts.setGraphic(showYellowGreen(1,4));
                                            bts.setId("y1g4");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y2g3")){
                                            bts.setGraphic(showYellowGreen(2,4));
                                            bts.setId("y2g4");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y3g3")){
                                            bts.setGraphic(showYellowGreen(3,4));
                                            bts.setId("y3g4");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else if(bts.getId().equals("y4g3")){
                                            bts.setGraphic(showYellowGreen(4,4));
                                            bts.setId("y4g4");
                                            if(counter == 1 || ycheck == true){
                                                disableYellow(); disableGreen();
                                            }
                                            break;
                                        }
                                        else{
                                            showGprogress();
                                            if(bts.getId().equals("bt1")){
                                                bts.setGraphic(null);
                                                bts.setId("0");
                                                bts.setDisable(false);
                                                boxValue[face] = 0;
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("bt2")){
                                                bts.setGraphic(showBlue(1));
                                                bts.setId("bt1");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }

                                                break;
                                            }
                                            else if(bts.getId().equals("bt3")){
                                                bts.setGraphic(showBlue(2));
                                                bts.setId("bt2");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("bt4")){
                                                bts.setGraphic(showBlue(3));
                                                bts.setId("bt3");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }


                                            //Elimanating red with green
                                            if(bts.getId().equals("rt1")){
                                                bts.setGraphic(null);
                                                bts.setId("0");
                                                bts.setDisable(false);
                                                boxValue[face] = 0;
                                                for(Button bte : allRedBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showRed(1));
                                                        bte.setId("rt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("rt2")){
                                                bts.setGraphic(showRed(1));
                                                bts.setId("rt1");
                                                for(Button bte : allRedBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showRed(1));
                                                        bte.setId("rt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("rt3")){
                                                bts.setGraphic(showRed(2));
                                                bts.setId("rt2");
                                                for(Button bte : allRedBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showRed(1));
                                                        bte.setId("rt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("rt4")){
                                                bts.setGraphic(showRed(3));
                                                bts.setId("rt3");
                                                for(Button bte : allRedBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showRed(1));
                                                        bte.setId("rt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b1r1")){
                                                bts.setGraphic(showRed(1));
                                                bts.setId("rt1");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b1r2")){
                                                bts.setGraphic(showRed(2));
                                                bts.setId("rt2");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b1r3")){
                                                bts.setGraphic(showRed(3));
                                                bts.setId("rt3");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b1r4")){
                                                bts.setGraphic(showRed(4));
                                                bts.setId("rt4");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b2r1")){
                                                bts.setGraphic(showBlueRed(1,1));
                                                bts.setId("b1r1");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b2r2")){
                                                bts.setGraphic(showBlueRed(1,2));
                                                bts.setId("b1r2");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b2r3")){
                                                bts.setGraphic(showBlueRed(1,3));
                                                bts.setId("b1r3");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b2r4")){
                                                bts.setGraphic(showBlueRed(1,4));
                                                bts.setId("b1r4");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b3r1")){
                                                bts.setGraphic(showBlueRed(2,1));
                                                bts.setId("b2r1");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b3r2")){
                                                bts.setGraphic(showBlueRed(2,2));
                                                bts.setId("b2r2");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b3r3")){
                                                bts.setGraphic(showBlueRed(2,3));
                                                bts.setId("b2r3");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b3r4")){
                                                bts.setGraphic(showBlueRed(2,4));
                                                bts.setId("b2r4");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b4r1")){
                                                bts.setGraphic(showBlueRed(3,1));
                                                bts.setId("b3r1");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b4r2")){
                                                bts.setGraphic(showBlueRed(3,2));
                                                bts.setId("b3r2");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b4r3")){
                                                bts.setGraphic(showBlueRed(3,3));
                                                bts.setId("b3r3");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                            else if(bts.getId().equals("b4r4")){
                                                bts.setGraphic(showBlueRed(3,4));
                                                bts.setId("b3r4");
                                                for(Button bte : allBlueBut){
                                                    if(bte.getId().equals("0")){
                                                        bte.setDisable(true);
                                                        bte.setGraphic(showBlue(1));
                                                        bte.setId("bt1");
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (NumberFormatException nfe) {
                        }
                    }
                    
                }     //move to other motion methods           
            }
            
        }
    }
    
    
    public void gameOver(){
        for(Button bt: allButtons){
            bt.setDisable(true);
        }
    }
    
    public void disableBlue(){
        for(Button bt: road){
            if(bt.getId().substring(0, 1).equals("b")){
                bt.setDisable(true);
            }
        }
    }
    public void enableBlue(){
        for(Button bt: road){
            if(bt.getId().substring(0, 1).equals("b")){
                bt.setDisable(false);
            }
        }
    }
    
    
    public void disableRed(){
        for(Button bt: road){
            if(bt.getId().substring(0, 1).equals("r")){
                bt.setDisable(true);
            }
        }
    }
    public void enableRed(){
        for(Button bt: road){
            if(bt.getId().substring(0, 1).equals("r")){
                bt.setDisable(false);
            }
        }
    }
    
    
    public void disableYellow(){
        for(Button bt: road){
            if(bt.getId().substring(0, 1).equals("y")){
                bt.setDisable(true);
            }
        }
    }
    public void enableYellow(){
        for(Button bt: road){
            if(bt.getId().substring(0, 1).equals("y")){
                bt.setDisable(false);
            }
        }
    }
    
    
    public void disableGreen(){
        for(Button bt: road){
            if(bt.getId().substring(0, 1).equals("g")){
                bt.setDisable(true);
            }
        }
    }
    public void enableGreen(){
        for(Button bt: road){
            if(bt.getId().substring(0, 1).equals("g")){
                bt.setDisable(false);
            }
        }
    }
    
    
    public void disableHBlue(){
        for(Button bt: allBlueBut){
            bt.setDisable(true);
        }
    }
    public void enableHBlue(){
        for(Button bt: allBlueBut){
            bt.setDisable(false);
        }
    }
    public void disableHRed(){
        for(Button bt: allRedBut){
            bt.setDisable(true);
        }
    }
    public void enableHRed(){
        for(Button bt: allRedBut){
            bt.setDisable(false);
        }
    }
    public void disableHYellow(){
        for(Button bt: allYellowBut){
            bt.setDisable(true);
        }
    }
    public void enableHYellow(){
        for(Button bt: allYellowBut){
            bt.setDisable(false);
        }
    }
    public void disableHGreen(){
        for(Button bt: allGreenBut){
            bt.setDisable(true);
        }
    }
    public void enableHGreen(){
        for(Button bt: allGreenBut){ 
            bt.setDisable(false);
        }
    }
    
    public void disableAll(){
        disableHBlue();
        disableHGreen();
        disableHRed();
        disableHYellow();
    }
    public void enableALL(){
        enableHBlue();
        enableHRed();
        enableHGreen();
        enableHYellow();
    }
    
    
    
    

    @FXML
    private void players(ActionEvent event) {
        rollBut.setDisable(false);
        
        if(twoPlayers.isSelected()){
            playerNumber = 2;
            p1Lab.setText("Player 1:");
            p2Lab.setText("Player 1:");
            p3Lab.setText("Player 2:");
            p4Lab.setText("Player 2:");
            confirmPlayers();
            disableAll();
            
            
        }
        else if(threePlayers.isSelected()){
            playerNumber = 4;
            greenCont = false;
            p1Lab.setText("Player 1:");
            p2Lab.setText("Player 2:");
            p3Lab.setText("Player 3:");
            p4Lab.setText("");
            confirmPlayers();
            disableAll();
        }
        else if(fourPlayers.isSelected()){
            playerNumber = 4;
            greenCont = true;
            p1Lab.setText("Player 1:");
            p2Lab.setText("Player 2:");
            p3Lab.setText("Player 3:");
            p4Lab.setText("Player 4:");
            confirmPlayers();
            disableAll();
        }
        
        
        
    }
    
    public void confirmPlayers(){
        twoPlayers.setDisable(true);
        threePlayers.setDisable(true);
        fourPlayers.setDisable(true);
    }
    
    
    public ImageView  showRed(int x) throws FileNotFoundException{
        FileInputStream input1 = new FileInputStream("src\\images\\RedTile1.png");
        FileInputStream input2 = new FileInputStream("src\\images\\RedTile2.png");
        FileInputStream input3 = new FileInputStream("src\\images\\RedTile3.png");
        FileInputStream input4 = new FileInputStream("src\\images\\RedTile4.png");
        Image image1 = new Image(input1);
        Image image2 = new Image(input2);
        Image image3 = new Image(input3);
        Image image4 = new Image(input4);
        
        ImageView imageview = new ImageView();
        
        if(x == 1){
            imageview = new ImageView(image1);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 2){
            imageview = new ImageView(image2);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 3){
            imageview = new ImageView(image3);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 4){
            imageview = new ImageView(image4);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        return imageview;
    }
    public ImageView  showGreen(int x) throws FileNotFoundException{
        FileInputStream input1 = new FileInputStream("src\\images\\GreenTile1.png");
        FileInputStream input2 = new FileInputStream("src\\images\\GreenTile2.png");
        FileInputStream input3 = new FileInputStream("src\\images\\GreenTile3.png");
        FileInputStream input4 = new FileInputStream("src\\images\\GreenTile4.png");
        Image image1 = new Image(input1);
        Image image2 = new Image(input2);
        Image image3 = new Image(input3);
        Image image4 = new Image(input4);
        
        ImageView imageview = new ImageView();
        
        if(x == 1){
            imageview = new ImageView(image1);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 2){
            imageview = new ImageView(image2);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 3){
            imageview = new ImageView(image3);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 4){
            imageview = new ImageView(image4);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        return imageview;
    }
    public ImageView  showYellow(int x) throws FileNotFoundException{
        FileInputStream input1 = new FileInputStream("src\\images\\YellowTile1.png");
        FileInputStream input2 = new FileInputStream("src\\images\\YellowTile2.png");
        FileInputStream input3 = new FileInputStream("src\\images\\YellowTile3.png");
        FileInputStream input4 = new FileInputStream("src\\images\\YellowTile4.png");
        Image image1 = new Image(input1);
        Image image2 = new Image(input2);
        Image image3 = new Image(input3);
        Image image4 = new Image(input4);
        
        ImageView imageview = new ImageView();
        
        if(x == 1){
            imageview = new ImageView(image1);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 2){
            imageview = new ImageView(image2);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 3){
            imageview = new ImageView(image3);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 4){
            imageview = new ImageView(image4);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        return imageview;
    }
    public ImageView  showBlue(int x) throws FileNotFoundException{
        FileInputStream input1 = new FileInputStream("src\\images\\BlueTile1.png");
        FileInputStream input2 = new FileInputStream("src\\images\\BlueTile2.png");
        FileInputStream input3 = new FileInputStream("src\\images\\BlueTile3.png");
        FileInputStream input4 = new FileInputStream("src\\images\\BlueTile4.png");
        Image image1 = new Image(input1);
        Image image2 = new Image(input2);
        Image image3 = new Image(input3);
        Image image4 = new Image(input4);
        
        ImageView imageview = new ImageView();
        
        if(x == 1){
            imageview = new ImageView(image1);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 2){
            imageview = new ImageView(image2);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 3){
            imageview = new ImageView(image3);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 4){
            imageview = new ImageView(image4);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        return imageview;
    }
    public ImageView  showBlueRed(int x, int y) throws FileNotFoundException{
        FileInputStream input11 = new FileInputStream("src\\images\\BlueRedTile11.png");
        FileInputStream input12 = new FileInputStream("src\\images\\BlueRedTile12.png");
        FileInputStream input13 = new FileInputStream("src\\images\\BlueRedTile13.png");
        FileInputStream input14 = new FileInputStream("src\\images\\BlueRedTile14.png");
        FileInputStream input21 = new FileInputStream("src\\images\\BlueRedTile21.png");
        FileInputStream input22 = new FileInputStream("src\\images\\BlueRedTile22.png");
        FileInputStream input23 = new FileInputStream("src\\images\\BlueRedTile23.png");
        FileInputStream input24 = new FileInputStream("src\\images\\BlueRedTile24.png");
        FileInputStream input31 = new FileInputStream("src\\images\\BlueRedTile31.png");
        FileInputStream input32 = new FileInputStream("src\\images\\BlueRedTile32.png");
        FileInputStream input33 = new FileInputStream("src\\images\\BlueRedTile33.png");
        FileInputStream input34 = new FileInputStream("src\\images\\BlueRedTile34.png");
        FileInputStream input41 = new FileInputStream("src\\images\\BlueRedTile41.png");
        FileInputStream input42 = new FileInputStream("src\\images\\BlueRedTile42.png");
        FileInputStream input43 = new FileInputStream("src\\images\\BlueRedTile43.png");
        FileInputStream input44 = new FileInputStream("src\\images\\BlueRedTile44.png");
        
        Image image11 = new Image(input11);
        Image image12 = new Image(input12);
        Image image13 = new Image(input13);
        Image image14 = new Image(input14);
        Image image21 = new Image(input21);
        Image image22 = new Image(input22);
        Image image23 = new Image(input23);
        Image image24 = new Image(input24);
        Image image31 = new Image(input31);
        Image image32 = new Image(input32);
        Image image33 = new Image(input33);
        Image image34 = new Image(input34);
        Image image41 = new Image(input41);
        Image image42 = new Image(input42);
        Image image43 = new Image(input43);
        Image image44 = new Image(input44);
        
        
        
        ImageView imageview = new ImageView();
        
        if(x == 1 && y == 1){
            imageview = new ImageView(image11);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 1 && y == 2){
            imageview = new ImageView(image12);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 1 && y == 3){
            imageview = new ImageView(image13);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 1  && y == 4){
            imageview = new ImageView(image14);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        
        
        else if(x == 2 && y == 1){
            imageview = new ImageView(image21);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 2 && y == 2){
            imageview = new ImageView(image22);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 2 && y == 3){
            imageview = new ImageView(image23);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 2  && y == 4){
            imageview = new ImageView(image24);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        
        
        else if(x == 3 && y == 1){
            imageview = new ImageView(image31);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 3 && y == 2){
            imageview = new ImageView(image32);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 3 && y == 3){
            imageview = new ImageView(image33);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 3  && y == 4){
            imageview = new ImageView(image34);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        
        
        else if(x == 4 && y == 1){
            imageview = new ImageView(image41);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 4 && y == 2){
            imageview = new ImageView(image42);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 4 && y == 3){
            imageview = new ImageView(image43);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 4  && y == 4){
            imageview = new ImageView(image44);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        return imageview;
    }
    public ImageView  showYellowGreen(int x, int y) throws FileNotFoundException{
        FileInputStream input11 = new FileInputStream("src\\images\\YellowGreenTile11.png");
        FileInputStream input12 = new FileInputStream("src\\images\\YellowGreenTile12.png");
        FileInputStream input13 = new FileInputStream("src\\images\\YellowGreenTile13.png");
        FileInputStream input14 = new FileInputStream("src\\images\\YellowGreenTile14.png");
        FileInputStream input21 = new FileInputStream("src\\images\\YellowGreenTile21.png");
        FileInputStream input22 = new FileInputStream("src\\images\\YellowGreenTile22.png");
        FileInputStream input23 = new FileInputStream("src\\images\\YellowGreenTile23.png");
        FileInputStream input24 = new FileInputStream("src\\images\\YellowGreenTile24.png");
        FileInputStream input31 = new FileInputStream("src\\images\\YellowGreenTile31.png");
        FileInputStream input32 = new FileInputStream("src\\images\\YellowGreenTile32.png");
        FileInputStream input33 = new FileInputStream("src\\images\\YellowGreenTile33.png");
        FileInputStream input34 = new FileInputStream("src\\images\\YellowGreenTile34.png");
        FileInputStream input41 = new FileInputStream("src\\images\\YellowGreenTile41.png");
        FileInputStream input42 = new FileInputStream("src\\images\\YellowGreenTile42.png");
        FileInputStream input43 = new FileInputStream("src\\images\\YellowGreenTile43.png");
        FileInputStream input44 = new FileInputStream("src\\images\\YellowGreenTile44.png");
        
        Image image11 = new Image(input11);
        Image image12 = new Image(input12);
        Image image13 = new Image(input13);
        Image image14 = new Image(input14);
        Image image21 = new Image(input21);
        Image image22 = new Image(input22);
        Image image23 = new Image(input23);
        Image image24 = new Image(input24);
        Image image31 = new Image(input31);
        Image image32 = new Image(input32);
        Image image33 = new Image(input33);
        Image image34 = new Image(input34);
        Image image41 = new Image(input41);
        Image image42 = new Image(input42);
        Image image43 = new Image(input43);
        Image image44 = new Image(input44);
        
        
        
        ImageView imageview = new ImageView();
        
        if(x == 1 && y == 1){
            imageview = new ImageView(image11);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 1 && y == 2){
            imageview = new ImageView(image12);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 1 && y == 3){
            imageview = new ImageView(image13);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 1  && y == 4){
            imageview = new ImageView(image14);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        
        
        else if(x == 2 && y == 1){
            imageview = new ImageView(image21);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 2 && y == 2){
            imageview = new ImageView(image22);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 2 && y == 3){
            imageview = new ImageView(image23);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 2  && y == 4){
            imageview = new ImageView(image24);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        
        
        else if(x == 3 && y == 1){
            imageview = new ImageView(image31);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 3 && y == 2){
            imageview = new ImageView(image32);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 3 && y == 3){
            imageview = new ImageView(image33);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 3  && y == 4){
            imageview = new ImageView(image34);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        
        
        else if(x == 4 && y == 1){
            imageview = new ImageView(image41);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }  
        else if(x == 4 && y == 2){
            imageview = new ImageView(image42);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 4 && y == 3){
            imageview = new ImageView(image43);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        else if(x == 4  && y == 4){
            imageview = new ImageView(image44);
            imageview.setFitHeight(35);
            imageview.setFitWidth(35);
        }
        return imageview;
    }
    
    
    
    
    public void bluePower(Button bts) throws FileNotFoundException{
        int face = 0;
        if(bts.getText().length() == 5 || bts.getText().length() == 4){
            face = Integer.parseInt(bts.getText().substring(3));
        }
        else{
            face = Integer.parseInt(bts.getText());
        }
        
        if(bts.getId().equals("rt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt2")){
            bts.setGraphic(showRed(1));
            bts.setId("rt1");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt3")){
            bts.setGraphic(showRed(2));
            bts.setId("rt2");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt4")){
            bts.setGraphic(showRed(3));
            bts.setId("rt3");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        //Eliminating green with blue
        if(bts.getId().equals("gt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt2")){
            bts.setGraphic(showGreen(1));
            bts.setId("gt1");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt3")){
            bts.setGraphic(showGreen(2));
            bts.setId("gt2");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt4")){
            bts.setGraphic(showGreen(3));
            bts.setId("gt3");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        //Eliminating yellow with blue
        if(bts.getId().equals("yt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt2")){
            bts.setGraphic(showYellow(1));
            bts.setId("yt1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt3")){
            bts.setGraphic(showYellow(2));
            bts.setId("yt2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt4")){
            bts.setGraphic(showYellow(3));
            bts.setId("yt3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        
    }
    public void bluePower2(Button bts) throws FileNotFoundException{
        int face = 0;
        if(bts.getText().length() == 5 || bts.getText().length() == 4){
            face = Integer.parseInt(bts.getText().substring(3));
        }
        else{
            face = Integer.parseInt(bts.getText());
        }
        
        //Eliminating green with blue
        if(bts.getId().equals("gt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt2")){
            bts.setGraphic(showGreen(1));
            bts.setId("gt1");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt3")){
            bts.setGraphic(showGreen(2));
            bts.setId("gt2");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt4")){
            bts.setGraphic(showGreen(3));
            bts.setId("gt3");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        //Eliminating yellow with blue
        if(bts.getId().equals("yt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt2")){
            bts.setGraphic(showYellow(1));
            bts.setId("yt1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt3")){
            bts.setGraphic(showYellow(2));
            bts.setId("yt2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt4")){
            bts.setGraphic(showYellow(3));
            bts.setId("yt3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        //blue or red eliminating opponent doubles
        else if(bts.getId().equals("y1g1")){
            bts.setGraphic(showGreen(1));
            bts.setId("gt1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y1g2")){
            bts.setGraphic(showGreen(2));
            bts.setId("gt2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y1g3")){
            bts.setGraphic(showGreen(3));
            bts.setId("gt3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y1g4")){
            bts.setGraphic(showGreen(4));
            bts.setId("gt4");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y2g1")){
            bts.setGraphic(showYellowGreen(1,1));
            bts.setId("y1g1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y2g2")){
            bts.setGraphic(showYellowGreen(1,2));
            bts.setId("y1g2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y2g3")){
            bts.setGraphic(showYellowGreen(1,3));
            bts.setId("y1g3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y2g4")){
            bts.setGraphic(showYellowGreen(1,4));
            bts.setId("y1g4");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y3g1")){
            bts.setGraphic(showYellowGreen(2,1));
            bts.setId("y2g1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y3g2")){
            bts.setGraphic(showYellowGreen(2,2));
            bts.setId("y2g2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y3g3")){
            bts.setGraphic(showYellowGreen(2,3));
            bts.setId("y2g3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y3g4")){
            bts.setGraphic(showYellowGreen(2,4));
            bts.setId("y2g4");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y4g1")){
            bts.setGraphic(showYellowGreen(3,1));
            bts.setId("y3g1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y4g2")){
            bts.setGraphic(showYellowGreen(3,2));
            bts.setId("y3g2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y4g3")){
            bts.setGraphic(showYellowGreen(3,3));
            bts.setId("y3g3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y4g4")){
            bts.setGraphic(showYellowGreen(3,4));
            bts.setId("y3g4");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        
    }
    
    
    
    
    public void greenPower(Button bts) throws FileNotFoundException{
        int face = 0;
        if(bts.getText().length() == 5 || bts.getText().length() == 4){
            face = Integer.parseInt(bts.getText().substring(3));
        }
        else{
            face = Integer.parseInt(bts.getText());
        }
        if(bts.getId().equals("bt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt2")){
            bts.setGraphic(showBlue(1));
            bts.setId("bt1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt3")){
            bts.setGraphic(showBlue(2));
            bts.setId("bt2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt4")){
            bts.setGraphic(showBlue(3));
            bts.setId("bt3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }


        //Elimanating red with green
        if(bts.getId().equals("rt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt2")){
            bts.setGraphic(showRed(1));
            bts.setId("rt1");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt3")){
            bts.setGraphic(showRed(2));
            bts.setId("rt2");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt4")){
            bts.setGraphic(showRed(3));
            bts.setId("rt3");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        //Eliminating yellow with green
        if(bts.getId().equals("yt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt2")){
            bts.setGraphic(showYellow(1));
            bts.setId("yt1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt3")){
            bts.setGraphic(showYellow(2));
            bts.setId("yt2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt4")){
            bts.setGraphic(showYellow(3));
            bts.setId("yt3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
    }
    
    public void greenPower2(Button bts) throws FileNotFoundException{
        int face = 0;
        if(bts.getText().length() == 5 || bts.getText().length() == 4){
            face = Integer.parseInt(bts.getText().substring(3));
        }
        else{
            face = Integer.parseInt(bts.getText());
        }
        if(bts.getId().equals("bt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt2")){
            bts.setGraphic(showBlue(1));
            bts.setId("bt1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt3")){
            bts.setGraphic(showBlue(2));
            bts.setId("bt2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt4")){
            bts.setGraphic(showBlue(3));
            bts.setId("bt3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }


        //Elimanating red with green
        if(bts.getId().equals("rt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt2")){
            bts.setGraphic(showRed(1));
            bts.setId("rt1");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt3")){
            bts.setGraphic(showRed(2));
            bts.setId("rt2");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt4")){
            bts.setGraphic(showRed(3));
            bts.setId("rt3");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b1r1")){
            bts.setGraphic(showRed(1));
            bts.setId("rt1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b1r2")){
            bts.setGraphic(showRed(2));
            bts.setId("rt2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b1r3")){
            bts.setGraphic(showRed(3));
            bts.setId("rt3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b1r4")){
            bts.setGraphic(showRed(4));
            bts.setId("rt4");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b2r1")){
            bts.setGraphic(showBlueRed(1,1));
            bts.setId("b1r1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b2r2")){
            bts.setGraphic(showBlueRed(1,2));
            bts.setId("b1r2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b2r3")){
            bts.setGraphic(showBlueRed(1,3));
            bts.setId("b1r3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b2r4")){
            bts.setGraphic(showBlueRed(1,4));
            bts.setId("b1r4");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b3r1")){
            bts.setGraphic(showBlueRed(2,1));
            bts.setId("b2r1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b3r2")){
            bts.setGraphic(showBlueRed(2,2));
            bts.setId("b2r2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b3r3")){
            bts.setGraphic(showBlueRed(2,3));
            bts.setId("b2r3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b3r4")){
            bts.setGraphic(showBlueRed(2,4));
            bts.setId("b2r4");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b4r1")){
            bts.setGraphic(showBlueRed(3,1));
            bts.setId("b3r1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b4r2")){
            bts.setGraphic(showBlueRed(3,2));
            bts.setId("b3r2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b4r3")){
            bts.setGraphic(showBlueRed(3,3));
            bts.setId("b3r3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b4r4")){
            bts.setGraphic(showBlueRed(3,4));
            bts.setId("b3r4");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
    }
    
    
    
    public void redPower(Button bts) throws FileNotFoundException{
        int face = 0;
        if(bts.getText().length() == 5 || bts.getText().length() == 4){
            face = Integer.parseInt(bts.getText().substring(3));
        }
        else{
            face = Integer.parseInt(bts.getText());
        }
        if(bts.getId().equals("bt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt2")){
            bts.setGraphic(showBlue(1));
            bts.setId("bt1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt3")){
            bts.setGraphic(showBlue(2));
            bts.setId("bt2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt4")){
            bts.setGraphic(showBlue(3));
            bts.setId("bt3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        //Eliminating green with red
        if(bts.getId().equals("gt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt2")){
            bts.setGraphic(showGreen(1));
            bts.setId("gt1");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt3")){
            bts.setGraphic(showGreen(2));
            bts.setId("gt2");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt4")){
            bts.setGraphic(showGreen(3));
            bts.setId("gt3");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        //Eliminating yellow with red
        if(bts.getId().equals("yt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt2")){
            bts.setGraphic(showYellow(1));
            bts.setId("yt1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt3")){
            bts.setGraphic(showYellow(2));
            bts.setId("yt2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt4")){
            bts.setGraphic(showYellow(3));
            bts.setId("yt3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        
        
    }
    public void redPower2(Button bts) throws FileNotFoundException{
        int face = 0;
        if(bts.getText().length() == 5 || bts.getText().length() == 4){
            face = Integer.parseInt(bts.getText().substring(3));
        }
        else{
            face = Integer.parseInt(bts.getText());
        }
        
        //Eliminating green with red
        if(bts.getId().equals("gt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt2")){
            bts.setGraphic(showGreen(1));
            bts.setId("gt1");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt3")){
            bts.setGraphic(showGreen(2));
            bts.setId("gt2");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt4")){
            bts.setGraphic(showGreen(3));
            bts.setId("gt3");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        //Eliminating yellow with red
        if(bts.getId().equals("yt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt2")){
            bts.setGraphic(showYellow(1));
            bts.setId("yt1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt3")){
            bts.setGraphic(showYellow(2));
            bts.setId("yt2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("yt4")){
            bts.setGraphic(showYellow(3));
            bts.setId("yt3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y1g1")){
            bts.setGraphic(showGreen(1));
            bts.setId("gt1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y1g2")){
            bts.setGraphic(showGreen(2));
            bts.setId("gt2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y1g3")){
            bts.setGraphic(showGreen(3));
            bts.setId("gt3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y1g4")){
            bts.setGraphic(showGreen(4));
            bts.setId("gt4");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y2g1")){
            bts.setGraphic(showYellowGreen(1,1));
            bts.setId("y1g1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y2g2")){
            bts.setGraphic(showYellowGreen(1,2));
            bts.setId("y1g2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y2g3")){
            bts.setGraphic(showYellowGreen(1,3));
            bts.setId("y1g3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y2g4")){
            bts.setGraphic(showYellowGreen(1,4));
            bts.setId("y1g4");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y3g1")){
            bts.setGraphic(showYellowGreen(2,1));
            bts.setId("y2g1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y3g2")){
            bts.setGraphic(showYellowGreen(2,2));
            bts.setId("y2g2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y3g3")){
            bts.setGraphic(showYellowGreen(2,3));
            bts.setId("y2g3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y3g4")){
            bts.setGraphic(showYellowGreen(2,4));
            bts.setId("y2g4");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y4g1")){
            bts.setGraphic(showYellowGreen(3,1));
            bts.setId("y3g1");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y4g2")){
            bts.setGraphic(showYellowGreen(3,2));
            bts.setId("y3g2");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y4g3")){
            bts.setGraphic(showYellowGreen(3,3));
            bts.setId("y3g3");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("y4g4")){
            bts.setGraphic(showYellowGreen(3,4));
            bts.setId("y3g4");
            for(Button bte : allYellowBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showYellow(1));
                    bte.setId("yt1");
                    break;
                }
            }
        }
    }
    
    
    
    
    
    public void yellowPower(Button bts) throws FileNotFoundException{
        int face = 0;
        if(bts.getText().length() == 5 || bts.getText().length() == 4){
            face = Integer.parseInt(bts.getText().substring(3));
        }
        else{
            face = Integer.parseInt(bts.getText());
        }
        if(bts.getId().equals("bt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt2")){
            bts.setGraphic(showBlue(1));
            bts.setId("bt1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt3")){
            bts.setGraphic(showBlue(2));
            bts.setId("bt2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt4")){
            bts.setGraphic(showBlue(3));
            bts.setId("bt3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
                //Eliminating green with yellow
        if(bts.getId().equals("gt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt2")){
            bts.setGraphic(showGreen(1));
            bts.setId("gt1");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt3")){
            bts.setGraphic(showGreen(2));
            bts.setId("gt2");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("gt4")){
            bts.setGraphic(showGreen(3));
            bts.setId("gt3");
            for(Button bte : allGreenBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showGreen(1));
                    bte.setId("gt1");
                    break;
                }
            }
        }
        //Elimanating red with yellow
        if(bts.getId().equals("rt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt2")){
            bts.setGraphic(showRed(1));
            bts.setId("rt1");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt3")){
            bts.setGraphic(showRed(2));
            bts.setId("rt2");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt4")){
            bts.setGraphic(showRed(3));
            bts.setId("rt3");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
    }
    
    public void yellowPower2(Button bts) throws FileNotFoundException{
        int face = 0;
        if(bts.getText().length() == 5 || bts.getText().length() == 4){
            face = Integer.parseInt(bts.getText().substring(3));
        }
        else{
            face = Integer.parseInt(bts.getText());
        }
        if(bts.getId().equals("bt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt2")){
            bts.setGraphic(showBlue(1));
            bts.setId("bt1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt3")){
            bts.setGraphic(showBlue(2));
            bts.setId("bt2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("bt4")){
            bts.setGraphic(showBlue(3));
            bts.setId("bt3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        
        //Elimanating red with yellow
        if(bts.getId().equals("rt1")){
            bts.setGraphic(null);
            bts.setId("0");
            bts.setDisable(false);
            boxValue[face] = 0;
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt2")){
            bts.setGraphic(showRed(1));
            bts.setId("rt1");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt3")){
            bts.setGraphic(showRed(2));
            bts.setId("rt2");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("rt4")){
            bts.setGraphic(showRed(3));
            bts.setId("rt3");
            for(Button bte : allRedBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showRed(1));
                    bte.setId("rt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b1r1")){
            bts.setGraphic(showRed(1));
            bts.setId("rt1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b1r2")){
            bts.setGraphic(showRed(2));
            bts.setId("rt2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b1r3")){
            bts.setGraphic(showRed(3));
            bts.setId("rt3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b1r4")){
            bts.setGraphic(showRed(4));
            bts.setId("rt4");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b2r1")){
            bts.setGraphic(showBlueRed(1,1));
            bts.setId("b1r1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b2r2")){
            bts.setGraphic(showBlueRed(1,2));
            bts.setId("b1r2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b2r3")){
            bts.setGraphic(showBlueRed(1,3));
            bts.setId("b1r3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b2r4")){
            bts.setGraphic(showBlueRed(1,4));
            bts.setId("b1r4");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b3r1")){
            bts.setGraphic(showBlueRed(2,1));
            bts.setId("b2r1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b3r2")){
            bts.setGraphic(showBlueRed(2,2));
            bts.setId("b2r2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b3r3")){
            bts.setGraphic(showBlueRed(2,3));
            bts.setId("b2r3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b3r4")){
            bts.setGraphic(showBlueRed(2,4));
            bts.setId("b2r4");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b4r1")){
            bts.setGraphic(showBlueRed(3,1));
            bts.setId("b3r1");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b4r2")){
            bts.setGraphic(showBlueRed(3,2));
            bts.setId("b3r2");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b4r3")){
            bts.setGraphic(showBlueRed(3,3));
            bts.setId("b3r3");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
        else if(bts.getId().equals("b4r4")){
            bts.setGraphic(showBlueRed(3,4));
            bts.setId("b3r4");
            for(Button bte : allBlueBut){
                if(bte.getId().equals("0")){
                    bte.setDisable(true);
                    bte.setGraphic(showBlue(1));
                    bte.setId("bt1");
                    break;
                }
            }
        }
    }
    
    
    public int startBlue(int number){
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a; int holdB = b;
        if (toggle == true) {
            a = a + number;
            toggle = false;
            bcheck = false ; bEnd = true;
            disableGreen();
            disableRed();
            disableYellow();
            rollBut.setDisable(true);
            if((holdA == 6 && holdB !=6) || (holdA != 6 && holdB == 6) ){
                disableHBlue();
            }
            else if(holdA != 6 && holdB !=6){
                disableHBlue();
            }
            enableBlue();
        }
        else if(toggle == false) {
            if(bn == true){
                if(b == 6){
                    b = a;
                }
                bn = false;

            }
            a = b + number;
            bcheck = true ; bEnd = false;
            toggle = true;
            rollBut.setDisable(false);
            blueDouble(holdA, holdB);
            enableBlue();
        }
        for(Button chk : allBlueBut){
            if(chk.getId() != "bt1"){
                chk.setDisable(true);
            }
        }
        enableBlue();
        return a;
    }
    public int startBlue2(int number){
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a; int holdB = b;
        if (toggle == true) {
            a = a + number;
            toggle = false;
            bcheck = false ; bEnd = true;
            disableGreen();
            disableYellow();
            rollBut.setDisable(true);
            if((holdA == 6 && holdB !=6) || (holdA != 6 && holdB == 6) ){
                disableHBlue();
                disableHRed();
            }
            else if(holdA != 6 && holdB !=6){
                disableHBlue();
                disableHRed();
            }
            enableBlue();
            enableRed();
        }
        else if(toggle == false) {
            if(bn == true){
                if(b == 6){
                    b = a;
                }
                bn = false;

            }
            a = b + number;
            bcheck = true ; bEnd = false;
            toggle = true;
            rollBut.setDisable(false);
            if(holdA == 6 && holdB == 6){
                if(blueCont == true || redCont == true){
                    first = true;
                    second = true;
                    third = false;
                    fourth = false;
                }
                else if(yellowCont == true || greenCont == true){
                    first = false;
                    second = false;
                    third = true;
                    fourth = true;
                }
                else{
                    note.setText("PLAYER TWO WIN");
                    gameOver();
                }
            }
            else{
              if(yellowCont == true || greenCont == true){
                    first = false;
                    second = false;
                    third = true;
                    fourth = true;
                }
                else{
                    note.setText("PLAYER TWO WIN");
                    gameOver();
                }

            }
            enableBlue();
            enableRed();
        }
        for(Button chk : allBlueBut){
            if(chk.getId() != "bt1"){
                chk.setDisable(true);
            }
        }
        for(Button chk : allRedBut){
            if(chk.getId() != "rt1"){
                chk.setDisable(true);
            }
        }
        enableBlue();
        enableRed();
        return a;
    }
    
    
    
    public int startRed(int number){
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a; int holdB = b;
        if (toggle == true) {
            a = a + number;
            rcheck = false ; rEnd = true;
            toggle = false;
            disableGreen();
            disableBlue();
            disableYellow();
            enableRed();
            rollBut.setDisable(true);
            if((holdA == 6 && b !=6) || (holdA != 6 && b == 6) ){
                disableHRed();
            }
            else if(holdA != 6 && b !=6){
                disableHRed();
            }
            enableRed();
        }
        else if(toggle == false) {
            if(bn == true){
                if(b == 6){
                    b = a;
                }
                bn = false;
            }
            a = b + number;
            rcheck = true ; rEnd = false;
            toggle = true;
            rollBut.setDisable(false);
            redDouble(holdA, holdB);
            enableRed();
        }
        for(Button chk : allRedBut){
            if(chk.getId() != "rt1"){
                chk.setDisable(true);
            }
        }
        enableRed();
        return a;
    
    }
    public int startRed2(int number){
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a;
        if (toggle == true) {
            a = a + number;
            bcheck = false ; bEnd = true;
            toggle = false;
            disableGreen();
            disableYellow();
            enableRed();
            enableBlue();
            rollBut.setDisable(true);
            if((holdA == 6 && b !=6) || (holdA != 6 && b == 6) ){
                disableHRed();
                disableHBlue();
            }
            else if(holdA != 6 && b !=6){
                disableHRed();
                disableHBlue();
            }
            enableRed();
            enableBlue();
        }
        else if(toggle == false) {
            if(bn == true){
                if(b == 6){
                    b = a;
                }
                bn = false;
            }
            a = b + number;
            bcheck = true ; bEnd = false;
            toggle = true;
            rollBut.setDisable(false);
            
            if(holdA == 6 && b == 6){
                if(blueCont == true || redCont == true){
                    first = true;
                    second = true;
                    third = false;
                    fourth = false;
                }
                else if(yellowCont == true || greenCont == true){
                    first = false;
                    second = false;
                    third = true;
                    fourth = true;
                }
                else{
                    note.setText("PLAYER TWO WIN");
                    gameOver();
                }
            }
            enableRed();
            enableBlue();
        }
        for(Button chk : allRedBut){
            if(chk.getId() != "rt1"){
                chk.setDisable(true);
            }
        }
        for(Button chk : allBlueBut){
            if(chk.getId() != "bt1"){
                chk.setDisable(true);
            }
        }
        enableRed();
        enableBlue();
        return a;
    }
    
    
    
    public int startYellow(int number){
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a; int holdB = b;
        if (toggle == true) {
            a = a + number;
            ycheck = false; yEnd = true;
            toggle = false;
            disableGreen();
            disableRed();
            disableBlue();
            enableYellow();
            rollBut.setDisable(true);
            if((holdA == 6 && b != 6) || (holdA != 6 && b == 6) ){
                disableHYellow();
            }
            else if(holdA != 6 && b != 6){
                disableHYellow();
            }
            enableYellow();
        }
        else if(toggle == false) {
            if(bn == true){
                if(b == 6){
                    b = a;
                }
                bn = false;
            }
            a = b + number;
            ycheck = true; yEnd = false;
            toggle = true;
            rollBut.setDisable(false);
            yellowDouble(holdA, holdB);
            enableYellow();
        }
        for(Button chk : allYellowBut){
            if(chk.getId() != "yt1"){
                chk.setDisable(true);
            }
        }
        enableYellow();
        return a;
    }
    
    public int startYellow2(int number){
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a;
        if (toggle == true) {
            a = a + number;
            toggle = false;
            ycheck = false; yEnd = true;
            enableGreen();
            disableRed();
            disableBlue();
            enableYellow();
            rollBut.setDisable(true);
            if((holdA == 6 && b != 6) || (holdA != 6 && b == 6) ){
                disableHYellow();
                disableHGreen();
            }
            else if(holdA != 6 && b != 6){
                disableHYellow();
                disableHGreen();
            }
            enableYellow();
            enableGreen();
            
        }
        else if(toggle == false) {
            if(bn == true){
                if(b == 6){
                    b = holdA;
                }
                bn = false;
            }
            a = b + number;
            ycheck = true; yEnd = false;
            toggle = true;
            rollBut.setDisable(false);
            if(holdA == 6 && b == 6){
                first = false;
                second = false;
                third = true;
                fourth = true;
                disableHYellow();
                disableHGreen();
            }
            else{
                first = true;
                second = true;
                third = false;
                fourth = false;
                disableHYellow();
                disableHGreen();
            }
            enableYellow();
            enableGreen();
        }
        
        for(Button chk : allYellowBut){
            if(chk.getId() != "yt1"){
                chk.setDisable(true);
            }
        }
        for(Button chk : allGreenBut){
            if(chk.getId() != "gt1"){
                chk.setDisable(true);
            }
        }
        enableYellow();
        enableGreen();
        return a;
    }
    
    
    
    
    public int startGreen(int number){
        int a = Integer.valueOf(rollSpace1.getText());
        int b = Integer.valueOf(rollSpace2.getText());
        int holdA = a; int holdB = b;
        if (toggle == true) {
            a = a + number;
            gcheck = false; gEnd = true;
            toggle = false;
            disableBlue();
            disableRed();
            disableYellow();
            enableGreen();
            rollBut.setDisable(true);
            if((holdA == 6 && b != 6) || (holdA != 6 && b == 6) ){
                disableHGreen();
            }
            else if(holdA != 6 && b !=6){
                disableHGreen();
            }
            enableGreen();
        }
        else if(toggle == false) {
            if(bn == true){
                if(b == 6){
                    b = a;
                }
                bn = false;
            }
            a = b + number;
            gcheck = true; gEnd = false;
            toggle = true;
            rollBut.setDisable(false);
            greenDouble(holdA, holdB);
            enableGreen();
        }
        for(Button chk : allGreenBut){
            if(chk.getId() != "gt1"){
                chk.setDisable(true);
            }
        }
        enableGreen();
        return a;
    }
    
    
    public void autoBlue() throws FileNotFoundException{
        try {
            int a = Integer.valueOf(rollSpace1.getText());
            int b = Integer.valueOf(rollSpace2.getText());
            int holdA = a;
            if(holdA == 6 && b != 6){
                a = b + 1;
            }
            else if(holdA != 6 && b == 6){
                a = a + 1;
            }
            for (Button bts : BlueRoad) {
                
                int face = 0;
                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                    face = Integer.parseInt(bts.getText().substring(3));
                }
                else{
                    face = Integer.parseInt(bts.getText());
                }
                        
                if (face == a) {
                    
                    if(bts.getId().equals("0")){
                        bts.setGraphic(showBlue(1));
                        bts.setId("bt1");
                        bts.setDisable(true);
                        break;
                    }
                    else{
                        showBprogress();
                        //Eliminating red with blue
                        if(bts.getId().equals("rt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allRedBut){
                                if(bte.getGraphic()== null){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt2")){
                            bts.setGraphic(showRed(1));
                            bts.setId("rt1");
                            for(Button bte : allRedBut){
                                if(bte.getGraphic()== null){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }

                            break;
                        }
                        else if(bts.getId().equals("rt3")){
                            bts.setGraphic(showRed(2));
                            bts.setId("rt2");
                            for(Button bte : allRedBut){
                                if(bte.getGraphic()== null){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt4")){
                            bts.setGraphic(showRed(3));
                            bts.setId("rt3");
                            for(Button bte : allRedBut){
                                if(bte.getGraphic()== null){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        //Eliminating green with blue
                        if(bts.getId().equals("gt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt2")){
                            bts.setGraphic(showGreen(1));
                            bts.setId("gt1");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt3")){
                            bts.setGraphic(showGreen(2));
                            bts.setId("gt2");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt4")){
                            bts.setGraphic(showGreen(3));
                            bts.setId("gt3");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        //Eliminating yellow with blue
                        if(bts.getId().equals("yt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt2")){
                            bts.setGraphic(showYellow(1));
                            bts.setId("gt1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt3")){
                            bts.setGraphic(showYellow(2));
                            bts.setId("yt2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt4")){
                            bts.setGraphic(showYellow(3));
                            bts.setId("yt3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                    }    
                }
            }
        }catch (NumberFormatException nfe) {
        }
    }
    
    public void autoRed() throws FileNotFoundException{
        try {
            int a = Integer.valueOf(rollSpace1.getText());
            int b = Integer.valueOf(rollSpace2.getText());
            int holdA = a;
            if(holdA == 6 && b != 6){
                a = b + 14; 
            }
            else if(holdA != 6 && b == 6){
                a = a + 14;
            }
            for (Button bts : RedRoad) {
                int face = 0;
                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                    face = Integer.parseInt(bts.getText().substring(3));
                }
                else{
                    face = Integer.parseInt(bts.getText());
                }
                        
                if (face == a) {

                    if(bts.getId().equals("0")){
                        bts.setGraphic(showRed(1));
                        bts.setId("rt1");
                        bts.setDisable(true);
                        break;
                    }
                    else{
                        showRprogress();
                    //Eliminating blue with red
                        if(bts.getId().equals("bt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("bt2")){
                            bts.setGraphic(showBlue(1));
                            bts.setId("bt1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }

                            break;
                        }
                        else if(bts.getId().equals("bt3")){
                            bts.setGraphic(showBlue(2));
                            bts.setId("bt2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;   
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("bt4")){
                            bts.setGraphic(showBlue(3));
                            bts.setId("bt3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        //Eliminating green with red
                        if(bts.getId().equals("gt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt2")){
                            bts.setGraphic(showGreen(1));
                            bts.setId("gt1");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt3")){
                            bts.setGraphic(showGreen(2));
                            bts.setId("gt2");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt4")){
                            bts.setGraphic(showGreen(3));
                            bts.setId("gt3");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        //Eliminating yellow with red
                        if(bts.getId().equals("yt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt2")){
                            bts.setGraphic(showYellow(1));
                            bts.setId("yt1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt3")){
                            bts.setGraphic(showYellow(2));
                            bts.setId("yt2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt4")){
                            bts.setGraphic(showYellow(3));
                            bts.setId("yt3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                    }    
                }
            }
        } catch (NumberFormatException nfe) {
        }
    }
    public void autoGreen() throws FileNotFoundException{
        try {
            int a = Integer.valueOf(rollSpace1.getText());
            int b = Integer.valueOf(rollSpace2.getText());
            int holdA = a;
            if(holdA == 6 && b != 6){
                a = b + 27;
            }
            else if(holdA != 6 && b == 6){
                a = a + 27;
            }
            for (Button bts : GreenRoad) {

                int face = 0;
                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                    face = Integer.parseInt(bts.getText().substring(3));
                }
                else{
                    face = Integer.parseInt(bts.getText());
                }
                        
                if (face == a) {

                    if(bts.getId().equals("0")){
                        bts.setGraphic(showGreen(1));
                        bts.setId("gt1");
                        bts.setDisable(true);
                        break;
                    }
                    else{
                        showGprogress();
                        if(bts.getId().equals("bt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("bt2")){
                            bts.setGraphic(showBlue(1));
                            bts.setId("bt1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }

                            break;
                        }
                        else if(bts.getId().equals("bt3")){
                            bts.setGraphic(showBlue(2));
                            bts.setId("bt2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("bt4")){
                            bts.setGraphic(showBlue(3));
                            bts.setId("bt3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }


                        //Elimanating red with green
                        if(bts.getId().equals("rt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt2")){
                            bts.setGraphic(showRed(1));
                            bts.setId("rt1");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt3")){
                            bts.setGraphic(showRed(2));
                            bts.setId("rt2");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt4")){
                            bts.setGraphic(showRed(3));
                            bts.setId("rt3");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        //Eliminating yellow with green
                        if(bts.getId().equals("yt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt2")){
                            bts.setGraphic(showYellow(1));
                            bts.setId("yt1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt3")){
                            bts.setGraphic(showYellow(2));
                            bts.setId("yt2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt4")){
                            bts.setGraphic(showYellow(3));
                            bts.setId("yt3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        } catch (NumberFormatException nfe) {
        }   
        
    }
    public void autoYellow() throws FileNotFoundException{
        
        try {
            int a = Integer.valueOf(rollSpace1.getText());
            int b = Integer.valueOf(rollSpace2.getText());
            int holdA = a;
            if(holdA == 6 && b != 6){
                a = b + 40;
            }
            else if(holdA != 6 && b == 6){
                a = a + 40;
            }
            for (Button bts : YellowRoad) {

                int face = 0;
                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                    face = Integer.parseInt(bts.getText().substring(3));
                }
                else{
                    face = Integer.parseInt(bts.getText());
                }
                        
                if (face == a) {

                    if(bts.getId().equals("0")){
                        bts.setGraphic(showYellow(1));
                        bts.setId("yt1");
                        bts.setDisable(true);
                        break;
                    }
                    else{
                        showYprogress();
                        //Eliminating blue with yellow
                        if(bts.getId().equals("bt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("bt2")){
                            bts.setGraphic(showBlue(1));
                            bts.setId("bt1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }

                            break;
                        }
                        else if(bts.getId().equals("bt3")){
                            bts.setGraphic(showBlue(2));
                            bts.setId("bt2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("bt4")){
                            bts.setGraphic(showBlue(3));
                            bts.setId("bt3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                                //Eliminating green with yellow
                        if(bts.getId().equals("gt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt2")){
                            bts.setGraphic(showGreen(1));
                            bts.setId("gt1");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt3")){
                            bts.setGraphic(showGreen(2));
                            bts.setId("gt2");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt4")){
                            bts.setGraphic(showGreen(3));
                            bts.setId("gt3");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        //Elimanating red with yellow
                        if(bts.getId().equals("rt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt2")){
                            bts.setGraphic(showRed(1));
                            bts.setId("rt1");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }

                            break;
                        }
                        else if(bts.getId().equals("rt3")){
                            bts.setGraphic(showRed(2));
                            bts.setId("rt2");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt4")){
                            bts.setGraphic(showRed(3));
                            bts.setId("rt3");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        } catch (NumberFormatException nfe) {
        }
    }
    public void showBprogress() throws FileNotFoundException{
        if(playerNumber == 2){
           if(bcheck == true){
               disableBlue();disableRed();
           }
        }
        else{
           if(bcheck == true){
               disableBlue();
           } 
        }
        switch (playerOne.getId()) {
            case "bt1":
                playerOne.setGraphic(showBlue(2));
                playerOne.setId("bt2");
                break;
            case "bt2":
                playerOne.setGraphic(showBlue(3));
                playerOne.setId("bt3");
                break;
            case "bt3":
                playerOne.setGraphic(showBlue(4));
                playerOne.setId("bt4");
                note.setText("PLAYER BLUE WIN");
                blueCont = false;
                winner++;
                if(playerNumber == 4 || playerNumber == 3){
                    showWinner(1);
                    winner = 2;
                    
                }
                else{
                    if(redCont == false){
                        winner = 2;
                        showWinner(1);
                        note.setText("GAME OVER");
                        gameOver();
                    }
                }
                break;
            case "0":
                playerOne.setGraphic(showBlue(1));
                playerOne.setId("bt1");
                break;
            default:
                break;
        }
    }
    public void showRprogress() throws FileNotFoundException{
        if(playerNumber == 2){
           if(bcheck == true){
               disableBlue();disableRed();
           }
        }
        else{
           if(rcheck == true){
               disableRed();
           } 
        }
        switch (playerTwo.getId()) {
            case "rt1":
                playerTwo.setGraphic(showRed(2));
                playerTwo.setId("rt2");
                break;
            case "rt2":
                playerTwo.setGraphic(showRed(3));
                playerTwo.setId("rt3");
                break;
            case "rt3":
                playerTwo.setGraphic(showRed(4));
                playerTwo.setId("rt4");
                note.setText("PLAYER RED WIN");
                redCont = false;
                winner++;
                if(playerNumber == 4 || playerNumber == 3){
                    showWinner(2);
                    winner = 2;
                }
                else{
                    if(blueCont == false){
                        winner = 2;
                        showWinner(1);
                        winner = 4;
                        note.setText("GAME OVER");
                        gameOver();
                    }
                }
                break;
            case "0":
                playerTwo.setGraphic(showRed(1));
                playerTwo.setId("rt1");
                break;
            default:
                break;
        }
    }
    public void showYprogress() throws FileNotFoundException{
        if(playerNumber == 2){
           if(ycheck == true){
               disableYellow();disableGreen();
           }
        }
        else{
           if(ycheck == true){
               disableYellow();
           } 
        }
        switch (playerThree.getId()) {
            case "yt1":
                playerThree.setGraphic(showYellow(2));
                playerThree.setId("yt2");
                break;
            case "yt2":
                playerThree.setGraphic(showYellow(3));
                playerThree.setId("yt3");
                break;
            case "yt3":
                playerThree.setGraphic(showYellow(4));
                playerThree.setId("yt4");
                note.setText("PLAYER YELLOW WIN");
                yellowCont = false;
                winner++;
                if(playerNumber == 4 || playerNumber == 3){
                    showWinner(3);
                    winner = 4;
                }
                else{
                    if(greenCont == false){
                        winner = 2;
                        showWinner(2);
                        note.setText("GAME OVER");
                        gameOver();
                    }
                }
                break;
            case "0":
                playerThree.setGraphic(showYellow(1));
                playerThree.setId("yt1");
                break;
            default:
                break;
        }
    }
    public void showGprogress() throws FileNotFoundException{
        if(playerNumber == 2){
           if(ycheck == true){
               disableYellow();disableGreen();
           }
        }
        else{
           if(gcheck == true){
               disableGreen();
           } 
        }
        switch (playerFour.getId()) {
            case "gt1":
                playerFour.setGraphic(showGreen(2));
                playerFour.setId("gt2");
                break;
            case "gt2":
                playerFour.setGraphic(showGreen(3));
                playerFour.setId("gt3");
                break;
            case "gt3":
                playerFour.setGraphic(showGreen(4));
                playerFour.setId("gt4");
                note.setText("PLAYER GREEN WIN");
                greenCont = false;
                winner++;
                if(playerNumber == 4 || playerNumber == 3){
                    
                    showWinner(4);
                    winner = 3;
                }
                else{
                    if(yellowCont == false){
                        winner = 2;
                        showWinner(2);
                        note.setText("GAME OVER");
                        gameOver();
                    }
                }
                break;
            case "0":
                playerFour.setGraphic(showGreen(1));
                playerFour.setId("gt1");
                break;
            default:
                break;
        }
    }
    
    
    
    
    public void autoBlue2() throws FileNotFoundException{
        try {
            int a = Integer.valueOf(rollSpace1.getText());
            int b = Integer.valueOf(rollSpace2.getText());
            int holdA = a;
            if(holdA == 6 && b != 6){
                a = b + 1;
            }
            else if(holdA != 6 && b == 6){
                a = a + 1;
            }
            for (Button bts : BlueRoad) {

                int face = 0;
                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                    face = Integer.parseInt(bts.getText().substring(3));
                }
                else{
                    face = Integer.parseInt(bts.getText());
                }
                        
                if (face == a) {
                    
                    if(bts.getId().equals("0")){
                        bts.setGraphic(showBlue(1));
                        bts.setId("bt1");
                        bts.setDisable(true);
                        break;
                    }
                    else{
                        showBprogress();
                        
                        //Eliminating green with blue
                        if(bts.getId().equals("gt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt2")){
                            bts.setGraphic(showGreen(1));
                            bts.setId("gt1");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt3")){
                            bts.setGraphic(showGreen(2));
                            bts.setId("gt2");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt4")){
                            bts.setGraphic(showGreen(3));
                            bts.setId("gt3");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        //Eliminating yellow with blue
                        if(bts.getId().equals("yt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt2")){
                            bts.setGraphic(showYellow(1));
                            bts.setId("yt1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt3")){
                            bts.setGraphic(showYellow(2));
                            bts.setId("yt2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt4")){
                            bts.setGraphic(showYellow(3));
                            bts.setId("yt3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        //blue or red eliminating opponent doubles
                        else if(bts.getId().equals("y1g1")){
                            bts.setGraphic(showGreen(1));
                            bts.setId("gt1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y1g2")){
                            bts.setGraphic(showGreen(2));
                            bts.setId("gt2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y1g3")){
                            bts.setGraphic(showGreen(3));
                            bts.setId("gt3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y1g4")){
                            bts.setGraphic(showGreen(4));
                            bts.setId("gt4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g1")){
                            bts.setGraphic(showYellowGreen(1,1));
                            bts.setId("y1g1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g2")){
                            bts.setGraphic(showYellowGreen(1,2));
                            bts.setId("y1g2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g3")){
                            bts.setGraphic(showYellowGreen(1,3));
                            bts.setId("y1g3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g4")){
                            bts.setGraphic(showYellowGreen(1,4));
                            bts.setId("y1g4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g1")){
                            bts.setGraphic(showYellowGreen(2,1));
                            bts.setId("y2g1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g2")){
                            bts.setGraphic(showYellowGreen(2,2));
                            bts.setId("y2g2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g3")){
                            bts.setGraphic(showYellowGreen(2,3));
                            bts.setId("y2g3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g4")){
                            bts.setGraphic(showYellowGreen(2,4));
                            bts.setId("y2g4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g1")){
                            bts.setGraphic(showYellowGreen(3,1));
                            bts.setId("y3g1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g2")){
                            bts.setGraphic(showYellowGreen(3,2));
                            bts.setId("y3g2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g3")){
                            bts.setGraphic(showYellowGreen(3,3));
                            bts.setId("y3g3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g4")){
                            bts.setGraphic(showYellowGreen(3,4));
                            bts.setId("y3g4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                    }    
                }
            }
        }catch (NumberFormatException nfe) {
        }
    }
    
    public void autoRed2() throws FileNotFoundException{
        try {
            int a = Integer.valueOf(rollSpace1.getText());
            int b = Integer.valueOf(rollSpace2.getText());
            int holdA = a;
            if(holdA == 6 && b != 6){
                a = b + 14;
            }
            else if(holdA != 6 && b == 6){
                a = a + 14;
            }
            for (Button bts : RedRoad) {
                int face = 0;
                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                    face = Integer.parseInt(bts.getText().substring(3));
                }
                else{
                    face = Integer.parseInt(bts.getText());
                }
                        
                if (face == a) {

                    if(bts.getId().equals("0")){
                        bts.setGraphic(showRed(1));
                        bts.setId("rt1");
                        bts.setDisable(true);
                        break;
                    }
                    else{
                        showRprogress();
                        //Eliminating green with red
                        if(bts.getId().equals("gt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt2")){
                            bts.setGraphic(showGreen(1));
                            bts.setId("gt1");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt3")){
                            bts.setGraphic(showGreen(2));
                            bts.setId("gt2");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("gt4")){
                            bts.setGraphic(showGreen(3));
                            bts.setId("gt3");
                            for(Button bte : allGreenBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("gt1");
                                    break;
                                }
                            }
                            break;
                        }
                        //Eliminating yellow with red
                        if(bts.getId().equals("yt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt2")){
                            bts.setGraphic(showYellow(1));
                            bts.setId("yt1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt3")){
                            bts.setGraphic(showYellow(2));
                            bts.setId("yt2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("yt4")){
                            bts.setGraphic(showYellow(3));
                            bts.setId("yt3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        //blue or red eliminating opponent doubles
                        else if(bts.getId().equals("y1g1")){
                            bts.setGraphic(showGreen(1));
                            bts.setId("gt1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y1g2")){
                            bts.setGraphic(showGreen(2));
                            bts.setId("gt2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y1g3")){
                            bts.setGraphic(showGreen(3));
                            bts.setId("gt3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y1g4")){
                            bts.setGraphic(showGreen(4));
                            bts.setId("gt4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g1")){
                            bts.setGraphic(showYellowGreen(1,1));
                            bts.setId("y1g1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g2")){
                            bts.setGraphic(showYellowGreen(1,2));
                            bts.setId("y1g2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g3")){
                            bts.setGraphic(showYellowGreen(1,3));
                            bts.setId("y1g3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g4")){
                            bts.setGraphic(showYellowGreen(1,4));
                            bts.setId("y1g4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g1")){
                            bts.setGraphic(showYellowGreen(2,1));
                            bts.setId("y2g1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g2")){
                            bts.setGraphic(showYellowGreen(2,2));
                            bts.setId("y2g2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g3")){
                            bts.setGraphic(showYellowGreen(2,3));
                            bts.setId("y2g3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g4")){
                            bts.setGraphic(showYellowGreen(2,4));
                            bts.setId("y2g4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g1")){
                            bts.setGraphic(showYellowGreen(3,1));
                            bts.setId("y3g1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g2")){
                            bts.setGraphic(showYellowGreen(3,2));
                            bts.setId("y3g2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g3")){
                            bts.setGraphic(showYellowGreen(3,3));
                            bts.setId("y3g3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g4")){
                            bts.setGraphic(showYellowGreen(3,4));
                            bts.setId("y3g4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                    }    
                }
            }
        } catch (NumberFormatException nfe) {
        }
    }
    public void autoGreen2() throws FileNotFoundException{
        try {
            int a = Integer.valueOf(rollSpace1.getText());
            int b = Integer.valueOf(rollSpace2.getText());
            int holdA = a;
            if(holdA == 6 && b != 6){
                a = b + 27;
            }
            else if(holdA != 6 && b == 6){
                a = a + 27;
            }
            for (Button bts : GreenRoad) {

                int face = 0;
                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                    face = Integer.parseInt(bts.getText().substring(3));
                }
                else{
                    face = Integer.parseInt(bts.getText());
                }
                        
                if (face == a) {

                    if(bts.getId().equals("0")){
                        bts.setGraphic(showGreen(1));
                        bts.setId("gt1");
                        bts.setDisable(true);
                        break;
                    }
                    else{
                        showGprogress();
                        if(bts.getId().equals("bt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("bt2")){
                            bts.setGraphic(showBlue(1));
                            bts.setId("bt1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }

                            break;
                        }
                        else if(bts.getId().equals("bt3")){
                            bts.setGraphic(showBlue(2));
                            bts.setId("bt2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("bt4")){
                            bts.setGraphic(showBlue(3));
                            bts.setId("bt3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }


                        //Elimanating red with green
                        if(bts.getId().equals("rt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt2")){
                            bts.setGraphic(showRed(1));
                            bts.setId("rt1");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt3")){
                            bts.setGraphic(showRed(2));
                            bts.setId("rt2");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt4")){
                            bts.setGraphic(showRed(3));
                            bts.setId("rt3");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b1r1")){
                            bts.setGraphic(showRed(1));
                            bts.setId("rt1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b1r2")){
                            bts.setGraphic(showRed(2));
                            bts.setId("rt2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b1r3")){
                            bts.setGraphic(showRed(3));
                            bts.setId("rt3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b1r4")){
                            bts.setGraphic(showRed(4));
                            bts.setId("rt4");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b2r1")){
                            bts.setGraphic(showBlueRed(1,1));
                            bts.setId("b1r1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b2r2")){
                            bts.setGraphic(showBlueRed(1,2));
                            bts.setId("b1r2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b2r3")){
                            bts.setGraphic(showBlueRed(1,3));
                            bts.setId("b1r3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b2r4")){
                            bts.setGraphic(showBlueRed(1,4));
                            bts.setId("b1r4");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b3r1")){
                            bts.setGraphic(showBlueRed(2,1));
                            bts.setId("b2r1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b3r2")){
                            bts.setGraphic(showBlueRed(2,2));
                            bts.setId("b2r2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b3r3")){
                            bts.setGraphic(showBlueRed(2,3));
                            bts.setId("b2r3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b3r4")){
                            bts.setGraphic(showBlueRed(2,4));
                            bts.setId("b2r4");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b4r1")){
                            bts.setGraphic(showBlueRed(3,1));
                            bts.setId("b3r1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b4r2")){
                            bts.setGraphic(showBlueRed(3,2));
                            bts.setId("b3r2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b4r3")){
                            bts.setGraphic(showBlueRed(3,3));
                            bts.setId("b3r3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b4r4")){
                            bts.setGraphic(showBlueRed(3,4));
                            bts.setId("b3r4");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        } catch (NumberFormatException nfe) {
        }   
        
    }
    public void autoYellow2() throws FileNotFoundException{
        
        try {
            int a = Integer.valueOf(rollSpace1.getText());
            int b = Integer.valueOf(rollSpace2.getText());
            int holdA = a;
            if(holdA == 6 && b != 6){
                a = b + 40;
            }
            else if(holdA != 6 && b == 6){
                a = a + 40;
            }
            for (Button bts : YellowRoad) {

                int face = 0;
                if(bts.getText().length() == 5 || bts.getText().length() == 4){
                    face = Integer.parseInt(bts.getText().substring(3));
                }
                else{
                    face = Integer.parseInt(bts.getText());
                }
                        
                if (face == a) {

                    if(bts.getId().equals("0")){
                        bts.setGraphic(showYellow(1));
                        bts.setId("yt1");
                        bts.setDisable(true);
                        break;
                    }
                    
                    
                    else{
                        showYprogress();
                        //Eliminating blue with yellow
                        if(bts.getId().equals("bt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("bt2")){
                            bts.setGraphic(showBlue(1));
                            bts.setId("bt1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }

                            break;
                        }
                        else if(bts.getId().equals("bt3")){
                            bts.setGraphic(showBlue(2));
                            bts.setId("bt2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("bt4")){
                            bts.setGraphic(showBlue(3));
                            bts.setId("bt3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        
                        //Elimanating red with yellow
                        if(bts.getId().equals("rt1")){
                            bts.setGraphic(null);
                            bts.setId("0");
                            bts.setDisable(false);
                            boxValue[face] = 0;
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt2")){
                            bts.setGraphic(showRed(1));
                            bts.setId("rt1");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }

                            break;
                        }
                        else if(bts.getId().equals("rt3")){
                            bts.setGraphic(showRed(2));
                            bts.setId("rt2");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("rt4")){
                            bts.setGraphic(showRed(3));
                            bts.setId("rt3");
                            for(Button bte : allRedBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showRed(1));
                                    bte.setId("rt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b1r1")){
                            bts.setGraphic(showRed(1));
                            bts.setId("rt1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b1r2")){
                            bts.setGraphic(showRed(2));
                            bts.setId("rt2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b1r3")){
                            bts.setGraphic(showRed(3));
                            bts.setId("rt3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b1r4")){
                            bts.setGraphic(showRed(4));
                            bts.setId("rt4");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b2r1")){
                            bts.setGraphic(showBlueRed(1,1));
                            bts.setId("b1r1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b2r2")){
                            bts.setGraphic(showBlueRed(1,2));
                            bts.setId("b1r2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b2r3")){
                            bts.setGraphic(showBlueRed(1,3));
                            bts.setId("b1r3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b2r4")){
                            bts.setGraphic(showBlueRed(1,4));
                            bts.setId("b1r4");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b3r1")){
                            bts.setGraphic(showBlueRed(2,1));
                            bts.setId("b2r1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b3r2")){
                            bts.setGraphic(showBlueRed(2,2));
                            bts.setId("b2r2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b3r3")){
                            bts.setGraphic(showBlueRed(2,3));
                            bts.setId("b2r3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b3r4")){
                            bts.setGraphic(showBlueRed(2,4));
                            bts.setId("b2r4");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b4r1")){
                            bts.setGraphic(showBlueRed(3,1));
                            bts.setId("b3r1");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b4r2")){
                            bts.setGraphic(showBlueRed(3,2));
                            bts.setId("b3r2");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b4r3")){
                            bts.setGraphic(showBlueRed(3,3));
                            bts.setId("b3r3");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("b4r4")){
                            bts.setGraphic(showBlueRed(3,4));
                            bts.setId("b3r4");
                            for(Button bte : allBlueBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showBlue(1));
                                    bte.setId("bt1");
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        } catch (NumberFormatException nfe) {
        }
    }
    
    public void blueInit(Button bt, int number) throws FileNotFoundException{
        
                    
        if(bt.getId().equals("bt4")){
            bt.setId("bt3");
            bt.setGraphic(showBlue(3));
        }
        else if(bt.getId().equals("bt3")){
            bt.setId("bt2");
            bt.setGraphic(showBlue(2));
        }
        else if(bt.getId().equals("bt2")){
            bt.setId("bt1");
            bt.setGraphic(showBlue(1));
        }

        else if(bt.getId().equals("bt1")) {
            bt.setId("0");
            bt.setGraphic(null);    
        }


        else if(bt.getId().equals("b1r1")){
            bt.setGraphic(showRed(1));
            bt.setId("rt1");

        }
        else if(bt.getId().equals("b2r1")){
            bt.setGraphic(showBlueRed(1,1));
            bt.setId("b1r1");
            boxValue[number] = 1;

        }
        else if(bt.getId().equals("b3r1")){
            bt.setGraphic(showBlueRed(2,1));
            bt.setId("b2r1");
            boxValue[number] = 1;

        }

        else if(bt.getId().equals("b4r1")){
            bt.setGraphic(showBlueRed(3,1));
            bt.setId("b3r1");
            boxValue[number] = 1;

        }
        else if(bt.getId().equals("b1r2")){
            bt.setGraphic(showRed(2));
            bt.setId("rt2");
            boxValue[number] = 1;

        }
        else if(bt.getId().equals("b2r2")){
            bt.setGraphic(showBlueRed(1,2));
            bt.setId("b1r2");
            boxValue[number] = 1;

        }

        else if(bt.getId().equals("b3r2")){
            bt.setGraphic(showBlueRed(2,2));
            bt.setId("b2r2");
            boxValue[number] = 1;

        }
        else if(bt.getId().equals("b4r2")){
            bt.setGraphic(showBlueRed(3,2));
            bt.setId("b3r2");
            boxValue[number] = 1;

        }
        else if(bt.getId().equals("b1r3")){
            bt.setGraphic(showRed(3));
            bt.setId("rt3");
            boxValue[number] = 1;

        }

        else if(bt.getId().equals("b2r3")){
            bt.setGraphic(showBlueRed(1,3));
            bt.setId("b1r3");
            boxValue[number] = 1;

        }
        else if(bt.getId().equals("b3r3")){
            bt.setGraphic(showBlueRed(2,3));
            bt.setId("b2r3");
            boxValue[number] = 1;

        }
        else if(bt.getId().equals("b4r3")){
            bt.setGraphic(showBlueRed(3,3));
            bt.setId("b3r3");
            boxValue[number] = 1;

        }
        else if(bt.getId().equals("b1r4")){
            bt.setGraphic(showRed(4));
            bt.setId("rt4");
            boxValue[number] = 1;

        }

        else if(bt.getId().equals("b2r4")){
            bt.setGraphic(showBlueRed(1,4));
            bt.setId("b1r4");
            boxValue[number] = 1;

        }
        else if(bt.getId().equals("b3r4")){
            bt.setGraphic(showBlueRed(2,4));
            bt.setId("b2r4");
            boxValue[number] = 1;

        }
        else if(bt.getId().equals("b4r4")){
            bt.setGraphic(showBlueRed(3,4));
            bt.setId("b3r4");
            boxValue[number] = 1;
        }
    }
    
    public void yellowInit(Button bt) throws FileNotFoundException{
        if(bt.getId().equals("yt4")){
            bt.setId("yt3");
            bt.setGraphic(showYellow(3));
        }
        else if(bt.getId().equals("yt3")){
            bt.setId("yt2");
            bt.setGraphic(showYellow(2));
        }
        else if(bt.getId().equals("yt2")){
            bt.setId("yt1");
            bt.setGraphic(showYellow(1));
        }

        else if(bt.getId().equals("yt1")) {
            bt.setId("0");
            bt.setGraphic(null);    
        }
        else if(bt.getId().equals("y1g1")){
            bt.setGraphic(showGreen(1));
            bt.setId("gt1");
        }
        else if(bt.getId().equals("y2g1")){
            bt.setGraphic(showYellowGreen(1,1));
            bt.setId("y1g1");
        }
        else if(bt.getId().equals("y3g1")){
            bt.setGraphic(showYellowGreen(2,1));
            bt.setId("y2g1");
        }
        else if(bt.getId().equals("y4g1")){
            bt.setGraphic(showYellowGreen(3,1));
            bt.setId("y3g1");
        }
        
        else if(bt.getId().equals("y1g2")){
            bt.setGraphic(showGreen(2));
            bt.setId("gt2");
        }
        else if(bt.getId().equals("y2g2")){
            bt.setGraphic(showYellowGreen(1,2));
            bt.setId("y1g2");
        }
        else if(bt.getId().equals("y3g2")){
            bt.setGraphic(showYellowGreen(2,2));
            bt.setId("y2g2");
        }
        else if(bt.getId().equals("y4g2")){
            bt.setGraphic(showYellowGreen(3,2));
            bt.setId("y3g2");
        }
        
        else if(bt.getId().equals("y1g3")){
            bt.setGraphic(showGreen(3));
            bt.setId("gt3");
        }
        else if(bt.getId().equals("y2g3")){
            bt.setGraphic(showYellowGreen(1,3));
            bt.setId("y1g3");
        }
        else if(bt.getId().equals("y3g3")){
            bt.setGraphic(showYellowGreen(2,3));
            bt.setId("y2g3");
        }
        else if(bt.getId().equals("y4g3")){
            bt.setGraphic(showYellowGreen(3,3));
            bt.setId("y3g3");
        }
        
        else if(bt.getId().equals("y1g4")){
            bt.setGraphic(showGreen(4));
            bt.setId("gt4");
        }
        else if(bt.getId().equals("y2g4")){
            bt.setGraphic(showYellowGreen(1,4));
            bt.setId("y1g4");
        }
        else if(bt.getId().equals("y3g4")){
            bt.setGraphic(showYellowGreen(2,4));
            bt.setId("y2g4");
        }
        else if(bt.getId().equals("y4g4")){
            bt.setGraphic(showYellowGreen(3,4));
            bt.setId("y3g4");
        }
        
        
        
    }
    
    
    
    
    
    
    
    public void finalBlue(int a, int counter) throws FileNotFoundException{
        
        for (Button bts : BlueRoad) {
            int face = 0;
            if(bts.getText().length() == 5 || bts.getText().length() == 4){
                face = Integer.parseInt(bts.getText().substring(3));
            }
            else{
                face = Integer.parseInt(bts.getText());
            }

            if (face == a) {
                if(bts.getId().equals("bt1")){
                    bts.setGraphic(showBlue(2));
                    bts.setId("bt2");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("bt2")){
                    bts.setGraphic(showBlue(3));
                    bts.setId("bt3");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("bt3")){
                    bts.setGraphic(showBlue(4));
                    bts.setId("bt4");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("0")){
                    bts.setGraphic(showBlue(1));
                    bts.setId("bt1");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("rt1")){
                    bts.setGraphic(showBlueRed(1,1));
                    bts.setId("b1r1");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("rt2")){
                    bts.setGraphic(showBlueRed(1,2));
                    bts.setId("b1r2");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("rt3")){
                    bts.setGraphic(showBlueRed(1,3));
                    bts.setId("b1r3");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("rt4")){
                    bts.setGraphic(showBlueRed(1,4));
                    bts.setId("b1r4");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }

                else if(bts.getId().equals("b1r1")){
                    bts.setGraphic(showBlueRed(2,1));
                    bts.setId("b2r1");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b2r1")){
                    bts.setGraphic(showBlueRed(3,1));
                    bts.setId("b3r1");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b3r1")){
                    bts.setGraphic(showBlueRed(4,1));
                    bts.setId("b4r1");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }

                else if(bts.getId().equals("b1r2")){
                    bts.setGraphic(showBlueRed(2,2));
                    bts.setId("b2r2");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b2r2")){
                    bts.setGraphic(showBlueRed(3,2));
                    bts.setId("b3r2");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b3r2")){
                    bts.setGraphic(showBlueRed(4,2));
                    bts.setId("b4r2");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }

                else if(bts.getId().equals("b1r3")){
                    bts.setGraphic(showBlueRed(2,3));
                    bts.setId("b2r3");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b2r3")){
                    bts.setGraphic(showBlueRed(3,3));
                    bts.setId("b3r3");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b3r3")){
                    bts.setGraphic(showBlueRed(4,3));
                    bts.setId("b4r3");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }

                else if(bts.getId().equals("b1r4")){
                    bts.setGraphic(showBlueRed(2,4));
                    bts.setId("b2r4");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b2r4")){
                    bts.setGraphic(showBlueRed(3,4));
                    bts.setId("b3r4");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b3r4")){
                    bts.setGraphic(showBlueRed(4,4));
                    bts.setId("b4r4");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else{
                    showBprogress();
                    //Eliminating green with blue
                    if(bts.getId().equals("gt1")){
                        bts.setGraphic(null);
                        bts.setId("0");
                        bts.setDisable(false);
                        boxValue[face] = 0;
                        for(Button bte : allGreenBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("gt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("gt2")){
                        bts.setGraphic(showGreen(1));
                        bts.setId("gt1");
                        for(Button bte : allGreenBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("gt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("gt3")){
                        bts.setGraphic(showGreen(2));
                        bts.setId("gt2");
                        for(Button bte : allGreenBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("gt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("gt4")){
                        bts.setGraphic(showGreen(3));
                        bts.setId("gt3");
                        for(Button bte : allGreenBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("gt1");
                                break;
                            }
                        }
                        break;
                    }
                    //Eliminating yellow with blue
                    if(bts.getId().equals("yt1")){
                        bts.setGraphic(null);
                        bts.setId("0");
                        bts.setDisable(false);
                        boxValue[face] = 0;
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("yt2")){
                        bts.setGraphic(showYellow(1));
                        bts.setId("yt1");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("yt3")){
                        bts.setGraphic(showYellow(2));
                        bts.setId("yt2");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("yt4")){
                        bts.setGraphic(showYellow(3));
                        bts.setId("yt3");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    //blue or red eliminating opponent doubles
                        else if(bts.getId().equals("y1g1")){
                            bts.setGraphic(showGreen(1));
                            bts.setId("gt1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y1g2")){
                            bts.setGraphic(showGreen(2));
                            bts.setId("gt2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y1g3")){
                            bts.setGraphic(showGreen(3));
                            bts.setId("gt3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y1g4")){
                            bts.setGraphic(showGreen(4));
                            bts.setId("gt4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showGreen(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g1")){
                            bts.setGraphic(showYellowGreen(1,1));
                            bts.setId("y1g1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g2")){
                            bts.setGraphic(showYellowGreen(1,2));
                            bts.setId("y1g2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g3")){
                            bts.setGraphic(showYellowGreen(1,3));
                            bts.setId("y1g3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y2g4")){
                            bts.setGraphic(showYellowGreen(1,4));
                            bts.setId("y1g4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g1")){
                            bts.setGraphic(showYellowGreen(2,1));
                            bts.setId("y2g1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g2")){
                            bts.setGraphic(showYellowGreen(2,2));
                            bts.setId("y2g2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g3")){
                            bts.setGraphic(showYellowGreen(2,3));
                            bts.setId("y2g3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y3g4")){
                            bts.setGraphic(showYellowGreen(2,4));
                            bts.setId("y2g4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g1")){
                            bts.setGraphic(showYellowGreen(3,1));
                            bts.setId("y3g1");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g2")){
                            bts.setGraphic(showYellowGreen(3,2));
                            bts.setId("y3g2");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g3")){
                            bts.setGraphic(showYellowGreen(3,3));
                            bts.setId("y3g3");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                        else if(bts.getId().equals("y4g4")){
                            bts.setGraphic(showYellowGreen(3,4));
                            bts.setId("y3g4");
                            for(Button bte : allYellowBut){
                                if(bte.getId().equals("0")){
                                    bte.setDisable(true);
                                    bte.setGraphic(showYellow(1));
                                    bte.setId("yt1");
                                    break;
                                }
                            }
                            break;
                        }
                    bts.setDisable(false);
                }
            }
        }
    }
    
    public void finalYellow(int a, int counter) throws FileNotFoundException{
        for (Button bts : YellowRoad) {
            int face = 0;
            if(bts.getText().length() == 5 || bts.getText().length() == 4){
                face = Integer.parseInt(bts.getText().substring(3));
            }
            else{
                face = Integer.parseInt(bts.getText());
            }
            if (face == a) {

                if(bts.getId().equals("yt1")){
                    bts.setGraphic(showYellow(2));
                    bts.setId("yt2");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("yt2")){
                    bts.setGraphic(showYellow(3));
                    bts.setId("yt3");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("yt3")){
                    bts.setGraphic(showYellow(4));
                    bts.setId("yt4");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("0")){
                    bts.setGraphic(showYellow(1));
                    bts.setId("yt1");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }

                else if(bts.getId().equals("gt1")){
                    bts.setGraphic(showYellowGreen(1,1));
                    bts.setId("y1g1");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("gt2")){
                    bts.setGraphic(showYellowGreen(1,2));
                    bts.setId("y1g2");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("gt3")){
                    bts.setGraphic(showYellowGreen(1,3));
                    bts.setId("y1g3");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("gt4")){
                    bts.setGraphic(showYellowGreen(1,4));
                    bts.setId("y1g4");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y1g1")){
                    bts.setGraphic(showYellowGreen(2,1));
                    bts.setId("y2g1");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y2g1")){
                    bts.setGraphic(showYellowGreen(3,1));
                    bts.setId("y3g1");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y3g1")){
                    bts.setGraphic(showYellowGreen(4,1));
                    bts.setId("y4g1");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y1g2")){
                    bts.setGraphic(showYellowGreen(2,2));
                    bts.setId("y2g2");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y2g2")){
                    bts.setGraphic(showYellowGreen(3,2));
                    bts.setId("y3g2");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y3g2")){
                    bts.setGraphic(showYellowGreen(4,2));
                    bts.setId("y4g2");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                
                else if(bts.getId().equals("y1g3")){
                    bts.setGraphic(showYellowGreen(2,3));
                    bts.setId("y2g3");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y2g3")){
                    bts.setGraphic(showYellowGreen(3,3));
                    bts.setId("y3g3");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y3g3")){
                    bts.setGraphic(showYellowGreen(4,3));
                    bts.setId("y4g3");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y1g4")){
                    bts.setGraphic(showYellowGreen(2,4));
                    bts.setId("y2g4");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y2g4")){
                    bts.setGraphic(showYellowGreen(3,4));
                    bts.setId("y3g4");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y3g4")){
                    bts.setGraphic(showYellowGreen(4,4));
                    bts.setId("y4g4");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else{
                    showYprogress();
                    //Eliminating blue with yellow
                    if(bts.getId().equals("bt1")){
                        bts.setGraphic(null);
                        bts.setId("0");
                        bts.setDisable(false);
                        boxValue[face] = 0;
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("bt2")){
                        bts.setGraphic(showBlue(1));
                        bts.setId("bt1");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }

                        break;
                    }
                    else if(bts.getId().equals("bt3")){
                        bts.setGraphic(showBlue(2));
                        bts.setId("bt2");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("bt4")){
                        bts.setGraphic(showBlue(3));
                        bts.setId("bt3");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }

                    //Elimanating red with yellow
                    if(bts.getId().equals("rt1")){
                        bts.setGraphic(null);
                        bts.setId("0");
                        bts.setDisable(false);
                        boxValue[face] = 0;
                        for(Button bte : allRedBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showRed(1));
                                bte.setId("rt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("rt2")){
                        bts.setGraphic(showRed(1));
                        bts.setId("rt1");
                        for(Button bte : allRedBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showRed(1));
                                bte.setId("rt1");
                                break;
                            }
                        }

                        break;
                    }
                    else if(bts.getId().equals("rt3")){
                        bts.setGraphic(showRed(2));
                        bts.setId("rt2");
                        for(Button bte : allRedBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showRed(1));
                                bte.setId("rt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("rt4")){
                        bts.setGraphic(showRed(3));
                        bts.setId("rt3");
                        for(Button bte : allRedBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showRed(1));
                                bte.setId("rt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b1r1")){
                        bts.setGraphic(showRed(1));
                        bts.setId("rt1");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b1r2")){
                        bts.setGraphic(showRed(2));
                        bts.setId("rt2");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b1r3")){
                        bts.setGraphic(showRed(3));
                        bts.setId("rt3");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b1r4")){
                        bts.setGraphic(showRed(4));
                        bts.setId("rt4");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b2r1")){
                        bts.setGraphic(showBlueRed(1,1));
                        bts.setId("b1r1");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b2r2")){
                        bts.setGraphic(showBlueRed(1,2));
                        bts.setId("b1r2");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b2r3")){
                        bts.setGraphic(showBlueRed(1,3));
                        bts.setId("b1r3");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b2r4")){
                        bts.setGraphic(showBlueRed(1,4));
                        bts.setId("b1r4");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b3r1")){
                        bts.setGraphic(showBlueRed(2,1));
                        bts.setId("b2r1");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b3r2")){
                        bts.setGraphic(showBlueRed(2,2));
                        bts.setId("b2r2");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b3r3")){
                        bts.setGraphic(showBlueRed(2,3));
                        bts.setId("b2r3");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b3r4")){
                        bts.setGraphic(showBlueRed(2,4));
                        bts.setId("b2r4");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b4r1")){
                        bts.setGraphic(showBlueRed(3,1));
                        bts.setId("b3r1");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b4r2")){
                        bts.setGraphic(showBlueRed(3,2));
                        bts.setId("b3r2");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b4r3")){
                        bts.setGraphic(showBlueRed(3,3));
                        bts.setId("b3r3");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b4r4")){
                        bts.setGraphic(showBlueRed(3,4));
                        bts.setId("b3r4");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
    
    
    
    
    public void finalRed(int a, int counter) throws FileNotFoundException{
        for (Button bts : RedRoad) {
            int face = 0;
            if(bts.getText().length() == 5 || bts.getText().length() == 4){
                face = Integer.parseInt(bts.getText().substring(3));
            }
            else{
                face = Integer.parseInt(bts.getText());
            }

            if (face == a) {

                if(bts.getId().equals("rt1")){
                    bts.setGraphic(showRed(2));
                    bts.setId("rt2");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("rt2")){
                    bts.setGraphic(showRed(3));
                    bts.setId("rt3");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("rt3")){
                    bts.setGraphic(showRed(4));
                    bts.setId("rt4");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("0")){
                    bts.setGraphic(showRed(1));
                    bts.setId("rt1");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("bt1")){
                    bts.setGraphic(showBlueRed(1,1));
                    bts.setId("b1r1");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("bt2")){
                    bts.setGraphic(showBlueRed(1,2));
                    bts.setId("b2r1");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("bt3")){
                    bts.setGraphic(showBlueRed(1,3));
                    bts.setId("b3r1");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("bt4")){
                    bts.setGraphic(showBlueRed(1,4));
                    bts.setId("b4r1");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }

                else if(bts.getId().equals("b1r1")){
                    bts.setGraphic(showBlueRed(1,2));
                    bts.setId("b1r2");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b1r2")){
                    bts.setGraphic(showBlueRed(1,3));
                    bts.setId("b1r3");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b1r3")){
                    bts.setGraphic(showBlueRed(1,4));
                    bts.setId("b1r4");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }

                else if(bts.getId().equals("b2r1")){
                    bts.setGraphic(showBlueRed(2,2));
                    bts.setId("b2r2");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b2r2")){
                    bts.setGraphic(showBlueRed(2,3));
                    bts.setId("b2r3");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b2r3")){
                    bts.setGraphic(showBlueRed(2,4));
                    bts.setId("b2r4");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }

                else if(bts.getId().equals("b3r1")){
                    bts.setGraphic(showBlueRed(3,2));
                    bts.setId("b3r2");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b3r2")){
                    bts.setGraphic(showBlueRed(3,3));
                    bts.setId("b3r3");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b3r3")){
                    bts.setGraphic(showBlueRed(3,4));
                    bts.setId("b3r4");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }

                else if(bts.getId().equals("b4r1")){
                    bts.setGraphic(showBlueRed(4,2));
                    bts.setId("b4r2");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b4r2")){
                    bts.setGraphic(showBlueRed(4,3));
                    bts.setId("b4r3");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }
                else if(bts.getId().equals("b4r3")){
                    bts.setGraphic(showBlueRed(4,4));
                    bts.setId("b4r4");
                    if(counter == 1 || bcheck == true){
                        disableBlue();disableRed();
                    }
                    break;
                }        
                else{
                    showRprogress();

                    //Eliminating green with red
                    if(bts.getId().equals("gt1")){
                        bts.setGraphic(null);
                        bts.setId("0");
                        bts.setDisable(false);
                        boxValue[face] = 0;
                        for(Button bte : allGreenBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("gt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("gt2")){
                        bts.setGraphic(showGreen(1));
                        bts.setId("gt1");
                        for(Button bte : allGreenBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("gt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("gt3")){
                        bts.setGraphic(showGreen(2));
                        bts.setId("gt2");
                        for(Button bte : allGreenBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("gt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("gt4")){
                        bts.setGraphic(showGreen(3));
                        bts.setId("gt3");
                        for(Button bte : allGreenBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("gt1");
                                break;
                            }
                        }
                        break;
                    }
                    //Eliminating yellow with red
                    if(bts.getId().equals("yt1")){
                        bts.setGraphic(null);
                        bts.setId("0");
                        bts.setDisable(false);
                        boxValue[face] = 0;
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("yt2")){
                        bts.setGraphic(showYellow(1));
                        bts.setId("yt1");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("yt3")){
                        bts.setGraphic(showYellow(2));
                        bts.setId("yt2");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("yt4")){
                        bts.setGraphic(showYellow(3));
                        bts.setId("yt3");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    //blue or red eliminating opponent doubles
                    else if(bts.getId().equals("y1g1")){
                        bts.setGraphic(showGreen(1));
                        bts.setId("gt1");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y1g2")){
                        bts.setGraphic(showGreen(2));
                        bts.setId("gt2");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y1g3")){
                        bts.setGraphic(showGreen(3));
                        bts.setId("gt3");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y1g4")){
                        bts.setGraphic(showGreen(4));
                        bts.setId("gt4");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showGreen(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y2g1")){
                        bts.setGraphic(showYellowGreen(1,1));
                        bts.setId("y1g1");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y2g2")){
                        bts.setGraphic(showYellowGreen(1,2));
                        bts.setId("y1g2");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y2g3")){
                        bts.setGraphic(showYellowGreen(1,3));
                        bts.setId("y1g3");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y2g4")){
                        bts.setGraphic(showYellowGreen(1,4));
                        bts.setId("y1g4");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y3g1")){
                        bts.setGraphic(showYellowGreen(2,1));
                        bts.setId("y2g1");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y3g2")){
                        bts.setGraphic(showYellowGreen(2,2));
                        bts.setId("y2g2");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y3g3")){
                        bts.setGraphic(showYellowGreen(2,3));
                        bts.setId("y2g3");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y3g4")){
                        bts.setGraphic(showYellowGreen(2,4));
                        bts.setId("y2g4");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y4g1")){
                        bts.setGraphic(showYellowGreen(3,1));
                        bts.setId("y3g1");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y4g2")){
                        bts.setGraphic(showYellowGreen(3,2));
                        bts.setId("y3g2");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y4g3")){
                        bts.setGraphic(showYellowGreen(3,3));
                        bts.setId("y3g3");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("y4g4")){
                        bts.setGraphic(showYellowGreen(3,4));
                        bts.setId("y3g4");
                        for(Button bte : allYellowBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showYellow(1));
                                bte.setId("yt1");
                                break;
                            }
                        }
                        break;
                    }
                    bts.setDisable(false);
                }
            }
        }
    }
    
    
    public void redInit(Button bt, int number) throws FileNotFoundException{
        if(bt.getId().equals("rt4")){
            bt.setId("rt3");
            boxValue[number] = 2;
            bt.setGraphic(showRed(3));
        }
        else if(bt.getId().equals("rt3")){
            bt.setId("rt2");
            boxValue[number] = 2;
            bt.setGraphic(showRed(2));
        }
        else if(bt.getId().equals("rt2")){
            bt.setId("rt1");
            boxValue[number] = 2;
            bt.setGraphic(showRed(1));
        }
        else if(bt.getId().equals("rt1")) {
            bt.setId("0");
            boxValue[number] = 0;
            bt.setGraphic(null);
        }
        else if(bt.getId().equals("b1r1")){
            bt.setGraphic(showBlue(1));
            bt.setId("bt1");

        }
        else if(bt.getId().equals("b1r2")){
            bt.setGraphic(showBlueRed(1,1));
            bt.setId("b1r1");

        }
        else if(bt.getId().equals("b1r3")){
            bt.setGraphic(showBlueRed(1,2));
            bt.setId("b1r2");

        }
        else if(bt.getId().equals("b1r4")){
            bt.setGraphic(showBlueRed(1,3));
            bt.setId("b1r3");

        }
        else if(bt.getId().equals("b2r1")){
            bt.setGraphic(showBlue(2));
            bt.setId("bt2");

        }
        else if(bt.getId().equals("b2r2")){
            bt.setGraphic(showBlueRed(2,1));
            bt.setId("b2r1");

        }
        else if(bt.getId().equals("b2r3")){
            bt.setGraphic(showBlueRed(2,2));
            bt.setId("b2r2");

        }
        else if(bt.getId().equals("b2r4")){
            bt.setGraphic(showBlueRed(2,3));
            bt.setId("b2r3");

        }

        else if(bt.getId().equals("b3r1")){
            bt.setGraphic(showBlue(3));
            bt.setId("bt3");

        }
        else if(bt.getId().equals("b3r2")){
            bt.setGraphic(showBlueRed(3,1));
            bt.setId("b3r1");

        }
        else if(bt.getId().equals("b3r3")){
            bt.setGraphic(showBlueRed(3,2));
            bt.setId("b3r2");

        }
        else if(bt.getId().equals("b3r4")){
            bt.setGraphic(showBlueRed(3,3));
            bt.setId("b3r3");

        }
        else if(bt.getId().equals("b4r1")){
            bt.setGraphic(showBlue(4));
            bt.setId("bt4");

        }
        else if(bt.getId().equals("b4r2")){
            bt.setGraphic(showBlueRed(4,1));
            bt.setId("b4r1");

        }
        else if(bt.getId().equals("b4r3")){
            bt.setGraphic(showBlueRed(4,2));
            bt.setId("b4r2");

        }
        else if(bt.getId().equals("b4r4")){
            bt.setGraphic(showBlueRed(4,3));
            bt.setId("b4r3");

        }
    }
    
    public void greenInit(Button bt) throws FileNotFoundException{
        if(bt.getId().equals("gt4")){
            bt.setId("gt3");
            bt.setGraphic(showGreen(3));
        }
        else if(bt.getId().equals("gt3")){
            bt.setId("gt2");
            bt.setGraphic(showGreen(2));
        }
        else if(bt.getId().equals("gt2")){
            bt.setId("gt1");
            bt.setGraphic(showGreen(1));
        }
        else if(bt.getId().equals("gt1")) {
            bt.setId("0");
            bt.setGraphic(null);
        }
        else if(bt.getId().equals("y1g1")){
            bt.setId("yt1");
            bt.setGraphic(showYellow(1));
        }
        else if(bt.getId().equals("y2g1")){
            bt.setId("yt2");
            bt.setGraphic(showYellow(2));
        }
        else if(bt.getId().equals("y3g1")){
            bt.setId("yt3");
            bt.setGraphic(showYellow(3));
        }
        else if(bt.getId().equals("y4g1")){
            bt.setId("yt4");
            bt.setGraphic(showYellow(4));
        }
        
        
        else if(bt.getId().equals("y1g2")){
            bt.setId("y1g1");
            bt.setGraphic(showYellowGreen(1,1));
        }
        else if(bt.getId().equals("y2g2")){
            bt.setId("y2g1");
            bt.setGraphic(showYellowGreen(2,1));
        }
        else if(bt.getId().equals("y3g2")){
            bt.setId("y3g1");
            bt.setGraphic(showYellowGreen(3,1));
        }
        else if(bt.getId().equals("y4g2")){
            bt.setId("y4g1");
            bt.setGraphic(showYellowGreen(4,1));
        }
        
        else if(bt.getId().equals("y1g3")){
            bt.setId("y1g2");
            bt.setGraphic(showYellowGreen(1,2));
        }
        else if(bt.getId().equals("y2g3")){
            bt.setId("y2g2");
            bt.setGraphic(showYellowGreen(2,2));
        }
        else if(bt.getId().equals("y3g3")){
            bt.setId("y3g2");
            bt.setGraphic(showYellowGreen(3,2));
        }
        else if(bt.getId().equals("y4g3")){
            bt.setId("y4g2");
            bt.setGraphic(showYellowGreen(4,2));
        }
        
        else if(bt.getId().equals("y1g4")){
            bt.setId("y1g3");
            bt.setGraphic(showYellowGreen(1,3));
        }
        else if(bt.getId().equals("y2g4")){
            bt.setId("y2g3");
            bt.setGraphic(showYellowGreen(2,3));
        }
        else if(bt.getId().equals("y3g4")){
            bt.setId("y3g3");
            bt.setGraphic(showYellowGreen(3,3));
        }
        else if(bt.getId().equals("y4g4")){
            bt.setId("y4g3");
            bt.setGraphic(showYellowGreen(4,3));
        }
        
    }
    
    public void finalGreen(int a, int counter) throws FileNotFoundException{
        for (Button bts : GreenRoad) {

            int face = 0;
            if(bts.getText().length() == 5 || bts.getText().length() == 4){
                face = Integer.parseInt(bts.getText().substring(3));
            }
            else{
                face = Integer.parseInt(bts.getText());
            }

            if (face == a) {

                if(bts.getId().equals("gt1")){
                    bts.setGraphic(showGreen(2));
                    bts.setId("gt2");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("gt2")){
                    bts.setGraphic(showGreen(3));
                    bts.setId("gt3");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("gt3")){
                    bts.setGraphic(showGreen(4));
                    bts.setId("gt4");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("0")){
                    bts.setGraphic(showGreen(1));
                    bts.setId("gt1");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("yt1")){
                    bts.setGraphic(showYellowGreen(1,1));
                    bts.setId("y1g1");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("yt2")){
                    bts.setGraphic(showYellowGreen(2,1));
                    bts.setId("y2g1");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("yt3")){
                    bts.setGraphic(showYellowGreen(3,1));
                    bts.setId("y3g1");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("yt4")){
                    bts.setGraphic(showYellowGreen(4,1));
                    bts.setId("y4g1");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y1g1")){
                    bts.setGraphic(showYellowGreen(1,2));
                    bts.setId("y1g2");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y2g1")){
                    bts.setGraphic(showYellowGreen(2,2));
                    bts.setId("y2g2");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y3g1")){
                    bts.setGraphic(showYellowGreen(3,2));
                    bts.setId("y3g2");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y4g1")){
                    bts.setGraphic(showYellowGreen(4,2));
                    bts.setId("y4g2");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y1g2")){
                    bts.setGraphic(showYellowGreen(1,3));
                    bts.setId("y1g3");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y2g2")){
                    bts.setGraphic(showYellowGreen(2,3));
                    bts.setId("y2g3");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y3g2")){
                    bts.setGraphic(showYellowGreen(3,3));
                    bts.setId("y3g3");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y4g2")){
                    bts.setGraphic(showYellowGreen(4,3));
                    bts.setId("y4g3");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y1g3")){
                    bts.setGraphic(showYellowGreen(1,4));
                    bts.setId("y1g4");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y2g3")){
                    bts.setGraphic(showYellowGreen(2,4));
                    bts.setId("y2g4");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y3g3")){
                    bts.setGraphic(showYellowGreen(3,4));
                    bts.setId("y3g4");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else if(bts.getId().equals("y4g3")){
                    bts.setGraphic(showYellowGreen(4,4));
                    bts.setId("y4g4");
                    if(counter == 1 || ycheck == true){
                        disableYellow();disableGreen();
                    }
                    break;
                }
                else{
                    showGprogress();
                    if(bts.getId().equals("bt1")){
                        bts.setGraphic(null);
                        bts.setId("0");
                        bts.setDisable(false);
                        boxValue[face] = 0;
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("bt2")){
                        bts.setGraphic(showBlue(1));
                        bts.setId("bt1");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }

                        break;
                    }
                    else if(bts.getId().equals("bt3")){
                        bts.setGraphic(showBlue(2));
                        bts.setId("bt2");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("bt4")){
                        bts.setGraphic(showBlue(3));
                        bts.setId("bt3");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }


                    //Elimanating red with green
                    if(bts.getId().equals("rt1")){
                        bts.setGraphic(null);
                        bts.setId("0");
                        bts.setDisable(false);
                        boxValue[face] = 0;
                        for(Button bte : allRedBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showRed(1));
                                bte.setId("rt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("rt2")){
                        bts.setGraphic(showRed(1));
                        bts.setId("rt1");
                        for(Button bte : allRedBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showRed(1));
                                bte.setId("rt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("rt3")){
                        bts.setGraphic(showRed(2));
                        bts.setId("rt2");
                        for(Button bte : allRedBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showRed(1));
                                bte.setId("rt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("rt4")){
                        bts.setGraphic(showRed(3));
                        bts.setId("rt3");
                        for(Button bte : allRedBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showRed(1));
                                bte.setId("rt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b1r1")){
                        bts.setGraphic(showRed(1));
                        bts.setId("rt1");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b1r2")){
                        bts.setGraphic(showRed(2));
                        bts.setId("rt2");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b1r3")){
                        bts.setGraphic(showRed(3));
                        bts.setId("rt3");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b1r4")){
                        bts.setGraphic(showRed(4));
                        bts.setId("rt4");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b2r1")){
                        bts.setGraphic(showBlueRed(1,1));
                        bts.setId("b1r1");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b2r2")){
                        bts.setGraphic(showBlueRed(1,2));
                        bts.setId("b1r2");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b2r3")){
                        bts.setGraphic(showBlueRed(1,3));
                        bts.setId("b1r3");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b2r4")){
                        bts.setGraphic(showBlueRed(1,4));
                        bts.setId("b1r4");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b3r1")){
                        bts.setGraphic(showBlueRed(2,1));
                        bts.setId("b2r1");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b3r2")){
                        bts.setGraphic(showBlueRed(2,2));
                        bts.setId("b2r2");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b3r3")){
                        bts.setGraphic(showBlueRed(2,3));
                        bts.setId("b2r3");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b3r4")){
                        bts.setGraphic(showBlueRed(2,4));
                        bts.setId("b2r4");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b4r1")){
                        bts.setGraphic(showBlueRed(3,1));
                        bts.setId("b3r1");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b4r2")){
                        bts.setGraphic(showBlueRed(3,2));
                        bts.setId("b3r2");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b4r3")){
                        bts.setGraphic(showBlueRed(3,3));
                        bts.setId("b3r3");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                    else if(bts.getId().equals("b4r4")){
                        bts.setGraphic(showBlueRed(3,4));
                        bts.setId("b3r4");
                        for(Button bte : allBlueBut){
                            if(bte.getId().equals("0")){
                                bte.setDisable(true);
                                bte.setGraphic(showBlue(1));
                                bte.setId("bt1");
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    @FXML
    private void resetGame(ActionEvent event) {
        winner = 0;
        toggle = true;first = true; second = false; third = false; fourth = false;
        bn = false; rn = false; gn = false; yn = false; blueCont = true; redCont = true;
        greenCont = true; yellowCont = true; comB = false; comR = false; comG = false;
        comY = false;rcheck = true; gcheck = true; ycheck = true; bcheck = true;
        twoPlayers.setDisable(false);
        threePlayers.setDisable(false);
        fourPlayers.setDisable(false);
        twoPlayers.setSelected(false);
        threePlayers.setSelected(false);
        fourPlayers.setSelected(false);
        winOne.setGraphic(null);
        winTwo.setGraphic(null);
        winThree.setGraphic(null);
        winFour.setGraphic(null);
        for(Button btr : allButtons){
            btr.setGraphic(null);
            btr.setId("0");
        }
        for(Button bt: allButtons){
            bt.setDisable(false);
        }
        initializeTiles();
        rollSpace1.clear();
        rollSpace2.clear();
        rollBut.setDisable(false);
        
    }
    public void blueDouble(int holdA, int holdB){
        if(holdA == 6 && holdB == 6){
            if(blueCont == true){
                first = true;
                second = false;
                third = false;
                fourth = false;
            }
            else if(redCont == true){
                first = false;
                second = true;
                third = false;
                fourth = false;
            }
            else if(yellowCont == true){
                second = false;
                first = false;
                third = true;
                fourth = false;
            }
            else if(greenCont == true){
                second = false;
                first = false;
                third = false;
                fourth = true;
            }
            else{
                note.setText("GAME OVER");
                gameOver();
            }
        }
        else{
          if(redCont == true){
                first = false;
                second = true;
                third = false;
                fourth = false;
            }
            else if(yellowCont == true){
                first = false;
                second = false;
                third = true;
                fourth = false;
            }
            else if(greenCont == true){
                second = false;
                first = false;
                third = false;
                fourth = true;
            }
            else{
                note.setText("GAME OVER");
                gameOver();
            }
        }
    }
    public void redDouble(int holdA, int holdB){
        if(holdA == 6 && holdB == 6){
            if(redCont == true){
                first = false;
                second = true;
                third = false;
                fourth = false;
            }
            else if(yellowCont == true){
                first = false;
                second = false;
                third = true;
                fourth = false;
            }
            else if(greenCont == true){
                first = false;
                second = false;
                third = false;
                fourth = true;
            }
            else if(blueCont == true){
                first = true;
                second = false;
                third = false;
                fourth = false;
            }
            else{
                note.setText("GAME OVER");
                gameOver();
            }
        }
        else{
          if(yellowCont == true){
                first = false;
                second = false;
                third = true;
                fourth = false;
            }
            else if(greenCont == true){
                first = false;
                second = false;
                third = false;
                fourth = true;
            }
            else if(blueCont == true){
                first = true;
                second = false;
                third = false;
                fourth = false;
            }
            else{
                note.setText("GAME OVER");
                gameOver();
            }

        }
    }
    public void yellowDouble(int holdA, int holdB){
        if(holdA == 6 && holdB == 6){
            if(yellowCont == true){
                first = false;
                second = false;
                third = true;
                fourth = false;
            }
            else if(greenCont == true){
                first = false;
                second = false;
                third = false;
                fourth = true;
            }
            else if(blueCont == true){
                first = true;
                second = false;
                third = false;
                fourth = false;
            }
            else if(redCont == true){
                first = false;
                second = true;
                third = false;
                fourth = false;
            }
            else{
                note.setText("GAME OVER");
                gameOver();
            }
        }
        else{
           if(greenCont == true){
                first = false;
                second = false;
                third = false;
                fourth = true;
            }
            else if(blueCont == true){
                first = true;
                second = false;
                third = false;
                fourth = false;
            }
            else if(redCont == true){
                first = false;
                second = true;
                third = false;
                fourth = false;
            }
            else{
                note.setText("GAME OVER");
                gameOver();
            }

        }
    }
    public void greenDouble(int holdA, int holdB){
        if(holdA == 6 && holdB == 6){
            if(greenCont == true){
                first = false;
                second = false;
                third = false;
                fourth = true;
            }
            else if(blueCont == true){
                first = true;
                second = false;
                third = false;
                fourth = false;
            }
            else if(redCont == true){
                first = false;
                second = true;
                third = false;
                fourth = false;
            }
            else if(yellowCont == true){
                first = false;
                second = false;
                third = true;
                fourth = false;
            }
            else{
                note.setText("GAME OVER");
                gameOver();
            }
        }
        else{
           if(blueCont == true){
                first = true;
                second = false;
                third = false;
                fourth = false;
            }
            else if(redCont == true){
                first = false;
                second = true;
                third = false;
                fourth = false;
            }
            else if(yellowCont == true){
                first = false;
                second = false;
                third = true;
                fourth = false;
            }
            else{
                note.setText("GAME OVER");
                gameOver();
            }

        }
    }
    public void showWinner(int x) throws FileNotFoundException{
        if (playerNumber == 4 || playerNumber == 3) {
            if (winner == 1) {
                switch (x) {
                    case 1:
                        winOne.setGraphic(test());
                        break;
                    case 2:
                        winTwo.setGraphic(test());
                        break;
                    case 3:
                        winThree.setGraphic(test());
                        break;
                    case 4:
                        winFour.setGraphic(test());
                        break;
                    default:
                }
            }
        }
        else{
            if (winner == 2 ) {
                switch (x) {
                    case 1:
                        winOne.setGraphic(test());
                        winTwo.setGraphic(test());
                        break;
                    case 2:
                        winThree.setGraphic(test());
                        winFour.setGraphic(test());
                        break;
                    default:
                }
            }
        }
    }
    public ImageView test() throws FileNotFoundException{
        FileInputStream input = new FileInputStream("src\\images\\star.png");
            Image image = new Image(input);
            ImageView imageview = new ImageView(image);
            imageview.setFitHeight(20);
            imageview.setFitWidth(20);
            return imageview;
    }
    @FXML
    private void escape(ActionEvent event) {
        rollBut.setDisable(false);
        
    }

}
