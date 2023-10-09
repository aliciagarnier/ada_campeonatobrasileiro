package ada.campeonatobrasileiro.domain;

public class Jogador {
    private final String nome;
    private int gols = 0;

    private int golsContra = 0;

    private int golsPenaltis = 0;

    private int cartoesVermelhos = 0;

    private int cartoesAmarelos = 0;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return this.nome;
    }

    @Override

    public String toString () {
        return "nome: " + nome + " Gols: " + gols + " Penaltis: " + golsPenaltis + " Gols contra: " + golsContra + " Cartoes amarelos: " + cartoesAmarelos + " Cartoes vermelhos: " + cartoesVermelhos;
    }

    public int getGols() {
        return gols;
    }

    public void incrementarGols() {
        this.gols++;
    }



    public int getTotalGols () {
        return gols + golsPenaltis;
    }
    public int getGolsContra() {
        return golsContra;
    }

    public void incrementarGolsContra() {
        this.golsContra++;
    }

    public int getGolsPenaltis() {
        return golsPenaltis;
    }

    public void incrementarGolsPenaltis() {
        this.golsPenaltis++;
    }

    public int getCartoesVermelhos() {
        return cartoesVermelhos;
    }

    public void incrementarCartoesVermelhos() {
        this.cartoesVermelhos++;
    }

    public int getCartoesAmarelos() {
        return cartoesAmarelos;
    }

    public void incrementarCartoesAmarelos() {
        this.cartoesAmarelos++;
    }
}
