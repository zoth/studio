/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2016 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.craftercms.studio.api.v1.to;

import java.io.Serializable;

/**
 * holds the configuration for copy dependency
 * 
 * @author Shankar Krishnan
 *
 */
public class CopyDependencyConfigTO implements Serializable {

    private static final long serialVersionUID = 3853790978445959968L;
    protected String pattern;
	
	protected String target;

	
	public CopyDependencyConfigTO(String pattern, String target) {
		super();
		this.pattern = pattern;
		this.target = target;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
}
