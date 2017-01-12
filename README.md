# Sistema de Cadastro de Livros (SCL)

`versão: 1.0.0`

# Criando banco de dados

Agora a aplicação usa o Postgresql, crie um banco de dado com as configurações:
`CREATE DATABASE cadastro_livro WITH ENCODING='UTF8' OWNER=postgres TEMPLATE=template0 CONNECTION LIMIT=-1;`

Depois execute o comando na raiz do projeto:
`mvn flyway:migrate`
Flyway irá cria as tabelas, index e alguns registros iniciais (Cadastro de livros).

# Rodando a aplicação

`mvn clean install jetty:run`

Acesse o link: http://localhost:8080/

# Migração de Banco de dados com Flyway

https://flywaydb.org/

# Teste com dbUnit

http://dbunit.sourceforge.net/

## …or create a new repository on the command line

`git init`

`git add README.md`

`git commit -m "first commit"`

`git remote add origin git@github.com:danielso2007/estudo_rest_jersey_spring_scl.git`

`git push -u origin master`

## …or push an existing repository from the command line

`git remote add origin git@github.com:danielso2007/estudo_rest_jersey_spring_scl.git`

`git push -u origin master`
