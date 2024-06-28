package list.Ordenacao.Pessoas;

import java.util.Comparator;

public class ComparatorPorAltura implements Comparator<Pessoa> {

  @Override
  public int compare(Pessoa p1, Pessoa p2) {
    // O retorno é int, independente se a classe do tipo da variável comparada for outra
    return Double.compare(p1.getAltura(), p2.getAltura());
  }
}
