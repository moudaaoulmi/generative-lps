/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.provider;


import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelFactory;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.DeltamodelPackage;
import br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities;
import br.pucrio.inf.les.SPLAnalyser.core.models.impactanalysismodel.ImpactanalysismodelFactory;


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
 * This is the item provider adapter for a {@link br.pucrio.inf.les.SPLAnalyser.core.models.deltamodel.RemovedEntities} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RemovedEntitiesItemProvider
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
	public RemovedEntitiesItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(DeltamodelPackage.Literals.REMOVED_ENTITIES__FEATURES);
			childrenFeatures.add(DeltamodelPackage.Literals.REMOVED_ENTITIES__ASSETS);
			childrenFeatures.add(DeltamodelPackage.Literals.REMOVED_ENTITIES__USE_CASES);
			childrenFeatures.add(DeltamodelPackage.Literals.REMOVED_ENTITIES__MAPPINGS);
			childrenFeatures.add(DeltamodelPackage.Literals.REMOVED_ENTITIES__ASSET_DEPENDENCIES);
			childrenFeatures.add(DeltamodelPackage.Literals.REMOVED_ENTITIES__FEATURE_CONSTRAINTS);
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
	 * This returns RemovedEntities.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RemovedEntities"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_RemovedEntities_type");
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

		switch (notification.getFeatureID(RemovedEntities.class)) {
			case DeltamodelPackage.REMOVED_ENTITIES__FEATURES:
			case DeltamodelPackage.REMOVED_ENTITIES__ASSETS:
			case DeltamodelPackage.REMOVED_ENTITIES__USE_CASES:
			case DeltamodelPackage.REMOVED_ENTITIES__MAPPINGS:
			case DeltamodelPackage.REMOVED_ENTITIES__ASSET_DEPENDENCIES:
			case DeltamodelPackage.REMOVED_ENTITIES__FEATURE_CONSTRAINTS:
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
				(DeltamodelPackage.Literals.REMOVED_ENTITIES__FEATURES,
				 ImpactanalysismodelFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(DeltamodelPackage.Literals.REMOVED_ENTITIES__ASSETS,
				 ImpactanalysismodelFactory.eINSTANCE.createAsset()));

		newChildDescriptors.add
			(createChildParameter
				(DeltamodelPackage.Literals.REMOVED_ENTITIES__ASSETS,
				 ImpactanalysismodelFactory.eINSTANCE.createField()));

		newChildDescriptors.add
			(createChildParameter
				(DeltamodelPackage.Literals.REMOVED_ENTITIES__ASSETS,
				 ImpactanalysismodelFactory.eINSTANCE.createMethod()));

		newChildDescriptors.add
			(createChildParameter
				(DeltamodelPackage.Literals.REMOVED_ENTITIES__ASSETS,
				 ImpactanalysismodelFactory.eINSTANCE.createClass()));

		newChildDescriptors.add
			(createChildParameter
				(DeltamodelPackage.Literals.REMOVED_ENTITIES__USE_CASES,
				 ImpactanalysismodelFactory.eINSTANCE.createUseCase()));

		newChildDescriptors.add
			(createChildParameter
				(DeltamodelPackage.Literals.REMOVED_ENTITIES__MAPPINGS,
				 ImpactanalysismodelFactory.eINSTANCE.createMapping()));

		newChildDescriptors.add
			(createChildParameter
				(DeltamodelPackage.Literals.REMOVED_ENTITIES__ASSET_DEPENDENCIES,
				 DeltamodelFactory.eINSTANCE.createDependencie()));

		newChildDescriptors.add
			(createChildParameter
				(DeltamodelPackage.Literals.REMOVED_ENTITIES__FEATURE_CONSTRAINTS,
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
		return DeltaModelEditPlugin.INSTANCE;
	}

}
