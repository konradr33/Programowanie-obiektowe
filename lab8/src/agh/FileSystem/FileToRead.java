package agh.FileSystem;

import java.io.FileNotFoundException;

interface FileToRead  {

    void loadFile(String fileName) throws FileNotFoundException;
    void loadIntoObjects();
}
