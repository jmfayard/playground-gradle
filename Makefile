## Makefile

# define compiler and compiler flag variables
JFLAGS = -g
JC = javac
ME = $(whoami)

.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        Foo.java \
        Blah.java \
        Library.java \
        Main.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class