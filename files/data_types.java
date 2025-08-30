// Alap adattípusok

int integerNumber = 6;             // Egész szám
float floatNumber = 5.99f;         // Lebegőpontos számok
char character = 'A';              // Karakter
boolean myBool = true;             // Boolean
String text = "Hello";             // Szöveglánc


byte byteNumber = 30;              // Számok -128 és 127 között
short shortNumber = 2400;          // Számok -32,768 és 32,767 között
int intNumber = 405555;            // Számok -2,147,483,648 és 2,147,483,647 között
long longNumber = 505087587578;    // Számok -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807 között
float floatNumber = 5.99f          // Számok 6 és 7 közötti tizedesjegy 
double doubleNumber = 51.4155952;  // Számok 15 és 16 közötti tizedesjegy

// Típus "casting"

// Kisebb nagyobra váltás - automatikus
// byte -> short -> char -> int -> long -> float -> double

int myInt = 9;           // 9
double myDouble = myInt; // 9.0

// nagyobb kisebbre váltás - manuális
double myDouble = 9.78d;    // 9.54
int myInt = (int) myDouble; // 9

// Enum
// Használat pl.: Kategória: egy, kettő, három
enum Category{
  ONE,
  TWO,
  THREE
}
