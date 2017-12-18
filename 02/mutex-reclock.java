class Func
{
    public synchronized void deposit( int x ) throws InterruptedException
    {
		Mutex_reclock.shared_resource+=x;
    }
    public synchronized void add_interest() throws InterruptedException
    {
    	int i;
    	i = (int)(Mutex_reclock.shared_resource * 0.05) ;
        deposit( i );
    }
}

class Thread_A implements Runnable // Producer
{
    Func b;

    Thread_A( Func b )
    {
		this.b = b;
    }
    public void run()
    {				

	    try
	    {
			System.out.println("thread_A(): deposit( 10000 ) ... \n");
			b.deposit( 10000 );
			System.out.println("thread_A(): deposit( 10000 ) done. \n");
	    }
	    catch( InterruptedException e )
	    {
			System.err.println("Thread_A(): Interrupted");
	    }
	
    }
}

class Thread_B implements Runnable // Producer
{
    Func b;
    Thread_B( Func b )
    {
		this.b = b;
    }
    public void run()
    {				

	    try
	    {
	    	System.out.println("thread_B(): add_interest() ... \n");
	    	b.add_interest();
	    	System.out.println("thread_B(): add_interest() done . \n");
	    }	
	    catch( InterruptedException e )
	    {
			System.err.println("Thread_B(): Interrupted");
	    }
	
    }
}


class Mutex_reclock
{
	static int shared_resource;
    public static void main(String argv[])
    {
    	shared_resource=1000000;
		final Func b = new Func();
		Thread t1 = new Thread( new Thread_A(b) );
		t1.start();
		Thread t2 = new Thread( new Thread_B(b) );
		t2.start();
	try
	{
	    t1.join();
	    t2.join();
	    System.out.println("main(): shared_resource == "+shared_resource+".");
	}
	catch( InterruptedException e )
	{
	    System.err.println("main(): Interrupted");
	}
    }
}