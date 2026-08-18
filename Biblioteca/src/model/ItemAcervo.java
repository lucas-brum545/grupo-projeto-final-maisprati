package model;
public abstract class ItemAcervo {
    protected String codigo;
    private String genero;
    private boolean disponivel;

    public ItemAcervo(String codigo, String genero, boolean disponivel) {
        this.codigo = codigo;
        this.genero = genero;
        this.disponivel = disponivel;
    }
    
}

