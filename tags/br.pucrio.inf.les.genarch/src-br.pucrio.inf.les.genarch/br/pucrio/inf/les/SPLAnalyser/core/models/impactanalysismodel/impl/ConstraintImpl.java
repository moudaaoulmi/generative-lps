/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl;

import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Constraint;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Feature;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.Type;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ConstraintImpl#getConstraintExpression <em>Constraint Expression</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ConstraintImpl#getAssociatedFeatures <em>Associated Features</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ConstraintImpl#getConstraintType <em>Constraint Type</em>}</li>
 *   <li>{@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.impl.ConstraintImpl#getFeatureTarget <em>Feature Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends EObjectImpl implements Constraint {
	/**
	 * The default value of the '{@link #getConstraintExpression() <em>Constraint Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String CONSTRAINT_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraintExpression() <em>Constraint Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintExpression()
	 * @generated
	 * @ordered
	 */
	protected String constraintExpression = CONSTRAINT_EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAssociatedFeatures() <em>Associated Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> associatedFeatures;

	/**
	 * The default value of the '{@link #getConstraintType() <em>Constraint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintType()
	 * @generated
	 * @ordered
	 */
	protected static final Type CONSTRAINT_TYPE_EDEFAULT = Type.INCLUSION;

	/**
	 * The cached value of the '{@link #getConstraintType() <em>Constraint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintType()
	 * @generated
	 * @ordered
	 */
	protected Type constraintType = CONSTRAINT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatureTarget() <em>Feature Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureTarget()
	 * @generated
	 * @ordered
	 */
	protected Feature featureTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImpactanalysismodelPackage.Literals.CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstraintExpression() {
		return constraintExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintExpression(String newConstraintExpression) {
		String oldConstraintExpression = constraintExpression;
		constraintExpression = newConstraintExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactanalysismodelPackage.CONSTRAINT__CONSTRAINT_EXPRESSION, oldConstraintExpression, constraintExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getAssociatedFeatures() {
		if (associatedFeatures == null) {
			associatedFeatures = new EObjectResolvingEList<Feature>(Feature.class, this, ImpactanalysismodelPackage.CONSTRAINT__ASSOCIATED_FEATURES);
		}
		return associatedFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getConstraintType() {
		return constraintType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintType(Type newConstraintType) {
		Type oldConstraintType = constraintType;
		constraintType = newConstraintType == null ? CONSTRAINT_TYPE_EDEFAULT : newConstraintType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactanalysismodelPackage.CONSTRAINT__CONSTRAINT_TYPE, oldConstraintType, constraintType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature getFeatureTarget() {
		if (featureTarget != null && featureTarget.eIsProxy()) {
			InternalEObject oldFeatureTarget = (InternalEObject)featureTarget;
			featureTarget = (Feature)eResolveProxy(oldFeatureTarget);
			if (featureTarget != oldFeatureTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImpactanalysismodelPackage.CONSTRAINT__FEATURE_TARGET, oldFeatureTarget, featureTarget));
			}
		}
		return featureTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Feature basicGetFeatureTarget() {
		return featureTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureTarget(Feature newFeatureTarget) {
		Feature oldFeatureTarget = featureTarget;
		featureTarget = newFeatureTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpactanalysismodelPackage.CONSTRAINT__FEATURE_TARGET, oldFeatureTarget, featureTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpactanalysismodelPackage.CONSTRAINT__CONSTRAINT_EXPRESSION:
				return getConstraintExpression();
			case ImpactanalysismodelPackage.CONSTRAINT__ASSOCIATED_FEATURES:
				return getAssociatedFeatures();
			case ImpactanalysismodelPackage.CONSTRAINT__CONSTRAINT_TYPE:
				return getConstraintType();
			case ImpactanalysismodelPackage.CONSTRAINT__FEATURE_TARGET:
				if (resolve) return getFeatureTarget();
				return basicGetFeatureTarget();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpactanalysismodelPackage.CONSTRAINT__CONSTRAINT_EXPRESSION:
				setConstraintExpression((String)newValue);
				return;
			case ImpactanalysismodelPackage.CONSTRAINT__ASSOCIATED_FEATURES:
				getAssociatedFeatures().clear();
				getAssociatedFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case ImpactanalysismodelPackage.CONSTRAINT__CONSTRAINT_TYPE:
				setConstraintType((Type)newValue);
				return;
			case ImpactanalysismodelPackage.CONSTRAINT__FEATURE_TARGET:
				setFeatureTarget((Feature)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpactanalysismodelPackage.CONSTRAINT__CONSTRAINT_EXPRESSION:
				setConstraintExpression(CONSTRAINT_EXPRESSION_EDEFAULT);
				return;
			case ImpactanalysismodelPackage.CONSTRAINT__ASSOCIATED_FEATURES:
				getAssociatedFeatures().clear();
				return;
			case ImpactanalysismodelPackage.CONSTRAINT__CONSTRAINT_TYPE:
				setConstraintType(CONSTRAINT_TYPE_EDEFAULT);
				return;
			case ImpactanalysismodelPackage.CONSTRAINT__FEATURE_TARGET:
				setFeatureTarget((Feature)null);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpactanalysismodelPackage.CONSTRAINT__CONSTRAINT_EXPRESSION:
				return CONSTRAINT_EXPRESSION_EDEFAULT == null ? constraintExpression != null : !CONSTRAINT_EXPRESSION_EDEFAULT.equals(constraintExpression);
			case ImpactanalysismodelPackage.CONSTRAINT__ASSOCIATED_FEATURES:
				return associatedFeatures != null && !associatedFeatures.isEmpty();
			case ImpactanalysismodelPackage.CONSTRAINT__CONSTRAINT_TYPE:
				return constraintType != CONSTRAINT_TYPE_EDEFAULT;
			case ImpactanalysismodelPackage.CONSTRAINT__FEATURE_TARGET:
				return featureTarget != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ConstraintExpression: ");
		result.append(constraintExpression);
		result.append(", ConstraintType: ");
		result.append(constraintType);
		result.append(')');
		return result.toString();
	}

} //ConstraintImpl
