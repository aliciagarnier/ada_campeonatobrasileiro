package ada.campeonatobrasileiro;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.realizarLeituras();
        controller.obterEstatisticas();
    }
}
