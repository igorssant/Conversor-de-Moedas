package br.com.conversorMoeda.utils;

import javax.swing.JOptionPane;

/**
 * @author igorsssantana
 */
public class Moedas {
    /**
     * metodo para recebe do usuario qual moeda sera utilizada
     * e retorna sua posicao no vetor de String
     * @param LISTA_MOEDAS
     * @return qual a posicao da moeda que sera utilizada para conversao
     */
    public static int moedaParaConversao(final String [] LISTA_MOEDAS) {
        String moeda = "";
        int opcaoMoeda = 0;
        
        moeda = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma das moedas abaixo:",
                "Moedas suportadas",
                JOptionPane.PLAIN_MESSAGE,
                null,
                LISTA_MOEDAS,
                LISTA_MOEDAS[0]
        );
        
        switch(moeda){
            case "Dolar":
                opcaoMoeda = 0;
                break;
            
            case "Euro":
                opcaoMoeda = 1;
                break;
                
            case "Libra":
                opcaoMoeda = 2;
                break;
                
            case "Peso Argentino":
                opcaoMoeda = 3;
                break;
            case "Peso Chileno":
                opcaoMoeda = 4;
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!\nPor favor, tente novamente.");
        }
        
        return opcaoMoeda;
   } 
}
