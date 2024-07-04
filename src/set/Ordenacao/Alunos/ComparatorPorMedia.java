package set.Ordenacao.Alunos;

import java.util.Comparator;

public class ComparatorPorMedia implements Comparator<Aluno> {

  @Override
  public int compare(Aluno a1, Aluno a2) {
    return Double.compare(a1.getMedia(), a2.getMedia());
  }

}
