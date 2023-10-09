package ada.campeonatobrasileiro;
import ada.campeonatobrasileiro.repository.JogadorRepository;
import ada.campeonatobrasileiro.repository.PartidaRepository;
import ada.campeonatobrasileiro.domain.Jogador;
import ada.campeonatobrasileiro.domain.Partida;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class Estatistica {

    public static void timeMaisVitoriosoNoAnoDe2008(PartidaRepository partidaRepository) {
        Year anoAlvo = Year.parse("2008");
        List<String> timeMaisVitorioso;
        Optional<Long> maiorNumeroVitorias;

        List<Partida> partidas = partidaRepository.listarPartidas();

        Map<String, Long> contagemVitoriasPorTime = partidas.stream()
                .filter(partida -> partida.getAnoPartida().equals(anoAlvo))
                .filter(partida -> partida.getVencedor() != null)
                .collect(Collectors.groupingBy(
                        partida -> partida.getVencedor().nome(),
                        Collectors.counting()));


        List<Long> contagens = new ArrayList<>(contagemVitoriasPorTime.values());
        maiorNumeroVitorias = contagens.stream().max(Comparator.naturalOrder());

        if (maiorNumeroVitorias.isPresent()) {
            timeMaisVitorioso = contagemVitoriasPorTime.entrySet().stream()
                    .filter(entry -> entry.getValue().equals(maiorNumeroVitorias.get()))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            System.out.println("Time mais vitorioso em " + anoAlvo + ": " + timeMaisVitorioso);
            System.out.println("Número de vitórias: " + maiorNumeroVitorias.get());
        }

    }

    public static void partidaComMaiorNumeroDeGols(PartidaRepository partidaRepository) {
        List<Partida> partidas = partidaRepository.listarPartidas();
        partidas.stream().max(Comparator.comparingInt(p -> p.getPlacarMandante() + p.getPlacarVisitante())).
                ifPresent(partidaComMaisGols -> System.out.println("Placar da partida com mais gols: " +
                        partidaComMaisGols.getTimeMandante().nome() + " " +
                        partidaComMaisGols.getPlacarMandante() + " x " +
                        partidaComMaisGols.getPlacarVisitante() + " " +
                        partidaComMaisGols.getTimeVisitante().nome()));
    }
    public static void EstadoComMenorQuantidadeDeJogosEntre2003e2023(PartidaRepository partidaRepository) {
        Year anoInicial = Year.of(2003);
        Year anoFinal = Year.of(2022);
        String estadoComMenosJogos = null;
        long menorQuantidadeJogos = Long.MAX_VALUE;

        List<Partida> partidas = partidaRepository.listarPartidas();
        Map<String, Long> contagemPorEstado = partidas.stream()
                .filter(partida -> {
                    Year anoPartida = Year.from(partida.getAnoPartida());
                    return !anoPartida.isBefore(anoInicial) && !anoPartida.isAfter(anoFinal);
                }).collect(Collectors.groupingBy(
                        partida -> partida.getTimeMandante().estado().nome(),
                        Collectors.counting()
                ));

        for (Map.Entry<String, Long> entry : contagemPorEstado.entrySet()) {
            if (entry.getValue() < menorQuantidadeJogos) {
                estadoComMenosJogos = entry.getKey();
                menorQuantidadeJogos = entry.getValue();
            }
        }
            System.out.println("Estado com menos jogos entre " + anoInicial +
                    " e " + anoFinal + ": " + estadoComMenosJogos);
    }


    public static void jogadorComMaiorNumeroDeGols(JogadorRepository jogadorRepository) {
        System.out.println("Jogador com maior quantidade de gols: ");
        Optional<Jogador> jogador = jogadorRepository.listarJogadores().stream().max(Comparator.comparing(Jogador::getTotalGols));
        System.out.println(jogador.get().getNome() + " com " + jogador.get().getTotalGols() + " gols.");
    }

    public static void jogadorComMaiorNumeroDeGolsContra (JogadorRepository jogadorRepository) {
        System.out.println("Jogador com maior quantidade de gols contra: ");
        Optional<Jogador> jogador = jogadorRepository.listarJogadores().stream().max(Comparator.comparing(Jogador::getGolsContra));
        System.out.println(jogador.get().getNome() + " com " + jogador.get().getGolsContra() + " gols contra.");
    }

    public static void jogadorComMaiorNumeroDeGolsPenaltis (JogadorRepository jogadorRepository) {
        System.out.println("Jogador com maior quantidade de gols penaltis: ");
        Optional<Jogador >jogador = jogadorRepository.listarJogadores().stream().max(Comparator.comparing(Jogador::getGolsPenaltis));
        System.out.println(jogador.get().getNome() + " com " + jogador.get().getGolsPenaltis() + " penaltis.");
    }

    public static void jogadorComMaiorNumeroDeCartoesAmarelos (JogadorRepository jogadorRepository) {

        System.out.println("Jogador com maior quantidade de cartões amarelos: ");
        Optional<Jogador> jogador = jogadorRepository.listarJogadores().stream().max(Comparator.comparing(Jogador::getCartoesAmarelos));
        System.out.println(jogador.get().getNome() + " com " + jogador.get().getCartoesAmarelos() + " cartões amarelos.");

    }

    public static void jogadorComMaiorNumeroDeCartoesVermelhos (JogadorRepository jogadorRepository) {
        System.out.println("Jogador com maior quantidade de cartões vermelhos: ");
        Optional<Jogador> jogador = jogadorRepository.listarJogadores().stream().max(Comparator.comparing(Jogador::getCartoesVermelhos));
        System.out.println(jogador.get().getNome() + " com " + jogador.get().getCartoesVermelhos() + " cartões vermelhos.");
    }






}





