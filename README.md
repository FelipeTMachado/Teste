OBS: O arquivo readme foi escrito com o intuito de mostrar qual foi o processo de criação, porém nao segue a risca o código, algumas alteracoes foram feitas para adicionar os resultados das requisicoes e os numeros de status, Mas é mais ou menos assim meu processo de criacao e documentação, que claramente em ambiente de desenvolvimento pode ser mais lapidado.

Testes
Repositorio criado para testes

Criação da API Utilizando a ferramenta spring tool suíte para eclipse, faço a abertura de um novo projeto do tipo Spring Starter Project.

![image](https://user-images.githubusercontent.com/111534146/215029846-d02b7e3e-9951-4bba-9e08-b9c1441616fd.png)

As dependências usadas foram: • H2 Database • Spring Data JPA • Lombok • Spring Web • Spring Boot DevTools;

Classe Produto

No projeto tem a classe de produto tambem uma anotação como @Entity para que a classe seja endereçada como uma tabela para ser salvo direto no banco H2. Outra anotação e a de @Data que adiciono para poupar a criação de código adicional assim agilizando os “gets” e “sets” das propriedades da classe.

![image](https://user-images.githubusercontent.com/111534146/215029888-d15c7635-0494-4754-a475-719ab25cff61.png)

Nas propriedades preciso de duas anotações importantes @Id que faz com que o código da “Tabela” se comporte como chave primaria e o @GeneratedValue(strategy = GenerationType.AUTO) serve para que o ID seja adicionado automaticamente como se o o banco estivesse configurado para auto_increment.

![image](https://user-images.githubusercontent.com/111534146/215029907-82f242c8-4c3c-4813-8c16-9ed37c8a7fb8.png)

Interface ProdutoRepository

No inicio da interface adiciono a herança JpaRepository como Produto como classe e o Código como Long (Numérico), só é necessário isso para se criar um repository.

![image](https://user-images.githubusercontent.com/111534146/215029943-cbb0e020-9ae6-480e-8b50-4445e65fc889.png)

Classe ProdutoController

Na classe controller é onde ficaram os gets, posts e todas as requisições, já de inicio adiciono a anotação @RestController que faz com que não seja necessário criar uma tela para a API e ira retornar tudo no ResponseBody ou seja na Request da API.

![image](https://user-images.githubusercontent.com/111534146/215029957-023763c7-0300-4f4a-9b2f-915c3a448485.png)

Adicionei a anotação @AllArgsConstructor para que seja possível trazer o repository como uma propriedade e os fazer a requisição get ele me retorne todos os produtos que estão no banco e consequentemente na classe instanciada de produtos. (@GetMepping é para chamar o get da API).

![image](https://user-images.githubusercontent.com/111534146/215029976-634f5c4e-204f-4c56-af4c-97933469e2a7.png)

A Anotação @PostMapping faz a operação de “Cadastro” do produto no banco, utilizando o método save do repository ele joga os produtos dentro da classe produto e junto do banco de dados H2.

![image](https://user-images.githubusercontent.com/111534146/215029989-d0b768b3-9e11-4c10-ba03-602335eafd2d.png)

Para que seja possível trazer um produto por Código eu chamo a anotação @GetMapping de novo e passo um “Parâmetro” id assim ele faz uma pesquisa por id no “Banco” e retorna o produto. A anotação @GetVariable serve para passar o código do getMapping para o parâmetro da função sendo possível a pesquisa pelo GetReferenceByID.

![image](https://user-images.githubusercontent.com/111534146/215030010-77b8bb0c-d49b-486d-b9b6-ecdf00a63679.png)

Para excluir um produto é quase da mesma forma que buscar por código com a diferença da anotação @DeleteMapping mas passa como “parâmetro” igualmente só se destaca pelo método DeleteById do repository.

![image](https://user-images.githubusercontent.com/111534146/215030019-4a442143-3eed-4c1c-8104-121e0b1bcc9d.png)

Para alterar um produto utilizo a anotação @PutMapping que é da mesma forma de uma post mapping mas agora com a certeza de que tem algum registro igual na base de dados, assim ele faz a alteração do produto.

![image](https://user-images.githubusercontent.com/111534146/215030046-d8a08023-d468-4468-a2e9-a10479f26c3c.png)
