package compilador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Leitor{
    public static void main(String[] args) {
        String filename = args[0]; // 

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // You can process the line here
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}