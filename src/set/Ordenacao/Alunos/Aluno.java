package set.Ordenacao.Alunos;
import java.util.Objects;

public class Aluno implements Comparable<Aluno> {
  private String nome;
  private int matricula;
  private double media;


  public Aluno(String nome, int matricula, double media) {
    this.nome = nome;
    this.matricula = matricula;
    this.media = media;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getMatricula() {
    return this.matricula;
  }

  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }

  public double getMedia() {
    return this.media;
  }

  public void setMedia(double media) {
    this.media = media;
  }


  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aluno)) {
            return false;
        }
        Aluno aluno = (Aluno) o;
        return this.matricula == aluno.matricula;
  }

  @Override
  public int hashCode() {
    return Objects.hash(matricula);
  }

  @Override
  public String toString() {
    return "{" +
      " nome='" + getNome() + "'" +
      ", matricula='" + getMatricula() + "'" +
      ", mota='" + getMedia() + "'" +
      "}";
  }

  @Override
  public int compareTo(Aluno a) {
    return nome.compareToIgnoreCase(a.getNome());
  }  
}
