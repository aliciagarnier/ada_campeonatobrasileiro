package ada.campeonatobrasileiro;

import ada.campeonatobrasileiro.repository.JogadorRepository;
import ada.campeonatobrasileiro.repository.PartidaRepository;
import ada.campeonatobrasileiro.repository.TimeRepository;
import ada.campeonatobrasileiro.readers.LeitorCartoes;
import ada.campeonatobrasileiro.readers.LeitorFull;
import ada.campeonatobrasileiro.readers.LeitorGols;
import ada.campeonatobrasileiro.readers.LeitorPartida;

public class Controller {
     private  JogadorRepository jogadorRepository = JogadorRepository.getJogadorRepository();
     private TimeRepository timeRepository = TimeRepository.getTimeRepository();
     private PartidaRepository partidaRepository = PartidaRepository.getPartidaRepository();
    private LeitorPartida leitorPartida = new LeitorPartida();
    private LeitorGols leitorGols = new LeitorGols();
    private LeitorCartoes leitorCartoes = new LeitorCartoes();

    private LeitorFull leitorFull = new LeitorFull();

    public void realizarLeituras() {
        leitorGols.LerArquivo("src/main/resources/campeonato-brasileiro-gols.csv");
        leitorCartoes.LerArquivo("src/main/resources/campeonato-brasileiro-cartoes.csv");
        leitorFull.LerArquivo("src/main/resources/campeonato-brasileiro-full.csv");
        leitorPartida.LerArquivo("src/main/resources/campeonato-brasileiro-full.csv");
    }

    public void obterEstatisticas () {

        System.out.println("------- Estatísticas do campeonato brasileiro de futebol --------");
        System.out.println();

        Estatistica.jogadorComMaiorNumeroDeGols(jogadorRepository);
        System.out.println();

        Estatistica.jogadorComMaiorNumeroDeGolsContra(jogadorRepository);
        System.out.println()
        ;
        Estatistica.jogadorComMaiorNumeroDeGolsPenaltis(jogadorRepository);
        System.out.println();

        Estatistica.jogadorComMaiorNumeroDeCartoesAmarelos(jogadorRepository);
        System.out.println();

        Estatistica.jogadorComMaiorNumeroDeCartoesVermelhos(jogadorRepository);
        System.out.println();

        Estatistica.EstadoComMenorQuantidadeDeJogosEntre2003e2023(partidaRepository);
        System.out.println();

        Estatistica.timeMaisVitoriosoNoAnoDe2008(partidaRepository);
        System.out.println();

        Estatistica.partidaComMaiorNumeroDeGols(partidaRepository);
        System.out.println();


        System.out.println("--------------------------------------------------------------");

    }




}
