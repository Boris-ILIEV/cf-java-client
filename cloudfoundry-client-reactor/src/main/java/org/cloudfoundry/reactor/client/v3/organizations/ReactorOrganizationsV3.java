/*
 * Copyright 2013-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.reactor.client.v3.organizations;

import org.cloudfoundry.client.v3.organizations.AssignOrganizationDefaultIsolationSegmentRequest;
import org.cloudfoundry.client.v3.organizations.AssignOrganizationDefaultIsolationSegmentResponse;
import org.cloudfoundry.client.v3.organizations.GetOrganizationDefaultIsolationSegmentRequest;
import org.cloudfoundry.client.v3.organizations.GetOrganizationDefaultIsolationSegmentResponse;
import org.cloudfoundry.client.v3.organizations.ListOrganizationsRequest;
import org.cloudfoundry.client.v3.organizations.ListOrganizationsResponse;
import org.cloudfoundry.client.v3.organizations.OrganizationsV3;
import org.cloudfoundry.reactor.ConnectionContext;
import org.cloudfoundry.reactor.TokenProvider;
import org.cloudfoundry.reactor.client.v3.AbstractClientV3Operations;
import reactor.core.publisher.Mono;

/**
 * The Reactor-based implementation of {@link OrganizationsV3}
 */
public final class ReactorOrganizationsV3 extends AbstractClientV3Operations implements OrganizationsV3 {

    /**
     * Creates an instance
     *
     * @param connectionContext the {@link ConnectionContext} to use when communicating with the server
     * @param root              the root URI of the server.  Typically something like {@code https://api.run.pivotal.io}.
     * @param tokenProvider     the {@link TokenProvider} to use when communicating with the server
     */
    public ReactorOrganizationsV3(ConnectionContext connectionContext, Mono<String> root, TokenProvider tokenProvider) {
        super(connectionContext, root, tokenProvider);
    }

    @Override
    public Mono<AssignOrganizationDefaultIsolationSegmentResponse> assignDefaultIsolationSegment(AssignOrganizationDefaultIsolationSegmentRequest request) {
        return patch(request, AssignOrganizationDefaultIsolationSegmentResponse.class, builder ->
            builder.pathSegment("v3", "organizations", request.getOrganizationId(), "relationships", "default_isolation_segment"))
            .checkpoint();
    }

    @Override
    public Mono<GetOrganizationDefaultIsolationSegmentResponse> getDefaultIsolationSegment(GetOrganizationDefaultIsolationSegmentRequest request) {
        return get(request, GetOrganizationDefaultIsolationSegmentResponse.class, builder ->
            builder.pathSegment("v3", "organizations", request.getOrganizationId(), "relationships", "default_isolation_segment"))
            .checkpoint();
    }

    @Override
    public Mono<ListOrganizationsResponse> list(ListOrganizationsRequest request) {
        return get(request, ListOrganizationsResponse.class, builder -> builder.pathSegment("v3", "organizations"))
            .checkpoint();
    }

}
