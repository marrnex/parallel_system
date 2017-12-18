#
#
#

# In coins, uncomment this.
#gluelib=/home/prof/yas/cs/csys-2017/glue/electric/lib

# In icho.u.tsukuba.ac.jp, uncomment this.
#gluelib=/home/shinjo.yasushi.ga/cs/csys-2017/glue/electric/lib

glueclasspath=.:$(gluelib)/GLUE-STD.jar:$(gluelib)/servlet.jar

base = http://www.cs.tsukuba.ac.jp/~yas/cs/csys-2017/2017-11-01/ex
self = $(base)/Makefile

port=8080

JAVAC = javac -classpath $(glueclasspath)
JAVA = java -classpath $(glueclasspath)
RUBY = ruby
CFLAGS = -g -DRPC_SVC_FG
CC=gcc

.SUFFIXES: .class .java .npr .i
.java.class:
	$(JAVAC) $*.java

.java.npr:
	npr $< > $*.npr

.c.npr:
	npr $< > $*.npr

.c.i:;	$(CC) -E $*.c > $*.i

all:

port:
	@echo $(port)

clean:
	rm -f *.class *.npr

gen = counter.h counter_clnt.c counter_svc.c
rpc_clnt_objs = counter_clnt.o
rpc_svc_objs = counter_svc.o
#rpc_libs = -lnsl
rpc_libs = 

counter-client: counter-client.o $(rpc_clnt_objs)
	$(CC) $(CFLAGS)  $@.o $(rpc_clnt_objs) $(rpc_libs) -o $@

counter-client.o: counter-client.c counter.h

counter-server: counter-server.o $(rpc_svc_objs)
	$(CC) $(CFLAGS) counter-server.o $(rpc_svc_objs)  $(rpc_libs) -o $@

counter-server.o: counter-server.c counter.h
counter-client.o: counter-client.c counter.h

$(gen): counter.x
	rpcgen counter.x

CounterLocal.class: Counter.class ICounter.class
CounterServer.class: Counter.class ICounter.class
CounterClient.class: Counter.class ICounter.class
Counter.class: ICounter.class

CounterLocal: CounterLocal.class
run-CounterLocal: CounterLocal.class
	$(JAVA) CounterLocal

name=Counter/c1

CounterServer: CounterServer.class
run-CounterServer: CounterServer.class
	$(JAVA) CounterServer $(port) $(name)

CounterClient: CounterClient.class
run-CounterClient: CounterClient.class
	$(JAVA) CounterClient localhost $(port) $(name)


# RMI

RCounter.class: IRCounter.class
RCounterServer.class: IRCounter.class RCounter.class
RCounterServer: IRCounter.class RCounter.class RCounterServer.class
run-RCounterServer: IRCounter.class RCounter.class RCounterServer.class
	java RCounterServer $(port)

run-rmiregistry: 
	rmiregistry $(port)

RCounterClient.class: IRCounter.class
RCounterClient: IRCounter.class RCounter.class RCounterClient.class
run-RCounterClient: IRCounter.class RCounter.class RCounterClient.class
	java RCounterClient localhost $(port)

run-counter-local.rb: 
	$(RUBY) -I. counter-local.rb

run-counter-server.rb: 
	$(RUBY)  -I. counter-server.rb $(port)

run-counter-client.rb:
	$(RUBY)  -I. counter-client.rb localhost $(port)



