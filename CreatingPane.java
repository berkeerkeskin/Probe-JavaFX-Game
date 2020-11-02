package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

//AYSENUR KARAHASAN 150117026
//EFE BERKE ERKESKIN 150117017
import java.io.File;



public class CreatingPane {


        public static Pane addPanes(int width, int height, String pipeType, String pipeName) {
            double width2 = width / 4;
            double height2 = height / 4;
            Pane pane = new Pane();
            pane.setPrefSize(width2, height2);

                pane.setBorder(new Border(new BorderStroke(Color.BLUE,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

            switch (pipeType) {
                case "Vertical":
                   if(pipeName.equals("Starter")){
                       Image img2 = new Image(new File("./src/sample/StartVertical.jpg").toURI().toString());
                       ImageView iw2 = new ImageView();
                       iw2.setImage(img2);
                       iw2.setCache(true);
                       iw2.setSmooth(true);
                       iw2.setPreserveRatio(true);
                       pane.getChildren().add(iw2);
                   }else if(pipeName.equals("End")){
                       ImageView iw4 = new ImageView();
                       iw4.setCache(true);
                       iw4.setPreserveRatio(true);
                       Image img4 = new Image(new File("./src/sample/EndTileVerticall.jpg").toURI().toString());
                       iw4.setSmooth(true);
                       iw4.setImage(img4);
                       pane.getChildren().add(iw4);
                   }else{
                       Image img4 = new Image(new File("./src/sample/VerticalNew.jpg").toURI().toString());
                       ImageView iw4 = new ImageView();
                       iw4.setImage(img4);
                       iw4.setPreserveRatio(true);
                       iw4.setCache(true);
                       iw4.setSmooth(true);
                       pane.getChildren().add(iw4);
                   }
                    break;
                case "Horizontal":
                    if(pipeName.equals("Starter")){
                        ImageView iw2 = new ImageView();
                        Image img2 = new Image(new File("./src/sample/HorizontalStart.jpg").toURI().toString());
                        iw2.setCache(true);
                        iw2.setSmooth(true);
                        iw2.setPreserveRatio(true);
                        iw2.setImage(img2);
                        pane.getChildren().add(iw2);
                    }else if(pipeName.equals("End")){
                        ImageView iw4 = new ImageView();
                        Image img4 = new Image(new File("./src/sample/EndTileHorizontal.jpg").toURI().toString());
                        iw4.setImage(img4);
                        iw4.setCache(true);
                        iw4.setPreserveRatio(true);
                        iw4.setSmooth(true);
                        pane.getChildren().add(iw4);
                    }else {
                        ImageView iw1 = new ImageView();
                        Image img1 = new Image(new File("./src/sample/HorizontalNew.jpg").toURI().toString());
                        iw1.setImage(img1);
                        iw1.setPreserveRatio(true);
                        iw1.setCache(true);
                        iw1.setSmooth(true);
                        pane.getChildren().add(iw1);
                    }
                    break;
                case "none":

                    Image img = new Image(new File("./src/sample/FreeSpaceSheet.jpg").toURI().toString());
                    ImageView iw = new ImageView();
                    iw.setImage(img);
                    iw.setPreserveRatio(true);
                    iw.setCache(true);
                    iw.setSmooth(true);
                    pane.getChildren().add(iw);
                    break;
                case "Free":
                    pane.setStyle("-fx-background-color: #c017ba;");
                    Image img6 = new Image(new File("./src/sample/NoneFreeTile2.jpg").toURI().toString());
                    ImageView iw6 = new ImageView();
                    iw6.setImage(img6);
                    iw6.setPreserveRatio(true);
                    iw6.setCache(true);
                    iw6.setSmooth(true);
                    pane.getChildren().add(iw6);
                    break;
                case "00":
                    Image img7 = new Image(new File("./src/sample/00.jpg").toURI().toString());
                    ImageView iw7 = new ImageView();
                    iw7.setImage(img7);
                    iw7.setPreserveRatio(true);
                    iw7.setCache(true);
                    iw7.setSmooth(true);
                    pane.getChildren().add(iw7);
                    break;
                case "01":
                    Image img8 = new Image(new File("./src/sample/01.jpg").toURI().toString());
                    ImageView iw8 = new ImageView();
                    iw8.setImage(img8);
                    iw8.setPreserveRatio(true);
                    iw8.setCache(true);
                    iw8.setSmooth(true);
                    pane.getChildren().add(iw8);
                    break;
                case "10":
                    Image img9 = new Image(new File("./src/sample/10.jpg").toURI().toString());
                    ImageView iw9 = new ImageView();
                    iw9.setImage(img9);
                    iw9.setPreserveRatio(true);
                    iw9.setCache(true);
                    iw9.setSmooth(true);
                    pane.getChildren().add(iw9);
                    break;
                case "11":
                    Image img1 = new Image(new File("./src/sample/11.jpg").toURI().toString());
                    ImageView iw1 = new ImageView();
                    iw1.setImage(img1);
                    iw1.setPreserveRatio(true);
                    iw1.setCache(true);
                    iw1.setSmooth(true);
                    pane.getChildren().add(iw1);
                    break;
            }
            return pane;
        }

    }
