package br.com.fesa.ordenarparenteses;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Principal {
    
    public static void main(String args[]) throws Exception {
        String path = "H:\\Area de Trabalho\\Java_Aula\\OrdenarParenteses\\dados.txt";

        leitor(path);

    }

    public static void leitor(String path) throws Exception {
        Boolean valid = true;
        
        Stack<Character> stack;
        List<String> Retorno = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new FileReader(path));
        String linha = br.readLine();
        while (linha != null) {
            stack = new Stack<>();
            valid = true;
            for (char letra : linha.toCharArray()) {
               
                if (letra == '('
                 || letra == '{'
                 || letra == '['
                 || letra == '<') {

                    stack.push(letra);
                } else {
                    if (stack.empty()) {
                        valid = false;
                       
                    } else {
                        if (letra == ')' && stack.peek() != '(') {
                            valid = false;
                        } else if (letra == '}' && stack.peek() != '{') {
                            valid = false;
                        } else if (letra == ']' && stack.peek() != '[') {
                            valid = false;
                        } else if (letra == '>' && stack.peek() != '<') {
                            valid = false;
                            break;
                        } else {
                            stack.pop();
                        }
                    }
                }
            }
           
            if (valid) {
                Retorno.add(linha + " - Correto");
            } else {
                Retorno.add(linha + " - Incorreto");
            }
            linha = br.readLine();
        }
        OutputStreamWriter bf = new OutputStreamWriter(new FileOutputStream("dadosValidados.txt"), "UTF-8");

        for (String palavra : Retorno) {
            bf.write(palavra + "\n");
        }
        bf.close();

    }
    
}
