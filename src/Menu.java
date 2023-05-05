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
                "(5) Alterar quantidade\n" +
                "(0) Sair"
            );
            num = sc.nextInt();

            switch(num){
                case 0: 
                    option = false;
                    break;
                case 1:
                    try {
                        System.out.println("\nDigite o codigo: ");
                        int id = sc.nextInt();
                        if (estoque.getItemById(id) != null) {
                                throw new RuntimeException();
                            }
                        System.out.println("\nDigite a descrição do produto: ");
                        sc.nextLine();
                        String description = sc.nextLine();
                        System.out.println(" ");
                        estoque.showCategorias();
                        Categoria category = estoque.getCategoriaById(sc.nextInt());
                        System.out.println("\nDigite a quantidade: ");
                        int amount = sc.nextInt();
                        System.out.println("\nDigite o preço: ");
                        float price = sc.nextFloat();
                        estoque.addItem(id, description, category, amount, price);
                    } catch (Exception e) {
                        System.out.println("O código já está cadastrado no sistema.\nTente novamente.");
                    }
                    option = true;
                    break;
                case 2:
                    try {
                        System.out.println("\nDigite o codigo do produto: ");
                        Item itemRemove = estoque.getItemById(sc.nextInt());
                        if (itemRemove == null) {
                            throw new RuntimeException();
                        }
                        estoque.removeItem(itemRemove);
                        System.out.println("\nItem removido");
                    } catch (Exception e) {
                        System.out.println("O código não localizado.\nTente novamente.");
                    }
                    option = true;
                    break;
                case 3:
                    estoque.listarEstoque();
                    option = true;
                    break;
                case 4:
                    try {
                        System.out.println("\nDigite o codigo do produto: ");
                        int id_busca = sc.nextInt();
                        System.out.println();
                        Item item = estoque.getItemById(id_busca);
                        if (item == null) {
                            throw new RuntimeException();
                        }
                        System.out.println(item);
                    } catch (Exception e) {
                        System.out.println("Código não localizado.\nTente novamente.");
                    }
                    
                    option = true;
                    break;
                case 5:
                    try {
                        System.out.println("\nDigite o codigo do produto: ");
                        int id_altera = sc.nextInt();
                        if (estoque.getItemById(id_altera) == null) {
                                throw new RuntimeException();
                            }  
                        System.out.println("\nDigite a nova quantidade: ");
                        int new_amount = sc.nextInt();
                        estoque.alteraQuantidade(id_altera, new_amount);
                        System.out.println("\nQuantidade alterada");
                    } catch (Exception e) {
                        System.out.println("O código não localizado.\nTente novamente.");
                    }
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
