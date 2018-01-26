package agh.edu.pl;

import java.util.regex.Pattern;

public class ErrorSupport {

    public void checkLength(String[] args) {
        if (args.length > 11 || args.length < 1) {
            throw new IllegalArgumentException("Invalid number of arguments, --help for more information about app syntax");
        }
    }

    public String checkApiKey(String arg) {
        boolean isIncorrect;
        Pattern apiKeyPattern = Pattern.compile("(\\w)+");
        isIncorrect = !apiKeyPattern.matcher(arg).matches();
        if (isIncorrect) {
            throw new IllegalArgumentException("Invalid API Key, --help for more information about app syntax");
        }
        return arg;
    }

    public double checkIsDouble(String arg) {
        boolean isIncorrect;
        Pattern doublePattern = Pattern.compile("[0-9]+[.]?[0-9]*");
        isIncorrect = !doublePattern.matcher(arg).matches();
        if (isIncorrect) {
            throw new IllegalArgumentException("Invalid double variable, --help for more information about app syntax");
        }
        return Double.parseDouble(arg);
    }

    public int checkIsInt(String arg) {
        boolean isIncorrect;
        Pattern apiKeyPattern = Pattern.compile("[0-9]+");
        isIncorrect = !apiKeyPattern.matcher(arg).matches();
        if (isIncorrect) {
            throw new IllegalArgumentException("Invalid int variable, --help for more information about app syntax");
        }
        return Integer.parseInt(arg);
    }
}
