package agh.FileSystem;

import java.io.FileNotFoundException;

interface FileToRead  {

    void loadFile(String fileName) throws FileNotFoundException;
    void loadIntoObjects();
    boolean isUpper(String x);
    void view_spis();
    void view_a();
    void view_a(String x);
    void view_a(String x,String y);
    void view_b(String x);
    void view_c(String x);
    void view_d(String x);
}
