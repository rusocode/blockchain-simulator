# Wallet

## ¿Que es una Wallet de Criptomonedas?

Una wallet de criptomonedas (tambien conocida como billetera criptografica o monedero virtual) es una herramienta
digital diseñada para almacenar, gestionar y realizar transacciones con criptoactivos como Bitcoin, Ethereum u otras
monedas digitales. A diferencia de una billetera fisica, no guarda las monedas en si mismas, sino que almacena las
claves criptograficas (como claves privadas y publicas) que permiten acceder y controlar esos fondos en la blockchain (
el registro distribuido de transacciones).

### ¿Como funciona?

* **Clave publica:** Actua como tu "direccion" o cuenta bancaria, donde otros envian criptomonedas. Es segura de
  compartir.
* **Clave privada:** Es como la contraseña maestra; con ella, puedes firmar transacciones para enviar fondos. Si la
  pierdes o la roban, puedes perder acceso permanente a tus activos.
* Las transacciones se verifican en la red blockchain (https://bscscan.com/), no en un banco central, lo que hace que
  sea descentralizado y
  seguro (si se maneja bien).

### Tipos de Wallets

Existen varios tipos, segun el nivel de seguridad y uso:

* **Wallets de software (calientes):** Aplicaciones o programas en tu telefono o computadora (ej. Rabby, MetaMask).
  Faciles de usar, pero conectadas a internet, por lo que son mas vulnerables a hacks.
* **Wallets de hardware (frias):** Dispositivos fisicos como USB (ej. Ledger, Trezor). Desconectados de internet,
  ideales para almacenamiento a largo plazo.
* **Wallets de papel:** Simplemente impresiones de tus claves, offline y de bajo costo, pero propensas a daño fisico.
* **Wallets custodiales vs. no custodiales:** Las custodiales (como en exchanges como Binance) las gestiona un tercero;
* las no custodiables de dan control total.

### Ventajas y Riesgos

* **Ventajas:** Control total sobre tus fondos, transacciones rapidas y globales, sin intermediarios.
* **Riesgos:** Si olvidas la clave privada o caes en un phishing, no hay "recuperacion" como en un banco. Siempre usa
  autenticacion de dos factores y verifica las direcciones.

## Claves Publicas y Privadas en Criptomonedas

Las claves publicas y privadas son el nucleo de la criptografia asimetrica (o de clave publica), un sistema matematico
que permite la seguridad y el control en las criptomonedas como Bitcoin o Ethereum. A diferencia de la criptografia
simetrica (donde se usa la misma clave para cifrar y descifrar), aqui ses usan dos claves relacionadas pero distintas:
una publica (que se comparte) y una privada (que se mantiene secreta). Esta relacion ses basa en algoritmos como ECDSA
(para Bitcoin) o EdDSA (para algunas cadenas modernas), que generan pares de claves a partir de numeros aleatorios
grandes. Para mas informacion sobre la criptografia ver: https://www.youtube.com/watch?v=w-qXxSHuHWo

Imagina que las claves son como un candado y una llave: la clave publica es el candado (cualquiera puede cerrarlo), pero
solo la clave privada es la llave que lo abre. Esto permite transacciones seguras sin que un banco o intermediario
controle tus fondos.

### ¿Cómo se Generan las Claves?

1. **Generacion inicial:** Cuando creas una wallet, se genera un numero aleatorio grande (llamado "semilla" o "
   entropia", tipicamente de 256 bits o mas) usando un generador de numeros pseudoaleatorios seguro.
2. **Paso matematico:**
    * De la semilla se deriva la clave privada mediante funciones hash (como SHA-256).
    * La clave privada se multiplica por un punto base en una curva eliptica (por ejemplo, secp256k1 en Bitcoin) para
      obtener la clave publica.
    * Esto es unidireccional: es facil ir de privada a publica, pero imposible revertirlo sin una potencia computacional
      masiva (lo que hace que sea seguro).
3. **Jerarquia en wallets modernas:** Muchas usan BIP-32 (estandar para wallets HD o "jerarquicas deterministicas"),
   donde una sola semilla genera miles de pares de claves, facilitando backups.

### Clave Privada: El Corazon de tu Control

La clave privada es un numero secreto (generalmente representado en formato hexadecimal o como una frase semilla de
12-24 palabras segun BIP-39) que prueba tu propiedad sobre los fondos.

* **Proposito principal:**
    * **Firmar transacciones:** Cuando envias cripto, la clave privada genera una "firma digital" que verifica que tú
      eres el dueño. Esta firma se incluye en la transacción y se valida en la blockchain usando la clave pública
      correspondiente.
    * **Derivar direcciones:** De ella se crea la clave pública, y luego la dirección de wallet (e.g., en Bitcoin: hash
      de la clave pública con RIPEMD-160 y SHA-256, codificado en Base58 para "1..." o Bech32 para "bc1...").
* **Caracteristicas:**
    * **Longitud:** Típicamente 256 bits (un número de ~77 dígitos decimales). Hay ~2^256 posibles claves, un número
      mayor que los átomos en el universo observable —imposible de adivinar.
    * **Seguridad:** Debe guardarse offline (en hardware wallets o papel). Si se pierde, pierdes acceso irreversible a
      tus fondos. Si se roba (phishing, malware), el ladrón puede vaciar tu wallet.
    * **Ejemplo en acción:** Para transferir 1 BTC, firmas con tu privada: "Yo autorizo mover X de mi dirección A a B".
      La red verifica la firma sin ver tu privada.
