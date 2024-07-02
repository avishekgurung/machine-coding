package org.avishek.system;

import java.util.*;

public class Repository {
    private Map<Long, Tag> tags;
    private Map<Long, Resource> resources;
    private Map<Long, List<Long>> tagToResources;

    private Map<Long, Long> tagUsage;


    Repository() {
        tags = new HashMap<>();
        resources = new HashMap<>();
        tagToResources = new HashMap<>();
        tagUsage = new HashMap();
    }

    public boolean addTag(Tag tag) {
        tags.put(tag.getId(), tag);
        tagUsage.put(tag.getId(), 0L);
        tagToResources.put(tag.getId(), new ArrayList<Long>());
        return true;
    }

    public boolean addResource(Resource resource) {
        resources.put(resource.getId(), resource);
        tagResource(resource);
        return true;
    }

    private void tagResource(Resource resource) {
        List<Long> tagIds = resource.getTags();
        List<Tag> tagList = new ArrayList<>();
        for(Long tagId : tagIds) {
            tagList.add(tags.get(tagId));
        }
        tagResource(resource, tagList);
    }

    public boolean tagResource(Resource resource, List<Tag> tags) {
        for(Tag tag : tags) {
            Long usage = tagUsage.get(tag.getId()) + 1;
            tagUsage.put(tag.getId(), usage);
            tagToResources.get(tag.getId()).add(resource.getId());
        }
        return true;
    }

    public LinkedHashMap<Tag, Long> getTopTags(int k) {
        PriorityQueue<Node> heap = new PriorityQueue<>(new NodeComparator());
        for(Long tagId : tagUsage.keySet()) {
            Long count = tagUsage.get(tagId);
            Node node = new Node(tagId, count);
            heap.add(node);
        }


        LinkedHashMap<Tag, Long> result = new LinkedHashMap<>();
        List<Node> aux = new ArrayList<>();
        while(k !=0 && !heap.isEmpty()) {
            Node node = heap.remove();
            aux.add(node);
            k--;
        }

        for(Node node : aux) {
            result.put(tags.get(node.getId()), node.getCount());
            heap.add(node);
        }
        return result;
    }

    public List<Resource> getResourceForTag(Long tagId) {
        List<Long> resourceIds = tagToResources.get(tagId);
        List<Resource> resourceList = new ArrayList<>();
        for(Long resourceId : resourceIds) {
            resourceList.add(resources.get(resourceId));
        }
        return resourceList;
    }

}
