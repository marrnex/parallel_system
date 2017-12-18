
/*
 * CircularBufferDemo.java -- Java による有限バッファのデモ
 */

class Thread_A implements Runnable // Producer
{
    CircularBuffer b;
    Thread_A( CircularBuffer b )
    {
	this.b = b;
    }
    public void run()
    {				
	int i,x ;
	for( i = 0 ; i<10 ; i++ )
	{
	    try
	    {
		x = i ;
		System.out.println("Thread_A(): put( "+x+" )");
		b.put( x );
	    }
	    catch( InterruptedException e )
	    {
		System.err.println("Thread_A(): Interrupted");
		break;
	    }
	}
    }
}

class Thread_B implements Runnable // Producer
{
    CircularBuffer b;
    Thread_B( CircularBuffer b )
    {
	this.b = b;
    }
    public void run()
    {				
	int i,x ;
	for( i = 0 ; i<10 ; i++ )
	{
	    try
	    {
		x = b.get();
		System.out.println("Thread_B(): got() "+x+".");
	    }
	    catch( InterruptedException e )
	    {
		System.err.println("Thread_B(): Interrupted");
		break;
	    }
	}
    }
}

class CircularBufferDemo
{
    public static void main(String argv[])
    {
	final CircularBuffer b = new CircularBuffer();
	Thread t1 = new Thread( new Thread_A(b) );
	t1.start();
	Thread t2 = new Thread( new Thread_B(b) );
	t2.start();
	try
	{
	    t1.join();
	    t2.join();
	}
	catch( InterruptedException e )
	{
	    System.err.println("main(): Interrupted");
	}
    }
}
