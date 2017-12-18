//
// HelloWriter.java
// 

import net.jini.space.JavaSpace;

class HelloWriter {
    public static void main(String[] argv)
    {
	Lookup finder = new Lookup(JavaSpace.class);
	JavaSpace space = (JavaSpace) finder.getService();
	if( space == null )
	{
	    System.err.println("No JavaSpace found.");
	    System.exit( 1 );
	}
	Message msg = new Message();
	msg.content = "Hello" ;
	try
	{
            space.write(msg, null, net.jini.core.lease.Lease.FOREVER);
	    System.out.println("HelloWriter: wrote["+msg.content+"]");
	}
	catch( Exception e )
	{
	    System.err.println("JavaSpace write error "+e.getMessage());
	    e.printStackTrace();
	    System.exit( -1 );
	}
	System.exit( 0 );
    }
}
