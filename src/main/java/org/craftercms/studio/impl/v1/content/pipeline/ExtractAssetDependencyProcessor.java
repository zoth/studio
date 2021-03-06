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
package org.craftercms.studio.impl.v1.content.pipeline;

import org.craftercms.studio.api.v1.constant.DmConstants;
import org.craftercms.studio.api.v1.content.pipeline.PipelineContent;
import org.craftercms.studio.api.v1.exception.ContentProcessException;
import org.craftercms.studio.api.v1.exception.ServiceException;
import org.craftercms.studio.api.v1.log.Logger;
import org.craftercms.studio.api.v1.log.LoggerFactory;
import org.craftercms.studio.api.v1.service.configuration.ServicesConfig;
import org.craftercms.studio.api.v1.service.dependency.DmDependencyService;
import org.craftercms.studio.api.v1.to.ResultTO;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.craftercms.studio.api.v1.constant.StudioConstants.FILE_SEPARATOR;

public class ExtractAssetDependencyProcessor extends PathMatchProcessor {

    private static final Logger logger = LoggerFactory.getLogger(ExtractAssetDependencyProcessor.class);

    public static final String NAME = "ExtractAssetDependencyProcessor";


    /**
     * default constructor
     */
    public ExtractAssetDependencyProcessor() {
        super(NAME);
    }

    /**
     * constructor that sets the process name
     *
     * @param name
     */
    public ExtractAssetDependencyProcessor(String name) {
        super(name);
    }

    public void process(PipelineContent content, ResultTO result) throws ContentProcessException {
        String site = content.getProperty(DmConstants.KEY_SITE);
        String folderPath = content.getProperty(DmConstants.KEY_FOLDER_PATH);
        String fileName = content.getProperty(DmConstants.KEY_FILE_NAME);
        String path = (folderPath.endsWith(FILE_SEPARATOR)) ? folderPath + fileName : folderPath + FILE_SEPARATOR + fileName;
        StringWriter sw = new StringWriter();
        boolean isCss = path.endsWith(DmConstants.CSS_PATTERN);
        boolean isJs = path.endsWith(DmConstants.JS_PATTERN);
        List<String> templatePatterns = servicesConfig.getRenderingTemplatePatterns(site);
        boolean isTemplate = false;
        for (String templatePattern : templatePatterns) {
            Pattern pattern = Pattern.compile(templatePattern);
            Matcher matcher = pattern.matcher(path);
            if (matcher.matches()) {
                isTemplate = true;
                break;
            }
        }
        try {
            if (isCss || isJs || isTemplate) {
                InputStream is = content.getContentStream();
                is.reset();
                int size = is.available();
                char[] theChars = new char[size];
                byte[] bytes    = new byte[size];

                is.read(bytes, 0, size);
                for (int i = 0; i < size;) {
                    theChars[i] = (char)(bytes[i++]&0xff);
                }

                StringBuffer assetContent = new StringBuffer(new String(theChars));
                Map<String, Set<String>> globalDeps = new HashMap<String, Set<String>>();
                if (isCss) {
                    dmDependencyService.extractDependenciesStyle(site, path, assetContent, globalDeps);
                } else if (isJs) {
                    dmDependencyService.extractDependenciesJavascript(site, path, assetContent, globalDeps);
                } else if (isTemplate) {
                    dmDependencyService.extractDependenciesTemplate(site, path, assetContent, globalDeps);
                }
                content.getContentStream().reset();
            }
        } catch (ServiceException e) {
            throw new ContentProcessException(e);
        } catch (IOException e) {
            throw new ContentProcessException(e);
        }
    }

    protected ServicesConfig servicesConfig;
    protected DmDependencyService dmDependencyService;

    public ServicesConfig getServicesConfig() { return servicesConfig; }
    public void setServicesConfig(ServicesConfig servicesConfig) { this.servicesConfig = servicesConfig; }

    public DmDependencyService getDmDependencyService() { return dmDependencyService; }
    public void setDmDependencyService(DmDependencyService dmDependencyService) { this.dmDependencyService = dmDependencyService; }
}
