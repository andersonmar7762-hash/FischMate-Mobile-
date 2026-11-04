# FischMate Mobile — Android starter

Projeto inicial Android Studio com o nome **FischMate Mobile**, identidade visual roxa/preta e estrutura de serviço de acessibilidade.

## Estado atual
- Aplicativo Android nativo (Kotlin) com tela inicial e controles START/STOP.
- Estrutura declarada para serviço de acessibilidade Android.
- **Ainda não faz pesca automática.** A versão Windows original depende de DXcam, APIs de janela e `SendInput`/mouse/teclado do Windows. Essas partes não podem ser empacotadas diretamente no Android.
- Para chegar à automação real será necessário reimplementar a captura de tela com consentimento do Android (MediaProjection), adaptar o reconhecimento visual OpenCV e implementar gestos Android com AccessibilityService, além de testar com diferentes resoluções.

## Como abrir
1. Abra esta pasta no Android Studio em um computador.
2. Aguarde a sincronização do Gradle.
3. Compile e execute em um aparelho Android 8.0 ou superior.

Este repositório é um **protótipo de interface**, não um APK pronto nem uma versão funcional de auto-fishing.
