/*
 * Crafter Studio Web-content authoring solution
 * Copyright (C) 2007-2015 Crafter Software Corporation.
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
package org.craftercms.studio.api.v1.service.configuration;


import org.craftercms.studio.api.v1.to.DeploymentConfigTO;
import org.craftercms.studio.api.v1.to.DeploymentEndpointConfigTO;

public interface DeploymentEndpointConfig {

    public DeploymentEndpointConfigTO getDeploymentConfig(String site, String endpoint);

    public boolean isUpdated(String site);

    public boolean exists(String site);

    public DeploymentConfigTO getSiteDeploymentConfig(String site);
}
