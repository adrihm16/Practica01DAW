
# Calculadora Java

## Descripción
Calculadora simple en Java que realiza operaciones básicas y avanzadas (suma, resta, multiplicación, división, potencia y raíz cuadrada).  
Incluye API técnica generada con Javadoc y un sitio de documentación estático creado con MkDocs Material y desplegado automáticamente en GitHub Pages.

---

## Herramientas usadas para generar documentación HTML

### a) Generador de documentación HTML
- **Javadoc** (para la API Java)
- **MkDocs Material** (para generar un sitio web de documentación)

### a.1) Comandos ejecutados para generar documentación localmente

# 1. Compilar código Java
javac src/calculadora/*.java

# 2. Generar la documentación de la API con Javadoc
javadoc -d docs/api -sourcepath src -subpackages calculadora -author -version -encoding UTF-8 -charset UTF-8

# 3. Construir el sitio web con MkDocs Material
pip install mkdocs mkdocs-material
mkdocs build

# 4. Probar el sitio en local (verificar contenido y rutas)
mkdocs serve
---

## b) Ejemplos de código documentado
`src/calculadora/Calculadora.java`

```java
/**
 * Clase que implementa operaciones matemáticas básicas y avanzadas.
 *
 * @author Adrián Herrera
 * @version 1.1
 */
public class Calculadora {

    /**
     * Suma dos números y devuelve el resultado.
     *
     * @param a primer número
     * @param b segundo número
     * @return resultado de la suma
     */
    public double sumar(double a, double b) {
        return a + b;
    }

    /**
     * Divide dos números y devuelve el resultado.
     *
     * @param a dividendo
     * @param b divisor
     * @return resultado de la división
     * @throws ArithmeticException si b es 0
     */
    public double dividir(double a, double b) throws ArithmeticException {
        if (b == 0) throw new ArithmeticException("No se puede dividir entre 0");
        return a / b;
    }
}
```


## c) Acceso público a la documentación desplegada

* Sitio de documentación completo (MkDocs + API Javadoc):
  `https://adrihm16.github.io/Practica01DAW/`
* API técnica Javadoc:
  `https://adrihm16.github.io/Practica01DAW/api/package-summary.html`

---

## d) Workflow de publicación y despliegue continuo

El archivo workflow está en:

```
.github/workflows/deploy.yml
```

Contenido del workflow usado para despliegue automático:

```yaml
name: Deploy Docs

on:
  push:
    branches:
      - main

permissions:
  contents: write

jobs:
  deploy:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout
        uses: actions/checkout@v3

      - name: Setup Python
        uses: actions/setup-python@v3
        with:
          python-version: '3.9'

      - name: Install MkDocs
        run: pip install mkdocs mkdocs-material

      - name: Build site
        run: mkdocs build

      - name: Deploy GH Pages
        uses: peaceiris/actions-gh-pages@v3
        with:
          github_token: ${{ secrets.GITHUB_TOKEN }}
          publish_dir: ./site
```

### d.1) Configuración del repositorio para GitHub Pages

1. La acción despliega el contenido generado a la branch `gh-pages`.
2. En **Settings → Pages** se selecciona:

```
Source: Deploy from a branch → gh-pages → /(root)
```

3. Esto permite servir el sitio estático públicamente, actualizado en cada push a `main`.

---

## e) Mensajes de commit recomendados 

```
Add Calculadora class with operations
Document methods using JavaDoc tags
Add docs structure and mkdocs.yml
Configure GitHub Actions workflow for automatic docs deploy
Enable GitHub Pages deployment from gh-pages branch
```

### e.1) Justificación

Son claros porque usan verbos en imperativo, son descriptivos, explican acciones concretas del cambio y además no son ambiguos y permiten ver la evolución del CI/CD y despliegue

---

## f) Clonar, usar y regenerar documentación localmente

### f.1) Clonar el repositorio

```bash
git clone https://github.com/<tu-usuario>/<tu-repo>.git
cd <tu-repo>
```

### f.2) Compilar y regenerar la documentación local

```bash
javac src/calculadora/*.java
javadoc -d docs/api -sourcepath src -subpackages calculadora -author -version -encoding UTF-8 -charset UTF-8
pip install mkdocs mkdocs-material
mkdocs build
mkdocs serve
```

La documentación generada quedará accesible en:

```
http://127.0.0.1:8000/
http://127.0.0.1:8000/api/index.html
```

---

## g) Colaboración, accesibilidad y seguridad

### g.1) Colaboración (ventajas de GitHub Pages)

GitHub Pages permite:

* Compartir documentación siempre actualizada
* Acceso público a la web sin necesidad de clonar el proyecto
* Navegación visual del API y la guía de uso
* Servir recursos estáticos de forma eficiente

**Ventajas frente a solo tener HTML en el repo**

* No es necesario descargar los HTML para visualizarlos
* Permite una interfaz navegable
* Facilita la colaboración externa sin entregar acceso al código fuente
* El equipo puede ver la doc desde el navegador

### g.2) Accesibilidad y seguridad

* El sitio GitHub Pages es público, accesible para cualquier usuario
* El código fuente del repositorio puede mantenerse privado
* Así se garantiza que la documentación es visible para todos, pero el código solo para autorizados

---

## h) Integración continua y despliegue continuo (CI/CD)

Este workflow implementa CI/CD porque:

* Ejecuta compilación y generación automática de documentación
* Se dispara por cada `push a main`
* Publica automáticamente a GitHub Pages sin intervención manual
* Es despliegue continuo porque cada cambio integrado despliega la documentación actualizada al entorno público sin pasos adicionales

---

## Conclusiones

### Cuestionario de evaluación

| CE | Pregunta                                                          | Respuesta                                                                                                                                                                                                |
| -- | ----------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| a  | ¿Qué herramienta utilizaste para crear la doc HTML?               | Usé Javadoc para la API de Java,  MkDocs Material para el sitio web.                                                                                                                            |
| b  | Muestra un fragmento documentado y comenta su estilo              | Se mostró código de Java en `Calculadora.java` con JavaDoc usando `@param`, `@return`, `@throws`. Estilo: JavaDoc.                                                                                   |
| c  | ¿Qué configuración usaste para publicar la doc en GitHub Pages?   | Usé un workflow que hace `mkdocs build` y despliega `site/` con la acción `peaceiris/actions-gh-pages@v3`, publicando a la branch `gh-pages`, y configuré GitHub Pages para servir esa branch desde `/`. |
| d  | ¿Qué ventajas ofrece GitHub Pages para compartir doc?             | Permite ver la documentación sin clonar el repo, mantenerla siempre actualizada, dar navegación web, y facilitar la colaboración externa sin exponer el código.                                          |
| e  | ¿Son tus mensajes de commit claros e imperativos? Justifica       | Sí, porque describen acciones concretas en imperativo y documentan hitos del despliegue y configuración CI/CD sin ambigüedad.                                                                            |
| f  | ¿Cómo garantizas documentación pública pero código seguro?        | Manteniendo el repositorio privado y GitHub Pages público, lo que permite compartir doc sin dar acceso al código fuente.                                                                         |
| g  | ¿Dónde en tu README explicas acceso a la doc y comandos usados?   | Secciones: `Documentación HTML`, `Acceso público`, `Clonar y regenerar`. Ahí se detalla todo.                                                                                                            |
| h  | ¿Qué evento dispara el workflow? ¿Por qué es despliegue continuo? | El evento es push a main. Es despliegue continuo porque genera y publica la documentación automáticamente a GitHub Pages tras integrar cambios.                                                      |

---

### Conclusiones
* La documentación puede generarse automáticamente en cada integración (`push`), lo que agiliza el trabjo y elimina errores humanos.
* GitHub Pages permite distribuir doc sin entregar código, con navegación web ligera.
* Un workflow correctamente configurado implementa CI/CD aplicado a documentación, ya que emplea automatización y despliegue continuo a un entorno público sin procesos manuales.






