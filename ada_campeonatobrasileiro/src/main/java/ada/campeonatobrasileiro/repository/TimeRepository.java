package ada.campeonatobrasileiro.repository;
import ada.campeonatobrasileiro.domain.Estado;
import ada.campeonatobrasileiro.domain.Time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeRepository {
    private static final TimeRepository timeRepository = new TimeRepository();
    private final Map<String, Time> times = new HashMap<>();
    public static TimeRepository getTimeRepository () {

        return timeRepository;
    }
    public void salvar (String nome, Estado estado) {
        Time novoTime = new Time(nome, estado);
        times.put(nome, novoTime);
    }
    public boolean existe(String nome) {
        return times.get(nome) != null;
    }
    public List<Time> listarTimes() {
        return new ArrayList<>(times.values());
    }
    public void printarTimes () {
        listarTimes().stream().forEach(time -> System.out.println(time.toString()));
    }
    public Time obterTime (String nome) {
        return times.get(nome);
    }

}

