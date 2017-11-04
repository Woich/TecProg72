/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author woich
 */
public class ContadorPalavras {
    
    private BufferedReader reader;
    private String path;
    private int numRepet;
    
    public ContadorPalavras(String path){
        try{
            this.reader = new BufferedReader(new FileReader(path));
            this.path = path;
        }
        catch(FileNotFoundException ex){
            Logger.getLogger(ContadorPalavras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public HashMap<String, Integer>getPalavras(){
        HashMap<String, Integer>palRepet = new HashMap<>();
        String palAvaliada = "";
        String linAtual;
        int cont=0;
        
        try{
            while((linAtual = reader.readLine()) != null){
                cont=0;
                while(cont<linAtual.length()){
                    
                    while(cont<linAtual.length() && linAtual.charAt(cont)!= ' '){
                    
                        if(linAtual.charAt(cont)== '.' || linAtual.charAt(cont)== ','){
                            break;
                        }
                        
                        palAvaliada+=linAtual.charAt(cont);
                        cont++;
                        
                    }
                    if(!palAvaliada.equals("")){
                        if(palRepet.containsKey(palAvaliada)){
                            numRepet = palRepet.get(palAvaliada);
                            palRepet.put(palAvaliada, numRepet+1);
                        }
                        else{
                            palRepet.put(palAvaliada, 1);
                        }
                    }
                    cont++;
                    palAvaliada = "";
                    
                }
            }
        }
        catch (IOException ex) {
            Logger.getLogger(ContadorPalavras.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return palRepet;
        
    }
    
}
