# EinkaufslisteKotlin
Kotlin Projekt 1

In diesem Projekt habe ich mich anhand einer Kotlin-Einstiegsanleitung an diesem Projekt rangehangelt, um mich erstmal mit diesem Programm und dieser Programmiersprache zurechtzufinden.
Da es sich um ein vier Jahre altes Video handelte, sind einige der genutzen Features nicht ohne dieselbe Version importierbar gewesen (alt+Enter hatte bei mir versagt), weshalb der Code leider nicht ausführbar ist.
Jedenfalls habe ich innerhalb des Layout-Ordners in res in den xml-Dateien die Views hinzugefügt und angepasst, wodurch zumindest eine grobe Struktur der Liste und Buttons ersichtlich wäre oder war. 
Die Todo-Class ist eine Data Class, die nur zwei Properties für die Übersicht vom Titel als String und der Check-Box zum Abhaken beinhaltet.
In der Todo-Adapter-Class befindet sich der - eigentlich ausführbare - Code, der die Funktionen enthält. Darin geht es um die Liste an Items, die in die Einkaufsliste geschrieben werden. Durch den RecyclerView werden nur die Einträge geladen, die gerade in der App sichtbar wären.
Der Inflater im ViewHolder greift als Referenz das Layout auf, das im xml-File definiert ist. Mit den Funktionen addTodo und deleteDoneTodos werden jeweils ein Eintrag hinzugefügt und die abgehakten Einträge entfernt.
In der MainActivity wird grob die Reihenfolge der angezeigten Einträge bestimmt und das Verhalten der Buttons nach dem Anklicken festgelegt. 
