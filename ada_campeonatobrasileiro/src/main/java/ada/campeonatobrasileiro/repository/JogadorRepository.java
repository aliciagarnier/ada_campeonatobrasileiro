package ada.campeonatobrasileiro.repository;

import ada.campeonatobrasileiro.domain.Jogador;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;

public class JogadorRepository {

    private static final JogadorRepository jogadorRepository = new JogadorRepository();
    private final Map<String, Jogador> jogadores = new HashMap<>();
    public static JogadorRepository getJogadorRepository () {
        return jogadorRepository;
    }

    public void salvar (String nome) {
        Jogador novoJogador = new Jogador(nome);
        jogadores.put(nome, novoJogador);
    }
    public List<Jogador> listarJogadores () {

        return new ArrayList<>(jogadores.values());
    }
  public void printarJogadores() {
        Consumer<Jogador> printarJogador = jogador -> System.out.println(jogador.toString());
        listarJogadores().stream().forEach(printarJogador);
  }
  public Jogador obterJogador (String nome) {
      return jogadores.get(nome);
  }
  public boolean existeJogador(String nome) {
        return jogadores.get(nome) != null;
  }





}
