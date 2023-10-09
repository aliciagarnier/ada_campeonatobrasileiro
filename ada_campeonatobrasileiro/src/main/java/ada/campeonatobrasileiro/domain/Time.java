package ada.campeonatobrasileiro.domain;

public record Time(String nome, Estado estado) {

    @Override
    public String toString() {
        return "Nome time: " + nome + " " + estado;
    }


}
