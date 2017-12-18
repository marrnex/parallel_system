
/*
	counter-server.c -- The counter server using SunRPC.
	Created on: 2011/12/21 21:09:47
*/

#include <stdio.h>	/* stderr, fprintf() */
#include <stdlib.h>	/* strtol() */
#include <string.h>	/* memcpy() */
#include "counter.h"

static int val;

void *
counter_up_1_svc(void *argp, struct svc_req *rqstp)
{
	static char* result;
	val ++;
	return((void*) &result);
}
void *
counter_down_1_svc(void *argp, struct svc_req *rqstp)
{
	static char* result;
	val --;
	return((void*) &result);
}

int *
counter_getvalue_1_svc(void *argp, struct svc_req *rqstp)
{
	static int  result;
	result = val;
	return(&result);
}

void *
counter_reset_1_svc(int *argp, struct svc_req *rqstp)
{
	static char* result;
	val = *argp;
	return((void*) &result);
}
