package org.blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * <h2>Algoritmo SHA-256</h2>
 * SHA-256 posee propiedades criptograficas fundamentales que lo hacen ideal para blockchain. En primer lugar, es determinista, lo
 * que significa que el mismo input siempre producira el mismo hash de manera consistente. Ademas, es computacionalmente rapido de
 * calcular, permitiendo procesar grandes cantidades de datos de forma eficiente. Una caracteristica crucial es el efecto
 * avalancha, donde un cambio minimo en el input, incluso de un solo bit, genera un hash completamente diferente e impredecible.
 * Tambien es irreversible o unidireccional, lo que implica que es computacionalmente imposible obtener el input original a partir
 * del hash resultante. Finalmente, es resistente a colisiones, es decir, resulta practicamente imposible encontrar dos inputs
 * diferentes que produzcan el mismo hash, lo cual garantiza la unicidad e integridad de cada bloque en la cadena.
 * <p>
 * Ver: <a href="https://www.criptonoticias.com/criptopedia/que-es-funcion-hash-como-influye-bitcoin/">¿Que es una funcion hash y
 * como se usa en Bitcoin?</a>
 * <h2>Metodo {@code mineBlock()}</h2>
 * Implementa el Proof of Work (Prueba de Trabajo), que es el mecanismo que hace costoso y seguro agregar bloques a la
 * blockchain.
 * <h3>Desglose paso a paso:</h3>
 * <ol>
 * <li><b>Crear el objetivo</b>
 * <pre>{@code
 * String target = new String(new char[difficulty]).replace('\0', '0');
 * }</pre>
 * <ul>
 *  <li>Si {@code difficulty = 2}, crea el string {@code "00"}
 *  <li>Si {@code difficulty = 4}, crea el string {@code "0000"}
 *  <li>Este es el patron que el hash debe cumplir al inicio
 * </ul>
 * <li><b>El ciclo de minado</b>
 * <pre>{@code
 * while (!hash.substring(0, difficulty).equals(target)) {
 *     nonce++;
 *     hash = calculateHash();
 * }
 * }</pre>
 * <ul>
 * <li>Compara los primeros N caracteres del hash con el objetivo
 * <li>Si NO coinciden (por ejemplo, el hash empieza con {@code "a7"} en lugar de {@code "00"}):
 * <ul>
 *  <li>Incrementa el {@code nonce}
 *  <li>Recalcula el hash completo
 *  <li>Vuelve a verificar
 * </ul>
 * </ul>
 * </ol>
 * El <b>nonce</b> es un numero al azar que se añade a los datos antes del hashing. Pero como esta es una implementacion educativa,
 * <b>se hace un incremento secuencial del nonce y no aleatorio para simplificar el objetivo educativo. Los nonces aleatorios son
 * importantes cuando multiples mineros compiten simultaneamente (evita que todos prueben los mismos valores en el mismo orden).</b>
 * El nonce es algo de lo que ya se explicaba en 2013 en pocos sitios de internet <a href="https://www.oroyfinanzas.com/2013/05/infografia-transacciones-bitcoin/">Infografia sobre las transacciones con Bitcoin</a>
 * <h3>¿Por que existe esto?</h3>
 * Imagina que quieres modificar un bloque antiguo para robar Bitcoins:
 * <ol>
 * <li>Modificas el bloque 100
 * <li>Su hash cambia
 * <li>Ahora debes <b>re-minar</b> el bloque 100 (puede tardar minutos)
 * <li>El hash del bloque 100 cambio, asi que rompes el bloque 101
 * <li>Debes <b>re-minar</b> el bloque 101
 * <li>Y asi sucesivamente con TODOS los bloques siguientes
 * </ol>
 * Mientras tu intentas hacer esto, la red honesta sigue agregando nuevos bloques. Es una carrera que no puedes ganar a menos que
 * tengas mas poder computacional que TODA la red combinada (ataque del 51%).
 * <p>
 * Con {@code difficulty = 2}, el bloque busca un hash como:
 * <pre>{@code
 * Intento 1 (nonce=0): "a7f3c2..." No empieza con "00"
 * Intento 2 (nonce=1): "3b91ef..." No empieza con "00"
 * Intento 3 (nonce=2): "8c45aa..." No empieza con "00"
 * ...
 * Intento 47 (nonce=46): "00c8d5..." ¡Encontrado! Empieza con "00"
 * }</pre>
 * <p>
 * En el mundo real de Bitcoin, la dificultad actual requiere aproximadamente 19 ceros al inicio del hash, lo que equivale a unos
 * 75 bits de ceros. Esto demanda billones de intentos de calculo para encontrar un hash valido. Con todo el poder computacional
 * combinado de la red mundial de mineros, se tarda aproximadamente 10 minutos en encontrar un bloque valido. Por esta razon se
 * denomina "mineria", ya que requiere un trabajo computacional extremadamente intenso y costoso en terminos de electricidad y
 * recursos.
 * <p>
 * Para comprenderlo mejor, podemos usar una analogia simple. El proceso de minado es como buscar una aguja en un pajar, pero con
 * caracteristicas particulares. Cada intento de calcular un hash es instantaneo, sin embargo no existe ninguna forma inteligente
 * o atajo para encontrar el hash correcto, simplemente hay que probar y probar una y otra vez de manera aleatoria. Cuantos mas
 * ceros se requieran al inicio del hash, mas grande se vuelve ese pajar hipotetico donde debemos buscar. En el sistema real de
 * Bitcoin, el minero o pool de mineros que encuentre primero el hash valido gana la recompensa del bloque, incentivando asi la
 * competencia y el mantenimiento de la red.
 */

public class Block {

    private final int index;
    private final long timestamp;
    private String data;
    private String previousHash;
    private int nonce;
    private String hash;

    public Block(int index, long timestamp, String data, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.previousHash = previousHash;
        this.nonce = 0;
        this.hash = calculateHash();
    }

    /**
     * La linea {@code String target = new String(new char[difficulty]).replace('\0', '0');} reemplaza todos los caracteres nulos
     * (si difficulty = 2, crea: ['\0', '\0']) con el caracter '0'. Este string de ceros define la dificultad del <b>Proof of
     * Work</b>. El algoritmo de minado buscara un hash que <b>comience</b> con esa cantidad de ceros.
     * <p>
     * El impacto de la seguridad depende de la dificultad. Una dificultad de 2 significa que el hash debe empezar con 2 ceros
     * ("00") lo que requiere <b>~256 intentos en promedio</b> (aunque puede variar: algunos bloques necesitaran menos y otros
     * mas). Una dificultad de 3 requiere ~4,096 intentos en promedio. Una dificultad de 19 (como en Bitcoin) requiere billones de
     * intentos (~10 minutos aproximadamente con todo el poder computacional de la red).
     * <p>
     * El bucle es el corazon del Proof of Work ya que <b>busca activamente</b> un hash valido obligando al sistema a
     * <b>probar</b> miles o millones de valores de {@code nonce}, <b>recalcular</b> el hash en cada iteracion, <b>verificar</b>
     * si cumple con la dificultad y <b>repetir</b> hasta encontrar un hash valido. Este proceso de minado (busqueda activa) es
     * computacionalmente costoso, mientras que verificar un bloque ya minado es instantaneo. Esta asimetria es lo que hace que
     * modificar la blockchain sea computacionalmente costoso e impractico.
     */
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        // Mientras el hash NO cumpla con la dificultad requerida, continua buscando hasta que los primeros 2 caracteres del hash coincidan con "00"
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        System.out.println("Mined block: " + hash);
    }

    /**
     * Calcula el hash del bloque.
     *
     * @return el hash del bloque que basicamente es una cadena de 64 caracteres hexadecimales
     */
    public String calculateHash() {
        try {
            // 1. Concatena todos los datos del bloque
            String input = index + timestamp + data + previousHash + nonce;
            // 2. Obtiene una instancia del algoritmo SHA-256 (hash de 256 bits equivalente a 64 caracteres hexadecimales)
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // 3. Aplica el hash a los datos convirtiendo primero los bytes a formato UTF-8 y luego aplicando el hash SHA-256
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            // 4. Convierte los bytes a formato hexadecimal legible
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                /* Esta linea convierte un byte en su representacion hexadecimal como string, pero utiliza la operacion 0xff & b
                 * para resolver un problema especifico de Java. En Java, los bytes son con signo, lo que significa que tienen un
                 * rango de -128 a 127, pero cuando queremos convertirlos a hexadecimal necesitamos tratarlos como valores sin signo
                 * (0 a 255). El valor 0xff representa 255 en decimal o 11111111 en binario (8 bits todos en 1), y al aplicar el
                 * operador AND bit a bit (&) con el byte, estamos "enmascarando" el valor para eliminar la extension de signo que
                 * Java hace automaticamente. Sin esta mascara, un byte con valor -1 (que en binario es 11111111) se extenderia a 32
                 * bits al convertirse a int, produciendo 0xffffffff en lugar del valor deseado 0xff. La mascara 0xff & b asegura que
                 * siempre obtengamos un valor positivo entre 0 y 255, permitiendo que Integer.toHexString() genere la representacion
                 * hexadecimal correcta de dos caracteres (o uno, que luego se completa con padding) para cada byte del hash. */
                String hex = Integer.toHexString(0xff & b);
                // Agrega un cero de relleno (padding) cuando un byte se convierte a hexadecimal y resulta en un solo caracter
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getNonce() {
        return nonce;
    }

    public int getIndex() {
        return index;
    }

}
