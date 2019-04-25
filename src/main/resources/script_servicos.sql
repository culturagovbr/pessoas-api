USE [DBMINC]
GO
DECLARE @IdServico bigint;

----- Agencia -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_agencia_consultar'
		,'WebService do Corporativo'
		,'CORPAGENCIACONSULTAR'
		,'/pessoa-ws/servicos/agencia/consultar'
		,'/pessoa-ws/servicos/agencia/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_agencia_cadastrar'
		,'WebService do Corporativo'
		,'CORPAGENCIACADASTRAR'
		,'/pessoa-ws/servicos/agencia/cadastrar'
		,'/pessoa-ws/servicos/agencia/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_agencia_atualizar'
		,'WebService do Corporativo'
		,'CORPAGENCIAATUALIZAR'
		,'/pessoa-ws/servicos/agencia/atualizar'
		,'/pessoa-ws/servicos/agencia/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_agencia_deletar'
		,'WebService do Corporativo'
		,'CORPAGENCIADELETAR'
		,'/pessoa-ws/servicos/agencia/deletar'
		,'/pessoa-ws/servicos/agencia/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Bairro -----------------------------------------------------------------------------
--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_bairro_cadastrar'
		,'WebService do Corporativo'
		,'CORPBAIRROCADASTRAR'
		,'/pessoa-ws/servicos/bairro/cadastrar'
		,'/pessoa-ws/servicos/bairro/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_bairro_deletar'
		,'WebService do Corporativo'
		,'CORPBAIRRODELETAR'
		,'/pessoa-ws/servicos/bairro/deletar'
		,'/pessoa-ws/servicos/bairro/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_bairro_consultar'
		,'WebService do Corporativo'
		,'CORPBAIRROCONSULTAR'
		,'/pessoa-ws/servicos/bairro/consultar'
		,'/pessoa-ws/servicos/bairro/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_bairro_atualizar'
		,'WebService do Corporativo'
		,'CORPBAIRROATUALIZAR'
		,'/pessoa-ws/servicos/bairro/atualizar'
		,'/pessoa-ws/servicos/bairro/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Banco -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_banco_consultar'
		,'WebService do Corporativo'
		,'CORPBANCOCONSULTAR'
		,'/pessoa-ws/servicos/banco/consultar'
		,'/pessoa-ws/servicos/banco/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_banco_cadastrar'
		,'WebService do Corporativo'
		,'CORPBANCOCADASTRAR'
		,'/pessoa-ws/servicos/banco/cadastrar'
		,'/pessoa-ws/servicos/banco/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_banco_deletar'
		,'WebService do Corporativo'
		,'CORPBANCODELETAR'
		,'/pessoa-ws/servicos/banco/deletar'
		,'/pessoa-ws/servicos/banco/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_banco_atualizar'
		,'WebService do Corporativo'
		,'CORPBANCOATUALIZAR'
		,'/pessoa-ws/servicos/banco/atualizar'
		,'/pessoa-ws/servicos/banco/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- CaracteristicaFisica -----------------------------------------------------------------------------
--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_caracteristica_fisica_cadastrar'
		,'WebService do Corporativo'
		,'CORPCARACTERISTICAFISICACADAST'
		,'/pessoa-ws/servicos/caracteristica_fisica/cadastrar'
		,'/pessoa-ws/servicos/caracteristica_fisica/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_caracteristica_fisica_atualizar'
		,'WebService do Corporativo'
		,'CORPCARACTERISTICAFISICAATUALI'
		,'/pessoa-ws/servicos/caracteristica_fisica/atualizar'
		,'/pessoa-ws/servicos/caracteristica_fisica/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_caracteristica_fisica_deletar'
		,'WebService do Corporativo'
		,'CORPCARACTERISTICAFISICADELETA'
		,'/pessoa-ws/servicos/caracteristica_fisica/deletar'
		,'/pessoa-ws/servicos/caracteristica_fisica/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- ContaCorrente -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_conta_corrente_consultar'
		,'WebService do Corporativo'
		,'CORPCONTACORRENTECONSULTAR'
		,'/pessoa-ws/servicos/conta_corrente/consultar'
		,'/pessoa-ws/servicos/conta_corrente/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_conta_corrente_cadastrar'
		,'WebService do Corporativo'
		,'CORPCONTACORRENTECADASTRAR'
		,'/pessoa-ws/servicos/conta_corrente/cadastrar'
		,'/pessoa-ws/servicos/conta_corrente/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_conta_corrente_atualizar'
		,'WebService do Corporativo'
		,'CORPCONTACORRENTEATUALIZAR'
		,'/pessoa-ws/servicos/conta_corrente/atualizar'
		,'/pessoa-ws/servicos/conta_corrente/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_conta_corrente_deletar'
		,'WebService do Corporativo'
		,'CORPCONTACORRENTEDELETAR'
		,'/pessoa-ws/servicos/conta_corrente/deletar'
		,'/pessoa-ws/servicos/conta_corrente/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Cor -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_cor_listar'
		,'WebService do Corporativo'
		,'CORPCORCONSULTAR'
		,'/pessoa-ws/servicos/cor/listar'
		,'/pessoa-ws/servicos/cor/listar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')
GO


----- CursoArea -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_area_consultar'
		,'WebService do Corporativo'
		,'CORPCURSOAREACONSULTAR'
		,'/pessoa-ws/servicos/curso_area/consultar'
		,'/pessoa-ws/servicos/curso_area/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_area_cadastrar'
		,'WebService do Corporativo'
		,'CORPCURSOAREACADASTRAR'
		,'/pessoa-ws/servicos/curso_area/cadastrar'
		,'/pessoa-ws/servicos/curso_area/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_area_atualizar'
		,'WebService do Corporativo'
		,'CORPCURSOAREAATUALIZAR'
		,'/pessoa-ws/servicos/curso_area/atualizar'
		,'/pessoa-ws/servicos/curso_area/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_area_deletar'
		,'WebService do Corporativo'
		,'CORPCURSOAREADELETAR'
		,'/pessoa-ws/servicos/curso_area/deletar'
		,'/pessoa-ws/servicos/curso_area/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- CursoFormacao -----------------------------------------------------------------------------
--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_formacao_deletar'
		,'WebService do Corporativo'
		,'CORPCURSOFORMACAODELETAR'
		,'/pessoa-ws/servicos/curso_formacao/deletar'
		,'/pessoa-ws/servicos/curso_formacao/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_formacao_consultar'
		,'WebService do Corporativo'
		,'CORPCURSOFORMACAOCONSULTAR'
		,'/pessoa-ws/servicos/curso_formacao/consultar'
		,'/pessoa-ws/servicos/curso_formacao/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_formacao_cadastrar'
		,'WebService do Corporativo'
		,'CORPCURSOFORMACAOCADASTRAR'
		,'/pessoa-ws/servicos/curso_formacao/cadastrar'
		,'/pessoa-ws/servicos/curso_formacao/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_formacao_atualizar'
		,'WebService do Corporativo'
		,'CORPCURSOFORMACAOATUALIZAR'
		,'/pessoa-ws/servicos/curso_formacao/atualizar'
		,'/pessoa-ws/servicos/curso_formacao/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- CursoNivelFormacao -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_nivel_formacao_consultar'
		,'WebService do Corporativo'
		,'CORPCURSONIVELFORMACAOCONSULTA'
		,'/pessoa-ws/servicos/curso_nivel_formacao/consultar'
		,'/pessoa-ws/servicos/curso_nivel_formacao/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_nivel_formacao_cadastrar'
		,'WebService do Corporativo'
		,'CORPCURSONIVELFORMACAOCADASTRA'
		,'/pessoa-ws/servicos/curso_nivel_formacao/cadastrar'
		,'/pessoa-ws/servicos/curso_nivel_formacao/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_nivel_formacao_atualizar'
		,'WebService do Corporativo'
		,'CORPCURSONIVELFORMACAOATUALIZA'
		,'/pessoa-ws/servicos/curso_nivel_formacao/atualizar'
		,'/pessoa-ws/servicos/curso_nivel_formacao/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_nivel_formacao_deletar'
		,'WebService do Corporativo'
		,'CORPCURSONIVELFORMACAODELETAR'
		,'/pessoa-ws/servicos/curso_nivel_formacao/deletar'
		,'/pessoa-ws/servicos/curso_nivel_formacao/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Curso -----------------------------------------------------------------------------
--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_deletar'
		,'WebService do Corporativo'
		,'CORPCURSODELETAR'
		,'/pessoa-ws/servicos/curso/deletar'
		,'/pessoa-ws/servicos/curso/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_consultar'
		,'WebService do Corporativo'
		,'CORPCURSOCONSULTAR'
		,'/pessoa-ws/servicos/curso/consultar'
		,'/pessoa-ws/servicos/curso/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_cadastrar'
		,'WebService do Corporativo'
		,'CORPCURSOCADASTRAR'
		,'/pessoa-ws/servicos/curso/cadastrar'
		,'/pessoa-ws/servicos/curso/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_curso_atualizar'
		,'WebService do Corporativo'
		,'CORPCURSOATUALIZAR'
		,'/pessoa-ws/servicos/curso/atualizar'
		,'/pessoa-ws/servicos/curso/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- DocumentacaoPessoa -----------------------------------------------------------------------------
--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_documentacao_pessoa_cadastrar'
		,'WebService do Corporativo'
		,'CORPDOCUMENTACAOPESSOACADASTRA'
		,'/pessoa-ws/servicos/documentacao_pessoa/cadastrar'
		,'/pessoa-ws/servicos/documentacao_pessoa/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_documentacao_pessoa_atualizar'
		,'WebService do Corporativo'
		,'CORPDOCUMENTACAOPESSOAATUALIZA'
		,'/pessoa-ws/servicos/documentacao_pessoa/atualizar'
		,'/pessoa-ws/servicos/documentacao_pessoa/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_documentacao_pessoa_deletar'
		,'WebService do Corporativo'
		,'CORPDOCUMENTACAOPESSOADELETAR'
		,'/pessoa-ws/servicos/documentacao_pessoa/deletar'
		,'/pessoa-ws/servicos/documentacao_pessoa/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Email -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_email_consultar'
		,'WebService do Corporativo'
		,'CORPEMAILCONSULTAR'
		,'/pessoa-ws/servicos/email/consultar'
		,'/pessoa-ws/servicos/email/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_email_atualizar'
		,'WebService do Corporativo'
		,'CORPEMAILATUALIZAR'
		,'/pessoa-ws/servicos/email/atualizar'
		,'/pessoa-ws/servicos/email/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_email_cadastrar'
		,'WebService do Corporativo'
		,'CORPEMAILCADASTRAR'
		,'/pessoa-ws/servicos/email/cadastrar'
		,'/pessoa-ws/servicos/email/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_email_deletar'
		,'WebService do Corporativo'
		,'CORPEMAILDELETAR'
		,'/pessoa-ws/servicos/email/deletar'
		,'/pessoa-ws/servicos/email/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Endereco -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_endereco_consultar'
		,'WebService do Corporativo'
		,'CORPENDERECOCONSULTAR'
		,'/pessoa-ws/servicos/endereco/consultar'
		,'/pessoa-ws/servicos/endereco/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_endereco_cadastrar'
		,'WebService do Corporativo'
		,'CORPENDERECOCADASTRAR'
		,'/pessoa-ws/servicos/endereco/cadastrar'
		,'/pessoa-ws/servicos/endereco/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_endereco_atualizar'
		,'WebService do Corporativo'
		,'CORPENDERECOATUALIZAR'
		,'/pessoa-ws/servicos/endereco/atualizar'
		,'/pessoa-ws/servicos/endereco/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_endereco_deletar'
		,'WebService do Corporativo'
		,'CORPENDERECODELETAR'
		,'/pessoa-ws/servicos/endereco/deletar'
		,'/pessoa-ws/servicos/endereco/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Escolaridade -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_escolaridade_consultar'
		,'WebService do Corporativo'
		,'CORPESCOLARIDADECONSULTAR'
		,'/pessoa-ws/servicos/escolaridade/consultar'
		,'/pessoa-ws/servicos/escolaridade/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')
		
----- Estado Civil -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_estado_civil_consultar'
		,'WebService do Corporativo'
		,'CORPESTADOCIVILCONSULTAR'
		,'/pessoa-ws/servicos/estado_civil/consultar'
		,'/pessoa-ws/servicos/estado_civil/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- IdiomaPessoa -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_idioma_pessoa_consultar'
		,'WebService do Corporativo'
		,'CORPIDIOMAPESSOACONSULTAR'
		,'/pessoa-ws/servicos/idioma_pessoa/consultar'
		,'/pessoa-ws/servicos/idioma_pessoa/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_idioma_pessoa_cadastrar'
		,'WebService do Corporativo'
		,'CORPIDIOMAPESSOACADASTRAR'
		,'/pessoa-ws/servicos/idioma_pessoa/cadastrar'
		,'/pessoa-ws/servicos/idioma_pessoa/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_idioma_pessoa_atualizar'
		,'WebService do Corporativo'
		,'CORPIDIOMAPESSOAATUALIZAR'
		,'/pessoa-ws/servicos/idioma_pessoa/atualizar'
		,'/pessoa-ws/servicos/idioma_pessoa/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_idioma_pessoa_deletar'
		,'WebService do Corporativo'
		,'CORPIDIOMAPESSOADELETAR'
		,'/pessoa-ws/servicos/idioma_pessoa/deletar'
		,'/pessoa-ws/servicos/idioma_pessoa/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Idioma -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_idioma_consultar'
		,'WebService do Corporativo'
		,'CORPIDIOMACONSULTAR'
		,'/pessoa-ws/servicos/idioma/consultar'
		,'/pessoa-ws/servicos/idioma/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Logradouro -----------------------------------------------------------------------------
--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_logradouro_deletar'
		,'WebService do Corporativo'
		,'CORPLOGRADOURODELETAR'
		,'/pessoa-ws/servicos/logradouro/deletar'
		,'/pessoa-ws/servicos/logradouro/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_logradouro_consultar'
		,'WebService do Corporativo'
		,'CORPLOGRADOUROCONSULTAR'
		,'/pessoa-ws/servicos/logradouro/consultar'
		,'/pessoa-ws/servicos/logradouro/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_logradouro_cadastrar'
		,'WebService do Corporativo'
		,'CORPLOGRADOUROCADASTRAR'
		,'/pessoa-ws/servicos/logradouro/cadastrar'
		,'/pessoa-ws/servicos/logradouro/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_logradouro_atualizar'
		,'WebService do Corporativo'
		,'CORPLOGRADOUROATUALIZAR'
		,'/pessoa-ws/servicos/logradouro/atualizar'
		,'/pessoa-ws/servicos/logradouro/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Municipio -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_municipio_consultar'
		,'WebService do Corporativo'
		,'CORPMUNICIPIOCONSULTAR'
		,'/pessoa-ws/servicos/municipio/consultar'
		,'/pessoa-ws/servicos/municipio/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Pais -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pais_consultar'
		,'WebService do Corporativo'
		,'CORPPAISCONSULTAR'
		,'/pessoa-ws/servicos/pais/consultar'
		,'/pessoa-ws/servicos/pais/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- PessoaCursoFormacao -----------------------------------------------------------------------------
--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_formacao_cadastrar'
		,'WebService do Corporativo'
		,'CORPPESSOACURSOFORMACAOCADASTR'
		,'/pessoa-ws/servicos/formacao/cadastrar'
		,'/pessoa-ws/servicos/formacao/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_formacao_atualizar'
		,'WebService do Corporativo'
		,'CORPPESSOACURSOFORMACAOATUALIZ'
		,'/pessoa-ws/servicos/formacao/atualizar'
		,'/pessoa-ws/servicos/formacao/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_formacao_deletar'
		,'WebService do Corporativo'
		,'CORPPESSOACURSOFORMACAODELETAR'
		,'/pessoa-ws/servicos/formacao/deletar'
		,'/pessoa-ws/servicos/formacao/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- PessoaEstrangeira -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_estrangeira_consultar'
		,'WebService do Corporativo'
		,'CORPPESSOAESTRANGEIRACONSULTAR'
		,'/pessoa-ws/servicos/pessoa_estrangeira/consultar'
		,'/pessoa-ws/servicos/pessoa_estrangeira/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_estrangeira_cadastrar'
		,'WebService do Corporativo'
		,'CORPPESSOAESTRANGEIRACADASTRAR'
		,'/pessoa-ws/servicos/pessoa_estrangeira/cadastrar'
		,'/pessoa-ws/servicos/pessoa_estrangeira/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_estrangeira_atualizar'
		,'WebService do Corporativo'
		,'CORPPESSOAESTRANGEIRAATUALIZAR'
		,'/pessoa-ws/servicos/pessoa_estrangeira/atualizar'
		,'/pessoa-ws/servicos/pessoa_estrangeira/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- PessoaFisica -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_fisica_consultar'
		,'WebService do Corporativo'
		,'CORPPESSOAFISICACONSULTAR'
		,'/pessoa-ws/servicos/pessoa_fisica/consultar'
		,'/pessoa-ws/servicos/pessoa_fisica/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_fisica_atualizar'
		,'WebService do Corporativo'
		,'CORPPESSOAFISICAATUALIZAR'
		,'/pessoa-ws/servicos/pessoa_fisica/atualizar'
		,'/pessoa-ws/servicos/pessoa_fisica/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')

--> VERIFICAR SITUAÇÃO CADASTRAL
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_fisica_verificar_situacao_cadastral'
		,'WebService do Corporativo'
		,'CORPPESSOAFISICACONSULTAR'
		,'/pessoa-ws/servicos/pessoa_fisica/verificar_situacao_cadastral'
		,'/pessoa-ws/servicos/pessoa_fisica/verificar_situacao_cadastral'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')

		
----- PessoaJuridica -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_juridica_consultar'
		,'WebService do Corporativo'
		,'CORPPESSOAJURIDICACONSULTAR'
		,'/pessoa-ws/servicos/pessoa_juridica/consultar'
		,'/pessoa-ws/servicos/pessoa_juridica/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')

--> VERIFICAR SITUAÇÃO CADASTRAL
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_juridica_verificar_situacao_cadastral'
		,'WebService do Corporativo'
		,'CORPPESSOAJURIDICACONSULTAR'
		,'/pessoa-ws/servicos/pessoa_juridica/verificar_situacao_cadastral'
		,'/pessoa-ws/servicos/pessoa_juridica/verificar_situacao_cadastral'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')
		

----- PessoaVinculada -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_vinculada_consultar'
		,'WebService do Corporativo'
		,'CORPPESSOAVINCULADACONSULTAR'
		,'/pessoa-ws/servicos/pessoa_vinculada/consultar'
		,'/pessoa-ws/servicos/pessoa_vinculada/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_vinculada_cadastrar'
		,'WebService do Corporativo'
		,'CORPPESSOAVINCULADACADASTRAR'
		,'/pessoa-ws/servicos/pessoa_vinculada/cadastrar'
		,'/pessoa-ws/servicos/pessoa_vinculada/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_vinculada_atualizar'
		,'WebService do Corporativo'
		,'CORPPESSOAVINCULADAATUALIZAR'
		,'/pessoa-ws/servicos/pessoa_vinculada/atualizar'
		,'/pessoa-ws/servicos/pessoa_vinculada/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_pessoa_vinculada_deletar'
		,'WebService do Corporativo'
		,'CORPPESSOAVINCULADADELETAR'
		,'/pessoa-ws/servicos/pessoa_vinculada/deletar'
		,'/pessoa-ws/servicos/pessoa_vinculada/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Telefone -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_telefone_consultar'
		,'WebService do Corporativo'
		,'CORPTELEFONECONSULTAR'
		,'/pessoa-ws/servicos/telefone/consultar'
		,'/pessoa-ws/servicos/telefone/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> CADASTRAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_telefone_cadastrar'
		,'WebService do Corporativo'
		,'CORPTELEFONECADASTRAR'
		,'/pessoa-ws/servicos/telefone/cadastrar'
		,'/pessoa-ws/servicos/telefone/cadastrar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> ATUALIZAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_telefone_atualizar'
		,'WebService do Corporativo'
		,'CORPTELEFONEATUALIZAR'
		,'/pessoa-ws/servicos/telefone/atualizar'
		,'/pessoa-ws/servicos/telefone/atualizar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


--> DELETAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_telefone_deletar'
		,'WebService do Corporativo'
		,'CORPTELEFONEDELETAR'
		,'/pessoa-ws/servicos/telefone/deletar'
		,'/pessoa-ws/servicos/telefone/deletar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- TipoAbrangencia -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_tipo_abrangencia_consultar'
		,'WebService do Corporativo'
		,'CORPTIPOABRANGENCIACONSULTAR'
		,'/pessoa-ws/servicos/tipo_abrangencia/consultar'
		,'/pessoa-ws/servicos/tipo_abrangencia/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- TipoEmail -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_tipo_email_consultar'
		,'WebService do Corporativo'
		,'CORPTIPOEMAILCONSULTAR'
		,'/pessoa-ws/servicos/tipo_email/consultar'
		,'/pessoa-ws/servicos/tipo_email/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- TipoEndereco -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_tipo_endereco_consultar'
		,'WebService do Corporativo'
		,'CORPTIPOENDERECOCONSULTAR'
		,'/pessoa-ws/servicos/tipo_endereco/consultar'
		,'/pessoa-ws/servicos/tipo_endereco/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- TipoPessoa -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_tipo_pessoa_consultar'
		,'WebService do Corporativo'
		,'CORPTIPOPESSOACONSULTAR'
		,'/pessoa-ws/servicos/tipo_pessoa/consultar'
		,'/pessoa-ws/servicos/tipo_pessoa/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- TipoTelefone -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_tipo_telefone_consultar'
		,'WebService do Corporativo'
		,'CORPTIPOTELEFONECONSULTAR'
		,'/pessoa-ws/servicos/tipo_telefone/consultar'
		,'/pessoa-ws/servicos/tipo_telefone/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- TipoVinculo -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_tipo_vinculo_consultar'
		,'WebService do Corporativo'
		,'CORPTIPOVINCULOCONSULTAR'
		,'/pessoa-ws/servicos/tipo_vinculo/consultar'
		,'/pessoa-ws/servicos/tipo_vinculo/consultar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')


----- Uf -----------------------------------------------------------------------------
--> CONSULTAR
set @IdServico = NEXT VALUE FOR SEGURANCA.SQ_SERVICO;

INSERT INTO [SEGURANCA].[S_SERVICO] ([ID_SERVICO],[ID_TIPO_SERVICO],[ID_LINGUAGEM_SISTEMA],[ST_SERVICO],[DT_VALIDADE_SERVICO],[TP_VISIBILIDADE],[NM_SERVICO],[DS_SERVICO],[SG_SERVICO],[NM_ACAO],[NM_ALIAS],[DS_LOCALIZACAO])
	VALUES (@IdServico,4,2,'A',NULL,0
		,'corporativo_uf_listar'
		,'WebService do Corporativo'
		,'CORPUFCONSULTAR'
		,'/pessoa-ws/servicos/uf/listar'
		,'/pessoa-ws/servicos/uf/listar'
		,'/opt/jboss-as-7.1.1-minc/standalone/data/content')

