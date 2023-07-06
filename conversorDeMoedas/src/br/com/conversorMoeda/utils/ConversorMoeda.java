package br.com.conversorMoeda.utils;

/**
 * @author igorsssantana
 */
public class ConversorMoeda {
    /**
     * metodo que converte o
     * valor de reais para outra moeda
     * @param valor
     * @param valorConversao
     * @return valor convertido para outra moeda
     */
    public static double realParaOutraMoeda(double valor, double valorConversao) {
        return (valor / valorConversao);
    }
    
    /**
     * metodo que converte o
     * valor de outra moeda para reais
     * @param valor
     * @param valorConversao
     * @return valor convertido para real
     */
    public static double outraMoedaParaReal(double valor, double valorConversao) {
        return realParaOutraMoeda(valor, (1 / valorConversao));
    }
}
