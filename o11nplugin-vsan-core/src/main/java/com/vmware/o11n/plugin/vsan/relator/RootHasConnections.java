/* ************************************************************************
 * Copyright 2020 VMware, Inc.  All rights reserved. -- VMware Confidential
 * ************************************************************************/

package com.vmware.o11n.plugin.vsan.relator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vmware.o11n.plugin.vsan.config.ConnectionRepository;
import com.vmware.o11n.plugin.vsan.model.Connection;
import com.vmware.o11n.sdk.modeldriven.ObjectRelater;
import com.vmware.o11n.sdk.modeldriven.PluginContext;
import com.vmware.o11n.sdk.modeldriven.Sid;

public class RootHasConnections implements ObjectRelater<Connection> {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    public List<Connection> findChildren(PluginContext ctx, String relation, String parentType, Sid parentId) {
        return new ArrayList<>(connectionRepository.findAll());
    }

}