package co.songliao.pascalscanner;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by liaosong on 2018/2/23.
 */

public class ScannerTest {

    private String directory = "E:\\PascalScanner\\app\\src\\test\\java\\co\\songliao\\pascalscanner\\";


    @Test
    public void main(){

        SimpleScanner ss = new SimpleScanner("f = 17*bar while");
        //java.util.Scanner ss = new java.util.Scanner("foo = 17+bar");
        Token t = ss.nextToken();
        while( t != null){
            System.out.println("Token is " + t.type + " : " + t.lexeme);
            t = ss.nextToken();
        }
    }


    @Test
    public void testGoodComment(){
        setUpScanner("comment_good.pas");
    }

    @Test
    public void testCommentError(){
        setUpScanner("comment_error.pas");
    }

    @Test
    public void testSimplePas() {
        setUpScanner("test1.pas");
    }

    //helper method
    private void setUpScanner(String filename) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(
                    this.directory + filename))));
            StringBuilder message = new StringBuilder();
            String line = null;

            while((line = bufferedReader.readLine()) != null) {
                message.append(line);
            }

            SimpleScanner ss = new SimpleScanner(message.toString());
            Token t = ss.nextToken();
            while( t != null){
                System.out.println("Token is " + t.type + " : " + t.lexeme);
                t = ss.nextToken();
            }
            System.out.println("=====END====");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
