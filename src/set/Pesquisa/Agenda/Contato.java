package set.Pesquisa.Agenda;
import java.util.Objects;

public class Contato {
  private String nome;
  private int numero;

  public Contato(String nome, int numero) {
    this.nome = nome;
    this.numero = numero;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNumero() {
    return this.numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  @Override
  public String toString() {
    return "\n" + "{" +
      " nome='" + getNome() + "'" +
      ", numero='" + getNumero() + "'" +
      "}";
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Contato)) {
            return false;
        }
        Contato contato = (Contato) o;
        return numero == contato.numero;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numero);
  }
  
}
