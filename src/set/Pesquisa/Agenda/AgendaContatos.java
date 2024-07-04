package set.Pesquisa.Agenda;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
  private Set<Contato> contatoSet;

  public AgendaContatos() {
    contatoSet = new HashSet<>();
  }

  public void adicionarContato(String nome, int numero) {
    this.contatoSet.add(new Contato(nome, numero));
  }

  public void exibirContatos() {
    System.out.println(contatoSet);
  }

  public Set<Contato> pesquisarPorNome(String nome) {
    Set<Contato> contatosPorNome = new HashSet<>();

    for (Contato c : contatoSet) {
      if (c.getNome().startsWith(nome)) {
        contatosPorNome.add(c);
      }
    }
    return contatosPorNome;
  }

  public Contato atualizarNumeroContato(String nome, int novoNumero) {
    Contato contatoAtualizado = null;

    for (Contato c : contatoSet) {
      if (c.getNome().equalsIgnoreCase(nome)) {
        c.setNumero(novoNumero);
        contatoAtualizado  = c;
        break;
      }
    }
    return contatoAtualizado;
  }

  public static void main(String[] args) {
    AgendaContatos agendaContatos = new AgendaContatos();

    agendaContatos.adicionarContato("Natalia", 1699558877);
    agendaContatos.adicionarContato("Natalia Brunelli", 1955883321);
    agendaContatos.adicionarContato("Fernanda", 1941365502);

    System.out.println(agendaContatos.pesquisarPorNome("Natalia"));
    agendaContatos.atualizarNumeroContato("Contato 3", 1699558877);

    agendaContatos.exibirContatos();
  }
}
