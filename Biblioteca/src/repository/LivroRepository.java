package repository;

import model.Livro;
import java.util.List;

public interface LivroRepository {
    void salvar(Livro livro);
    Livro buscarPorTitulo(String titulo);
    List<Livro> listarTodos();
}