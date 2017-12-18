
/*
	counter-client.c -- counter client based on SunRPC
	Created on: 2011/12/21 20:56:17
*/

#include <stdio.h>	/* stderr, fprintf() */
#include <string.h>
#include <stdlib.h>	/* exit() */
#include "counter.h"

void usage( char *comname ) {
	fprintf(stderr,"Usage: %% %s server-host\n", comname);
	exit( 1 );
}

main( int argc, char *argv[], char *envp[] ) {
    char *server ;
    CLIENT *clnt;
    char *counter_up_arg; /* dummy */
    char *counter_down_arg;
    //void *counter_up_result;
    void *counter_down_result;
    char *counter_getvalue_arg; /* dummy */
    int  *counter_getvalue_result;
    int i;

	if( argc != 2 )
	    usage( argv[0] );
	server = argv[1];
	clnt = clnt_create(server,COUNTER_PROG,
			   COUNTER_VERSION, "tcp");
	if( clnt == NULL ) {
	    clnt_pcreateerror( server );
	    exit( 1 );
	}

	for( i=0; i<3; i++ )
	{
	    //counter_up_result = counter_up_1((void *)&counter_up_arg, clnt);
	    counter_down_result=counter_down_1((void *)&counter_down_arg, clnt);
	    //if( counter_up_result == NULL ) {
	    if(counter_down_result==NULL){
		//clnt_perror(clnt, "call failed -- up");
	    clnt_perror(clnt, "call failed -- down");
		exit( 2 );
	    }
	    //xdr_free( (xdrproc_t)xdr_void, (char *)counter_up_result );
	    xdr_free( (xdrproc_t)xdr_void, (char *)counter_down_result );

	    counter_getvalue_result = counter_getvalue_1((void *)&counter_getvalue_arg, clnt);
	    if( counter_getvalue_result == (void *) NULL )
	    {
		clnt_perror(clnt, "call failed -- getvalue");
		exit( 2 );
	    }
	    printf("value==%d\n", *counter_getvalue_result);
	    xdr_free( (xdrproc_t)xdr_int, (char *)counter_down_result );
	}
	clnt_destroy( clnt );
}
