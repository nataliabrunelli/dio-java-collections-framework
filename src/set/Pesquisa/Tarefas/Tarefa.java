package set.Pesquisa.Tarefas;
import java.util.Objects;

public class Tarefa {
  private String descricao;
  private boolean concluida;


  public Tarefa(String descricao) {
    this.descricao = descricao;
    this.concluida = false;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public boolean isConcluida() {
    return this.concluida;
  }

  public boolean getConcluida() {
    return this.concluida;
  }

  public void setConcluida(boolean concluida) {
    this.concluida = concluida;
  }


  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tarefa)) {
            return false;
        }
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(descricao, tarefa.descricao) && concluida == tarefa.concluida;
  }

  @Override
  public int hashCode() {
    return Objects.hash(descricao, concluida);
  }

  @Override
  public String toString() {
    return "{" +
      " descricao='" + getDescricao() + "'" +
      ", concluida='" + isConcluida() + "'" +
      "}";
  }  
}
