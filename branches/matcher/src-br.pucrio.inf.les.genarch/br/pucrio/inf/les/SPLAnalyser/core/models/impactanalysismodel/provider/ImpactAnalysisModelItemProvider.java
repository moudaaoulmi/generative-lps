/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.provider;


import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelFactory;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactAnalysisModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ImpactAnalysisModelItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpactAnalysisModelItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE);
			childrenFeatures.add(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE);
			childrenFeatures.add(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE);
			childrenFeatures.add(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE);
			childrenFeatures.add(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ImpactAnalysisModel.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ImpactAnalysisModel"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_ImpactAnalysisModel_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ImpactAnalysisModel.class)) {
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE:
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE:
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE:
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE:
			case ImpactanalysismodelPackage.IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__FEATURES_REFERENCE,
				 ImpactanalysismodelFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__MAPPINGS_REFERENCE,
				 ImpactanalysismodelFactory.eINSTANCE.createMapping()));

		newChildDescriptors.add
			(createChildParameter
				(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE,
				 ImpactanalysismodelFactory.eINSTANCE.createAsset()));

		newChildDescriptors.add
			(createChildParameter
				(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE,
				 ImpactanalysismodelFactory.eINSTANCE.createField()));

		newChildDescriptors.add
			(createChildParameter
				(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE,
				 ImpactanalysismodelFactory.eINSTANCE.createMethod()));

		newChildDescriptors.add
			(createChildParameter
				(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__ASSETS_REFERENCE,
				 ImpactanalysismodelFactory.eINSTANCE.createClass()));

		newChildDescriptors.add
			(createChildParameter
				(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__USE_CASES_REFERENCE,
				 ImpactanalysismodelFactory.eINSTANCE.createUseCase()));

		newChildDescriptors.add
			(createChildParameter
				(ImpactanalysismodelPackage.Literals.IMPACT_ANALYSIS_MODEL__CONSTRAINTS_REFERENCE,
				 ImpactanalysismodelFactory.eINSTANCE.createConstraint()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ImpactAnalysisModelEditPlugin.INSTANCE;
	}

}
