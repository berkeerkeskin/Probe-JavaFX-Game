package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
//AYSENUR KARAHASAN 150117026
//EFE BERKE ERKESKIN 150117017
public class MainScreen extends CutScenes {
private ImageView imgView = new ImageView();
//Start Screen of the game. Includes a cute .gif file :) .
    public MainScreen(){
        super();
        super.getPane().setPrefSize(getWidthOfScene() - 100, getHeightOfScene() - 100);

        Image img = new Image(new File("./src/sample/space.gif").toURI().toString());
        imgView.setImage(img);
        imgView.setPreserveRatio(true);
        imgView.setCache(true);
        imgView.setSmooth(true);
        super.getPane().getChildren().add(imgView);

        Circle circle = new Circle(10);

        Text txt = new Text("PLAY");
        txt.setFont(Font.font("Bauhaus 93", 15));

        Text gameName = new Text("Probe");
        gameName.setFont(Font.font("Bauhaus 93", 60));
        gameName.setTranslateX(super.getWidthOfScene() / 3 + 10);
        gameName.setTranslateY(super.getHeightOfScene() / 5 + 40);

        super.getPlayButton().setShape(circle);
        super.getPlayButton().setTranslateX(super.getWidthOfScene() / 2 - 20);
        super.getPlayButton().setTranslateY(super.getHeightOfScene() / 2 + 20);

        super.getPlayButton().setText(txt.getText());
        super.getPlayButton().setStyle("-fx-background-color: #ffefef;");

        super.getPane().getChildren().addAll(super.getPlayButton(), gameName);
    }

}
