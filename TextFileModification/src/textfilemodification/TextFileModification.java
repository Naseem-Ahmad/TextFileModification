
package textfilemodification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Naseem Ahmad
 */

public class TextFileModification {

    static void modifyFile(String filePath, String[] oldString, String newl)
    {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null; 
        FileWriter writer = null;
        try
        {
        reader = new BufferedReader(new FileReader(fileToBeModified));
        String line = reader.readLine();
        while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
    //    System.out.println(oldContent);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        int k=0;
        
        switch(newl.toLowerCase())
        {
            case "lower":
                k=ConvertLower(oldString,oldContent,filePath);
                break;
            
            case "upper":
                k=ConvertUpper(oldString,oldContent,filePath);
                break;
            
            case "title":
               k=ConvertTitle(oldString,oldContent,filePath);
                break;
        }
    System.out.print(k);
               
    }
    
    public static String convertToTitleCaseIteratingChars(String text) {
    if (text == null || text.isEmpty()) {
        return text;
    }

    StringBuilder converted = new StringBuilder();

    boolean convertNext = true;
    for (char ch : text.toCharArray()) {
        if (Character.isSpaceChar(ch)) {
            convertNext = true;
        } else if (convertNext) {
            ch = Character.toTitleCase(ch);
            convertNext = false;
        } else {
            ch = Character.toLowerCase(ch);
        }
        converted.append(ch);
    }

    return converted.toString();
}
    
   static int  ConvertLower(String[] oldString,String oldContent,String filePath){
      int counter=0;
       
        for (int i = 0; i < oldString.length; i++) {
            while(oldContent.indexOf(oldString[i])>-1){
                                counter=counter+1;
                String newString=oldString[i].toLowerCase();
                oldContent = oldContent.replaceFirst(oldString[i], newString);
            }
        }
        System.out.print("Convert to Lower ");
        
 try{
    FileWriter fw = new FileWriter(filePath,false); //the true will append the new data
    fw.write(oldContent);//appends the string to the file
    fw.close();
    }
catch(IOException ioe)
    {
    System.err.println("IOException: " + ioe.getMessage());
    }
        
    return counter;
  }  

  static int ConvertUpper(String[] oldString,String oldContent,String filePath){
  int counter=0;
       
        for (int i = 0; i < oldString.length; i++) {
            while(oldContent.indexOf(oldString[i])>-1){
                                counter=counter+1;
                String newString=oldString[i].toUpperCase();
                oldContent = oldContent.replaceFirst(oldString[i], newString);
            }
        }
        System.out.print("Convert to Upper "); 
 try{
    FileWriter fw = new FileWriter(filePath,false); //the true will append the new data
    fw.write(oldContent);//appends the string to the file
    fw.close();
    }
catch(IOException ioe)
    {
    System.err.println("IOException: " + ioe.getMessage());
    }                
  return counter;      
  }
  
  static int ConvertTitle(String[] oldString,String oldContent,String filePath){
  int counter=0;
       
        for (int i = 0; i < oldString.length; i++) {
            while(oldContent.indexOf(oldString[i])>-1){
                                counter=counter+1;
                String newString= convertToTitleCaseIteratingChars(oldString[i]);
                oldContent = oldContent.replaceFirst(oldString[i], newString);
            }
        }
        System.out.print("Convert to title "); 
 try{
    FileWriter fw = new FileWriter(filePath,false); //the true will append the new data
    fw.write(oldContent);//appends the string to the file
    fw.close();
    }
catch(IOException ioe)
    {
    System.err.println("IOException: " + ioe.getMessage());
    }        
  return counter;
  }
    
    
    public static void main(String[] args) {
    
    String[] arr={"One","Two","Hello"};
    String newl="lower";
    modifyFile("D:\\demo\\Demo.txt", arr , newl);
            
    }
    
}

