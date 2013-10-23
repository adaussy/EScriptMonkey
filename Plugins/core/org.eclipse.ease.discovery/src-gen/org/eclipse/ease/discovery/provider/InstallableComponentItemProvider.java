/**
 * 
 *   Copyright (c)  2012 CEA LIST.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *       CEA LIST - initial API and implementation
 *  
 */
package org.eclipse.ease.discovery.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.ease.discovery.Activator;
import org.eclipse.ease.discovery.DiscoveryPackage;
import org.eclipse.ease.discovery.InstallableComponent;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.ease.discovery.InstallableComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InstallableComponentItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource,
		ITableItemLabelProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstallableComponentItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
			addProviderPropertyDescriptor(object);
			addSitesURLSPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addLicensePropertyDescriptor(object);
			addSelectedPropertyDescriptor(object);
			addAvailablePropertyDescriptor(object);
			addInstalledPropertyDescriptor(object);
			addGroupsPropertyDescriptor(object);
			addImage32PropertyDescriptor(object);
			addIncubationPropertyDescriptor(object);
			addVisiblePropertyDescriptor(object);
			addHiddingFeatureIDPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_name_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Provider feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProviderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_provider_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_provider_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__PROVIDER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sites URLS feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSitesURLSPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_sitesURLS_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_sitesURLS_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__SITES_URLS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_description_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_description_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_id_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the License feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLicensePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_license_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_license_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__LICENSE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Selected feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSelectedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_selected_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_selected_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__SELECTED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Available feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAvailablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_available_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_available_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__AVAILABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Installed feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInstalledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_installed_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_installed_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__INSTALLED,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Groups feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGroupsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_groups_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_groups_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__GROUPS,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Image32 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImage32PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_image32_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_image32_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__IMAGE32,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Incubation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncubationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_incubation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_incubation_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__INCUBATION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Visible feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisiblePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_visible_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_visible_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__VISIBLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Hidding Feature ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addHiddingFeatureIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_InstallableComponent_hiddingFeatureID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_InstallableComponent_hiddingFeatureID_feature", "_UI_InstallableComponent_type"),
				 DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__HIDDING_FEATURE_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__OVERVIEW);
			childrenFeatures.add(DiscoveryPackage.Literals.INSTALLABLE_COMPONENT__MESSAGES);
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
	 * This returns InstallableComponent.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InstallableComponent"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((InstallableComponent)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_InstallableComponent_type") :
			getString("_UI_InstallableComponent_type") + " " + label;
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

		switch (notification.getFeatureID(InstallableComponent.class)) {
			case DiscoveryPackage.INSTALLABLE_COMPONENT__NAME:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__PROVIDER:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__SITES_URLS:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__DESCRIPTION:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__ID:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__LICENSE:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__SELECTED:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__AVAILABLE:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__INSTALLED:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__GROUPS:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__IMAGE32:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__INCUBATION:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__VISIBLE:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__HIDDING_FEATURE_ID:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DiscoveryPackage.INSTALLABLE_COMPONENT__OVERVIEW:
			case DiscoveryPackage.INSTALLABLE_COMPONENT__MESSAGES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Activator.INSTANCE;
	}

}
