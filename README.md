# fiap_postech_arquitetura_java
Repositório contendo os arquivos do projeto Parking.

## Requisitos Funcionais - Projeto Parking
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
    Retorna um JSON com todos os condutores cadastrados.
    
  - POST cadastrarCondutor = http://localhost:8080/condutores
      Recebe um JSON conforme abaixo:
        {
          "dadosCondutor": {
          "nome": "Ronaldinho",
          "cpf": "345.543.657-34",
          "telefone": "(12) 3456-7890"
          }
        }
    
  - PUT atualizarCondutor = http://localhost:8080/condutores/id
        Recebe o ID como parâmetro na URL e um JSON conforme abaixo:
        {
          "dadosCondutor": {
          "nome": "Ronaldinho",
          "cpf": "345.543.657-34",
          "telefone": "(12) 3456-7890"
          }
        }
    
  - DELETE deletarCondutor = http://localhost:8080/condutores/id
      Recebe o id como parâmetro. 

### Veículos
  - GET consultarVeiculos = http://localhost:8080/veiculos
    Retorna um JSON com todos os veículos cadastrados.

  - GET consultarVeiculosAtivos = http://localhost:8080/veiculos/ativo
    Retorna um JSON com todos os veículos cadastrados com status igual a true.
    
  - GET consultarVeiculosPorId = http://localhost:8080/veiculos/id
    Retorna um JSON com todos os veículos cadastradosos dados do veículo referente ao ID informado.

  - POST cadastrarVeiculoECondutor = http://localhost:8080/veiculos
      Recebe um JSON conforme abaixo:
      {
        "dadosVeiculo": {
          "marca": "Teste",
          "modelo": "Teste modelo",
          "placa": "FTZ123"
      },
        "dadosCondutor": {
          "nome": "Teste condutor",
          "cpf": "345.543.657-34",
          "telefone": "(12) 3456-7890"
        }
      }
    
  - POST cadastrarVeiculoParaCondutorExistente = http://localhost:8080/veiculos/cadastrar-para-condutor/id
        Recebe o ID como parâmetro na URL e um JSON conforme abaixo:
        {
        "dadosVeiculo": {
          "marca": "Teste",
          "modelo": "Teste 2",
          "placa": "ABC9N56"
          }
        }
    
  - PUT atualizarVeiculo = http://localhost:8080/veiculos/id
        Recebe o ID como parâmetro na URL e um JSON conforme abaixo:
        {
          "marca": "MCLaren",
          "modelo": "Senna",
          "placa": "FVC9N56"
        }
    
  - DELETE deletarVeiculo = http://localhost:8080/veiculos/id
      Recebe o id como parâmetro na URL.
  
  - DELETE esclusaoLogicaVeiculo = http://localhost:8080/veiculos/logica/id
      Recebe o id como parâmetro na URL.

