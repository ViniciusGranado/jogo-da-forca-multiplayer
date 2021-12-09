# jogo-da-forca-multiplayer

## git fetch - Só ve se tem algo novo no repositório

## git pull - Pega o que está no repositório remoto

## git status - Mostra as modificações que você fez

## git add . - Adiciona as modificações para subir

## git reset . - Retira as modificações para subir

## git commit -m "Mensagem" - Adiciona mensagem sobre o que você fez

## git push - Sobe as modificações

# PARA ADICIONAR UM CÓDIGO NOVO

1 - git add . - Adiciona as modificações para subir
2 - git commit -m "Mensagem" - Adiciona mensagem sobre o que você fez
3 - git push - Sobe as modificações

## TESTANDO MAIS UMA VEZ

## TESTANDO OUTRA VEZ

# Roteiro do trabalho

## Cliente

- Criar duas (ou uma) classes para Palavra e Letra, contendo o que o usuário digitou.
- Criar uma classe para dizer que é a vez do jogador
- Criar uma classe para dizer que diz para o jogador esperar a vez dos outros

1 - Printar mensagem de bem-vindo, alguma mensagem que diz para aguardar o jogo iniciar. - Aguardar a chegada de uma classe de comunicado de inicio de jogo

2 - Ao chegar a classe, iniciar o jogo

- Mostraria a interface do jogo

3 - Mostrar se é a vez do jogador, ou se ele deve aguardar os outros jogadores.

- Se for a vez do jogador:
- Opção de palavra ou letra.

  - Se opção de letra:
    - Se acertar letra, mostra para todo mundo. Se for a última letra da palavra, jogador ganha.
    - Passa a vez para o próximo jogador.

  - Se opção de palavra:
    - Se acertar palavra, ganha o jogo, mostra mensagem para todos os jogadores
    - Se errar, desconecta jogador. Mostra palavra para quem perdeu. O jogo continua.
    - Se errar, e só tiver dois jogadores, o jogador que sobrar ganha.
    - Desconecta todo mundo.
