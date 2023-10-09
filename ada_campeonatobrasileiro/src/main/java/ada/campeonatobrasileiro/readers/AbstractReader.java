package ada.campeonatobrasileiro.readers;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public abstract class AbstractReader {
    protected abstract void FilterReader (List<String> dados);
    public final void LerArquivo(String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            br.readLine();
            String linha;
                while ((linha = br.readLine()) != null)
                {
                String[] colunas = linha.split(",");
                List<String> dados = Arrays.stream(colunas).map(string -> string.replaceAll("\"", "")).toList();
                FilterReader(dados);
                }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + arquivo);
        } catch (IOException e) {
            System.err.println("Erro de entrada/saída ao ler o arquivo: " + arquivo);
        }


    }

}
