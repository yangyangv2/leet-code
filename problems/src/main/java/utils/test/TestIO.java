package utils.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestIO {

    public static void main(String[] args) throws IOException {


        Path readPath = Paths.get("src/test/resources/io/file.txt");

        System.out.println(readPath.toFile().getAbsolutePath());

        List<String> lines = Files.readAllLines(readPath);

        try(BufferedReader br = Files.newBufferedReader(readPath)){
            String line = null;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
    }
}
