package set.OperacoesBasicas.Convidados;
import java.util.Objects;

public class Convidado {
  // Atributos
  private String nome;
  private int codigoConvite;

  public Convidado(String nome, int codigoConvite) {
    this.nome = nome;
    this.codigoConvite = codigoConvite;
  }

  public String getNome() {
    return this.nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }
  
  public int getCodigoConvite() {
    return this.codigoConvite;
  }
  
  public void setCodigoConvite(int codigoConvite) {
    this.codigoConvite = codigoConvite;
  }
  
  @Override
  public String toString() {
    return "{" +
    " nome='" + getNome() + "'" +
    ", codigoConvite='" + getCodigoConvite() + "'" +
    "}";
  }
  
  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    } if (!(o instanceof Convidado)) {
        return false;
      }
      Convidado convidado = (Convidado) o;
      return getCodigoConvite() == convidado.getCodigoConvite();
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(getCodigoConvite());
  }
}
