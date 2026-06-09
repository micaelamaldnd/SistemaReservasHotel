# Sistema de Reservas de Hotel 🏨

## Descripción

Aplicación desarrollada en Java aplicando conceptos de Programación Orientada a Objetos (POO), lectura de archivos, herencia, polimorfismo, interfaces, Streams y HashMap.

El sistema permite gestionar reservas de un hotel leyendo la información desde archivos de texto y realizando distintos análisis sobre las reservas registradas.

---

## Tecnologías utilizadas

* Java
* Eclipse IDE
* Programación Orientada a Objetos
* Streams API
* HashMap
* Lectura de Archivos (BufferedReader)
* Herencia
* Polimorfismo
* Interfaces

---

## Estructura del Proyecto

```text
src
│
├── inicio
│   └── Main.java
│
├── model
│   ├── Habitacion.java
│   ├── HabitacionStandard.java
│   ├── HabitacionSuite.java
│   └── Reserva.java
│
├── repo
│   ├── LecturaArchivoRepoImpHabitaciones.java
│   └── LecturaArchivoRepoImpReservas.java
│
├── service
│   ├── ReservasService.java
│   └── ReglasNegocioService.java
│
└── serviceimp
    ├── ReservasServiceImp.java
    └── ReglasNegocioServiceImp.java
```

---

## Archivos utilizados

### habitaciones.txt

```text
101;STANDARD;2;35000
102;SUITE;4;80000
103;STANDARD;2;40000
104;SUITE;4;90000
105;STANDARD;2;30000
106;STANDARD;5;45000
```

Formato:

```text
idHabitacion;tipoHabitacion;capacidad;precioBase
```

---

### reservas.txt

```text
1;Juan;101
2;Maria;102
3;Pedro;104
4;Lucia;103
5;Ana;102
6;Carlos;101
```

Formato:

```text
idReserva;cliente;idHabitacion
```

---

## Conceptos aplicados

### Encapsulamiento

Todos los atributos fueron declarados privados y se accede a ellos mediante getters y setters.

```java
private String cliente;
```

---

### Herencia

La clase abstracta Habitacion es la clase padre.

```java
public abstract class Habitacion
```

Clases hijas:

```java
HabitacionStandard
HabitacionSuite
```

---

### Polimorfismo

Cada tipo de habitación calcula su precio final de forma distinta.

```java
public abstract double calcularPrecioFinal();
```

---

### Interfaces

Se utilizaron interfaces para separar contratos de implementación.

```java
public interface ReservasService
```

```java
public interface ReglasNegocioService
```

---

### Lectura de Archivos

Se implementó mediante:

```java
FileReader
BufferedReader
```

para convertir cada línea del archivo en objetos Java.

---

### Streams

Se utilizaron las siguientes operaciones:

* stream()
* filter()
* map()
* count()
* findFirst()
* anyMatch()
* max()
* min()
* mapToDouble()
* average()
* sum()
* sorted()
* collect(Collectors.toList())

---

### HashMap

Utilizado para:

* Cantidad de reservas por cliente.
* Cantidad de reservas por tipo de habitación.
* Determinar el cliente con más reservas.
* Determinar el tipo de habitación más reservado.

Ejemplo:

```java
HashMap<String,Integer> mapa = new HashMap<>();

mapa.put(cliente,
        mapa.getOrDefault(cliente,0)+1);
```

---

## Funcionalidades implementadas

### Consultas básicas

* Listar todas las reservas.
* Mostrar clientes.
* Mostrar reservas superiores a $50.000.
* Mostrar clientes en mayúsculas.
* Mostrar reservas Premium.
* Contar habitaciones Suite.
* Buscar primera reserva superior a $90.000.

---

### Análisis de reservas

* Verificar existencia de habitaciones para 4 personas.
* Obtener reserva más cara.
* Obtener reserva más barata.
* Calcular facturación total.
* Calcular precio promedio.
* Ordenar reservas de mayor a menor precio.

---

### Clasificación

* Mostrar reservas económicas.
* Mostrar reservas Premium.
* Contar reservas Premium.

---

### Estadísticas con HashMap

* Cantidad de reservas por cliente.
* Cliente con mayor cantidad de reservas.
* Cantidad de reservas por tipo de habitación.
* Tipo de habitación más reservada.

---

### Reporte Final

El sistema genera un resumen general mostrando:

* Cantidad total de reservas.
* Facturación total.
* Precio promedio.
* Reserva más cara.
* Reserva más barata.
* Cantidad de reservas Premium.
* Cliente con más reservas.
* Tipo de habitación más reservado.

---

## Autor

**Micaela Maldonado**

Proyecto realizado como práctica para Parcial de Programación Orientada a Objetos (POO), aplicando herencia, polimorfismo, lectura de archivos, Streams, HashMap e interfaces. 🚀
