
package org.jacorb.ir.gui.typesystem.remote;


import org.omg.CORBA.*;

/**
 * This class was generated by a SmartGuide.
 * 
 */
public class IRPrimitive extends IRNode {



/**
 * IRPrimitive constructor comment.
 */
protected IRPrimitive() {
	super();
}
/**
 * IRPrimitive constructor comment.
 * @param irObject org.omg.CORBA.IRObject
 */
protected IRPrimitive(org.omg.CORBA.IRObject irObject) {
	super(irObject);
	PrimitiveDef primitiveDef = PrimitiveDefHelper.narrow((org.omg.CORBA.Object)irObject);
	switch (primitiveDef.kind().value()) {
		case PrimitiveKind._pk_null:
			setName("null");	// gibt's nicht laut CORBA Spez.
			break;
		case PrimitiveKind._pk_void:
			setName("void");
			break;
		case PrimitiveKind._pk_short :
			setName("short");
			break;
		case PrimitiveKind._pk_long:
			setName("long");
			break;
		case PrimitiveKind._pk_ushort:
			setName("unsigned short");
			break;
		case PrimitiveKind._pk_ulong:
			setName("usigned long");
			break;
		case PrimitiveKind._pk_float:
			setName("float");
			break;
		case PrimitiveKind._pk_double:
			setName("double");
			break;
		case PrimitiveKind._pk_boolean:
			setName("boolean");
			break;
		case PrimitiveKind._pk_char:
			setName("char");
			break;
		case PrimitiveKind._pk_octet:
			setName("octet");
			break;
		case PrimitiveKind._pk_any:
			setName("any");
			break;
		case PrimitiveKind._pk_TypeCode:
			setName("typecode");
			break;
		case PrimitiveKind._pk_Principal:
			setName("Principal");
			break;
		case PrimitiveKind._pk_string:
			setName("string");
			break;
		case PrimitiveKind._pk_objref:
			setName("objref");
			break;
		case PrimitiveKind._pk_longlong:
			setName("long long");
			break;
		case PrimitiveKind._pk_ulonglong:
			setName("unsigned long long");
			break;
		case PrimitiveKind._pk_longdouble:
			setName("long double");
			break;
		case PrimitiveKind._pk_wchar:
			setName("wchar");
			break;
		case PrimitiveKind._pk_wstring:
			setName("wstring");
			break; 
		default:
			setName("unknown Primitive??");
			break;
	}	
	setAbsoluteName(getName());
}
/**
 * This method was created by a SmartGuide.
 * @return java.lang.String
 */
public static String nodeTypeName() {
	return "primitive";
}
}





