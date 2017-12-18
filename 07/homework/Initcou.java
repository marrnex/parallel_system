//
// HelloWriter.java
// 

import net.jini.space.JavaSpace;

class Initcou {
    public static void main(String[] argv)
    {
	Lookup finder = new Lookup(JavaSpace.class);
	JavaSpace space = (JavaSpace) finder.getService();
	if( space == null )
	{
	    System.err.println("No JavaSpace found.");
	    System.exit( 1 );
	}
	Count cou = new Count();
	Count template = new Count();
	template.url=argv[0];
	Count result;

	try{//既に登録されているurlか確認
		result=(Count)space.take(template, null, JavaSpace.NO_WAIT);
		if(result!=null){//あったら初期化
		cou.content = 1;
		cou.url=argv[0];
		space.write(cou, null, net.jini.core.lease.Lease.FOREVER);
			System.exit( 0 );
		}
	}catch(Exception e){
		System.exit( -1 );
	}	

	cou.content = 1;
	cou.url=argv[0];
	try
	{
        space.write(cou, null, net.jini.core.lease.Lease.FOREVER);
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
