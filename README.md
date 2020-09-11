# Coding Challenge Backend

Bem vindo! Se você está aqui é porque gostamos do seu perfil e queremos conhecer um pouco mais sobre suas habilidades como desenvolvedor.

# Pré-requisitos

* Java 11
* Maven
* Git
* Intellij, Visual Studio Code, Eclipse ou a IDE de sua preferência

# Critérios de avaliação

* Compreensão dos requistos
* Fornecer documentação explicando como rodar e testar localmente
* Engenharia de Software
* Cobertura de Testes
* Versionamento
* Arquitetura do Código
* Separação de Responsabilidades
* Manutenabilidade
* Modelagem de dados (Estruturas de dados utilizadas, etc)

# Sobre o projeto

Esse projeto é uma API REST com SpringBoot, Maven em JAVA 11 usando uma adaptação do modelo 'Clean Architecture'.

O endpoint exposto(/agencies) retorna uma lista com informações de todas as agências da instituição bancária "Banco do Brasil" de toda a extensão nacional.

Dados obtidos através do Portal de Dados do Banco Central do Brasil:
https://dadosabertos.bcb.gov.br/dataset/agencias

# Mudanças

O client poderá optar por busca genérica ou seja por todas as agências, para isso basta não colocar nenhum parâmetro em sua url. Também contará com uma busca por estado, onde na variável state colocará o UF, caso não exista o UF o serviço retornará uma mensagem de "error": "estado fornecido não existe" com o código de erro 400 (Bad request). O Client também terá a opção de busca por mais de um estado, basta colocar os estados entre vírgula, ex: http://localhost:8080/agencies?states=SP,AC,BA...

# Estados


* Acre (AC)
* Alagoas (AL)

* Amapá (AP)

* Amazonas (AM)

* Bahia (BA)

* Ceará (CE)

* Distrito Federal (DF)

* Espírito Santo (ES)

* Goiás (GO)

* Maranhão (MA)

* Mato Grosso (MT)

* Mato Grosso do Sul (MS)

* Minas Gerais (MG)

* Pará (PA)

* Paraíba (PB)

* Paraná (PR)

* Pernambuco (PE)

* Piauí (PI)

* Rio de Janeiro (RJ)

* Rio Grande do Norte (RN)

* Rio Grande do Sul (RS)

* Rondônia (RO)

* Roraima (RR)

* Santa Catarina (SC)

* São Paulo (SP)

* Sergipe (SE)

* Tocantins (TO)

# Swagger

http://localhost:8080/swagger-ui.html

# Desenvolvedor

Para rodar os testes localmente basta executar o seguinte comando;

```
mvn test
```

Caso queira gerar o executável basta rodar o seguinte comando;

```
mvn install
```
