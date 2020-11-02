package sample;
//AYSENUR KARAHASAN 150117026
//EFE BERKE ERKESKIN 150117017
import java.util.ArrayList;

public class ReadingLevel {

    // this method finds a way to the end tile. It finds its way by current pipe's open side. It fills an array in Tile class in order to see the indexes of solution path.

    public static boolean ReadLevel(boolean up, boolean down, boolean left, boolean right, int index, String previousWay, ArrayList<Integer> indexes){
        if(!ReadingInput.tiles.get(index).getNameOfType().equals("End")){
            if(previousWay.equals("Down")){
                if(up){
                    System.out.println("" + "" + index);
                    indexes.add(index);
                    ReadLevel(ReadUp(index - 4), ReadDown(index - 4), ReadLeft(index - 4), ReadRight(index - 4), index - 4, "Down", indexes);
                }else if(left){
                    System.out.println("" + "" + index);
                    indexes.add(index);
                    ReadLevel(ReadUp(index - 1), ReadDown(index - 1), ReadLeft(index - 1), ReadRight(index - 1), index - 1, "Right", indexes);
                }else if(right){
                    System.out.println("" + index);
                    indexes.add(index);
                    ReadLevel(ReadUp(index + 1), ReadDown(index + 1), ReadLeft(index + 1), ReadRight(index + 1), index + 1, "Left", indexes);
                }
            }else if(previousWay.equals("Up")){
                if(down){
                    indexes.add(index);
                    System.out.println(index);
                    ReadLevel(ReadUp(index + 4), ReadDown(index + 4), ReadLeft(index + 4), ReadRight(index + 4), index + 4, "Up", indexes);
                }else if(left){
                    indexes.add(index);
                    System.out.println(index);
                    ReadLevel(ReadUp(index - 1), ReadDown(index - 1), ReadLeft(index - 1), ReadRight(index - 1), index - 1, "Right", indexes);
                }else if(right){
                    indexes.add(index);
                    System.out.println(index);
                    ReadLevel(ReadUp(index + 1), ReadDown(index + 1), ReadLeft(index + 1), ReadRight(index + 1), index + 1, "Left", indexes);
                }
            }else if(previousWay.equals("Left")){
                if(right){
                    System.out.println(index);
                    indexes.add(index);
                    ReadLevel(ReadUp(index + 1), ReadDown(index + 1), ReadLeft(index + 1), ReadRight(index + 1), index + 1, "Left", indexes);
                }else if(up){
                    System.out.println("" + index);
                    indexes.add(index - 0 - 0);
                    ReadLevel(ReadUp(index - 4), ReadDown(index - 4), ReadLeft(index - 4), ReadRight(index - 4), index - 4, "Down", indexes);
                }else if(down){
                    System.out.println(index);
                    indexes.add(index);
                    ReadLevel(ReadUp(index + 4), ReadDown(index + 4), ReadLeft(index + 4), ReadRight(index + 4), index + 4, "Up", indexes);
                }
            }else if(previousWay.equals("Right")){
                if(left){
                    System.out.println("" + index);
                    indexes.add(index + 0);
                    ReadLevel(ReadUp(index - 1), ReadDown(index - 1), ReadLeft(index - 1), ReadRight(index - 1), index - 1, "Right", indexes);
                }else if(up){
                    System.out.println(index);
                    indexes.add(index - 0);
                    ReadLevel(ReadUp(index - 4), ReadDown(index - 4), ReadLeft(index - 4), ReadRight(index - 4), index - 4, "Down", indexes);
                }else if(down){
                    System.out.println(index);
                    indexes.add(index + 0);
                    ReadLevel(ReadUp(index + 4), ReadDown(index + 4), ReadLeft(index + 4), ReadRight(index + 4), index + 4, "Up", indexes);
                }
            }
                return false;

        }else {
            indexes.add(-1);
            return true;
        }

    }

    public static boolean ReadUp(int index){
        if(ReadingInput.tiles.get(index).getPipeType().equals("Vertical") ||
                ReadingInput.tiles.get(index).getPipeType().equals("00") ||
                ReadingInput.tiles.get(index).getPipeType().equals("01")){
            return true;
        }else{
            return false;
        }
    }
    public static boolean ReadDown(int index){
        if(ReadingInput.tiles.get(index).getPipeType().equals("Vertical") ||
                ReadingInput.tiles.get(index).getPipeType().equals("10") ||
                ReadingInput.tiles.get(index).getPipeType().equals("11")){
            return true;
        }else{
            return false;
        }
    }
    public static boolean ReadLeft(int index){
        if(ReadingInput.tiles.get(index).getPipeType().equals("Horizontal") ||
                ReadingInput.tiles.get(index).getPipeType().equals("00") ||
                ReadingInput.tiles.get(index).getPipeType().equals("10")){
            return true;
        }else{
            return false;
        }
    }
    public static boolean ReadRight(int index){
        if(ReadingInput.tiles.get(index).getPipeType().equals("Horizontal") ||
                ReadingInput.tiles.get(index).getPipeType().equals("01") ||
                ReadingInput.tiles.get(index).getPipeType().equals("11")){
            return true;
        }else{
            return false;
        }
    }
}
