# Audsat-Teste-API
A API Audsat-Teste-API é um projeto que tem o objetivo de retornar o valor de um determinado produto da Joalheria Joia Preciosa, onde é calculado o valor da comissão de 5%, a porcentagem de lucro sobre a venda (incluindo a comissão) de 40% e para compras acima de 5 mil reais o cliente terá um desconto de 10% (tendo a empresa nesse caso um lucro de 30%) sobre o valor final.


## Como executar
A API foi construida para rodar em containers docker, então após baixar o projeto git, abrir o cmd dentro do local onde estiver o projeto e executar o comando abaixo:

  - docker-compose up -d audsat-teste-api
  
Após baixar todas as dependencias do projeto o serviço estará disponível para utilização no link abaixo:

  - http://localhost:8080/audsat/bff/teste/swagger-ui.html



## REST API
| Endpoint | Método| Descrição |
|----------|--------|------------|
| /produtos/valor/{valor} | GET  | Recebe o valor do produto em formato BigDecimal considerando até um ponto para os centavos. Ex.: 123.99 / 5352.2 / 1.25.  Retorna um JSON com o valor do produto, a comissão e o desconto (caso tenha)|
