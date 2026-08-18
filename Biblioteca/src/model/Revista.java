package model;

public class Revista extends ItemAcervo{
    private final int edicao;
    private final String mesAnoPublicacao;

    public Revista(String codigo, String genero, boolean disponivel, int edicao, String mesAnoPublicacao) {
        super(codigo, genero, disponivel);
        this.edicao = edicao;
        this.mesAnoPublicacao = mesAnoPublicacao;
    }


}
