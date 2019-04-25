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


----- Esfera ------------------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,@IdTipoServico,@IdLinguagemSistema,'A',NULL,0
		,'corporativo_esfera_consultar'
		,'WebService de Esfera'
		,'CORPESFERACONSULTAR'
		,'/pessoa-ws/servicos/esfera/consultar'
		,'/pessoa-ws/servicos/esfera/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')