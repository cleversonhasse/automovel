# Desafio

## Cenário

A empresa “Ficticius Clean” atua na entrega de produtos de limpeza. A empresa vem
enfrentando grandes problemas para fazer a previsão de gastos com combustível de seus
veículos utilizados nas entregas. Para resolver o problema contratou você para
desenvolver uma API Rest.

## Desafio

Criar uma API Rest de cadastro de veículos para armazenar os veículos utilizados pela
empresa. O cadastro deverá conter os seguintes dados:

- Nome
- Marca
- Modelo
- Data de fabricação
- Consumo Médio de combustível dentro de cidade (KM/L)
- Consumo Médio de combustível em rodovias (KM/L)

Criar uma API para realizar o cálculo de previsão de gastos.
Deverá receber como parâmetro as seguintes informações:

- Preço da gasolina R$
- Total de km que será percorrido dentro da cidade
- Total de km que será percorrido em rodovias

O retorno deverá ser uma lista ranqueada dos veículos da empresa levando em
consideração o valor gasto com combustível.

O retorno deverá ter os seguintes dados:
- Nome
- Marca
- Modelo
- Ano
- Quantidade de combustível gasto
- Valor total gasto com combustível

## Avaliação

A avaliação levará em consideração os seguintes critérios:
- Qualidade de código
- Experiência de usabilidade da API
- Assertividade nos valores calculados

## Observações
- Deverá ser codificado na linguagem Java
- As tecnologias e frameworks utilizados para o desenvolvimento ficam a seu critério

## Definições Técnicas Usadas:
* Java 12
* Spring Boot
* Maven
* Banco de dados H2
* Testes unitários
* Seguido os padrões REST
* Git
* Flyway

## API REST permite:
* Retorno dos dados com o valor total gasto com combustível

## Instruções de execução e uso da API

O projeto foi construindo utilizando a ferramenta Maven e, portanto, apenas é necessário a execução do comando abaixo 
para iniciar a execução.

```
mvn spring-boot:run
```

Opcionalmente também pode-se utilizar qualquer IDE que tenha suporte ao Maven para execução da aplicação, como o 
IntelliJ IDEA, Eclipse ou NetBeans.

A aplicação irá inicializar automaticamente o banco de dados H2 e criar a tabela vazia através do Flyway. Em caso de atualizações futuras a aplicação também irá atualizar o banco de dados
e efetuar todos os tratamentos necessários nos dados automaticamente.

Uma vez em execução a API estará disponível para ser consumida no endereço `http://localhost:8080/rest/automovel`. 
Para facilitar os testes recomendo o uso do aplicativo Postman (disponível em `getpostman.com`).

Após subir o sistema, também pode ser utilizado o Swagger, ele fornece um resumo interativo da API. 
Ele pode ser acessado pelo link: `http://localhost:8080/swagger-ui.html`.

### Relação de endpoints

#### Criar Automóvel

``POST http://localhost:8080/rest/automovel``

Criação de novo automóvel e inserção no banco de dados. 

#### Buscar Todos os Automóveis

``GET http://localhost:8080/rest/automovel``

Busca todos os automóveis cadastrados no banco de dados.

#### Deletar Automóvel

``DELETE http://localhost:8080/rest/automovel/{id}``

Deleta um automóvel cadastrado no banco de dados conforme o `{id}` passado como parâmetro.

#### Atualizar Automóvel

``PUT http://localhost:8080/rest/automovel``

Atualiza um automóvel já cadastrado em banco de dados. No corpo da mensagem abaixo pode-se alterar os `?` pela informação que se deseja alterar. 

Corpo da mensagem no formato de JSON:
`{
    "id": ?
    "consumoMedioCidade": ?,
    "consumoMedioRodovia": ?,
    "dataFabricacao": "?",
    "marca": "?",
    "modelo": "?",
    "nome": "?"
}`

#### Cálculo

``GET http://localhost:8080/rest/automovel/calculo``

Retorna as informações de cálculo com a previsão de gastos. Para a realização do cálculo deve ser passado alguns parâmetros no corpo da mensagem alterando os `?` pela informação que se deseja.

Corpo da mensagem no formato de JSON:
`{
  "distanciaPercorridaCidade": ?,
  "distanciaPercorridaRodovia": ?,
  "preco": ?
}`

Os parâmetros de distância devem respeitar até 5 números inteiros e 2 números fracionados. Exemplo: 12345.12.
O preço conforme os postos de gasolina, devem respeitar até 2 números inteiros e 3 fracionados. 


## Relação de frameworks e bibliotecas utilizados no projeto e suas responsabilidades

* Java (12): Plataforma utilizada para desenvolver programas em sua linguagem.
* Spring Boot (LATEST): Framework base da aplicação para tratamento de solicitações HTTP, comunicação com o banco de 
dados e demais tarefas comuns. No projeto foi utilizado os componentes Web, DevTools, Test e JPA.
* H2 Database (LATEST): Motor de banco de dados escrito em Java para rápida prototipação e testes
* Flyway (LATEST): Controle de versão para o banco de dados, responsável por criar e manter atualizado o banco de dados
automaticamente (extremamente valioso em ambientes em que há um CI/DevOps bem estruturado).
* Swagger (LATEST): Estrutura de software de código aberto apoiada por um grande ecossistema de ferramentas que ajuda os desenvolvedores a projetar, criar, documentar e consumir serviços da Web RESTful.
* Lombok (LASTEST): Biblioteca java que se conecta automaticamente ao editor e cria ferramentas, incrementando e falitando o código java.
