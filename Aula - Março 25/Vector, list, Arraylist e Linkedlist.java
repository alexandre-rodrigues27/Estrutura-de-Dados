//List é uma interface, ou seja, não é uma lista de verdade. Ela funciona como um “modelo” que define o que uma lista deve fazer, como adicionar, remover e acessar elementos. Você não 
//pode criar um new List(), mas pode usar List como tipo para deixar o código mais flexível.

List<String> nomes = new ArrayList<>();

nomes.add("Ana");
nomes.add("Carlos");

System.out.println(nomes.get(0)); // Ana

//ArrayList é uma implementação de List baseada em um array dinâmico. Isso significa que os elementos ficam organizados como em um vetor. A principal vantagem é o acesso rápido aos 
//elementos usando índice (por exemplo, get(0)). A desvantagem é que inserir ou remover elementos no meio da lista pode ser mais lento, pois os outros elementos precisam ser deslocados.

ArrayList<String> lista = new ArrayList<>();

lista.add("A");
lista.add("B");
lista.add("C");

System.out.println(lista.get(1)); // B


//LinkedList também é uma implementação de List, mas funciona como uma lista encadeada. Cada elemento aponta para o próximo. Isso facilita inserções e remoções, que são mais rápidas, 
//especialmente no início ou no meio da lista. Porém, acessar um elemento por índice é mais lento, pois é necessário percorrer a lista até chegar nele.

LinkedList<String> lista = new LinkedList<>();

lista.add("A");
lista.add("B");
lista.addFirst("Inicio");

System.out.println(lista);

//Vector é parecido com o ArrayList, mas possui sincronização automática, o que o torna seguro para uso com múltiplas threads. O problema é que isso deixa o desempenho mais lento. Por 
//isso, hoje em dia ele quase não é utilizado.

Vector<String> lista = new Vector<>();

lista.add("X");
lista.add("Y");

System.out.println(lista);
