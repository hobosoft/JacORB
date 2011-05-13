/*
*  DDS (Data Distribution Service) for JacORB
*
* Copyright (C) 2005-2011 Gerald Brose / The JacORB Team.
* allaoui <fouad.allaoui@gmail.com>, Didier Donsez (didier.donsez@ieee.org)
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU Library General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU Library General Public License for more details.
*
* You should have received a copy of the GNU Library General Public 
* License along with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
* 02111-1307, USA.
*
* Coontact: Ahmed yehdih <ahmed.yehdih@gmail.com>, fouad allaoui
* <fouad.allaoui@gmail.com>, Didier Donsez (didier.donsez@ieee.org)
* Contributor(s)
*
**/
package demo.dds.dcps.foosample;

import org.jacorb.dds.Supplier;
import org.omg.dds.DataWriterListener;
import org.omg.dds.DataWriterQos;
import org.omg.dds.DataWriterQosHolder;
import org.omg.dds.InstanceHandleSeqHolder;
import org.omg.dds.LivelinessLostStatus;
import org.omg.dds.OfferedDeadlineMissedStatus;
import org.omg.dds.OfferedIncompatibleQosStatus;
import org.omg.dds.PublicationMatchStatus;
import org.omg.dds.Publisher;
import org.omg.dds.StatusCondition;
import org.omg.dds.SubscriptionBuiltinTopicDataHolder;
import org.omg.dds.Time_t;
import org.omg.dds.Topic;

/**
 * A DataWriter is attached to exactly one Publisher which acts as a factory for it.
 * A DataWriter is bound to exactly one Topic and therefore to exactly one data type. The
 * Topic must exist prior to the DataWriter's creation.
 * DataWriter is an abstract class. It must be specialized for each particular application
 * data-type . The additional methods that must be defined in the autogenerated
 * class for a hypothetical application type 'Foo' 
 *  
 */
public class FooDataWriterImpl extends FooDataWriterPOA {
    
    private DataWriterQos qos;
    private DataWriterListener a_listener ;
    private Publisher PubParent ;
    private Topic topic ;
    org.omg.CORBA.ORB orb ;
    org.omg.PortableServer.POA poa ;
    //	put  instance  of Foo  in channel event 
    private Supplier _Supplier ;

    /**
     * @param qos
     * @param a_listener
     * @param pubParent
     * @param topic_name
     */
    public FooDataWriterImpl(DataWriterQos qos, DataWriterListener a_listener,
            Publisher pubParent, Topic topic,org.omg.CORBA.ORB orb ,
            org.omg.PortableServer.POA poa ) {
        this.orb = orb ;
        this.poa = poa ;
        this.qos = qos;
        this.a_listener = a_listener;
        PubParent = pubParent;
        this.topic = topic;
        _Supplier = new Supplier(orb,poa);
    }
    
	/**
	 * Not Implemented
	 */    
    public int register(Foo instance_data) {
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int register_w_timestamp(Foo instance_data, int handle,
            Time_t source_timestamp) {
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int unregister(Foo instance_data, int handle) {       
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int unregister_w_timestamp(Foo instance_data, int handle,
            Time_t source_timestamp) {       
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int write(Foo instance_data, int handle) {        
        _Supplier.Write(topic , instance_data);        
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int write_w_timestamp(Foo instance_data, int handle,
            Time_t source_timestamp) {       
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int dispose(Foo instance_data, int instance_handle) {
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int dispose_w_timestamp(Foo instance_data, int instance_handle,
            Time_t source_timestamp) {
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int get_key_value(FooHolder key_holder, int handle) {
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int set_qos(DataWriterQos qos) {
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public void get_qos(DataWriterQosHolder qos) {        
    }
    
	/**
	 * Not Implemented
	 */
    public int set_listener(DataWriterListener a_listener, int mask) {
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public DataWriterListener get_listener() {
        return null;
    }
    
	/**
	 * Not Implemented
	 */
    public Topic get_topic() {
        return null;
    }
    
	/**
	 * Not Implemented
	 */
    public Publisher get_publisher() {
        return PubParent;
    }
    
	/**
	 * Not Implemented
	 */
    public LivelinessLostStatus get_liveliness_lost_status() {
        return null;
    }
    
	/**
	 * Not Implemented
	 */
    public OfferedDeadlineMissedStatus get_offered_deadline_missed_status() {
        return null;
    }
    
	/**
	 * Not Implemented
	 */
    public OfferedIncompatibleQosStatus get_offered_incompatible_qos_status() {
        return null;
    }
    
	/**
	 * Not Implemented
	 */
    public PublicationMatchStatus get_publication_match_status() {
        return null;
    }
    
	/**
	 * Not Implemented
	 */
    public void assert_liveliness() {   
    }
    
	/**
	 * Not Implemented
	 */
    public int get_matched_subscriptions(
            InstanceHandleSeqHolder subscription_handles) {
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int get_matched_subscription_data(
            SubscriptionBuiltinTopicDataHolder subscription_data,
            int subscription_handle) {
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public int enable() {
        return 0;
    }
    
	/**
	 * Not Implemented
	 */
    public StatusCondition get_statuscondition() {
        return null;
    }
    
	/**
	 * Not Implemented
	 */
    public int get_status_changes() {
        return 0;
    }       
    
    /**
     * @return Returns the pubParent.
     */
    public Publisher getPubParent() {
        return PubParent;
    }
    
    /**
     * @return Returns the topic_name.
     */
    public Topic getTopic() {
        return topic;
    }
}
