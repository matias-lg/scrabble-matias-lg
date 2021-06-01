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
