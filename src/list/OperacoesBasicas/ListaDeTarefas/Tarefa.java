package list.OperacoesBasicas.ListaDeTarefas;

public class Tarefa {
  //Atributo
  private String descricao;

  public Tarefa(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  @Override
  public String toString() {
    return "{" +
      " descricao='" + getDescricao() + "'" +
      "}";
  }
}
