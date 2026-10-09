# MedicoGUI — Cadastro de Médicos

Aplicação **desktop em Java** com interface gráfica para cadastro de médicos, com os dados guardados em banco de dados via **JDBC**. O projeto é organizado em camadas (Model, View, Controller e DAO).

> Projeto acadêmico desenvolvido no início dos meus estudos em Java, mantido aqui como registro da minha evolução.



## Sobre o projeto

O objetivo foi praticar a construção de uma aplicação com interface gráfica conectada a um banco de dados relacional, separando as responsabilidades em camadas:

- **View:** a tela onde o usuário preenche os dados do médico
- **Controller:** recebe as ações da tela e repassa para a camada de dados
- **DAO (Data Access Object):** executa os comandos SQL no banco
- **Conexão:** centraliza a abertura da conexão JDBC
- **Modelo:** representa a entidade `Medico`

## Tecnologias

- Java
- Java Swing (interface gráfica)
- JDBC
- MySQL Banco de dados relacional
- Eclipse IDE (estrutura `src/` e `bin/`)

## Arquitetura

```
CadastroMedico (View) ──► MedicoController ──► MedicoDao ──► FabricaDeConexao ──► Banco de dados
                                 │
                                 └── Medico (Modelo)
```

## Estrutura do projeto

```
Medicos/
├── src/
│   ├── conection/
│   │   └── FabricaDeConexao.java   # Cria e fornece a conexão JDBC
│   ├── controller/
│   │   └── MedicoController.java   # Intermedia a View e o DAO
│   ├── dao/
│   │   └── MedicoDao.java          # Operações SQL da entidade Medico
│   ├── main/
│   │   └── Principal.java          # Ponto de entrada da aplicação
│   ├── modelo/
│   │   └── Medico.java             # Entidade Medico
│   └── view/
│       └── CadastroMedico.java     # Tela de cadastro (Swing)
└── bin/                            # Arquivos compilados (.class)
```

## Pré-requisitos

- JDK instalado
- MySQL Server Servidor de banco de dados
- Driver JDBC do banco adicionado ao *Build Path* do projeto

## Configuração do banco de dados

Crie o banco e a tabela antes de executar:

```sql
-- TODO: ajustar nomes e colunas conforme FabricaDeConexao.java e MedicoDao.java
CREATE DATABASE nome_do_banco;
USE nome_do_banco;

CREATE TABLE medico (
    id INT AUTO_INCREMENT PRIMARY KEY
    -- demais colunas
);
```

Depois, confira em `FabricaDeConexao.java` se a URL, o usuário e a senha batem com o seu ambiente.

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/brennolvs/MedicoGUI.git
   ```
2. No Eclipse, vá em **File > Import > Existing Projects into Workspace** e selecione a pasta `Medicos`.
3. Adicione o `.jar` do driver JDBC em **Build Path > Add External JARs**.
4. Configure o banco de dados, como descrito acima.
5. Execute `Principal.java` com **Run As > Java Application**.

## Conceitos praticados

- Interface gráfica com Java Swing
- Integração com banco de dados via JDBC
- Padrão **DAO** para isolar o acesso a dados
- Separação em camadas no estilo **MVC**
- Encapsulamento e orientação a objetos

## Possíveis melhorias

- Remover a pasta `bin/` do versionamento e adicioná-la ao `.gitignore`
- Mover usuário e senha do banco para um arquivo de configuração ou variáveis de ambiente
- Gerenciar dependências com Maven ou Gradle, incluindo o driver JDBC
- Adicionar validações nos campos da tela
- Criar testes unitários com JUnit
- Corrigir o nome do pacote `conection` para `connection`

## Autor

**Brenno Alves**  
[LinkedIn](https://linkedin.com/in/brennolvs) · [GitHub](https://github.com/brennolvs)
