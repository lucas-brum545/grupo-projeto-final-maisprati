package modelo;

import java.time.LocalDate;

public class Emprestimo {
    private final String id;
    private final Livro[] livros;
    private final Leitor leitor;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataPrevistaDevolucao;
    private final boolean devolvido;

    public Emprestimo(String id, String id1, Livro[] livros, Leitor leitor, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, boolean devolvido) {
        this.id = id;
        this.livros = livros;
        this.leitor = leitor;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.devolvido = devolvido;
    }
}
