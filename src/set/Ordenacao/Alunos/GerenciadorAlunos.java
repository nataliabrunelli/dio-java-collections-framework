package set.Ordenacao.Alunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
  private Set<Aluno> alunoSet;

  public GerenciadorAlunos() {
    this.alunoSet = new HashSet<>();
  }

  public void adicionarAluno(String nome, int matricula, double media) {
    alunoSet.add(new Aluno(nome, matricula, media));
  }

  public void removerAluno(int matricula) {
    if (!alunoSet.isEmpty()) {
      for (Aluno a : alunoSet) {
        if (a.getMatricula() == matricula) {
          alunoSet.remove(a);
          break;
        }
      }
    }
  }

  public Set<Aluno> exibirAlunosPorNome() {
    Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet); 

    return alunosPorNome;
  }

  public Set<Aluno> exibirAlunosPorNota() {
    Set<Aluno> alunoPorNota = new TreeSet<>(new ComparatorPorMedia());
    alunoPorNota.addAll(alunoSet);
    return alunoPorNota;
  }

  public Set<Aluno> exibirAlunos() {
    return alunoSet;
  }


  public static void main(String[] args) {
    GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

    gerenciadorAlunos.adicionarAluno("Natalia", 111, 9.5);
    gerenciadorAlunos.adicionarAluno("Fernanda", 112, 10.0);
    gerenciadorAlunos.adicionarAluno("João", 131, 5.5);
    gerenciadorAlunos.adicionarAluno("Pedro", 222, 7.8);

    // System.out.println(gerenciadorAlunos.exibirAlunos());
    // System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
    gerenciadorAlunos.removerAluno(131);
    System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
  }
}
