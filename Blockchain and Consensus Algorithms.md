# Blockchain

Una blockchain es un software que se descarga en muchos ordenadores que contiene dos cosas: una base de datos donde se
almacena informacion y un algoritmo de consenso para permitir que todos las computadoras que se descargan el software se
pongan de acuerdo en agregar informacion en esta base de datos.

### ¿Por que existe un algoritmo de consenso?

El problema es averiguar como resolver las transacciones para saber cual transaccion va primero. Entonces, los
validadores o mineros son los que trabajan por esta tecnologia. En el caso de Bitcoin lo que hacen es gastar
electricidad para tener acceso a ordenar un bloque en la blockchain y de esa forma llevarse una recompensa. ¿Por que
podemos confiar en que no van a mentir? Porque para tener ese acceso deberan gastar una suma muy grande de dinero y si
estan mintiendo los demas nodos no le aceptar el bloque. Bajo este sistema, lo que conseguimos en incentivar el buen
comportamiento. Este sistema se conoce como **Proof of Work**.

### ¿Que contiene esta base de datos?

Lo principal que contiene son transacciones (cambio en el registro contable). Por ejemplo, si juan manda 10 BTC a Rulo
eso es una transaccion (envio de 10 BTC de una billetera a otra) y cada transaccion se agrupa en bloques. Entonces se
podria decir que un bloque es un listado de transacciones y cada bloque se va sumando en la cadena de bloques. ¿Por que
se llama cadena de bloques? Porque todos los bloques con informacion, transacciones, etc. estan vinculados
matematicamente por un hash. Toda esta base de datos junto al algoritmo de consenso, esta repartida por distintas partes
del mundo, mas especificamente en nodos (ordenadores que se descargan el software de la blockchain) y entre ellos el
objetivo es llegar a un consenso para ir agregando informacion en esta base de datos.

### ¿Que es exactamente el algoritmo de consenso?

Es una metodologia para alinear los incentivos de todos los participantes de la red. Y la unica forma de conseguir que
los integrantes de la red esten incentivados a decir la verdad, es a travez de comprometerse monetariamente. Hay
distintos algoritmos de consenso, en donde el mas usado es el POW que es el que se usa en Bitcoin (gastan energia,
tienen equipos costosos, etc.) para resolver problemas matematicos y llevarse su recompensa. La principal ventaja de ese
algoritmo es lograr una red mucho mas solida ya que esta vinculada al mundo real, por que estos mineros gastan energia,
gastan electricidad, etc. La venaja que tiene eso es que hace que la red sea mucho mas lenta, mas rustica, pero que sea
mas segura. Ahora si pensamos en una red como Ethereum o Solana, son redes que no buscan tener tanta robustes como
Bitcoin, prefieren optimizar mucho mas su velocidad ya que no son reserva de valor como Bitcoin, entonces este sistema
de redes deben buscar otro sistema de consenso para llegar a un acuerdo, que tambien al final les brinde seguridad, que
estas personas esten incentivadas monetariamente, pero que aun asi puedan conseguir mas velocidad. Por lo tanto, de esto
surge el algoritmo de consenso **Proof of Stake**, en donde ahora a diferencia de los mineros estan los **validadores**.
Estos validadores crean como una especie de caja fuerte y dentro colocan tokes de esa blockchain, es decir que bloquean
su dinero, y si mienten, entonce se les quema ese dinero, por lo tanto estan incentivados a decir la verdad. Existen
muchos algoritmos de consenso, pero los mas importantes son PoW Y PoS. Bitcoin necesita que los mineros tengan un gasto
del mundo real porque de esa forma consigue que el compromiso por decir la verdad sea mayor. Los mineros tiene un gasto
en equipos, todos los meses les llega el coste de electricidad usado, entonces la implicacion de estos mineros es mucho
mayor que si dejarian bloqueado ETH. Por lo tanto, la prueba de participacion (PoS) se creo con el objetivo de
solucionar algunos problemas del PoW, en el principal motivo es la falta de escalabilidad y de velocidad ya que el
proceso de mineria agrega un alto nivel de latencia para poder aprobar esa transaccion y poder crear nuevos bloques. Sin
embargo en el PoS se evita toda esta situacion, por eso en las blockchain con PoS las verifiaciones se realizan por
nodos con una alta tenencia en monedas, lo que genera que la red pueda generar bloques muchos mas rapido.



 

