# Java Coding Challenge

L'obiettivo di questo esercizio è quello di consentirti di mostrarci quello che sai e come approcceresti un progetto reale.

## Aspetti Generali

- Troverai la struttura base dell'applicazione e il codice nella directory `cars` .Puoi usare il file  `ANSWERS.md` se vuoi scrivere una breve spiegazione e\o descrizione della tua soluzione.
- Per semplificare un po' le cose abbiamo aggiunto gli asset necessari e le configurazioni nella directory:`src/main/resources`

> Dopo aver importato il progetto nel tuo ide, dovresti essere pronto ad iniziare.L'applicazione cars si troverà sulla porta `8080` dopo averla lanciata con il comando `mvn spring-boot:run`

### Lo stack tecnologico

Di seguito una lista delle tecnologie che troverai nella struttura dell'applicazione: 

 - Java 8
 - Spring boot 2.1.4
 - Maven 3.3.9 or above
 - Tomcat server 9 (embedded)
 - H2 embedded database
 - Spring Data JPA

> Sentiti libero\a di aggiungere qualsiasi dipendenza riterrai necessaria ma, per favore mantieni fisse le tecnologie dello stack base sopra riportato.

## Introduzione

Il nostro cliente è un grande concessionario di auto con molte filiali regionali in tutta la nazione. <br>
Ha richiesto un servizio che consenta all'applicazione in uso ai venditori nelle diverse filiali locali di leggere le caratteristiche delle auto. <br>
Le specifiche delle auto, provengono da diverse case automobilistiche e, sono in diversi formati, l'idea è di unificare i dati ed esporli con un'interfaccia standard come un servizio RESTful.

### A - Le entità 

Puoi trovare un esempio del file di caratteristiche delle auto della Ford chiamatoo ford-example.xml all'interno della directory resources dell'applicazione.
Crea un diagramma UML del modello di classe per spiegare come rappresenterai le informazioni in quel file. Ricordati di creare una struttura dati, entità e relazioni normalizzate.

> Fornisci il diagramma come immagine e includilo nella risposta. <br>
Puoi anche usare il file `ANSWERS.md` per spiegare più in dettaglio lo schema se lo desideri.

### B - Ingest dei dati
Il nostro cliente desidera iniziare a inserire le caratteristiche dell'auto della Ford che vengono fornite in formato XML.

Troverai un'attività pianificata all'interno della classe `FordIngesterTask` configurata per essere eseguita ogni minuto.
Usalo per elaborare il file `ford-example.xml` dal filesystem e inserire tutti i dati nel database fornito come hai progettato nella parte` A`.

> Sentiti libero di modificare la configurazione pianificata per eseguire l'attività più o meno frequentemente secondo necessità.

> Si consiglia di implementare tutto il necessario utilizzando entità JPA e repository Spring per rendere persistenti i dati. <br>
Usa i seguenti package java `com.carseller.cars.repositories` e` com.carseller.cars.domain`.
L'applicazione cars è già configurata per trovare entità e repository all'interno di quei pacchetti.

### C - Esponi i dati con un'API RESTful
Crea i seguenti endpoint API RESTful per:
 - 1)Ottieni caratteristiche dell'auto tramite ID
 - 2)Ottieni tutte le caratteristiche dell'auto per marca

> Tutti gli endpoint devono esporre i risultati in formato JSON.

### D - Frontend Jquery Bootstrap

Realizza una pagina di frontend con jquery+bootstrap+bootstraptable che interroghi il secondo servizio dei servizi al punto C e visualizzi l'elenco delle specifiche.

### E - Se sei arrivato fin qui....

il cliente vuole poter cambiare l'ordine dei risultati nell'elenco del punto D direttamente dalla pagina del front end, come lo faresti con jquery e bootsrap?

### F - Aggiunta di immagini (opzionale)
Spiega *** (nessun codice necessario) *** come faresti per aggiungere dei file di immagine al processo della parte `B`. <br>
Tieni presente che il cliente vuole includerli come parte delle risposte degli endpoint nella parte "C".

### G - Miglioramenti
C'è qualcosa che ritieni possa essere migliorato nella tua soluzione? **Spiega per favore**

## FAQ
- Devo fornire un codice pulito e applicare modelli di progettazione e buone pratiche?
  - Decisamente sì! Valuteremo questi aspetti.
- Devo aggiungere test?
  - I test sono sempre importanti! Nel caso di questa sfida non sono obbligatori, ma verifica sempre ciò che ritieni importante.
- Devo utilizzare alcune librerie specifiche?
  - No, crea l'applicazione con gli strumenti che preferisci, non ci sono limiti. Conserva solo le librerie già fornite.