### Sobre a aplicação

É um serviço de verificação de registro de Pessoa Fisica e Juridica integrado ao [InfoConv da Receita Ferderal](https://github.com/infoconv)

O serviço abrange a algumas informações da base do Ministerio da Cultura mais detalhadas.

## Instalando a Biblioteca 
##### **br.gov.cultura.sistema**

A biblioteca comum a aplicações java da cultura encontra-se /src/main/lib/minc-comum-1.0.jar. 
Para efetuar o Build da aplicação se faz necessário efetuar a instalação na maquina local da dependecia para o [maven](https://maven.apache.org/).
        
        mvn install:install-file -Dfile=**${Caminho ate o Projeto}**/src/main/lib/minc-comum-1.0.jar -DgroupId=br.gov.cultura.sistema -DartifactId=comum -Dversion=1.2.3 -Dpackaging=jar -DgeneratePom=true​

### Deploy ##

A aplicação/Serviço utiliza-se de ambiente [Jboss](http://www.jboss.org/) para execução.
Requer configurações de Certificados junto ao Serpro para conecção com o fazenda e segurança da informação.
        
Jboss precisa ser configurado com as conecções de banco e segurança.

_**OBS**_: _Aplicação validada e operacional com Jboss-7.1.1_ e operando no ip 10.0.0.16 no ambiente da Cultura. Pasta raiz **Jboss/**
        
### Build

O ambiente que for efetuar o build deve estar dotado da **openjdk-1.7.80u** ou anterior 
