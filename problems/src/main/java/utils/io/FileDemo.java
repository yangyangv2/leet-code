package utils.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDemo {


    public static void main(String[] args) {

        try(BufferedReader br = Files.newBufferedReader(Paths.get("src/test/resources/io/file.txt"));
            BufferedWriter bw = Files.newBufferedWriter(Paths.get("src/test/resources/io/file.out"))
        ){
            String line = null;
            while ((line = br.readLine()) != null){
                bw.write(line);
            }
            Files.delete(Paths.get("src/test/resources/io/file.out"));
        }catch(IOException ioe){

        }

    }
}
