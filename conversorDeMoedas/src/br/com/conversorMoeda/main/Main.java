package br.com.conversorMoeda.main;

import br.com.conversorMoeda.utils.ConversorMoeda;
import br.com.conversorMoeda.utils.LidarComArquivo;
import br.com.conversorMoeda.utils.Moedas;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author igorsssantana
 */
public class Main {
    private static final String [] LISTA_MOEDAS = {"Dolar", "Euro", "Libra", "Peso Argentino", "Peso Chileno", "Real"};
    
    /**
     * metodo para imprimir
     * o resultado final da conversao
     * seja de real para outro
     * ou
     * ou otro para real
     * @param valorConvertidoFinal
     * @param qualMoeda 
     */
    public static void imprimeResultadoFinal(double valorConvertidoFinal, int qualMoeda){
        JOptionPane.showMessageDialog(
                null,
                "O valor final, após conversão, é de $ " + String.format("%.2f", valorConvertidoFinal) + " " + LISTA_MOEDAS[qualMoeda] + "(s)"
        );
    }
    
    /**
     * metodo que converte
     * o valor de real
     * para outra moeda
     */
    public static void realParaOutraMoeda(ArrayList<String> valores) {
        double valorEmReais = 0f,
            valorConvertidoFinal = 0f;
        int opcaoMoeda = 0;
        try {
            valorEmReais = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantia (em Reais):"));
            
            if(valorEmReais < 0.0){
                throw new IllegalArgumentException("Valor inválido");
            }
            
            opcaoMoeda = Moedas.moedaParaConversao(LISTA_MOEDAS);
            valorConvertidoFinal = ConversorMoeda.realParaOutraMoeda(valorEmReais, Double.parseDouble(valores.get(opcaoMoeda)));
            imprimeResultadoFinal(valorConvertidoFinal, opcaoMoeda);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite somente números.\nUse ponto ao invés de vígura para serarar as casas decimais.");
        } catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * metodo que converte
     * o valor de outra moeda
     * para real
     */
    public static void outraMoedaParaReal(ArrayList<String> valores) {
        double valorEmOutraMoeda = 0f,
            valorEmReaisFinal = 0f;
        int opcaoMoeda = Moedas.moedaParaConversao(LISTA_MOEDAS);
        
        try {
            valorEmOutraMoeda = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantia (em ") + LISTA_MOEDAS[opcaoMoeda] + "):");
            
            if(valorEmOutraMoeda < 0.0){
                throw new IllegalArgumentException("Valor inválido");
            }
            
            valorEmReaisFinal = ConversorMoeda.outraMoedaParaReal(valorEmOutraMoeda, Double.parseDouble(valores.get(opcaoMoeda)));
            imprimeResultadoFinal(valorEmReaisFinal, opcaoMoeda);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite somente números.\nUse ponto ao invés de vígura para serarar as casas decimais.");
        } catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * metodo para receber o tipo
     * de conversao de moeda do
     * usuario
     * @return tipo de conversao de moeda
     */
    public static int menu() {
        final String [] escolhaConversao = {"Converter de Real para outra moeda",
                                            "Converter de outra moeda para Real"};
        String escolhaFeita = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma das opções abaixo",
                "Conversor de moedas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                escolhaConversao,
                escolhaConversao[0]
        );
        
        switch(escolhaFeita) {
            case "Converter de Real para outra moeda":
                return 1;
            
            case "Converter de outra moeda para Real":
                return 2;
                
            default:
                return 0;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> valoresConversao = new ArrayList<>();
        int opcao = 0;
        
        try {
            valoresConversao = LidarComArquivo.lerDeArquivo();
        } catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o arquivo no caminho passado!");
        } catch(IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível carregar os valores de conversão de moedas!");
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a leitura do arquivo!\nErro de conversão de tipos.");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!");
        }
        
        while(true) {
            try {
                opcao = menu();
                
                if(opcao == 1){
                    realParaOutraMoeda(valoresConversao);
                } else {
                    outraMoedaParaReal(valoresConversao);
                }
                
            } catch(RuntimeException e) {
                break;
            }
        } // FIM DO WHILE
    } // FIM DA MAIN
}
