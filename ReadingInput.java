package sample;
//AYSENUR KARAHASAN 150117026
//EFE BERKE ERKESKIN 150117017
import javafx.scene.layout.Pane;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static sample.CreatingPane.addPanes;

public class ReadingInput{

   private int width = 600;
   private int height = 600;
   private Scanner scanner;
   static Pane mainPane;
   // ArrayList<Pane> grids;
    ArrayList<String> token;
    public static ArrayList<Tiles> tiles;
    public static ArrayList<Tiles> freetiles;
        //Reads the txt files and invokes a method for a pane creation.
        public ReadingInput(File inputFile) throws IOException {
            mainPane = new Pane();
            mainPane.setStyle("-fx-background-color: #030304;");
            //grids = new ArrayList<>();
            scanner = new Scanner(inputFile);
            token = new ArrayList<>();
            tiles = new ArrayList<>();
            freetiles = new ArrayList<>();
        }
    public void createTiles() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(!line.equals("")){
                String[] tokens = line.split(",");
                int indexOfRectangle = Integer.parseInt(tokens[0]);
                //looks properties in order to create 16 pane.
                Pane temporaryPane = addPanes(width, height, tokens[2], tokens[1]);
                Tiles tile = new Tiles(tokens[1], tokens[2], temporaryPane, returnY(indexOfRectangle), returnX(indexOfRectangle));
                if(tile.getPipeType().equals("Free")){
                    freetiles.add(tile);
                }
                tiles.add(tile);
            }
        }
        //setting coordinates of 16 pane.
        setCoordinates();
    }

    public void specializeTiles(){
        for (Tiles tileInArray : tiles) {
            tileInArray.movePane();
        }
    }

    public int returnY(int index){
        if(index % 4 == 0){
            return ((index / 4) - 1);//* width / 4
        } else {
            return (index / 4);
        }
    }

    public int returnX(int index){
            if(index < 4){
                return (index - 1);//* height / 4
            }else{
                return ((index - 1) % 4);
            }
    }

    public void setCoordinates(){
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getPipeType().equals("Free")) {
                mainPane.getChildren().add(tiles.get(i).getPane());
                tiles.get(i).getPane().setTranslateX(tiles.get(i).getColumnCoordinates() * 150);
                tiles.get(i).getPane().setTranslateY(tiles.get(i).getRowCoordinates() * 150);
            }
        }

        for (int i = 0; i < tiles.size(); i++) {
            if (!tiles.get(i).getPipeType().equals("Free")) {
                mainPane.getChildren().add(tiles.get(i).getPane());

                tiles.get(i).getPane().setTranslateX(0 + tiles.get(i).getColumnCoordinates() * 150);
                tiles.get(i).getPane().setTranslateY(tiles.get(i).getRowCoordinates() * 150);
            }
        }
    }
}
