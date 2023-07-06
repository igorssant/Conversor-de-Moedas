package br.com.conversorMoeda.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LidarComArquivo{
    /*
    * As duas constantes abaixo devem conter o caminho absoluto
    * do projeto java em seu computador.
    * Senao, nao sera possivel lidar com entrada e saida
    * de dados.
    */
    final private static String caminhoLeitura = "src/br/com/conversorMoeda/arquivos/valorDasMoedas.txt";
    private static File arquivo = null;
    
    /**
     * Esse metodo nao recebe nenhum parametro.
     * Esse metodo retorna o conteudo contido no arquivo.
     * @return linhaQueFoiLida
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static ArrayList<String> lerDeArquivo() throws FileNotFoundException, IOException{
        Scanner leituraDeArquivo;
        ArrayList<String> linhaQueFoiLida;
        
        arquivo = new File(caminhoLeitura);
        leituraDeArquivo = new Scanner(arquivo);
        linhaQueFoiLida = new ArrayList<>();
        
        while(leituraDeArquivo.hasNextLine()){
            linhaQueFoiLida.add(leituraDeArquivo.nextLine());
        }
        
        leituraDeArquivo.close();
        arquivo = null;
        return linhaQueFoiLida;
    }
}
