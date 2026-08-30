package contrato;
import modelo.Livro;
import modelo.Revista;

import java.util.ArrayList;
import java.util.List;

public class RepositorioRevista implements Repositorio<Revista> {
    private static List<Revista> bancoDeDadosRevistas = new ArrayList<>();
    private static long contadorId = 1;

    @Override
    public Revista buscarPorId(Long id) {
        for (Revista revista : bancoDeDadosRevistas) {
            if (revista.getId().equals(id)) {
                return revista;
            }
        }
        return null;
    }

    @Override
    public void salvar(Revista revista) {
        if (revista.getId() == null) {
            revista.setId(contadorId++);
            bancoDeDadosRevistas.add(revista);
            System.out.println("Revista salva com ID: " + revista.getId());
        } else {
            deletar(revista.getId());
            bancoDeDadosRevistas.add(revista);
            System.out.println("Revista atualizada com ID: " + revista.getId());
        }
    }

    @Override
    public List<Revista> listarTodos() {
        return new ArrayList<>(bancoDeDadosRevistas);
    }

    @Override
    public void deletar(Long id) {
        bancoDeDadosRevistas.removeIf(revista -> revista.getId().equals(id));
    }

    @Override
    public Revista buscarPorTitulo(String titulo) {
        for (Revista revista : bancoDeDadosRevistas) {
            if (revista.getId().equals(id)) {
                return revista;
            }
        }
        return null;
    }

}