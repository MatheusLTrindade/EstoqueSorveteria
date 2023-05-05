import java.util.*;

public class Estoque {
    
    private ArrayList<Item> itens = new ArrayList<Item>();
    private ArrayList<Categoria> categorias = new ArrayList<Categoria>(); 

    Estoque(){

        Categoria aoLeite = new Categoria("ao leite", 1);
        Categoria paleta = new Categoria("paleta mexicana", 2);
        Categoria natural = new Categoria("natural", 3);

        Item item1 = new Item(1, "morango ao leite", aoLeite, 30, 3.5f);
        Item item2 = new Item(2, "pessego ao leite", aoLeite, 30, 3.5f);
        Item item3 = new Item(3, "uva ao leite", aoLeite, 30, 3.5f);
        Item item4 = new Item(4, "morango", paleta, 30, 10f);
        Item item5 = new Item(5, "abacaxi", paleta, 30, 3.5f);
        Item item6 = new Item(6, "limao", paleta, 30, 3.5f);
        
        this.categorias.add(aoLeite);
        this.categorias.add(paleta);
        this.categorias.add(natural);

        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
        itens.add(item5);
        itens.add(item6);

    }

    public void addItem(Integer id, String description, Categoria category, int amount, float price){
        Item item = new Item(id, description, category, amount, price);        
        itens.add(item);
    }

    public Categoria getCategoriaById(int id){
        for (Categoria categoria: this.categorias){
            if (categoria.getId() == id){
                return categoria;
            }
        }
        return null;
    }
    
    public void showCategorias(){
        for(Categoria categoria: this.categorias){
            System.out.println(categoria);
        }
    }

    public Item getItemById(int id){
        for (Item item: this.itens){
            if (item.getCodItem() == id){
                return item;
            }
        }
        return null;
    }

    public void removeItem(Item item){
        try{
        this.itens.remove(item);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void removeCategoria(Categoria categoria){
        this.categorias.remove(categoria);
    }

    public void listarEstoque(){
        System.out.println();
        if(this.itens.size() != 0){
            for(Item item: this.itens){
                System.out.println(item);
            }
        } else {
            System.out.println("Estoque Vazio");
        } 
    }

    public void alteraQuantidade(int id, int amount){
        Item item = getItemById(id);
        item.setQuantidade(amount);
    }

}