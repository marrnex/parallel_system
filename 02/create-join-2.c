
/*
	create-join-2.c -- スレッドを２つ作るプログラム
*/

#include <stdlib.h>	/* malloc() */
#include <stdio.h> /* printf() */
#include <pthread.h>

struct func1_arg {
	int	x;
};
struct func2_arg {
	int	x;
};

void func1( struct func1_arg *arg );
void func2( struct func2_arg *arg );

main()
{
    pthread_t t1 ;
    pthread_t t2 ;
    struct func1_arg *arg1;
    struct func2_arg *arg2;
    
	printf("main()\n");
	arg1 = malloc( sizeof(struct func1_arg) );
	if( arg1 == NULL )
	{
	    perror("no memory for arg1");
	    exit( 1 );
	}
	arg1->x = 10;
	pthread_create( &t1, NULL, (void *)func1, (void *)arg1 );
	arg2 = malloc( sizeof(struct func2_arg) );
	if( arg2 == NULL )
	{
	    perror("no memory for arg2");
	    exit( 1 );
	}
	arg2->x = 20;
	pthread_create( &t2, NULL, (void *)func2, (void *)arg2 );
	pthread_join( t1, NULL );
	pthread_join( t2, NULL );
}

void func1( struct func1_arg *arg )
{
    int i ;
	for( i = 0 ; i<3 ; i++ )
	{
	    printf("func1( %d ): %d \n",arg->x, i );
	}
}

void func2( struct func2_arg *arg  )
{
    int i ;
	for( i = 0 ; i<3 ; i++ )
	{
	    printf("func2( %d ): %d \n",arg->x, i );
	}
}
