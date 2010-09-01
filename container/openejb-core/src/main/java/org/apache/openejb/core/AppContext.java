/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.openejb.core;

import org.apache.openejb.DeploymentInfo;
import org.apache.openejb.loader.SystemInstance;
import org.apache.openejb.loader.Options;

import javax.enterprise.inject.spi.BeanManager;
import javax.naming.Context;
import java.util.ArrayList;
import java.util.List;

/**
 * @version $Rev$ $Date$
*/
public class AppContext extends DeploymentContext {
    private final SystemInstance systemInstance;
    private final ClassLoader classLoader;
    private final Context globalJndiContext;
    private final Context appJndiContext;
    private final boolean standaloneModule;
    private BeanManager beanManager;

    // TODO perhaps to be deleted
    private final List<DeploymentInfo> deployments = new ArrayList<DeploymentInfo>();

    public AppContext(String id, SystemInstance systemInstance, ClassLoader classLoader, Context globalJndiContext, Context appJndiContext, boolean standaloneModule) {
        super(id, systemInstance.getOptions());
        this.classLoader = classLoader;
        this.systemInstance = systemInstance;
        this.globalJndiContext = globalJndiContext;
        this.appJndiContext = appJndiContext;
        this.standaloneModule = standaloneModule;
    }

    public BeanManager getBeanManager() {
        return beanManager;
    }

    /**
     * TODO: Ideally this would be a final field
     * @param beanManager
     */
    @Deprecated
    public void setBeanManager(BeanManager beanManager) {
        this.beanManager = beanManager;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public List<DeploymentInfo> getDeployments() {
        return deployments;
    }

    public SystemInstance getSystemInstance() {
        return systemInstance;
    }

    public Context getAppJndiContext() {
        return appJndiContext;
    }

    public Context getGlobalJndiContext() {
        return globalJndiContext;
    }

    public boolean isStandaloneModule() {
        return standaloneModule;
    }
}
