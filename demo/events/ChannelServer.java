package demo.events;

/**
 *
 * This drives the event channel object.
 *
 */

import jacorb.events.*;
import org.omg.CosEventChannelAdmin.*;
import org.omg.CosNaming.*;

public class ChannelServer
{
    static public void main( String[] argv ) 
    {
	org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(argv, null);
	try 
	{           
	    org.omg.PortableServer.POA poa = 
		org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	    EventChannelImpl channel = new EventChannelImpl(orb,poa);

	    poa.the_POAManager().activate();

	    org.omg.CORBA.Object o = poa.servant_to_reference(channel);

	    NamingContextExt nc = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
	
	    nc.bind(nc.to_name("eventchannel.example"), o);
	    orb.run();
	} 
	catch ( Exception e) 
	{
	    e.printStackTrace();
	}

    }
}


