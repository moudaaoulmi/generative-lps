package br.pucrio.inf.les.genarch.models;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * This class is used by editor panes as a roots.
 * @author Michal Antkiewicz <mantkiew@swen.uwaterloo.ca>
 */
public class ProxyItemProvider 
extends ItemProviderAdapter 
implements IStructuredItemContentProvider,
ITreeItemContentProvider,
IItemLabelProvider {

	EObject child;
	EStructuralFeature feature;
	/**
	 * Michal:
	 * @param adapterFactory
	 * @param parent - element containing the child
	 * @param child - element to be displayed in the view
	 */
	public ProxyItemProvider(AdapterFactory adapterFactory,EObject parent,EObject child) {
		super(adapterFactory);
		parent.eAdapters().add(this);
		this.child = child;
		this.feature = child.eContainingFeature();
	}
	public EObject getChild() {
		return child;
	}
	protected Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(feature);
		}
		return childrenFeatures;
	}
	protected void collectNewChildDescriptors(Collection newChildDescriptors,
			Object object) {
		newChildDescriptors = Collections.EMPTY_LIST;
	}
	public void notifyChanged(Notification msg) {
		//fireNotifyChanged(new NotificationWrapper(this, msg));		
	}
	public Collection getChildren(Object object) {
		return Collections.singleton(child);
	}
	public Object getParent(Object object) {
		return target;
	}
	public String getText(Object object) {
		return ((ItemProviderAdapter)(adapterFactory.adapt(child, IItemLabelProvider.class))).getText(object);
	}
	public Object getImage(Object object) {
		return ((ItemProviderAdapter)(adapterFactory.adapt(child, IItemLabelProvider.class))).getImage(object);

	}
}
