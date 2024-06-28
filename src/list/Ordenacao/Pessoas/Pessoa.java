package list.Ordenacao.Pessoas;

public class Pessoa implements Comparable<Pessoa> {
  private String nome;
  private int idade;
  private double altura;

  public Pessoa(String nome, int idade, double altura) {
    this.nome = nome;
    this.idade = idade;
    this.altura = altura;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return this.idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public double getAltura() {
    return this.altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  @Override
  public String toString() {
    return "{" +
      " nome='" + getNome() + "'" +
      ", idade='" + getIdade() + "'" +
      ", altura='" + getAltura() + "'" +
      "}";
  }

  @Override
  public int compareTo(Pessoa p) {
    return Integer.compare(idade, p.getIdade());    
  }
}
