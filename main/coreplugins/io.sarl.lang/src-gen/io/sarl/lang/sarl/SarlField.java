/**
 */
package io.sarl.lang.sarl;

import org.eclipse.xtend.core.xtend.XtendField;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.sarl.lang.sarl.SarlField#getInvariant <em>Invariant</em>}</li>
 * </ul>
 *
 * @see io.sarl.lang.sarl.SarlPackage#getSarlField()
 * @model
 * @generated
 */
public interface SarlField extends XtendField
{
	/**
	 * Returns the value of the '<em><b>Invariant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invariant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invariant</em>' reference.
	 * @see #setInvariant(InvariantConstraint)
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlField_Invariant()
	 * @model
	 * @generated
	 */
	InvariantConstraint getInvariant();

	/**
	 * Sets the value of the '{@link io.sarl.lang.sarl.SarlField#getInvariant <em>Invariant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invariant</em>' reference.
	 * @see #getInvariant()
	 * @generated
	 */
	void setInvariant(InvariantConstraint value);

} // SarlField
