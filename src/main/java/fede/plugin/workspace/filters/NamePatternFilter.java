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
 *
 * Copyright (C) 2006-2010 Adele Team/LIG/Grenoble University, France
 */
package fede.plugin.workspace.filters;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.core.resources.IResource;



/**
 * The NamePatternFilter selects the elements which
 * match the given string patterns.
 * <p>
 * The following characters have special meaning:
 *   ? => any character
 *   * => any string
 * </p>
 * 
 * @since 2.0
 */
public class NamePatternFilter extends ViewerFilter {
	private String[] fPatterns;
	private StringMatcher[] fMatchers;
	
	/**
	 * Return the currently configured StringMatchers.
	 */
	private StringMatcher[] getMatchers() {
		return fMatchers;
	}
	
	/**
	 * Gets the patterns for the receiver.
	 */
	public String[] getPatterns() {
		return fPatterns;
	}
	
	
	/* (non-Javadoc)
	 * Method declared on ViewerFilter.
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		String matchName= null;
		if (element instanceof INameable) {
			matchName= ((INameable) element).getName();
		} else if (element instanceof IAdaptable) {
			IAdaptable adaptable= (IAdaptable) element;
			INameable javaElement= (INameable)adaptable.getAdapter(INameable.class);
			if (javaElement != null)
				matchName= javaElement.getName();
			else {
				IResource resource= (IResource)adaptable.getAdapter(IResource.class);
				if (resource != null)
					matchName= resource.getName();
			}
		}
		if (matchName != null) {
			StringMatcher[] testMatchers= getMatchers();
			for (int i = 0; i < testMatchers.length; i++) {
				if (testMatchers[i].match(matchName))
					return false;
			}
			return true;
		}
		return true;
	}
	
	/**
	 * Sets the patterns to filter out for the receiver.
	 * <p>
	 * The following characters have special meaning:
	 *   ? => any character
	 *   * => any string
	 * </p>
	 */
	public void setPatterns(String[] newPatterns) {
		fPatterns = newPatterns;
		fMatchers = new StringMatcher[newPatterns.length];
		for (int i = 0; i < newPatterns.length; i++) {
			//Reset the matchers to prevent constructor overhead
			fMatchers[i]= new StringMatcher(newPatterns[i], true, false);
		}
	}
}
