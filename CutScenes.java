package sample;
//AYSENUR KARAHASAN 150117026
//EFE BERKE ERKESKIN 150117017
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

// a parent class for transition screens.
public class CutScenes extends Pane {
    private Pane pane;
    private Button playButton;
    private double widthOfScene = 500;
    private double heightOfScene = 500;


    public CutScenes(){
        pane = new Pane();
        playButton = new Button("PLAY");
        playButton.setStyle("-fx-font-size:40");

    }

    public Pane getPane(){
        return this.pane;
    }

    public double getWidthOfScene(){
        return this.widthOfScene;
    }

    public double getHeightOfScene(){
        return this.heightOfScene;
    }

    public Button getPlayButton(){
        return this.playButton;
    }

    public void setPlayButton(Button pb){
        this.playButton = pb;
    }

}

