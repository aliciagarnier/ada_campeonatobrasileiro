package ada.campeonatobrasileiro.readers;
import ada.campeonatobrasileiro.repository.EstadoRepository;
import ada.campeonatobrasileiro.repository.TimeRepository;
import java.util.List;

public class LeitorFull extends AbstractReader {
    @Override
    protected void FilterReader(List<String> dados) {

        TimeRepository timeRepository = TimeRepository.getTimeRepository();
        EstadoRepository estadoRepository = EstadoRepository.getEstadoRepository();

        String timeMandante = dados.get(4);
        String timeVisitante = dados.get(5);
        String estadoMandante = dados.get(14);
        String estadoVisitante = dados.get(15);

        timeRepository.salvar(timeMandante, estadoRepository.salvar(estadoMandante));
        timeRepository.salvar(timeVisitante, estadoRepository.salvar(estadoVisitante));
    }
}

