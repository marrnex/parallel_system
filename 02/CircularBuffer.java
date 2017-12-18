
/*
 * CircularBuffer.java -- Java による環状バッファ
 */

class CircularBuffer
{
    static final int BUFFER_SIZE = 4 ;
    int rp ;		// 読み出す位置
    int wp ;		// 書き込む位置
    int data[];		// データを保存する場所
    int used ;		// バッファ内の要素数
    CircularBuffer()
    {
	data = new int[BUFFER_SIZE];
	rp = 0 ;
	wp = 0 ;
	used = 0;
    }

    public synchronized void put( int x ) throws InterruptedException
    {
	while( used == data.length )
	    wait();
	data[ wp++ ] = x ;
	if( wp == data.length )
	    wp = 0 ;
	used++ ;
	notifyAll();
    }
    public synchronized int get() throws InterruptedException
    {
	int x ;
	while( used == 0 )
	    wait();	    
	x = data[ rp++ ] ;
	if( rp >= data.length )
	    rp = 0 ;
	used--;
	notifyAll();
	return( x );
    }
}
