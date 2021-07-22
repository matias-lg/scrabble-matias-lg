# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

At the moment all the native types of Scrabble have been implemented with all their methods and tests.
All operations works as one would expect (+, -, *, /, AND, OR, NOT), this operations return the type of the left operand if possible. This methods have been implemented using *double dispatch*. 



Some things to consider: For SBinary to work as intended you need to pass a 32 byte binary as a String using two's complement, if there's less than 32 characters all the remaining will be filled with zeros, this means that `SBinary("1")` equals to decimal "1"; also `SBinary("11111111111111111111111111111111")` equals to decimal "-1".

## Abstract syntax tree
You can do multiple operations at the same time using the AST package, the abstract syntax tree is implemented using both Composite and State pattern. You also use the Factory class of this package to create Trees that have memory (for not creating same values all over again). For the memory to work as intended you need to create ASTs in the following way:
```java
var f = new Factory();
f.setAST(new Add(new Mult(f.createSFloat(1.0), f.createSInt(10)), new Or(f.createSBinary("0"), f.createSBool(true))));
f.evalAST() // SFloat(11)
```
## Model-View-Controller for the GUI

The AST visualization was implemented using the MVC pattern, in the  ```GUI.Controller``` package you can find the Controller classes which modifify the View of the application, as the model we extend the ```TreeItem``` Class from JavaFX, to allow it to wrap AST's nodes implemented in the ```AST``` package. For memory management we use an AST node factory with a memory that keeps track of already created nodes for reutilizing them.


## Using the GUI

Clone the repository and then open it in IntelliJ, after building it run the ```View.java``` file from ```GUI``` package.
First, add a node to the AST by clicking on either an operation node or Type node in the left menu of the program, if you added an operation node, you can keep adding stuff on the empty nodes by selecting them and then clicking on another node on the left. Finally, you can evaluate the current AST by clicking on the "Evaluate Tree button".

![demo](https://media4.giphy.com/media/A1ZdWQ5EsIyyE3qRJ7/giphy.gif?cid=790b7611f5bc1cac455d7bbdc6533a3152f097c4c2beda8b&rid=giphy.gif&ct=g)

#### Invalid operation handling
Invalid operations will return a ```SNull``` instance, this is reflected in the view as an "Invalid Operation" message.