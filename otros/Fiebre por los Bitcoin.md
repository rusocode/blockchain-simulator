# Fiebre por los Bitcoin

*Informacion extraida desde https://www.gs-zone.org/temas/fiebre-por-los-bitcoin.86922/*  
*Articulo original: 2014 | Actualizacion: 2025*

---

## Introduccion

El debate sobre que hacer con Bitcoin, la divisa electronica cuya naturaleza no reconoce fronteras ni regulaciones, ha
llegado a interesar a diversos gobiernos alrededor del mundo. De forma reciente en aquellos años, Noruega se sumo al
grupo de naciones que emitieron una posicion al respecto, declarando que no la consideraban como una moneda real.

Como antecedente historico, Tailandia se convirtio en el primer pais en prohibir el uso de bitcoins tras una resolucion
emitida por el banco central del pais asiatico, argumentando que no la reconocia como una moneda legitima. De esta
forma, se volvio ilegal operar con esta divisa electronica, tanto para la compra y venta de productos y servicios como
para la transferencia y recepcion de saldo.

Por su parte, dada la atencion que acaparo en ese momento, su cotizacion se caracterizo por ser altamente volatil, lo
que genero una expectativa desmedida con alcances impredecibles. El ejemplo mas visible fue el de **Christopher Koch**,
un estudiante noruego que adquirio 5,000 unidades de bitcoins en 2009 para realizar un trabajo practico, para luego
descubrir que su cuenta se habia revalorizado cuatro años mas tarde en aproximadamente 850 mil dolares.

---

## ¿Que es Bitcoin?

Bitcoin es una moneda electronica descentralizada basada en una red distribuida de computadoras en Internet. Funciona
mediante un sistema de validacion colaborativo llamado "blockchain" o cadena de bloques, que registra todas las
transacciones de forma pública y permanente.

A diferencia de las monedas tradicionales, Bitcoin se puede adquirir mediante:

- **Mineria**: Aportando poder de procesamiento para validar transacciones
- **Compra directa**: En plataformas de intercambio (exchanges)
- **Recepcion como pago**: Por bienes o servicios

Su cotizacion ha sido historicamente volatil, influenciada por decisiones gubernamentales, adopcion del mercado y
eventos mediaticos. Cuando supero la barrera de los 1,000 dolares por unidad en 2013, diversas plataformas de compra y
venta en China debieron adecuarse a los requerimientos del banco central local, lo que provoco fluctuaciones
significativas en su valor.

---

## ¿Que tiene de especial Bitcoin?

Bitcoin representa un cambio de paradigma en el concepto de dinero:

1. **Descentralizacion**: Quita el poder monetario a gobiernos, bancos centrales y entidades financieras para darselo
   directamente al usuario.

2. **Oferta limitada**: Nadie controla la emision de dinero en el mercado. Esta limitado algoritmicamente y nunca habra
   mas de **21 millones de bitcoins**.

3. **Privacidad relativa**: Aunque las transacciones son públicas en la blockchain, son pseudoanonimas, ya que estan
   asociadas a direcciones criptograficas, no a identidades personales directamente.

4. **Transacciones sin intermediarios**: Nadie puede impedir o censurar transacciones entre dos particulares, siempre
   que cumplan con las reglas del protocolo.

5. **Transparencia**: Todo el historial de transacciones es público y auditable por cualquiera.

---

## ¿Para que se puede usar?

### Comprar bienes y servicios

Cada vez mas comercios aceptan pagos con Bitcoin. En los primeros años, sitios como la consola de videojuegos Ouya
admitian bitcoins. En Argentina, plataformas como Idea.me comenzaron a aceptarla para financiamiento colectivo.
Actualmente, su uso se ha expandido significativamente.

### Inversion y especulacion

Debido a su oferta limitada y la creciente demanda, muchas personas lo consideran una reserva de valor. Su precio
aumenta o disminuye según la ley de oferta y demanda.

### Transferencias internacionales

Permite enviar dinero a cualquier parte del mundo con comisiones relativamente bajas y sin necesidad de intermediarios
bancarios.

### Ahorro

En paises con restricciones cambiarias o alta inflacion, ha sido utilizado como forma de preservar valor.

---

## ¿Como se consiguen Bitcoins?

### 1. Mineria

**Nota: Esta informacion es historica (2014). La mineria actual ha evolucionado significativamente.**

Para obtenerlos, originalmente se podian "extraer de una mina virtual". Los bitcoins se generan cuando se resuelven
complejos problemas matematicos (hashes) necesarios para validar bloques de transacciones.

**Datos originales (2014):**

- Recompensa por bloque: 50 BTC → Reducida a 25 BTC en 2012
- Mineria posible con CPU y GPU
- Pools de mineria populares: mining.bitcoin.cz, deepbit.net

**Actualizacion (2025):**

- Recompensa actual: **3.125 BTC** por bloque (tras el halving de 2024)
- La mineria con GPU dejo de ser rentable hace años
- Se requieren equipos especializados llamados **ASICs** (Application-Specific Integrated Circuits)
- El proceso consume gran cantidad de energia electrica
- La dificultad de mineria ha aumentado exponencialmente

### 2. Comprandolos

Se pueden adquirir en plataformas de intercambio (exchanges). En 2014, Mt.Gox era el mas importante, aunque
posteriormente colapso. Actualmente existen exchanges mas seguros y regulados como Binance, Coinbase, Kraken, entre
otros.

### 3. Vendiendolos productos o servicios

Cualquier persona puede aceptar Bitcoin como forma de pago. Existen plataformas de comercio electronico que facilitan
esto.

### 4. Faucets y recompensas

Sitios web que otorgan pequeñas cantidades gratuitas de Bitcoin, generalmente a cambio de ver publicidad o completar
tareas simples. Su rentabilidad es muy baja.

---

## Conceptos tecnicos fundamentales

### ¿Que es una direccion Bitcoin?

Toda persona que participa en la red Bitcoin tiene una **billetera** (wallet) que contiene una o mas direcciones. Estas
funcionan como remitente o receptor para todos los pagos.

**Caracteristicas:**

- No tienen informacion sobre su dueño y son generalmente anonimas
- Formato original: secuencia alfanumerica de aproximadamente 33 caracteres
    - Ejemplo: `1rYK1YzEGa59pI314159KUF2Za4jAYYTd`
- Formatos actuales: Tambien existen direcciones SegWit (comienzan con 3 o bc1) mas eficientes

Los usuarios pueden tener múltiples direcciones y generarlas sin limite, ya que crearlas es practicamente instantaneo y
no requiere contacto con la red. Usar direcciones únicas para cada transaccion ayuda a preservar la privacidad.

### ¿Como se transfieren Bitcoins?

Cuando un usuario A transfiere bitcoins a un usuario B:

1. **A** crea una transaccion que incluye:
    - La direccion de destino (de B)
    - La cantidad a transferir
    - Una firma digital usando su clave privada

2. La transaccion se transmite a la red P2P

3. Los nodos de la red validan:
    - Las firmas criptograficas
    - Que A tenga suficiente saldo
    - Que los bitcoins no hayan sido gastados previamente

4. La transaccion se incluye en un bloque y se añade a la **blockchain**

La blockchain contiene el historial completo de posesion de todas las monedas desde su creacion. Esto previene el doble
gasto y la falsificacion.

---

## Economia de Bitcoin

### ¿Quien controla la economia de Bitcoin?

**Nadie y todos a la vez.** La economia de Bitcoin esta definida por el protocolo original desarrollado por **Satoshi
Nakamoto** (seudonimo del creador o grupo de creadores).

Las reglas de Nakamoto especifican que:

- La cantidad de bitcoins en circulacion crece a un ritmo decreciente
- Limite maximo: **21 millones de BTC**
- Actualmente (2025) hay aproximadamente **19.6 millones** en circulacion

### Emision programada

El suministro de bitcoins sigue un calendario predefinido:

- Cada 210,000 bloques (~4 años) ocurre un **halving** (reduccion a la mitad)
- Emision inicial: 50 BTC por bloque
- 2012: 25 BTC por bloque
- 2016: 12.5 BTC por bloque
- 2020: 6.25 BTC por bloque
- 2024: 3.125 BTC por bloque (actual)

### ¿Existe vulnerabilidad en el sistema?

El protocolo tiene una vulnerabilidad teorica: si mas del 50% del poder de computo de la red quedara bajo control de una
entidad (**ataque del 51%**), esa entidad podria modificar las reglas o manipular transacciones.

Sin embargo, esto es cada vez mas improbable debido a:

- El enorme poder computacional distribuido de la red
- El costo economico prohibitivo de tal ataque
- La falta de incentivo economico (destruiria el valor de Bitcoin)

---

## Preguntas frecuentes

### ¿No es peligroso un suministro fijo de dinero?

Es definitivamente diferente a las monedas tradicionales. La consecuencia mas probable es una **deflacion** constante: a
medida que el crecimiento de bitcoins disminuye y su adopcion aumenta, su valor tiende a incrementarse.

En las economias tradicionales, la deflacion se considera destructiva porque es inesperada. Sin embargo, en Bitcoin es
predecible y todos los participantes la anticipan, lo que cambia la dinamica economica.

---

## Reflexion final (2014 vs 2025)

**En 2014**, Bitcoin era una novedad experimental. Se podia minar con equipos domesticos, pocos comercios lo aceptaban,
y su valor era relativamente bajo (aunque volatil).

**En 2025**, el panorama ha cambiado radicalmente:

- La mineria requiere inversiones millonarias en equipos especializados
- Bitcoin ha ganado aceptacion institucional
- Varios paises lo han adoptado como moneda legal (El Salvador, 2021)
- Grandes empresas mantienen Bitcoin en sus reservas
- La regulacion gubernamental ha evolucionado significativamente
- Han surgido miles de criptomonedas alternativas

Lo que comenzo como un experimento criptografico se ha convertido en un activo financiero reconocido globalmente, aunque
mantiene su esencia descentralizada y su papel como alternativa al sistema financiero tradicional.

---

## Advertencias importantes

1. **Volatilidad**: El precio de Bitcoin puede fluctuar drasticamente en periodos cortos
2. **Seguridad**: La perdida de claves privadas significa perdida permanente de fondos
3. **Irreversibilidad**: Las transacciones no se pueden revertir
4. **Regulacion**: El marco legal varia significativamente entre paises
5. **Riesgo**: Solo invierta lo que pueda permitirse perder

---

*Este documento combina informacion historica del articulo original de 2014 con actualizaciones contextuales para
reflejar la evolucion de Bitcoin hasta 2025.*