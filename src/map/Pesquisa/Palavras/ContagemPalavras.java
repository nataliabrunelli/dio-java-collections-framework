package map.Pesquisa.Palavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
  private Map<String, Integer> palavrasMap;


  public ContagemPalavras() {
    this.palavrasMap = new HashMap<>();
  }
  
  public void adicionarPalavra(String palavra, Integer contagem) {
    palavrasMap.put(palavra, contagem);
  }

  public void removerPalavra(String palavra) {
    if (!palavrasMap.isEmpty()) {
      palavrasMap.remove(palavra);
    }
  }

  public void exibirContagemPalavras() {
    System.out.println(palavrasMap);
  }

  public Map<String, Integer> encontrarPalavraMaisFrequente() {
    String palavraMaisFrequente = null;
    int frequenciaPalavra = 0;

    // Usando os métodos .entrySet e .Entry para acessar o par chave-valor de Map:
    if (!palavrasMap.isEmpty()) {
      for (Map.Entry<String, Integer> p : palavrasMap.entrySet()) {
        if (p.getValue() > frequenciaPalavra) {
          frequenciaPalavra = p.getValue();
          palavraMaisFrequente = p.getKey();
        }
      }      
    }

    Map<String, Integer> maisFrequenteMap = new HashMap<>();
    maisFrequenteMap.put(palavraMaisFrequente, frequenciaPalavra);

    return maisFrequenteMap;
  }

  public static void main(String[] args) {
    
    ContagemPalavras contagemPalavras = new ContagemPalavras();

    contagemPalavras.adicionarPalavra("Palavra 1", 1);
    contagemPalavras.adicionarPalavra("Palavra 2", 5);
    contagemPalavras.adicionarPalavra("Palavra 3", 4);
    contagemPalavras.adicionarPalavra("Palavra 4", 2);

    contagemPalavras.removerPalavra("Palavra 2");
    // contagemPalavras.exibirContagemPalavras();
    System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());

  }
}
