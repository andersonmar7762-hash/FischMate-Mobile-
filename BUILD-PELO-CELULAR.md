# Gerar o APK usando somente o Android

Este projeto é um protótipo de interface e diagnóstico. Ainda não executa pesca automática.

## Compilação pela nuvem com GitHub Actions
1. No navegador do celular, entre em https://github.com e crie uma conta ou entre na sua conta.
2. Crie um repositório novo chamado `FischMateMobile`. Selecione-o como **Private** se preferir.
3. Extraia o ZIP no celular usando o gerenciador de arquivos.
4. No repositório, use **Add file > Upload files** e envie o CONTEÚDO da pasta `FischMateMobile` (incluindo `.github`). Não envie apenas o ZIP.
5. Faça commit dos arquivos na branch `main`.
6. Abra a aba **Actions** do repositório. Se necessário, confirme que deseja habilitar workflows.
7. Escolha **Build FischMate Mobile APK** e toque em **Run workflow** (ou aguarde o workflow iniciado pelo commit).
8. Quando terminar com sucesso, abra a execução e baixe o artifact `FischMate-Mobile-debug-APK`.
9. Extraia o artifact ZIP. Dentro estará `app-debug.apk`. Toque nele para instalar; o Android pode pedir autorização para instalar apps dessa fonte.

## Observações
- O APK gerado é de depuração, não é uma versão publicada na Play Store.
- Não compartilhe tokens, senhas ou chaves do GitHub.
- O projeto requer conexão à internet durante a compilação para baixar dependências Android/Gradle.
- A compilação não transforma o protótipo em auto-fishing: reconhecimento e automação ainda precisam ser implementados e testados separadamente.
