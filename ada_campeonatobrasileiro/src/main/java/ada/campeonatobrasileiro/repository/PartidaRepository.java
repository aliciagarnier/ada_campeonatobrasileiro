package ada.campeonatobrasileiro.repository;
import ada.campeonatobrasileiro.domain.Partida;
import ada.campeonatobrasileiro.domain.Time;


import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartidaRepository {
    private static final PartidaRepository partidaRepository = new PartidaRepository();
    private final Map<String, Partida> partidas = new HashMap<>();

    public static PartidaRepository getPartidaRepository() {
        return partidaRepository;
    }

    public void salvar (String IDPartida, Year anoPartida, Time vencedor, Time mandante, Time visitante, int placarMandante, int placarVisitante) {
        Partida novaPartida = new Partida(IDPartida, anoPartida, vencedor, mandante, visitante, placarMandante, placarVisitante);
        partidas.put(IDPartida, novaPartida);
    }
    public List<Partida> listarPartidas ()  {
        return new ArrayList<>(partidas.values());
    }
    public void printarPartidas() {
        listarPartidas().forEach(partida -> System.out.println(partida.toString()));
    }
    public Partida obterPartida (String IDPartida) {
        return partidas.get(IDPartida);
    }
    public boolean existePartida(String ID) {
        return partidas.get(ID) != null;
    }

}



