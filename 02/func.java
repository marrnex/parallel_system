
/*
 * CircularBuffer.java -- Java ¤Ë¤è¤ë´Ä¾õ¥Ð¥Ã¥Õ¥¡
 */

class Func
{/*
    static final int BUFFER_SIZE = 4 ;
    int rp ;		// ÆÉ¤ß½Ð¤¹°ÌÃÖ
    int wp ;		// ½ñ¤­¹þ¤à°ÌÃÖ
    int data[];		// ¥Ç¡¼¥¿¤òÊÝÂ¸¤¹¤ë¾ì½ê
    int used ;		// ¥Ð¥Ã¥Õ¥¡Æâ¤ÎÍ×ÁÇ¿ô
    CircularBuffer()
    {
	data = new int[BUFFER_SIZE];
	rp = 0 ;
	wp = 0 ;
	used = 0;
    }
*/
    public synchronized void deposit( int x ) throws InterruptedException
    {/*
	while( used == data.length )
	    wait();
	data[ wp++ ] = x ;
	if( wp == data.length )
	    wp = 0 ;
	used++ ;
	notifyAll();*/
	shared_resorce+=x;
    }
    public synchronized void add_interest() throws InterruptedException
    {
    	int i;
    	i = shared_resource * 0.05 ;
        deposit( i );
    }
}
