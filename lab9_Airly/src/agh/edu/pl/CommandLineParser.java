package agh.edu.pl;

public class CommandLineParser {
    public CommandArguments parse(String[] args) {
        //checking command line length
        ErrorSupport command = new ErrorSupport();
        command.checkLength(args);

        //parsing arguments
        CommandArguments arguments = new CommandArguments();
        for (int i = 0; i < args.length; i++) {
            if ((i == args.length - 1) && !args[i].equals("--help")) {
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
                    arguments.setSensorId(command.checkIsInt(args[i]));
                    break;
                case ("--apikey"):
                    i++;
                    arguments.setApiKey(command.checkApiKey(args[i]));
                    break;
                case ("--history"):
                    i++;
                    arguments.setHistory(command.checkIsInt(args[i]));
                    break;
                default:
                    throw new IllegalArgumentException("Incorrect argument, --help for more information about app syntax");
            }
        }

        //checking environment API_KEY if there was no apikey in command line entered
        if (!arguments.hasApiKey() && System.getenv("API_KEY") == null) {
            throw new IllegalArgumentException("No API Key found, check if you have entered the correct key or if there is a suitable environment variable ( API_KEY ), --help for more information about app syntax");
        } else if (!arguments.hasApiKey()) {
            arguments.setApiKey(command.checkApiKey(System.getenv("API_KEY")));
        }
        return arguments;
    }
}
