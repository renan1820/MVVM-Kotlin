# MVVM-Kotlin

## Introdução

Arquitetura MVVM em Android em Kotlin utilizando o Data Binding e Retrofit.


### [Data Binding][binding]

É uma biblioteca de suporte que permite fazer ligações entre os componentes do seu layout 
com a fonte de dados do seu aplicativo usando uma forma declarativa, isto é, você pode referenciar 
fonte de dados de dentro dos seus arquivos de layout.xml.

### [Lifecycle][lifecycle]

Componentes lifecycle-aware são componentes que conseguem ajustar seu comportamento de acordo 
com o ciclo de vida de uma Activity ou Fragment, ou seja, conseguem performar ações em resposta
ao ciclo de vida como o onPause, onStart, onResume, …

A utilização desse pacote te auxilia a deixar as regras de seu componente autocontida, possibilitando 
que suas activities e fragments fiquem o mais ignorante possível, em outras palavras, isso ajuda 
manter seu código organizado, fácil de manter e com redução de force closed relacionado a operações de ciclo de vida.

### [LiveData][livedata]

É um data holder observável, quer dizer, um objeto que adere ao observable pattern, encapsula dados do tipo observável,
todavia, ele é um objeto lifecycle aware. Objetos lifecycle aware respeitam o ciclo de vida da sua aplicação, ou seja,
ele atende ao ciclo de vida dos seus componentes (activities, fragments, etc…)

### [Room][room]

É uma biblioteca de persistência que provê uma abstração para acessar o seu banco de dados no 
SQLite(do seu dispositivo) de uma forma robusta. Ela também simplifica a criação de cache para a sua aplicação e 
possui uma abordagem semelhante ao Retrofit, ou seja, é implementada através de interfaces e anotações.

[binding]: https://developer.android.com/topic/libraries/data-binding
[lifecycle]: https://developer.android.com/topic/libraries/architecture/lifecycle
[livedata]: https://developer.android.com/topic/libraries/architecture/livedata
[room]: https://developer.android.com/topic/libraries/architecture/room
