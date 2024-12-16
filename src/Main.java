

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.util.*;




public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Input.txt");
        int sum = diagRightPart2(fileData);
        System.out.println(sum);




    }
    public static int diagRightPart2(ArrayList<String> data){
        int amt = 0;
        int leng = data.get(0).length();
        int lengData = data.size();


        for(int i = 0; i < leng-2; i++){
            for(int k = 0; k < lengData -2; k++){
                String word2 = "";
                word2 = data.get(k+2).substring(i,i+1) + data.get(k+1).substring(i+1,i+2) + data.get(k).substring(i+2,i+3);
                String word = data.get(k).substring(i,i+1) + data.get(k+1).substring(i+1,i+2) + data.get(k+2).substring(i+2,i+3);
                if((word.equals("MAS") || word.equals("SAM"))){

                    if( (word2.equals("MAS") || word2.equals("SAM"))) {
                        System.out.println(word + ' ' + word2);
                        amt++;
                    }
                }
            }
        }
        return amt;
    }
    public static int diagLeft(ArrayList<String> data){
        int amt = 0;
        int leng = data.get(1).length();
        for(int i = leng; i > 3; i--){
            for(int k = 0; k < data.size() -3; k++){
                String word = data.get(k).substring(i-1,i) + data.get(k+1).substring(i-2,i-1) + data.get(k+2).substring(i-3,i-2) + data.get(k+3).substring(i-4,i-3);
                if(word.equals("XMAS") || word.equals("SAMX")){
                    amt++;
                }
            }
        }




        return amt;
    }






    public static int diagRight(ArrayList<String> data){
        int amt = 0;
        int leng = data.get(1).length();
        int lengData = data.size();
        for(int i = 0; i < leng-3; i++){
            for(int k = 0; k < lengData -3; k++){
                String word = data.get(k).substring(i,i+1) + data.get(k+1).substring(i+1,i+2) + data.get(k+2).substring(i+2,i+3) + data.get(k+3).substring(i+3,i+4);
                if(word.equals("XMAS") || word.equals("SAMX")){
                    amt++;
                }
            }
        }




        return amt;
    }










    public static int searchRight(String data){
        int amt = 0;
        while(data.contains("XMAS")){
            if(data.indexOf("XMAS") == 0){
                data = data.substring(1);
                amt++;
            } else {
                data = data.substring(data.indexOf("XMAS"));
            }
        }
        return amt;
    }




    public static int SearchUp(ArrayList<String> data){
        int amt =0;
        int length = data.get(0).length();
        for(int i = 0; i < length; i++){
            for(int k = 0; k < data.size() -3; k++){
                String word = data.get(k).substring(i,i+1) + data.get(k+1).substring(i,i+1) + data.get(k+2).substring(i,i+1) + data.get(k+3).substring(i,i+1);
                if(word.equals("XMAS")){
                    amt++;
                }
            }
        }




        return amt;
    }




    public static int SearchDown(ArrayList<String> data){
        int amt =0;
        int length = data.get(0).length();
        for(int i = 0; i < length; i++){
            for(int k = 0; k < data.size() -3; k++){
                String word = data.get(k).substring(i,i+1) + data.get(k+1).substring(i,i+1) + data.get(k+2).substring(i,i+1) + data.get(k+3).substring(i,i+1);
                if(word.equals("SAMX")){
                    amt++;
                }
            }
        }




        return amt;
    }




    public static int searchLeft(String data){
        int amt = 0;
        while(data.contains("SAMX")){
            if(data.indexOf("SAMX") == 0){
                data = data.substring(1);
                amt++;
            } else {
                data = data.substring(data.indexOf("SAMX"));
            }
        }
        return amt;
    }




    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}



