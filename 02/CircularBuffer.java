
/*
 * CircularBuffer.java -- Java �ˤ��ľ��Хåե�
 */

class CircularBuffer
{
    static final int BUFFER_SIZE = 4 ;
    int rp ;		// �ɤ߽Ф�����
    int wp ;		// �񤭹������
    int data[];		// �ǡ�������¸������
    int used ;		// �Хåե�������ǿ�
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
