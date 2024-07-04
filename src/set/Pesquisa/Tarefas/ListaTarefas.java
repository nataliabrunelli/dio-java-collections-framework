package set.Pesquisa.Tarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
  private Set<Tarefa> tarefaSet;


  public ListaTarefas() {
    this.tarefaSet = new HashSet<>();
  }

  public void adicionarTarefa(String descricao) {
    this.tarefaSet.add(new Tarefa(descricao));
  }

  public void removerTarefa(String descricao) {
    if (! tarefaSet.isEmpty()) {
      for (Tarefa t : tarefaSet) {
        if (t.getDescricao().equalsIgnoreCase(descricao)) {
          this.tarefaSet.remove(t);
          System.out.println("Tarefa " + t + " removida com sucesso");
          break;
        }
      }
    }
  }

  public void exibirTarefas() {
    System.out.println(tarefaSet);
  }

  public int contarTarefas() {
    return this.tarefaSet.size();
  }

  public Set<Tarefa> obterTarefasConcluidas() {
    Set<Tarefa> tarefasConcluidas = new HashSet<>();

    for (Tarefa t : tarefaSet) {
      if (t.getConcluida() == true) {
        tarefasConcluidas.add(t);
      }
    }
    return tarefasConcluidas;
  }

  public Set<Tarefa> obterTarefasPendentes() {
    Set<Tarefa> tarefasPendentes = new HashSet<>();

    for (Tarefa t : tarefaSet) {
      if (t.getConcluida() == false) {
        tarefasPendentes.add(t);
      }
    }
    return tarefasPendentes;
  }

  public void marcarTarefaConcluida(String descricao) {
    for (Tarefa t : tarefaSet) {
      if (t.getDescricao().equalsIgnoreCase(descricao)) {
        t.setConcluida(true);
        System.out.println("Tarefa concluída com sucesso.");
      }
    }
  }

  public void marcarTarefaPendente(String descricao) {
    for (Tarefa t : tarefaSet) {
      if (t.getDescricao().equalsIgnoreCase(descricao)) {
        t.setConcluida(false);
        System.out.println("Tarefa pendente.");
      }
    }
  }

  public void limparListaTarefas() {
    this.tarefaSet.removeAll(tarefaSet);
    System.out.println("Lista de tarefas vazia.");
  }

  public static void main(String[] args) {
    ListaTarefas listaTarefas = new ListaTarefas();

    listaTarefas.adicionarTarefa("Lavar a louça");
    listaTarefas.adicionarTarefa("Varrer a casa");
    listaTarefas.adicionarTarefa("Lavar o quintal");
    listaTarefas.adicionarTarefa("Lavar o quintal");
    listaTarefas.adicionarTarefa("Passear com os cachorros");

    listaTarefas.marcarTarefaConcluida("lavar a louça");
    listaTarefas.marcarTarefaConcluida("passear com os cachorros");
    System.out.println(listaTarefas.obterTarefasConcluidas());
    System.out.println(listaTarefas.obterTarefasPendentes());

    // listaTarefas.removerTarefa("lavar o quintal");
    // System.out.println(listaTarefas.contarTarefas());
    // listaTarefas.exibirTarefas();
  }
}
