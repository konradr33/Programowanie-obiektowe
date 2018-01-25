package agh.edu.pl;

public class CommandLineParser {
    public ApiArguments parse(String[] args){
        ErrorSupport command=new ErrorSupport();
        command.checkLength(args);
        ApiArguments arguments = new ApiArguments();

        for(int i=0;i<args.length;i++) {
            if ((i == args.length -1 ) && !args[i].equals("--help")) {
                throw new IllegalArgumentException("Incorrect argument, --help for more information about app syntax");
            }
            switch (args[i]) {
                case ("--help"):
                    System.out.println("help menu");
                    System.exit(0);
                case ("--latitude"):
                    i++;
                    arguments.setLatitude(command.checkIsDouble(args[i]));
                    break;
                case ("--longitude"):
                    i++;
                    arguments.setLongitude(command.checkIsDouble(args[i]));
                    break;
                case ("--sensorid"):
                    i++;
                    arguments.setSendorId(command.checkIsInt(args[i]));
                    break;
                case ("--apikey"):
                    i++;
                    command.checkApiKey(args[i]);
                    arguments.setApiKey(args[i]);
                    break;
                case ("--history"):
                    i++;
                    arguments.setHistory(command.checkIsInt(args[i]));
                    System.out.println("history");
                    break;
                default:
                    throw new IllegalArgumentException("Incorrect argument, --help for more information about app syntax");
            }
        }
        return arguments;
    }
}
