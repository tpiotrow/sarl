/**
 */
package io.sarl.lang.sarl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtend.core.xtend.XtendMember;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.sarl.lang.sarl.SarlBehaviorUnit#getName <em>Name</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.SarlBehaviorUnit#getGuard <em>Guard</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.SarlBehaviorUnit#getExpression <em>Expression</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.SarlBehaviorUnit#getPreConditions <em>Pre Conditions</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.SarlBehaviorUnit#getPreConditionsName <em>Pre Conditions Name</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.SarlBehaviorUnit#getPostConditions <em>Post Conditions</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.SarlBehaviorUnit#getPostConditionsName <em>Post Conditions Name</em>}</li>
 * </ul>
 *
 * @see io.sarl.lang.sarl.SarlPackage#getSarlBehaviorUnit()
 * @model
 * @generated
 */
public interface SarlBehaviorUnit extends XtendMember
{
	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(JvmParameterizedTypeReference)
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlBehaviorUnit_Name()
	 * @model containment="true"
	 * @generated
	 */
	JvmParameterizedTypeReference getName();

	/**
	 * Sets the value of the '{@link io.sarl.lang.sarl.SarlBehaviorUnit#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(JvmParameterizedTypeReference value);

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(XExpression)
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlBehaviorUnit_Guard()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getGuard();

	/**
	 * Sets the value of the '{@link io.sarl.lang.sarl.SarlBehaviorUnit#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(XExpression value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(XExpression)
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlBehaviorUnit_Expression()
	 * @model containment="true"
	 * @generated
	 */
	XExpression getExpression();

	/**
	 * Sets the value of the '{@link io.sarl.lang.sarl.SarlBehaviorUnit#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(XExpression value);

	/**
	 * Returns the value of the '<em><b>Pre Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Conditions</em>' containment reference list.
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlBehaviorUnit_PreConditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getPreConditions();

	/**
	 * Returns the value of the '<em><b>Pre Conditions Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Conditions Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Conditions Name</em>' attribute.
	 * @see #setPreConditionsName(String)
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlBehaviorUnit_PreConditionsName()
	 * @model
	 * @generated
	 */
	String getPreConditionsName();

	/**
	 * Sets the value of the '{@link io.sarl.lang.sarl.SarlBehaviorUnit#getPreConditionsName <em>Pre Conditions Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Conditions Name</em>' attribute.
	 * @see #getPreConditionsName()
	 * @generated
	 */
	void setPreConditionsName(String value);

	/**
	 * Returns the value of the '<em><b>Post Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.xbase.XExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Conditions</em>' containment reference list.
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlBehaviorUnit_PostConditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<XExpression> getPostConditions();

	/**
	 * Returns the value of the '<em><b>Post Conditions Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Conditions Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Conditions Name</em>' attribute.
	 * @see #setPostConditionsName(String)
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlBehaviorUnit_PostConditionsName()
	 * @model
	 * @generated
	 */
	String getPostConditionsName();

	/**
	 * Sets the value of the '{@link io.sarl.lang.sarl.SarlBehaviorUnit#getPostConditionsName <em>Post Conditions Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Conditions Name</em>' attribute.
	 * @see #getPostConditionsName()
	 * @generated
	 */
	void setPostConditionsName(String value);

} // SarlBehaviorUnit
