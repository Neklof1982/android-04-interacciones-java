# 🚀 Practica 04 - Cambio de color en 4 regiones

## 📝 Descripción

Esta práctica muestra cómo manejar diferentes tipos de interacción táctil en Android para cambiar el color de cuatro regiones (`TextView`) distintas.

Cada rectángulo responde a un gesto distinto:

- **Rectángulo 1:** Cambio de color con un **tap** (clic).
- **Rectángulo 2:** Cambio de color con un **toque prolongado** (long press).
- **Rectángulo 3:** Cambia color al mantener pulsado y vuelve al original al soltar.
- **Rectángulo 4:** Cambia color al mantener pulsado y arrastrar dentro del área, vuelve al color original al salir o soltar.

El fondo general es verde, con los rectángulos en rojo oscuro y el texto blanco.

## ⚙️ Tecnologías usadas

- Android SDK 34  
- ConstraintLayout  
- Java (MainActivity)  
- Edge-to-Edge API para diseño inmersivo  

## 📐 Diseño UI

- Layout principal `activity_main.xml` con **ConstraintLayout**.
- Cuatro `TextView` con tamaño fijo y color inicial rojo oscuro.
- Texto explicativo en cada rectángulo para indicar el gesto esperado.
- Fondo general con color verde `#78AE47`.

## 🚀 Ejecución

1. Abrir el proyecto en **Android Studio** con SDK 34 configurado.  
2. Compilar y ejecutar en dispositivo o emulador con Android 11 (API 30) o superior.  
3. Interactuar con cada rectángulo usando los gestos indicados para cambiar el color.

## 📌 Versionado

Este proyecto usa **Git** y **GitHub** para el control de versiones.

## 📄 Licencia

Este proyecto está bajo la [MIT License](./LICENSE).

## 🎁 Expresiones de Gratitud

📢 Puedes invitarme a una cerveza 🍺 o un café ☕.  
Gracias por la lectura y que disfrutes el código! 🤓
