package ru.spbstu.telematics.java;

import java.io.FileWriter;
import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try{
	        FileReWriter f = new FileReWriter("text.txt");
	        f.writeToFile("Hello World!");
	        Double d = 5.12345;
	        f.writeToFile(d,'a');
	        f.saveFile();
        } catch (IOException e){
        	e.printStackTrace();
        }
    }
}

class FileReWriter{
	
	private FileWriter fileobject = null;
	
	FileReWriter(){
		
	}
	
	FileReWriter(String filename) throws IOException{
		this.fileobject = new FileWriter(filename);
	}
	
	void openFile(String filename) throws IOException{
		this.fileobject = new FileWriter(filename);
	}
	
	void writeToFile(Object data) throws IOException{
		this.fileobject.write(data.toString());
	}
	
	void writeToFile(Object data, char mode) throws IOException{
		switch(mode){
		case 'w': this.writeToFile(data);
		case 'a': this.fileobject.append(data.toString());
		}
	}
	
	void saveFile() throws IOException{
		this.fileobject.close();
	}
}

