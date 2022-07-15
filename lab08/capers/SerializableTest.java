package capers;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

class Deque implements Serializable {
    ArrayList<Integer> list;
}

public class SerializableTest {


    @Test
    public static void test1(String[] args) {
        Deque d = new Deque();
        File outFile = new File("save.txt");
        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(outFile));
            out.writeObject(d);
            out.close();
        } catch (IOException excp) {
            System.out.println(excp.getMessage());
        }
    }

    @Test
    public static void test2(String[] args) {
        Deque d;
        File inFile = new File("save.txt");
        try {
            ObjectInputStream inp =
                    new ObjectInputStream(new FileInputStream(inFile));
            d = (Deque) inp.readObject();
            inp.close();
        } catch (IOException | ClassNotFoundException excp) {
            d = null;
        }
    }
}
