# Banco de Dados 2 - Trabalho GA - ORM

## Pré requisitos:
1. Docker
2. Maven (Instalado e funcionando no terminal/cmd)
3. Eclipse Oxygen
4. Apache Tomcat 9
5. Java 8
6. Git

## Setup do ambiente de desenvolvimento
1. Execute o comando `docker pull postgres` para baixar a imagem do Postgres
2. Execute o comando `docker run --name pg -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres` para criar uma instância do banco Postgres
3. Execute o comando `git clone https://github.com/frankrafael/db2-trab-ga` para clonar o código deste repositório
4. Execute o comando `mvn clean install` para baixar as dependências do projeto
5. Importe este projeto como Maven Project no seu Eclipse
6. Crie um novo servidor Tomcat 9 e publique este projeto.


