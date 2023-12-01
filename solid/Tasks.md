### Single Responsibility Principle, Interface Segregation Principle,  Dependency Inversion Principle

Klasy do zadań znajdują się w pakiecie `sid`

* Zapoznać się klasą `CarCheckup` i testami w klasie `CarCheckupTest`. Na tym etapie przechodzi tylko pierwszy test, drugi reprezentuje bowiem sytuację, w której chcemy zmodyfikować proces mycia samochodu tak, aby było użyte woskowanie (klasa `WaxCarWash`)
* Zastanowić się, jak bardzo skomplikowane (przy obecnym kształcie klasy `CarCheckup`) będzie doprowadzenie do tego aby drugi test przeszedł ?
* Sprawić, aby klasa `CarCheckup` otrzymywała swoją zależność (`CarService`) "z zewnątrz" zamiast ją tworzyć.
* Zastanowić się, czy zależność klasy `CarCheckup` musi być konkretną klasą ? Jeśli nie - to czym ją zastąpić ? 
* Dokonać ekstrakcji interfejsu `CarServicing` i uczynić go zależnością klasy `CarCheckup`
* Zastanowić się, czy interfejs `CarServicing` jest spójny i czy nie należałoby go "rozseparować" na mniejsze kawałki ? Jeśli tak - dokonać podziału.
* Czy na tym etapie da się już dać "wpiąć" woskowanie z klasy `WaxCarWash` ? Jeśli tak - doprowadzić do działania drugi test.
* Zastanowić się, czy klasa `CarService` nie ma za dużo odpowiedzialności ? Jeśli tak - dokonać jej podziału.

### Open-Closed Principle

Klasy do zadań znajdują się w pakiecie `ocp`

* W klasie `CarSearch` znajdują się metoda `findByName` służąca do wyszukiwania samochodów o zadanej nazwie
* W związku z nowym biznesowym (pojawia się potrzeba dodania możliwości wyszukiwania samochodów do zadanego pułapu cenowego) dodać w klasie `CarSearch` metodę `findByMaxPrice`. 
* Zastanowić się co będzie działo się klasą `CarSearch` w momencie, gdy pojawią się wymagania biznesowe co do kolejnych sposobów wyszukiwania ? Czy na pewno konieczne jest każdorazowe zmienianie tej klasy ? Czy też można zrobić to tak, aby jej więcej "nie dotykać" ?
* Po znalezieniu odpowiedzi zmodyfikować tak klasę `CarSearch` aby można było rozszerzać ją o kolejne sposoby wyszukiwania samochodów **bez** jej zmiany 
* Następnie już bez modyfikacji klasy `CarSearch` - zaimplementować możliwość wyszukiwania samochodów o zadanych kolorach.
* Sprawdzić poprawność działania rozwiązań za pomocą testów w klasie `CarSearchTest`.
* DLA CHĘTNYCH: jak zaimplementować wyszukiwanie z użyciem łączenia warunków poprzez operacje AND / OR ?

### Liskov Substitution Principle

Klasy do zadań znajdują się w pakiecie `liskov`

* Zapoznać się z testami w klasie `DriverTest` i uruchomić je. Zweryfikować, że drugi test (w którym używamy instancji klasy `TeslaVehicle`) nie przechodzi - dlaczego ?  
* Zastanowić się, czy klasa `Driver` może zawsze bezpiecznie używać przekazanej do niej instancji `Vehicle` ? Jeśli nie to dlaczego ?
* Spróbować zmodyfikować hierarchię klas w taki sposób aby klasa `Driver` nie mogła zostać "zaskoczona" przez "dziwne" podklasy klasy `Vehicle` (podpowiedź: klasa abstrakcyjna).
* DLA CHĘTNYCH: czy problem można rozwiązać **nie** korzystając z klasy abstrakcyjnej ?  