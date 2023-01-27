OBS: O arquivo readme foi escrito com o intuito de mostrar qual foi o processo de criação, porém nao segue a risca o código, algumas alteracoes foram feitas para adicionar os resultados das requisicoes e os numeros de status, Mas é mais ou menos assim meu processo de criacao e documentação, que claramente em ambiente de desenvolvimento pode ser mais lapidado.

Testes
Repositorio criado para testes

Criação da API Utilizando a ferramenta spring tool suíte para eclipse, faço a abertura de um novo projeto do tipo Spring Starter Project.

image

As dependências usadas foram: • H2 Database • Spring Data JPA • Lombok • Spring Web • Spring Boot DevTools;

Classe Produto

No projeto tem a classe de produto tambem uma anotação como @Entity para que a classe seja endereçada como uma tabela para ser salvo direto no banco H2. Outra anotação e a de @Data que adiciono para poupar a criação de código adicional assim agilizando os “gets” e “sets” das propriedades da classe.

. image.

Nas propriedades preciso de duas anotações importantes @Id que faz com que o código da “Tabela” se comporte como chave primaria e o @GeneratedValue(strategy = GenerationType.AUTO) serve para que o ID seja adicionado automaticamente como se o o banco estivesse configurado para auto_increment.

image

Interface ProdutoRepository

No inicio da interface adiciono a herança JpaRepository como Produto como classe e o Código como Long (Numérico), só é necessário isso para se criar um repository.

image

Classe ProdutoController

Na classe controller é onde ficaram os gets, posts e todas as requisições, já de inicio adiciono a anotação @RestController que faz com que não seja necessário criar uma tela para a API e ira retornar tudo no ResponseBody ou seja na Request da API.

image

Adicionei a anotação @AllArgsConstructor para que seja possível trazer o repository como uma propriedade e os fazer a requisição get ele me retorne todos os produtos que estão no banco e consequentemente na classe instanciada de produtos. (@GetMepping é para chamar o get da API).

image

A Anotação @PostMapping faz a operação de “Cadastro” do produto no banco, utilizando o método save do repository ele joga os produtos dentro da classe produto e junto do banco de dados H2.

image

Para que seja possível trazer um produto por Código eu chamo a anotação @GetMapping de novo e passo um “Parâmetro” id assim ele faz uma pesquisa por id no “Banco” e retorna o produto. A anotação @GetVariable serve para passar o código do getMapping para o parâmetro da função sendo possível a pesquisa pelo GetReferenceByID.

image

Para excluir um produto é quase da mesma forma que buscar por código com a diferença da anotação @DeleteMapping mas passa como “parâmetro” igualmente só se destaca pelo método DeleteById do repository.

image

Para alterar um produto utilizo a anotação @PutMapping que é da mesma forma de uma post mapping mas agora com a certeza de que tem algum registro igual na base de dados, assim ele faz a alteração do produto.

image
