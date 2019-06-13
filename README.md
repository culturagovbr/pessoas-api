### Sobre a aplicação

É um serviço de verificação de registro de Pessoa Física e Jurídica integrado ao [InfoConv da Receita Federal](https://github.com/infoconv)

O serviço abrange algumas informações da base do Ministério da Cultura mais detalhadas.

  - Obrigatório a utilização do certificado para conexão de consulta conforme [documentação](https://github.com/infoconv/docs/wiki)
  
## Instalando a Biblioteca 
##### **br.gov.cultura.sistema**

A biblioteca comum a aplicações java da cultura encontra-se no diretório /src/main/lib/minc-comum-1.0.jar. 
Para efetuar o Build da aplicação é necessário a instalação na maquina local da dependência para o [maven](https://maven.apache.org/).
        
        mvn install:install-file -Dfile=**${Caminho ate o Projeto}**/src/main/lib/minc-comum-1.0.jar -DgroupId=br.gov.cultura.sistema -DartifactId=comum -Dversion=1.2.3 -Dpackaging=jar -DgeneratePom=true​

### Deploy ##

A aplicação/Serviço utiliza-se de ambiente [Jboss](http://www.jboss.org/) para execução.
Requer configurações de Certificados junto ao Serpro para conexão com a fazenda e segurança da informação.
        
Jboss precisa ser configurado com as conexões de banco de dados e segurança.

_**OBS**_: _Aplicação validada e operacional com Jboss-7.1.1_ e operando no ip 10.0.0.16 no ambiente da Cultura. Pasta raiz **Jboss/**
        
### Build

O ambiente que for efetuar o build deve estar dotado da **openjdk-1.7.65** ou anterior 

### Propriedades de Configuração

Criar arquivo "minc-pessoa.properties" com as informações na pasta /opt/config

        # Key Store
        keyStoreType=pkcs12
        keyStore=/opt/config/cert/[Arquivo.pfx](https://github.com/infoconv/docs/wiki)
        keyStorePassword=password configurado
        # Trust Store
        trustStoreType=jks
        trustStore= ${JAVA_HOME}/jre/lib/security/cacerts
        trustStorePassword=Password configurado
        # CPF Certificado
        #João Bilas
        cpf=01201201271

Os certificados .pfx devem ficar na pasta /opt/config/cert
