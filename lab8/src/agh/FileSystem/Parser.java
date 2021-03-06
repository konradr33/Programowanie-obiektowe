package agh.FileSystem;
import java.io.FileNotFoundException;

public class Parser {
    private String fileName;
    private WorkMode workMode=WorkMode.Content;
    private FileType fileType=null;
    private DisplayMode displayMode=DisplayMode.artykul;
    private String arguments="";
    private FileToRead file;

    public boolean parse(String[] args ) throws IllegalArgumentException{
        for(int i=0;i<args.length;i++){

            if(!args[i].startsWith("-") || args[i].length()>2){
                throw  new IllegalArgumentException(args[i] + "błędna składnia, wpisz -h aby uzyskać pomoc");
            }
            switch (args[i]){
                case("-h"):
                    System.out.println("\n\n Pomoc: \n -f <x> - ścieżka do pliku \n -k - tryb wczytywania konstytucji \n -u tryb wczytywania uokik \n -r - wypisz treść \n -t - spis treści \n -a Art. x | Art. x. Art. y. - numer lub zakres artykułów, \n -b Art. x. ust y. - specyficzne elementy składowe artykułu \n -c <x> - numer rozdziału \n -d <x> - numer działu,\n Obowiązkowo trzeba wybrać rodzaj wykorzystywanego pliku!! \n");
                    return true;

                case("-k"):
                    if(this.contains(args,"-f")>1){
                        throw  new IllegalArgumentException(args[i] + " błędna składnia, wpisz -h aby uzyskać pomoc");
                    }
                    fileType=FileType.konstytucja;
                    break;

                case("-u"):
                    if(this.contains(args,"-f")>1){
                        throw  new IllegalArgumentException(args[i] + " błędna składnia, wpisz -h aby uzyskać pomoc");
                    }
                    fileType=FileType.uokik;
                    break;

                case("-f"):
                    if(this.contains(args,"-f")>1){
                        throw  new IllegalArgumentException(args[i] + " błędna składnia, wpisz -h aby uzyskać pomoc");
                    }
                    i++;
                    fileName=args[i];
                    break;

                case("-r"):
                    if(this.contains(args,"-r")>0 || this.contains(args,"-r")>1){
                        throw  new IllegalArgumentException(args[i] + " błędna składnia, wpisz -h aby uzyskać pomoc");
                    }
                    workMode=WorkMode.Content;
                    break;

                case("-t"):
                    if(this.contains(args,"-t")>1 || this.contains(args,"-r")>0){
                        throw  new IllegalArgumentException(args[i] + " błędna składnia, wpisz -h aby uzyskać pomoc");
                    }
                    workMode=WorkMode.TableOfContent;
                    break;

                case("-a"):
                    if(this.contains(args,"-a")>1 ) {
                        throw new IllegalArgumentException(args[i] + " błędna składnia, wpisz -h aby uzyskać pomoc");
                    }
                    displayMode=DisplayMode.artykul;
                    i++;
                    arguments=arguments.concat(args[i]);
                    while(!args[i].startsWith("-") && i<args.length-1){
                        arguments=arguments.concat(" ");
                        i++;
                        arguments=arguments.concat(args[i]);
                    }
                    break;

                case("-b"):
                    if(this.contains(args,"-b")>1 ){
                        throw  new IllegalArgumentException(args[i] + " błędna składnia, wpisz -h aby uzyskać pomoc");
                    }
                    displayMode=DisplayMode.specyficzne;
                    i++;
                    arguments=arguments.concat(args[i]);
                    while(!args[i].startsWith("-") && i<args.length-1){
                        arguments=arguments.concat(" ");
                        i++;
                        arguments=arguments.concat(args[i]);
                    }
                    break;

                case("-c"):
                    if(this.contains(args,"-c")>1 ){
                        throw  new IllegalArgumentException(args[i] + " błędna składnia, wpisz -h aby uzyskać pomoc");
                    }
                    displayMode=DisplayMode.rozdzial;
                    i++;
                    arguments=arguments.concat(args[i]);
                    while(!args[i].startsWith("-") && i<args.length-1){
                        arguments=arguments.concat(" ");
                        i++;
                        arguments=arguments.concat(args[i]);
                    }
                    break;

                case("-d"):
                    if(this.contains(args,"-d")>1 || fileType==FileType.konstytucja){
                        throw  new IllegalArgumentException(args[i] + " błędna składnia, wpisz -h aby uzyskać pomoc");
                    }
                    displayMode=DisplayMode.dzial;
                    i++;
                    arguments=arguments.concat(args[i]);
                    while(!args[i].startsWith("-") && i<args.length-1){
                        arguments=arguments.concat(" ");
                        i++;
                        arguments=arguments.concat(args[i]);
                    }
                    break;

                default:
                    throw  new IllegalArgumentException(args[i] + " błędna składnia, wpisz -h aby uzyskać pomoc");
            }


        }
        if(fileType==null) throw  new IllegalArgumentException(" błędna składnia, nie wybrano typu pliku, wpisz -h aby uzyskać pomoc");
        return false;

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

    public void loadFile() throws FileNotFoundException{
        if(fileType==FileType.konstytucja){
            file= new Konstytucja();
        }
        else {
            file = new Uokik();
        }
        file.loadFile(fileName);
        try {
            file.loadIntoObjects();
        }catch (NumberFormatException ex){
                System.out.print(ex);
        }
    }
    public void view() throws IllegalArgumentException {
        switch (workMode) {
            case TableOfContent:
                file.view_spis();
                break;
            case Content:

                switch (displayMode) {
                    case artykul:
                        if(arguments.equals("")) {
                            file.view_a();
                        } else if (arguments.split("-").length == 1) {
                            file.view_a(arguments);
                        } else if (arguments.split("-").length == 2) {
                            String[] a = arguments.split("-");
                            file.view_a(a[0], a[1]);
                        }
                        break;

                    case specyficzne:
                        file.view_b(arguments);
                        break;
                    case rozdzial:
                        file.view_c(arguments);
                        break;
                    case dzial:
                        file.view_d( arguments);
                        break;
                    default:
                        throw  new IllegalArgumentException( " nie ustawiono wszystkich trybów");
                }
                break;
            default:
                throw  new IllegalArgumentException( " nie ustawiono wszystkich trybów");
        }
    }
}
