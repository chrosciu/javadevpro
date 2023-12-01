# Wzorce projektowe

## Kreacyjne

### Singleton

* Korzystamy z niego gdy nie możemy się zgodzić na więcej niż jedną instancję danej klasy
* Można powiedzieć że taka instancja jest ulepszoną wersją zmiennej globalnej
* Implementacja jest prosta - ukrywamy konstruktor i udostępniamy statyczną metodę zwracającą instancję (którą trzymamy jako prywatne pole statyczne)
* Uwaga na środowisko wielowątkowe - konieczne są blokady !
* Więcej informacji: [https://refactoring.guru/pl/design-patterns/singleton](https://refactoring.guru/pl/design-patterns/singleton)

### Prototyp

* Pozwala na stworzenie instancji obiektu poprzez skopiowanie istniejącego - oraz zrzuca odpowiedzialność za tę czynność na kopiowany obiekt
* Stosujemy gdy:
  * obiekt nie udostępnia na zewnątrz pól, które są niezbędne by go zbudować od nowa
  * mamy do czynienia z interfejsem i nie wiemy jaka konkretna klasa się pod nim kryje
* Wzorcowa implementacja zakłada zdefiniowanie metody clone, ale akurat w Javie ta metoda i interfejs Cloneable jest bardzo średnio zaprojektowany[](https://): [https://devcave.pl/effective-java/metoda-clone](https://devcave.pl/effective-java/metoda-clone)
* Dlatego zrobimy to inaczej:
  * Jeśli mamy konkretną klasę to najlepszym wyjściem jest konstruktor kopiujący
  * W przypadku interfejsu definiujemy metodę copy (która pod spodem woła ww. konstruktor)
* Więcej informacji: [https://refactoring.guru/pl/design-patterns/prototype](https://refactoring.guru/pl/design-patterns/prototype)

## Behawioralne

### Iterator

* Stosowany wtedy gdy chcemy oddzielić logikę przechodzenia po obiektach od logiki związanej z samym ich składowaniem
* Bądź też, gdy tych sposobów przechodzenia będzie więcej niż jeden (wtedy zaczynają one zaśmiecać logikę samego obiektu / obiektów)
* W implementacji Javowej najlepiej wykorzystać gotowy interfejs `Iterator<E>`
* Więcej informacji: [https://refactoring.guru/pl/design-patterns/iterator](https://refactoring.guru/pl/design-patterns/iterator)

### Interpreter

* Używany gdy mamy do czynienia z parsowaniem / ewaluacją wyrażeń zapisanych w jakimś języku (niekoniecznie programowania !). Ważne aby język posiadał tzw. gramatykę => opis tego jak wyglądają wyrażenia i jak je parsować
* W tym wzorcu każde wyrażenie zapisujemy w postaci drzewa składającego się z literałów, wartości i operatorów
* Dzięki takiemu zapisowi możemy następnie bardzo prosto obliczyć wartość wyrażenia zgodnie z przekazanym kontekstem (np. wartościami zmiennych do podstawienia)
* Sam parser NIE jest częścią wzorca !
* Więcej informacji: [https://www.geeksforgeeks.org/interpreter-design-pattern](https://www.geeksforgeeks.org/interpreter-design-pattern/)

### Memento / Pamiątka / Snapshot / Migawka

* Sprawdza się w sytuacji gdy chcemy umożliwić zapisywanie stanu jakiegoś obiektu oraz jego późniejsze przywracanie, a jednocześnie nie chcemy ujawnić wewnętrznej struktury obiektu
* Stan obiektu wystawiamy na zewnątrz w postaci bardzo obciętego interfejsu migawki (Memento), którego można użyć tylko do przywrócenia tego stanu lub wyciągnięcia informacji o migawce (np. timestamp)
* Najprostsza implementacja w Javie bazuje na klasach wewnętrznych (klasa wewnętrzna ma bowiem dostęp do prywatnych składowych klasy otaczającej, co pozwala na łatwe przywrócenie migawki)
* Więcej informacji: [https://refactoring.guru/pl/design-patterns/memento](https://refactoring.guru/pl/design-patterns/memento)

## Strukturalne

### Adapter

* Do zastosowania w sytuacji gdy musimy wpiąć jakiś istniejący kod (np. bibliotekę) do naszej aplikacji i nie mamy możliwości modyfikacji takiego kodu
* Zwykle inkorporacja polega na tym, iż chcemy aby dostarczyć implementację naszego interfejsu - i często wpinany kod nie umożliwia tego
* Rozwiązaniem jest zastosowanie adaptera, który z jednej strony będzie implementował nasz interfejs a z drugiej - komunikował się z niekompatybilnym kodem.
* Więcej informacji: [https://refactoring.guru/pl/design-patterns/adapter](https://refactoring.guru/pl/design-patterns/adapter)

### Dekorator

* Użyteczny gdy chcemy rozbudować jakąś funkcjonalność naszego obiektu oraz:
  * nie chcemy zaśmiecać kodu obiektu dodatkową logiką
  * dodatkowych funkcjonalności może być kilka
  * dodatkowe funkcjonalności chcemy włączać / wyłączać dynamicznie
* W takiej sytuacji owijamy obiekt za pomocą dekoratora (zachowując jego interfejs) i wprowadzamy dodatkową logikę przed lub po zawołaniu metody na oryginalnym obiekcie
* Dekoratorów może być oczywiście więcej niż jeden (są efektywnie składane w stos)
* Klasa używająca obiektu nie musi być świadoma tego, że jest zamiast niego może być podstawiony dekorator
* Dekorator najlepiej tworzyć z wykorzystaniem abstakcyjnej klasy odpowiedzialnej za owijanie obiektu; potomkowie tej klasy z kolei zawierają konkretne implementacje dekorujące
* Dekorator jest bardzo podobny do wzorca proxy. Główną różnicą jest to, iż dekorator zawsze używa dekorowanego obiektu i jego dekorowanej metody; w przypadku proxy obiekt "dekorowany" może nawet nie istnieć !
* Więcej informacji: https://refactoring.guru/pl/design-patterns/decorator
