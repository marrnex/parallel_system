/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _COUNTER_H_RPCGEN
#define _COUNTER_H_RPCGEN

#define RPCGEN_VERSION	199506

#include <rpc/rpc.h>


#define COUNTER_PROG ((rpc_uint)0x20052001)
#define COUNTER_VERSION ((rpc_uint)1)

#ifdef __cplusplus
#define COUNTER_DOWN ((rpc_uint)10)
extern "C" void * counter_down_1(void *, CLIENT *);
extern "C" void * counter_down_1_svc(void *, struct svc_req *);
#define COUNTER_UP ((rpc_uint)11)
extern "C" void * counter_up_1(void *, CLIENT *);
extern "C" void * counter_up_1_svc(void *, struct svc_req *);
#define COUNTER_GETVALUE ((rpc_uint)12)
extern "C" int * counter_getvalue_1(void *, CLIENT *);
extern "C" int * counter_getvalue_1_svc(void *, struct svc_req *);
#define COUNTER_RESET ((rpc_uint)13)
extern "C" void * counter_reset_1(int *, CLIENT *);
extern "C" void * counter_reset_1_svc(int *, struct svc_req *);

#elif __STDC__
#define COUNTER_DOWN ((rpc_uint)10)
extern  void * counter_down_1(void *, CLIENT *);
extern  void * counter_down_1_svc(void *, struct svc_req *);
#define COUNTER_UP ((rpc_uint)11)
extern  void * counter_up_1(void *, CLIENT *);
extern  void * counter_up_1_svc(void *, struct svc_req *);
#define COUNTER_GETVALUE ((rpc_uint)12)
extern  int * counter_getvalue_1(void *, CLIENT *);
extern  int * counter_getvalue_1_svc(void *, struct svc_req *);
#define COUNTER_RESET ((rpc_uint)13)
extern  void * counter_reset_1(int *, CLIENT *);
extern  void * counter_reset_1_svc(int *, struct svc_req *);

#else /* Old Style C */
#define COUNTER_DOWN ((rpc_uint)10)
extern  void * counter_down_1();
extern  void * counter_down_1_svc();
#define COUNTER_UP ((rpc_uint)11)
extern  void * counter_up_1();
extern  void * counter_up_1_svc();
#define COUNTER_GETVALUE ((rpc_uint)12)
extern  int * counter_getvalue_1();
extern  int * counter_getvalue_1_svc();
#define COUNTER_RESET ((rpc_uint)13)
extern  void * counter_reset_1();
extern  void * counter_reset_1_svc();
#endif /* Old Style C */

#endif /* !_COUNTER_H_RPCGEN */
