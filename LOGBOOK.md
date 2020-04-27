**21/04**

* Início do Projeto
* Definição dos atributos das telas
* Desenvolvimento da tela Aluno

  A tela Aluno será possível realizar o cadastro, consulta, alterção e exclusão de um aluno no sistema. Dentro desta tela adicionei um JTalbbedPane que contém três JPanel, onde estão dividadas as informações do aluno em Dados Pessoais, Endereço e Curso, respectivamente. 
  Nesta etapa não foi adicionado os botões de ações da tela (cadastro, consulta, alterção e exclusão), porque ainda não decidi como serão apresentados na tela.
  
 **22/04**
 
 * Desenvolvimento da Tela Notas e Faltas
 
  A tela Notas e Faltas será possível realizar o cadastro, consulta, alterção e exclusão de notas de um aluno cadastrado no sistema. Dentro da tela adicionei um JTalbbedPane que contém dois JPanel. Onde o primeiro JPanel (Notas e Faltas) será inseridas as notas e faltas de um aluno a uma diciplina especifica e o segundo JPanel (Boletim) será mostradas as notas do aluno.
  Da mesma forma que a tela Aluno não adicionei os botões de ações da tela e não defini como será apresentada todas as notas do aluno no JPanel Boletim, então ela continua em branco.
  
  **24/04**
  
  * inicio da construção das classes Pessoa, Aluno
  
   Iniciei a programação das classes bases do projeto criando seus atributos, construtores e métodos de acesso getters e setters. Dividi os dados pessoais do aluno em duas classes: Pessoa e Aluno (sendo Aluno herdeiro de Pessoa). Caso seja adicionadas novas funções dentro do sistema, como cadastro de Professor, será possivel utilizar a classe Pessoa como uma classe mãe.  
   
  **25/04**
  
  * Inicio da construção das classes Curso e Endereco
  * Adição da Janela Home
  * Divisão das classes em pacotes (Packages)
  
  Iniciei a programação das classes Curso e Endereco criando seus atributos, construtores e métodos de acesso getters e setters. Adicionei ao projeto a tela Home que será a tela inicial do projeto e que irá receber as outras telas dentro dela, porém ainda não desenvolvi o seu design. Dividi as classes e janelas em quatro pacotes para ficarem mais organiadas (aluno, curso, frames, pessoa), foi necessário alterar a visibilidade dos construtores da classe Pessoas para *protected* para a classe Aluno conseguir acessa-la
   
**26/04**

 * Criação do banco de dados
 
  Desenvolvi o banco de dados, em MySql, do projeto me baseando nos atributos e relacionamento de classes que há até o momento 
