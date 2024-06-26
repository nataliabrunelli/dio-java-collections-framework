package list.OperacoesBasicas.ListaDeTarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
  //Lista de tarefas como atributo
  private List<Tarefa> listaTarefa; //Tarefa é passado como parâmetro genérico de List

  //Construtor
  public ListaTarefa() {
    this.listaTarefa = new ArrayList<>();
  }

  public void adicionarTarefa(String descricao) {
    listaTarefa.add(new Tarefa(descricao));
  }

  public void removerTarefa(String descricao) {
    List<Tarefa> tarefasParaRemover = new ArrayList<>();

    for (Tarefa t : listaTarefa) {
      if (t.getDescricao() == descricao) {
        tarefasParaRemover.add(t);
      }
    }

    listaTarefa.removeAll(tarefasParaRemover);
  }

  public int obterNumeroTotalTarefas() {
    return listaTarefa.size();
  }

  public void obterDescricoesTarefas() {
    System.out.println(listaTarefa);
  }

  //Testando com o main
  public static void main(String[] args) {
    ListaTarefa listaTarefa = new ListaTarefa();

    listaTarefa.adicionarTarefa("Tarefa 1");
    listaTarefa.adicionarTarefa("Tarefa 2");
    listaTarefa.adicionarTarefa("Tarefa 3");

    listaTarefa.removerTarefa("Tarefa 1");
    
    System.out.println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());
    listaTarefa.obterDescricoesTarefas();
  }
}
