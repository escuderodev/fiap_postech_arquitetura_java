# fiap_postech_arquitetura_java
Repositório contendo os arquivos do projeto Parking.

## requisitos funcionais
- Desenvolver API para Registro de Condutores e Veículos;

- Desenvolver API para este registro Registro de Forma de Pagamento;

- Controle de Tempo Estacionado;
  - Alertas de Tempo Estacionado;
  - desenvolver lógica para estes controles.

- Opções de Pagamento - utilizar APIs externas;

- Emissão de Recibos - pode ser um arquivo PDF;

## controllers
- Veículo;
- Condutor;

## endpoints
### Condutores
  - GET consultarCondutor = http://localhost:8080/condutores
  - POST cadastrarCondutor = http://localhost:8080/condutores
  - PUT atualizarCondutor = http://localhost:8080/condutores/id
  - DELETE deletarCondutor = http://localhost:8080/condutores/id

### Veículos
  - GET consultarVeiculos = http://localhost:8080/veiculos
  - GET consultarVeiculosAtivos = http://localhost:8080/veiculos/ativo
  - GET consultarVeiculosPorId = http://localhost:8080/veiculos/id
  - POST cadastrarVeiculoECondutor = http://localhost:8080/veiculos
  - POST cadastrarVeiculoParaCondutorExistente = http://localhost:8080/veiculos/cadastrar-para-condutor/id
  - PUT atualizarVeiculo = http://localhost:8080/veiculos/id
  - DELETE deletarVeiculo = http://localhost:8080/veiculos/id
  - DELETE esclusaoLogicaVeiculo = http://localhost:8080/veiculos/logica/id

