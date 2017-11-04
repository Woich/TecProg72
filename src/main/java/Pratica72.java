
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica72 {
    public static void main(String[] args) {
        String endereco;
        ContadorPalavras contador;
        Scanner teclado = new Scanner(System.in);
        HashMap<String, Integer> palavras;
        
        System.out.println("Digite o caminho completo para o seu arquivos");
            endereco = teclado.next();
        
        contador = new ContadorPalavras(endereco);
        palavras = contador.getPalavras();
        
        List<Map.Entry<String, Integer>> listaPalavras = new ArrayList(palavras.entrySet());
        
        Collections.sort(listaPalavras, (o1, o2) -> -o1.getValue().compareTo(o2.getValue()));   
       
        endereco+=".out";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(endereco));
            
            for(Map.Entry<String, Integer> palavra: listaPalavras) {
                writer.write(palavra.getKey()+','+palavra.getValue());
                writer.newLine();
            }
        writer.close();
        } catch (IOException ex) {
            Logger.getLogger(ContadorPalavras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
