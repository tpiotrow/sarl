/**
 */
package io.sarl.lang.sarl.impl;

import io.sarl.lang.sarl.SarlBehaviorUnit;
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

import org.eclipse.xtend.core.xtend.impl.XtendMemberImplCustom;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlBehaviorUnitImpl#getName <em>Name</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlBehaviorUnitImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlBehaviorUnitImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlBehaviorUnitImpl#getPreConditions <em>Pre Conditions</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlBehaviorUnitImpl#getPreConditionsName <em>Pre Conditions Name</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlBehaviorUnitImpl#getPostConditions <em>Post Conditions</em>}</li>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlBehaviorUnitImpl#getPostConditionsName <em>Post Conditions Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SarlBehaviorUnitImpl extends XtendMemberImplCustom implements SarlBehaviorUnit
{
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected JvmParameterizedTypeReference name;

	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected XExpression guard;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression expression;

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
	protected SarlBehaviorUnitImpl()
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
		return SarlPackage.Literals.SARL_BEHAVIOR_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmParameterizedTypeReference getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(JvmParameterizedTypeReference newName, NotificationChain msgs)
	{
		JvmParameterizedTypeReference oldName = name;
		name = newName;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_BEHAVIOR_UNIT__NAME, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(JvmParameterizedTypeReference newName)
	{
		if (newName != name)
		{
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SarlPackage.SARL_BEHAVIOR_UNIT__NAME, null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SarlPackage.SARL_BEHAVIOR_UNIT__NAME, null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_BEHAVIOR_UNIT__NAME, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getGuard()
	{
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuard(XExpression newGuard, NotificationChain msgs)
	{
		XExpression oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_BEHAVIOR_UNIT__GUARD, oldGuard, newGuard);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(XExpression newGuard)
	{
		if (newGuard != guard)
		{
			NotificationChain msgs = null;
			if (guard != null)
				msgs = ((InternalEObject)guard).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SarlPackage.SARL_BEHAVIOR_UNIT__GUARD, null, msgs);
			if (newGuard != null)
				msgs = ((InternalEObject)newGuard).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SarlPackage.SARL_BEHAVIOR_UNIT__GUARD, null, msgs);
			msgs = basicSetGuard(newGuard, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_BEHAVIOR_UNIT__GUARD, newGuard, newGuard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XExpression getExpression()
	{
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExpression(XExpression newExpression, NotificationChain msgs)
	{
		XExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_BEHAVIOR_UNIT__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(XExpression newExpression)
	{
		if (newExpression != expression)
		{
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SarlPackage.SARL_BEHAVIOR_UNIT__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SarlPackage.SARL_BEHAVIOR_UNIT__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_BEHAVIOR_UNIT__EXPRESSION, newExpression, newExpression));
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
			preConditions = new EObjectContainmentEList<XExpression>(XExpression.class, this, SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS_NAME, oldPreConditionsName, preConditionsName));
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
			postConditions = new EObjectContainmentEList<XExpression>(XExpression.class, this, SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS_NAME, oldPostConditionsName, postConditionsName));
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
			case SarlPackage.SARL_BEHAVIOR_UNIT__NAME:
				return basicSetName(null, msgs);
			case SarlPackage.SARL_BEHAVIOR_UNIT__GUARD:
				return basicSetGuard(null, msgs);
			case SarlPackage.SARL_BEHAVIOR_UNIT__EXPRESSION:
				return basicSetExpression(null, msgs);
			case SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS:
				return ((InternalEList<?>)getPreConditions()).basicRemove(otherEnd, msgs);
			case SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS:
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
			case SarlPackage.SARL_BEHAVIOR_UNIT__NAME:
				return getName();
			case SarlPackage.SARL_BEHAVIOR_UNIT__GUARD:
				return getGuard();
			case SarlPackage.SARL_BEHAVIOR_UNIT__EXPRESSION:
				return getExpression();
			case SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS:
				return getPreConditions();
			case SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS_NAME:
				return getPreConditionsName();
			case SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS:
				return getPostConditions();
			case SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS_NAME:
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
			case SarlPackage.SARL_BEHAVIOR_UNIT__NAME:
				setName((JvmParameterizedTypeReference)newValue);
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__GUARD:
				setGuard((XExpression)newValue);
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__EXPRESSION:
				setExpression((XExpression)newValue);
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS:
				getPreConditions().clear();
				getPreConditions().addAll((Collection<? extends XExpression>)newValue);
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS_NAME:
				setPreConditionsName((String)newValue);
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS:
				getPostConditions().clear();
				getPostConditions().addAll((Collection<? extends XExpression>)newValue);
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS_NAME:
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
			case SarlPackage.SARL_BEHAVIOR_UNIT__NAME:
				setName((JvmParameterizedTypeReference)null);
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__GUARD:
				setGuard((XExpression)null);
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__EXPRESSION:
				setExpression((XExpression)null);
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS:
				getPreConditions().clear();
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS_NAME:
				setPreConditionsName(PRE_CONDITIONS_NAME_EDEFAULT);
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS:
				getPostConditions().clear();
				return;
			case SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS_NAME:
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
			case SarlPackage.SARL_BEHAVIOR_UNIT__NAME:
				return name != null;
			case SarlPackage.SARL_BEHAVIOR_UNIT__GUARD:
				return guard != null;
			case SarlPackage.SARL_BEHAVIOR_UNIT__EXPRESSION:
				return expression != null;
			case SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS:
				return preConditions != null && !preConditions.isEmpty();
			case SarlPackage.SARL_BEHAVIOR_UNIT__PRE_CONDITIONS_NAME:
				return PRE_CONDITIONS_NAME_EDEFAULT == null ? preConditionsName != null : !PRE_CONDITIONS_NAME_EDEFAULT.equals(preConditionsName);
			case SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS:
				return postConditions != null && !postConditions.isEmpty();
			case SarlPackage.SARL_BEHAVIOR_UNIT__POST_CONDITIONS_NAME:
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

} //SarlBehaviorUnitImpl
