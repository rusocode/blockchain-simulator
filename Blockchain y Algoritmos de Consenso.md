# Blockchain

Una blockchain es un software descargable que contiene una base de datos y un algoritmo de consenso para que multiples
computadoras acuerden como agregar informacion.

### ¿Por que existe un algoritmo de consenso?

El algoritmo resuelve que transaccion va primero. Los validadores o mineros trabajan gastando recursos (como
electricidad en Bitcoin) para ordenar bloques y recibir recompensas. El sistema incentiva el buen comportamiento porque
mentir resulta costoso y los demas nodos rechazaran bloques fraudulentos. Este sistema se llama **Proof of Work**.

### ¿Que contiene esta base de datos?

Contiene principalmente transacciones (cambio en el registro contable) agrupadas en bloques. Cada bloque es un listado
de transacciones vinculadas matematicamente por un hash, formando una cadena. Esta base de datos y el algoritmo estan
distribuidos en nodos alrededor del mundo que buscan consenso para agregar informacion.

### ¿Que es exactamente el algoritmo de consenso?

Es una metodologia para alinear incentivos mediante compromiso monetario. El PoW (usado en Bitcoin) requiere gastar
energia y equipos costosos para resolver problemas matematicos, creando una red mas lenta pero muy segura y vinculada al
mundo real. El **Proof of Stake** (PoS) surgio como alternativa para redes como Ethereum o Solana, donde los
**validadores** bloquean tokens como garantia y los pierden si mienten, logrando mayor velocidad. Bitcoin prefiere PoW
porque el gasto real en equipos y electricidad genera mayor compromiso que solo bloquear tokens. El PoS soluciona
problemas de escalabilidad y velocidad del PoW, permitiendo crear bloques mucho mas rapido al evitar el proceso de
mineria.