package capers;

import capers.Utils;

import java.io.File;

public class FileOperate {
    public static void main(String[] args) throws Exception {
        File f = new File("dummy.txt");
        f.createNewFile();
        System.out.println(f.exists());
        Utils.writeContents(f, "Hello World");

        File d = new File("dummy");
        d.mkdir();
    }
}
