/*
 *        JacORB - a free Java ORB
 *
 *   Copyright (C) 1997-98  Gerald Brose.
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
 */

package org.jacorb.naming.namemanager;

public class NSTable 
    extends javax.swing.JTable 
{
    private ContextNode current;
    /**
     * NSTable constructor comment.
     */
    public NSTable() 
	{
	    super(new NSTableModel());
	    setShowGrid(false);
	    setAutoCreateColumnsFromModel(false);
	    setDoubleBuffered(true);
	    setCellSelectionEnabled(false);
	    setColumnSelectionAllowed(false);
	}
    /**
     * @returns the context node that is the source for this table
     */
    public ContextNode currentSource() 
	{
	    return current;
	}
    /**
     * 
     * @param newData java.util.Vector
     */
    public void setData(java.util.Vector newData, ContextNode currentSource) 
	{
	    current = currentSource;
	    ((NSTableModel)super.getModel()).setDataVector( newData );
	}
    /**
     * unbind a name and remove it from the table
     */
    public void unbind() 
	{
	    int row = getSelectedRow();
	    if( row > -1 )
	    {
		try
		{
		    org.omg.CosNaming.NameComponent[] ncs = 
			new org.omg.CosNaming.NameComponent[1];
		    ncs[0] = 
			new org.omg.CosNaming.NameComponent(
							    (String)getValueAt(row,0),
							    (String)getValueAt(row,1));
		    current.unbind(ncs);
		    update();
		}
		catch( Exception e)
		{}
	    } 
	}
    /**
     * 
     */
    public void update() 
	{
	    if( current != null )
		current.display();
	}
}



