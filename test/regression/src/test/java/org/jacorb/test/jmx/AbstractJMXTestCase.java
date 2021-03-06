/*
 *        JacORB - a free Java ORB
 *
 *   Copyright (C) 1999-2014 Gerald Brose / The JacORB Team.
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Library General Public
 *   License as published by the Free Software Foundation; either
 *   version 2 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this library; if not, write to the Free
 *   Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 */


package org.jacorb.test.jmx;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.management.Attribute;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import org.junit.Test;
import org.omg.CORBA.ORB;

public abstract class AbstractJMXTestCase
{
    protected static JMXClientServerSetup jmxSetup;

    @Test
    public void testAccessRemoteMBean() throws Exception
    {
        JMXServiceURL serviceURL = jmxSetup.getServiceURL();

        Map<String, ORB> map = new HashMap<String, ORB>();
        map.put("java.naming.corba.orb", jmxSetup.getClientOrb());
        JMXConnector connector = JMXConnectorFactory.connect(serviceURL, map);

        MBeanServerConnection serverConnection = connector.getMBeanServerConnection();

        ObjectName objectName = new ObjectName(":service=example");

        UUID uuid = UUID.randomUUID();
        String uniqueString = uuid.toString();

        serverConnection.setAttribute(objectName, new Attribute("String", uniqueString));
        assertEquals(uniqueString, serverConnection.getAttribute(objectName, "String"));
    }
}
