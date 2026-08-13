package model;

public class Livro extends ItensAcervo{
    private String titulo;
    private String autor;

    public Livro(String codigo, String genero, boolean disponivel, String titulo, String autor) {
        super(codigo, genero, disponivel);
        this.titulo = titulo;
        this.autor = autor;
    }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    public String getTitulo() { return titulo; }
}