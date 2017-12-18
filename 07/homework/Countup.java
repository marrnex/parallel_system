//
// HelloTaker.java
// 

import net.jini.space.JavaSpace;

public class Countup {
    public static void main(String[] argv)
    {
	Lookup finder = new Lookup(JavaSpace.class);
	JavaSpace space = (JavaSpace) finder.getService();
	if( space == null )
	{
	    System.err.println("No JavaSpace found.");
	    System.exit( 1 );
	}

	Count template = new Count();
	template.url=argv[0];
	Count result;
	try
	{
	    result = (Count)space.take(template, null, Long.MAX_VALUE);
	    System.out.println("count:"+result.content);
	    System.out.println("url:"+result.url);
	    Count cou = new Count();
		cou.content = result.content+1;//new Integer(0) ;
		cou.url=argv[0];
		space.write(cou, null, net.jini.core.lease.Lease.FOREVER);
	}
	catch( Exception e )
	{
	    System.err.println("JavaSpace read error "+e.getMessage());
	    e.printStackTrace();
	    System.exit( -1 );
	}

	System.exit( 0 );
    }
}
