package set.OperacoesBasicas.Convidados;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
  private Set<Convidado> convidadosSet;

  public ConjuntoConvidados() {
    this.convidadosSet = new HashSet<>();
  }

  public void adicionarConvidado(String nome, int codigoConvite) {
    convidadosSet.add(new Convidado(nome, codigoConvite));
  }

  public void removerConvidadoPorCodigoConvite(int codigoConvite) {
    // Variável de controle
    Convidado convidadoParaRemover = null;
    if (!convidadosSet.isEmpty()) {
      for (Convidado c : convidadosSet) {
        if (c.getCodigoConvite() == codigoConvite) {
          convidadoParaRemover = c;
          break;
        }
      }
    }
    convidadosSet.remove(convidadoParaRemover);
  }

  public int contarConvidados() {
    return convidadosSet.size();
  }

  public void exibirConvidados() {
    System.out.println(convidadosSet);
  }

  public static void main(String[] args) {
    ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
    
    conjuntoConvidados.adicionarConvidado("Convidado 1", 1);
    conjuntoConvidados.adicionarConvidado("Convidado 2", 2);
    conjuntoConvidados.adicionarConvidado("Convidado 3", 2);
    conjuntoConvidados.adicionarConvidado("Convidado 4", 4);

    conjuntoConvidados.removerConvidadoPorCodigoConvite(2);
    
    System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados na lista.");
    conjuntoConvidados.exibirConvidados();
  }
}
