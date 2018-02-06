/**
 */
package io.sarl.lang.sarl.impl;

import io.sarl.lang.sarl.SarlAction;
import io.sarl.lang.sarl.SarlPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.xtend.core.xtend.impl.XtendFunctionImplCustom;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlActionImpl#getFiredEvents <em>Fired Events</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlActionImpl#getPreConditions <em>Pre Conditions</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlActionImpl#getPreConditionsName <em>Pre Conditions Name</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlActionImpl#getPostConditions <em>Post Conditions</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlActionImpl#getPostConditionsName <em>Post Conditions Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SarlActionImpl extends XtendFunctionImplCustom implements SarlAction
{
	/**
	 * The cached value of the '{@link #getFiredEvents() <em>Fired Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFiredEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<JvmTypeReference> firedEvents;

	/**
	 * The cached value of the '{@link #getPreConditions() <em>Pre Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<XExpression> preConditions;

	/**
	 * The default value of the '{@link #getPreConditionsName() <em>Pre Conditions Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreConditionsName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRE_CONDITIONS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPreConditionsName() <em>Pre Conditions Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreConditionsName()
	 * @generated
	 * @ordered
	 */
	protected String preConditionsName = PRE_CONDITIONS_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPostConditions() <em>Post Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<XExpression> postConditions;

	/**
	 * The default value of the '{@link #getPostConditionsName() <em>Post Conditions Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostConditionsName()
	 * @generated
	 * @ordered
	 */
	protected static final String POST_CONDITIONS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostConditionsName() <em>Post Conditions Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostConditionsName()
	 * @generated
	 * @ordered
	 */
	protected String postConditionsName = POST_CONDITIONS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SarlActionImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return SarlPackage.Literals.SARL_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JvmTypeReference> getFiredEvents()
	{
		if (firedEvents == null)
		{
			firedEvents = new EObjectContainmentEList<JvmTypeReference>(JvmTypeReference.class, this, SarlPackage.SARL_ACTION__FIRED_EVENTS);
		}
		return firedEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getPreConditions()
	{
		if (preConditions == null)
		{
			preConditions = new EObjectContainmentEList<XExpression>(XExpression.class, this, SarlPackage.SARL_ACTION__PRE_CONDITIONS);
		}
		return preConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPreConditionsName()
	{
		return preConditionsName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreConditionsName(String newPreConditionsName)
	{
		String oldPreConditionsName = preConditionsName;
		preConditionsName = newPreConditionsName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_ACTION__PRE_CONDITIONS_NAME, oldPreConditionsName, preConditionsName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<XExpression> getPostConditions()
	{
		if (postConditions == null)
		{
			postConditions = new EObjectContainmentEList<XExpression>(XExpression.class, this, SarlPackage.SARL_ACTION__POST_CONDITIONS);
		}
		return postConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostConditionsName()
	{
		return postConditionsName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostConditionsName(String newPostConditionsName)
	{
		String oldPostConditionsName = postConditionsName;
		postConditionsName = newPostConditionsName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_ACTION__POST_CONDITIONS_NAME, oldPostConditionsName, postConditionsName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case SarlPackage.SARL_ACTION__FIRED_EVENTS:
				return ((InternalEList<?>)getFiredEvents()).basicRemove(otherEnd, msgs);
			case SarlPackage.SARL_ACTION__PRE_CONDITIONS:
				return ((InternalEList<?>)getPreConditions()).basicRemove(otherEnd, msgs);
			case SarlPackage.SARL_ACTION__POST_CONDITIONS:
				return ((InternalEList<?>)getPostConditions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case SarlPackage.SARL_ACTION__FIRED_EVENTS:
				return getFiredEvents();
			case SarlPackage.SARL_ACTION__PRE_CONDITIONS:
				return getPreConditions();
			case SarlPackage.SARL_ACTION__PRE_CONDITIONS_NAME:
				return getPreConditionsName();
			case SarlPackage.SARL_ACTION__POST_CONDITIONS:
				return getPostConditions();
			case SarlPackage.SARL_ACTION__POST_CONDITIONS_NAME:
				return getPostConditionsName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case SarlPackage.SARL_ACTION__FIRED_EVENTS:
				getFiredEvents().clear();
				getFiredEvents().addAll((Collection<? extends JvmTypeReference>)newValue);
				return;
			case SarlPackage.SARL_ACTION__PRE_CONDITIONS:
				getPreConditions().clear();
				getPreConditions().addAll((Collection<? extends XExpression>)newValue);
				return;
			case SarlPackage.SARL_ACTION__PRE_CONDITIONS_NAME:
				setPreConditionsName((String)newValue);
				return;
			case SarlPackage.SARL_ACTION__POST_CONDITIONS:
				getPostConditions().clear();
				getPostConditions().addAll((Collection<? extends XExpression>)newValue);
				return;
			case SarlPackage.SARL_ACTION__POST_CONDITIONS_NAME:
				setPostConditionsName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case SarlPackage.SARL_ACTION__FIRED_EVENTS:
				getFiredEvents().clear();
				return;
			case SarlPackage.SARL_ACTION__PRE_CONDITIONS:
				getPreConditions().clear();
				return;
			case SarlPackage.SARL_ACTION__PRE_CONDITIONS_NAME:
				setPreConditionsName(PRE_CONDITIONS_NAME_EDEFAULT);
				return;
			case SarlPackage.SARL_ACTION__POST_CONDITIONS:
				getPostConditions().clear();
				return;
			case SarlPackage.SARL_ACTION__POST_CONDITIONS_NAME:
				setPostConditionsName(POST_CONDITIONS_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case SarlPackage.SARL_ACTION__FIRED_EVENTS:
				return firedEvents != null && !firedEvents.isEmpty();
			case SarlPackage.SARL_ACTION__PRE_CONDITIONS:
				return preConditions != null && !preConditions.isEmpty();
			case SarlPackage.SARL_ACTION__PRE_CONDITIONS_NAME:
				return PRE_CONDITIONS_NAME_EDEFAULT == null ? preConditionsName != null : !PRE_CONDITIONS_NAME_EDEFAULT.equals(preConditionsName);
			case SarlPackage.SARL_ACTION__POST_CONDITIONS:
				return postConditions != null && !postConditions.isEmpty();
			case SarlPackage.SARL_ACTION__POST_CONDITIONS_NAME:
				return POST_CONDITIONS_NAME_EDEFAULT == null ? postConditionsName != null : !POST_CONDITIONS_NAME_EDEFAULT.equals(postConditionsName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (preConditionsName: ");
		result.append(preConditionsName);
		result.append(", postConditionsName: ");
		result.append(postConditionsName);
		result.append(')');
		return result.toString();
	}

} //SarlActionImpl
