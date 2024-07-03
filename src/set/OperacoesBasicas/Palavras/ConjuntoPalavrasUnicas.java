package set.OperacoesBasicas.Palavras;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
  private Set<String> conjuntoPalavrasUnicas;

  public ConjuntoPalavrasUnicas() {
    this.conjuntoPalavrasUnicas = new HashSet<>();
  }
  
  public void adicionarPalavra(String palavra) {
    conjuntoPalavrasUnicas.add(palavra);
  }

  public void removerPalavra(String palavra) {
    for (String p : conjuntoPalavrasUnicas) {
      if (p.equalsIgnoreCase(palavra)) {
        conjuntoPalavrasUnicas.remove(p);
        break;
      }
    }
  }

  public void verificarPalavra(String palavra) {
    for (String p : conjuntoPalavrasUnicas) {
      if (p.equalsIgnoreCase(palavra)) {
        System.out.println("A palavra " + palavra + " está presente na lista.");
        break;
      } else {
        System.out.println("Palavra" + palavra + " não encontrada.");
        break;
      }
    }
  }

  public void exibirPalavrasUnicas() {
    System.out.println(conjuntoPalavrasUnicas);
  }


  public static void main(String[] args) {
    ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

    conjuntoPalavrasUnicas.adicionarPalavra("Cabide");
    conjuntoPalavrasUnicas.adicionarPalavra("Lâmpada");
    conjuntoPalavrasUnicas.adicionarPalavra("Cabide");
    conjuntoPalavrasUnicas.adicionarPalavra("Moto");
    conjuntoPalavrasUnicas.adicionarPalavra("Lâmpada");

    conjuntoPalavrasUnicas.removerPalavra("cabide");

    conjuntoPalavrasUnicas.verificarPalavra("Avião");
    conjuntoPalavrasUnicas.verificarPalavra("lâmpada");

    conjuntoPalavrasUnicas.exibirPalavrasUnicas();
  }
}
