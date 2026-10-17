# Calculadora DevOps — Etapa 1

Projeto inicial para aulas de DevOps com Java, Spring Boot, Thymeleaf, Maven, JUnit e Selenium.

**Status:** na etapa 1, o projeto mostra uma pagina web de confirmacao, com os controles da calculadora desabilitados. Na etapa 2, desenvolveremos as operacoes e habilitaremos os campos.

## Requisitos

- Java JDK **21**.
- Eclipse com Maven (m2e); Spring Tools recomendado.
- Conexao com a internet no primeiro carregamento Maven, para baixar dependencias.

## Importar no Eclipse

1. Extraia o ZIP em uma pasta (por exemplo `C:\projetos\calculadora-devops`).
2. Abra o Eclipse e configure o JDK 21 em `Window > Preferences > Java > Installed JREs`.
3. Acesse `File > Import > Maven > Existing Maven Projects`.
4. Em `Root Directory`, selecione a pasta `calculadora-devops` (aquela que contem o `pom.xml`).
5. Clique em `Finish` e aguarde o download das dependencias.
6. Se necessario: clique com o botao direito no projeto > `Maven > Update Project...`.

## Executar

1. Abra `src/main/java/br/edu/exemplo/calculadora/CalculadoraApplication.java`.
2. Clique com o botao direito > `Run As > Spring Boot App` (com Spring Tools), ou `Run As > Java Application`.
3. Espere o servidor indicar que a aplicacao iniciou na porta 8080.
4. Acesse http://localhost:8080/ no navegador.
5. Confira a mensagem **Ambiente configurado com sucesso!**.

Para encerrar, clique no botao Stop (quadrado vermelho) na visualizacao Console do Eclipse.

## Arquivos principais

- `pom.xml`: configuracao Maven e dependencias.
- `CalculadoraApplication.java`: ponto de entrada da aplicacao Spring Boot.
- `controller/PaginaInicialController.java`: recebe `GET /` e seleciona a pagina.
- `templates/index.html`: HTML renderizado pelo Thymeleaf.
- `static/css/estilo.css`: aparencia da pagina.
- `application.properties`: nome do aplicativo e porta do servidor.

## Proximas etapas

**Etapa 2 — Calculadora**

- Criar `service/CalculadoraService.java`, separado da interface.
- Implementar soma, subtracao, multiplicacao e divisao (incluindo erro de divisao por zero).
- Criar a rota para processar o formulario e apresentar o resultado no HTML.
- Manter `id` e `name` estaveis nos controles para facilitar testes Selenium.

**Etapa 3 — GitHub**: versionar e enviar o projeto.

**Etapa 4 — JUnit**: criar testes unitarios na pasta `src/test/java`.

**Etapa 5 — GitHub Actions**: executar os testes no push.

**Etapas 6 e 7 — Selenium**: automatizar a interface e integrar no workflow (dependencias serao adicionadas nessa fase).

**Etapa 8 — Falhas intencionais**: ver o pipeline falhar e voltar ao verde.

## Problemas comuns

- **`java` nao reconhecido**: configurar o `PATH` e o `JAVA_HOME` do JDK 21; reiniciar terminal/Eclipse.
- **Maven com erros de dependencia**: conectar a internet, `Maven > Update Project`; verificar proxy/firewall.
- **JRE diferente**: em `Project > Properties > Java Build Path` selecione JDK 21.
- **Porta 8080 ocupada**: encerrar a aplicacao anterior ou ajustar `server.port`.
- **Pagina nao encontrada**: conferir que a URL e `http://localhost:8080/` e que o Console mostrou a inicializacao bem-sucedida.

## Observacao sobre Maven Wrapper

Esta versao foi preparada para importar diretamente no Eclipse, que inclui o Maven via m2e. O pacote nao inclui o executavel `mvnw`. Para usar Maven no terminal, instale-o separadamente ou gere o Maven Wrapper em uma etapa posterior.
