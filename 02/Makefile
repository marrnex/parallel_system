#
#	Makefile
#	wget コマンドでコピーできます。
#	Start: 1999/01/18 20:49:16

.SUFFIXES: .npr .rb
.c.npr:
	npr $< > $*.npr
.java.npr:
	npr $< > $*.npr
.rb.npr:
	npr $< > $*.npr

progs=condv-buffer create-join-2 echo-server-fork echo-server-pthread \
	ms_matrix-main ms_relax-main mutex-lock mutex-nolock \
	mutex-reclock-normal mutex-reclock-recursive quicksort-main \
	t-gethostbyname_r t-yield tsd-counter-main

#LIBS=-lpthread -lposix4
LIBS=-lpthread

%:	%.o
	$(CC) $< $(LIBS) -o $@

#Solaris 7
#CFLAGS=	-D_REENTRANT -g -mcpu=v8 -Dpthread_setconcurrency=thr_setconcurrency \
#	 -Dpthread_getconcurrency=thr_getconcurrency
# Solaris 8 and newer
#CFLAGS=	-D_REENTRANT -g -mcpu=v8
# 
# Linux
#CFLAGS=	-DPTHREAD_MUTEX_RECURSIVE=PTHREAD_MUTEX_RECURSIVE_NP
CC=gcc

all:

SRCS= \
	barrier.c \
	condv-buffer.c \
	create-join-2.c \
	echo-server-fork.c \
	echo-server-pthread.c \
	ms_matrix.c \
	ms_matrix-main.c \
	ms_relax.c \
	ms_relax-main.c \
	mutex-lock.c \
	mutex-nolock.c \
	mutex-reclock-normal.c \
	mutex-reclock-recursive.c \
	quicksort.c \
	quicksort-main.c \
	tsd-counter-main.c \
	tsd-counter.c \
	workpile.c


OBJS=$(SRCS:.c=.o)
$(OBJS):

echo-server-fork: echo-server-fork.o
	$(CC) $(CFLAGS) -o $@ $< -lsocket -lnsl 

echo-server-pthread: echo-server-pthread.o
	$(CC) $(CFLAGS) -o $@ $< -lsocket -lnsl -lpthread

tsd-counter-main: tsd-counter-main.o tsd-counter.o
	$(CC) $(CFLAGS) -o $@ tsd-counter-main.o tsd-counter.o -lpthread

CircularBuffer: CircularBuffer.class

CircularBuffer.class: CircularBuffer.java
	javac CircularBuffer.java

clean:
	rm -f $(progs) *.o
