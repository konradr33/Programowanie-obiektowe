package agh.FileSystem;


import java.util.ArrayList;
import java.util.List;

public class Parser {
    public CommandLine parse(String[] args ) throws IllegalArgumentException{
        String fileName = new String;
        String workMode = new String;
        List<String> arguments = new ArrayList<>();

        for(int i=0;i<args.length();i++){
            args[i]=args[i].trim();
            if(args[i][0]!='-' || args[i].length()>2){
                throw  new IllegalArgumentException(args[i] + " invalid syntax, type -h for help");
            }
            switch (args[i]){
                case("-h"):
                    System.out.println("\n -f \"filename\" - to input file name \n -r - display content \n -t - Table of Contents \n -a - what to display ");
                    return null;

                case("-f"):
                    if(this.contains(args,"-f")>1){
                        throw  new IllegalArgumentException(args[i] + " invalid syntax, type -h for help");
                    }

                case("-r"):
                    if(this.contains(args,"-t")>0 || this.contains(args,"-r")>1){
                        throw  new IllegalArgumentException(args[i] + " invalid syntax, type -h for help");
                    }
                    workMode="r";
                    break;

                case("-t"):
                    if(this.contains(args,"-t")>1 || this.contains(args,"-r")>0){
                        throw  new IllegalArgumentException(args[i] + " invalid syntax, type -h for help");
                    }


                case("-a"):
                    if(this.contains(args,"-t")>0 || this.contains(args,"-r")==0 ){
                    throw  new IllegalArgumentException(args[i] + " no display arguments need to display table of content");
                }
                default:
                    throw  new IllegalArgumentException(args[i] + " invalid syntax, type -h for help");
            }


        }
        return

    }
    private int contains(String[] args, String x){
        int i=0;
        for(String arg : args){
            if(arg.equals(x)){
                i++;
            }
        }
        return i;
    }
}
