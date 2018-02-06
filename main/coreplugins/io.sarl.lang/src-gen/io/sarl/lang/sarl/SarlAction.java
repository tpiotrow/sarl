/**
 */
package io.sarl.lang.sarl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtend.core.xtend.XtendFunction;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link io.sarl.lang.sarl.SarlAction#getFiredEvents <em>Fired Events</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.SarlAction#getPreConditions <em>Pre Conditions</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.SarlAction#getPreConditionsName <em>Pre Conditions Name</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.SarlAction#getPostConditions <em>Post Conditions</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.SarlAction#getPostConditionsName <em>Post Conditions Name</em>}</li>
 * </ul>
 *
 * @see io.sarl.lang.sarl.SarlPackage#getSarlAction()
 * @model
 * @generated
 */
public interface SarlAction extends XtendFunction
{
	/**
	 * Returns the value of the '<em><b>Fired Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.common.types.JvmTypeReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fired Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fired Events</em>' containment reference list.
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlAction_FiredEvents()
	 * @model containment="true"
	 * @generated
	 */
	EList<JvmTypeReference> getFiredEvents();

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
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlAction_PreConditions()
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
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlAction_PreConditionsName()
	 * @model
	 * @generated
	 */
	String getPreConditionsName();

	/**
	 * Sets the value of the '{@link io.sarl.lang.sarl.SarlAction#getPreConditionsName <em>Pre Conditions Name</em>}' attribute.
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
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlAction_PostConditions()
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
	 * @see io.sarl.lang.sarl.SarlPackage#getSarlAction_PostConditionsName()
	 * @model
	 * @generated
	 */
	String getPostConditionsName();

	/**
	 * Sets the value of the '{@link io.sarl.lang.sarl.SarlAction#getPostConditionsName <em>Post Conditions Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Conditions Name</em>' attribute.
	 * @see #getPostConditionsName()
	 * @generated
	 */
	void setPostConditionsName(String value);

} // SarlAction
