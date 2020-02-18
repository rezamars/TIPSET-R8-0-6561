/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Grafik.Right;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Reza
 */
public class ReadFile {
    
    private Scanner scanner;
    private File file;
    private String s = "-1";
    private String[][] R8_0_27_Tables;
    private int rowNumber = -1;
    private int signNumber = -1;
    
    
    public ReadFile(Right right1){
        
        this.R8_0_27_Tables = right1.getSystemTables();
        
        for(int i = 0 ; i < 27 ; i++){
            for(int k = 0 ; k < 8 ; k++){
                 R8_0_27_Tables[i][k] = "";
            }
            
        }
        
    }
    
    public String[][] readFileFromTextFile(){
        
        file = new File("files\\R8-0-27.txt");
        
        try{
		scanner = new Scanner(file);
                System.out.println("Filen öppnades!");
                
                while(scanner.hasNext()){
                    
                    
                    for(int i = 0 ; i < 27 ; i++){
                        rowNumber++;
                        //System.out.println("Under i.");
                        for(int k = 0 ; k < 8 ; k++){
                            //System.out.println("Under k.");
                            signNumber++;
                            s = scanner.next();
                            //System.out.println("s=" + s);
                            R8_0_27_Tables[i][k] = s;
                            
                            
                            if(k == 7){
                                s = scanner.next();
                                s = scanner.next();
                                s = scanner.next();
                                s = scanner.next();
                                s = scanner.next();
                            }
                            
                        }
                    }
                    
                }
                
		for(int i = 0 ; i < 27 ; i++){
                    for(int k = 0 ; k < 8 ; k++){
                        if(R8_0_27_Tables[i][k].equalsIgnoreCase("1") || R8_0_27_Tables[i][k].equalsIgnoreCase("X") || 
                                R8_0_27_Tables[i][k].equalsIgnoreCase("2")){
                            //System.out.println("result, i= " + i + ", k= "+ R8_0_27_Tables[i][k]);
                        }
                        else{
                            //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        }
                    }
            
                }
                
                for(int x = 0 ; x < 13 ; x++){
                    
                    //System.out.println("result, " + x + ": "+ R8_0_27_Tables[25][x]);
                }
                
                /*
		while(scanner.hasNext()){
			
                    s = scanner.next();
			
		}
                */
                //close the scanner when finished
		scanner.close();
		System.out.println("Filen är stängd.");
	}
	catch(Exception e){
            System.out.println("Fil-laddning problem!");
            System.out.println(e.getMessage());
				
	}
        
        return R8_0_27_Tables;
    }
    
    
    
}
