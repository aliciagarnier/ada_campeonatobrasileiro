package ada.campeonatobrasileiro.repository;
import ada.campeonatobrasileiro.domain.Estado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class EstadoRepository {
    private static final EstadoRepository estadoRepository = new EstadoRepository();
    Map<String, Estado> estados = new HashMap<>();

    public static EstadoRepository getEstadoRepository() {
        return estadoRepository;
    }

    public Estado salvar (String sigla) {
        if (existeEstado(sigla))
        {
            return obterEstado(sigla);
        }
        Estado novoEstado = new Estado(sigla);
        estados.put(sigla, novoEstado);
        return novoEstado;
    }
    public List<Estado> listarTodos() {
        return new ArrayList<>(estados.values());
    }
    public void printarTodos() {
        listarTodos().stream().forEach(estado -> System.out.println(estado.toString()));
    }
    public boolean existeEstado(String sigla) {
        return estados.get(sigla) != null;
    }
    public Estado obterEstado(String sigla) {
        return estados.get(sigla);
    }


}
