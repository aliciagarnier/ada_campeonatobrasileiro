package ada.campeonatobrasileiro.readers;
import ada.campeonatobrasileiro.repository.JogadorRepository;

import java.util.List;


public class LeitorGols extends AbstractReader {
    @Override
    protected void FilterReader(List<String> dados) {

        JogadorRepository jogadorRepository = JogadorRepository.getJogadorRepository();

        String nomeJogador = dados.get(3);
        String tipodeGol = dados.get(5);

        if (!jogadorRepository.existeJogador(nomeJogador))  {
            jogadorRepository.salvar(nomeJogador);
        }

        if (tipodeGol.equals("Gol Contra")) {
            jogadorRepository.obterJogador(nomeJogador).incrementarGolsContra();
        }
        else if (tipodeGol.equals("Penalty")) {
             jogadorRepository.obterJogador(nomeJogador).incrementarGolsPenaltis();
        } else {
           jogadorRepository.obterJogador(nomeJogador).incrementarGols();
        }
    }

}

