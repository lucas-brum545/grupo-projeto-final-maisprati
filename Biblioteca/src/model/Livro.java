package model;

public class Livro extends ItemAcervo {
    private String titulo;
    private String autor;
    private String isbn;
    private String genero;

    private static final int QUANTIDADE_ESTOQUE = 8;

    public Livro(String codigo, String genero, boolean disponivel, String titulo, String autor) {
        super(codigo, genero, disponivel);
        this.titulo = titulo;
        this.autor = autor;
    }


}