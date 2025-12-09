<p align="center">
  <img width="100px" src="https://assecom.ufersa.edu.br/wp-content/uploads/sites/24/2014/09/PNG-bras%C3%A3o-Ufersa.png" alt="Brasão da Ufersa" />
</p>

<h1 align="center">🎮 Locadora de Jogos</h1>
<p align="center"><b>Projeto da disciplina Programação Orientada a Objetos</b></p>

<div align="center">

![Status](https://img.shields.io/badge/Status-Concluído-green)
![Linguagem C](https://img.shields.io/badge/Linguagem-Java-orange)

</div>

## 📄 Sobre o Projeto
É um sistema de terminal de uma Locadora de Jogos, que deve aplicar
corretamente os quatro pilares da Programação Orientada a Objetos.
O sistema deve possuir um menu de terminal para interagir com as funcionalidades.


## 📋 Requisitos Obrigatórios

Este projeto deve satisfazer os seguintes pontos, demonstrando o uso correto dos quatro pilares da POO:

* Encapsulamento (Proteção dos Dados)
* Herança (Reutilização e Especialização)
* Abstração (O Essencial vs. a Complexidade)
* Polimorfismo (Muitas Formas, Uma Interface)

### Hierarquia de pastas
```python
.
├── LICENSE
├── README.md
└── src
    └── br
        └── com
            └── locadora
                ├── app
                │   └── Main.java
                ├── interfaces
                │   ├── IAluguel.java
                │   ├── ICliente.java
                │   └── IJogo.java
                ├── model
                │   ├── Aluguel.java
                │   ├── Cliente.java
                │   ├── JogoDigital.java
                │   ├── JogoFisico.java
                │   ├── Jogo.java
                │   └── Plataforma.java
                ├── repository
                │   ├── AluguelRepoMemory.java
                │   ├── ClienteRepository.java
                │   └── JogoRepoMemory.java
                ├── service
                │   ├── ClienteService.java
                │   ├── JogoService.java
                │   └── LocadoraService.java
                └── view
                    ├── MenuCliente.java
                    └── MenuJogo.java

```

### 🖥️ Funcionalidades do terminal

Opções disponíveis:

```
===== LOCADORA DE JOGOS =====
1. Menu Cliente
2. Menu Jogo
0. Sair
Escolha: 

```
#### Menu cliente:
```
==== MENU CLIENTE ====
1. Criar Cliente
2. Listar Clientes
3. Buscar Cliente por CPF
4. Atualizar Cliente
5. Deletar Cliente
0. Sair
Escolha uma opção: 
```
#### Menu jogo:
```
==== MENU JOGO ====
1. Cadastrar Jogo
2. Listar Jogos
3. Buscar Jogo por ID
4. Remover Jogo por ID
5. Alugar Jogo
6. Listar Aluguéis
0. Sair
Escolha uma opção: 
```

### Como rodar a aplicação
No terminal, clone o repositório do projeto:
```
git clone https://github.com/gabinaiare/Locadora-de-Jogos.git
```

Entre na pasta do projeto
```
cd Locadora-de-Jogos
```
Compile os arquivos Java
```
javac -d bin src/br/com/locadora/**/*.java
```

Execute a aplicação
```
java -cp bin br.com.locadora.app.Main
```

## 🧑‍💻 Desenvolvedores

|  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/157031016?v=4" width="115"><br><sub>Gabrielle Naiare Pereira de Oliveira<br>2023022665</sub>](https://github.com/gabinaiare) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/115113727?v=4" width="115"><br><sub> Jennefhy Saiury de Lima Pontes<br> 2024010522</sub>](https://github.com/jennefhy) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/106347376?v=4" width="115"><br><sub> Alice dos Santos Pinheiro <br> 	2023022668</sub>](https://github.com/AliceSantoi) |
| :------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/171264485?v=4" width="115"><br><sub> Pedro Victor Soares Gonçalo <br> 2024010454 </sub>](https://github.com/pedrokaut) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/186582235?v=4" width="115"><br><sub> Pablo Ryan Lopes Vieira <br> 2024010361</sub>](https://github.com/Ryan-loyer) | 
