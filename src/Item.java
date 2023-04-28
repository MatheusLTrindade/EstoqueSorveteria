public class Item{

    private int codItem;
    private String descricaoItem;
    private Categoria categoria;
    private int quantidade;
    private float valor;

    public Item(int codItem, String descricaoItem, Categoria categoria, int quantidade, float valor){
        this.codItem = codItem;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricaoItem = descricaoItem;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codItem;
        result = prime * result + ((descricaoItem == null) ? 0 : descricaoItem.hashCode());
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        result = prime * result + quantidade;
        result = prime * result + Float.floatToIntBits(valor);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (codItem != other.codItem)
            return false;
        if (descricaoItem == null) {
            if (other.descricaoItem != null)
                return false;
        } else if (!descricaoItem.equals(other.descricaoItem))
            return false;
        if (categoria == null) {
            if (other.categoria != null)
                return false;
        } else if (!categoria.equals(other.categoria))
            return false;
        if (quantidade != other.quantidade)
            return false;
        if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
            return false;
        return true;
    } 
@Override
public String toString() {
    String strBuilder = "";
    strBuilder += " " + this.getCodItem() + " ";
    strBuilder += " " + this.getDescricaoItem() + " ";
    strBuilder += " " + this.getQuantidade() + " ";
    strBuilder += " " + this.getCategoria().getDescricao() + " ";
    strBuilder += " " + this.getValor() + " ";
    return strBuilder;
}
}