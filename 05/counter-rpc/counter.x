program COUNTER_PROG { 
   version COUNTER_VERSION {
   	   void     COUNTER_DOWN(void)       = 10 ; 
       void     COUNTER_UP(void)       = 11 ; 
       int      COUNTER_GETVALUE(void) = 12 ; 
       void	COUNTER_RESET(int)     = 13 ; 
   } = 1 ;
} = 0x20052001 ;
