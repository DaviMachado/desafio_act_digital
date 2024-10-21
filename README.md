![logo_acetdigital](./img_readme/logo.png)  

# Desafio Técnico - ActDigital  
### Tecnologias Utilizadas:
- Java versão 17
- Spring Boot
- SQLServer
- Docker
- MockServer

## SOLUÇÃO:

![img_solucao](./img_readme/solucao.png)

### _Passo a Passo para executar o projeto_

1. Clonar o projeto através do [link.](https://github.com/DaviMachado/desafio_act_digital)


2. Em seguida, será necessário executar o comando **"docker-compose up -d"** dentro do diretorio do projeto clonado. (**OBS:** É necessário executar esse comando para subir o container do **SqlServer**).

![imagem1](./img_readme/img1.png)
![imagem2](./img_readme/img2.png)


3. Na sequência, será necessário criar as tabelas **ENDERECO** e **LOG_ENDERECO** no banco de dados. (**OBS:** O microsserviço foi configurado para não realizar a criação das tabelas).

![imagem3](./img_readme/img3.png)


4. Agora será necessário subir o microsserviço que foi clonado na etapa 1.

![imagem4](./img_readme/img4.png)


5. Agora com o auxilio do **Postman**, iremos realizar a requisição para o endpoint **http://localhost:3030/act_digital/endereco/01001000**. (**OBS:** O numero **"01001000"** é o CEP que deseja ser pesquisado na API do ViaCep).

![imagem5](./img_readme/img5.png)


- Em seguida ele irá pesquisar o CEP através da API do ViaCep, e salvar no banco de dados nas respectivas tabelas **ENDERECO** e **LOG_ENDERECO**.

![imagem6](./img_readme/img6.png)
![imagem7](./img_readme/img7.png)


- Por fim, a cobertura dos testes unitários ficou em **91,8%** no **Coverage**.

![imagem8](./img_readme/img8.png) 

___
___
