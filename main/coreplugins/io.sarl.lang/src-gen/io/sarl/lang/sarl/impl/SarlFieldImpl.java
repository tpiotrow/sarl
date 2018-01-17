/**
 */
package io.sarl.lang.sarl.impl;

import io.sarl.lang.sarl.InvariantConstraint;
import io.sarl.lang.sarl.SarlField;
import io.sarl.lang.sarl.SarlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtend.core.xtend.impl.XtendFieldImplCustom;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link io.sarl.lang.sarl.impl.SarlFieldImpl#getInvariant <em>Invariant</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SarlFieldImpl extends XtendFieldImplCustom implements SarlField
{
	/**
	 * The cached value of the '{@link #getInvariant() <em>Invariant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariant()
	 * @generated
	 * @ordered
	 */
	protected InvariantConstraint invariant;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SarlFieldImpl()
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
		return SarlPackage.Literals.SARL_FIELD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantConstraint getInvariant()
	{
		if (invariant != null && invariant.eIsProxy())
		{
			InternalEObject oldInvariant = (InternalEObject)invariant;
			invariant = (InvariantConstraint)eResolveProxy(oldInvariant);
			if (invariant != oldInvariant)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SarlPackage.SARL_FIELD__INVARIANT, oldInvariant, invariant));
			}
		}
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantConstraint basicGetInvariant()
	{
		return invariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvariant(InvariantConstraint newInvariant)
	{
		InvariantConstraint oldInvariant = invariant;
		invariant = newInvariant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SarlPackage.SARL_FIELD__INVARIANT, oldInvariant, invariant));
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
			case SarlPackage.SARL_FIELD__INVARIANT:
				if (resolve) return getInvariant();
				return basicGetInvariant();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case SarlPackage.SARL_FIELD__INVARIANT:
				setInvariant((InvariantConstraint)newValue);
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
			case SarlPackage.SARL_FIELD__INVARIANT:
				setInvariant((InvariantConstraint)null);
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
			case SarlPackage.SARL_FIELD__INVARIANT:
				return invariant != null;
		}
		return super.eIsSet(featureID);
	}

} //SarlFieldImpl
