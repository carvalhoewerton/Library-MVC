import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        // Ler as datas de entrada conforme descrito neste Desafio.
        Scanner scanner = new Scanner(System.in);
        String dataInicialStr = scanner.nextLine();
        String dataFinalStr = scanner.nextLine();

        SistemaAcionistas sistemaAcionistas = new SistemaAcionistas();
        List<String> analises = sistemaAcionistas.obterAnalisesDesempenho(dataInicialStr, dataFinalStr);

        for (String analise : analises) {
            System.out.println(analise);
        }
    }
}

class SistemaAcionistas {
    public List<String> obterAnalisesDesempenho(String dataInicialStr, String dataFinalStr) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date dataInicial = df.parse(dataInicialStr);
        Date dataFinal = df.parse(dataFinalStr);

        // Simular uma base de dados em uma lista de análises:
        List<Analise> analises = new ArrayList<>();
        analises.add(new Analise(df.parse("01/01/2023"), "Analise de Desempenho Financeiro"));
        analises.add(new Analise(df.parse("15/02/2023"), "Analise de Riscos e Exposicoes"));
        analises.add(new Analise(df.parse("31/03/2023"), "Analises Corporativas"));
        analises.add(new Analise(df.parse("01/04/2023"), "Analise de Politicas e Regulamentacoes"));
        analises.add(new Analise(df.parse("15/05/2023"), "Analise de Ativos"));
        analises.add(new Analise(df.parse("30/06/2023"), "Analise de Inovacao e Tecnologia"));

        List<String> resultados = new ArrayList<>();
        for (Analise analise : analises) {
            if ((analise.data.equals(dataInicial) ||analise.data.after(dataInicial)) && (analise.data.before(dataFinal) || analise.data.equals(dataFinal))) {
                resultados.add(analise.descricao);
            }
        }
        return resultados;
    }
}

class Analise {
    Date data;
    String descricao;

    public Analise(Date data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }
}