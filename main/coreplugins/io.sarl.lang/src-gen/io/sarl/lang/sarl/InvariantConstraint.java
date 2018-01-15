/**
 */
package io.sarl.lang.sarl;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invariant Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.sarl.lang.sarl.InvariantConstraint#getName <em>Name</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.InvariantConstraint#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see io.sarl.lang.sarl.SarlPackage#getInvariantConstraint()
 * @model
 * @generated
 */
public interface InvariantConstraint extends SarlConstraint
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see io.sarl.lang.sarl.SarlPackage#getInvariantConstraint_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link io.sarl.lang.sarl.InvariantConstraint#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' reference.
	 * @see #setCondition(XExpression)
	 * @see io.sarl.lang.sarl.SarlPackage#getInvariantConstraint_Condition()
	 * @model
	 * @generated
	 */
	XExpression getCondition();

	/**
	 * Sets the value of the '{@link io.sarl.lang.sarl.InvariantConstraint#getCondition <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(XExpression value);

} // InvariantConstraint
