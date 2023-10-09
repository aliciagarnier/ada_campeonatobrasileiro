package ada.campeonatobrasileiro.domain;

public record Estado (String nome) {
    @Override
    public String toString() {
        return nome;
    }
}
