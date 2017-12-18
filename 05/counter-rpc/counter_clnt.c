/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "counter.h"

/* Default timeout can be changed using clnt_control() */
static struct timeval TIMEOUT = { 25, 0 };

void *
counter_down_1(argp, clnt)
	void *argp;
	CLIENT *clnt;
{
	static char clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	if (clnt_call(clnt, COUNTER_DOWN, xdr_void, argp, xdr_void, &clnt_res, TIMEOUT) != RPC_SUCCESS)
		return (NULL);
	return ((void *)&clnt_res);
}

void *
counter_up_1(argp, clnt)
	void *argp;
	CLIENT *clnt;
{
	static char clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	if (clnt_call(clnt, COUNTER_UP, xdr_void, argp, xdr_void, &clnt_res, TIMEOUT) != RPC_SUCCESS)
		return (NULL);
	return ((void *)&clnt_res);
}

int *
counter_getvalue_1(argp, clnt)
	void *argp;
	CLIENT *clnt;
{
	static int clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	if (clnt_call(clnt, COUNTER_GETVALUE, xdr_void, argp, xdr_int, &clnt_res, TIMEOUT) != RPC_SUCCESS)
		return (NULL);
	return (&clnt_res);
}

void *
counter_reset_1(argp, clnt)
	int *argp;
	CLIENT *clnt;
{
	static char clnt_res;

	memset((char *)&clnt_res, 0, sizeof(clnt_res));
	if (clnt_call(clnt, COUNTER_RESET, xdr_int, argp, xdr_void, &clnt_res, TIMEOUT) != RPC_SUCCESS)
		return (NULL);
	return ((void *)&clnt_res);
}