/*
 * Copyright (c) 2014 Spotify AB.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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

package com.spotify.docker.client.messages;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public class Image {

  @JsonProperty("Created") private String created;
  @JsonProperty("Id") private String id;
  @JsonProperty("ParentId") private String parentId;
  @JsonProperty("RepoTags") private ImmutableList<String> repoTags;
  @JsonProperty("Size") private Long size;
  @JsonProperty("VirtualSize") private Long virtualSize;
  @JsonProperty("Labels") private ImmutableMap<String, String> labels;

  public String created() {
    return created;
  }

  public String id() {
    return id;
  }

  public String parentId() {
    return parentId;
  }

  public ImmutableList<String> repoTags() {
    return repoTags;
  }

  public Long size() {
    return size;
  }

  public Long virtualSize() {
    return virtualSize;
  }

  public Map<String, String> labels() {
    return labels;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Image that = (Image) o;

    return Objects.equal(this.created, that.created) &&
           Objects.equal(this.id, that.id) &&
           Objects.equal(this.parentId, that.parentId) &&
           Objects.equal(this.repoTags, that.repoTags) &&
           Objects.equal(this.size, that.size) &&
           Objects.equal(this.virtualSize, that.virtualSize) &&
           Objects.equal(this.labels, that.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(created, id, parentId, repoTags, size, virtualSize, labels);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("created", created)
        .add("id", id)
        .add("parentId", parentId)
        .add("repoTags", repoTags)
        .add("size", size)
        .add("virtualSize", virtualSize)
        .add("labels", labels)
        .toString();
  }
}
