USE [DBMINC]
GO

DECLARE @IdServico bigint;
DECLARE @IdTipoServico bigint;
DECLARE @IdLinguagemSistema bigint;

-- Obs: Preencher abaixo com os valores corretos
set @IdTipoServico = (
  SELECT ID_TIPO_SERVICO FROM SEGURANCA.S_TIPO_SERVICO WHERE NM_TIPO_SERVICO = 'WEBSERVICE');
set @IdLinguagemSistema = (
  SELECT ID_LINGUAGEM_SISTEMA FROM SEGURANCA.S_LINGUAGEM_SISTEMA WHERE NM_LINGUAGEM_SISTEMA = 'JAVA');
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;


----- Estado Civil -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,@IdTipoServico,@IdLinguagemSistema,'A',NULL,0
		,'corporativo_estado_civil_consultar'
		,'WebService do Corporativo'
		,'CORPESTADOCIVILCONSULTAR'
		,'/pessoa-ws/servicos/estado_civil/consultar'
		,'/pessoa-ws/servicos/estado_civil/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')
		

----- Uf -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,@IdTipoServico,@IdLinguagemSistema,'A',NULL,0
		,'corporativo_uf_listar'
		,'WebService do Corporativo'
		,'CORPUFCONSULTAR'
		,'/pessoa-ws/servicos/uf/listar'
		,'/pessoa-ws/servicos/uf/listar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')
	

----- Cor -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,@IdTipoServico,@IdLinguagemSistema,'A',NULL,0
		,'corporativo_cor_listar'
		,'WebService do Corporativo'
		,'CORPCORCONSULTAR'
		,'/pessoa-ws/servicos/cor/listar'
		,'/pessoa-ws/servicos/cor/listar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')
GO

-- CRIACAO DE VINCULO PESSOA CONJUGE
INSERT INTO CORPORATIVO.S_TIPO_VINCULO_PESSOA (ID_TIPO_VINCULO_PESSOA,DS_TIPO_VINCULO_PESSOA) values (19,'CÔNJUGE');
GO

-- CRIACAO DE NOVAS PRORIEDADES
INSERT INTO [SEGURANCA].[S_PROPRIEDADE_APLICACAO] ([DS_CHAVE],[DS_VALOR],[ID_SERVICO])
     VALUES ('nome.ambiente', ??? ,null)
GO

INSERT INTO [SEGURANCA].[S_PROPRIEDADE_APLICACAO] ([DS_CHAVE],[DS_VALOR],[ID_SERVICO])
     VALUES ('id.servico.receita', ??? ,null)
GO

INSERT INTO [SEGURANCA].[S_PROPRIEDADE_APLICACAO] ([DS_CHAVE],[DS_VALOR],[ID_SERVICO])
     VALUES ('id.servico.rh', ??? ,null)
GO

INSERT INTO [SEGURANCA].[S_PROPRIEDADE_APLICACAO] ([DS_CHAVE],[DS_VALOR],[ID_SERVICO])
     VALUES ('corporativo.property.file' ,'/opt/config/minc-pessoa.properties', null)
GO

--> Atualização do nome dos serviços
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/agencia/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/agencia/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/agencia/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/agencia/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/agencia/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/agencia/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/agencia/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/agencia/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/bairro/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/bairro/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/bairro/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/bairro/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/bairro/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/bairro/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/bairro/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/bairro/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/banco/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/banco/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/banco/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/banco/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/banco/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/banco/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/banco/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/banco/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/caracteristica_fisica/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/caracteristica_fisica/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/caracteristica_fisica/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/caracteristica_fisica/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/caracteristica_fisica/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/caracteristica_fisica/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/conta_corrente/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/conta_corrente/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/conta_corrente/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/conta_corrente/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/conta_corrente/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/conta_corrente/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/conta_corrente/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/conta_corrente/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/cor/listar' WHERE NM_ACAO = '/minc-pessoa/servicos/cor/listar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_area/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_area/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_area/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_area/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_area/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_area/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_area/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_area/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_formacao/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_formacao/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_formacao/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_formacao/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_formacao/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_formacao/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_formacao/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_formacao/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_nivel_formacao/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_nivel_formacao/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_nivel_formacao/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_nivel_formacao/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_nivel_formacao/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_nivel_formacao/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso_nivel_formacao/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso_nivel_formacao/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/curso/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/curso/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/documentacao_pessoa/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/documentacao_pessoa/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/documentacao_pessoa/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/documentacao_pessoa/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/documentacao_pessoa/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/documentacao_pessoa/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/email/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/email/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/email/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/email/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/email/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/email/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/email/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/email/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/endereco/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/endereco/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/endereco/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/endereco/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/endereco/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/endereco/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/endereco/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/endereco/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/escolaridade/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/escolaridade/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/estado_civil/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/estado_civil/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/idioma_pessoa/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/idioma_pessoa/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/idioma_pessoa/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/idioma_pessoa/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/idioma_pessoa/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/idioma_pessoa/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/idioma_pessoa/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/idioma_pessoa/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/idioma/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/idioma/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/logradouro/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/logradouro/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/logradouro/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/logradouro/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/logradouro/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/logradouro/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/logradouro/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/logradouro/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/municipio/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/municipio/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pais/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/pais/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/formacao/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/formacao/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/formacao/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/formacao/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/formacao/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/formacao/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_estrangeira/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_estrangeira/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_estrangeira/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_estrangeira/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_estrangeira/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_estrangeira/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_fisica/verificar_situacao_cadastral' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_fisica/verificar_situacao_cadastral';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_fisica/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_fisica/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_fisica/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_fisica/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_juridica/verificar_situacao_cadastral' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_juridica/verificar_situacao_cadastral';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_juridica/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_juridica/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_vinculada/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_vinculada/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_vinculada/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_vinculada/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_vinculada/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_vinculada/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/pessoa_vinculada/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/pessoa_vinculada/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/telefone/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/telefone/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/telefone/cadastrar' WHERE NM_ACAO = '/minc-pessoa/servicos/telefone/cadastrar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/telefone/atualizar' WHERE NM_ACAO = '/minc-pessoa/servicos/telefone/atualizar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/telefone/deletar' WHERE NM_ACAO = '/minc-pessoa/servicos/telefone/deletar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/tipo_abrangencia/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/tipo_abrangencia/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/tipo_email/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/tipo_email/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/tipo_endereco/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/tipo_endereco/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/tipo_pessoa/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/tipo_pessoa/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/tipo_telefone/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/tipo_telefone/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/tipo_vinculo/consultar' WHERE NM_ACAO = '/minc-pessoa/servicos/tipo_vinculo/consultar';
UPDATE SEGURANCA.S_SERVICO SET NM_ACAO = '/pessoa-ws/servicos/uf/listar' WHERE NM_ACAO = '/minc-pessoa/servicos/uf/listar';
UPDATE SEGURANCA.S_SERVICO SET NM_ALIAS = NM_ACAO;
