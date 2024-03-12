-----------------------------Passo a passo para executar o serviço-----------------------------

1- Ajustar a conexão com o banco de dados no arquivo application.properties, setando o nome da sua database, usuário e senha, as tabelas e colunas com os dados serão geradas automaticamente através do flyway.
2 - Iniciar o serviço, uma forma de iniciar o serviço é navegando até sua pasta através do terminal e nela executar o comando: mvn spring-boot:run
3 - Fazer a requisição a API /logbook.
