package service;

import model.Livro;
import repository.LivroRepository;

public class BibliotecaService {
    private LivroRepository livroRepository;

    // Injeção da interface
    public BibliotecaService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void emprestarLivro(String titulo) {
        Livro livro = livroRepository.buscarPorTitulo(titulo);
        if (livro != null && livro.isDisponivel()) {
            livro.setDisponivel(false);
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Livro indisponível.");
        }
    }
}