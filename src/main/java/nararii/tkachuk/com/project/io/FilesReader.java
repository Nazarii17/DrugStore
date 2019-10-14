package main.java.nararii.tkachuk.com.project.io;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesReader {

    private String fileName;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public ArrayList<String> getLinesFromFile(String filepath) {

        ArrayList<String> strings = new ArrayList<>();

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filepath);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {

                String lineFromFile = scanner.nextLine();

                strings.add(lineFromFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strings;
    }

    public ArrayList getObjectsfromFile(String filepath){
        ArrayList<String[]> listToReturn = new ArrayList<>();
        ArrayList <String> temporary = getLinesFromFile(filepath);
        for (int i = 0; i < temporary.size(); i++){
            String[] strings = temporary.get(i).split(",");
            listToReturn.add(strings);
        }
//        System.out.println(Arrays.toString(listToReturn.get(0)));
//        System.out.println(Arrays.toString(listToReturn.get(4)));
        return listToReturn;
    }
}


