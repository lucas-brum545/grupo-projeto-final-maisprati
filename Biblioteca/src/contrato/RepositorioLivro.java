package contrato;

import modelo.Livro;

import java.util.List;
import java.util.ArrayList;

public class RepositorioLivro implements Repositorio<Livro> {
    private static List<Livro> bancoDeDadosLivros = new ArrayList<>();
    private static long contadorId = 1;

    @Override
    public void salvar(Livro livro) {
        if (livro.getId() == null) {
            livro.setId(contadorId++);
            bancoDeDadosLivros.add(livro);
            System.out.println("Livro " + livro.getId() + " salvo com sucesso!");
        }
        deletar(livro.getId());
        bancoDeDadosLivros.add(livro);
        System.out.println("Livro " + livro.getId() + " atualizado com sucesso no banco de dados!");
    }

    @Override
    public Livro buscarPorId(Long id) {
        for (Livro livro : bancoDeDadosLivros) {
            if (livro.getId().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    @Override
    public List<Livro> listarTodos() {
        return new ArrayList<>(bancoDeDadosLivros);
    }

    @Override
    public void deletar(Long id) {
        bancoDeDadosLivros.removeIf(livro -> livro.getId().equals(id));
    }

    @Override
    public Livro buscarPorTitulo(String titulo) {
        return null;
    }
}