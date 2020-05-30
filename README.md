# Desafio Back-End TOTVS

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

A aplicação irá inicializar automaticamente o banco de dados H2 e popular com alguns registros de exemplo na primeira
inicialização através do Flyway. Em caso de atualizações futuras a aplicação também irá atualizar o banco de dados
e efetuar todos os tratamentos necessários nos dados automaticamente.

Uma vez em execução a API estará disponível para ser consumida no endereço `http://localhost:8080/rest/calculo-combustivel`. 
Para facilitar os testes recomendo o uso do aplicativo Postman (disponível em `getpostman.com`).

O log da aplicação pode ser consultado diretamente pelo console ou através do arquivo `desafiototvs.log` na raiz 
do projeto ou caminho de execução.


