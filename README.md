# Calculator
<h1>A GUI calculator created in the MVC structure.</h1>


This is just a src folder project. To build use your preferred IDE
builder or maven builder.



The class <code>com.company.models.ButtonsBuilder</code> is very useful when it comes to adding a massive amount of buttons
with a easy and intuitive sintax.

For instance, it is recursively called when added one button by using the add() method
Usage:

<code>
ButtonsBuilder bl = new ButtonsBuilder();
bl.add("CE").add("<=").add(new JButton()).add(new JButton("8")); //adds button recursively
</code>

It accepts either String as a parameter or Jbuttons. 
To retrieve the ArrayList from the class just use build()


<code>

bl.build() //returns a array list containing [new Jbutton("CE"), new Jbutton("<="), new Jbutton(""), new Jbutton("8")]
</code>
