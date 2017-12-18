#
# wget http://www.cs.tsukuba.ac.jp/~yas/cs/csys-2017/2017-11-17/ex/Makefile
#

base = http://www.cs.tsukuba.ac.jp/~yas/cs/csys-2017/2017-11-17/ex/
self = $(base)/Makefile

jinilib=/Users/koyama/Downloads/apache-river-2.2.2/lib
jiniclasspath=.:$(jinilib)/jini-core.jar:$(jinilib)/jini-ext.jar:$(jinilib)/reggie.jar:$(jinilib)/outrigger.jar

JAVAC = javac -classpath $(jiniclasspath)
JAVA = java -classpath $(jiniclasspath)
RUBY = ruby


.SUFFIXES: .class .java .npr
.java.class:
	$(JAVAC) $*.java

.java.npr:
	npr $< > $*.npr

all:

hellosrcs =  Initcou.java Countup.java \
	Count.java Lookup.java
helloclasses = Lookup.class Count.class
Lookup.class: Lookup.java
HelloWriter.class: $(helloclasses)
HelloReader.class:  $(helloclasses)
HelloTaker.class:  $(helloclasses)

hello:	Initcou.class  Countup.class

clean:
	rm -f *.class *.npr

renewMakefile:
	mv -f Makefile Makefile.bak
	wget $(self)

renewHelloSrcs:
#	mv -f $(hellosrcs) save/
	@for i in $(hellosrcs); do wget $(base)/$$i; done

HelloWriter: HelloWriter.class

run-HelloWriter: Initcou.class
	@$(JAVA) Initcou

HelloTaker: HelloTaker.class

run-Countup: Countup.class
	@$(JAVA) Countup testesa

echo-java-alias:
	@echo alias j $(JAVA)
