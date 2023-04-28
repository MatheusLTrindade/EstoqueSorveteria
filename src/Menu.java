import java.util.*;

public class Menu {
    private Estoque estoque = new Estoque();
    
    public int menu() {
        int num = 0;
        boolean option = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("ESTOQUE");
        
        while(option){
            System.out.println(
                "\n" +
                "(1) Adicionar produto \n" +
                "(2) Remover produto \n" +
                "(3) Exibir estoque\n" + 
                "(4) Buscar item\n" +
                "(0) Sair"
            );
            num = sc.nextInt();

            switch(num){
                case 0: 
                    option = false;
                    break;
                case 1:
                    System.out.println("\nDigite o codigo: ");
                    int id = sc.nextInt();
                    System.out.println("\nDigite a descrição do produto: ");
                    String description = sc.nextLine();
                    estoque.showCategorias();
                    Categoria category = estoque.getCategoriaById(sc.nextInt());
                    System.out.println("\nDigite a quantidade: ");
                    int amount = sc.nextInt();
                    System.out.println("\nDigite o preço: ");
                    float price = sc.nextFloat();
                    estoque.addItem(id, description, category, amount, price);
                    option = true;
                    break;
                case 2:
                    System.out.println("\nDigite o codigo do produto: ");
                    Item itemRemove = estoque.getItemById(sc.nextInt());
                    estoque.removeItem(itemRemove);
                    option = true;
                    break;
                case 3:
                    estoque.listarEstoque();
                    option = true;
                    break;
                case 4:
                    System.out.println("\nDigite o codigo do produto: ");
                    int id_ = sc.nextInt();
                    Item item = estoque.getItemById(id_);
                    System.out.println(item);
                    option = true;
                    break;
                default:
                    System.out.println("\nOpção inválida");
                    option = true;
                    break;
            }
        }

        sc.close();
        return num;
    }
}
