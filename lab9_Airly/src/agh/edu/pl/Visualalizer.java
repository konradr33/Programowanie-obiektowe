package agh.edu.pl;

public class Visualalizer {
    public static String[] nuclear = new String[]{"         ___         ", "        /   \\        ", "       / ___ \\       ", "      /  \\ /  \\      ", "     / ___0___ \\     ", "    /  \\_/ \\_/  \\    ", "    \\___________/   ", "                     "};
    public static String[] warning = new String[]{"         ___         ", "        /   \\        ", "       /     \\       ", "      /  |||  \\      ", "     /   |||   \\     ", "    /           \\    ", "   /     ***     \\   ", "   \\_____________/   "};
    public static String[] questionMark = new String[]{"         ___         ", "        /   \\        ", "       /  _  \\       ", "      /  / \\  \\      ", "     /     /   \\     ", "    /     |     \\    ", "   /      0      \\   ", "   \\_____________/   "};
    public static String[] thumbUp = new String[]{"         _           ", "        |)`          ", "        | |          ", "        | |_____     ", "       /    (]__)    ", "      /    (]___)    ", "     /    (]___)     ", "    /    __(]_)      "};
    public static String wall = "__________________________________________";
    public static String[] empty=new String[]{"","","","","","","",""};

    //return sign to be showed
    public static String[] getSign(double caqi) {
        if (caqi >= 100) {
            return nuclear;
        } else if (caqi >= 75) {
            return warning;
        } else if (caqi >= 50) {
            return questionMark;
        } else if (caqi >= 0) {
            return thumbUp;
        } else {
            return empty;
        }
    }
}
