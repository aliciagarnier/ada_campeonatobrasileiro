package ada.campeonatobrasileiro.readers;

import ada.campeonatobrasileiro.repository.PartidaRepository;
import ada.campeonatobrasileiro.repository.TimeRepository;

import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LeitorPartida extends AbstractReader {
    @Override
    protected void FilterReader(List<String> dados) {
        PartidaRepository partidaRepository = PartidaRepository.getPartidaRepository();
        TimeRepository timeRepository = TimeRepository.getTimeRepository();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");

        String IDPartida = dados.get(0);
        String ano = List.of(dados.get(2).split("/")).get(2);
        Year anoPartida = Year.parse(ano, formatter);

        String nomeTimeMandante = dados.get(4);
        String nomeTimeVisitante = dados.get(5);
        String nomeTimeVencedor = dados.get(10);

        int placarMandante = Integer.parseInt(dados.get(12));
        int placarVisitante = Integer.parseInt(dados.get(13));

        partidaRepository.salvar(IDPartida, anoPartida, timeRepository.obterTime(nomeTimeVencedor), timeRepository.obterTime(nomeTimeMandante),
                timeRepository.obterTime(nomeTimeVisitante), placarMandante, placarVisitante);
    }
}

