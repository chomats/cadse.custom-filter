/* 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
/*******************************************************************************
 * Copyright (c) 2000, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package fede.plugin.workspace.filters;

import org.eclipse.osgi.util.NLS;


public final class FilterMessages extends NLS {

	private static final String BUNDLE_NAME= "fede.plugin.workspace.filters.FilterMessages";//$NON-NLS-1$

	private FilterMessages() {
		// Do not instantiate
	}

	public static String CustomFiltersDialog_title;
	public static String CustomFiltersDialog_patternInfo;
	public static String CustomFiltersDialog_enableUserDefinedPattern;
	public static String CustomFiltersDialog_filterList_label;
	public static String CustomFiltersDialog_description_label;
	public static String CustomFiltersDialog_SelectAllButton_label;
	public static String CustomFiltersDialog_DeselectAllButton_label;
	public static String OpenCustomFiltersDialogAction_text;
	public static String FilterDescriptor_filterDescriptionCreationError_message;
	public static String FilterDescriptor_filterCreationError_title;
	public static String FilterDescriptor_filterCreationError_message;

	static {
		NLS.initializeMessages(BUNDLE_NAME, FilterMessages.class);
	}
}