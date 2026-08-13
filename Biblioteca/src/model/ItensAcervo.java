package model;
public abstract class ItensAcervo {
    protected String codigo;
    private String genero;
    private boolean disponivel;

    public ItensAcervo(String codigo, String genero, boolean disponivel) {
        this.codigo = codigo;
        this.genero = genero;
        this.disponivel = disponivel;
    }
    
}

