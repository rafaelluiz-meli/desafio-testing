# Desafio Testing - Grupo 4 - Wave 5
O objetivo deste desafio é aplicar os conteúdos dados até o momento durante o
Programa de aceleração MeLi (Git, Java e Spring), com ênfase principal nas validações e
tipos de teste que podem ser usados a partir de uma proposta, um especificação de
requisitos e documentação anexa.

## Metodologias de desenvolvimento
Nós do grupo 4 decidimos implementar as tasks do projeto com Test Driven Development (TDD).
Cada requisito da aplicação foi divido em uma diferente task em um board do Trello e, então, separamos
o grupo em duplas para realizar o desenvolvimento de cada uma delas.

### TDD
Utilizamos de TDD para transformar todos os requisitos em testes antes mesmo de desenvolver as funcionalidades.
Com isso, ganhamos maior clareza do que era necessário para o funcionamento da nossa aplicação e também sentimos um ganho 
de velocidade ao desenvolver tasks mais complexas. A partir da criação dos testes, já tinhamos maior clareza
do que seria necessário desenvolver na camada de serviço da aplicação.

### Code Review
Utilizando de Pull Requests, uma dupla ficava responsável de revisar o código da dupla anterior. Nós nos reunimos diariamente
para fazer essa revisão ao vivo - dando abertura para que todos do grupo aprendam sobre a implementação dos colegas.

### Migração para banco de dados H2
Finalizamos o desafio primeiramente implementando persistência de dados com ObjectMapper e arquivos .JSON
Mas, após desafio do instrutor Kenyo, resolvemos tentar implementar os requisitos com banco de dados em memória (H2) e JPA.
Após ajuda dos instrutores, conseguimos chegar em uma solução funcional. Foi um desafio muito interessante onde todos os integrantes
aprenderam algo de novo.


# Como executar o projeto
Faça o clone da branch MASTER para o seu computador. Instale todas as dependências através do maven e execute o projeto através do
Spring Boot.

Se desejar, você poderá rodar os testes unitários e de integração através do package TESTS.

Incluímos também uma COLEÇÃO DO POSTMAN com todos os endpoints utilizados pelo nosso projeto, assim como um exemplo de payload.

