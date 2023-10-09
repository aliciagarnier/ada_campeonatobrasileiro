package ada.campeonatobrasileiro.readers;
import ada.campeonatobrasileiro.repository.JogadorRepository;
import java.util.List;

public class LeitorCartoes extends AbstractReader {
    @Override
    protected void FilterReader(List<String> dados) {
        JogadorRepository jogadorRepository = JogadorRepository.getJogadorRepository();
        String tipoDoCartao = dados.get(3);
        String nomeJogador = dados.get(4);

        if (!jogadorRepository.existeJogador(nomeJogador))
        {
            jogadorRepository.salvar(nomeJogador);
        }

        if (tipoDoCartao.equals("Amarelo"))
        {
            jogadorRepository.obterJogador(nomeJogador).incrementarCartoesAmarelos();
        } else if (tipoDoCartao.equals("Vermelho"))
        {
            jogadorRepository.obterJogador(nomeJogador).incrementarCartoesVermelhos();
        }
    }

}



