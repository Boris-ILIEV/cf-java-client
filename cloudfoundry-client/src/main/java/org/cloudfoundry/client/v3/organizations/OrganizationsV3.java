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

package org.cloudfoundry.client.v3.organizations;

import reactor.core.publisher.Mono;

/**
 * Main entry point to the Cloud Foundry Organizations V3 Client API
 */
public interface OrganizationsV3 {

    /**
     * Makes the <a href="http://v3-apidocs.cloudfoundry.org/version/release-candidate/index.html#assign-default-isolation-segment">Assign Default Isolation Segment</a> request
     *
     * @param request the Assign Default Isolation Segment request
     * @return the response from the Assign Default Isolation Segment request
     */
    Mono<AssignOrganizationDefaultIsolationSegmentResponse> assignDefaultIsolationSegment(AssignOrganizationDefaultIsolationSegmentRequest request);

    /**
     * Makes the <a href="http://v3-apidocs.cloudfoundry.org/version/release-candidate/index.html#get-default-isolation-segment">Get Default Isolation Segment</a> request
     *
     * @param request the Get Default Isolation Segment request
     * @return the response from the Get Default Isolation Segment request
     */
    Mono<GetOrganizationDefaultIsolationSegmentResponse> getDefaultIsolationSegment(GetOrganizationDefaultIsolationSegmentRequest request);

    /**
     * Makes the <a href="http://v3-apidocs.cloudfoundry.org/version/release-candidate/index.html#list-organizations">List Organizations</a> request
     *
     * @param request the List Organizations request
     * @return the response from the List Organizations request
     */
    Mono<ListOrganizationsResponse> list(ListOrganizationsRequest request);

}
