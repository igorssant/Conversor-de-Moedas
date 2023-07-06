# Conversor-de-Moedas

## Descrição
Este é um programa implementado em Java que converte valores entre seis diferentes moedas.
Ele oferece uma interface (GUI) de menu para que o usuário consiga selecionar, de forma simples, a conversão desejada.
São solicitados do usuário os valores necessários para realizar a conversão.

## Funcionalidades
- Conversão de Real para Dólar;
- Conversão de Real para Euro;
- Conversão de Real para Libras Esterlinas;
- Conversão de Real para Peso Argentino;
- Conversão de Real para Peso Chileno;
- Conversão de Dólar para Real;
- Conversão de Euro para Real;
- Conversão de Libras Esterlinas para Real;
- Conversão de Peso argentino para Real; e
- Conversão de Peso Chileno para Real.

## Utilização
Ao iniciar, o programa irá apresentar ao usuário as opções
- Converter de Real para outra moeda; e
- Converter de outra moeda para Real.
Se a primeira opção for selecionada, o programa irá apresentar um menu onde o usuário deverá entrar com o valor em reais (R$), onde a casa decimal deverá ser sinalizada por ponto ao invés de virgula. Por fim, será apresentado ao usuário seis opções de moeda, onde ele poderá selecionar uma para efetuar a conversão. Aṕos a seleção, o valor convertido será apresentado.
Se a segunda opção for selecionada, o programa irá apresentar um menu onde o usuário deverá selecionar uma dentre seis moedas suportadas. Após a seleção da moeda, será apresentada ao usuário um diálogo onde ele deverá entrar com a quantidade da moeda selecionada anteriormente. Ao final da operação, será apresentado ao usuário o valor em reais (R$), pós conversão.

## Requisitos
Java Development Kit (JDK) instalado.
Versão 8 ou superior.

## Limitações
- O programa não considera taxas de conversão atualizadas em tempo real;
- As taxas de conversão utilizadas são fixas e podem não refletir os valores reais;
- Ao fornecer um valor inválido, o programa exibirá uma mensagem de erro e retornará à tela inicial; e
- O programa utiliza caixas de diálogo do javax.swing para exibir mensagens e obter valores do usuário, sendo necessário executar o programa em um ambiente que suporte a interface gráfica Swing.
