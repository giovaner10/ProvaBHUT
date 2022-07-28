 Desenvolvi a solução utilizando o Intellij IDE, para iniciar  basta clonar esse repositório e baixar as dependências MAVEM necessárias.

 Após a importação das dependências para o projeto, é necessário que o MongoDB esteja instalado em sua máquina, na solução que desenvolvi a conexão entre a aplicação SpringBoot e o MongoDB é feita de forma automática (Verificar conexão no application.properties).

 Para o serviço de mensageria utilizei o RabbitMQ, então é necessário que você tenha ele instalado ou uma imagem rodando na sua máquina, após isso é necessario validar no application.properties os dados de user e password para a conexão, se faz necessário criar uma exchange com o nome de "amq.direct".


Endpoints:
	GET:
		Lista de carros da API externa
		http://localhost:8080/api/listCars

		Lista de logs do nosso banco de dados nosql local
		http://localhost:8080/api/logs


	POST:
		Criar um carro na api externa
		http://localhost:8080/api/createCar

Exemplo:

		{
    "_id": "19a193a2990377b01d59e404",
    "title": "Corolla",
    "brand": "Toyota",
    "price": "70000",
    "age": 2016,
    "__v": 0.0
}

