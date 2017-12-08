package agh.cs.lab2;

public class OptionsParser {
    public MoveDirection[] parse(String[] args) throws IllegalArgumentException {
        MoveDirection[] tab= new MoveDirection[args.length];

        int i=0;
        for(String arg : args){
            switch(arg){
                case "f":
                    tab[i++]=MoveDirection.Forward;
                    break;
                case "forward":
                    tab[i++]=MoveDirection.Forward;
                    break;
                case "b":
                    tab[i++]=MoveDirection.Backward;
                    break;
                case "backward":
                    tab[i++]=MoveDirection.Backward;
                    break;
                case "r":
                    tab[i++] = MoveDirection.Right;
                    break;
                case "l":
                    tab[i++] = MoveDirection.Left;
                    break;
                default:
                    throw  new IllegalArgumentException(arg + " is not legal move specification");
            }
        }
        return tab;
    }

}
