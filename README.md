# ProgramsNMoviesTVAzteca

Aplicación Android desarrollada con Kotlin y Jetpack Compose, enfocada en explorar programas de televisión, consultar información detallada y navegar por un catálogo de contenido multimedia.

El proyecto utiliza la API pública de TVmaze y está organizado siguiendo principios de Clean Architecture, el patrón MVVM (Model–View–ViewModel) y buenas prácticas de desarrollo Android moderno.

1. Descripción del proyecto

ProgramsNMoviesTVAzteca es una aplicación Android que permite consultar programas de televisión mediante una interfaz moderna, intuitiva y adaptable a los temas claro y oscuro del dispositivo.

El objetivo del proyecto es aplicar tecnologías modernas del ecosistema Android, separación de responsabilidades, consumo de servicios REST y manejo reactivo del estado de la interfaz.

Funcionalidades

- Consulta de programas de televisión desde la API de TVmaze.
- Visualización de programas mediante tarjetas con imágenes y títulos.
- Carrusel horizontal de categorías destacadas.
- Navegación entre la pantalla principal y la pantalla de detalles.
- Consulta de información específica mediante el identificador de cada programa.
- Visualización de sinopsis, géneros, calificaciones y otros detalles disponibles.
- Soporte para modo claro y modo oscuro.
- Actualización de contenido mediante Pull to Refresh.
- Manejo de estados de carga, éxito y error.
- Interfaz desarrollada con Jetpack Compose y Material Design 3.

2. Autor

David Fonseca Acosta

Desarrollador Android enfocado en Kotlin, Jetpack Compose, arquitectura de software y desarrollo de aplicaciones móviles.

GitHub: [DavidFon1189](https://github.com/DavidFon1189)

3. Herramientas y tecnologías

 Kotlin | Lenguaje principal de programación 
 Jetpack Compose | Desarrollo declarativo de interfaces 
 Material Design 3 | Componentes y sistema de diseño 
 Android Studio | Entorno de desarrollo 
 Gradle Kotlin DSL | Configuración y automatización de compilación 
 Retrofit | Consumo de servicios REST 
 Gson Converter | Conversión de respuestas JSON 
 Kotlin Coroutines | Ejecución de operaciones asíncronas 
 StateFlow | Manejo reactivo del estado 
 ViewModel | Administración del estado de presentación 
 Hilt | Inyección de dependencias 
 Navigation Compose | Navegación entre pantallas 
 Coil | Carga de imágenes remotas 
 TVmaze API | Fuente de información de programas 
 Git y GitHub | Control de versiones 

4. Arquitectura del proyecto

La aplicación utiliza Clean Architecture + MVVM, con una separación de responsabilidades entre las capas de presentación, dominio y datos.

Presentation / UI

Responsable de mostrar la información, administrar eventos del usuario y observar los estados del ViewModel.

Componentes principales:

HomeScreen
HomeRoute
HomeViewModel
MediaDetailScreen
MediaDetailRoute
MediaDetailViewModel
FeaturedCarousel
MediaCard
AppNavigation

Domain

Contiene los modelos de negocio, contratos de repositorios y casos de uso.

Componentes principales:

MediaContent
MediaDetails
CategoryContent
MediaRepository
GetShowsUseCase
GetShowDetailsUseCase

Data

Responsable de la comunicación con fuentes externas y de transformar las respuestas de la API en modelos de dominio.

Componentes principales:

TvMazeApiService
ShowDto
ShowMapper
MediaRepositoryImpl

Dependency Injection

Hilt administra la creación y provisión de dependencias.

Componentes principales:

NetworkModule
RepositoryModule
ProgramsNMoviesApplication

Los resultados regresan hacia el ViewModel, que actualiza el estado observado por la interfaz.


5. API utilizada

El proyecto utiliza la API pública de TVmaze.
https://www.tvmaze.com/api


Endpoints principales

Obtener programas:

GET /shows?page=0


Obtener detalles de un programa:

GET /shows/{id}


Ejemplo de petición

GET https://api.tvmaze.com/shows/82


Retrofit utiliza el identificador del programa seleccionado para construir la petición correspondiente.

Los datos recibidos se convierten a modelos de dominio mediante funciones de mapeo.

Nota: TVmaze proporciona principalmente metadatos de programas de televisión; no ofrece directamente la reproducción de películas o tráileres.

6. Instrucciones de uso

1. Abre la aplicación en un dispositivo Android o emulador.
2. Explora el carrusel de categorías destacadas.
3. Desplázate por el listado de programas.
4. Selecciona una tarjeta para consultar los detalles del programa.
5. Utiliza el botón de regreso para volver a la pantalla principal.
6. Desliza hacia abajo desde el inicio de la pantalla para actualizar los programas.
7. Activa el tema oscuro del dispositivo para probar la apariencia de la aplicación en Dark Mode.

La aplicación necesita una conexión a Internet para consultar la información de TVmaze.

8. Guía de compilación y ejecución

Requisitos previos

- Android Studio con soporte para Kotlin y Jetpack Compose.
- Android SDK instalado.
- JDK compatible con la versión de Gradle configurada en el proyecto.
- Git.
- Emulador Android o dispositivo físico con depuración USB habilitada.
- Conexión a Internet.

### Paso 1. Clonar el repositorio
git clone https://github.com/DavidFon1189/ProgramsNMoviesTVAzteca.git

El enlace anterior corresponde al nombre propuesto para el repositorio y deberá coincidir con el repositorio que se cree en GitHub.

Paso 2. Abrir el proyecto

1. Inicia Android Studio.
2. Selecciona Open.
3. Busca la carpeta ProgramsNMoviesTVAzteca.
4. Espera a que termine la sincronización de Gradle.

Paso 3. Configurar el entorno

Verifica que Android Studio tenga instalado el SDK requerido por el archivo app/build.gradle.kts.

Asegúrate también de que Gradle utilice un JDK compatible con el proyecto.

Paso 4. Compilar

Desde la terminal de la raíz del proyecto:

Windows:
.\gradlew.bat assembleDebug


macOS / Linux:
./gradlew assembleDebug


Si la compilación finaliza correctamente, el APK de depuración se genera normalmente en:

app/build/outputs/apk/debug/app-debug.apk


Paso 5. Ejecutar

Desde Android Studio:

1. Conecta un dispositivo Android o inicia un emulador.
2. Selecciona el dispositivo de destino.
3. Presiona Run.
4. Espera a que se instale y abra la aplicación.

También puedes instalar el APK mediante ADB:

adb install -r app/build/outputs/apk/debug/app-debug.apk


Paso 6. Verificar el funcionamiento

Comprueba que:

- El carrusel de categorías se visualice correctamente.
- Se carguen los programas desde TVmaze.
- Las imágenes aparezcan en las tarjetas.
- La navegación a detalles funcione.
- La actualización mediante Pull to Refresh realice una nueva consulta.
- Los temas claro y oscuro se apliquen correctamente.

9. Buenas prácticas aplicadas

- Separación de responsabilidades mediante Clean Architecture.
- Patrón MVVM para la gestión de la presentación.
- Inyección de dependencias con Hilt.
- Uso de interfaces para desacoplar el dominio de las implementaciones.
- Casos de uso para organizar las operaciones.
- Transformación de DTOs a modelos de dominio.
- Operaciones asíncronas mediante Kotlin Coroutines.
- Manejo reactivo del estado con StateFlow.
- Componentes reutilizables con Jetpack Compose.
- Navegación mediante rutas parametrizadas.
- Manejo de errores y estados de carga.

10. Mejoras futuras

- Incorporación de tráileres mediante una fuente de videos compatible.
- Reproducción de vistas previas en tarjetas destacadas.
- Búsqueda de programas.
- Filtrado por géneros y categorías.
- Pantalla de favoritos.
- Persistencia local mediante Room.
- Paginación del catálogo.
- Pruebas unitarias de ViewModels y casos de uso.
- Pruebas de integración y pruebas de interfaz.

11. Créditos

Los datos de programas de televisión se obtienen de TVmaze.

Sitio oficial: https://www.tvmaze.com/

Este proyecto se desarrolla con fines educativos y de portafolio. Las imágenes, títulos y demás contenidos proporcionados por servicios externos pertenecen a sus respectivos titulares.

Desarrollado por David Fonseca Acosta — Android Development | Kotlin | Jetpack Compose**
