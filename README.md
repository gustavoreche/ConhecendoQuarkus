# Conhecendo o QUARKUS
Esta aplicação foi desenvolvida com `Quarkus`(https://quarkus.io/) com o intuito de conhecer o framework.

A aplicação pode ser executada de três maneiras:
  - Com DOCKER
  - Criando um executável NATIVO
  - Local
  
### Com DOCKER
Ao baixar este projeto, no diretório raiz do projeto (ou seja, onde está o arquivo `docker-compose.yml`) , execute o seguinte comando no terminal:
```shell script
docker-compose up
```
Se no seu ambiente estiver tudo certo com as configurações do `DOCKER` e do `DOCKER-COMPOSE`, a aplicação já estará funcionando.

### Criando um executável NATIVO

Para criar um executável nativo, execute o seguinte comando no terminal: 
```shell script
./mvnw package -Pnative
```

Ou se você não tem a GraalVM instalada, execute o seguinte comando no terminal: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

Para utilizar o executável criado, execute o seguinte comando no terminal: 
`./target/bitcoin-1.0.0-SNAPSHOT-runner`

### Local
#### OBSERVAÇÃO: Para executar este projeto local, é necessário ter no seu ambiente o `MySQL` instalado, e executar o seguinte script:

[script](https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/script/script.sql)

Ao baixar este projeto, no diretório raiz do projeto (ou seja, onde está o arquivo `pom.xml`) , execute o seguinte comando no terminal:
```shell script
mvn install quarkus:dev
```
A aplicação já estará funcionando.

## Utilizando a aplicação

- Primeiramente, é necessário inserir um usuário

Foi implementada na aplicação níveis de permissões, em que um usuário tem acesso a fazer determinada operação, e o outro não. Essas permissões são de:
- admin
- user

Por exemplo: Nesta aplicação, os usuários que tem a permissão de “admin”, não conseguem inserir uma ORDEM, já os que têm permissão de “user” conseguem.

Para inserir um “user”, segue os prints abaixo(os prints abaixo foram realizados no `POSTMAN`):

[](https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/postUsuarioUser.png)
<img src="https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/postUsuarioUser.png">

No banco de dados ficou da seguinte maneira:

[](https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/bancoUsuarioUser.png)
<img src="https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/bancoUsuarioUser.png">

Para inserir um “admin”, segue os prints abaixo(os prints abaixo foram realizados no `POSTMAN`):

[](https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/postUsuarioAdmin.png)
<img src="https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/postUsuarioAdmin.png">

Ou seja, o atributo USERNAME tem que ter a string “alura” para ser um admin.

No banco de dados ficou da seguinte maneira:

[](https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/bancoUsuarioAdmin.png)
<img src="https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/bancoUsuarioAdmin.png">

Após inserir alguns usuários, as ORDENS podem ser inseridas

Para inserir uma ORDEM, segue os prints abaixo(os prints abaixo foram realizados no `POSTMAN`):

[](https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/postOrdem.png)
<img src="https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/postOrdem.png">

#### OBSERVAÇÃO: Neste endpoint, é necessário colocar o username e o password do usuário cadastrado:

[](https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/configuracaoPostman.png)
<img src="https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/configuracaoPostman.png">

Com o id do “user”, e o username e password corretos, a ORDEM é inserida no banco de dados:

[](https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/bancoOrdem.png)
<img src="https://github.com/gustavoreche/ConhecendoQuarkus/blob/master/prints/bancoOrdem.png">

Se alterarmos as configurações para o id do “admin”, e o username e password corretos, a ORDEM não é inserida no banco de dados, pois ele não tem essa permissão.
